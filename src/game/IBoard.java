package game;

public interface IBoard {
    public boolean put(int x, int y, Stone stone);

    public boolean isFinish(Stone stone);

    public void lock();
}
