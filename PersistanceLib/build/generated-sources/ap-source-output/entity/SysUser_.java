package entity;

import entity.Appointment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-22T18:49:27")
@StaticMetamodel(SysUser.class)
public class SysUser_ { 

    public static volatile SingularAttribute<SysUser, String> departmentName;
    public static volatile SingularAttribute<SysUser, String> password;
    public static volatile SingularAttribute<SysUser, String> sex;
    public static volatile SingularAttribute<SysUser, String> fullName;
    public static volatile SingularAttribute<SysUser, String> description;
    public static volatile SingularAttribute<SysUser, String> position;
    public static volatile SingularAttribute<SysUser, String> userName;
    public static volatile SingularAttribute<SysUser, Integer> userId;
    public static volatile SingularAttribute<SysUser, String> status;
    public static volatile CollectionAttribute<SysUser, Appointment> appointmentCollection;

}