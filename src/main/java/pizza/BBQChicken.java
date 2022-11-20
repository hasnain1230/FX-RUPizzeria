package pizza;

import constants.Constants;
import pizza.properties.Crust;
import pizza.properties.Pizza;
import pizza.properties.Size;

public class BBQChicken extends Pizza {
    public BBQChicken(Crust crust) {
        super(crust);
    }


    /**
     * @return
     */
    @Override
    public double price() {
        if (super.getSize() == Size.SMALL) {
            return Constants.SMALL_BBQ_CHICKEN;
        } else if (super.getSize() == Size.MEDIUM) {
            return Constants.MEDIUM_BBQ_CHICKEN;
        } else if (super.getSize() == Size.LARGE) {
            return Constants.LARGE_BBQ_CHICKEN;
        } else {
            return Constants.ERROR;
        }
    }
}
