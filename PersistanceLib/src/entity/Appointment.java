/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author meknock
 */
@Entity
@Table(name = "tbl_appointment")
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByAppId", query = "SELECT a FROM Appointment a WHERE a.appId = :appId"),
    @NamedQuery(name = "Appointment.findByAppDate", query = "SELECT a FROM Appointment a WHERE a.appDate = :appDate"),
    @NamedQuery(name = "Appointment.findByAppTime", query = "SELECT a FROM Appointment a WHERE a.appTime = :appTime"),
    @NamedQuery(name = "Appointment.findByStatus", query = "SELECT a FROM Appointment a WHERE a.status = :status"),
    @NamedQuery(name = "Appointment.findByRemark", query = "SELECT a FROM Appointment a WHERE a.remark = :remark")})
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_id")
    private Integer appId;
    @Basic(optional = false)
    @Column(name = "app_date")
    private String appDate;
    @Basic(optional = false)
    @Column(name = "app_time")
    private String appTime;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "remark")
    private String remark;
    @JoinColumn(name = "inviter_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private SysUser inviterId;
    @JoinColumn(name = "visitor_id", referencedColumnName = "visitor_id")
    @ManyToOne(optional = false)
    private Visitor visitorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointmentId")
    private Collection<CheckinOut> checkinOutCollection;

    public Appointment() {
    }

    public Appointment(Integer appId) {
        this.appId = appId;
    }

    public Appointment(Integer appId, String appDate, String appTime, String status, String remark) {
        this.appId = appId;
        this.appDate = appDate;
        this.appTime = appTime;
        this.status = status;
        this.remark = remark;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SysUser getInviterId() {
        return inviterId;
    }

    public void setInviterId(SysUser inviterId) {
        this.inviterId = inviterId;
    }

    public Visitor getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Visitor visitorId) {
        this.visitorId = visitorId;
    }

    public Collection<CheckinOut> getCheckinOutCollection() {
        return checkinOutCollection;
    }

    public void setCheckinOutCollection(Collection<CheckinOut> checkinOutCollection) {
        this.checkinOutCollection = checkinOutCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appId != null ? appId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appId == null && other.appId != null) || (this.appId != null && !this.appId.equals(other.appId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Appointment[ appId=" + appId + " ]";
    }
    
}
