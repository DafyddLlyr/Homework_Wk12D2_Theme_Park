package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PlaygroundTest {
    Playground playground;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void visitorUnder15CanEnter() {
        Visitor youngVisitor = new Visitor(10, 100, 100);
        assertTrue(playground.isAllowed(youngVisitor));
    }

    @Test
    public void visitorAged15CanEnter() {
        Visitor middleVisitor = new Visitor(15, 150, 100);
        assertTrue(playground.isAllowed(middleVisitor));
    }

    @Test
    public void visitorOver15CannotEnter() {
        Visitor oldVisitor = new Visitor(25, 180, 100);
        assertFalse(playground.isAllowed(oldVisitor));
    }
}
