package game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import tick3.Tick3CellPanel;

public class Board extends JPanel implements ICell.Callbacks {
    private static final int SIZE = 3;
    private static final int GAP = 3;

    private Tick3CellPanel[][] cells = new Tick3CellPanel[SIZE][SIZE];

    private boolean locked = false;

    public Board() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(SIZE, SIZE, GAP, GAP));
        initBoard();
    }

    private void initBoard() {
        for (int k1 = 0; k1 < SIZE; k1++) {
            for (int k2 = 0; k2 < SIZE; k2++) {
                cells[k1][k2] = new Tick3CellPanel(k1, k2);
                cells[k1][k2].setCallbacks(this);
                add(cells[k1][k2]);
            }
        }
    }

    public boolean put(int x, int y, Stone stone) {
        if (locked) { return false; }
        return cells[x][y].put(stone);
    }

    public boolean isFinish(Stone stone) {
        //----  横方向の三連チェック
        for (int k1 = 0; k1 < SIZE; k1++) {
            boolean flag = true;
            for (int k2 = 0; k2 < SIZE; k2++) {
                if (!cells[k1][k2].isPut(stone)) {
                    flag = false;
                }
            }
            if (flag) { return true; }
        }

        //----  縦方向の三連チェック
        for (int k1 = 0; k1 < SIZE; k1++) {
            boolean flag = true;
            for (int k2 = 0; k2 < SIZE; k2++) {
                if (!cells[k2][k1].isPut(stone)) {
                    flag = false;
                }
            }
            if (flag) { return true; }
        }

        //----  左上から右下への三連チェック
        if (cells[0][0].isPut(stone)
                && cells[1][1].isPut(stone)
                && cells[2][2].isPut(stone) ) { return true; }

        //----  右上から左下への三連チェック
        if (cells[0][2].isPut(stone)
                && cells[1][1].isPut(stone)
                && cells[2][0].isPut(stone)) { return true;}
        return false;
    }

    public void lock() {
        locked = true;
    }

    //--- コールバックの処理

    @Override
    public void callbackMethod(int x, int y) {
        _callbacks.callbackMethod(x, y);
    }

    //--- コールバックメソッドの定義

    public interface Callbacks {
        public void callbackMethod(int x, int y);
    }

    private Callbacks _callbacks;

    public void setCallbacks(Callbacks callbacks) {
        _callbacks = callbacks;
    }
}
