package fxrupizzeria;

import constants.Constants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import orders.Order;
import pizza.ChicagoPizza;
import pizza.NYPizza;
import pizza.properties.Pizza;
import pizza.properties.Size;
import pizza.properties.Topping;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class NYViewController implements Initializable {

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

    private Order currentOrder;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.availableToppings.getItems().addAll(Constants.TOPPINGS);
        this.typeComboBox.getItems().addAll(Constants.TYPES);
        this.typeComboBox.setValue(this.typeComboBox.getItems().get(0));
        currentOrder = new Order();
    }

    private void resetAvailableToppings() {
        this.availableToppings.getItems().clear();
        this.availableToppings.getItems().addAll(Constants.TOPPINGS);
    }

    //TODO: change images when change type
    @FXML
    protected void menuDisplay() {
        if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            this.resetAvailableToppings();
            this.crustTextField.setText("HandTossed");
            this.selectedToppings.getItems().clear();
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[1])) {
            this.resetAvailableToppings();
            this.crustTextField.setText("Brooklyn");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.DELUXE_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.DELUXE_TOPPINGS);
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[2])) {
            this.resetAvailableToppings();
            this.crustTextField.setText("Thin");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.BBQ_CHICKEN_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.BBQ_CHICKEN_TOPPINGS);
        } else {
            this.resetAvailableToppings();
            this.crustTextField.setText("HandTossed");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.MEATZZA_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.MEATZZA_TOPPINGS);
        }

        this.smallPriceChange();
        this.mediumPriceChange();
        this.largePriceChange();
    }

    @FXML
    protected void smallPriceChange() {
        if (this.smallRadioButton.isSelected()) {
            if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
                this.priceTextField.setText(String.format("%.2f", Constants.SMALL_BUILD_YOUR_OWN +
                        (Constants.ADDITIONAL_TOPPING_COST * this.selectedToppings.getItems().stream().count())));
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
                this.priceTextField.setText(String.format("%.2f", Constants.MEDIUM_BUILD_YOUR_OWN +
                        (Constants.ADDITIONAL_TOPPING_COST * this.selectedToppings.getItems().stream().count())));
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
                this.priceTextField.setText(String.format("%.2f", Constants.LARGE_BUILD_YOUR_OWN +
                        (Constants.ADDITIONAL_TOPPING_COST * this.selectedToppings.getItems().stream().count())));
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
        if (!this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            this.outputTextArea.appendText("Cannot customize this type of pizza!\n");
        } else if (this.availableToppings.getSelectionModel().getSelectedItem() == null) {
            this.outputTextArea.appendText("Select a topping to add please!\n");
        } else if (this.selectedToppings.getItems().size() == Constants.MAXIMUM_TOPPINGS) {
            this.outputTextArea.appendText("Cannot add more than 7 toppings!\n");
        } else {
            this.selectedToppings.getItems().add(this.availableToppings.getSelectionModel().getSelectedItem());
            this.availableToppings.getItems().remove(this.availableToppings.getSelectionModel().getSelectedItem());
            this.priceTextField.setText(String.format("%.2f", Double.parseDouble(this.priceTextField.getText().trim()) + Constants.ADDITIONAL_TOPPING_COST));
        }
    }

    @FXML
    protected void removeTopping() {
        if (!this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            this.outputTextArea.appendText("Cannot customize this type of pizza!\n");
        } else if (this.selectedToppings.getItems().isEmpty()) {
            this.outputTextArea.appendText("No toppings to remove!\n");
        } else if (this.selectedToppings.getSelectionModel().getSelectedItem() == null) {
            this.outputTextArea.appendText("Select a topping to remove please!\n");
        } else {
            this.availableToppings.getItems().add(this.selectedToppings.getSelectionModel().getSelectedItem());
            this.selectedToppings.getItems().remove(this.selectedToppings.getSelectionModel().getSelectedItem());
            this.priceTextField.setText(String.format("%.2f", Double.parseDouble(this.priceTextField.getText().trim()) - Constants.ADDITIONAL_TOPPING_COST));
        }
    }

    private Size getSize() {
        if (this.smallRadioButton.isSelected()){
            return Size.SMALL;
        } else if (this.mediumRadioButton.isSelected()){
            return Size.MEDIUM;
        } else {
            return Size.LARGE;
        }
    }

    @FXML
    protected void addOrder() throws FileNotFoundException {
        if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            Pizza byo = new NYPizza().createBuildYourOwn();
            byo.setSize(getSize());

            for(int i = 0; i<this.selectedToppings.getItems().stream().count(); i++){
                byo.add(Topping.returnToppingEnumFromString(this.selectedToppings.getItems().get(i).toUpperCase()));
            }

            if (this.currentOrder.add(byo)) {
                this.outputTextArea.appendText("Pizza Order was Added!\n");
            }
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[1])) {
            Pizza deluxe = new NYPizza().createDeluxe();
            deluxe.setSize(getSize());
            if (this.currentOrder.add(deluxe)) {
                this.outputTextArea.appendText("Pizza Order was Added!\n");
            }
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[2])) {
            Pizza bbq = new NYPizza().createBBQChicken();
            bbq.setSize(getSize());
            if (this.currentOrder.add(bbq)) {
                this.outputTextArea.appendText("Pizza Order was Added!\n");
            }
        } else {
            Pizza meatzza = new NYPizza().createMeatzza();
            meatzza.setSize(getSize());
            if (this.currentOrder.add(meatzza)) {
                this.outputTextArea.appendText("Pizza Order was Added!\n");
            }
        }
        this.typeComboBox.setValue(this.typeComboBox.getItems().get(0));
        this.menuDisplay();
    }

}