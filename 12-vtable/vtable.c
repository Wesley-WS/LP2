#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef void (* Figure_drag)  (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
	void (* drag)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Retangulo;

void retangulo_print (Retangulo* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
	sup->vtable->drag(sup);
}

int retangulo_area (Retangulo* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

void retangulo_drag (Retangulo* this){
	Figure* sup = (Figure*) this;
	sup->x = sup->x + 100;
	sup->y = sup->y + 50;
	printf("Nova posicao do Retangulo (%d,%d).\n",
           sup->x, sup->y);
}

Figure_vtable retangulo_vtable = {
    (Figure_Print) retangulo_print,
    (Figure_Area)  retangulo_area,
	(Figure_drag)  retangulo_drag
};

Retangulo* retangulo_new (int x, int y, int w, int h) {
    Retangulo*   this  = malloc(sizeof(Retangulo));
    Figure* sup = (Figure*) this;
    sup->vtable = &retangulo_vtable;
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

void ellipse_print (Retangulo* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
	sup->vtable->drag(sup);
}

int ellipse_area (Retangulo* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}


void ellipse_drag (Retangulo* this){
	Figure* sup = (Figure*) this;
	sup->x = sup->x + 100;
	sup->y = sup->y + 50;
	printf("Nova posicao da Ellipse (%d,%d).\n",
           sup->x, sup->y);
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
	(Figure_drag)  ellipse_drag
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) retangulo_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) retangulo_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130)
    };

    ///

    for (int i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
