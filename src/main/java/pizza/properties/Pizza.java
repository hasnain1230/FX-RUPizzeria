package pizza.properties;

import java.util.ArrayList;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    public Pizza(Crust crust) {
        this.toppings = new ArrayList<>();
        this.crust = crust;
    }
    public boolean add(Object obj) {
        if (obj instanceof Topping) {
            this.toppings.add((Topping) obj);
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
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Crust getCrust() {
        return this.crust;
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    public Size getSize() {
        return this.size;
    }

    public abstract double price();

    @Override
    public String toString() {
        return String.format("Size: %s, Crust: %s, Toppings: %s", this.size, this.crust, this.toppings.toString());
    }
}

