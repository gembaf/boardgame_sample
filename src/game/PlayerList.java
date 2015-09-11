package game;

import java.util.ArrayList;

public class PlayerList extends ArrayList<Player> {
    private static final int NUM = 2;

    private int currentId = 0;

    public PlayerList() {
        super(NUM);
    }

    public Player currentPlayer() {
        return get(currentId);
    }

    public void next() {
        currentId = (currentId + 1) % NUM;
    }
}
