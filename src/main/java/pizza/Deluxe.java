package pizza;

import constants.Constants;
import pizza.properties.Crust;
import pizza.properties.Pizza;
import pizza.properties.Size;
import pizza.properties.Topping;

public class Deluxe extends Pizza {

    public Deluxe(Crust crust) {
        super(crust);
    }


    /**
     * @return
     */
    @Override
    public double price() {
        if (super.getSize() == Size.SMALL) {
            return Constants.SMALL_DELUXE;
        } else if (super.getSize() == Size.MEDIUM) {
            return Constants.MEDIUM_DELUXE;
        } else if (super.getSize() == Size.LARGE) {
            return Constants.LARGE_DELUXE;
        } else {
            return Constants.ERROR;
        }
    }
}
