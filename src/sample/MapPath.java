package sample;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class MapPath extends Path {
    public MapPath (int round){
        if (round == 1){
            LineTo line = new LineTo(20, 20);
            LineTo line1 = new LineTo(450, 20);
            LineTo line2 = new LineTo(450, 220);
            LineTo line3 = new LineTo(100, 220);
            LineTo line4 = new LineTo(100, 400);
            LineTo line5 = new LineTo(300, 550);
            LineTo line6 = new LineTo(450, 550);
            LineTo line7 = new LineTo(570, 380);
            LineTo line8 = new LineTo(640, 550);
            LineTo line9 = new LineTo(780, 550);

            MoveTo startPos = new MoveTo(20, 20);
            this.getElements().addAll(startPos, line, line1, line2, line3, line4, line5, line6, line7, line8, line9);
        }
    }
}
