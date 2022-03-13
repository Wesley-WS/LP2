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

	ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
		this.setSize(350,350);
		this.setVisible(true);
		
		this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Retangulo(x,y, w,h));
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Elipse(x,y, w,h));
                    } else if (evt.getKeyChar() == 'c') {
						figs.add(new Circulo(x,y, w));
					}
                    repaint();
                }
            }
        );
		
		
	}
	public void paint (Graphics g){
		super.paint(g);
//		for (Retangulo r: this.rs) {
//            r.paint(g,false);
//        }
//		for (Elipse e: this.es) {
//            e.paint(g,false);
//        }
		for (Figure fig: this.figs) {
				fig.paint(g,false);
		}
	}
}
