package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(17, 140.00, 50.00);
        visitor2 = new Visitor(17, 201.00, 50.00);
        visitor3 = new Visitor(11, 150.00, 50.00);
        visitor4 = new Visitor(25, 150.00, 50.00);
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
    public void allowsOver12andTall(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor2));
    }
    @Test
    public void deniesOver12andShort(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }
    @Test
    public void deniesUnder12andTall(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void chargesDoubleForTall(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor2), 0.00);
    }

    @Test
    public void chargesDefaultForShort(){
        assertEquals(8.40, rollerCoaster.priceFor(visitor4), 0.00);
    }
}
