/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author meknock
 */
@Entity
public class VisitorAppointment implements Serializable {

    private Integer invitorId;
    @Column(name = "visitor_id")
    private Integer visitorId;
    @Column(name = "visitor_name")
    private String visitorName;
    @Column(name = "visitor_sex")
    private String visitorSex;
    @Basic(optional = false)
    @Column(name = "visitor_age")
    private String visitorAge;
    @Basic(optional = false)
    @Column(name = "description")
    private String visitorDescription;
    @Basic(optional = false)
    @Column(name = "user_id")
    private String user_id;
    @Basic(optional = false)
    @Column(name = "full_name")
    private String full_name;
    @Basic(optional = false)
    @Column(name = "department_name")
    private String department_name;
    @Basic(optional = false)
    @Column(name = "position")
    private String position;
    @Id
    @Basic(optional = false)
    @Column(name = "app_id")
    private Integer appointmentId;
    @Basic(optional = false)
    @Column(name = "app_date")
    private String appointmentDate;
    @Basic(optional = false)
    @Column(name = "app_time")
    private String appointmentTime;
    @Basic(optional = false)
    @Column(name = "status")
    private String appointmentStatus;
    @Basic(optional = false)
    @Column(name = "remark")
    private String appointmentRemark;

    public VisitorAppointment() {
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorSex() {
        return visitorSex;
    }

    public void setVisitorSex(String visitorSex) {
        this.visitorSex = visitorSex;
    }

    public String getVisitorAge() {
        return visitorAge;
    }

    public void setVisitorAge(String visitorAge) {
        this.visitorAge = visitorAge;
    }

    public String getVisitorDescription() {
        return visitorDescription;
    }

    public void setVisitorDescription(String visitorDescription) {
        this.visitorDescription = visitorDescription;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getInvitorId() {
        return invitorId;
    }

    public void setInvitorId(Integer invitorId) {
        this.invitorId = invitorId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentRemark() {
        return appointmentRemark;
    }

    public void setAppointmentRemark(String appointmentRemark) {
        this.appointmentRemark = appointmentRemark;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }    
}
