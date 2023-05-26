
package shapes;

import java.awt.Color;
import java.awt.Graphics;


public abstract class Shape {

    private Color color;
    private boolean fill;
    private boolean resized = false;
    private boolean moved = false;
    private boolean delete = false;

    public Shape(Color color, boolean fill) {
        this.color = color;
        this.fill = fill;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isResized() {
        return resized;
    }

    public void setResized(boolean resized) {
        this.resized = resized;
    }

    public Shape() {
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public abstract boolean contains(int x, int y);

}
