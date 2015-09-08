package GameLib;

import java.awt.Color;

public class Player {
    private Stone stone;

    public Player(Color color) {
        stone = new Stone(color);
    }

    public Stone getStone() {
        return stone;
    }
}
