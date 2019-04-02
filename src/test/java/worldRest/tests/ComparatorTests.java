package worldRest.backingBeans.tests;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;

import javax.ejb.EJB;

import org.junit.Test;

import worldRest.persistence.Restaurant;
import worldRest.persistence.Restaurant;
import worldRest.persistence.comparators.restaurant.CostComparator;
import worldRest.persistence.comparators.restaurant.RatingComparator;
import worldRest.persistence.comparators.restaurant.VotesComparator;
import worldRest.logic.interfaces.RestaurantEJBLocal;

public class ComparatorTests {
    @EJB
    RestaurantEJBLocal restEJB;
    
    List<Restaurant> rests;
    
    public ComparatorTests() {
        rests = restEJB.getAllRestaurants();
    }
    
    public void costCompareTest() {
        System.out.println(Arrays.toString(rests.toArray()));
        Collections.sort(rests, new CostComparator());
    }
}