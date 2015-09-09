package sansan;

import java.awt.Color;

import javax.swing.JApplet;

import GameLib.Board;
import GameLib.Player;

public class Sansan extends JApplet implements Board.Callbacks {
    private Board board;

    private Player player1 = new Player(Color.BLACK);
    private Player player2 = new Player(Color.WHITE);
    private boolean who = true;

    @Override
    public void init() {
        board = new Board();
        board.setCallbacks(this);;
        setContentPane(board);
    }

    //--- コールバックの処理

    @Override
    public void callbackMethod(int x, int y) {
        boolean flag = false;
        if (who) {
            flag = board.put(x, y, player1.getStone());
        } else {
            flag = board.put(x, y, player2.getStone());
        }
        if (flag) {
            who = !who;
        }
    }
}
