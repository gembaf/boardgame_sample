package gui;

import game.IBoard;
import game.ICell;
import game.Stone;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class BoardPanel extends JPanel implements IBoard, ICell.Callbacks {
    protected int size;

    protected CellPanel[][] cells;

    protected boolean locked = false;

    public BoardPanel(int size, int gap) {
        this.size = size;
        setBackground(Color.BLACK);
        setLayout(new GridLayout(size, size, gap, gap));
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
