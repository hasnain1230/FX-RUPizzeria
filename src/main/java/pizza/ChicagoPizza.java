package pizza;

import pizza.properties.Crust;
import pizza.properties.Pizza;
import pizza.properties.Size;

public class ChicagoPizza implements PizzaFactory {
    private final Size pizzaSize;

    public ChicagoPizza(Size pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    /**
     * @return 
     */
    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Crust.DEEP_DISH);
    }

    /**
     * @return 
     */
    @Override
    public Pizza createMeatzza() {
        return new Deluxe(Crust.PAN);
    }

    /**
     * @return 
     */
    @Override
    public Pizza createBBQChicken() {
        return new Deluxe(Crust.STUFFED);
    }

    /**
     * @return 
     */
    @Override
    public Pizza createBuildYourOwn() {
        return new Deluxe(Crust.PAN);
    }
}
