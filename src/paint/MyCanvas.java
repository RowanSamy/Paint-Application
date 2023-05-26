package paint;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;
  
class MyCanvas extends JComponent {
  
    public void paint(Graphics g)
    {
  
        // draw and display the line
        g.drawLine(30, 20, 80, 90);
    }
}
  
