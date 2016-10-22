/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessMethod;

import entity.CheckinOut;
import entity.VisitorAppointment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author meknock
 */
@Local
public interface CheckinOutFacadeLocal {

    void create(CheckinOut checkinOut);

    void edit(CheckinOut checkinOut);

    void remove(CheckinOut checkinOut);

    CheckinOut find(Object id);

    List<CheckinOut> findAll();

    List<CheckinOut> findRange(int[] range);

    int count();

    List<VisitorAppointment> getPendingApp();

    void updateAppointmentStatus(Integer appId, String status);

    void atomicCheckIn(CheckinOut checkinOut, Integer appId, String status);

    void atomicRemoveCheckIn(CheckinOut checkIn, Integer appId, String status);
    
}
