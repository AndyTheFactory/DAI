/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.beans;

import static com.github.adminfaces.template.util.Assert.has;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import parkyou.entity.Parkingspot;
import parkyou.entity.User;
import parkyou.model.Filter;
import parkyou.model.ParkingspotModel;
import parkyou.model.UserModel;

/**
 *
 * @author andrei
 */
@Named
@ViewScoped
public class MyParkingMB implements Serializable {

    @Inject
    private UserModel userModel;
    
    @Inject
    ParkingspotModel parkingspotModel;
    
    @Inject
    SecurityContext securityContext;
    
    Filter<Parkingspot> filter = new Filter<>(new Parkingspot());
    
    Parkingspot selectedParking; //cars selected in checkbox column
    
    LazyDataModel<Parkingspot> parking;
    
    List<Parkingspot> filteredValue;// datatable filteredValue attribute (column filters)

    Integer id;
    User my;
    
    @PostConstruct
    public void initDataModel() {
        String username = securityContext.getCallerPrincipal().getName();
        my = userModel.findUserByLogin(username);
        
        parking = new LazyDataModel<Parkingspot>() {
            @Override
            public List<Parkingspot> load(int first, int pageSize,
                                  String sortField, SortOrder sortOrder,
                                  Map<String, Object> filters) {
                List<Parkingspot> list = parkingspotModel.paginate(filter,my);
                setRowCount((int) parkingspotModel.count(filter,my));
//                if (list.size()>0){
//                    selectedParking = list.get(0);
//                    id = list.get(0).getId();
//                }
                return list;
            }

            @Override
            public int getRowCount() {
                return super.getRowCount();
            }

            @Override
            public Parkingspot getRowData(String key) {
                return parkingspotModel.findById(new Integer(key));
            }
            
        };
        return;
    }
    

    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(id)) {
            selectedParking = parkingspotModel.findById(id);
        }
    }
    
    public void onRowSelect(SelectEvent selectEvent){
        //selectedParking = (Parkingspot)selectEvent.getObject();
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getParkingName(){
        if (this.id == null){
            return "No Parking Spot selected";
        }
        //TODO: get parking spot name
        return "TODO";
    }

    public Parkingspot getSelectedParking() {
        return selectedParking;
    }

    public void setSelectedParking(Parkingspot selectedParking) {
        this.selectedParking = selectedParking;
    }

    public LazyDataModel<Parkingspot> getParking() {
        return parking;
    }

    public void setParking(LazyDataModel<Parkingspot> parking) {
        this.parking = parking;
    }

    public Filter<Parkingspot> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Parkingspot> filter) {
        this.filter = filter;
    }
    
    
    
}
