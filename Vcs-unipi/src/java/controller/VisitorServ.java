/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import businessMethod.VisitorFacadeRemote;
import entity.Visitor;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.VisitorBean;

/**
 *
 * @author meknock
 */
public class VisitorServ extends HttpServlet {

    @EJB
    private VisitorFacadeRemote visitorService;
    Visitor visitor = new Visitor();

    public void saveVisitor(HttpServletRequest request) {
        visitor.setVisitorName(request.getParameter("visitorName"));
        visitor.setVisitorSex(request.getParameter("visitorSex"));
        visitor.setVisitorAge(request.getParameter("visitorAge"));
        visitor.setDescription(request.getParameter("visitorDescription"));
        visitorService.create(visitor);
    }

    public void getAllVisitors(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String loggedInUserName = request.getRemoteUser();
            request.setAttribute("loggedInUserName", loggedInUserName);
            
            List<Visitor> allVisitors = visitorService.findAll();
            request.setAttribute("allVisistors", allVisitors);
            RequestDispatcher view = request.getRequestDispatcher("/registerVisitor.jsp");
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void populateVisitor(HttpServletRequest request, HttpServletResponse response, int visitorId) {
        try {
            VisitorBean visitorBean = new VisitorBean();
            visitorBean.setVisitorId(visitorId);
            visitorBean.setVisitorName(visitorService.find(visitorId).getVisitorName());
            visitorBean.setVisitorSex(visitorService.find(visitorId).getVisitorSex());
            visitorBean.setVisitorAge(visitorService.find(visitorId).getVisitorAge());
            visitorBean.setVisitorDesc(visitorService.find(visitorId).getDescription());
            request.setAttribute("visitor", visitorBean);
            RequestDispatcher view = request.getRequestDispatcher("/registerVisitor.jsp");
            view.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateVisitor(HttpServletRequest request) {
        visitorService.edit(new Visitor(
                Integer.valueOf(request.getParameter("visitorId")),
                request.getParameter("visitorName"),
                request.getParameter("visitorSex"),
                request.getParameter("visitorAge"),
                request.getParameter("visitorDescription")
        ));
    }

    public void deleteVisitor(int visitorId) {
        try {
            visitorService.remove(visitorService.find(visitorId));
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
            String visitorId = "";
            if (actionType != null) {
                operation = actionType.split("\\.")[0];
                visitorId = actionType.substring(7);
            }
            switch (operation) {
                case "update":
                    populateVisitor(request, response, Integer.parseInt(visitorId));
                    break;
                case "delete":
                    deleteVisitor(Integer.parseInt(visitorId));
                    break;
            }
            getAllVisitors(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
                saveVisitor(request);
                getAllVisitors(request, response);
                break;
            case "Update":
                updateVisitor(request);
                getAllVisitors(request, response);
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
