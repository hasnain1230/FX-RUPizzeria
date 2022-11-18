module rupizzeria.fxrupizzeria {
    requires javafx.controls;
    requires javafx.fxml;


    opens fx_rupizzeria to javafx.fxml;
    exports fx_rupizzeria;
}