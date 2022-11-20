module rupizzeria.fxrupizzeria {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxrupizzeria to javafx.fxml;
    exports fxrupizzeria;
}