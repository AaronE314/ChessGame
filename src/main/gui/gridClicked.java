package main.gui;

import javafx.scene.input.MouseEvent;

public class gridClicked{

    public static void handleEvent(MouseEvent event) {
        GridPanel g = (GridPanel) event.getSource();

        System.out.println(g.colIndex + " " + g.rowIndex);


        System.out.println(g.hasPiece());
    }
}
