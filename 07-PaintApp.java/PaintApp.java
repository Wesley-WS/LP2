import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PaintApp{
	
	public static void main (String[] args){
		PaintFrame frame = new PaintFrame();
	}
}

class PaintFrame extends JFrame{
	public Circulo c1;
	public Retangulo r1;
	public Elipse e1;
	
	PaintFrame(){
		
		this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
		
		this.setTitle("Painting Figures");
		this.setSize(350,350);
		this.setVisible(true);
		
		this.c1 = new Circulo(50,50,100);
		this.r1 = new Retangulo(100,100,100,30);
		this.e1 = new Elipse(150,150,100,30);
		
	}
	public void paint (Graphics g){
		super.paint(g);
		this.c1.setCor(new Color(0,255,0));
		this.c1.paint(g, true);
		
		this.r1.setCor(new Color(128,0,0));
		this.r1.paint(g, false);
		
		this.e1.setCor(new Color(75,0,130));
		this.e1.paint(g, true);
		
	}
}
