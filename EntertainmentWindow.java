package entertainment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class EntertainmentWindow extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    public MyPanel panel; 
        
    public EntertainmentWindow() throws HeadlessException {
        super();
        int szer, wys;
        panel = new MyPanel();
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
       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EntertainmentWindow window = new EntertainmentWindow();
                    window.panel.repaint();
                `   Follower follower = new Follower(window.panel, Color.ORANGE);
                    Thread thread = new Thread(follower);
                    thread.start();
                                  
                }   
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
