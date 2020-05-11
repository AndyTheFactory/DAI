/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.beans;

import static com.github.adminfaces.template.util.Assert.has;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import parkyou.entity.Parkingspot;
import parkyou.entity.User;
import parkyou.model.ParkingspotModel;
import parkyou.model.UserModel;
import static parkyou.util.Utils.addDetailMessage;

@Named
@ViewScoped
public class ParkingAdminFormMB   implements Serializable {
    private Integer id;
    
    private Parkingspot parking;
    
    @Inject
    ParkingspotModel parkingModel;
    
    @Inject
    UserModel userModel;
    
    List<User> users;
    
    
    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(id)) {
            parking = parkingModel.findById(id);
        } else {
            parking = new Parkingspot();
        }
    }
    
    

    public void remove() throws IOException {
        if (has(parking) && has(parking.getId())) {
            parkingModel.remove(parking);
            addDetailMessage("User " + parking.getName()
                    + " removed successfully");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("parking-list.jsf");
        }
    }

    public void save() {
        String msg;
        
        //TODO:change!!
        
        parking.setX1(0);
        parking.setY1(0);
        parking.setX2(0);
        parking.setY2(0);
        
        if (parking.getOwner()==0){
            parking.setOwner(null);
        }
        
        if (parking.getId() == null) {
            parking.setCreated(new Date());
            parkingModel.insert(parking);
            msg = "User " + parking.getName()+ " created successfully";
        } else {
            parkingModel.update(parking);
            msg = "Car " + parking.getName()+ " updated successfully";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        parking = new Parkingspot();
        id = null;
    }

    public boolean isNew() {
        return parking == null || parking.getId() == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Parkingspot getParking() {
        return parking;
    }

    public void setParking(Parkingspot parking) {
        this.parking = parking;
    }

    public ParkingspotModel getParkingModel() {
        return parkingModel;
    }

    public void setParkingModel(ParkingspotModel parkingModel) {
        this.parkingModel = parkingModel;
    }

    public List<User> getUsers() {
        return userModel.findAll();
    }

    
}
