package main.piece.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;
import main.gui.GridPanel;
import main.piece.Piece;

import java.util.ArrayList;

public class King extends Piece{
    public final String BLACK_KING = "file:src/res/images/Black_King.png";
    public final String WHITE_KING = "file:src/res/images/White_King.png";


    public King(GridPanel pos, boolean isBlack) {
        super(pos, null, null, isBlack);

        if(isBlack) {
            this.image = new Image(BLACK_KING);
        } else {
            this.image = new Image(WHITE_KING);
        }

        this.imageView = new ImageView(image);


        //Main.mainGrid[0][0].getChildren().add(imageView);

        Main.layout.addToGrid(imageView,0,0);
        pos.getChildren().add(this.imageView);
        pos.setPiece(this);

        movement = calculateMovement();

    }

    private GridPanel[] calculateMovement() {
        ArrayList<GridPanel> moves = new ArrayList<>();

        int i = pos.colIndex;
        int j = pos.rowIndex;

        int startPosX = (i - 1 < 0) ? i : i-1;
        int startPosY = (j - 1 < 0) ? j  : j-1;
        int endPosX = (i + 1 > Main.mainGrid.length-1) ? i : i+1;
        int endPosY = (j + 1 > Main.mainGrid[0].length-1) ? j  : j+1;


        for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
            for (int colNum=startPosY; colNum<=endPosY; colNum++) {
                moves.add(Main.mainGrid[rowNum][colNum]);
            }
        }

        return moves.toArray(new GridPanel[moves.size()]);
    }
}
