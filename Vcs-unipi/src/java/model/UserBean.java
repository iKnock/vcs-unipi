/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author meknock
 */
public class UserBean {

    private Integer userId;
    private String fullName;
    private String sex;
    private String departmentName;
    private String description;
    private String position;
    private String status;
    private String userName;

    public UserBean() {
    }

    public UserBean(Integer userId, String fullName, String sex, String departmentName, String description, String position, String status, String userName) {
        this.userId = userId;
        this.fullName = fullName;
        this.sex = sex;
        this.departmentName = departmentName;
        this.description = description;
        this.position = position;
        this.status = status;
        this.userName = userName;
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
}
