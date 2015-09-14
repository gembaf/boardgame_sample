package gui;

import game.Player;
import game.PlayerList;

import javax.swing.JApplet;

public abstract class GamePanel extends JApplet implements ISelectEvent {
    protected BoardPanel board;
    protected PlayerList playerList;

    public void onSelect(int x, int y) {
        Player player = playerList.currentPlayer();
        boolean flag = board.put(x, y, player.getStone());

        if (board.isFinish(player.getStone())) {
            System.out.println(player);
            board.lock();
        }

        if (flag) {
            playerList.next();
        }
    }
}
