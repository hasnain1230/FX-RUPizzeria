package orders;

import pizza.NYPizza;
import pizza.properties.Customizable;
import pizza.properties.Pizza;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.OptionalDouble;
import java.util.Scanner;

public class StoreOrders implements Customizable {
    private final HashSet<Order> orders;

    public StoreOrders() {
        this.orders = new HashSet<>();
    }

    public String export() { // FIXME: BRUH
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
     * @param obj 
     * @return
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
     * @param obj 
     * @return
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
