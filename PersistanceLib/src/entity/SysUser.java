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
@Table(name = "tbl_sys_user")
@NamedQueries({
    @NamedQuery(name = "SysUser.findAll", query = "SELECT s FROM SysUser s"),
    @NamedQuery(name = "SysUser.findByUserId", query = "SELECT s FROM SysUser s WHERE s.userId = :userId"),
    @NamedQuery(name = "SysUser.findByFullName", query = "SELECT s FROM SysUser s WHERE s.fullName = :fullName"),
    @NamedQuery(name = "SysUser.findBySex", query = "SELECT s FROM SysUser s WHERE s.sex = :sex"),
    @NamedQuery(name = "SysUser.findByDepartmentName", query = "SELECT s FROM SysUser s WHERE s.departmentName = :departmentName"),
    @NamedQuery(name = "SysUser.findByDescription", query = "SELECT s FROM SysUser s WHERE s.description = :description"),
    @NamedQuery(name = "SysUser.findByPosition", query = "SELECT s FROM SysUser s WHERE s.position = :position"),
    @NamedQuery(name = "SysUser.findByStatus", query = "SELECT s FROM SysUser s WHERE s.status = :status"),
    @NamedQuery(name = "SysUser.findByUserName", query = "SELECT s FROM SysUser s WHERE s.userName = :userName"),
    @NamedQuery(name = "SysUser.findByUserNamePassword", query = "SELECT s FROM SysUser s WHERE s.userName = :userName AND s.password = :password"),
    @NamedQuery(name = "SysUser.findByPassword", query = "SELECT s FROM SysUser s WHERE s.password = :password")})
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")    
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "full_name")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @Column(name = "department_name")
    private String departmentName;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @Column(name = "status")   
    private String status;
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inviterId")
    private Collection<Appointment> appointmentCollection;

    public SysUser() {
    }

    public SysUser(Integer userId) {
        this.userId = userId;
    }

    public SysUser(Integer userId, String fullName, String sex, String departmentName, String description, String position, String status, String password) {
        this.userId = userId;
        this.fullName = fullName;
        this.sex = sex;
        this.departmentName = departmentName;
        this.description = description;
        this.position = position;
        this.status = status;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysUser)) {
            return false;
        }
        SysUser other = (SysUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SysUser[ userId=" + userId + " ]";
    }
    
}
