package com.mvladimirovich.simplesnake;

import com.mvladimirovich.engine2d.Playable;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Instant;
import java.util.Random;

public class SnakeGame implements Playable {

    private Random r = new Random(Instant.now().getEpochSecond());
    private int size;
    private int[][] fieldmap;
    private Snake snake;
    private int drawmul = 10;

    public static Playable createNewGame() {
        return new SnakeGame(20);
    }

    SnakeGame(int size) {
        // init game field
        this.size = size;
        resetGame();
    }

    private void resetGame() {
        fieldmap = new int[size][size];
        Point startPoint = new Point(size / 2, size / 2);
        snake = new Snake(startPoint);
        snake.direction = DirectionEnum.up;
        addApple();
    }

    private void addApple() {
        int x = r.nextInt(size);
        int y = r.nextInt(size);
        fieldmap[x][y] = 1;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(0, 0, size * drawmul, size * drawmul);
    }

    @Override
    public void draw(Graphics g) {
        drawField(g);
        drawSnake(g);
    }

    private void drawField(Graphics g) {
        for(int i = 0; i< size; i++) {
            for(int j = 0; j< size; j++) {
                switch (fieldmap[i][j]) {
                    case 1:
                        g.setColor(Color.GREEN);
                        g.fillRect(i * drawmul + 1, j * drawmul + 1, drawmul - 1, drawmul - 1);
                    default:
                        break;
                }
            }
        }
    }

    private void drawSnake(Graphics g) {
        for(Point pt : snake.body) {
            g.setColor(Color.BLACK);
            g.fillRect(pt.x * drawmul + 1, pt.y * drawmul + 1, drawmul - 1, drawmul -1 );
        }
    }

    @Override
    public void step() {
        Point desired = snake.getDesiredPoint();
        if(!checkBounds(desired)) {
            resetGame();
            return;
        }
        if (fieldmap[desired.x][desired.y] == 1) {
            snake.grow(4);
            fieldmap[desired.x][desired.y] = 0;
            addApple();
        }
        snake.move(desired);
    }

    private boolean checkBounds(Point desired) {
        if (desired.x < 0 || desired.x >= size || desired.y < 0 || desired.y >= size) {
            return false;
        }
        return true;
    }

    @Override
    public void handleKeyEvent(KeyEvent k) {
        switch (k.getKeyChar()) {
            case 'w':
                snake.direction = DirectionEnum.up;
                break;
            case 's':
                snake.direction = DirectionEnum.down;
                break;
            case 'a':
                snake.direction = DirectionEnum.left;
                break;
            case 'd':
                snake.direction = DirectionEnum.right;
                break;
            default:
                break;
        }
        System.out.println(snake.direction);
    }
}
