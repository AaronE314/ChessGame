package main.piece.pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;
import main.gui.GridPanel;
import main.piece.Piece;

import java.util.ArrayList;

public class Pawn extends Piece {
    public final Image BLACK_PAWN = new Image("file:res/images/Black_Pawn.png");
    public final Image WHITE_PAWN = new Image("file:res/images/White_Pawn.png");

    private boolean firstMove = true;


    public Pawn(GridPanel pos, boolean isBlack) {
        super(pos, null, null, isBlack);

        if(isBlack) {
            this.image = BLACK_PAWN;
        } else {
            this.image = WHITE_PAWN;
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

        if(firstMove) {
            moves.add(Main.mainGrid[ix][jy + 1]);
            moves.add(Main.mainGrid[ix][jy + 2]);
        } else if (jy < Main.mainGrid[ix].length && !Main.mainGrid[ix][jy + 1].hasPiece()){
            moves.add(Main.mainGrid[ix][jy + 1]);
        }

        if(jy < Main.mainGrid[ix].length && ix + 1 < Main.mainGrid.length && Main.mainGrid[ix+1][jy+1].hasPiece()) {
            moves.add(Main.mainGrid[ix+1][jy+1]);
        }

        if(jy < Main.mainGrid[ix].length && ix - 1 > 0 && Main.mainGrid[ix-1][jy+1].hasPiece()) {
            moves.add(Main.mainGrid[ix-1][jy+1]);
        }

        return moves.toArray(new GridPanel[moves.size()]);
    }
}
