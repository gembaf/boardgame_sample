package gui;

import java.util.EventListener;

public interface ISelectEvent extends EventListener {
    public void onSelect(int x, int y);
}
