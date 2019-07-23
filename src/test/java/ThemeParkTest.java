import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ThemeParkTest {

    private ThemePark newPark;
    private Dodgems dodgems;
    private  CandyflossStall candyflossStall;

    @Before
    public void setup() {
        newPark = new ThemePark();
        dodgems = new Dodgems("Bumper Cars", 5);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 8);
    }

    @Test
    public void canAccessAttractions() {
        assertEquals(0, newPark.getAttractions().size());
    }

    @Test
    public void canGetStalls() {
        assertEquals(0, newPark.getStalls().size());
    }

    @Test
    public void canAddAttraction() {
        newPark.addAttraction(dodgems);
        assertEquals(1, newPark.getAttractions().size());
        assertTrue(newPark.getAttractions().contains(dodgems));
    }

    @Test
    public void canAddStalls() {
        newPark.addStall(candyflossStall);
        assertEquals(1, newPark.getStalls().size());
        assertTrue(newPark.getStalls().contains(candyflossStall));
    }

    @Test
    public void canGetAllReviewed() {
        newPark.addStall(candyflossStall);
        newPark.addAttraction(dodgems);
        assertEquals(2, newPark.getAllReviewed().size());
        assertTrue(newPark.getAllReviewed().contains(candyflossStall));
        assertTrue(newPark.getAllReviewed().contains(dodgems));
    }
}
