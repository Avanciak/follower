package entertainment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class Follower extends JComponent implements Runnable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Point position;
    private int radius;
    private Component component;
    private Color color;
    
    
    public Follower() {
        this.position = new Point(50,50);
        this.radius = 5;
        this.setSize(2*radius, 2*radius);
        this.setBackground(new Color(100));
    }
    
    public Follower(Component component, Color color) {
        this.position = new Point(component.getLocation());
        this.radius = 5;
        this.setSize(2*radius, 2*radius);
        this.setBackground(new Color(100));
        this.component = component;
        this.color = color;
    }
    
   /* public void follow(MyPanel component) {
        if(this.position.x > component.getMousePoint().x) this.position.x--;
        if(this.position.x < component.getMousePoint().x) this.position.x++;
        if(this.position.y > component.getMousePoint().y) this.position.y--;
        if(this.position.y < component.getMousePoint().y) this.position.y++;
    }*/
    
   /* public void slowFollow() {
        double followSpeed = 1;
        if(this.position.x > this.getMousePosition().x) this.position.x--; 
        if(this.position.x < this.getMousePosition().x) this.position.x++;
        if(this.position.y > this.getMousePosition().y) this.position.y--;
        if(this.position.y < this.getMousePosition().y) this.position.y++;
    }*/
    
    
    public void follow() {
              
        int minX = component.getX();
        int maxX = component.getX() + component.getWidth();
        int minY = component.getY();
        int maxY = component.getY() + component.getHeight();
        Point mousePos = component.getMousePosition();
        //if(mousePos != null) System.out.println("Mouse in window");
       
        if(mousePos != null) {
            int X = mousePos.x;
            int Y = mousePos.y;
           // System.out.println("Mouse position: " + X + ", " + Y);
            if(this.position.x > Math.max(X,minX)) this.position.x--;
            if(this.position.x < Math.min(X,maxX)) this.position.x++;
            if(this.position.y > Math.max(Y,minY)) this.position.y--;
            if(this.position.y < Math.min(Y,maxY)) this.position.y++;
            //System.out.println(this.position.x + ", " + this.position.y);
            //System.out.println("Borders:");
            //System.out.println(minX + ", " + maxX);
            //System.out.println(minY + ", " + maxY);
            
        }
        
        
    }
    
    public void draw(Graphics g) {
        g.setColor(this.color);
        //g.setColor(Color.ORANGE);
        g.fillOval(this.position.x - this.radius, 
                   this.position.y-this.radius, 
                   2 * this.radius, 2 * this.radius);
        
    }
    
    public void draw() {
        Graphics g = this.component.getGraphics();
        g.setColor(this.color);
        g.fillOval(this.position.x - this.radius, 
                   this.position.y-this.radius, 
                   2 * this.radius, 2 * this.radius);
    }
    
    public void refresh() {
        this.component.repaint(this.position.x - this.radius, 
                this.position.y-this.radius, 
                2 * this.radius, 2 * this.radius);
    }
    
    @Override
    public void run() {
        while(true) {
            
            this.follow();
            this.draw();
            
            try {
                Thread.sleep(20);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
            //System.out.println("watek dziala");
               
        }
        
    }

}
