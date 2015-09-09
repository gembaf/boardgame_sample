package GameLib;

import java.awt.Color;
import java.util.ArrayList;

public class PlayerList extends ArrayList<Player> {
    private static final int NUM = 2;

    private int currentId = 0;

    public PlayerList() {
        super(NUM);
        add(new Player(Color.BLACK));
        add(new Player(Color.WHITE));
    }

    public Player currentPlayer() {
        return get(currentId);
    }

    public void next() {
        currentId = (currentId + 1) % NUM;
    }
}
