package worldRest.logic;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.SessionContext;
import javax.annotation.Resource;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.enterprise.inject.Default;

import worldRest.persistence.Restaurant;
import worldRest.logic.interfaces.RestaurantEJBLocal;

@Stateless @Default
public class RestaurantEJB implements RestaurantEJBLocal, Serializable {
    @PersistenceContext(name="worldRestPU")
    private EntityManager em;
    
    @Resource
    private SessionContext ctx;
    
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> rests = null;
        try {
            rests = (List<Restaurant>) em.createNamedQuery("getAllRestaurants").getResultList();
        }    
        catch(Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
        }
        return rests;
    }
    
    public List<Restaurant> searchByCuisine(String cuisine) {
        List<Restaurant> rests = null;
        try {
            rests = (List<Restaurant>) em.createNamedQuery("searchByCuisine").setParameter("cuisine", "%"+cuisine+"%").getResultList();
        }    
        catch(Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
        }
        return rests;
    }
    
    public List<Restaurant> searchByName(String name) {
        List<Restaurant> rests = null;
        try {
            rests = (List<Restaurant>) em.createNamedQuery("searchByName").setParameter("name", name).getResultList();
        }
        catch(Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
        }
        return rests;        
    }

}