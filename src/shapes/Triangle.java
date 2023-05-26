
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;


public class Triangle extends Shape  implements Cloneable{ // extend shape class and override its method as a triangle instance and implements Cloneable to make clone of a triangle
  private int z[]=new int[3];
  private int y[]=new int[3];
  private int x1,y1;
  private int x2,y2;

   public Triangle(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(color, fill);
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
    
     public void setArray()
    { // set the points of the triangle in arrays
        z[0]=x1;
        y[0]=y1;
        z[1]=x2;
        y[1]=y2;  
        y[2] = y2;
        z[2] = 2*x1 - x2;
    }
    public int getLastElementX()
    { // get the x coordinate of the bottom-right point
      return this.z[2];  
    }
     public int getLastElementY()
    {
      return this.y[2];  
    }
    @Override
    public void draw(Graphics g) { 
       g.setColor(getColor());
       setArray();
        if(!isFill()){  // draw unfilled triangle
            g.drawPolygon(z,y,3);           
        }
        else // draw unfilled triangle
          g.fillPolygon(z,y,3);      
       
    }
     @Override   
    public Object clone() throws CloneNotSupportedException {
       shapes.Triangle t =( shapes.Triangle)super.clone();  // make a clone of a triangle    
       JOptionPane.showMessageDialog(null, "Copied...");
       return t;
    }

    @Override
    public boolean contains(int x, int y) {  // check if a triangle contains a pressed point
       java.awt.Polygon t = new java.awt.Polygon(this.y, this.z, 3); 
        if (t.contains(x, y)) {
            JOptionPane.showMessageDialog(null, "Selected...");
            return true;
        } else {
            return false;
        }
    }
    }
    
    
    

