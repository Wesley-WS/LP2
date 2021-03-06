#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Retangulo;

void retangulo_print (Retangulo* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Retangulo* retangulo_new (int x, int y, int w, int h) {
    Retangulo*   this  = malloc(sizeof(Retangulo));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) retangulo_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}



///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int r;
} Circulo;

void Circulo_print (Circulo* this) {
    Figure* sup = (Figure*) this;
    printf("Circulo de raio (%d) na posicao (%d,%d).\n",
           this->r, sup->x, sup->y);
}

Circulo* circulo_new (int x, int y, int r) {
    Circulo* this = malloc(sizeof(Circulo));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Circulo_print;
    sup->x = x;
    sup->y = y;
    this->r = r;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) retangulo_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) circulo_new(210,110,130)
    };

    ///

    for (int i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
