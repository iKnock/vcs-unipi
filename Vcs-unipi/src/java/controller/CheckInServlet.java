/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import businessMethod.AppointmentFacadeRemote;
import businessMethod.CheckinOutFacadeRemote;
import entity.CheckinOut;
import entity.VisitorAppointment;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CheckInBean;
import model.VisitorAppBean;

/**
 *
 * @author meknock
 */
public class CheckInServlet extends HttpServlet {

    @EJB
    private AppointmentFacadeRemote appointmentService;

    @EJB
    private CheckinOutFacadeRemote checkInService;

    CheckinOut checkIn = new CheckinOut();

    public void saveCheckIn(HttpServletRequest request) throws ServletException, IOException {
        try {
            checkIn.setAppointmentId(appointmentService.find(Integer.valueOf(request.getParameter("appId"))));
            checkIn.setStatus(request.getParameter("checkInStatus"));
            checkIn.setMemo(request.getParameter("checkInMemo"));
            //make the two following two operation atomic. i.e if one not successed role back which are save check in user and update status of appointment
            checkInService.atomicCheckIn(checkIn, appointmentService.find(Integer.valueOf(request.getParameter("appId"))).getAppId(), "OCCURED");
        } catch (Exception e) {
        }
    }

    public void updateCheckIn(HttpServletRequest request) {
        try {
            checkIn.setCheckInId(Integer.valueOf(request.getParameter("checkInId")));
            checkIn.setAppointmentId(appointmentService.find(Integer.valueOf(request.getParameter("appId"))));
            checkIn.setStatus(request.getParameter("checkInStatus"));
            checkIn.setMemo(request.getParameter("checkInMemo"));
            checkInService.edit(checkIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete row from check In table by checkIn Id
     *
     * @param request
     * @param checkInId
     */
    public void deleteCheckIn(HttpServletRequest request, int checkInId) {
        try {            
            checkInService.atomicRemoveCheckIn(checkInService.find(checkInId), checkInService.find(checkInId).getAppointmentId().getAppId(), "ACTIVE");
            
            //checkInService.remove(checkInService.find(checkInId));
            //checkInService.updateAppointmentStatus(appointmentService.find(Integer.valueOf(request.getParameter("appId"))).getAppId(), "ACTIVE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPendingAppointments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<VisitorAppointment> allPendingAppointment = checkInService.getPendingApp();
            request.setAttribute("pendingAppointments", allPendingAppointment);
            RequestDispatcher view = request.getRequestDispatcher("/manageCheckIn.jsp");
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getCheckedInUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String loggedInUserName = request.getRemoteUser();
            request.setAttribute("loggedInUserName", loggedInUserName);

            List<VisitorAppointment> allPendingAppointment = checkInService.getPendingApp();
            request.setAttribute("pendingAppointments", allPendingAppointment);

            List<CheckinOut> allCheckIn = checkInService.findAll();
            request.setAttribute("allCheckIns", allCheckIn);
            RequestDispatcher view = request.getRequestDispatcher("/manageCheckIn.jsp");
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    VisitorAppBean visitorAppBean = new VisitorAppBean();

    public void selectAppointment(HttpServletRequest request, HttpServletResponse response, int appointmentId) {
        try {
            visitorAppBean.setAppointmentId(appointmentId);
            request.setAttribute("visitorAppBean", visitorAppBean);
            RequestDispatcher view = request.getRequestDispatcher("/manageCheckIn.jsp");
            view.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populateCheckIn(HttpServletRequest request, HttpServletResponse response, int checkInId) {
        try {
            CheckInBean checkInBean = new CheckInBean();

            visitorAppBean.setAppointmentId(checkInService.find(checkInId).getAppointmentId().getAppId());
            request.setAttribute("visitorAppBean", visitorAppBean);

            checkInBean.setCheckInId(checkInId);
            checkInBean.setCheckInStatus(checkInService.find(checkInId).getStatus());
            checkInBean.setCheckInMemo(checkInService.find(checkInId).getMemo());
            request.setAttribute("checkInBean", checkInBean);
            RequestDispatcher view = request.getRequestDispatcher("/manageCheckIn.jsp");
            view.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String actionType = request.getParameter("value");
            String operation = "";
            String appointmentId = "";
            if (actionType != null) {
                operation = actionType.split("\\.")[0];
                appointmentId = actionType.substring(7);
            }
            switch (operation) {
                case "select":
                    selectAppointment(request, response, Integer.parseInt(appointmentId));
                    break;
                case "chkout":
                    populateCheckIn(request, response, Integer.parseInt(appointmentId));
                    break;
                case "update":
                    populateCheckIn(request, response, Integer.parseInt(appointmentId));
                    break;
                case "delete":
                    deleteCheckIn(request, Integer.parseInt(appointmentId));
                    break;
            }
            getCheckedInUsers(request, response);
        } catch (Exception e) {
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String btnActionType = request.getParameter("btnAction");
        switch (btnActionType) {
            case "Save":
                saveCheckIn(request);
                getCheckedInUsers(request, response);
                break;
            case "Update":
                updateCheckIn(request);
                getCheckedInUsers(request, response);
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
