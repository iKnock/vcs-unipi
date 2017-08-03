# vcs-unipi
## visitor check in system for university of pisa
This system is developed for a term project of the course in title **"concurrent and distributed systems"**. The project is **Distributed multithreaded application** that exploits the power of Java EE 7 freamwork. The idea is to create and manage a system that handles **visitors check-In** (Entrance) to a certain compound (university, research center, security firm or else…) in a distributed manner which consists of different actors like **security personnel** at the gate, the **visitor**, the **inviter** (who invite the visitor), the **security Guard supervisors** who are accessing the system from different places (Computers) with different authorization level.
The system will be a web based system so that users of the system which are located at different nodes can access the system seamlessly.   
The functional requirements of our system are the following  
        ..1.	Schedule Appointment: This functional requirement is essential for the inviter to register the visitor’s by putting all   the necessary information of the visitor on the system and place an appointment for the visitor prior to the visitor arrival at the compound. Generally this use case maintain who and when a visitor potentially come to the compound and request to enter.  
        ..2.	Check Visitors Appointment: In this functionality the system assists the security personals at the gate of the compound to 
        review and check if the visitor requesting permit is valid or not and where the visitor is going after he/she enters the compound.
        ..3.	Manage CheckIn/CheckOut: In this functionality of the system the security personals at the gate maintain information 
        (like the time the visitor enters the compound) for every visitor who enter the compound and maintain information as well when he 
        moves out of the compound (like the time he moves out).
        ..4.	View Visitors History: This functionality is useful to review the past visiting activities and answer questions like who getsin, when he/she gets in and where do they get in (or who invites them to get in).
To develop this web based application we will use a database to store the information and access that information accordingly. In order to 
organize our application we will be going to use the following stack of technologies  
        ..I.	Java server pages(JSP)
        ..II.	Servlet 
        ..III.	Enterprise java beans(EJB)
        ..V.	Java persistence technology(JPA)
        ..V.	Mysql
