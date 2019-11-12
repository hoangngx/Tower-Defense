package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FinishLine extends Rectangle{
    FinishLine(int x, int y, int w, int l, Color color) {
        super(w, l, color);
        setX(x);
        setY(y);
    }
}
