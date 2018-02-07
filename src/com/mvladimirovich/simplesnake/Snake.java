package com.mvladimirovich.simplesnake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    List<Point> body;
    DirectionEnum direction;
    int doGrow = 0;

    public void grow(int growSize) {
        doGrow += growSize;
    }

    public void move(Point to) {
        if(doGrow == 0) {
            body.remove(0);
        } else {
            doGrow--;
        }
        body.add(to);
    }

    public Snake(Point startPoint){
        body = new ArrayList<>();
        body.add(startPoint);
    }

    public Point getHead() {
        return body.get(this.body.size()-1);
    }

    public Point getDesiredPoint() {
        switch (direction) {
            case up:
                return getHead().top();
            case down:
                return getHead().bottom();
            case left:
                return getHead().left();
            case right:
                return getHead().right();
            default:
                return getHead();
        }
    }
}
