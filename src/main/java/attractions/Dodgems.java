package attractions;

import behaviours.IReviewed;
import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements IReviewed, ITicketed {

    private double defaultPrice;

    public Dodgems(String name, int rating) {
        super(name, rating);
        this.defaultPrice = 4.50;
    }

    @Override
    public double defaultPrice() {
        return this.defaultPrice;
    }

    @Override
    public double priceFor(Visitor visitor) {
        return (visitor.getAge() < 12) ? this.defaultPrice / 2 : this.defaultPrice;
    }
}
