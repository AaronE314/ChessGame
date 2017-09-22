package main.piece.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;
import main.gui.GridPanel;
import main.piece.Piece;

import java.util.ArrayList;

public class Bishop extends Piece{

    public final Image BLACK_BISHOP = new Image("file:res/images/Black_Bishop.png");
    public final Image WHITE_BISHOP = new Image("file:res/images/White_Bishop.png");


    public Bishop(GridPanel pos, boolean isBlack) {
        super(pos, null, null, isBlack);

        if(isBlack) {
            this.image = BLACK_BISHOP;
        } else {
            this.image = WHITE_BISHOP;
        }

        this.imageView = new ImageView(image);

        pos.setPiece(this);



        pos.getChildren().add(this.imageView);

        movement = calculateMovement();



    }

    private GridPanel[] calculateMovement() {
        ArrayList<GridPanel> moves = new ArrayList<>();

        int i = 1;
        int j = 1;

        while(i < Main.mainGrid.length && j < Main.mainGrid[i].length){

            moves.add(Main.mainGrid[pos.colIndex + i][pos.rowIndex + j]);

            if(Main.mainGrid[pos.colIndex + i][pos.rowIndex + j].hasPiece()) {
                break;
            }

            i++;
            j++;
        }
        i=-1;
        j=-1;
        while(i > 0 && j > 0){

            moves.add(Main.mainGrid[pos.colIndex + i][pos.rowIndex + j]);

            if(Main.mainGrid[pos.colIndex + i][pos.rowIndex + j].hasPiece()) {
                break;
            }

            i--;
            j--;
        }

        i=1;
        j=-1;
        while(i < Main.mainGrid.length && j > 0){

            moves.add(Main.mainGrid[pos.colIndex + i][pos.rowIndex + j]);

            if(Main.mainGrid[pos.colIndex + i][pos.rowIndex + j].hasPiece()) {
                break;
            }

            i++;
            j--;
        }

        i=-1;
        j=1;
        while(i > 0 && j < Main.mainGrid[i].length){

            moves.add(Main.mainGrid[pos.colIndex + i][pos.rowIndex + j]);

            if(Main.mainGrid[pos.colIndex + i][pos.rowIndex + j].hasPiece()) {
                break;
            }

            i--;
            j++;
        }

        return moves.toArray(new GridPanel[moves.size()]);
    }
}
