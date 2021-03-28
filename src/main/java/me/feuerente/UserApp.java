package me.feuerente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class starts the application.
 */
public class UserApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the gui by loading the user view from FXML.
     *
     * @param stage the stage
     * @throws Exception the exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("User Demo");
        stage.setScene(scene);
        stage.show();
    }
}
