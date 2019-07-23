package attractions;

import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, IReviewed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowed(Visitor visitor) {
        return (visitor.getAge() > 12 && visitor.getHeight() > 145);
    }
}
