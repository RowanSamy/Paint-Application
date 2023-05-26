
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;


public class Circle extends Shape implements Cloneable{ // extend shape class and override its method as a circle instance and implements Cloneable to make clone of a circle
    private int x1,y1;
    private int x2,y2;

    public Circle(int x1, int y1, int x2, int y2, Color color,boolean fill) {
        super(color,fill);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
       g.setColor(getColor());
       if(!isFill()){ // draw unfilled circle
        if (x1 < x2 && y1 < y2) {
                    g.drawOval(x1, y1, x2 - x1, x2 - x1);
                } else if (x1 > x2 && y1 > y2) {
                    g.drawOval(x2, y2, Math.abs(x2 - x1), Math.abs(x2 - x1));
                }else if (x1 > x2 && y2 > y1)
                     g.drawOval(x2, y1, Math.abs(x2 -x1), Math.abs(x2 - x1));
                else if (x1 < x2 && y1 > y2 )
                    g.drawOval(x1, y2, Math.abs(x2 - x1), Math.abs(x2 - x1));
       }else{ // draw filled circle
           if (x1 < x2 && y1 < y2) {
                    g.fillOval(x1, y1, x2 - x1,  x2 - x1);
                } else if (x1 > x2 && y1 > y2) {
                    g.fillOval(x2, y2, Math.abs(x2 - x1), Math.abs( x2 - x1));
                }else if (x1 > x2 && y2 > y1)
                     g.fillOval(x2, y1, Math.abs(x2 -x1), Math.abs( x2 - x1));
                else if (x1 < x2 && y1 > y2 )
                    g.fillOval(x1, y2, Math.abs(x2 - x1), Math.abs( x2 - x1));  
       }
       
    }
     @Override   
    public Object clone() throws CloneNotSupportedException {
       shapes.Circle c =( shapes.Circle)super.clone();  // make a clone of a circle   
       JOptionPane.showMessageDialog(null, "Copied...");
       return c;
    }

    @Override
    public boolean contains(int x, int y) { // check if a circle contains a pressed point
       java.awt.Rectangle r = new java.awt.Rectangle(this.x1, this.y1, Math.abs(this.x1 - this.x2),Math.abs(this.x1 - this.x2));
        if (r.contains(x, y)) {   
            JOptionPane.showMessageDialog(null, "Selected...");
            return true;
        } else {
            return false;
    }

}
}
