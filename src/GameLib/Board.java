package GameLib;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Board extends JPanel {
    private static final int SIZE = 3;
    private static final int GAP = 3;

    private Cell[][] cells = new Cell[SIZE][SIZE];

    public Board() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(SIZE, SIZE, GAP, GAP));
        initBoard();
    }

    private void initBoard() {
        for (int k1 = 0; k1 < SIZE; k1++) {
            for (int k2 = 0; k2 < SIZE; k2++) {
                cells[k1][k2] = new Cell();
                add(cells[k1][k2]);
            }
        }
    }
}
