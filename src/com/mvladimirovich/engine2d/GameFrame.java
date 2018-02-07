package com.mvladimirovich.engine2d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame  extends JFrame implements KeyListener {

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        game.handleKeyEvent(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    private Playable game;

    GameFrame(Playable g) {
        super();
        game = g;
        this.setBounds(game.getBounds());
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        game.draw(graphics);
    }
}
