import attractions.Dodgems;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThemeParkTest {

    private ThemePark themePark;
    private Dodgems dodgems;
    private  CandyflossStall candyflossStall;
    private Visitor visitor;

    @Before
    public void setup() {
        themePark = new ThemePark();
        dodgems = new Dodgems("Bumper Cars", 5);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 8);
        visitor = new Visitor(20, 180, 100);
    }

    @Test
    public void canAccessAttractions() {
        assertEquals(0, themePark.getAttractions().size());
    }

    @Test
    public void canGetStalls() {
        assertEquals(0, themePark.getStalls().size());
    }

    @Test
    public void canAddAttraction() {
        themePark.addAttraction(dodgems);
        assertEquals(1, themePark.getAttractions().size());
        assertTrue(themePark.getAttractions().contains(dodgems));
    }

    @Test
    public void canAddStalls() {
        themePark.addStall(candyflossStall);
        assertEquals(1, themePark.getStalls().size());
        assertTrue(themePark.getStalls().contains(candyflossStall));
    }

    @Test
    public void canGetAllReviewed() {
        themePark.addStall(candyflossStall);
        themePark.addAttraction(dodgems);
        assertEquals(2, themePark.getAllReviewed().size());
        assertTrue(themePark.getAllReviewed().contains(candyflossStall));
        assertTrue(themePark.getAllReviewed().contains(dodgems));
    }

    @Test
    public void visitMethodIncrementsVisitCount() {
        themePark.addAttraction(dodgems);
        themePark.visit(visitor, dodgems);
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void visitMethodAddsAttractionToVisitor() {
        themePark.addAttraction(dodgems);
        themePark.visit(visitor, dodgems);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertTrue(visitor.getVisitedAttractions().contains(dodgems));
    }

    @Test
    public void cannotVisitAttractionNotInPark() {
        themePark.visit(visitor, dodgems);
        assertEquals(0, dodgems.getVisitCount());
        assertEquals(0, visitor.getVisitedAttractions().size());
    }
}
