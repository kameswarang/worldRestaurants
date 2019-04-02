package worldRest.backingBeans;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.io.Serializable;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.ejb.EJB;
import javax.validation.constraints.NotNull;

import worldRest.persistence.Restaurant;
import worldRest.persistence.comparators.restaurant.CostComparator;
import worldRest.persistence.comparators.restaurant.RatingComparator;
import worldRest.persistence.comparators.restaurant.VotesComparator;
import worldRest.logic.interfaces.RestaurantEJBLocal;

@Named("restBB") @SessionScoped
public class RestaurantBB implements Serializable {
    @EJB
    private RestaurantEJBLocal restaurantEJB;
    
    private List<Restaurant> rests;
    public List<Restaurant> getRests() { return this.rests; }
    
    @NotNull(message="Enter a valid cuisine")
    private String cuisine;
    public String getCuisine() { return this.cuisine; }
    public void setCuisine(String c) { this.cuisine = c; }
    
    @NotNull(message="Enter a valid name")
    private String name;
    public String getName() { return this.name; }
    public void setName(String r) { this.name = r; }
    
    private String sortBy;
    public String getSortBy() { return this.sortBy; }
    public void setSortBy(String r) { this.sortBy = r; }
    
    private boolean searchActive;
    public boolean getSearchActive() { return this.searchActive; }
    public void setSearchActive(boolean s) { this.searchActive = s; }

    @PostConstruct
    public void init() {
        getAllRestaurants();
        sortBy="";
    }
    
    public void getAllRestaurants() {
        rests = restaurantEJB.getAllRestaurants();
        cuisine="";
        name="";
        this.searchActive = false;
    }
    
    public void searchCuisine() {
        rests = restaurantEJB.searchByCuisine(cuisine);
        sort();
        this.searchActive = true;
    }
    
    public void searchRest() {
        rests = restaurantEJB.searchByName(name);
        sort();
        this.searchActive = true;
    }
    
    public void sort() {
      //System.out.println("Sorting by " + sortBy);
        switch(sortBy) {
            case "cost": sortByCost(); break;
            case "rating": sortByRating(); break;
            case "votes": sortByVotes(); break;
            case "": break;
        }
    }

    private void sortByCost() {
        Collections.sort(rests, new CostComparator());
    }
    
    private void sortByRating() {
        Collections.sort(rests, new RatingComparator().reversed());
    }
    
    private void sortByVotes() {
        Collections.sort(rests, new VotesComparator().reversed());
    }
}