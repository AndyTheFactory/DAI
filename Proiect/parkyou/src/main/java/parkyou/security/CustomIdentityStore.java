/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.security;


import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import javax.inject.Inject;
import parkyou.entity.User;
import parkyou.model.UserModel;

@ApplicationScoped
public class CustomIdentityStore implements IdentityStore {
    @Inject
    private UserModel um;
    
    @Override
    public CredentialValidationResult validate(Credential credential) {

        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
        
        String username = login.getCaller();
        String password = login.getPasswordAsString();
        if (username=="guest"){
                return new CredentialValidationResult("guest", new HashSet<>(Arrays.asList("GUEST")));
        }else{
            Optional<User> u = um.findByLogin(username,password);

            if (u.isPresent()) {
                return new CredentialValidationResult(u.get().getUsername(), new HashSet<>(Arrays.asList(u.get().getGroup())));
            } else {
                return CredentialValidationResult.INVALID_RESULT;
            }
        }
    }
}