package orders;

import pizza.properties.Customizable;
import pizza.properties.Pizza;

import java.io.*;
import java.util.HashSet;


/**
 * Encapsulation that stores all the orders placed in the {@code FX-RUPizzeria} store
 * @authors Hasnain Ali, Carolette Saguil
 */
public class StoreOrders implements Customizable {
    /**
     * Using a HashSet for all the orders in case we want quick look up times for a specific order.
     */
    private final HashSet<Order> orders;

    /**
     * Constructor that initializes the HashSet for {@code orders}.
     */
    public StoreOrders() {
        this.orders = new HashSet<>();
    }

    /**
     * This method will take all current orders and write them into a file.
     * @return A String with the file path of where {@code orders.export} was written.
     */
    public String export() {
        try {
            File fileToWrite = new File("./orders.export");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite));

            for (Order order : this.orders) {
                StringBuilder outputString = new StringBuilder();
                outputString.append(String.format("Order ID: %d", order.getOrderID()));
                double totalPrice = 0.0;

                for (Pizza pizza : order.getPizzasInOrder()) {
                    outputString.append(String.format("\t%s\n", pizza.toString()));
                    totalPrice += pizza.price();
                }

                bufferedWriter.write(outputString.toString());
                bufferedWriter.write(String.format("Total Price: $%.2f\n", totalPrice));
            }

            return fileToWrite.getAbsolutePath();

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return null;
    }

    /**
     * @param obj An order to add into {@code StoreOrders}.
     * @return Whether the order was successfully added into {@code StoreOrders}.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            this.orders.add((Order) obj);
            return true;
        }

        return false;
    }

    /**
     * @param obj An order to remove from {@code StoreOrders}.
     * @return Whether the order was successfully removed from {@code StoreOrders}.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            this.orders.remove((Order) obj);
            return true;
        }

        return false;
    }
}
