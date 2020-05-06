/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.model;

import java.util.List;
import java.util.function.Predicate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import parkyou.entity.Parkingspot;

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

    public Parkingspot findById(Integer id) {
        return new Parkingspot(id);
    }
    
}
