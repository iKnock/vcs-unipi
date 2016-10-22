<%-- 
    Document   : error
    Created on : Dec 26, 2015, 12:58:36 AM
    Author     : meknock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: #b2cecf;">
        <div>
            <div style="border: 1px black solid; border-radius: 12px; background-color: #b2cfc2;">
                <table align="center">
                    <tr>
                        <th><a href="/Vcs-unipi/HomeServlet"><input style="margin-top: 20px;" type="submit" value="Home"></a></th>
                        <!--<th><a href="/Vcs-unipi/SystemUsersServlet"><input style="margin-top: 20px;" type="submit" value="Register System User"></a></th>
                        <th><a href="/Vcs-unipi/VisitorServ"><input style="margin-top: 20px;" type="submit" value="Register visitor"></a></th>
                        <th><a href="/Vcs-unipi/AppointmentServlet"><input style="margin-top: 20px;" type="submit" value="Reserve An Appointment"></a></th>
                        <th><a href="/Vcs-unipi/CheckInServlet"><input style="margin-top: 20px;" type="submit" value="Manage Check-In"></a></th>-->
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
            <div style="border: 3px red solid; border-radius: 12px; margin-left: 400px; margin-right: 400px; margin-top: 130px;">
                <h2 style="color: red; margin-left: 35px;">Invalid User Name or Password! Please Try Again.</h2>
                <div style="border: 1px black solid; border-radius: 12px; width: 80px; margin-left: 30%;"><a style="text-align: center;" href="/Vcs-unipi/LogInServlet"><h4>Log In</h4></a></div>
            </div>
        </div>
    </body>
</html>
