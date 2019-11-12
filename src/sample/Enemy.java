package sample;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.Set;


public abstract class Enemy extends GameEntity {
    Spawner spawner = new Spawner(0.0, 50.0);
    protected double x = spawner.getSpawnX(), y = spawner.getSpawnY();
    protected double velocity;
    protected double health;
    public enum Direct{LEFT, RIGHT, UP, DOWN}
    protected Direct direct = Direct.RIGHT;
    ImageView enemySprite;

    public Enemy(int x, int y, int width, int length) { super(x, y, width, length); }

    public Direct setDirect(HashMap turningBlockMap) {
        Set<Rectangle> set = turningBlockMap.keySet();
        for (Rectangle key : set) {
            if (this.getBoundsInParent().intersects(key.getBoundsInParent())) {
                if (turningBlockMap.get(key).equals("DOWN")) direct = Direct.DOWN;
                if (turningBlockMap.get(key).equals("UP")) direct = Direct.UP;
                if (turningBlockMap.get(key).equals("RIGHT")) direct = Direct.RIGHT;
                if (turningBlockMap.get(key).equals("LEFT")) direct = Direct.LEFT;
            }
        }
        return direct;
    }

    Path path = new Path();

    public void move(int level){
        direct = setDirect(path.getTurningBlock(level));
        switch (direct) {
            case RIGHT: x += velocity;
                enemySprite.setRotate(0);
                break;
            case LEFT: x -= velocity;
                enemySprite.setRotate(180);
                break;
            case DOWN: y += velocity;
                enemySprite.setRotate(90);
                break;
            case UP: y -= velocity;
                enemySprite.setRotate(270);
                break;
        }
        // move rec
        setTranslateX(x);
        setTranslateY(y);
        // move sprite
        enemySprite.relocate(x-17, y-17);
    }
}
