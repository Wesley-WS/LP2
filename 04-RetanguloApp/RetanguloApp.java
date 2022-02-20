import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RetanguloApp {
    public static void main (String[] args) {
		Retangulo retangulo1 = new Retangulo(50,50,100,100);
		Retangulo retangulo2 = new Retangulo(60,60,50,50);
		
		retangulo1.print();
		retangulo2.print();
		
		retangulo1.area();
		retangulo2.area();
		
		retangulo1.drag(10,10);
		retangulo2.drag(20,20);
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
	
	public void area(){
		int area = ladoA*ladoB;
		System.out.format("A area do retangulo e %d\n", area);
 }
 
	public void drag (int dx, int dy){
		int novoX = x + dx;
		int novoY = y + dy;
		System.out.format("A nova pocisao do retangulo e (%d,%d)\n", novoX, novoY);
 }
}




