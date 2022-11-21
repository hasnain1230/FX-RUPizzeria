package pizza;

import constants.Constants;
import pizza.properties.Crust;
import pizza.properties.Pizza;
import pizza.properties.Size;

/**
 * This class is an encapsulation for any type of Meatzza used in {@code FX-RUPizzeria}. Depending on the Crust Style,
 * this class can account for any type of Meatzza Pizza. It inherits from {@code Pizza.java}.
 * @author Hasnain Ali, Carolette Saguil
 */
public class Meatzza extends Pizza {
    /**
     * @param crust The type of crust for the Pizza.
     */
    public Meatzza(Crust crust) {
        super(crust);
    }

    /**
     * @return The price of the Pizza depending on the size. Error if no size is defined.
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
