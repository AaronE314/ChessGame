package main.gui;

import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import main.piece.Piece;

public class Layout extends Parent {

    private BorderPane layout;
    private GridPane grid;
    private MenuBar menuBar;
    public GridPanel[][] gridPanels;
    private boolean b = false;
    private int count = 0;

    public Layout() {

        layout = new BorderPane();
        menuBar = new MenuBar();
        grid = new GridPane();
        gridPanels = new GridPanel[8][8];

        grid.setGridLinesVisible(true);

        setUpGrid();
        setUpMenu();

        layout.setTop(menuBar);
        layout.setCenter(grid);

    }

    private void setUpMenu() {
        String[][] menuItems = {{"File", "Help"},
                                {"New Game", "Save Game", "Open Game", "Close"},
                                {"About"}};
        Menu[] menus = new Menu[menuItems[0].length];


        for(int i = 0; i < menuItems[0].length; i++){
            menus[i] = new Menu(menuItems[0][i]);
        }

        for(int j = 0; j<menus.length; j++) {
            for (int i = 0; i < menuItems[j+1].length; i++) {
                menus[j].getItems().add(new MenuItem(menuItems[j+1][i]));
            }
        }

        menuBar.getMenus().addAll(menus);
    }

    private void setUpGrid(){
        int numCols = 8;
        int numRows = 8;

        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            grid.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            grid.getRowConstraints().add(rowConstraints);
        }

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                addPane(i, j);
            }
        }
    }

    private void addPane(int colIndex, int rowIndex) {
        GridPanel pane = new GridPanel(colIndex,rowIndex, b);
        if(count != 7) {
            b = !b;
            count++;
        } else {
            count=0;
        }
        pane.setOnMouseClicked(e->gridClicked.handleEvent(e));
        grid.add(pane, colIndex, rowIndex);
        gridPanels[colIndex][rowIndex] = pane;
    }

    public BorderPane getLayout() {
        return layout;
    }

}
