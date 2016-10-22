package entity;

import entity.CheckinOut;
import entity.SysUser;
import entity.Visitor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-12T16:36:31")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, String> appTime;
    public static volatile SingularAttribute<Appointment, SysUser> inviterId;
    public static volatile SingularAttribute<Appointment, Integer> appId;
    public static volatile CollectionAttribute<Appointment, CheckinOut> checkinOutCollection;
    public static volatile SingularAttribute<Appointment, String> appDate;
    public static volatile SingularAttribute<Appointment, String> remark;
    public static volatile SingularAttribute<Appointment, String> status;
    public static volatile SingularAttribute<Appointment, Visitor> visitorId;

}