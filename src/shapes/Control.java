
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Control extends JPanel implements MouseListener, MouseMotionListener {

    public static Color currentColor = Color.BLACK;
    public static boolean checkFill = false;
    public static int mode = -1;
    protected static int x1, y1;   
    protected static int x2, y2;
    protected boolean first = false;
    public static ArrayList<Shape> x = new ArrayList<Shape>(); // array of drawn shapes
    public static Shape selectedShape;
    public static Shape copy;
    public static int o = -1;
    
    public Control() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) { // paint the shapes array
        super.paintComponent(g);
        Iterator it = x.iterator(); //design pattern
        while (it.hasNext()) {
            Shape y = (Shape) it.next();
            y.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) { 
        x1 = me.getX(); // take the coordinates of the pressed point
        y1 = me.getY();
           
        ShapesFactory f = ShapesFactory.getInstance(); //design pattern factory
        if (mode == 0) { // draw a line
            Line l = (Line) f.createShape("Line", x1, y1, x1, y1, currentColor, checkFill);
            x.add(l);
            repaint();
        } else if (mode == 1) {  // draw a rectangle
            Rectangle r = (Rectangle) f.createShape("Rectangle", x1, y1, x1, y1, currentColor, checkFill);
            x.add(r);
            repaint();
        } else if (mode == 2) {  // draw a circle
            Circle c = (Circle) f.createShape("Circle", x1, y1, x1, y1, currentColor, checkFill);
            x.add(c);
            repaint();
        } else if (mode == 3) {  // draw a triangle
            Triangle t = (Triangle) f.createShape("Triangle", x1, y1, x1, y1, currentColor, checkFill);
            x.add(t);
            repaint();
        } else if (mode == 4) {  // draw a square
            Square sq = (Square) f.createShape("Square", x1, y1, x1, y1, currentColor, checkFill);
            x.add(sq);
            repaint();
        } else if (mode == 5) { // select an item
            selectedShape = null;
            for (int i = x.size() - 1; i >= 0; i--) {
                if (x.get(i).contains(x1, y1)) {                   
                    selectedShape = x.get(i);
                    o = i;
                    break;
                }
            }
        } else if (mode == 8) { // paste a copied shape
            if (copy != null) {
                try {
                    determineShape(copy);
                    copy = null;
                    repaint();
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (mode == 9) { // move a selected shape
            if (selectedShape != null) {                       
                try {
                    determineShape(selectedShape);
                    selectedShape = null;
                    repaint();
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (mode == 10) { // delete a selected shape
            try{
            x.get(o).setDelete(true);
            paint.GUI.undo.add(x.get(o));
            x.remove(o);
            o = -1;
            repaint();}catch (ArrayIndexOutOfBoundsException ex ){}
        } 
                else if (mode == -1) { // defult mode
            JOptionPane.showMessageDialog(null, "You have to choose a shape!!");
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (mode == 0) { // take the second coordinates of a drawn line
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Line) {
                Line l = (Line) s;
                l.setX2(x2);
                l.setY2(y2);
            }
            repaint();
            first = false;
        } else if (mode == 1) {  // take the second coordinates of a drawn rectangle
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
            first = false;
        } else if (mode == 2) { // take the second coordinates of a drawn circle
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Circle) {
                Circle c = (Circle) s;
                c.setX2(x2);
                c.setY2(y2);
            }
            repaint();
            first = false;
        } else if (mode == 3) { // take the second coordinates of a drawn triangle
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Triangle) {
                Triangle t = (Triangle) s;
                t.setX2(x2);
                t.setY2(y2);
            }
            repaint();
            first = false;
        } else if (mode == 4) { // take the second coordinates of a drawn square
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof shapes.Square) {
                shapes.Square sq = (shapes.Square) s;
                sq.setX2(x2);
                sq.setY2(y2);
            }
            repaint();
            first = false;
        } else if (mode == 6 || mode == 7) { // take the second coordinates of the copied and resized shapes
            x2 = me.getX();
            y2 = me.getY();
            if (selectedShape != null) {
                try {
                    determineShape(selectedShape);
                    x1 = 0;
                    y1 = 0;
                    repaint();                  
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    public static double distance(int x1, int y1, int x2, int y2) { // calculate the distance between two points
        double d = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        return d;
    }

    public void determineShape(Shape selectedShape) throws CloneNotSupportedException { // determine the shape instance
        /* in general if mode = 6 --> calling resize
        in general if mode = 7 --> calling copy
        in general if mode = 8 --> calling paste
        in general if mode = 9 --> calling move
        */ 
        if (selectedShape instanceof shapes.Line) {
            Line l = (Line) selectedShape;
            if (mode == 6) {
                effect.SelectLi.resizeLi(x2, y2, x1, y1, l);
            } else if (mode == 7) {
                effect.SelectLi.copyLi(l);
            } else if (mode == 8) {
                effect.SelectLi.pasteLi(l, x1, y1);
            } else if (mode == 9) {
                effect.SelectLi.moveLi(l, x1, y1);
            }           
            } else if (selectedShape instanceof shapes.Rectangle) {
            Rectangle r = (Rectangle) selectedShape;
            if (mode == 6) {
                effect.SelectRec.resizeRec(x2, y2, x1, y1, r);
            } else if (mode == 7) {
                effect.SelectRec.copyRec(r);
            } else if (mode == 8) {
                effect.SelectRec.pasteRec(r, x1, y1);
            } else if (mode == 9) {
                effect.SelectRec.moveRec(r, x1, y1);               
            } 
            }else if (selectedShape instanceof shapes.Circle) {
            Circle c = (Circle) selectedShape;
            if (mode == 6) {
                effect.SelectCir.resizeCir(x2, y2, x1, y1, c);
            } else if (mode == 7) {
                effect.SelectCir.copyCir(c);
            } else if (mode == 8) {
                effect.SelectCir.pasteCir(c, x1, y1);
            } else if (mode == 9) {                
                effect.SelectCir.moveCir(c, x1, y1);
            }
        } else if (selectedShape instanceof shapes.Square) {
            Square sq = (Square) selectedShape;
            if (mode == 6) {
                effect.SelectSqu.resizeSqu(x2, y2, x1, y1, sq);
            } else if (mode == 7) {
                effect.SelectSqu.copySqu(sq);
            } else if (mode == 8) {
                effect.SelectSqu.pasteSqu(sq, x1, y1);
            } else if (mode == 9) {
                effect.SelectSqu.moveSqu(sq, x1, y1);
            }
        } else {
            Triangle t = (Triangle) selectedShape;
            if (mode == 6) {
                effect.SelectTri.resizeTri(x2, y2, x1, y1, t);
            } else if (mode == 7) {
                effect.SelectTri.copyTri(t);
            } else if (mode == 8) {
                effect.SelectTri.pasteTri(t, x1, y1);
            } else if (mode == 9) {
                effect.SelectTri.moveTri(t, x1, y1);
            } } 
    
    
    }






}
