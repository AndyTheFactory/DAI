/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.model;

import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import parkyou.entity.Parkingspot;
import parkyou.entity.User;

/**
 *
 * @author andrei
 */
@Stateless
public class UserModel {
    
    @PersistenceContext(unitName = "com.parkyouDB")
    private EntityManager em; 

    public List<User> paginate(Filter<User> filter) {
        TypedQuery<User> query = em.createNamedQuery("Users.findAll",User.class);
        
        return query.getResultList();
    }
    public long count(Filter<User> filter) {
        TypedQuery<Long> query = em.createNamedQuery("Users.count",Long.class);
        
        return query.getSingleResult();
    }

    public static Parkingspot findById(Integer id) {
        return new Parkingspot(id);
    }
    public User findByEmail(String email)  throws NoResultException{
        TypedQuery<User> query = em.createNamedQuery("Users.findByEmail",User.class);
        query.setParameter("email", email );
        
        return query.getSingleResult();
    }
    public User findByUsername(String username) throws NoResultException{
        TypedQuery<User> query = em.createNamedQuery("Users.findByUsername",User.class);
        query.setParameter("username", username );
        
        return query.getSingleResult();
    }
    public User findByUsername(String username, String password)  throws NoResultException{
        TypedQuery<User> query = em.createNamedQuery("Users.findByUsernamePassword",User.class);
        query.setParameter("username", username );
        query.setParameter("password", password );
        
        return query.getSingleResult();
    }
    public User findByEmail(String email, String password)  throws NoResultException{
        TypedQuery<User> query = em.createNamedQuery("Users.findByEmailPassword",User.class);
        query.setParameter("email", email );
        query.setParameter("password", password );
        
        return query.getSingleResult();
    }
    public User findUserByLogin(String username_or_email){
            return  username_or_email.contains("@") ?
                findByEmail(username_or_email):
                findByUsername(username_or_email);            
    }
    public Optional<User> findByLogin(String username_or_email){
        try {
            return  Optional.of(findUserByLogin(username_or_email));            
        }
        catch (NoResultException e) {
	        return Optional.empty();
	    }
    }
    public Optional<User> findByLogin(String username_or_email, String password){
        try{
            return  username_or_email.contains("@") ?
                Optional.of(findByEmail(username_or_email,password)):
                Optional.of(findByUsername(username_or_email,password));            
            
        }catch(NoResultException e){
	        return Optional.empty();
        } 
    }
}
