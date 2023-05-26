
package effect;

import java.awt.Color;
import shapes.ShapesFactory;
import shapes.Square;


public class SelectSqu extends shapes.Square {
        // this class is called when the selectedSahpe was instance of Square
    public static void resizeSqu (int x2, int y2, int x1, int y1, shapes.Square s) // resize the square
    {

ShapesFactory f =ShapesFactory.getInstance();
Square sqCopy = (Square) f.createShape("Square", s.getX1(), s.getY1(), s.getX2(), s.getY2(),s.getColor(), s.isFill());
                if (s.getX1()>  x2 && s.getY1()> y2)  {    //if the pressend point was on top-left
                 sqCopy.setX1(x2);
                 sqCopy.setY1(y2);    
                }
                else if (s.getX2()< x2 && s.getY1()>y2) {   //if the pressend point was near top-right
                     sqCopy.setX2(x2);
                     sqCopy.setY1(y2);
                }else if (s.getX1()>x2 && s.getY2()<y2){    //if the pressend point was near bottom-left
                     sqCopy.setX1(x2);
                     sqCopy.setY2(y2);
                }else if ( s.getX2()<x2 && s.getY2()<y2){   //if the pressend point was near bottom-right 
                     sqCopy.setX2(x2);
                     sqCopy.setY2(y2);
                }
                else
                { // minimiziation
                    double i1=shapes.Control.distance(x2,y2,s.getX1(),s.getY1());
                    double i2=shapes.Control.distance(x2,y2,s.getX2(),s.getY1());
                    double i3=shapes.Control.distance(x2,y2,s.getX1(),s.getY2());
                    double i4=shapes.Control.distance(x2,y2,s.getX2(),s.getY2());
                       if(i1<i2 && i1<i3 && i1<i4)
                       {  //if the pressend point was near top-left point
                            sqCopy.setX1(x2);
                            sqCopy.setY1(y2);  
                       }
                       else if(i2<i3 && i2<i4)
                       { //if the pressend point was near top-right point
                           sqCopy.setX2(x2);
                            sqCopy.setY1(y2);  
                       }
                       else if (i3<i4)
                       { //if the pressend point was near bottom-left point
                        sqCopy.setX1(x2);
                        sqCopy.setY2(y2);   
                       }
                       else { //if the pressend point was near bottom-right point
                          sqCopy.setX2(x2);
                          sqCopy.setY2(y2); 
                      
                       }     
                }
                s.setResized(true);              
                shapes.Control.x.remove(shapes.Control.o);             
                shapes.Control.x.add(shapes.Control.o,sqCopy); // add the new resized square to the shapes array
   
}
        public static void copySqu ( shapes.Square sq) throws CloneNotSupportedException
    {   // copy the square
         shapes.Control.copy = null;
        shapes.Control.copy = ((Square) sq.clone()); // make a clone of the selected Square     
    }
 public static void pasteSqu ( shapes.Square sq, int x2, int y2)
 { // paste the square
    int length = Math.abs(sq.getX1()-sq.getX2());
ShapesFactory f =ShapesFactory.getInstance();
Square sqCopy = (Square) f.createShape("Square", 0, 0, 0, 0, Color.BLACK, false);
// setting the dimensions, color and fill for the paste square
     sqCopy.setX1(x2);
     sqCopy.setX2(x2 + length);
     sqCopy.setY1(y2);
     sqCopy.setY2(y2 + length); 
     sqCopy.setColor(sq.getColor());
     sqCopy.setFill(sq.isFill());
     shapes.Control.x.add(sqCopy); // add the new paste square to the shapes array
 }
public static void moveSqu ( shapes.Square sq, int x2, int y2)
 { // move the square
ShapesFactory f =ShapesFactory.getInstance();
Square sqCopy = (Square) f.createShape("Square", sq.getX1(), sq.getY1(), sq.getX2(), sq.getY2(),sq.getColor(), sq.isFill());
    int length = Math.abs(sq.getX1()-sq.getX2());
    // setting the dimensions, color and fill for the moved square
     sqCopy.setX1(x2);
     sqCopy.setX2(x2 + length);
     sqCopy.setY1(y2);
     sqCopy.setY2(y2 + length); 
     sq.setMoved(true);              
     shapes.Control.x.remove(shapes.Control.o);             
     shapes.Control.x.add(sqCopy); // add the new paste square to the shapes array
   
 }               

    public SelectSqu(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
    }


}