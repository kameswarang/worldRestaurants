package worldRest.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import worldRest.persistence.Restaurant;

@Local
public interface RestaurantEJBLocal {
    public List<Restaurant> getAllRestaurants();
    public List<Restaurant> searchByCuisine(String cuisine);
    public List<Restaurant> searchByName(String name);
}