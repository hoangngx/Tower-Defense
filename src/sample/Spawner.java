package sample;

public class Spawner extends Path {
    public Spawner (double startX, double startY){
        spawnX = startX;
        spawnY = startY;
    }

    public void setSpawnX (int spawnX){
        this.spawnX = spawnX;
    }
    public double getSpawnX(){
        return this.spawnX;
    }

    public void setSpawnY (int spawnY){
        this.spawnY = spawnY;
    }
    public double getSpawnY(){
        return this.spawnY;
    }
}
