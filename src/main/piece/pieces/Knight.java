package main.piece.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.shape.MoveTo;
import main.Main;
import main.gui.GridPanel;
import main.piece.Piece;

import java.util.ArrayList;

public class Knight extends Piece{

    public final Image BLACK_KNIGHT = new Image("file:res/images/Black_Knight.png");
    public final Image WHITE_KNIGHT = new Image("file:res/images/White_Knight.png");


    public Knight(GridPanel pos, boolean isBlack) {
        super(pos, null, null, isBlack);

        if(isBlack) {
            this.image = BLACK_KNIGHT;
        } else {
            this.image = WHITE_KNIGHT;
        }

        this.imageView = new ImageView(image);



        pos.getChildren().add(this.imageView);

        pos.setPiece(this);

        movement = calculateMovement();



    }

    private GridPanel[] calculateMovement() {
        ArrayList<GridPanel> moves = new ArrayList<>();

        int ix = pos.colIndex;
        int jy = pos.rowIndex;

        for(int i = -2; i <= 2; i++){

            if (Math.abs(i) == 1) {
                if(ix + i < Main.mainGrid.length && ix + i >= 0 && jy-2 >= 0) {
                    moves.add(Main.mainGrid[ix + i][jy -2]);
                }
                if(ix + i < Main.mainGrid.length && ix + i >= 0 && jy+2 >= Main.mainGrid[i].length) {
                    moves.add(Main.mainGrid[ix + i][jy + 2]);
                }


            } else if(Math.abs(i) == 2){
                if(ix + i < Main.mainGrid.length && ix + i >= 0 && jy-2 >= 0) {
                    moves.add(Main.mainGrid[i][-1]);
                }
                if(ix + i < Main.mainGrid.length && ix + i >= 0 && jy+2 >= Main.mainGrid[i].length) {
                    moves.add(Main.mainGrid[i][1]);
                }
            }

        }

        return moves.toArray(new GridPanel[moves.size()]);
    }
}
