package com.mvladimirovich.engine2d;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Playable {

    void step();
    Rectangle getBounds();
    void draw(Graphics g);
    void handleKeyEvent(KeyEvent k);

}