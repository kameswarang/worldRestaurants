package worldRest.persistence.comparators.restaurant;

import java.util.Comparator;

import worldRest.persistence.Restaurant;

public class VotesComparator implements Comparator<Restaurant> {
    public int compare(Restaurant r, Restaurant s) {
        return r.getVotes() - s.getVotes();
    }
}