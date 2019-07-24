package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {

    private double defaultPrice;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.defaultPrice = 8.40;
    }

    @Override
    public boolean isAllowed(Visitor visitor) {
        return (visitor.getAge() > 12 && visitor.getHeight() > 145);
    }

    @Override
    public double defaultPrice() {
        return this.defaultPrice;
    }

    @Override
    public double priceFor(Visitor visitor) {
        return (visitor.getHeight() <= 200) ? this.defaultPrice : this.defaultPrice * 2;
    }
}
