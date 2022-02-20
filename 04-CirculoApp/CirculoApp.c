#include <stdio.h>
#include <string.h>
 
typedef struct {
   int  x, y;
   int  largura, altura;
}Circulo;
 
 void print(Circulo* c){
	 printf("Retangulo de posicao (%d,%d), largura %d e altura %d\n", c->x, c->y, c->largura, c->altura);
 }
 
 void area(Circulo* c){
	 int raio = (c->largura/2);
	 int area = 2.14*raio*raio;
	 printf("A area do circulo e %d\n", area);
 }
 
 void drag (int dx, int dy, Circulo* c){
	 int novoX = c->x + dx;
	 int novoY = c->y + dy;
	 printf("A nova pocisao do circulo e (%d,%d)\n", novoX, novoY);
 }
 
 
int main() {
	
   Circulo Circulo1 = { 40,40, 80,80}; 
   Circulo Circulo2 = { 40,40, 40,40};

   print(&Circulo1);
   print(&Circulo2);
   
   area(&Circulo1);
   area(&Circulo2);
   
   drag(10,10,&Circulo1);
   drag(20,20,&Circulo2);
}
