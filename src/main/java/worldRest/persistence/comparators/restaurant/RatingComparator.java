package worldRest.persistence.comparators.restaurant;

import java.util.Comparator;

import worldRest.persistence.Restaurant;

public class RatingComparator implements Comparator<Restaurant> {
    public int compare(Restaurant r, Restaurant s) {
        return (int) ((r.getRating() - s.getRating()) * 10);
    }
}