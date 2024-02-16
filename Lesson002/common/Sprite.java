package Lesson002.common;

import Lesson002.common.Interactable;
import Lesson002.common.MainCanvas;

import java.awt.*;
import java.awt.event.MouseListener;

public abstract class Sprite implements Interactable{
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHiegth;
    protected float getLeft() {
        return x - halfWidth;
    }
    protected void setLeft(float left) {
        x = left + halfWidth;
    }
    protected float getRight () {
        return x + halfWidth;
    }
    protected void setRight(float right) {
        x = right - halfWidth;
    }
    protected float getTop() {
        return y - halfHiegth;
    }
    protected void setTop(float top) {
        y = top + halfHiegth;
    }
    protected float getBottom() {
        return y + halfHiegth;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHiegth;
    }

    protected float getWidth() {
        return 2f*halfWidth;
    }
    protected float getHeight() {
        return 2f*halfHiegth;
    }

    public void update(MainCanvas canvas, float deltaTime) {}
    public void render(MainCanvas canvas, Graphics g) {}
}
