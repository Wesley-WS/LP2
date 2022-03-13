package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures.*;

public class Retangulo extends Figure {
    private int largura, altura;
	private int x, y;
	private Color cor;
	
	public Retangulo( int x, int y, int largura, int altura){
		this.x = x;
		this.y = y;
		this.largura = largura;
		this.altura = altura;
	}
	
	public void print(){
		System.out.format("Retangulo na posicao (%d, %d) com o ladoA tendo %d de largura e o ladoB tendo %d de altura.\n", this.x, this.y, this.largura, this.altura);
	}
	
	public int area(){
		int area = largura*altura;
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
			g2d.fillRect(this.x, this.y, this.largura, this.altura);
		}else{
			g2d.drawRect(this.x, this.y, this.largura, this.altura);
		}
	}
	
	public void setCor(Color cor){
		this.cor = cor;
	}
}
