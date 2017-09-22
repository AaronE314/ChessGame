package main.piece.pieces;

import javafx.scene.image.Image;
import main.gui.GridPanel;
import main.piece.Piece;

public class Knight extends Piece{
    public Knight(GridPanel pos, Image image, GridPanel[] movement,boolean isBlack) {
        super(pos, image, movement, isBlack);
    }

    private GridPanel[] CalculateMovement(){
        return null;
    }
}
