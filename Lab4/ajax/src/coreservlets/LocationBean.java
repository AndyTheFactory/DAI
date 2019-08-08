package coreservlets;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;

@ManagedBean 
@SessionScoped
public class LocationBean implements Serializable {
  private static final long serialVersionUID = 1L;
  private String state, cityPopulation;
  private boolean isCityListDisabled = true;

  public String getState() {
    return(state);
  }

  public void setState(String state) {
    this.state = state;
    this.cityPopulation="";                // Clear population display
    isCityListDisabled = false; // Enable list of cities
  }

  public String getCityPopulation() {
    return(cityPopulation);
  }

  public void setCityPopulation(String cityPopulation) {
    this.cityPopulation = cityPopulation;
  }
  
  public boolean isCityListDisabled() {
    return(isCityListDisabled);
  }
  
  public List<String> getStates() {
    return(StateInfo.STATE_NAMES);
  }
  
  public Map<String,String> getCities() {
    return(StateInfo.STATE_MAP.get(state));
  }
}
