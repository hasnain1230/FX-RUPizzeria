package fxrupizzeria;

import constants.Constants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import orders.Order;
import pizza.properties.Pizza;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is a controller class for the Store Orders View of the RU Pizzeria Application. It will handle all ActionEvents, button clicks, and any other
 * behavior that the user can interact with. This class will also handle the logic of the application. This class implements initializable
 * in order to initialize the basic state of the application upon start.
 * @author Hasnain Ali, Carolette Saguil
 */
public class StoreOrdersViewController implements Initializable {
    /**
     * This is the order number combo box for store orders view. This will be initialized upon start when the initialize method is called.
     */
    @FXML
    private ComboBox<Integer> orderNumberComboBox;
    /**
     * This is the order total text field for store orders view.
     */
    @FXML
    private TextField orderTotalTextField;
    /**
     * This is the store order list view for store orders view.
     */
    @FXML
    private ListView<Pizza> storeOrderListView;
    /**
     * This is the text area where all the store order output will be displayed.
     */
    @FXML
    private TextArea outputStoreOrdersTextArea;

    /**
     * This method gets all the orders in store orders and initializes the order number combo box for the GUI.
     * It will be called automatically upon the start of the program.
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Order order : RUPizzeriaViewController.getStoreOrders().getOrders().values()) {
            this.orderNumberComboBox.getItems().add(order.getOrderID());
        }
    }

    /**
     * This updates the stages, including: order total text field and store order list view,
     * when the user chooses different orders in the order number combo box.
     */
    @FXML
    protected void updateStage() {
        this.storeOrderListView.getItems().clear();
        Integer currentOrderID = this.orderNumberComboBox.getValue();
        double subTotal = Constants.EMPTY_SUBTOTAL;

        for (Order order : RUPizzeriaViewController.getStoreOrders().getOrders().values()) {
            if (((Integer) order.getOrderID()).equals(currentOrderID)) {
                for (Pizza pizza : order.getPizzasInOrder()) {
                    this.storeOrderListView.getItems().add(pizza);
                    subTotal += pizza.price();
                }
                break;
            }
        }

        this.orderTotalTextField.setText(String.format("$ %.2f", subTotal * Constants.CALCULATED_SALES_TAX));
    }

    /**
     * This cancels an order in store orders.
     * Fails if: user does not select order to cancel or store orders are empty
     */
    @FXML
    protected void cancelOrder() {

        if(this.orderNumberComboBox.getValue() == null) {
            this.outputStoreOrdersTextArea.appendText("Cannot cancel unselected order.\n");
            return;
        }

        Integer currentOrderID = this.orderNumberComboBox.getValue();
        RUPizzeriaViewController.getStoreOrders().getOrders().remove(currentOrderID);
        this.orderNumberComboBox.getItems().remove(currentOrderID);
        this.orderNumberComboBox.setValue(null);
        this.storeOrderListView.getItems().clear();

        this.outputStoreOrdersTextArea.appendText("Order " + currentOrderID + " has been cancelled.\n");
    }

    /**
     * This exports the store orders to an external file, location is given to user in output text area.
     */
    @FXML
    protected void exportOrder() {
        this.outputStoreOrdersTextArea.appendText(String.format("All orders have been exported to %s", RUPizzeriaViewController.getStoreOrders().export()));
    }
}