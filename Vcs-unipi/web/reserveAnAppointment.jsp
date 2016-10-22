<%-- 
    Document   : reserveAnAppointment
    Created on : Dec 12, 2015, 11:45:54 AM
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
            <div>
                <div style="margin-left: 550px; margin-right: 500px;">
                    <h3 style="color: #A9094D">Reserve Visitor's Appointment</h3>
                </div>
                <div>
                    <td><hr/></td>                    
                </div>
                <div style="margin-left: 550px; margin-right: 500px;">
                    <h4>Select Visitor to Reserve an Appointment</h4>
                </div>

                <table align="center" border="1|0" style="background-color: #83b0b2">                    
                    <tr>
                        <th>Visitor Id</th>
                        <th>Visitor Name</th>
                        <th>Visitor Sex</th>
                        <th>Visitor Age</th>
                        <th>Visitor Description</th>
                        <th colspan="2">Action</th>                        
                    </tr>

                    <c:forEach items="${allVisistors}" var="allVisistor">
                        <tr>                            
                            <td>${allVisistor.visitorId}</td>                        
                            <td>${allVisistor.visitorName}</td>
                            <td>${allVisistor.visitorSex}</td>
                            <td>${allVisistor.visitorAge}</td>
                            <td>${allVisistor.description}</td>                                                          
                            <th><a href="/Vcs-unipi/AppointmentServlet?value=select.${allVisistor.visitorId}"><input type="submit" value="Select Visitor"></a></th>                            
                        </tr>
                    </c:forEach>

                </table>
                <div>
                    <td><hr/></td>                    
                </div>
                <form method="POST" action="AppointmentServlet">
                    <table align="center" style="background-color: #83b0b2; margin-top: 10px; margin-bottom: 10px; border-radius: 12px;">
                        <tr>
                            <th><br/></th>
                            <th><br/></th>
                            <th><br/></th>
                            <th><br/></th>
                            <th><br/></th>
                            <th><br/></th>
                        </tr>
                        <tr>
                            <td><hr/></td>
                            <td><hr/></td>
                            <td><hr/></td>
                            <td><hr/></td>
                        </tr>
                        <tr>
                            <th>Visitor Id:</th>
                            <td><input style="margin: 3px" type="text" readonly="true" name="visitorId" value="${visitor.visitorId}" size="20"></td>
                        </tr>
                        <tr>
                            <td><hr/></td>
                            <td><hr/></td>
                            <td><hr/></td>
                            <td><hr/></td>
                        </tr>
                        <input type="hidden" name="appId" value="${appointmentBean.appId}">
                        <tr>
                            <th>Appointment Date:</th>
                            <td><input style="margin: 3px" type="date" name="appointmentDate" value="${appointmentBean.appDate}" size="20"></td>
                        </tr>
                        <tr>
                            <th>Appointment Time:</th>
                            <td><input style="margin: 3px;" type="time" name="appointmentTime" value="${appointmentBean.appTime}"></td>
                        </tr>
                        <tr> 
                            <th>Remark:</th>
                            <td><textarea rows="4" cols="50" style="margin: 3px;" type="text" name="appointmentRemark">${appointmentBean.remark}</textarea></td>
                        </tr>
                        <tr>                     
                            <td><input style="margin-top: 20px;" type="submit" name="btnAction" value="Save"></td>
                            <td><input style="margin-top: 20px;" type="submit" name="btnAction" value="Update"></td>                            
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                <table align="center" border="1|0" style="background-color: #83b0b2">              
                    <tr>
                        <th>Appointment Date</th>
                        <th>Appointment Time</th>
                        <th>Appointment Remark</th>
                        <th colspan="2">Action</th>                        
                    </tr>
                    <c:forEach items="${allAppointments}" var="allAppointment">
                        <tr>                            
                            <td>${allAppointment.appDate}</td>                        
                            <td>${allAppointment.appTime}</td>
                            <td>${allAppointment.remark}</td>                                                       
                            <th><a href="/Vcs-unipi/AppointmentServlet?value=update.${allAppointment.appId}"><input type="submit" value="Edit"></a></th>
                            <th><a href="/Vcs-unipi/AppointmentServlet?value=delete.${allAppointment.appId}"><input type="submit" value="Delete"></a></th>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </body>
</html>
