import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;
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

	ArrayList<Retangulo> rs = new ArrayList<Retangulo>();
    Random rand = new Random();
	ArrayList<Elipse> es = new ArrayList<Elipse>();
    
	PaintFrame(){
		
		this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
		//this.setTitle("Painting Figures");
		this.setSize(350,350);
		this.setVisible(true);
		
		this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        rs.add(new Retangulo(x,y, w,h));
                        repaint();  // outer.repaint()
                    }
					if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        es.add(new Elipse(x,y, w,h));
                        repaint();  // outer.repaint()
                    }
                }
            }
        );
		
		
		
	
		
	}
	public void paint (Graphics g){
		super.paint(g);
//		for (Retangulo r: this.rs) {
//            r.paint(g,false);
//        }
		for (Elipse e: this.es) {
            e.paint(g,false);
        }
	}
}
