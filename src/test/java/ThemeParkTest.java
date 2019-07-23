import attractions.Dodgems;
import attractions.Playground;
import attractions.RollerCoaster;

import behaviours.ISecurity;

import people.Visitor;

import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThemeParkTest {

    private ThemePark themePark1;
    private ThemePark themePark2;
    private Dodgems dodgems;
    private CandyflossStall candyflossStall;
    private Visitor visitor;
    private RollerCoaster rollerCoaster;
    private TobaccoStall tobaccoStall;

    @Before
    public void setup() {
        themePark1 = new ThemePark();
        themePark2 = new ThemePark();
        dodgems = new Dodgems("Bumper Cars", 5);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 8);
        visitor = new Visitor(20, 180, 100);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);

        themePark2.addStall(candyflossStall);
        themePark2.addAttraction(dodgems);
    }

    @Test
    public void canAccessAttractions() {
        assertEquals(0, themePark1.getAttractions().size());
    }

    @Test
    public void canGetStalls() {
        assertEquals(0, themePark1.getStalls().size());
    }

    @Test
    public void canAddAttraction() {
        themePark1.addAttraction(dodgems);
        assertEquals(1, themePark1.getAttractions().size());
        assertTrue(themePark1.getAttractions().contains(dodgems));
    }

    @Test
    public void canAddStalls() {
        themePark1.addStall(candyflossStall);
        assertEquals(1, themePark1.getStalls().size());
        assertTrue(themePark1.getStalls().contains(candyflossStall));
    }

    @Test
    public void canGetAllReviewed() {
        assertEquals(2, themePark2.getAllReviewed().size());
        assertTrue(themePark2.getAllReviewed().contains(candyflossStall));
        assertTrue(themePark2.getAllReviewed().contains(dodgems));
    }

    @Test
    public void visitMethodIncrementsVisitCount() {
        themePark1.addAttraction(dodgems);
        themePark1.visit(visitor, dodgems);
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void visitMethodAddsAttractionToVisitor() {
        themePark1.addAttraction(dodgems);
        themePark1.visit(visitor, dodgems);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertTrue(visitor.getVisitedAttractions().contains(dodgems));
    }

    @Test
    public void cannotVisitAttractionNotInPark() {
        themePark1.visit(visitor, dodgems);
        assertEquals(0, dodgems.getVisitCount());
        assertEquals(0, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canGetAllReviews() {
        assertEquals(2, themePark2.getAllReviews().size());
        assertEquals(new Integer(5), themePark2.getAllReviews().get("Bumper Cars"));
        assertEquals(new Integer(8), themePark2.getAllReviews().get("Candy Land"));
    }

    @Test
    public void canGetAllISecurities() {
        visitor = new Visitor(25, 180, 100);
        themePark2.addAttraction(rollerCoaster);
        themePark2.addStall(tobaccoStall);

        ArrayList<ISecurity> allAllowed = themePark2.getAllAllowedFor(visitor);

        assertEquals(2, allAllowed.size());
        assertTrue(allAllowed.contains(rollerCoaster));
        assertTrue(allAllowed.contains(tobaccoStall));
    }

    @Test
    public void allAllowedRestrictsBasedOnAllISecurity() {
        visitor = new Visitor(16, 100, 100);
        Playground playground = new Playground("Fun Zone", 7);
        themePark2.addAttraction(rollerCoaster);
        themePark2.addStall(tobaccoStall);
        themePark2.addAttraction(playground);

        ArrayList<ISecurity> allAllowed = themePark2.getAllAllowedFor(visitor);

        assertEquals(0, allAllowed.size());
    }
}
