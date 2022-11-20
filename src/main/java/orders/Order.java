package orders;

import pizza.properties.Customizable;
import pizza.properties.Pizza;

import java.util.HashSet;
import java.util.UUID;

public class Order implements Customizable {
    private static int orderNumber;
    private final int orderID;
    private final HashSet<Pizza> pizzasInOrder;

    public Order() {
        this.orderID = orderNumber++;
        this.pizzasInOrder = new HashSet<>();
    }

    public int getOrderID() {
        return this.orderID;
    }

    public HashSet<Pizza> getPizzasInOrder() {
        return this.pizzasInOrder;
    }

    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Pizza) {
            this.pizzasInOrder.add((Pizza) obj);
            return true;
        }

        return false;
    }

    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Pizza) {
            this.pizzasInOrder.remove((Pizza) obj);
            return true;
        }

        return false;
    }
}
