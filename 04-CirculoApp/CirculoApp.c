#include <stdio.h>
#include <string.h>
 
typedef struct {
   int  x, y;
   int  largura, altura;
}Circulo;
 
 void print(Circulo* c){
	 printf("Circulo de posicao (%d,%d), largura %d e altura %d\n", c->x, c->y, c->largura, c->altura);
 }
 
 float area(Circulo* c){
	 float raio = (c->largura/2);
	 float area = 2.14*raio*raio;
	 return (area);
 }
 
 void drag(int dx, int dy, Circulo* c){
	 c->x = c->x + dx;
	 c->y = c->y + dy;
	 
 }
 
 
int main() {
	
   Circulo Circulo1 = { 40,40, 80,80}; 
   Circulo Circulo2 = { 40,40, 40,40};

   print(&Circulo1);
   print(&Circulo2);
   
   float area1 = area(&Circulo1);
   float area2 = area(&Circulo2);
   
   printf("A area do circulo1 e :%.2f\n",area1);
   printf("A area do circulo2 e :%.2f\n",area2);
   
   drag(10,10,&Circulo1);
   drag(20,20,&Circulo2);
   
   print(&Circulo1);
   print(&Circulo2);
   
}
