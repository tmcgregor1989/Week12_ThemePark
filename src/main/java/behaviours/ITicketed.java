package behaviours;

public interface ITicketed {

    public double defaultPrice();
    public double priceFor(people.Visitor visitor);
}
