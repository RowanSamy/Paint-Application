
package paint;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import shapes.Shape;

public class GUI extends javax.swing.JFrame  {

    public GUI() {
        initComponents();
        
    }
   public static ArrayList<Shape> undo = new ArrayList<Shape>();
    public static ArrayList<Shape> revUndo = new ArrayList<Shape>();
    public static int no =0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shape = new javax.swing.JComboBox<>();
        drawingArea = new shapes.Control();
        fill = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        select = new javax.swing.JButton();
        resize = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shape.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        shape.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a shape", "Line", "Circle", "Rectangle", "Square", "Triangle" }));
        shape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shapeActionPerformed(evt);
            }
        });
        getContentPane().add(shape, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 99, 237, -1));

        drawingArea.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout drawingAreaLayout = new javax.swing.GroupLayout(drawingArea);
        drawingArea.setLayout(drawingAreaLayout);
        drawingAreaLayout.setHorizontalGroup(
            drawingAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        drawingAreaLayout.setVerticalGroup(
            drawingAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        getContentPane().add(drawingArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 860, 800));

        fill.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        fill.setText("Fill shape");
        fill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillActionPerformed(evt);
            }
        });
        getContentPane().add(fill, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 130, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setText("Colors");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 108, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton3.setText("Undo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 550, 237, -1));

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton4.setText("Redo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 605, 237, -1));

        select.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        getContentPane().add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 215, 237, 42));

        resize.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        resize.setText("Re-size");
        resize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resizeActionPerformed(evt);
            }
        });
        getContentPane().add(resize, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 440, 237, -1));

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton5.setText("Copy");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 275, 237, -1));

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton6.setText("Paste");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 330, 237, -1));

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton7.setText("Move");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 385, 237, -1));

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 495, 237, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 660, 237, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 0));
        jLabel1.setText("Welcome to our paint!!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 29, 237, 52));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paint/BackGround.jpeg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 340, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void shapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shapeActionPerformed
        // TODO add your handling code here:        
        Object selectedItem = shape.getSelectedItem();
        String selectedItemStr = selectedItem.toString();        
        if(!selectedItemStr.equals("Choose a shape")){    // determine the choosen shape from the user      
            if(selectedItemStr.equals("Line"))
            {
                drawingArea.mode = 0;  
            }
            else if(selectedItemStr.equals("Rectangle"))
            {
                 drawingArea.mode = 1;                
            }
            
            else if (selectedItemStr.equals("Circle"))
            {
              drawingArea.mode = 2;
            }  
            else if (selectedItemStr.equals("Triangle"))
            {
              drawingArea.mode = 3; 
        }else if(selectedItemStr.equals("Square") )
            {
                drawingArea.mode=4;
            }
        else {
           drawingArea. mode=-1;   
        }
        }     
    }//GEN-LAST:event_shapeActionPerformed

    private void fillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillActionPerformed
        // TODO add your handling code here:
        if (fill.isSelected()) // check if the user want the shape filled or not
            shapes.Control.checkFill=true;
        else 
            shapes.Control.checkFill=false;   
    }//GEN-LAST:event_fillActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Colors c = new Colors(); // show color chooser
        c.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i<undo.size(); i++)
        undo.remove(i);
        drawingArea.x.clear();  // clear the drawing area
        repaint();
        JOptionPane.showMessageDialog(null, "Drawing Area is Clear...");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        boolean t = true;
        try{ // to catch out of bounds error
        if (undo.size() != 0){
        if (undo.get(undo.size()-1).isDelete())
        {     // undo the delete task           
            t = false;
            no++;
            drawingArea.x.add(undo.get(undo.size()-1));
            undo.remove(undo.size()-1); 
            repaint();   
        }
        else if (undo.get(undo.size()-1).isResized() || undo.get(undo.size()-1).isMoved())
        {   // undo the resize task and move task   
          t = false;
          undo.add( drawingArea.x.get(drawingArea.x.size()-1));
          drawingArea.x.remove(drawingArea.x.size()-1);       
          drawingArea.x.add(undo.get(undo.size()-2));
          undo.remove(undo.size()-2); 
          repaint();         
        }}      
        if (drawingArea.x.size()!=0 && t )
        {           // undo the drawing task                          
            undo.add( drawingArea.x.get(drawingArea.x.size()-1));
            drawingArea.x.remove(drawingArea.x.size()-1);
            repaint();
        }}catch(ArrayIndexOutOfBoundsException ex)
         {}
 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        boolean t = true;
        try{  // to catch out of bounds error
        if (drawingArea.x.size() != 0)
        {
         if(drawingArea.x.get(drawingArea.x.size()-1).isDelete())
         {  // redo the delete task   
             t = false;
             no--;
             undo.add( drawingArea.x.get(drawingArea.x.size()-1));
             drawingArea.x.remove(drawingArea.x.size()-1);
            repaint();
         }
         else if(drawingArea.x.get(drawingArea.x.size()-1).isResized() ||drawingArea.x.get(drawingArea.x.size()-1).isMoved())
         { // redo the resize task  and move task
            t = false;
            undo.add( drawingArea.x.get(drawingArea.x.size()-1));
            drawingArea.x.remove(drawingArea.x.size()-1);
            drawingArea.x.add(undo.get(undo.size()-2));
            undo.remove(undo.size()-2);
            repaint();
         }}
         if (undo.size() != 0 && t)
         { // redo the drawing task  
             drawingArea.x.add(undo.get(undo.size()-1));
             undo.remove(undo.size()-1);
             repaint();
         }}catch(ArrayIndexOutOfBoundsException ex)
         {}
 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void resizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resizeActionPerformed
        // TODO add your handling code here:
         if ( drawingArea.mode==5)
        { // hold on the resize task if there is a selected shape
           undo.add(shapes.Control.selectedShape);        
            drawingArea.mode=6;
        }
        else 
        {
            JOptionPane.showMessageDialog(this,"You have to select a shape first");
        }
    }//GEN-LAST:event_resizeActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
        // hold on selection task
         drawingArea.mode = 5;
         shapes.Control.selectedShape = null;
    
    }//GEN-LAST:event_selectActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         if ( drawingArea.mode==5)
        { // hold on the copy task if there is a selected shape
            drawingArea.mode=7;
        }
        else 
        {
            JOptionPane.showMessageDialog(this,"You have to select a shape first");
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         // hold on the resize task if there is a copied shape
        drawingArea.mode = 8;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (drawingArea.mode == 5)
        { // hold on the move task if there is a selected shape
              undo.add(shapes.Control.selectedShape); 
            drawingArea.mode = 9;
        }
        else
            {
            JOptionPane.showMessageDialog(this,"You have to select a shape first");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         if (drawingArea.mode == 5)
        {           // hold on the delete task if there is a selected shape
           drawingArea.mode = 10;
        }
        else
            {
            JOptionPane.showMessageDialog(this,"You have to select a shape first");
        }
    }//GEN-LAST:event_jButton8ActionPerformed


   boolean check;
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private shapes.Control drawingArea;
    private javax.swing.JCheckBox fill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton resize;
    private javax.swing.JButton select;
    private javax.swing.JComboBox<String> shape;
    // End of variables declaration//GEN-END:variables
}
