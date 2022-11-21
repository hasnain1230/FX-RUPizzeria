package pizza;

import orders.Order;
import pizza.properties.Crust;
import pizza.properties.Pizza;
import pizza.properties.Size;
import pizza.properties.Topping;

public class NYPizza implements PizzaFactory {
    /**
     * @return
     */
    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Crust.BROOKLYN);
    }

    /**
     * @return
     */
    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Crust.THIN);
    }

    /**
     * @return
     */
    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.HAND_TOSSED);
    }

    /**
     * @return
     */
    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.HAND_TOSSED);
    }
}