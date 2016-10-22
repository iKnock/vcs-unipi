package entity;

import entity.Appointment;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-12T16:36:31")
@StaticMetamodel(CheckinOut.class)
public class CheckinOut_ { 

    public static volatile SingularAttribute<CheckinOut, Integer> checkInId;
    public static volatile SingularAttribute<CheckinOut, Appointment> appointmentId;
    public static volatile SingularAttribute<CheckinOut, String> memo;
    public static volatile SingularAttribute<CheckinOut, String> status;

}