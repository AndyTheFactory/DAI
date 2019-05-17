package coreservlets;

import javax.faces.bean.*;

@ManagedBean
public class NumberGenerator  {
  private double number = Math.random();
  private double range = 1.0;
  
  public double getRange() {
    return(range);
  }

  public void setRange(double range) {
    this.range = range;
  }

  public double getNumber() {
    return(number);
  }
  
  public double getNumber2() {
    return(Math.random() * range);
  }
  
  // In Ajax apps, the return value of the action controller method is
  // ignored. In non-Ajax apps, returning null means to redisplay the
  // current page. By using null here, the app will still work
  // (albeit with a full page reload) if you remove f:ajax.
  
  public String randomize() {
    number = range * Math.random();
    return(null);
  }
}
