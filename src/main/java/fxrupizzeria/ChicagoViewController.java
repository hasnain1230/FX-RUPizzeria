package fxrupizzeria;

import constants.Constants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ChicagoViewController implements Initializable {

    @FXML
    private ListView<String> availableToppings;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField crustTextField;

    @FXML
    private ListView<String> selectedToppings;

    @FXML
    private RadioButton smallRadioButton;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton largeRadioButton;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextArea outputTextArea;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.availableToppings.getItems().addAll(Constants.TOPPINGS);
        this.typeComboBox.getItems().addAll(Constants.TYPES);
        this.typeComboBox.setValue(this.typeComboBox.getItems().get(0));
    }

    private void resetAvailableToppings() {
        this.availableToppings.getItems().clear();
        this.availableToppings.getItems().addAll(Constants.TOPPINGS);
    }

    //TODO: change images when change type
    @FXML
    protected void menuDisplay() {
        if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            resetAvailableToppings();
            this.crustTextField.setText("Pan");
            this.selectedToppings.getItems().clear();
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[1])) {
            resetAvailableToppings();
            this.crustTextField.setText("Deep Dish");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.DELUXE_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.DELUXE_TOPPINGS);
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[2])) {
            resetAvailableToppings();
            this.crustTextField.setText("Pan");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.BBQ_CHICKEN_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.BBQ_CHICKEN_TOPPINGS);
        } else {
            resetAvailableToppings();
            this.crustTextField.setText("Stuffed");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.MEATZZA_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.MEATZZA_TOPPINGS);
        }

        smallPriceChange();
        mediumPriceChange();
        largePriceChange();
    }

    //TODO: make prices constants
    @FXML
    protected void smallPriceChange() {
        if (this.smallRadioButton.isSelected()) {
            if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
                this.priceTextField.setText(String.valueOf(Constants.SMALL_BBQ_CHICKEN));
            } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[1])) {
                this.priceTextField.setText(String.valueOf(Constants.SMALL_DELUXE));
            } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[2])) {
                this.priceTextField.setText(String.valueOf(Constants.SMALL_BBQ_CHICKEN));
            } else {
                this.priceTextField.setText(String.valueOf(Constants.SMALL_MEATZZA));
            }

        }
    }

    @FXML
    protected void mediumPriceChange() {
        if (this.mediumRadioButton.isSelected()) {
            if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
                this.priceTextField.setText(String.valueOf(Constants.MEDIUM_BUILD_YOUR_OWN));
            } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[1])) {
                this.priceTextField.setText(String.valueOf(Constants.MEDIUM_DELUXE));
            } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[2])) {
                this.priceTextField.setText(String.valueOf(Constants.MEDIUM_BBQ_CHICKEN));
            } else {
                this.priceTextField.setText(String.valueOf(Constants.MEDIUM_MEATZZA));
            }
        }
    }

    @FXML
    protected void largePriceChange() {
        if (this.largeRadioButton.isSelected()) {
            if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
                this.priceTextField.setText(String.valueOf(Constants.LARGE_BUILD_YOUR_OWN));
            } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[1])) {
                this.priceTextField.setText(String.valueOf(Constants.LARGE_DELUXE));
            } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[2])) {
                this.priceTextField.setText(String.valueOf(Constants.LARGE_BBQ_CHICKEN));
            } else {
                this.priceTextField.setText(String.valueOf(Constants.LARGE_MEATZZA));
            }
        }
    }

    @FXML
    protected void addTopping() {
        if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            if (this.selectedToppings.getItems().stream().count() != Constants.MAXIMUM_TOPPINGS) {
                this.selectedToppings.getItems().add(this.availableToppings.getSelectionModel().getSelectedItem());
                this.availableToppings.getItems().remove(this.availableToppings.getSelectionModel().getSelectedItem());
            } else {
                this.outputTextArea.appendText("Cannot add more than 7 toppings!\n");
            }
        } else {
            this.outputTextArea.appendText("Cannot customize this type of pizza!\n");
        }
    }

    @FXML
    protected void removeTopping() {
        if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            if (!this.selectedToppings.getItems().isEmpty()) {
                this.availableToppings.getItems().add(this.selectedToppings.getSelectionModel().getSelectedItem());
                this.selectedToppings.getItems().remove(this.selectedToppings.getSelectionModel().getSelectedItem());
            } else {
                this.outputTextArea.appendText("No toppings to remove!\n");
            }
        } else {
            this.outputTextArea.appendText("Cannot customize this type of pizza!\n");
        }
    }

    @FXML
    protected void addOrder() {
        this.outputTextArea.appendText("Pizza Order was Added!\n");
        this.typeComboBox.setValue(this.typeComboBox.getItems().get(0));
        menuDisplay();
    }

}