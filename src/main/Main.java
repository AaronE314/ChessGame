package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.gui.GridPanel;
import main.gui.Layout;
import main.logic.GameHandler;

public class Main extends Application {

    public static GridPanel[][] mainGrid;

    public static Layout layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        layout = new Layout();

        mainGrid = layout.getGrid();

        GameHandler gameHandler = new GameHandler();

        gameHandler.NewGame();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(layout.getLayout(), 800, 800));
        primaryStage.show();
    }



}
