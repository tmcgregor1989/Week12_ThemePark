import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private HashMap<String, Integer> reviews;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
        this.reviews = new HashMap<>();
    }

    public int countAttractions(){
        return this.attractions.size();
    }

    public int countStalls() {
        return this.stalls.size();
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> allReviewed = new ArrayList<>();
        for (Attraction attraction : this.attractions){
            allReviewed.add(attraction);
        }
        for (Stall stall : this.stalls){
            allReviewed.add(stall);
        }
        return allReviewed;
    }

    public int countAllReviewed(ArrayList<IReviewed> allReviewed){
        return allReviewed.size();
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.incrementVisitCount();
        visitor.addAttraction(attraction);
    }

    public HashMap<String, Integer> getReviews(ArrayList<IReviewed> iReviewed){
        for (IReviewed review : iReviewed){
            this.reviews.put(review.getName(), review.getRating());
        }
        return reviews;
    }

    public int countReviews(){
        return reviews.size();
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor, ArrayList<IReviewed> iReviewed){
        ArrayList<IReviewed> allowedForVisitor = new ArrayList<>();
        for (IReviewed review : iReviewed){
            if (review instanceof ISecurity){
                if((((ISecurity) review).isAllowedTo(visitor))){
                    allowedForVisitor.add(review);
                }
            }
            else {allowedForVisitor.add(review);}
        }
        return allowedForVisitor;
    }

    public int countAllAllowed(ArrayList<IReviewed> iReviewed){
        return iReviewed.size();
    }
}



