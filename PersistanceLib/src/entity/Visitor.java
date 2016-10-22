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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author meknock
 */
@Entity
@Table(name = "tbl_visitor")
@NamedQueries({
    @NamedQuery(name = "Visitor.findAll", query = "SELECT v FROM Visitor v"),
    @NamedQuery(name = "Visitor.findByVisitorId", query = "SELECT v FROM Visitor v WHERE v.visitorId = :visitorId"),
    @NamedQuery(name = "Visitor.findByVisitorName", query = "SELECT v FROM Visitor v WHERE v.visitorName = :visitorName"),
    @NamedQuery(name = "Visitor.findByVisitorSex", query = "SELECT v FROM Visitor v WHERE v.visitorSex = :visitorSex"),
    @NamedQuery(name = "Visitor.findByVisitorAge", query = "SELECT v FROM Visitor v WHERE v.visitorAge = :visitorAge"),
    @NamedQuery(name = "Visitor.findByDescription", query = "SELECT v FROM Visitor v WHERE v.description = :description")})
public class Visitor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "visitor_id")
    private Integer visitorId;
    @Basic(optional = false)
    @Column(name = "visitor_name")
    private String visitorName;
    @Basic(optional = false)
    @Column(name = "visitor_sex")
    private String visitorSex;
    @Basic(optional = false)
    @Column(name = "visitor_age")
    private String visitorAge;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitorId")
    private Collection<Appointment> appointmentCollection;

    public Visitor() {
    }

    public Visitor(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Visitor(Integer visitorId, String visitorName, String visitorSex, String visitorAge, String description) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.visitorSex = visitorSex;
        this.visitorAge = visitorAge;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitorId != null ? visitorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitor)) {
            return false;
        }
        Visitor other = (Visitor) object;
        if ((this.visitorId == null && other.visitorId != null) || (this.visitorId != null && !this.visitorId.equals(other.visitorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Visitor[ visitorId=" + visitorId + " ]";
    }
    
}
