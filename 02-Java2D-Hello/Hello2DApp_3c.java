import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp_3c {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
	
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
	g2d.setPaint(Color.green);
	int w = getWidth();
        int h = getHeight();
	g2d.fillRect(50,50,100,100);
	g2d.setPaint(Color.red);
	g2d.fillOval(60,60,80,80);
    }
}