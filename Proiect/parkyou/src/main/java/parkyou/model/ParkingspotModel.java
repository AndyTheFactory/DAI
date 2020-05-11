/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.model;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import parkyou.entity.Parkingspot;
import parkyou.entity.User;

/**
 *
 * @author andrei
 */
@Stateless
public class ParkingspotModel {
//    private static final String PERSISTENCE_UNIT_NAME = "com.parkyouDB";   
//    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME, type = PersistenceContextType.EXTENDED)
    @PersistenceContext(unitName = "com.parkyouDB")
    private EntityManager em; 

    public List<Parkingspot> paginate(Filter<Parkingspot> filter) {
        TypedQuery<Parkingspot> query = em.createNamedQuery("Parkingspots.findAll",Parkingspot.class);
        
        return query.getResultList();
    }
    public long count(Filter<Parkingspot> filter) {
        TypedQuery<Long> query = em.createNamedQuery("Parkingspots.count",Long.class);
        
        return query.getSingleResult();
    }
    public long count(Filter<Parkingspot> filter, User user) {
        TypedQuery<Long> query = em.createNamedQuery("Parkingspots.countOwner",Long.class);
        query.setParameter("owner", user.getId());
        
        return query.getSingleResult();
    }

    public Parkingspot findById(Integer id) {
        TypedQuery<Parkingspot> query = em.createNamedQuery("Parkingspots.findById",Parkingspot.class);
        query.setParameter("id", id );
        
        return query.getSingleResult();
    }

    public List<Parkingspot> paginate(Filter<Parkingspot> filter, User user) {
        TypedQuery<Parkingspot> query = em.createNamedQuery("Parkingspots.findByOwner",Parkingspot.class);
        query.setParameter("owner", user.getId());
        
        
        return query.getResultList();
    }
    
    public List<Parkingspot> paginate(Filter<Parkingspot> filter, Date fromDate, Date toDate) {
        TypedQuery<Parkingspot> query = em.createNamedQuery("Parkingspots.findBySchedule",Parkingspot.class);
        query.setParameter("fromdate", fromDate);
        query.setParameter("todate", toDate);
        
        
        return query.getResultList();
    }
    
    
    public void remove(Parkingspot parking){
        if (!em.contains(parking)) {
            parking = em.merge(parking);
        }

        em.remove(parking);
        
    }
    
    public Parkingspot update(Parkingspot parking){
        return em.merge(parking);
        
    }

    public void insert(Parkingspot parking){
        em.persist(parking);
    }
    
}
