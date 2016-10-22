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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author meknock
 */
@Entity
@Table(name = "tbl_checkin_out")
@NamedQueries({
    @NamedQuery(name = "CheckinOut.findAll", query = "SELECT c FROM CheckinOut c"),
    @NamedQuery(name = "CheckinOut.findByCheckInId", query = "SELECT c FROM CheckinOut c WHERE c.checkInId = :checkInId"),
    @NamedQuery(name = "CheckinOut.findByMemo", query = "SELECT c FROM CheckinOut c WHERE c.memo = :memo"),
    @NamedQuery(name = "CheckinOut.findByStatus", query = "SELECT c FROM CheckinOut c WHERE c.status = :status")})
public class CheckinOut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "check_in_id")
    private Integer checkInId;
    @Basic(optional = false)
    @Column(name = "memo")
    private String memo;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "appointment_id", referencedColumnName = "app_id")
    @ManyToOne(optional = false)
    private Appointment appointmentId;

    public CheckinOut() {
    }

    public CheckinOut(Integer checkInId) {
        this.checkInId = checkInId;
    }

    public CheckinOut(Integer checkInId, String memo, String status) {
        this.checkInId = checkInId;
        this.memo = memo;
        this.status = status;
    }

    public Integer getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Integer checkInId) {
        this.checkInId = checkInId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Appointment getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Appointment appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkInId != null ? checkInId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckinOut)) {
            return false;
        }
        CheckinOut other = (CheckinOut) object;
        if ((this.checkInId == null && other.checkInId != null) || (this.checkInId != null && !this.checkInId.equals(other.checkInId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CheckinOut[ checkInId=" + checkInId + " ]";
    }
    
}
