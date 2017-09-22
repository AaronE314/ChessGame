package main.piece.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;
import main.gui.GridPanel;
import main.piece.Piece;

import java.util.ArrayList;

public class Rook extends Piece{
    public final Image BLACK_ROOK = new Image("file:res/images/Black_Rook.png");
    public final Image WHITE_ROOK = new Image("file:res/images/White_Rook.png");


    public Rook(GridPanel pos, boolean isBlack) {
        super(pos, null, null, isBlack);

        if(isBlack) {
            this.image = BLACK_ROOK;
        } else {
            this.image = WHITE_ROOK;
        }

        this.imageView = new ImageView(image);



        pos.getChildren().add(this.imageView);

        pos.setPiece(this);

        movement = calculateMovement();

    }

    private GridPanel[] calculateMovement() {
        ArrayList<GridPanel> moves = new ArrayList<>();

        int i = 1;
        int j;

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
