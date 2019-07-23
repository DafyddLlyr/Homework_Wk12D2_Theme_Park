package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DodgemTest {

    Dodgems dodgems;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }

    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(4.50, dodgems.defaultPrice(), 0.00);
    }

    @Test
    public void chargesYoungPeopleHalf() {
        Visitor visitor = new Visitor(5, 140, 100);
        assertEquals(2.25, dodgems.priceFor(visitor), 0.00);
    }

    @Test
    public void charges12YearOldsFullPrice() {
        Visitor visitor = new Visitor(12, 140, 100);
        assertEquals(4.50, dodgems.priceFor(visitor), 0.00);
    }

    @Test
    public void chargesOlderPeopleDefaultPrice() {
        Visitor visitor = new Visitor(20, 180, 140);
        assertEquals(4.50, dodgems.priceFor(visitor), 0.00);
    }
}
