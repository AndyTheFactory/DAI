/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RegistrationController {
    
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String password2;

    public RegistrationController(){
        super();
    }
    
    public String getFirstName(){
        return this.firstname;
    }
    
}
