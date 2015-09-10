package game;

public interface IBoard {
    public boolean put(int x, int y, Stone stone);

    public boolean isFinish(Stone stone);

    public void lock();

    public void callbackMethod(int x, int y);

    public interface Callbacks {
        public void callbackMethod(int x, int y);
    }

    public void setCallbacks(Callbacks callbacks);
}
