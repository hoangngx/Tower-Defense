package sample;

import javafx.scene.shape.Rectangle;

public class Finish extends Path {

    public Finish(int endX, int endY){
        this.endX = endX;
        this.endY = endY;
    }

    public void setEndX (int endX){
        this.endX = endX;
    }
    public double getEndX(){
        return this.endX;
    }

    public void setEndY (int endY){
        this.endY = endY;
    }
    public double getendY(){
        return this.endY;
    }

    public Rectangle finishBlock(){
        return new Rectangle(endX, endY, 40, 40);
    }
}
