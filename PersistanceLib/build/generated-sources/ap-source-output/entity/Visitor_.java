package entity;

import entity.Appointment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-12T16:36:31")
@StaticMetamodel(Visitor.class)
public class Visitor_ { 

    public static volatile SingularAttribute<Visitor, String> visitorName;
    public static volatile SingularAttribute<Visitor, String> visitorAge;
    public static volatile SingularAttribute<Visitor, String> description;
    public static volatile SingularAttribute<Visitor, String> visitorSex;
    public static volatile SingularAttribute<Visitor, Integer> visitorId;
    public static volatile CollectionAttribute<Visitor, Appointment> appointmentCollection;

}