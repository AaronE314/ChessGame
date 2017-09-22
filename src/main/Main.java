package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.gui.Layout;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Layout layout = new Layout();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(layout.getLayout(), 800, 800));
        primaryStage.show();
    }



}
