/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import businessMethod.CheckinOutFacadeRemote;
import businessMethod.VisitorFacadeRemote;
import businessMethod.AppointmentFacadeRemote;
import businessMethod.SysUserFacadeRemote;
import entity.Appointment;
import entity.SysUser;
import entity.Visitor;
import entity.VisitorAppointment;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AppointmentBean;
import model.VisitorBean;

/**
 *
 * @author meknock
 */
public class AppointmentServlet extends HttpServlet {

    @EJB
    private VisitorFacadeRemote visitorService;
    Visitor visitor = new Visitor();

    @EJB
    private SysUserFacadeRemote systemUserService;
    SysUser systemUser = new SysUser();

    @EJB
    private AppointmentFacadeRemote appointmentService;
    Appointment appointment = new Appointment();

    @EJB
    private CheckinOutFacadeRemote checkInService;

    public void saveAppointment(HttpServletRequest request) {
        try {
            appointment.setInviterId(systemUserService.getUserByUserName(request.getRemoteUser()));
            appointment.setVisitorId(visitorService.find(Integer.parseInt(request.getParameter("visitorId"))));
            appointment.setAppDate(request.getParameter("appointmentDate"));
            appointment.setAppTime(request.getParameter("appointmentTime"));
            appointment.setRemark(request.getParameter("appointmentRemark"));
            appointment.setStatus("ACTIVE");
            appointmentService.create(appointment);
        } catch (Exception e) {
        }
    }

    public void updateAppointment(HttpServletRequest request) {
        try {
            appointment.setInviterId(systemUserService.getUserByUserName(request.getRemoteUser()));
            appointment.setVisitorId(visitorService.find(Integer.parseInt(request.getParameter("visitorId"))));
            appointment.setAppId(Integer.valueOf(request.getParameter("appId")));
            appointment.setAppDate(request.getParameter("appointmentDate"));
            appointment.setAppTime(request.getParameter("appointmentTime"));
            appointment.setRemark(request.getParameter("appointmentRemark"));
            appointment.setStatus("ACTIVE");
            appointmentService.edit(appointment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int appId) {
        try {
            appointmentService.remove(appointmentService.find(appId));
        } catch (Exception e) {
        }
    }

    List<Visitor> allVisitors;

    public void getAllAppointments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String loggedInUserName = request.getRemoteUser();
            request.setAttribute("loggedInUserName", loggedInUserName);
            
            allVisitors = visitorService.findAll();
            request.setAttribute("allVisistors", allVisitors);

            List<Appointment> allAppointments = appointmentService.findAll();
            List<VisitorAppointment> allPendingAppointment = checkInService.getPendingApp();
            request.setAttribute("allAppointments", allAppointments);
            RequestDispatcher view = request.getRequestDispatcher("/reserveAnAppointment.jsp");
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    VisitorBean visitorBean = new VisitorBean();

    public void selectVisitor(HttpServletRequest request, HttpServletResponse response, int visitorId) {
        try {
            visitorBean.setVisitorId(visitorId);
            request.setAttribute("visitor", visitorBean);
            RequestDispatcher view = request.getRequestDispatcher("/reserveAnAppointment.jsp");
            view.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populateAppointments(HttpServletRequest request, HttpServletResponse response, int appointmentId) {
        try {
            AppointmentBean appointmentBean = new AppointmentBean();

            visitorBean.setVisitorId(appointmentService.find(appointmentId).getVisitorId().getVisitorId());
            request.setAttribute("visitor", visitorBean);
            //appointmentBean.setVisitorId(appointmentService.find(appointmentId).getVisitorId().getVisitorId().toString());      
            appointmentBean.setAppId(appointmentId);
            appointmentBean.setAppDate(appointmentService.find(appointmentId).getAppDate());
            appointmentBean.setAppTime(appointmentService.find(appointmentId).getAppTime());
            appointmentBean.setStatus(appointmentService.find(appointmentId).getStatus());
            appointmentBean.setRemark(appointmentService.find(appointmentId).getRemark());
            request.setAttribute("appointmentBean", appointmentBean);
            RequestDispatcher view = request.getRequestDispatcher("/reserveAnAppointment.jsp");
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
                    selectVisitor(request, response, Integer.parseInt(appointmentId));
                    break;
                case "update":
                    populateAppointments(request, response, Integer.parseInt(appointmentId));
                    break;
                case "delete":
                    deleteAppointment(Integer.parseInt(appointmentId));
                    break;
            }
            getAllAppointments(request, response);
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
                saveAppointment(request);
                getAllAppointments(request, response);
                break;
            case "Update":
                updateAppointment(request);
                getAllAppointments(request, response);
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
