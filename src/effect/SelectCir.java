
package effect;

import java.awt.Color;
import shapes.Circle;
import static shapes.Control.o;
import shapes.ShapesFactory;

public class SelectCir extends shapes.Circle {  // this class is called when the selectedSahpe was instance of Circle
    
    public SelectCir(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
    }
   

    public static void resizeCir(int x2, int y2, int x1, int y1, shapes.Circle c) // resize the circle
    {
        ShapesFactory f =ShapesFactory.getInstance();
        Circle cCopy = (Circle) f.createShape("Circle", c.getX1(), c.getY1(), c.getX2(), c.getY2(),c.getColor(), c.isFill());
        if (c.getX1()>  x2 && c.getY1()> y2)  {    //if the pressend point was on top-left
            cCopy.setX1(x2);
            cCopy.setY1(y2);
        }
        else if (c.getX2()< x2 && c.getY1()>y2) {   //if the pressend point was near top-right
            cCopy.setX2(x2);
            cCopy.setY1(y2);
        }else if (c.getX1()>x2 && c.getY2()<y2){    //if the pressend point was near bottom-left
            cCopy.setX1(x2);
            cCopy.setY2(y2);
        }else if ( c.getX2()<x2 && c.getY2()<y2){  //if the pressend point was near bottom-right
            cCopy.setX2(x2);
            cCopy.setY2(y2);
        }
        else
        { // minimiziation
            double i1=shapes.Control.distance(x2,y2,c.getX1(),c.getY1());
            double i2=shapes.Control.distance(x2,y2,c.getX2(),c.getY1());
            double i3=shapes.Control.distance(x2,y2,c.getX1(),c.getY2());
            double i4=shapes.Control.distance(x2,y2,c.getX2(),c.getY2());
            if(i1<i2 && i1<i3 && i1<i4)
            { //if the pressend point was near top-left point
                cCopy.setX1(x2);
                cCopy.setY1(y2);
            }
            else if(i2<i3 && i2<i4)
            {  //if the pressend point was near top-right point
                cCopy.setX2(x2);
                cCopy.setY1(y2);
            }
            else if (i3<i4)
            {  //if the pressend point was near bottom-left point
                cCopy.setX1(x2);
                cCopy.setY2(y2);
            }
            else {  //if the pressend point was near bottom-right point
                cCopy.setX2(x2);
                cCopy.setY2(y2);
            }
        }
        try{
        c.setResized(true);
        shapes.Control.x.remove(shapes.Control.o);
        shapes.Control.x.add(o, cCopy); // add the new resized circle to the shapes array
        }catch(ArrayIndexOutOfBoundsException ex){}
    }
    public static void copyCir ( shapes.Circle c) throws CloneNotSupportedException
    {     // copy the circle
         shapes.Control.copy = null;
        shapes.Control.copy = ((Circle) c.clone());  // make a clone of the selected Circle  
    }
 public static void pasteCir ( shapes.Circle c, int x2, int y2)
 { // paste the circle
    int length = Math.abs(c.getX1()-c.getX2());
  ShapesFactory f =ShapesFactory.getInstance();
  Circle cCopy = (Circle) f.createShape("Circle", 0, 0, 0, 0, Color.BLACK, false);
  // setting the dimensions, color and fill for the paste circle
     cCopy.setX1(x2);
     cCopy.setX2(x2 + length);
     cCopy.setY1(y2);
     cCopy.setY2(y2 + length); 
     cCopy.setColor(c.getColor());
     cCopy.setFill(c.isFill());
     shapes.Control.x.add(cCopy); // add the new paste circle to the shapes array
 }
               
public static void moveCir ( shapes.Circle c, int x2, int y2)
 { // move the circle
      ShapesFactory f =ShapesFactory.getInstance();
      Circle cCopy = (Circle) f.createShape("Circle", c.getX1(), c.getY1(), c.getX2(), c.getY2(),c.getColor(), c.isFill());
    int length = Math.abs(c.getX1()-c.getX2());
     // setting the dimensions, color and fill for the moved circle
     cCopy.setX1(x2);
     cCopy.setX2(x2 + length);
     cCopy.setY1(y2);
     cCopy.setY2(y2 + length); 
      c.setMoved(true);              
                shapes.Control.x.remove(shapes.Control.o);             
                shapes.Control.x.add(cCopy); // add the new paste circle to the shapes array
 }         
}
