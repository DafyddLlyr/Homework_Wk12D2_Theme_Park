package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorMustBeOver12() {
        Visitor youngVisitor = new Visitor(12, 200, 100);
        assertFalse(rollerCoaster.isAllowed(youngVisitor));
    }

    @Test
    public void visitorMustBeOver145cmTall() {
        Visitor shortVisitor = new Visitor(20, 145, 100);
        assertFalse(rollerCoaster.isAllowed(shortVisitor));
    }

    @Test
    public void visitorOver12AndOver145IsAllowed() {
        Visitor visitor = new Visitor(13, 146, 100);
        assertTrue(rollerCoaster.isAllowed(visitor));
    }
}
