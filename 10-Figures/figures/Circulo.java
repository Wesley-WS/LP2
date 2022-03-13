package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Circulo extends Figure{
    private int raio;
	private int x, y;
	private Color cor;
	
	public Circulo(int x ,int y ,int raio ){
		this.x = x;
		this.y = y;
		this.raio = raio;
	}
	
	public void print(){
		System.out.format("Circulo na posicao (%d, %d) tendo %d de raio.\n", this.x, this.y, this.raio);
	}
	
	public int area(){
		int area = this.raio*this.raio*3;
		return area;
	}
 
	public void drag (int dx, int dy){
		this.x = this.x + dx;
		this.y = this.y + dy;
		
	}
	public void paint(Graphics g, boolean preenchido ){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(cor);
		if(preenchido){
			g2d.fillOval(this.x, this.y, this.raio, this.raio);
		}else{
			g2d.drawOval(this.x, this.y, this.raio, this.raio);
		}
	}
	
	public void setCor(Color cor){
		this.cor = cor;
	}
}