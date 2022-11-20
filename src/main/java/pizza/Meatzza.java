package pizza;

import constants.Constants;
import pizza.properties.Crust;
import pizza.properties.Pizza;
import pizza.properties.Size;

public class Meatzza extends Pizza {
    public Meatzza(Crust crust) {
        super(crust);
    }


    /**
     * @return
     */
    @Override
    public double price() {
        if (super.getSize() == Size.SMALL) {
            return Constants.SMALL_MEATZZA;
        } else if (super.getSize() == Size.MEDIUM) {
            return Constants.MEDIUM_MEATZZA;
        } else if (super.getSize() == Size.LARGE) {
            return Constants.LARGE_MEATZZA;
        } else {
            return Constants.ERROR;
        }
    }
}
