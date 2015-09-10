package gui;

import game.IBoard;
import game.ICell;
import game.Stone;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import tick3.Tick3CellPanel;

public abstract class BoardPanel extends JPanel implements IBoard, ICell.Callbacks {
    protected static final int SIZE = 3;
    protected static final int GAP = 3;

    protected Tick3CellPanel[][] cells = new Tick3CellPanel[SIZE][SIZE];

    protected boolean locked = false;

    public BoardPanel() {
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

    @Override
    public boolean put(int x, int y, Stone stone) {
        if (locked) { return false; }
        return cells[x][y].put(stone);
    }

    @Override
    public abstract boolean isFinish(Stone stone);

    @Override
    public void lock() {
        locked = true;
    }

    protected IBoard.Callbacks _callbacks;

    @Override
    public void callbackMethod(int x, int y) {
        _callbacks.callbackMethod(x, y);
    }

    @Override
    public void setCallbacks(IBoard.Callbacks callbacks) {
        _callbacks = callbacks;
    }
}
