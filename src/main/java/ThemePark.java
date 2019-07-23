import attractions.Attraction;
import attractions.Dodgems;
import behaviours.IReviewed;
import org.w3c.dom.Attr;
import stalls.CandyflossStall;
import stalls.Stall;

import java.util.ArrayList;
import java.util.Collection;

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
        for(Attraction attraction : this.attractions) { allReviewed.add((IReviewed) attraction); }
        for(Stall stall : this.stalls) { allReviewed.add((IReviewed) stall); }
        return allReviewed;
    }
}
