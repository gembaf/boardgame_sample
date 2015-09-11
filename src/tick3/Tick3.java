package tick3;

import game.PlayerList;
import gui.GamePanel;

public class Tick3 extends GamePanel {
    @Override
    public void init() {
        playerList = new PlayerList();
        board = new Tick3BoardPanel();
        board.setCallbacks(this);
        setContentPane(board);
    }
}
