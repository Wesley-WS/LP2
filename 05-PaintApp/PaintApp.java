import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class PaintApp{
	
	public static void main (String[] args){
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}
}

class PaintFrame extends JFrame{
	Retangulo r1;
	PaintFrame(){
		this.setTitle("Painting Figures");
		this.setSize(350,350);
		this.r1 = new Retangulo(50,50, 100,30);
	}
	public void paint (Graphics g){
		super.paint(g);
		g.setColor(new Color(0,255,0));
		this.r1.paintDraw(g);
		this.r1.drag(50,50);
		g.setColor(new Color(0,0,0));
		this.r1.paintFill(g);
		this.r1.drag(50,50);
		g.setColor(new Color(255,0,0));
		this.r1.paintFill(g);
	}
}

class Retangulo {
    private int ladoA, ladoB;
	private int x, y;
	
	public Retangulo( int x, int y, int ladoA, int ladoB){
		this.x = x;
		this.y = y;
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}
	
	public void print(){
		System.out.format("Retangulo na posicao (%d, %d) com o ladoA tendo %d de largura e o ladoB tendo %d de altura.\n", this.x, this.y, this.ladoA, this.ladoB);
	}
	
	public int area(){
		int area = ladoA*ladoB;
		return area;
 }
 
	public void drag (int dx, int dy){
		this.x = this.x + dx;
		this.y = this.y + dy;
		
 }
	void paintDraw(Graphics g ){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(this.x, this.y, this.ladoA, this.ladoB);
	}
	
	void paintFill(Graphics g ){
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(this.x, this.y, this.ladoA, this.ladoB);
	}
	
 
}
