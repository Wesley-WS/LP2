import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RetanguloApp {
    public static void main (String[] args) {
		Retangulo retangulo1 = new Retangulo(50,50,100,100);
		Retangulo retangulo2 = new Retangulo(60,60,50,50);
		
		retangulo1.print();
		retangulo2.print();
		
		int area1 = retangulo1.area();
		int area2 = retangulo2.area();
		
		System.out.format("A area do retangulo1 e %d\n", area1);
		System.out.format("A area do retangulo2 e %d\n", area2);
		
		
		retangulo1.drag(10,10);
		retangulo2.drag(20,20);
		
		retangulo1.print();
		retangulo2.print();
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
}





