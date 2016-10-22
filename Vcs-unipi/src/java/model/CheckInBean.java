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
public class CheckInBean {
    
    private Integer checkInId;
    private String checkInStatus;
    private String checkInMemo;

    public CheckInBean() {
    }

    public Integer getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Integer checkInId) {
        this.checkInId = checkInId;
    }

    public String getCheckInStatus() {
        return checkInStatus;
    }

    public void setCheckInStatus(String checkInStatus) {
        this.checkInStatus = checkInStatus;
    }

    public String getCheckInMemo() {
        return checkInMemo;
    }

    public void setCheckInMemo(String checkInMemo) {
        this.checkInMemo = checkInMemo;
    }        
}
