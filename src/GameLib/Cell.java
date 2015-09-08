package GameLib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Cell extends JPanel implements MouseListener {
    private Stone stone = null;

    private Point point;

    public Cell(int x, int y) {
        point = new Point(x, y);
        setBackground(Color.GREEN);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (stone != null) {
            g.setColor(Color.RED);
            g.fillOval(3, 3, 90, 90);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        stone = new Stone();
        _callbacks.callbackMethod(point.x, point.y);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    //--- コールバックメソッドの定義

    public interface Callbacks {
        public void callbackMethod(int x, int y);
    }

    private Callbacks _callbacks;

    public void setCallbacks(Callbacks callbacks) {
        _callbacks = callbacks;
    }
}
