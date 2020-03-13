package parkyou.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-24T21:01:03")
@StaticMetamodel(Reports.class)
public class Reports_ { 

    public static volatile SingularAttribute<Reports, Date> created;
    public static volatile SingularAttribute<Reports, Integer> freespots;
    public static volatile SingularAttribute<Reports, Integer> parkingspotId;
    public static volatile SingularAttribute<Reports, Integer> id;
    public static volatile SingularAttribute<Reports, Boolean> isObsolete;
    public static volatile SingularAttribute<Reports, Integer> userId;

}