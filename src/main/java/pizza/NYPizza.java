package pizza;

import pizza.properties.Crust;
import pizza.properties.Pizza;


/**
 * Implements a New York Style Pizza. Implements from Pizza Factory which allows for either Deluxe, Meatzza, BBQChicken, or BuildYourOwnPizza
 * to be created in New York Crust Style.
 * @author Hasnain Ali, Carolette Saguil
 */
public class NYPizza implements PizzaFactory {
    /**
     * @return A Deluxe Chicago Style Pizza
     */
    @Override
    public Pizza createDeluxe() {
        return new Deluxe(Crust.BROOKLYN);
    }

    /**
     * @return A Meatzza Chicago Style Pizza
     */
    @Override
    public Pizza createMeatzza() {
        return new Meatzza(Crust.THIN);
    }

    /**
     * @return A BBQChicken Chicago Style Pizza
     */
    @Override
    public Pizza createBBQChicken() {
        return new BBQChicken(Crust.HAND_TOSSED);
    }

    /**
     * @return A BuildYourOwn Chicago Style Pizza
     */
    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.HAND_TOSSED);
    }
}