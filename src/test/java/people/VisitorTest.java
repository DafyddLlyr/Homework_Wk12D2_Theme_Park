package people;

import attractions.Attraction;
import attractions.Dodgems;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VisitorTest {

    Visitor visitor;
    Attraction dodgems;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        dodgems = new Dodgems("Bumper Cars", 5);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void startsWithEmptyListOfAttractions() {
        assertEquals(0, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canAddAttraction() {
        visitor.addAttraction(dodgems);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertTrue(visitor.getVisitedAttractions().contains(dodgems));
    }
}
