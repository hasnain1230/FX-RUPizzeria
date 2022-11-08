module rupizzeria.fxrupizzeria {
    requires javafx.controls;
    requires javafx.fxml;


    opens rupizzeria.fxrupizzeria to javafx.fxml;
    exports rupizzeria.fxrupizzeria;
}