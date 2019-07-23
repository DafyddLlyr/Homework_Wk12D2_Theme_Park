package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void visitorUnder18NotAllowed() {
        Visitor youngVisitor = new Visitor(17, 180, 100);
        assertFalse(tobaccoStall.isAllowed(youngVisitor));
    }

    @Test
    public void visitor18YearsOldAllowed() {
        Visitor visitor = new Visitor(18, 180, 100);
        assertTrue(tobaccoStall.isAllowed(visitor));
    }

    @Test
    public void visitorOver18Allowed() {
        Visitor oldVisitor = new Visitor(20, 180, 100);
        assertTrue(tobaccoStall.isAllowed(oldVisitor));
    }

    @Test
    public void hasRating() {
        assertEquals(5, tobaccoStall.getRating());
    }
}
