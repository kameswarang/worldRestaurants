package worldRest.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity @Table(name="`restaurants`")
@NamedQueries({
    @NamedQuery(name="getAllRestaurants",
        query="SELECT r FROM Restaurant r"),
    @NamedQuery(name="searchByCuisine",
        query="SELECT r FROM Restaurant r WHERE r.cuisines LIKE :cuisine"),
    @NamedQuery(name="searchByName",
        query="SELECT r FROM Restaurant r WHERE r.name LIKE :name")
})
public class Restaurant {
    @Id @Column(name="`Restaurant ID`")
    private int id;
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    
    @Column(name="`Restaurant Name`")
    private String name;
    public String getName() { return this.name; }
    public void setName() { this.name = name; }
    
    @Column(name="`Cuisines`")
    private String cuisines;
    public String getCuisines() { return this.cuisines; }
    public void setCuisines(String cuisines) { this.cuisines = cuisines; }
    
    @Column(name=" `Average Cost for two`")
    private int costForTwo;
    public int getCostForTwo() { return this.costForTwo; }
    public void setCostForTwo(int c) { this.costForTwo = c; }
    
    @Column(name="`Currency`")
    private String currency;
    public String getCurrency() { return this.currency; }
    public void setCurrency(String c) { this.currency = c; }
    
    @Column(name="`Has Table booking`")
    private String tableBooking;
    public String getTableBooking() { return this.tableBooking; }
    public void setTableBooking(String t) { this.tableBooking = t; }
    
    @Column(name="`Has Online delivery`")
    private String onlineDelivery;
    public String getOnlineDelivery() { return this.onlineDelivery; }
    public void setOnlineDelivery(String o) { this.onlineDelivery = o; }
    
    @Column(name="`Aggregate rating`")
    private float rating;
    public float getRating() { return this.rating; }
    public void setRating(float r) { this.rating = r; }
    
    @Column(name="`Rating color`")
    private String ratingColor;
    public String getRatingColor() { return this.ratingColor; }
    public String getRatingColorNoSpaces() { return this.ratingColor.replaceAll("\\s", ""); }
    public void setRatingColor(String r) { this.ratingColor = r; }
    
    @Column(name="`Rating text`")
    private String ratingText;
    public String getRatingText() { return this.ratingText; }
    public void setRatingText(String r) { this.ratingText = r; }
    
    @Column(name="`Votes`")
    private int votes;
    public int getVotes() { return this.votes; }
    public void setVotes(int v) { this.votes = v; }
}