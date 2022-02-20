#include <stdio.h>
#include <string.h>
 
typedef struct {
   int  x, y;
   int  largura, altura;
}Circulo;
 
 void print(Circulo* c){
	 printf("Retangulo de posicao (%d,%d), largura %d e altura %d\n", c->x, c->y, c->largura, c->altura);
 }

 
 
int main() {
	
   Circulo Circulo1 = { 40,40, 80,80}; 
   Circulo Circulo2 = { 40,40, 40,40};

   print(&Circulo1);
   print(&Circulo2);
   
}
