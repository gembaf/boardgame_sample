package game;

import java.awt.Color;


public class Stone {
    private Color color;

    private Stone(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean eqColor(Stone stone) {
        return color == stone.getColor();
    }

    public static Stone BlackStone() {
        return new Stone(Color.BLACK);
    }

    public static Stone WhiteStone() {
        return new Stone(Color.WHITE);
    }
}
