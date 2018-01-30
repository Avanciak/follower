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
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
        this.setMousePoint(getMousePosition());
        //System.out.println(this.getMousePoint());
        //this.paintComponents(getGraphics());
        Graphics g = this.getGraphics();
        //this.follower.draw(g);
        
        //this.follower.follow(this);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(this.mousePoint.x - 5, this.mousePoint.y - 5, 10, 10);
        //this.repaint();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public Point getMousePoint() {
        return mousePoint;
    }

    public void setMousePoint(Point mousePoint) {
        this.mousePoint = mousePoint;
    }

}
