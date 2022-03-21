package attractions;

import people.Visitor;

public class RollerCoaster  extends Attraction implements behaviours.ISecurity, behaviours.ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        if (visitor.getAge() > 12 && visitor.getHeight() > 145.00){
            return true;
        }
        return false;
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if (visitor.getHeight() > 200.00){
            return this.defaultPrice()*2;
        }
        return this.defaultPrice();
    }
}
