import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Dodgems attraction1;
    Park attraction2;
    RollerCoaster attraction3;
    Playground attraction4;
    CandyflossStall stall1;
    IceCreamStall stall2;
    TobaccoStall stall3;
    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;
    Visitor visitor;
    Visitor visitor2;
    HashMap<String, Integer> reviews;

    @Before
    public void before(){
        attraction1 = new Dodgems("Dodgy", 5);
        attraction2 = new Park("parky", 5);
        attraction3 = new RollerCoaster("Rolly", 5);
        attraction4 = new Playground("Groundy", 5);
        stall1 = new CandyflossStall("Candy", "Kandi", ParkingSpot.A1, 5);
        stall2 = new IceCreamStall("Ice T", "Ice Cube", ParkingSpot.B1, 5);
        stall3 = new TobaccoStall("Smoky", "Joe", ParkingSpot.A3, 5);
        attractions = new ArrayList<>(Arrays.asList(attraction1, attraction2, attraction3, attraction4));
        stalls = new ArrayList<>(Arrays.asList(stall1, stall2, stall3));
        themePark = new ThemePark(attractions, stalls);
        visitor = new Visitor(27, 175, 50.00);
        visitor2 = new Visitor(17, 175, 50.00);
        reviews = new HashMap<>();

    }

    @Test
    public void hasAttractions(){
        assertEquals(4, themePark.countAttractions());
    }

    @Test
    public void hasStalls(){
        assertEquals(3, themePark.countStalls());
    }

    @Test
    public void hasReviewed(){
        ArrayList<IReviewed> allReviewed = themePark.getAllReviewed();
        assertEquals(7, themePark.countAllReviewed(allReviewed));
    }

    @Test
    public void hasVisited(){
        themePark.visit(visitor, attraction1);
        assertEquals(1, attraction1.getVisitCount());
        assertEquals(1, visitor.countVisitedAttractions());
    }

    @Test
    public void hasReviewHashMap(){
        ArrayList<IReviewed> allReviewed = themePark.getAllReviewed();
        themePark.getReviews(allReviewed);
        assertEquals(7, themePark.countReviews());
    }

    @Test
    public void getsAllAllowedForVisitor(){
       ArrayList<IReviewed> allowed = themePark.getAllAllowedFor(visitor2, themePark.getAllReviewed());
       assertEquals(5, themePark.countAllAllowed(allowed));

    }
}
