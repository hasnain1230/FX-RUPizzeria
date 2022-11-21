package fxrupizzeria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pizza.properties.Topping;

import java.io.IOException;
import java.util.UUID;

/**
 * This class launches the {@code FX-RUPizzeria} application and sets the starting stage for the application.
 * @author Hasnain Ali, Carolette Saguil
 */
public class RUPizzeriaApp extends Application {
    /**
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws IOException In case the specified starting .fxml is not found
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUPizzeriaApp.class.getResource("RUPizzeriaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("RU-Pizzeria");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches {@code FX-RUPizzeria} GUI FX Application.
     * @param args Command line arguments -- will not be used for this application. This application is a GUI application.
     */
    public static void main(String[] args) {
        launch();
    }
}