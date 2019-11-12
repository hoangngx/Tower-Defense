package sample;

import javafx.scene.image.ImageView;

public class NormalEnemy extends Enemy {
    public NormalEnemy(){
        super(0, 0, 30, 30);
        velocity = 0.4;
        enemySprite = new ImageView(getClass().getResource("NormalEnemy.png").toExternalForm());
    }
}
