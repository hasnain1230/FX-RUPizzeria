package pizza_properties;

import java.util.ArrayList;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

/*    public boolean add(Object obj) {
        if (obj instanceof Topping) {
            toppings.add((Topping) obj);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        if (obj instanceof Topping) {
            toppings.remove((Topping) obj);
            return true;
        }
        return false;
    }*/

    public abstract double price();
}

