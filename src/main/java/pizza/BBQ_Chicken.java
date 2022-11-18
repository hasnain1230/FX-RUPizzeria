package pizza;

import pizza_properties.Pizza;

public class BBQ_Chicken extends Pizza {
    public BBQ_Chicken() {
        super("BBQ Chicken", 10.99);
        super.addTopping(new Topping("Chicken", 1.99));
        super.addTopping(new Topping("BBQ Sauce", 0.99));
    }

    /**
     * @return
     */
    @Override
    public double price() {
        return 0;
    }
}
