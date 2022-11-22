package tests;

import constants.Constants;
import org.junit.jupiter.api.Test;
import pizza.ChicagoPizza;
import pizza.NYPizza;
import pizza.PizzaFactory;
import pizza.properties.Crust;
import pizza.properties.Pizza;
import pizza.properties.Size;
import pizza.properties.Topping;

import static org.junit.jupiter.api.Assertions.*;

class BuildYourOwnTest {

    @Test
    void add() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);

        assertTrue(chicagoPizza.add(Topping.BACON));
        assertTrue(chicagoPizza.add(Topping.HAM));

        assertFalse(chicagoPizza.add("bacon"));

        Topping[] chicagoExpectedOutput = {Topping.BACON, Topping.HAM};
        Topping[] chicagoActualOutput = chicagoPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(chicagoExpectedOutput, chicagoActualOutput);

        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);

        assertTrue(nyPizza.add(Topping.BACON));
        assertTrue(nyPizza.add(Topping.HAM));

        assertFalse(nyPizza.add("pineapple"));

        Topping[] nyExpectedOutput = {Topping.BACON, Topping.HAM};
        Topping[] nyActualOutput = nyPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(nyExpectedOutput, nyActualOutput);
    }

    @Test
    void remove() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);
        chicagoPizza.add(Topping.BACON);
        chicagoPizza.add(Topping.HAM);
        chicagoPizza.add(Topping.PINEAPPLE);

        assertTrue(chicagoPizza.remove(Topping.PINEAPPLE));
        assertTrue(chicagoPizza.remove(Topping.HAM));

        assertFalse(chicagoPizza.remove("bacon"));

        Topping[] chicagoExpectedOutput = {Topping.BACON};
        Topping[] chicagoActualOutput = chicagoPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(chicagoExpectedOutput, chicagoActualOutput);

        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);
        nyPizza.add(Topping.BACON);
        nyPizza.add(Topping.HAM);
        nyPizza.add(Topping.PINEAPPLE);

        assertTrue(nyPizza.remove(Topping.BACON));
        assertTrue(nyPizza.remove(Topping.HAM));

        assertFalse(nyPizza.remove("pineapple"));

        Topping[] nyExpectedOutput = {Topping.PINEAPPLE};
        Topping[] nyActualOutput = nyPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(nyExpectedOutput, nyActualOutput);
    }

    @Test
    void setSize() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);
        Size expectedOutput1 = Size.SMALL;
        Size actualOutput1 = chicagoPizza.getSize();
        assertEquals(expectedOutput1, actualOutput1);

        chicagoPizza.setSize(Size.MEDIUM);
        Size expectedOutput2 = Size.MEDIUM;
        Size actualOutput2 = chicagoPizza.getSize();
        assertEquals(expectedOutput2, actualOutput2);

        chicagoPizza.setSize(Size.LARGE);
        Size expectedOutput3 = Size.LARGE;
        Size actualOutput3 = chicagoPizza.getSize();
        assertEquals(expectedOutput3, actualOutput3);
        
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);
        Size expectedOutput4 = Size.SMALL;
        Size actualOutput4 = nyPizza.getSize();
        assertEquals(expectedOutput4, actualOutput4);

        nyPizza.setSize(Size.MEDIUM);
        Size expectedOutput5 = Size.MEDIUM;
        Size actualOutput5 = nyPizza.getSize();
        assertEquals(expectedOutput5, actualOutput5);

        nyPizza.setSize(Size.LARGE);
        Size expectedOutput6 = Size.LARGE;
        Size actualOutput6 = nyPizza.getSize();
        assertEquals(expectedOutput6, actualOutput6);
    }

    @Test
    void getCrust() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);
        Crust chicagoExpectedOutput = Crust.PAN;
        Crust chicagoActualOutput = chicagoPizza.getCrust();
        assertEquals(chicagoExpectedOutput, chicagoActualOutput);

        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);
        Crust nyExpectedOutput = Crust.HAND_TOSSED;
        Crust nyActualOutput = nyPizza.getCrust();
        assertEquals(nyExpectedOutput, nyActualOutput);
    }

    @Test
    void getToppings() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);
        chicagoPizza.add(Topping.BACON);
        chicagoPizza.add(Topping.HAM);
        chicagoPizza.add(Topping.PINEAPPLE);

        Topping[] chicagoExpectedOutput1 = {Topping.BACON, Topping.HAM, Topping.PINEAPPLE};
        Topping[] chicagoActualOutput1 = chicagoPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(chicagoExpectedOutput1, chicagoActualOutput1);

        chicagoPizza.remove(Topping.PINEAPPLE);

        Topping[] chicagoExpectedOutput2 = {Topping.BACON, Topping.HAM};
        Topping[] chicagoActualOutput2 = chicagoPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(chicagoExpectedOutput2, chicagoActualOutput2);

        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);
        nyPizza.add(Topping.BACON);
        nyPizza.add(Topping.HAM);
        nyPizza.add(Topping.PINEAPPLE);

        Topping[] nyExpectedOutput1 = {Topping.BACON, Topping.HAM, Topping.PINEAPPLE};
        Topping[] nyActualOutput1 = nyPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(nyExpectedOutput1, nyActualOutput1);

        nyPizza.remove(Topping.PINEAPPLE);

        Topping[] nyExpectedOutput2 = {Topping.BACON, Topping.HAM};
        Topping[] nyActualOutput2 = nyPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(nyExpectedOutput2, nyActualOutput2);
    }

    @Test
    void getSize() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);
        Size expectedOutput1 = Size.SMALL;
        Size actualOutput1 = chicagoPizza.getSize();
        assertEquals(expectedOutput1, actualOutput1);

        chicagoPizza.setSize(Size.MEDIUM);
        Size expectedOutput2 = Size.MEDIUM;
        Size actualOutput2 = chicagoPizza.getSize();
        assertEquals(expectedOutput2, actualOutput2);

        chicagoPizza.setSize(Size.LARGE);
        Size expectedOutput3 = Size.LARGE;
        Size actualOutput3 = chicagoPizza.getSize();
        assertEquals(expectedOutput3, actualOutput3);

        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);
        Size expectedOutput4 = Size.SMALL;
        Size actualOutput4 = nyPizza.getSize();
        assertEquals(expectedOutput4, actualOutput4);

        nyPizza.setSize(Size.MEDIUM);
        Size expectedOutput5 = Size.MEDIUM;
        Size actualOutput5 = nyPizza.getSize();
        assertEquals(expectedOutput5, actualOutput5);

        nyPizza.setSize(Size.LARGE);
        Size expectedOutput6 = Size.LARGE;
        Size actualOutput6 = nyPizza.getSize();
        assertEquals(expectedOutput6, actualOutput6);
    }

    @Test
    void testToString() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);

        String expectedOutput = String.format("Chicago Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
        Size.SMALL, Crust.PAN, Constants.SMALL_BUILD_YOUR_OWN);
        String actualOutput = chicagoPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        chicagoPizza.setSize(Size.MEDIUM);

        expectedOutput = String.format("Chicago Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.MEDIUM, Crust.PAN, Constants.MEDIUM_BUILD_YOUR_OWN);
        actualOutput = chicagoPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        chicagoPizza.setSize(Size.LARGE);

        expectedOutput = String.format("Chicago Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.LARGE, Crust.PAN, Constants.LARGE_BUILD_YOUR_OWN);
        actualOutput = chicagoPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        chicagoPizza.add(Topping.CHEDDAR);

        expectedOutput = String.format("Chicago Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [%s] Price: $ %.2f",
                Size.LARGE, Crust.PAN, Topping.CHEDDAR, Constants.LARGE_BUILD_YOUR_OWN + Constants.ADDITIONAL_TOPPING_COST);
        actualOutput = chicagoPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);

        expectedOutput = String.format("New York Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.SMALL, Crust.HAND_TOSSED, Constants.SMALL_BUILD_YOUR_OWN);
        actualOutput = nyPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        nyPizza.setSize(Size.MEDIUM);

        expectedOutput = String.format("New York Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.MEDIUM, Crust.HAND_TOSSED, Constants.MEDIUM_BUILD_YOUR_OWN);
        actualOutput = nyPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        nyPizza.setSize(Size.LARGE);

        expectedOutput = String.format("New York Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.LARGE, Crust.HAND_TOSSED, Constants.LARGE_BUILD_YOUR_OWN);
        actualOutput = nyPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        nyPizza.add(Topping.CHEDDAR);

        expectedOutput = String.format("New York Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [%s] Price: $ %.2f",
                Size.LARGE, Crust.HAND_TOSSED, Topping.CHEDDAR, Constants.LARGE_BUILD_YOUR_OWN + Constants.ADDITIONAL_TOPPING_COST);
        actualOutput = nyPizza.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void price() {
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);

        Double expectedOutput1 = Constants.SMALL_BUILD_YOUR_OWN;
        Double actualOutput1 = chicagoPizza.price();
        assertEquals(expectedOutput1, actualOutput1);

        chicagoPizza.setSize(Size.MEDIUM);

        Double expectedOutput2 = Constants.MEDIUM_BUILD_YOUR_OWN;
        Double actualOutput2 = chicagoPizza.price();
        assertEquals(expectedOutput2, actualOutput2);

        chicagoPizza.setSize(Size.LARGE);

        Double expectedOutput3 = Constants.LARGE_BUILD_YOUR_OWN;
        Double actualOutput3 = chicagoPizza.price();
        assertEquals(expectedOutput3, actualOutput3);

        chicagoPizza.add(Topping.CHEDDAR);

        Double expectedOutput4 = Constants.LARGE_BUILD_YOUR_OWN + Constants.ADDITIONAL_TOPPING_COST;
        Double actualOutput4 = chicagoPizza.price();
        assertEquals(expectedOutput4, actualOutput4);

        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);

        Double expectedOutput5 = Constants.SMALL_BUILD_YOUR_OWN;
        Double actualOutput5 = nyPizza.price();
        assertEquals(expectedOutput5, actualOutput5);

        nyPizza.setSize(Size.MEDIUM);

        Double expectedOutput6 = Constants.MEDIUM_BUILD_YOUR_OWN;
        Double actualOutput6 = nyPizza.price();
        assertEquals(expectedOutput6, actualOutput6);

        nyPizza.setSize(Size.LARGE);

        Double expectedOutput7 = Constants.LARGE_BUILD_YOUR_OWN;
        Double actualOutput7 = nyPizza.price();
        assertEquals(expectedOutput7, actualOutput7);

        nyPizza.add(Topping.CHEDDAR);

        Double expectedOutput8 = Constants.LARGE_BUILD_YOUR_OWN + Constants.ADDITIONAL_TOPPING_COST;
        Double actualOutput8 = nyPizza.price();
        assertEquals(expectedOutput8, actualOutput8);
    }
}