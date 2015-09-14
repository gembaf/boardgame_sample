package tick3;

import game.Stone;
import gui.BoardPanel;

public class Tick3BoardPanel extends BoardPanel {
    private static final int SIZE = 3;
    private static final int GAP = 3;

    public Tick3BoardPanel() {
        super(SIZE, GAP);
        cells = new Tick3CellPanel[SIZE][SIZE];
        initBoard();
    }

    private void initBoard() {
        for (int k1 = 0; k1 < this.size; k1++) {
            for (int k2 = 0; k2 < this.size; k2++) {
                cells[k1][k2] = new Tick3CellPanel(k1, k2);
                cells[k1][k2].addSelectListener(this);
                add(cells[k1][k2]);
            }
        }
    }

    @Override
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
}
