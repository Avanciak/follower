package entertainment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class EntertainmentWindow extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    public MyPanel panel; 
    
    //int mouseX = 0;
    //int mouseY = 0;
    
    
    public EntertainmentWindow() throws HeadlessException {
        super();
        // TODO Auto-generated constructor stub
        // int posX, posY;
        int szer, wys;
        panel = new MyPanel();
        //posX = 150;
        //posY = 300;
        szer = 700;
        wys = 600;
        this.setTitle("Follow me");
        this.setSize(szer,wys);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        panel.setVisible(true);
        this.addMouseListener(panel);
        this.addMouseMotionListener(panel);
        
    }
    
   


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EntertainmentWindow window = new EntertainmentWindow();
                    window.panel.repaint();
              Follower follower = new Follower(window.panel, Color.ORANGE);
              Thread thread = new Thread(follower);
              thread.start();
                                  
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
        
    }

    
}
