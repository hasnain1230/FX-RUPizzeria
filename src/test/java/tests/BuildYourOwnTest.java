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
        //Test Cases for chicago pizza
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);

        //Test case 1: add valid input and check if it returns true
        assertTrue(chicagoPizza.add(Topping.BACON));
        assertTrue(chicagoPizza.add(Topping.HAM));

        //Test case 2: add invalid input and check if it returns false
        assertFalse(chicagoPizza.add("bacon"));

        //Test case 3: check if toppings were added correctly by seeing if topping array is equal
        Topping[] chicagoExpectedOutput = {Topping.BACON, Topping.HAM};
        Topping[] chicagoActualOutput = chicagoPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(chicagoExpectedOutput, chicagoActualOutput);

        //Test cases for NY pizza
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);

        //Test case 1: add valid input and check if it returns true
        assertTrue(nyPizza.add(Topping.BACON));
        assertTrue(nyPizza.add(Topping.HAM));

        //Test case 2: add invalid input and check if it returns false
        assertFalse(nyPizza.add("pineapple"));

        //Test case 3: check if toppings were added correctly by seeing if topping array is equal
        Topping[] nyExpectedOutput = {Topping.BACON, Topping.HAM};
        Topping[] nyActualOutput = nyPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(nyExpectedOutput, nyActualOutput);
    }

    @Test
    void remove() {
        //Test cases for chicago pizza
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);
        chicagoPizza.add(Topping.BACON);
        chicagoPizza.add(Topping.HAM);
        chicagoPizza.add(Topping.PINEAPPLE);

        //Test case 1: added valid inputs beforehand, now remove valid inputs and check if it returns true
        assertTrue(chicagoPizza.remove(Topping.PINEAPPLE));
        assertTrue(chicagoPizza.remove(Topping.HAM));

        //Test case 2: try to remove invalid input and check if it returns false
        assertFalse(chicagoPizza.remove("bacon"));

        //Test case 3: check if toppings were removed correctly by seeing if topping array is equal
        Topping[] chicagoExpectedOutput = {Topping.BACON};
        Topping[] chicagoActualOutput = chicagoPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(chicagoExpectedOutput, chicagoActualOutput);

        //Test cases for ny pizza
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);
        nyPizza.add(Topping.BACON);
        nyPizza.add(Topping.HAM);
        nyPizza.add(Topping.PINEAPPLE);

        //Test case 1: added valid inputs beforehand, now remove valid inputs and check if it returns true
        assertTrue(nyPizza.remove(Topping.BACON));
        assertTrue(nyPizza.remove(Topping.HAM));

        //Test case 2: try to remove invalid input and check if it returns false
        assertFalse(nyPizza.remove("pineapple"));

        //Test case 3: check if toppings were removed correctly by seeing if topping array is equal
        Topping[] nyExpectedOutput = {Topping.PINEAPPLE};
        Topping[] nyActualOutput = nyPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(nyExpectedOutput, nyActualOutput);
    }

    @Test
    void setSize() {
        //Test cases for chicago pizza
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();

        //Test case 1: set size to small and check if the get size return small
        chicagoPizza.setSize(Size.SMALL);
        Size expectedOutput1 = Size.SMALL;
        Size actualOutput1 = chicagoPizza.getSize();
        assertEquals(expectedOutput1, actualOutput1);

        //Test case 2: set size to medium and check if the get size return medium
        chicagoPizza.setSize(Size.MEDIUM);
        Size expectedOutput2 = Size.MEDIUM;
        Size actualOutput2 = chicagoPizza.getSize();
        assertEquals(expectedOutput2, actualOutput2);

        //Test case 3: set size to large and check if the get size return large
        chicagoPizza.setSize(Size.LARGE);
        Size expectedOutput3 = Size.LARGE;
        Size actualOutput3 = chicagoPizza.getSize();
        assertEquals(expectedOutput3, actualOutput3);

        //Test cases for ny pizza
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();

        //Test case 1: set size to small and check if the get size return small
        nyPizza.setSize(Size.SMALL);
        Size expectedOutput4 = Size.SMALL;
        Size actualOutput4 = nyPizza.getSize();
        assertEquals(expectedOutput4, actualOutput4);

        //Test case 2: set size to medium and check if the get size return medium
        nyPizza.setSize(Size.MEDIUM);
        Size expectedOutput5 = Size.MEDIUM;
        Size actualOutput5 = nyPizza.getSize();
        assertEquals(expectedOutput5, actualOutput5);

        //Test case 3: set size to large and check if the get size return large
        nyPizza.setSize(Size.LARGE);
        Size expectedOutput6 = Size.LARGE;
        Size actualOutput6 = nyPizza.getSize();
        assertEquals(expectedOutput6, actualOutput6);
    }

    @Test
    void getCrust() {
        //Test cases for chicago pizza
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);

        //Test case: check if getCrust return pan
        Crust chicagoExpectedOutput = Crust.PAN;
        Crust chicagoActualOutput = chicagoPizza.getCrust();
        assertEquals(chicagoExpectedOutput, chicagoActualOutput);

        //Test cases for ny pizza
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);

        //Test case: check if getCrust return pan
        Crust nyExpectedOutput = Crust.HAND_TOSSED;
        Crust nyActualOutput = nyPizza.getCrust();
        assertEquals(nyExpectedOutput, nyActualOutput);
    }

    @Test
    void getToppings() {
        //test cases for chicago pizza
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();
        chicagoPizza.setSize(Size.SMALL);
        chicagoPizza.add(Topping.BACON);
        chicagoPizza.add(Topping.HAM);
        chicagoPizza.add(Topping.PINEAPPLE);

        //Test case 1: add toppings to pizza and check if topping array is equal
        Topping[] chicagoExpectedOutput1 = {Topping.BACON, Topping.HAM, Topping.PINEAPPLE};
        Topping[] chicagoActualOutput1 = chicagoPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(chicagoExpectedOutput1, chicagoActualOutput1);

        //Test case 2: remove topping from pizza and check if topping array is equal
        chicagoPizza.remove(Topping.PINEAPPLE);

        Topping[] chicagoExpectedOutput2 = {Topping.BACON, Topping.HAM};
        Topping[] chicagoActualOutput2 = chicagoPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(chicagoExpectedOutput2, chicagoActualOutput2);

        //Test cases for ny pizza
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();
        nyPizza.setSize(Size.SMALL);
        nyPizza.add(Topping.BACON);
        nyPizza.add(Topping.HAM);
        nyPizza.add(Topping.PINEAPPLE);

        //Test case 1: add toppings to pizza and check if topping array is equal
        Topping[] nyExpectedOutput1 = {Topping.BACON, Topping.HAM, Topping.PINEAPPLE};
        Topping[] nyActualOutput1 = nyPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(nyExpectedOutput1, nyActualOutput1);

        //Test case 2: remove topping from pizza and check if topping array is equal
        nyPizza.remove(Topping.PINEAPPLE);

        Topping[] nyExpectedOutput2 = {Topping.BACON, Topping.HAM};
        Topping[] nyActualOutput2 = nyPizza.getToppings().toArray(new Topping[0]);
        assertArrayEquals(nyExpectedOutput2, nyActualOutput2);
    }

    @Test
    void getSize() {
        //Test cases for chicago pizza
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();

        //Test case 1: set size to small and check if the get size return small
        chicagoPizza.setSize(Size.SMALL);
        Size expectedOutput1 = Size.SMALL;
        Size actualOutput1 = chicagoPizza.getSize();
        assertEquals(expectedOutput1, actualOutput1);

        //Test case 2: set size to medium and check if the get size return medium
        chicagoPizza.setSize(Size.MEDIUM);
        Size expectedOutput2 = Size.MEDIUM;
        Size actualOutput2 = chicagoPizza.getSize();
        assertEquals(expectedOutput2, actualOutput2);

        //Test case 3: set size to large and check if the get size return large
        chicagoPizza.setSize(Size.LARGE);
        Size expectedOutput3 = Size.LARGE;
        Size actualOutput3 = chicagoPizza.getSize();
        assertEquals(expectedOutput3, actualOutput3);

        //Test cases for ny pizza
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();

        //Test case 1: set size to small and check if the get size return small
        nyPizza.setSize(Size.SMALL);
        Size expectedOutput4 = Size.SMALL;
        Size actualOutput4 = nyPizza.getSize();
        assertEquals(expectedOutput4, actualOutput4);

        //Test case 2: set size to medium and check if the get size return medium
        nyPizza.setSize(Size.MEDIUM);
        Size expectedOutput5 = Size.MEDIUM;
        Size actualOutput5 = nyPizza.getSize();
        assertEquals(expectedOutput5, actualOutput5);

        //Test case 3: set size to large and check if the get size return large
        nyPizza.setSize(Size.LARGE);
        Size expectedOutput6 = Size.LARGE;
        Size actualOutput6 = nyPizza.getSize();
        assertEquals(expectedOutput6, actualOutput6);
    }

    @Test
    void testToString() {
        //Test case for chicago pizza
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();

        //Test case 1: set size to small and check if toString returns expected output
        chicagoPizza.setSize(Size.SMALL);
        String expectedOutput = String.format("Chicago Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
        Size.SMALL, Crust.PAN, Constants.SMALL_BUILD_YOUR_OWN);
        String actualOutput = chicagoPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        //Test case 2: set size to medium and check if toString returns expected output
        chicagoPizza.setSize(Size.MEDIUM);

        expectedOutput = String.format("Chicago Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.MEDIUM, Crust.PAN, Constants.MEDIUM_BUILD_YOUR_OWN);
        actualOutput = chicagoPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        //Test case 3: set size to large and check if toString returns expected output
        chicagoPizza.setSize(Size.LARGE);

        expectedOutput = String.format("Chicago Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.LARGE, Crust.PAN, Constants.LARGE_BUILD_YOUR_OWN);
        actualOutput = chicagoPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        //Test case 4: add topping to large pizza and check if toString returns expected output
        chicagoPizza.add(Topping.CHEDDAR);

        expectedOutput = String.format("Chicago Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [%s] Price: $ %.2f",
                Size.LARGE, Crust.PAN, Topping.CHEDDAR, Constants.LARGE_BUILD_YOUR_OWN + Constants.ADDITIONAL_TOPPING_COST);
        actualOutput = chicagoPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        //Test cases for ny pizza
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();

        //Test case 1: set size to small and check if toString returns expected output
        nyPizza.setSize(Size.SMALL);

        expectedOutput = String.format("New York Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.SMALL, Crust.HAND_TOSSED, Constants.SMALL_BUILD_YOUR_OWN);
        actualOutput = nyPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        //Test case 2: set size to medium and check if toString returns expected output
        nyPizza.setSize(Size.MEDIUM);

        expectedOutput = String.format("New York Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.MEDIUM, Crust.HAND_TOSSED, Constants.MEDIUM_BUILD_YOUR_OWN);
        actualOutput = nyPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        //Test case 3: set size to large and check if toString returns expected output
        nyPizza.setSize(Size.LARGE);

        expectedOutput = String.format("New York Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [] Price: $ %.2f",
                Size.LARGE, Crust.HAND_TOSSED, Constants.LARGE_BUILD_YOUR_OWN);
        actualOutput = nyPizza.toString();
        assertEquals(expectedOutput, actualOutput);

        //Test case 4: add topping to large pizza and check if toString returns expected output
        nyPizza.add(Topping.CHEDDAR);

        expectedOutput = String.format("New York Style (Build Your Own) | Size: %s, Crust: %s, Toppings: [%s] Price: $ %.2f",
                Size.LARGE, Crust.HAND_TOSSED, Topping.CHEDDAR, Constants.LARGE_BUILD_YOUR_OWN + Constants.ADDITIONAL_TOPPING_COST);
        actualOutput = nyPizza.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void price() {
        //Test cases for chicago pizza
        PizzaFactory chicagoPizzaFactory = new ChicagoPizza();
        Pizza chicagoPizza = chicagoPizzaFactory.createBuildYourOwn();

        //Test case 1: set size to small and check if price return price of small build your own pizza (8.99)
        chicagoPizza.setSize(Size.SMALL);

        Double expectedOutput1 = Constants.SMALL_BUILD_YOUR_OWN;
        Double actualOutput1 = chicagoPizza.price();
        assertEquals(expectedOutput1, actualOutput1);

        //Test case 2: set size to medium and check if price return price of medium build your own pizza (10.99)
        chicagoPizza.setSize(Size.MEDIUM);

        Double expectedOutput2 = Constants.MEDIUM_BUILD_YOUR_OWN;
        Double actualOutput2 = chicagoPizza.price();
        assertEquals(expectedOutput2, actualOutput2);

        //Test case 3: set size to large and check if price return price of large build your own pizza (12.99)
        chicagoPizza.setSize(Size.LARGE);

        Double expectedOutput3 = Constants.LARGE_BUILD_YOUR_OWN;
        Double actualOutput3 = chicagoPizza.price();
        assertEquals(expectedOutput3, actualOutput3);

        //Test case 4: add topping to large pizza and check if price return price of large build your own pizza + 1 topping (14.58)
        chicagoPizza.add(Topping.CHEDDAR);

        Double expectedOutput4 = Constants.LARGE_BUILD_YOUR_OWN + Constants.ADDITIONAL_TOPPING_COST;
        Double actualOutput4 = chicagoPizza.price();
        assertEquals(expectedOutput4, actualOutput4);

        //Test cases for ny pizza
        PizzaFactory nyPizzaFactory = new NYPizza();
        Pizza nyPizza = nyPizzaFactory.createBuildYourOwn();

        //Test case 1: set size to small and check if price return price of small build your own pizza (8.99)
        nyPizza.setSize(Size.SMALL);

        Double expectedOutput5 = Constants.SMALL_BUILD_YOUR_OWN;
        Double actualOutput5 = nyPizza.price();
        assertEquals(expectedOutput5, actualOutput5);

        //Test case 2: set size to medium and check if price return price of medium build your own pizza (10.99)
        nyPizza.setSize(Size.MEDIUM);

        Double expectedOutput6 = Constants.MEDIUM_BUILD_YOUR_OWN;
        Double actualOutput6 = nyPizza.price();
        assertEquals(expectedOutput6, actualOutput6);

        //Test case 3: set size to large and check if price return price of large build your own pizza (12.99)
        nyPizza.setSize(Size.LARGE);

        Double expectedOutput7 = Constants.LARGE_BUILD_YOUR_OWN;
        Double actualOutput7 = nyPizza.price();
        assertEquals(expectedOutput7, actualOutput7);

        //Test case 4: add topping to large pizza and check if price return price of large build your own pizza + 1 topping (14.58)
        nyPizza.add(Topping.CHEDDAR);

        Double expectedOutput8 = Constants.LARGE_BUILD_YOUR_OWN + Constants.ADDITIONAL_TOPPING_COST;
        Double actualOutput8 = nyPizza.price();
        assertEquals(expectedOutput8, actualOutput8);
    }
}