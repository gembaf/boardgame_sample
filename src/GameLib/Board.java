package GameLib;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Board extends JPanel implements Cell.Callbacks {
    private static final int SIZE = 3;
    private static final int GAP = 3;

    private Cell[][] cells = new Cell[SIZE][SIZE];

    private Player player1 = new Player(Color.BLACK);
    private Player player2 = new Player(Color.WHITE);
    private boolean who = true;

    public Board() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(SIZE, SIZE, GAP, GAP));
        initBoard();
    }

    private void initBoard() {
        for (int k1 = 0; k1 < SIZE; k1++) {
            for (int k2 = 0; k2 < SIZE; k2++) {
                cells[k1][k2] = new Cell(k1, k2);
                cells[k1][k2].setCallbacks(this);
                add(cells[k1][k2]);
            }
        }
    }

    //--- コールバックの処理

    @Override
    public void callbackMethod(int x, int y) {
        if (who) {
            cells[x][y].put(player1.getStone());
        } else {
            cells[x][y].put(player2.getStone());
        }
        who = !who;
    }
}
