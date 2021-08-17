#ifndef LISTE
#define LISTE

typedef struct maillon_s {
  int val;
  struct maillon_s* suiv;
} maillon;

typedef struct liste_s {
  maillon* premier;
  int n; // taille
} liste;

maillon* creer_maillon(int c);
void detruire_maillon(maillon* m);
liste* creer_liste();
void inserer_dans_liste(liste* l, int c);
void detruire_liste(liste* l);
void afficher_liste(liste l);

#endif
