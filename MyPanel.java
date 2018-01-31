package entertainment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel
        implements MouseListener, MouseMotionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Point mousePoint;
     
    

   public MyPanel(){
       
   }
           
    
    @Override
    public void mouseDragged(MouseEvent arg0) {
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        
        this.setMousePoint(getMousePosition());
        Graphics g = this.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(this.mousePoint.x - 5, this.mousePoint.y - 5, 10, 10);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getModifiers() == MouseEvent.BUTTON3_MASK) {
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    public Point getMousePoint() {
        return mousePoint;
    }

    public void setMousePoint(Point mousePoint) {
        this.mousePoint = mousePoint;
    }

}
