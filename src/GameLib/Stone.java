package GameLib;

import java.awt.Color;


public class Stone {
    private Color color;

    public Stone(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean eqColor(Stone stone) {
        return color == stone.getColor();
    }
}
