/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import businessMethod.SysUserFacadeRemote;
import entity.SysUser;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SysUserBean;

/**
 *
 * @author meknock
 */
public class SystemUsersServlet extends HttpServlet {

    @EJB
    private SysUserFacadeRemote systemUserService;
    SysUser systemUser = new SysUser();

    public void getAllSysUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String loggedInUserName = request.getRemoteUser();
            request.setAttribute("loggedInUserName", loggedInUserName);

            List<SysUser> allSysUsers = systemUserService.findAll();
            request.setAttribute("allSysUsers", allSysUsers);
            RequestDispatcher view = request.getRequestDispatcher("/registerSystemUsers.jsp");
            view.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String encryptPassword(String password) {
        String encryptedPassword = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            encryptedPassword = bigInt.toString(16);
        } catch (Exception e) {
        }
        return encryptedPassword;
    }

    public void saveSystemUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getParameter("userName") != null) {
                SysUser sysUser = systemUserService.getUserByUserName(request.getParameter("userName"));
                if (sysUser != null) {
                    List<SysUser> allSysUsers = systemUserService.findAll();
                    request.setAttribute("allSysUsers", allSysUsers);

                    request.setAttribute("userNameValidation", "User Name Already Occupied. Please try Another.");
                    RequestDispatcher view = request.getRequestDispatcher("/registerSystemUsers.jsp");
                    view.forward(request, response);
                } else {
                    systemUser.setUserName(request.getParameter("userName"));
                    systemUser.setPassword(encryptPassword(request.getParameter("userPassword")));
                    systemUser.setFullName(request.getParameter("sysUserFullName"));
                    systemUser.setSex(request.getParameter("sysUserSex"));
                    systemUser.setDepartmentName(request.getParameter("deptName"));
                    systemUser.setPosition(request.getParameter("userPosition"));
                    systemUser.setStatus("active");
                    systemUser.setDescription(request.getParameter("sysUserDescription"));
                    systemUserService.create(systemUser);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populateSysUser(HttpServletRequest request, HttpServletResponse response, int userId) {
        try {
            SysUserBean sysUserBean = new SysUserBean();
            sysUserBean.setUserId(userId);
            sysUserBean.setFullName(systemUserService.find(userId).getFullName());
            sysUserBean.setSex(systemUserService.find(userId).getSex());
            sysUserBean.setDepartmentName(systemUserService.find(userId).getDepartmentName());
            sysUserBean.setPosition(systemUserService.find(userId).getPosition());
            sysUserBean.setDescription(systemUserService.find(userId).getDescription());
            sysUserBean.setUserName(systemUserService.find(userId).getUserName());
            sysUserBean.setPassword(systemUserService.find(userId).getPassword());
            request.setAttribute("sysUserBean", sysUserBean);
            RequestDispatcher view = request.getRequestDispatcher("/registerSystemUsers.jsp");
            view.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSysUser(HttpServletRequest request) {
        systemUser.setUserId(Integer.valueOf(request.getParameter("sysUserId")));
        systemUser.setUserName(request.getParameter("userName"));
        systemUser.setPassword(encryptPassword(request.getParameter("userPassword")));
        systemUser.setFullName(request.getParameter("sysUserFullName"));
        systemUser.setSex(request.getParameter("sysUserSex"));
        systemUser.setDepartmentName(request.getParameter("deptName"));
        systemUser.setPosition(request.getParameter("userPosition"));
        systemUser.setStatus("active");
        systemUser.setDescription(request.getParameter("sysUserDescription"));
        systemUserService.edit(systemUser);
    }

    public void deleteSysUser(int sysUserId) {
        try {
            systemUserService.remove(systemUserService.find(sysUserId));
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
        String actionType = request.getParameter("value");
        String operation = "";
        String sysUserId = "";
        if (actionType != null) {
            operation = actionType.split("\\.")[0];
            sysUserId = actionType.substring(7);
        }
        switch (operation) {
            case "update":
                populateSysUser(request, response, Integer.parseInt(sysUserId));
                break;
            case "delete":
                deleteSysUser(Integer.parseInt(sysUserId));
                break;
        }
        getAllSysUsers(request, response);
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
                saveSystemUser(request, response);
                getAllSysUsers(request, response);
                break;
            case "Update":
                updateSysUser(request);
                getAllSysUsers(request, response);
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
