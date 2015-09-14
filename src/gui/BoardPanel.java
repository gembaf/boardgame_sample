package gui;

import game.IBoard;
import game.Stone;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class BoardPanel extends JPanel implements IBoard, ISelectEvent {
    protected int size;

    protected CellPanel[][] cells;

    protected boolean locked = false;

    protected ISelectEvent listener = null;

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

    public void addSelectListener(ISelectEvent listener) {
        this.listener = listener;
    }

    public void removeSelectListener() {
        this.listener = null;
    }

    public void onSelect(int x, int y) {
        listener.onSelect(x, y);
    }
}
