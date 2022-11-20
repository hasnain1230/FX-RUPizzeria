package pizza;

import constants.Constants;
import pizza.properties.Crust;
import pizza.properties.Pizza;
import pizza.properties.Size;
import pizza.properties.Topping;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {

    public BuildYourOwn(Crust crust) {
        super(crust);
    }

    @Override
    public double price() {
        ArrayList<Topping> toppings = getToppings();

        if (super.getSize() == Size.SMALL) {
            return Constants.SMALL_BUILD_YOUR_OWN + (toppings.size() * Constants.ADDITIONAL_TOPPING_COST);
        } else if (super.getSize() == Size.MEDIUM) {
            return Constants.MEDIUM_BUILD_YOUR_OWN + (toppings.size() * Constants.ADDITIONAL_TOPPING_COST);
        } else if (super.getSize() == Size.LARGE) {
            return Constants.LARGE_BUILD_YOUR_OWN + (toppings.size() * Constants.ADDITIONAL_TOPPING_COST);
        } else {
            return Constants.ERROR;
        }
    }
}
