package GameLib;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Cell extends JPanel {
    public Cell() {
        setBackground(Color.GREEN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
