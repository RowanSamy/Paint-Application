package shapes;

import java.awt.Color;

public class ShapesFactory {

    private static ShapesFactory sf = null;

    private ShapesFactory() {
    }

    public static ShapesFactory getInstance() {
        if (sf == null) { //design pattern
            sf = new ShapesFactory();
        }
        return sf;
    }

    public Shape createShape(String name, int x1, int y1, int x2, int y2, Color color, boolean fill) {
        // creat an instance required
        if (name.equals("Rectangle")) {
            return new Rectangle(x1, y1, x2, y2, color, fill);
        }
        if (name.equals("Circle")) {
            return new Circle(x1, y1, x2, y2, color, fill);
        }
        if (name.equals("Line")) {
            return new Line(x1, y1, x2, y2, color, fill);
        }
        if (name.equals("Square")) {
            return new Square(x1, y1, x2, y2, color, fill);
        }
        if (name.equals("Triangle")) {
            return new Triangle(x1, y1, x2, y2, color, fill);
        }
        return null;

    }

}
