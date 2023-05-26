package effect;

import java.awt.Color;
import shapes.ShapesFactory;
import shapes.Triangle;

public class SelectTri {
// this class is called when the selectedSahpe was instance of Triangle
    public static void resizeTri(int x2, int y2, int x1, int y1, shapes.Triangle t) { // resize the triangle

        ShapesFactory f = ShapesFactory.getInstance();
        Triangle tCopy = (Triangle) f.createShape("Triangle", t.getX1(), t.getY1(), t.getX2(), t.getY2(), t.getColor(), t.isFill());
        double i1 = shapes.Control.distance(x2, y2, t.getX1(), t.getY1());
        double i2 = shapes.Control.distance(x2, y2, t.getX2(), t.getY2());
        double i3 = shapes.Control.distance(x2, y2, t.getLastElementX(), t.getLastElementY());

        if (i1 < i2 && i1 < i3) { //if the pressend point was near top point
            tCopy.setY1(y2);
        } else if (i2 < i3 && y2 > t.getY1()) {  //if the pressend point was near bottom-right point
            int step = x2 - t.getX2();
            tCopy.setY2(y2);
            tCopy.setX2(x2);
            tCopy.setX1(t.getX1() + step);
        } else { //if the pressend point was near bottom-left point
            int step = x2 - t.getLastElementX();
            tCopy.setY2(y2);
            tCopy.setX1(t.getX1() - step);
        }
        t.setResized(true);
        shapes.Control.x.remove(shapes.Control.o);
        shapes.Control.x.add(shapes.Control.o,tCopy);  // add the new resized triangle to the shapes array
    }

    public static void copyTri(shapes.Triangle t) throws CloneNotSupportedException {
         // copy the triangle
        shapes.Control.copy = null;
        shapes.Control.copy = ((Triangle) t.clone()); // make a clone of the selected Triangle  
    }

    public static void pasteTri(shapes.Triangle t, int x2, int y2) {
        // paste the triangle
        int vertixDiffY = y2 - t.getY1();
        int vertixDiffX = x2 - t.getX1();
        ShapesFactory f = ShapesFactory.getInstance();
        Triangle tCopy = (Triangle) f.createShape("Triangle", 0, 0, 0, 0, Color.BLACK, false);
        // setting the dimensions, color and fill for the paste triangle
        tCopy.setX1(x2);
        tCopy.setY1(y2);
        tCopy.setX2(t.getX2() + vertixDiffX);
        tCopy.setY2(t.getY2() + vertixDiffY);
        tCopy.setColor(t.getColor());
        tCopy.setFill(t.isFill());
        shapes.Control.x.add(tCopy); // add the new paste triangle to the shapes array
    }

    public static void moveTri(shapes.Triangle t, int x2, int y2) {
        // move the triangle
        ShapesFactory f = ShapesFactory.getInstance();
        Triangle tCopy = (Triangle) f.createShape("Triangle", t.getX1(), t.getY1(), t.getX2(), t.getY2(), t.getColor(), t.isFill());
        // setting the dimensions, color and fill for the moved triangle
        int vertixDiffY = y2 - t.getY1();
        int vertixDiffX = x2 - t.getX1();
        tCopy.setX1(x2);
        tCopy.setY1(y2);
        tCopy.setX2(t.getX2() + vertixDiffX);
        tCopy.setY2(t.getY2() + vertixDiffY);
        t.setMoved(true);
        shapes.Control.x.remove(shapes.Control.o);
        shapes.Control.x.add(tCopy); // add the new paste triangle to the shapes array
    }
}
