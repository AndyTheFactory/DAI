package coreservlets;

/** Bean to represent a double. Immutable. We could have used Double except
 *  that accessor (doubleValue) does not follow getBlah naming convention.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 */

public class NumberBean {
  private final double num;

  public NumberBean(double number) {
    this.num = number;
  }
  
  public double getNumber() {
    return(num);
  }
}
