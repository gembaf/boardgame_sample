package tick3;

import game.Stone;
import gui.BoardPanel;

public class Tick3BoardPanel extends BoardPanel {
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
