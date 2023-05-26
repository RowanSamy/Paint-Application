
package effect;

import java.awt.Color;
import shapes.Line;
import shapes.ShapesFactory;

public class SelectLi extends shapes.Line {
     // this class is called when the selectedSahpe was instance of Line
    public static void resizeLi (int x2, int y2, int x1, int y1, shapes.Line l) // resize the line
    {
               ShapesFactory f =ShapesFactory.getInstance();
                Line lCopy = (Line) f.createShape("Line", l.getX1(), l.getY1(), l.getX2(), l.getY2(),l.getColor(), l.isFill());
               
                    double i1=shapes.Control.distance(x2,y2,l.getX1(),l.getY1());
                    double i2=shapes.Control.distance(x2,y2,l.getX2(),l.getY2());
                       if(i1<i2 )
                       { //if the pressend point was near top point
                            lCopy.setX1(x2);
                            lCopy.setY1(y2);  
                       }
                       else 
                       { //if the pressend point was near bottom point
                           lCopy.setX2(x2);
                            lCopy.setY2(y2);  
                       }
                    l.setResized(true);              
                shapes.Control.x.remove(shapes.Control.o);             
                shapes.Control.x.add(shapes.Control.o,lCopy);      // add the new resized circle to the shapes array
                }
    public static void copyLi ( shapes.Line l) throws CloneNotSupportedException
    {// copy the line
         shapes.Control.copy = null;        
        shapes.Control.copy = (( shapes.Line) l.clone());   // make a clone of the selected line         
    }
    public static void pasteLi ( shapes.Line l, int x2, int y2)
 { // paste the line
    int length = Math.abs(l.getX1()-l.getX2());
    int width = Math.abs(l.getY1()-l.getY2());
    ShapesFactory f = ShapesFactory.getInstance();
    shapes.Line lCopy = ( shapes.Line) f.createShape("Line", 0, 0, 0, 0, Color.BLACK, false);
     // setting the dimensions, color for the paste line
     lCopy.setX1(x2);
     lCopy.setX2(x2 + length);
     lCopy.setY1(y2);
     lCopy.setY2(y2 + width); 
     lCopy.setColor(l.getColor());
     lCopy.setFill(l.isFill());
     shapes.Control.x.add(lCopy); // add the new paste line to the shapes array
 }
    public static void moveLi ( shapes.Line l, int x2, int y2)
 {// move the line
      ShapesFactory f =ShapesFactory.getInstance(); 
      Line lCopy = (Line) f.createShape("Line", l.getX1(), l.getY1(), l.getX2(), l.getY2(),l.getColor(), l.isFill());
    int length = Math.abs(l.getX1()-l.getX2());
    int width = Math.abs(l.getY1()-l.getY2());
     // setting the dimensions, color for the moved line
     lCopy.setX1(x2);
     lCopy.setX2(x2 + length);
     lCopy.setY1(y2);
     lCopy.setY2(y2 + width); 
     l.setMoved(true);              
                shapes.Control.x.remove(shapes.Control.o);             
                shapes.Control.x.add(lCopy);  // add the new paste line to the shapes array
 }

    public SelectLi(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
    }
               
               

   
}
