
package effect;

import java.awt.Color;
import shapes.Rectangle;
import shapes.ShapesFactory;


public class SelectRec extends shapes.Rectangle {
      // this class is called when the selectedSahpe was instance of Rectangle
    public static void resizeRec (int x2, int y2, int x1, int y1, Rectangle r) // resize the rectangle
    {
             ShapesFactory f =ShapesFactory.getInstance();
                Rectangle rCopy = (Rectangle) f.createShape("Rectangle", r.getX1(), r.getY1(), r.getX2(), r.getY2(),r.getColor(), r.isFill());
                if (r.getX1()>  x2 && r.getY1()> y2)  {       //if the pressend point was on top-left
                 rCopy.setX1(x2);
                 rCopy.setY1(y2);    
                }
                else if (r.getX2()< x2 && r.getY1()>y2) {  //if the pressend point was near top-right
                     rCopy.setX2(x2);
                     rCopy.setY1(y2);
                }else if (r.getX1()>x2 && r.getY2()<y2){   //if the pressend point was near bottom-left 
                     rCopy.setX1(x2);
                     rCopy.setY2(y2);
                }else if ( r.getX2()<x2 && r.getY2()<y2){   //if the pressend point was near bottom-right 
                     rCopy.setX2(x2);
                     rCopy.setY2(y2);
                }
                else
                { // minimiziation
                    double i1=shapes.Control.distance(x2,y2,r.getX1(),r.getY1());
                    double i2=shapes.Control.distance(x2,y2,r.getX2(),r.getY1());
                    double i3=shapes.Control.distance(x2,y2,r.getX1(),r.getY2());
                    double i4=shapes.Control.distance(x2,y2,r.getX2(),r.getY2());
                       if(i1<i2 && i1<i3 && i1<i4)
                       { //if the pressend point was near top-left point
                            rCopy.setX1(x2);
                            rCopy.setY1(y2);  
                       }
                       else if(i2<i3 && i2<i4)
                       { //if the pressend point was near top-right point
                           rCopy.setX2(x2);
                            rCopy.setY1(y2);  
                       }
                       else if (i3<i4)
                       { //if the pressend point was near bottom-left point
                        rCopy.setX1(x2);
                        rCopy.setY2(y2);   
                       }
                       else { //if the pressend point was near bottom-right point
                          rCopy.setX2(x2);
                          rCopy.setY2(y2); 
                      
                       }     
                }
                r.setResized(true);              
                shapes.Control.x.remove(shapes.Control.o);             
                shapes.Control.x.add(shapes.Control.o,rCopy); // add the new resized rectangle to the shapes array
                  
}
    public static void copyRec ( shapes.Rectangle r) throws CloneNotSupportedException
    {  // copy the rectangle
         shapes.Control.copy = null;
        shapes.Control.copy = ((Rectangle) r.clone());  // make a clone of the selected Rectangle     
      
    }
 public static void pasteRec ( shapes.Rectangle r, int x2, int y2)
 { // paste the rectangle
    int length = Math.abs(r.getX1()-r.getX2());
    int width = Math.abs(r.getY1()-r.getY2());
   ShapesFactory f =ShapesFactory.getInstance();
   Rectangle rCopy = (Rectangle) f.createShape("Rectangle", 0, 0, 0, 0, Color.BLACK, false);
   // setting the dimensions, color and fill for the paste Rectangle
     rCopy.setX1(x2);
     rCopy.setX2(x2 + length);
     rCopy.setY1(y2);
     rCopy.setY2(y2 + width); 
     rCopy.setColor(r.getColor());
     rCopy.setFill(r.isFill());
     shapes.Control.x.add(rCopy); // add the new paste rectangle to the shapes array
 }
 
 public static void moveRec ( shapes.Rectangle r, int x2, int y2)
 {// move the rectangle
ShapesFactory f =ShapesFactory.getInstance();
Rectangle rCopy = (Rectangle) f.createShape("Rectangle", r.getX1(), r.getY1(), r.getX2(), r.getY2(),r.getColor(), r.isFill());
    int length = Math.abs(r.getX1()-r.getX2());
    int width = Math.abs(r.getY1()-r.getY2());
    // setting the dimensions, color and fill for the moved rectangle
     rCopy.setX1(x2);
     rCopy.setX2(x2 + length);
     rCopy.setY1(y2);
     rCopy.setY2(y2 + width); 
       r.setMoved(true);              
       shapes.Control.x.remove(shapes.Control.o);             
     shapes.Control.x.add(rCopy); // add the new paste rectangle to the shapes array
 }

    public SelectRec(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
    }
   
    
    
}