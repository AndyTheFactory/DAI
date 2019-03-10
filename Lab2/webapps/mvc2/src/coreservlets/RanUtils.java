package coreservlets;

/** "Business logic" for RandomNumberServlet MVC example.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 */

public class RanUtils {
  public static NumberBean getRandomNum(String rangeString) {
    double range;
    try {
      range = Double.parseDouble(rangeString);
    } catch(Exception e) {
      range = 10.0;
    }
    return(new NumberBean(Math.random() * range));
  }
  
  private RanUtils() {} // Non-instantiatable class
}
