package main.piece.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;
import main.gui.GridPanel;
import main.piece.Piece;

import java.util.ArrayList;

public class Queen extends Piece{
    public final Image BLACK_QUEEN = new Image("file:res/images/Black_Queen.png");
    public final Image WHITE_QUEEN = new Image("file:res/images/White_Queen.png");


    public Queen(GridPanel pos, boolean isBlack) {
        super(pos, null, null, isBlack);

        if(isBlack) {
            this.image = BLACK_QUEEN;
        } else {
            this.image = WHITE_QUEEN;
        }

        this.imageView = new ImageView(image);



        pos.getChildren().add(this.imageView);

        pos.setPiece(this);

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

        i = 1;

        while(i < Main.mainGrid.length){

            moves.add(Main.mainGrid[pos.colIndex + i][pos.rowIndex]);

            if(Main.mainGrid[pos.colIndex + i][pos.rowIndex].hasPiece()) {
                break;
            }

            i++;
        }
        i=-1;
        while(i > 0){

            moves.add(Main.mainGrid[pos.colIndex + i][pos.rowIndex]);

            if(Main.mainGrid[pos.colIndex + i][pos.rowIndex].hasPiece()) {
                break;
            }

            i--;
        }

        j=-1;
        while(j < Main.mainGrid[i].length){

            moves.add(Main.mainGrid[pos.colIndex][pos.rowIndex + j]);

            if(Main.mainGrid[pos.colIndex][pos.rowIndex + j].hasPiece()) {
                break;
            }

            j--;
        }

        j=1;
        while(j > 0){

            moves.add(Main.mainGrid[pos.colIndex][pos.rowIndex + j]);

            if(Main.mainGrid[pos.colIndex][pos.rowIndex + j].hasPiece()) {
                break;
            }

            j++;
        }

        return moves.toArray(new GridPanel[moves.size()]);
    }
}
