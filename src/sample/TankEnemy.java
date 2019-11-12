package sample;

import javafx.scene.image.ImageView;

public class TankEnemy extends Enemy {
    public TankEnemy(){
        super(0, 0, 40, 40);
        velocity = 0.2;
        enemySprite = new ImageView(getClass().getResource("TankEnemy.png").toExternalForm());
        enemySprite.setFitWidth(85);
        enemySprite.setPreserveRatio(true);
        enemySprite.setSmooth(true);
        enemySprite.setCache(true);
    }
}
