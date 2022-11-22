package fxrupizzeria;

import constants.Constants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import orders.Order;
import pizza.ChicagoPizza;
import pizza.properties.Pizza;
import pizza.properties.Size;
import pizza.properties.Topping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is a controller class for the Chicago View of the RU Pizzeria Application. It will handle all ActionEvents, button clicks, and any other
 * behavior that the user can interact with. This class will also handle the logic of the application. This class implements initializable
 * in order to initialize the basic state of the application upon start.
 * @author Hasnain Ali, Carolette Saguil
 */
public class ChicagoViewController implements Initializable {

    /**
     * The available toppings list view for Chicago View. This list view will be initialized upon start when the initialize method is called.
     */
    @FXML
    private ListView<String> availableToppings;

    /**
     * This is a combo box for selecting pizza type when ordering Chicago Pizza. This combo box will be initialized upon start when the initialize method is called.
     */
    @FXML
    private ComboBox<String> typeComboBox;

    /**
     * The crust text field for Chicago View.
     */
    @FXML
    private TextField crustTextField;

    /**
     * The selected toppings list view for Chicago View.
     */
    @FXML
    private ListView<String> selectedToppings;

    /**
     * The small radio button for Chicago View.
     */
    @FXML
    private RadioButton smallRadioButton;

    /**
     * The medium radio button for Chicago View.
     */
    @FXML
    private RadioButton mediumRadioButton;

    /**
     * The large radio button for Chicago View.
     */
    @FXML
    private RadioButton largeRadioButton;

    /**
     * The price text field for Chicago View.
     */
    @FXML
    private TextField priceTextField;

    /**
     * This is the text area where all the program output will be displayed.
     */
    @FXML
    private TextArea outputTextArea;

    /**
     * The pizza image view for Chicago view.
     */
    @FXML
    private ImageView pizzaImage;

    /**
     * The order that is currently being added.
     */
    private static Order currentOrder;

    /**
     * This method will initialize the available toppings list view, type combo box, and current order for GUI.
     * It will be called automatically upon the start of the program.
     * @param arg0 The location used to resolve relative paths for the root object, or
     *             {@code null} if the location is not known.
     * @param arg1 The resources used to localize the root object, or {@code null} if
     *             the root object was not localized.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.availableToppings.getItems().addAll(Constants.TOPPINGS);
        this.typeComboBox.getItems().addAll(Constants.TYPES);
        this.typeComboBox.setValue(this.typeComboBox.getItems().get(0));
        currentOrder = RUPizzeriaViewController.getCurrentOrder();
    }

    /**
     * This method resets the available topping list view to have all the toppings again.
     */
    private void resetAvailableToppings() {
        this.availableToppings.getItems().clear();
        this.availableToppings.getItems().addAll(Constants.TOPPINGS);
    }

    /**
     * Updates the Chicago menu display, including: pizza image view, price text field, available toppings list view,
     * selected toppings list view, and crust text field, when user selects different types of pizza through type combo box.
     * @throws FileNotFoundException
     */
    @FXML
    protected void menuDisplay() throws FileNotFoundException {
        // Check if OS is Windows
        String OS = System.getProperty("os.name").toLowerCase();
        String contentRoot;
        if (OS.contains("win")) {
            contentRoot = "src\\main\\resources\\";
        } else {
            contentRoot = "src/main/resources/";
        }
        Image defaultImage = new Image(new FileInputStream(contentRoot + "assets/chicagoDefault.jpg"));
        Image deluxeImage = new Image(new FileInputStream(contentRoot + "assets/chicagoDeluxe.jpg"));
        Image bbqImage = new Image(new FileInputStream(contentRoot + "assets/chicagoBBQ.jpg"));
        Image meatzzaImage = new Image(new FileInputStream(contentRoot + "assets/chicagoMeat.jpg"));

        if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            this.resetAvailableToppings();
            this.crustTextField.setText("Pan");
            this.selectedToppings.getItems().clear();
            this.pizzaImage.setImage(defaultImage);
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[1])) {
            this.resetAvailableToppings();
            this.crustTextField.setText("Deep Dish");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.DELUXE_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.DELUXE_TOPPINGS);
            this.pizzaImage.setImage(deluxeImage);
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[2])) {
            this.resetAvailableToppings();
            this.crustTextField.setText("Pan");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.BBQ_CHICKEN_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.BBQ_CHICKEN_TOPPINGS);
            this.pizzaImage.setImage(bbqImage);
        } else {
            this.resetAvailableToppings();
            this.crustTextField.setText("Stuffed");
            this.selectedToppings.getItems().clear();
            this.selectedToppings.getItems().addAll(Constants.MEATZZA_TOPPINGS);
            this.availableToppings.getItems().removeAll(Constants.MEATZZA_TOPPINGS);
            this.pizzaImage.setImage(meatzzaImage);
        }
        this.smallPriceChange();
        this.mediumPriceChange();
        this.largePriceChange();
    }

    /**
     * Updates price text field for small pizza size when small radio button is selected.
     */
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

    /**
     * Updates price text field for medium pizza size when medium radio button is selected.
     */
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

    /**
     * Updates price text field for large pizza size when large radio button is selected.
     */
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

    /**
     * Adds a topping to pizza and update available topping list view, selected topping list view,
     * and price text field accordingly for build your own pizza.
     * Fails if: pizza type is not build your own, available topping is not selected, or there are already 7 toppings selected
     */
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

    /**
     * Removes a topping from pizza and update available topping list view, selected topping list view,
     * and price text field accordingly for build your own pizza.
     * Fails if: pizza type is not build your own, selected topping is not selected, or selected topping list view is empty
     */
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

    /**
     * @return Returns size of pizza depending on which size radio button is selected.
     */
    private Size getSize() {
        if (this.smallRadioButton.isSelected()) {
            return Size.SMALL;
        } else if (this.mediumRadioButton.isSelected()) {
            return Size.MEDIUM;
        } else {
            return Size.LARGE;
        }
    }

    /**
     * Adds selected pizza to current order. Resets pizza menu display to default settings for next pizza.
     * @throws FileNotFoundException
     */
    @FXML
    protected void addOrder() throws FileNotFoundException {
        if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[0])) {
            Pizza byo = new ChicagoPizza().createBuildYourOwn();
            byo.setSize(getSize());

            for(int i = 0; i < this.selectedToppings.getItems().stream().count(); i++) {
                byo.add(Topping.returnToppingEnumFromString(this.selectedToppings.getItems().get(i)));
            }

            if (currentOrder.add(byo)) {
                this.outputTextArea.appendText("Pizza Order was Added!\n");
            }

        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[1])) {
            Pizza deluxe = new ChicagoPizza().createDeluxe();
            deluxe.setSize(getSize());
            if (currentOrder.add(deluxe)) {
                this.outputTextArea.appendText("Pizza Order was Added!\n");
            }
        } else if (this.typeComboBox.getValue().equalsIgnoreCase(Constants.TYPES[2])) {
            Pizza bbq = new ChicagoPizza().createBBQChicken();
            bbq.setSize(getSize());
            if (currentOrder.add(bbq)) {
                this.outputTextArea.appendText("Pizza Order was Added!\n");
            }
        } else {
            Pizza meatzza = new ChicagoPizza().createMeatzza();
            meatzza.setSize(getSize());
            if (currentOrder.add(meatzza)) {
                this.outputTextArea.appendText("Pizza Order was Added!\n");
            }
        }
        
        this.typeComboBox.setValue(this.typeComboBox.getItems().get(0));
        this.menuDisplay();
    }
}