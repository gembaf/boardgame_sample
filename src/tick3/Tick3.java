package tick3;

import game.Board;
import game.Player;
import game.PlayerList;

import javax.swing.JApplet;

public class Tick3 extends JApplet implements Board.Callbacks {
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

        if (board.isFinish(player.getStone())) {
            System.out.println(player);
            board.lock();
        }

        if (flag) {
            playerList.next();
        }
    }
}
