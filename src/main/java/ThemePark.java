import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark() {
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
    }

    public ArrayList<Attraction> getAttractions() {
        return this.attractions;
    }

    public ArrayList<Stall> getStalls() {
        return this.stalls;
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public void addStall(Stall stall) {
        this.stalls.add(stall);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> allReviewed = new ArrayList<>();
        for(Attraction attraction : this.attractions) { allReviewed.add(attraction); }
        for(Stall stall : this.stalls) { allReviewed.add(stall); }
        return allReviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        if(this.attractions.contains(attraction)) {
            attraction.incrementVisitCount();
            visitor.addAttraction(attraction);
        }
    }

    public HashMap<String, Integer> getAllReviews() {
        HashMap<String, Integer> allReviews = new HashMap<>();
        for(IReviewed iReviewed : this.getAllReviewed()) {
            allReviews.put(iReviewed.getName(), iReviewed.getRating());
        }
        return allReviews;
    }

    public ArrayList<ISecurity> getAllAllowedFor(Visitor visitor) {
        ArrayList<ISecurity> allAllowed = new ArrayList<>();
        for (IReviewed iReviewed : this.getAllReviewed()) {
            if(iReviewed instanceof ISecurity) {
                ISecurity iSecurity = (ISecurity) iReviewed;
                if (iSecurity.isAllowed(visitor)) {
                    allAllowed.add(iSecurity);
                }
            }
        }
        return allAllowed;
    }
}
