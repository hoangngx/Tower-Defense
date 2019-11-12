package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Pane root;

    private List<Enemy> enemies = new ArrayList<>();
    public int deadEnemy = 0;
    public int spawnedEnemy = 1;
    public Finish finish = new Finish(700, 500);
    public Rectangle finishBlock = finish.finishBlock();
    public int level = 1;
    public int round = 1;
    public int numberOfRounds = 5;

    String countRoundText;
    Text roundText = new Text(350, 20, countRoundText);

    private Pane createContent() {
        root = new Pane();
        root.setPrefSize(800, 600);

        root.getChildren().add(roundText);

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate;
            private double distanceBetweenEnemy = 1.0;

            public void start() {
                lastUpdate = System.nanoTime();
                super.start();
            }

            @Override
            public void handle(long now) {
                long elapsedNanoSeconds = now - lastUpdate ;
                double elapsedSeconds = elapsedNanoSeconds / 1_000_000_000.0;

                if (elapsedSeconds >= distanceBetweenEnemy) {
                    // ROUND 1
                    if (spawnedEnemy <= 1) {
                        updateRound();
                        spawnNormalEnemy();
                        lastUpdate = now;
                    }

                    // ROUND 2
                    if (spawnedEnemy <= 3 && deadEnemy >= 1) {
                        round = 2;
                        updateRound();
                        spawnNormalEnemy();
                        lastUpdate = now;
                    }

                    // ROUND 3
                    if (spawnedEnemy <= 7 && deadEnemy >= 3) {
                        round = 3;
                        updateRound();
                        distanceBetweenEnemy = 0.5;
                        spawnNormalEnemy();
                        lastUpdate = now;
                    }

                    // ROUND 4
                    if (spawnedEnemy <= 12 && deadEnemy >= 7) {
                        round = 4;
                        updateRound();
                        spawnNormalEnemy();
                        spawnTankEnemy();
                        lastUpdate = now;
                    }

                    // ROUND 5
                    if (spawnedEnemy <= 18 && deadEnemy >= 12) {
                        round = 5;
                        updateRound();
                        spawnRapidEnemy();
                        spawnPlane();
                        lastUpdate = now;
                    }
                }
                onUpdate();
            }
        };
        timer.start();

        return root;
    }

    private void updateRound(){
        countRoundText = "ROUND: " + round + "/" + numberOfRounds;
        roundText.setText(countRoundText);
    }

    private void spawnNormalEnemy() {
        NormalEnemy normalEnemy = new NormalEnemy();
        //root.getChildren().add(normalEnemy);
        root.getChildren().add(normalEnemy.enemySprite);
        enemies.add(normalEnemy);
        spawnedEnemy++;
    }
    private void spawnTankEnemy() {
        TankEnemy tankEnemy = new TankEnemy();
        //root.getChildren().add(tankEnemy);
        root.getChildren().add(tankEnemy.enemySprite);
        enemies.add(tankEnemy);
        spawnedEnemy++;
    }
    private void spawnPlane() {
        Plane plane = new Plane();
        root.getChildren().add(plane.enemySprite);
        enemies.add(plane);
        spawnedEnemy++;
    }
    private void spawnRapidEnemy() {
        RapidEnemy rapidEnemy = new RapidEnemy();
        //root.getChildren().add(rapidEnemy);
        root.getChildren().add(rapidEnemy.enemySprite);
        enemies.add(rapidEnemy);
        spawnedEnemy++;
    }

    private void onUpdate() {
        for (Enemy enemy : enemies)
            enemy.move(level);
        destroy(enemies);
    }


    public void destroy(List<Enemy> enemies){
        for (int i=0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if(finishBlock.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
                root.getChildren().removeAll(enemy.enemySprite);
                //root.getChildren().removeAll(enemy);
                enemies.remove(enemy);
                i--;
                deadEnemy++;
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setScene(new Scene(createContent()));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
