package main.gui;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import main.piece.Piece;

public class GridPanel extends Pane{

    public final int colIndex;
    public final int rowIndex;
    private Image image;
    private Piece piece;
    private boolean isBlack;

    public GridPanel(int col, int row, boolean isBlack){
        colIndex = col;
        rowIndex = row;
        this.isBlack = isBlack;
        if(isBlack) {
            this.setStyle("-fx-background-color: #000000");
        } else {
            this.setStyle("-fx-background-color: #FFFFFF");
        }



    }

    public void setImage(){
        image = piece.getImage();
    }

    public void setPiece(Piece p){
        piece = p;
        setImage();
    }

    public Piece getPiece(){
        return piece;
    }


}
