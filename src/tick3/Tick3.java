package tick3;

import game.Player;
import game.PlayerList;
import game.Stone;
import gui.GamePanel;

public class Tick3 extends GamePanel {
    @Override
    public void init() {
        playerList = new PlayerList();
        playerList.add(new Player(Stone.BlackStone()));
        playerList.add(new Player(Stone.WhiteStone()));
        board = new Tick3BoardPanel();
        board.setCallbacks(this);
        setContentPane(board);
    }
}
