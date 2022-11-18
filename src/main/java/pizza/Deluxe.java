package pizza;

import pizza_properties.Pizza;
import pizza_properties.Size;
import pizza_properties.Topping;

import java.util.ArrayList;

public class Deluxe extends Pizza {
    public Deluxe() {
        super();
        super.toppings.add(Topping.SAUSAGE);

    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public double price() {
        return 0;
    }
}
