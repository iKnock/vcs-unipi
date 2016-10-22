<%-- 
    Document   : registerSystemUsers
    Created on : Dec 12, 2015, 1:43:33 PM
    Author     : meknock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VCSUnipi</title>
    </head>
    <body style="background-color: #b2cecf;">
        <div>
            <div style="border: 1px black solid; border-radius: 12px; background-color: #b2cfc2;">
                <table align="center">
                    <tr>
                        <th><a href="/Vcs-unipi/HomeServlet"><input style="margin-top: 20px;" type="submit" value="Home"></a></th>
                        <th><a href="/Vcs-unipi/SystemUsersServlet"><input style="margin-top: 20px;" type="submit" value="Register System User"></a></th>
                        <th><a href="/Vcs-unipi/VisitorServ"><input style="margin-top: 20px;" type="submit" value="Register visitor"></a></th>
                        <th><a href="/Vcs-unipi/AppointmentServlet"><input style="margin-top: 20px;" type="submit" value="Reserve An Appointment"></a></th>
                        <th><a href="/Vcs-unipi/CheckInServlet"><input style="margin-top: 20px;" type="submit" value="Manage Check-In"></a></th>
                        <th><br/></th>      
                        <th><br/></th>      
                        <th>Logged In As: ${loggedInUserName}</th>
                        <th><br/></th>      
                        <th><br/></th>      
                        <th><a href="/Vcs-unipi/LogOutServlet">Log Out</a></th>
                    </tr>
                </table>
                <input type="hidden" name="loggedInUserId">
            </div>
            <div style="margin-top: 20px; margin-bottom: 20px; margin-left: 400px; margin-right: 400px;">
                <div style="margin-left: 150px; margin-right: 200px;">
                    <h3 style="color: #A9094D">Register System Users</h3>
                </div>
                <div>
                    <td><hr/></td>                    
                </div>
                <form method="POST" action="SystemUsersServlet">
                    <table align="center" style="background-color: #83b0b2; border: 1px solid transparent; border-radius: 12px;">                                                    
                        <tr>
                            <td><hr/></td>
                            <td><hr/></td>
                            <th><hr/></th>                    
                        </tr>
                        <input type="hidden" name="sysUserId" value="${sysUserBean.userId}">
                        <tr>
                            <th>Full Name:</th>
                            <td><input style="margin: 3px" type="text" name="sysUserFullName" value="${sysUserBean.fullName}" size="20"></td>
                        </tr>
                        <tr> 
                            <th>Sex:</th>
                            <td>
                                <input style="margin: 3px" type="text" name="sysUserSex" list="cmbSysUserSex" value="${sysUserBean.sex}" size="20">
                                <datalist id="cmbSysUserSex">
                                    <option>Male</option>
                                    <option>Female</option>
                                </datalist>
                            </td>
                        </tr>
                        <tr> 
                            <th>Department Name:</th>
                            <td><input style="margin: 3px" type="text" name="deptName" value="${sysUserBean.departmentName}" size="20"></td>
                        </tr>                
                        <tr> 
                            <th>Position:</th>
                            <td>
                                <input style="margin: 3px;" type="text" name="userPosition" list="cmbUserPosition" value="${sysUserBean.position}" size="20">
                                <datalist id="cmbUserPosition">
                                    <option>Employee</option>
                                    <option>Security Personnel</option>
                                    <option>System Admin</option>
                                </datalist>
                            </td>
                        </tr>
                        <tr> 
                            <th>Description:</th>                        
                            <td><textarea rows="4" cols="50" style="margin: 3px;" type="text" name="sysUserDescription" size="20">${sysUserBean.description}</textarea></td>
                        </tr>
                        <tr>
                            <td><hr/></td>
                            <td><hr/></td>
                            <th><hr/></th>                    
                        </tr>
                        <tr> 
                            <th>User Name:</th>
                            <td><input type="text" name="userName" value="${sysUserBean.userName}" size="20"></td>                           
                        </tr>
                        <tr><p style="color: red;margin-left: -30px;">${userNameValidation}</p></tr>
                        <tr> 
                            <th>Password:</th>
                            <td><input style="margin: 3px;" type="password" name="userPassword" value="${sysUserBean.password}" size="20"></td>
                        </tr>
                        <tr>                     
                            <td><input style="margin-top: 20px; margin-bottom: 20px;" type="submit" name="btnAction" value="Save"></td>
                            <td><input style="margin-top: 20px; margin-bottom: 20px;" type="submit" name="btnAction" value="Update"></td>                        
                        </tr>
                    </table>
                </form>
            </div>
            <div style="margin-top: 20px; margin-bottom: 20px; margin-left: 200px; margin-right: 200px;">
                <table align="center" border="1|0" style="background-color: #83b0b2">
                    <tr>
                        <th>Full Name</th>
                        <th>Sex</th>
                        <th>Department Name</th>
                        <th>Position</th>
                        <th>Description</th>
                        <th colspan="2">Action</th>                        
                    </tr>
                    <c:forEach items="${allSysUsers}" var="allSysUser">
                        <tr>                            
                            <td>${allSysUser.fullName}</td>                        
                            <td>${allSysUser.sex}</td>
                            <td>${allSysUser.departmentName}</td>
                            <td>${allSysUser.position}</td>
                            <td>${allSysUser.description}</td>                                                          
                            <th><a href="/Vcs-unipi/SystemUsersServlet?value=update.${allSysUser.userId}"><input type="submit" value="Edit"></a></th>
                            <th><a href="/Vcs-unipi/SystemUsersServlet?value=delete.${allSysUser.userId}"><input type="submit" value="Delete"></a></th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
