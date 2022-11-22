package fxrupizzeria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import orders.Order;
import orders.StoreOrders;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is a controller class the RU Pizzeria Application. It will handle all ActionEvents, button clicks, and any other
 * behavior that the user can interact with. This class implements initializable in order to initialize the basic state of the application upon start.
 * @author Hasnain Ali, Carolette Saguil
 */
public class RUPizzeriaViewController implements Initializable {

    /**
     * This is the stage that will open when a button is clicked.
     */
    private Stage stage;

    /**
     * The order that is currently being added.
     */
    private static Order currentOrder;

    /**
     * This is the database of store orders.
     */
    private static StoreOrders storeOrders;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentOrder = new Order();
        storeOrders = new StoreOrders();
    }

    /**
     * @return Returns the current order.
     */
    public static Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * Creates new order.
     */
    public static void setNewOrder() {
        currentOrder = new Order();
    }

    /**
     * @return Returns the store orders.
     */
    public static StoreOrders getStoreOrders() {
        return storeOrders;
    }

    /**
     * Loads the Chicago view in a new window. While this view is open, user cannot open another view until they exit this view.
     * @throws IOException
     */
    @FXML
    protected void loadChicago() throws IOException {
        if (stage == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RUPizzeriaViewController.class.getResource("ChicagoView.fxml"));
            Parent rootPane = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setOnHiding(we -> stage = null);
            stage.setTitle("Chicago Style Pizza");
            stage.setScene(new Scene(rootPane));
            stage.show();
        } else {
            stage.toFront();
        }
    }

    /**
     * Loads the NY view in a new window. While this view is open, user cannot open another view until they exit this view.
     * @throws IOException
     */
    @FXML
    protected void loadNy() throws IOException {
        if (stage == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RUPizzeriaViewController.class.getResource("NYView.fxml"));
            Parent rootPane = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setOnHiding(we -> stage = null);
            stage.setTitle("New York Style Pizza");
            stage.setScene(new Scene(rootPane));
            stage.show();
        } else {
            stage.toFront();
        }
    }

    /**
     * Loads the Store Orders view in a new window. While this view is open, user cannot open another view until they exit this view.
     * @throws IOException
     */
    @FXML
    protected void loadStoreOrders() throws IOException {
        if (stage == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RUPizzeriaViewController.class.getResource("StoreOrdersView.fxml"));
            Parent rootPane = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.setOnHiding(we -> stage = null);
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(rootPane));
            stage.show();
        } else {
            stage.toFront();
        }
    }

    /**
     * Loads the Current Order view in a new window. While this view is open, user cannot open another view until they exit this view.
     * @throws IOException
     */
    @FXML
    protected void loadCurrentOrder() throws IOException {
        if (stage == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RUPizzeriaViewController.class.getResource("CurrentOrderView.fxml"));
            Parent rootPane = fxmlLoader.load();
            stage = new Stage();
            stage.setOnHiding(we -> stage = null);
            stage.setTitle("Current Order");
            stage.setScene(new Scene(rootPane));
            stage.show();
        } else {
            stage.toFront();
        }
    }
}