/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import parkyou.entity.Parkingspot;
import parkyou.entity.User;
import parkyou.model.Filter;
import parkyou.model.UserModel;

@Named
@ViewScoped
public class UserAdminMB implements Serializable {

    @Inject
    private UserModel userModel;

    Filter<User> filter = new Filter<>(new User());
    
    User selectedUser; //cars selected in checkbox column
    
    LazyDataModel<User> users;
    
    List<User> filteredValue;// datatable filteredValue attribute (column filters)
    

    @PostConstruct
    public void initDataModel() {
        users = new LazyDataModel<User>() {
            @Override
            public List<User> load(int first, int pageSize,
                                  String sortField, SortOrder sortOrder,
                                  Map<String, Object> filters) {
                List<User> list = userModel.paginate(filter);
                setRowCount((int) userModel.count(filter));
                return list;
            }

            @Override
            public int getRowCount() {
                return super.getRowCount();
            }

            @Override
            public User getRowData(String key) {
                return userModel.findById(new Integer(key));
            }
            
        };
        return;
        
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public Filter<User> getFilter() {
        return filter;
    }

    public void setFilter(Filter<User> filter) {
        this.filter = filter;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public LazyDataModel<User> getUsers() {
        return users;
    }

    public void setUsers(LazyDataModel<User> users) {
        this.users = users;
    }

    public List<User> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<User> filteredValue) {
        this.filteredValue = filteredValue;
    }
    
    public void onRowSelect(SelectEvent selectEvent){
        //selectedParking = (Parkingspot)selectEvent.getObject();
        
    }
    
}
