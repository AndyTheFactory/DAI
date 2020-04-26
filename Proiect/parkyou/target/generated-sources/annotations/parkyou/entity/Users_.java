package parkyou.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-26T17:26:17")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Double> homex;
    public static volatile SingularAttribute<Users, Double> homey;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Serializable> avatar;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, String> lastname;

}