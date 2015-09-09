package sansan;

import javax.swing.JApplet;

import GameLib.Board;
import GameLib.Player;
import GameLib.PlayerList;

public class Sansan extends JApplet implements Board.Callbacks {
    private Board board;

    private PlayerList playerList = new PlayerList();

    @Override
    public void init() {
        board = new Board();
        board.setCallbacks(this);
        setContentPane(board);
    }

    //--- コールバックの処理

    @Override
    public void callbackMethod(int x, int y) {
        Player player = playerList.currentPlayer();
        boolean flag = board.put(x, y, player.getStone());
        if (flag) {
            playerList.next();
        }
    }
}
