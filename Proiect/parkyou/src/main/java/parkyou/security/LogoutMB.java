/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.security;

import org.omnifaces.util.Faces;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;
import java.io.IOException;
import java.io.Serializable;

import static com.github.adminfaces.template.util.Assert.has;

@RequestScoped
@Specializes
public class LogoutMB extends com.github.adminfaces.template.security.LogoutMB implements Serializable {


    @Override
    public void doLogout() throws IOException {
        if(has(Faces.getRequestCookie("admin-email"))) {
            Faces.removeResponseCookie("admin-email",null);
            Faces.removeResponseCookie("admin-pass",null);
        }
        super.doLogout();
    }
}