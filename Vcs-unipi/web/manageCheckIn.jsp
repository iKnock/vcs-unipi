<%-- 
    Document   : manageCheckIn
    Created on : Dec 12, 2015, 1:55:50 PM
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
                    <h3 style="color: #A9094D">Manage Check In and Check Out</h3>
                </div>
                <div>
                    <td><hr/></td>                    
                </div>
                <table align="center" border="1|0" style="background-color: #83b0b2">                    
                    <tr>
                        <!--<th>Visitor Id</th>-->
                        <th>Visitor Name</th>
                        <th>Inviter Full Name</th>
                        <th>Inviter Dept. Name</th>
                        <th>Visitor Sex</th>
                        <th>Visitor Age</th>
                        <th>Visitor Description</th>     
                        <th>Appointment Date</th>
                        <th>Appointment Time</th>
                        <th>Remark</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach items="${pendingAppointments}" var="pendingAppointment">
                        <tr>                            
                            <!--<td>${pendingAppointment.visitorId}</td>-->     
                            <td>${pendingAppointment.visitorName}</td>
                            <td>${pendingAppointment.getFull_name()}</td>
                            <td>${pendingAppointment.getDepartment_name()}</td>
                            <td>${pendingAppointment.visitorSex}</td>                                                        
                            <td>${pendingAppointment.visitorAge}</td>
                            <td>${pendingAppointment.visitorDescription}</td>     
                            <td>${pendingAppointment.appointmentDate}</td>
                            <td>${pendingAppointment.appointmentTime}</td> 
                            <td>${pendingAppointment.appointmentRemark}</td>
                            <th><a href="/Vcs-unipi/CheckInServlet?value=select.${pendingAppointment.appointmentId}"><input type="submit" value="Select Appointment"></a></th>
                        </tr>
                    </c:forEach>
                </table>
                <form method="POST" action="CheckInServlet">
                    <table align="center" style="background-color: #83b0b2; margin-top: 10px; margin-bottom: 10px; border-radius: 12px;">                   
                        <tr>
                            <td><hr/></td>
                            <td><hr/></td>
                            <th><hr/></th>                    
                        </tr>  
                        <tr>
                            <td><input type="hidden" name="checkInId" value="${checkInBean.checkInId}"></td>
                        </tr>
                        <tr>
                            <th>Appointment Id:</th>
                            <td><input type="text" readonly="true" name="appId" value="${visitorAppBean.appointmentId}"></td>
                        </tr>
                        <tr>
                            <td><hr/></td>
                            <td><hr/></td>
                            <th><hr/></th>                    
                        </tr>  
                        <tr>
                            <th>Operation:</th>
                            <td>
                                <input style="margin: 3px" type="text" name="checkInStatus" value="${checkInBean.checkInStatus}" list="cmbCheckInStatus" size="20">
                                <datalist id="cmbCheckInStatus">
                                    <option>Check-In</option>
                                    <option>Check-Out</option>
                                </datalist>
                            </td>
                        </tr>
                        <tr>
                            <th>Memo:</th>
                            <td><textarea rows="4" cols="50" style="margin: 3px" type="text" name="checkInMemo" size="20">${checkInBean.checkInMemo}</textarea></td>
                        </tr>
                        <tr>                     
                            <td><input style="margin-top: 20px;" name="btnAction" type="submit" value="Save"></td>
                            <td><input style="margin-top: 20px;" name="btnAction" type="submit" value="Update"></td>                        
                        </tr>
                    </table>
                </form>
            </div>
            <div>
                <table align="center" border="1|0" style="background-color: #83b0b2">                   
                    <tr>
                        <th>Status</th>
                        <th>Memo</th>             
                        <th colspan="3">Action</th>  
                    </tr>
                    <c:forEach items="${allCheckIns}" var="allCheckIn">
                        <tr>                            
                            <td>${allCheckIn.status}</td>                        
                            <td>${allCheckIn.memo}</td>         
                            <th><a href="/Vcs-unipi/CheckInServlet?value=chkout.${allCheckIn.checkInId}"><input type="submit" value="Check Out"></a></th>
                            <th><a href="/Vcs-unipi/CheckInServlet?value=update.${allCheckIn.checkInId}"><input type="submit" value="Edit"></a></th>
                            <th><a href="/Vcs-unipi/CheckInServlet?value=delete.${allCheckIn.checkInId}"><input type="submit" value="Delete"></a></th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
