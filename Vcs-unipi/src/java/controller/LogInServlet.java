/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import businessMethod.SysUserFacadeRemote;
import entity.SysUser;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserBean;

/**
 *
 * @author meknock
 */
public class LogInServlet extends HttpServlet {

    @EJB
    private SysUserFacadeRemote loginService;
    SysUser sysUser = new SysUser();

    public void getUserAuth(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //List<Visitor> allVisitors = visitor.findAll();
            String loggedInUserName = request.getRemoteUser();
            request.setAttribute("loggedInUserName", loggedInUserName);
            RequestDispatcher view = request.getRequestDispatcher("/logIn.jsp");            
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void authenticateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userName = request.getParameter("j_username");
            String password = request.getParameter("j_password");
            List<SysUser> user = loginService.authenticateUser(userName, password);
            if (user != null) {
                UserBean userBean = new UserBean(user.get(0).getUserId(),
                        user.get(0).getFullName(),
                        user.get(0).getSex(),
                        user.get(0).getDepartmentName(),
                        user.get(0).getDescription(),
                        user.get(0).getPosition(),
                        user.get(0).getStatus(),
                        user.get(0).getUserName());
                HttpSession userSession = request.getSession();
                userSession.setAttribute("userSession", userBean);
                System.out.println("Login Success= " + user.get(0).getFullName());
            }
        } catch (Exception e) {
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
        getUserAuth(request, response);
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
        authenticateUser(request, response);
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
