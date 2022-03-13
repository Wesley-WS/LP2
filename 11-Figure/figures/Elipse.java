package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Elipse extends Figure {
    private int largura, altura;
	private int x, y;
	private Color cor;
	
	public Elipse( int x, int y, int largura, int altura){
		super(x,y);
		this.largura = largura;
		this.altura = altura;
	}
	
	public void print(){
		System.out.format("Elipse na posicao (%d, %d) tendo %d de largura e %d de altura.\n", this.x, this.y, this.largura, this.altura);
	}
	
	public int area(){
		int area = this.largura*this.altura*3;
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
			g2d.fillOval(this.x, this.y, this.largura, this.altura);
		}else{
			g2d.drawOval(this.x, this.y, this.largura, this.altura);
		}
	}
	
	public void setCor(Color cor){
		this.cor = cor;
	}
	
 
}