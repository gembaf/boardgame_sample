package GameLib;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Board extends JPanel {
    private final int Size = 3;
    private final int Gap = 3;

    private Cell[][] cells = new Cell[Size][Size];

    public Board() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(Size, Size, Gap, Gap));
        initBoard();
    }

    private void initBoard() {
        for (int k1 = 0; k1 < Size; k1++) {
            for (int k2 = 0; k2 < Size; k2++) {
                cells[k1][k2] = new Cell();
                add(cells[k1][k2]);
            }
        }
    }
}
