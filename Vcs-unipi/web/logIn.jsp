<%-- 
    Document   : logIn
    Created on : Dec 12, 2015, 12:34:18 AM
    Author     : meknock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            </div>
            <div style="border: 1px black solid; border-radius: 12px; background-color: #83b0b2; margin-left: 500px; margin-right: 500px; margin-top: 130px;">
                <form method="POST" action="j_security_check">
                    <table align="center">
                        <tr>
                            <th></th>
                            <th style="margin-bottom: 20px;">Log In</th>
                        </tr>
                        <tr>
                            <th>User Name:</th>
                            <th><input style="margin: 3px" type="text" name="j_username" size="20"></th>
                        </tr>
                        <tr>
                            <th>Password:</th>
                            <td><input style="margin: 3px" type="password" name="j_password" size="20"></td>
                        </tr>
                        <tr> 
                            <td></td>
                            <td><input style="margin-top: 20px;" type="submit" value="Log In"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
