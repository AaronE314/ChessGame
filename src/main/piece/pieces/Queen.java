package main.piece.pieces;

import javafx.scene.image.Image;
import main.gui.GridPanel;
import main.piece.Piece;

public class Queen extends Piece{
    public Queen(GridPanel pos, Image image, GridPanel[] movement,boolean isBlack) {
        super(pos, image, movement, isBlack);
    }

    private GridPanel[] CalculateMovement(){
        return null;
    }
}
