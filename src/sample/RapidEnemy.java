package sample;

import javafx.scene.image.ImageView;

public class RapidEnemy extends Enemy {
    public RapidEnemy(){
        super(0, 0, 20, 20);
        velocity = 0.55;
        enemySprite = new ImageView(getClass().getResource("RapidEnemy.png").toExternalForm());
        enemySprite.setFitWidth(50);
        enemySprite.setPreserveRatio(true);
        enemySprite.setSmooth(true);
        enemySprite.setCache(true);
    }
}
