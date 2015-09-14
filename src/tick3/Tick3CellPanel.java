package tick3;

import gui.CellPanel;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class Tick3CellPanel extends CellPanel {
    public Tick3CellPanel(int x, int y) {
        super(x, y);
        setBackground(Color.GREEN);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        listener.onSelect(point.x, point.y);
    }
}
