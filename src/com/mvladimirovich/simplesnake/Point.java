package com.mvladimirovich.simplesnake;

public class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point top() { return new Point(x, y-1); }
    public Point bottom() { return new Point(x, y+1); }
    public Point left() { return new Point(x-1, y); }
    public Point right() { return new Point(x+1, y); }
}
