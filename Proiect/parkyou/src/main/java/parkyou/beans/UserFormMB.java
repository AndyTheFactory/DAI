/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.beans;

import static com.github.adminfaces.template.util.Assert.has;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import parkyou.entity.User;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import parkyou.model.UserModel;
import static parkyou.util.Utils.addDetailMessage;

@Named
@ViewScoped
public class UserFormMB  implements Serializable {
    private Integer id;
    
    private User user;
    
    @Inject
    UserModel userModel;
    
    String password;
    
    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(id)) {
            user = userModel.findById(id);
        } else {
            user = new User();
        }
    }
    
    

    public void remove() throws IOException {
        if (has(user) && has(user.getId())) {
            userModel.remove(user);
            addDetailMessage("User " + user.getUsername()
                    + " removed successfully");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("admin-users.jsf");
        }
    }

    public void save() {
        String msg;
        
        if (this.password!=""){
            user.setPassword(this.password);
        }
        if (user.getId() == null) {
            userModel.insert(user);
            msg = "User " + user.getUsername()+ " created successfully";
        } else {
            userModel.update(user);
            msg = "Car " + user.getUsername()+ " updated successfully";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        user = new User();
        id = null;
    }

    public boolean isNew() {
        return user == null || user.getId() == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
    
}
