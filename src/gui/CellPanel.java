package gui;

import game.ICell;
import game.Stone;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public abstract class CellPanel extends JPanel implements MouseListener, ICell {
    protected Stone stone;
    protected Point point;

    protected ISelectEvent listener = null;

    public CellPanel(int x, int y) {
        point = new Point(x, y);
        addMouseListener(this);
    }

    public boolean put(Stone stone) {
        if (this.stone != null) { return false; }
        this.stone = stone;
        repaint();
        return true;
    }

    public boolean isPut(Stone stone) {
        if (this.stone == null) { return false; }
        return this.stone.eqColor(stone);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (stone != null) {
            g.setColor(stone.getColor());
            g.fillOval(3, 3, 90, 90);
        }
    }

    public void addSelectListener(ISelectEvent listener) {
        this.listener = listener;
    }

    public void removeSelectListener() {
        this.listener = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
