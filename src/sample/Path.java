package sample;

import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class Path {
    protected double spawnX;
    protected double spawnY;
    protected double endX;
    protected double endY;

    public HashMap getTurningBlock(int level){
        HashMap<Rectangle, String> turningBlockMap = new HashMap<Rectangle, String>();
        if (level == 1) {
            turningBlockMap.put(new Rectangle(500, 30, 40, 40), "DOWN");
            turningBlockMap.put(new Rectangle(500, 350, 40, 40), "LEFT");
            turningBlockMap.put(new Rectangle(100, 350, 40, 40), "DOWN");
            turningBlockMap.put(new Rectangle(100, 550, 40, 40), "RIGHT");
        }
        return turningBlockMap;
    }
}
