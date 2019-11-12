package sample;

import javafx.scene.image.ImageView;

public class Plane extends Enemy {
    public Plane(){
        super(0, 0, 45, 45);
        velocity = 0.1;
        enemySprite = new ImageView(getClass().getResource("Plane.png").toExternalForm());
    }

    @Override
    public void move(int round){
        x += velocity+0.07;
        y += velocity;
        enemySprite.setRotate(52);
        // move rec
        setTranslateX(x);
        setTranslateY(y);
        // move sprite
        enemySprite.relocate(x-17, y-17);
    }
}
