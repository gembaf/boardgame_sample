package game;

public interface ICell {
    public boolean put(Stone stone);

    public boolean isPut(Stone stone);

    public interface Callbacks {
        public void callbackMethod(int x, int y);
    }

    public void setCallbacks(Callbacks callbacks);
}
