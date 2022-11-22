package fxrupizzeria;

import constants.Constants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import orders.Order;
import pizza.properties.Pizza;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is a controller class for the Current Order View of the RU Pizzeria Application. It will handle all ActionEvents, button clicks, and any other
 * behavior that the user can interact with. This class will also handle the logic of the application. This class implements initializable
 * in order to initialize the basic state of the application upon start.
 * @author Hasnain Ali, Carolette Saguil
 */
public class CurrentOrderViewController implements Initializable {
    /**
     * This is the order number text field for current order view. This will be initialized upon start when the initialize method is called.
     */
    @FXML
    private TextField orderNumberTextField;
    /**
     * This is the orders list view for current order view. This will be initialized upon start when the initialize method is called.
     */
    @FXML
    private ListView<Pizza> ordersListView;
    /**
     * This is the subtotal text field for current order view. This will be initialized upon start when the initialize method is called.
     */
    @FXML
    private TextField subtotalTextField;
    /**
     * This is the sales tax text field for current order view. This will be initialized upon start when the initialize method is called.
     */
    @FXML
    private TextField salesTaxTextField;
    /**
     * This is the order total text field for current order view. This will be initialized upon start when the initialize method is called.
     */
    @FXML
    private TextField orderTotalTextField;
    /**
     * This is the text area where all the program output will be displayed.
     */
    @FXML
    private TextArea outputCurrentOrderTextArea;

    /**
     * This is the current order.
     */
    private Order currentOrder;

    /**
     * This method will initialize the current order, order number text field, subtotal text field, sales tax text field,
     * and order total text field for the GUI. It will be called automatically upon the start of the program.
     * @param arg0 The location used to resolve relative paths for the root object, or
     *             {@code null} if the location is not known.
     * @param arg1 The resources used to localize the root object, or {@code null} if
     *             the root object was not localized.
     */
    @FXML
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        currentOrder = RUPizzeriaViewController.getCurrentOrder();
        this.orderNumberTextField.setText(String.valueOf(currentOrder.getOrderID()));
        double subtotal = Constants.EMPTY_SUBTOTAL;
        double salesTax;

        for (Pizza pizza : currentOrder.getPizzasInOrder()) {
            this.ordersListView.getItems().add(pizza);
            subtotal += pizza.price();
        }

        salesTax = subtotal * (Constants.SALES_TAX);

        this.subtotalTextField.setText(String.format("$ %.2f", subtotal));
        this.salesTaxTextField.setText(String.format("$ %.2f", salesTax));

        this.orderTotalTextField.setText(String.format("$ %.2f", subtotal + salesTax));
    }

    /**
     * Recalculates subtotal, sales tax, and order total. Updates text fields accordingly.
     */
    private void recalculateTotals() {
        double subtotal = Constants.EMPTY_SUBTOTAL;
        double salesTax;

        for (Pizza pizza : currentOrder.getPizzasInOrder()) {
            subtotal += pizza.price();
        }

        salesTax = subtotal * (Constants.SALES_TAX);

        this.subtotalTextField.setText(String.format("$ %.2f", subtotal));
        this.salesTaxTextField.setText(String.format("$ %.2f", salesTax));

        this.orderTotalTextField.setText(String.format("$ %.2f", subtotal + salesTax));
    }

    /**
     * Removes a pizza from the current order.
     * Fails if: no pizza is selected to remove or current order is empty
     */
    @FXML
    protected void removePizza() {
        Pizza itemToRemove = this.ordersListView.getSelectionModel().getSelectedItem();

        if (itemToRemove == null || this.ordersListView.getItems().isEmpty()) {
            this.outputCurrentOrderTextArea.appendText("No Pizza To Remove\n");
            return;
        }

        this.ordersListView.getItems().remove(itemToRemove);
        this.currentOrder.getPizzasInOrder().remove(itemToRemove);

        this.recalculateTotals();

        this.outputCurrentOrderTextArea.appendText("Removed The Pizza\n");
    }

    /**
     * Clears the current order.
     * Fails if: current order is empty
     */
    @FXML
    protected void clearOrder() {
        if (this.currentOrder.getPizzasInOrder().isEmpty()) {
            this.outputCurrentOrderTextArea.appendText("No Order To Clear\n");
            return;
        }
        this.ordersListView.getItems().clear();
        this.currentOrder.getPizzasInOrder().clear();
        this.recalculateTotals();
    }

    /**
     * Places the current order.
     * Fails if: current order is empty
     */
    @FXML
    protected void placeOrder() {
        if (this.currentOrder.getPizzasInOrder().isEmpty()) {
            this.outputCurrentOrderTextArea.appendText("No Order To Place\n");
            return;
        }

        Order placedOrder = new Order(this.currentOrder);
        RUPizzeriaViewController.getStoreOrders().add(placedOrder);
        this.clearOrder();
        RUPizzeriaViewController.setNewOrder();

        this.outputCurrentOrderTextArea.appendText("Placed The Order\n");
    }
}