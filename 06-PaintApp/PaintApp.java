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
	Circulo r1;
	PaintFrame(){
		this.setTitle("Painting Figures");
		this.setSize(350,350);
		this.r1 = new Circulo(50,50, 100,30);
	}
	public void paint (Graphics g){
		super.paint(g);
		this.r1.setCor(new Color(0,255,0));
		this.r1.paint(g, true);
		this.r1.drag(50,50);
		this.r1.setCor(new Color(128,0,0));
		this.r1.paint(g, false);
		this.r1.drag(50,50);
		this.r1.setCor(new Color(75,0,130));
		this.r1.paint(g, true);

	}
}

class Circulo {
    private int largura, altura;
	private int x, y;
	private Color cor;
	
	public Circulo( int x, int y, int largura, int altura){
		this.x = x;
		this.y = y;
		this.largura = largura;
		this.altura = altura;
	}
	
	public void print(){
		System.out.format("Circulo na posicao (%d, %d) com o largura tendo %d de largura e o altura tendo %d de altura.\n", this.x, this.y, this.largura, this.altura);
	}
	
	public int area(){
		int area = largura*altura;
		return area;
 }
 
	public void drag (int dx, int dy){
		this.x = this.x + dx;
		this.y = this.y + dy;
		
 }
	void paint(Graphics g, boolean preenchido ){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(cor);
		if(preenchido){
			g2d.fillOval(this.x, this.y, this.largura, this.altura);
		}else{
			g2d.drawOval(this.x, this.y, this.largura, this.altura);
		}
	}
	
	void setCor(Color cor){
		this.cor = cor;
	}
	
 
}
