package entertainment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class Follower extends JComponent implements Runnable{

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
       
    public void follow() {
              
        int minX = component.getX();
        int maxX = component.getX() + component.getWidth();
        int minY = component.getY();
        int maxY = component.getY() + component.getHeight();
        Point mousePos = component.getMousePosition();
       
        if(mousePos != null) {
            int X = mousePos.x;
            int Y = mousePos.y;
            if(this.position.x > Math.max(X,minX)) this.position.x--;
            if(this.position.x < Math.min(X,maxX)) this.position.x++;
            if(this.position.y > Math.max(Y,minY)) this.position.y--;
            if(this.position.y < Math.min(Y,maxY)) this.position.y++;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(this.color);
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
        Graphics g = this.component.getGraphics();
        g.setColor(this.color);
        if(previousPosition != null) {
            g.clearRect(this.previousPosition.x - 2 * this.radius,
                        this.previousPosition.y - 2 * this.radius,
                        4 * this.radius,
                        4 * this.radius);
        }
        g.fillOval(this.position.x - this.radius, 
                   this.position.y - this.radius, 
                   2 * this.radius, 
                   2 * this.radius);
    }
    
    @Override
    public void run() {
        while(true) {
            
            this.follow();
            // draw() leaves a trace
            this.draw();
            // comment draw() and uncomment refresh() to stpa drawing a trace of the follower
            //this.refresh();
            
            try {
                Thread.sleep(20);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
  
        }
        
    }

}
