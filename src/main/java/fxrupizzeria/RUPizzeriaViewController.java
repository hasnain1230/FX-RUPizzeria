package fxrupizzeria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RUPizzeriaViewController{

    private Stage stage;

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

    @FXML
    protected void loadCurrentOrder() throws IOException {
        if (stage == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RUPizzeriaViewController.class.getResource("CurrentOrderView.fxml"));
            Parent rootPane = (Parent) fxmlLoader.load();
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