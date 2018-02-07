package com.mvladimirovich.engine2d;

import com.mvladimirovich.simplesnake.SnakeGame;

import javax.swing.*;
import java.sql.Date;
import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class Application {

    public static void main(String[] args) {

        Playable g = SnakeGame.createNewGame();

        GameFrame mainFrame = new GameFrame(g);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        // run event loop
        java.util.Timer t  =new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                g.step();
                mainFrame.repaint();
            }
        }, Date.from(Instant.now()),500);
    }
}
