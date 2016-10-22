/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author meknock
 */
public class VisitorBean implements Serializable{

    private int visitorId;
    private String visitorName = "";
    private String visitorSex = "";
    private String visitorAge = "";
    private String visitorDesc = "";

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
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

    public String getVisitorDesc() {
        return visitorDesc;
    }

    public void setVisitorDesc(String visitorDesc) {
        this.visitorDesc = visitorDesc;
    }
}
