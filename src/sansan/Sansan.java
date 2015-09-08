package sansan;

import javax.swing.JApplet;

import GameLib.Board;

public class Sansan extends JApplet {
    @Override
    public void init() {
        Board board = new Board();
        setContentPane(board);
    }
}

