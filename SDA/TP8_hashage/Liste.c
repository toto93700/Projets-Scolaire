#include<stdio.h>
#include<stdlib.h>
#include <Liste.h>

maillon* creer_maillon(int c) {
  maillon* m = malloc(sizeof(maillon));
  m->val = c;
  m->suiv = NULL;
  return m;
}

void detruire_maillon(maillon* m) {
  free(m);
}

liste* creer_liste() {
  liste* l = malloc(sizeof(liste));
  l->premier = NULL;
  l->n = 0;
  return l;
}

void inserer_dans_liste(liste* l, int c) {
  maillon* m = creer_maillon(c);
  m->suiv = l->premier;
  l->premier = m;
  l->n++;
}

void detruire_liste(liste* l) {
  while(l->premier != NULL) {
    maillon* tmp = l->premier;
    l->premier = l->premier->suiv;
    free(tmp);
  }
  free(l);
}

void afficher_liste(liste l) {
  maillon* tmp = l.premier;
  while(tmp != NULL) {
    printf("%d ",tmp->val);
    tmp = tmp->suiv;
  }
  printf("\n");
}
