package main.piece;


import javafx.scene.image.Image;
import main.gui.GridPanel;

public class Piece {

    protected GridPanel[] movement;
    protected GridPanel ipos, pos;
    protected Image image;
    protected boolean isBlack;

    public Piece(GridPanel pos, Image image, GridPanel[] movement, boolean isBlack) {
        this.movement = movement;
        this.ipos = this.pos = pos;
        this.image = image;
        this.isBlack = isBlack;

    }

    public void move(GridPanel g){
        pos = g;
    }

    public Image getImage(){
        return image;
    }

    private GridPanel[] CalculateMovement(){
        return null;
    }



}
