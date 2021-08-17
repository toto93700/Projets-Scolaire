#include <stdio.h>
#include <stdlib.h>



typedef struct maillon_s {
  int val;
  struct maillon_s* suiv;
} maillon;

typedef struct liste_s {
  maillon* premier;
  int n; // taille
} liste;


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



///////

typedef struct table_de_hachage__t{
 int taille;
 liste *Tab;
}table_de_hachage_t;


table_de_hachage_t cree_table_de_hachage(int taille){

  table_de_hachage_t *T=malloc(sizeof(table_de_hachage_t));

  T->Tab=malloc(sizeof(liste)*taille);
  T->taille=taille;
  for(int i=0;i<taille;i++){
  T->Tab[i]=creer_liste();
  }
  return T;
}

/*table_de_hachage_t t;
t.taille=5;
t.Tab=malloc(sizeof(Liste))
*/




void detruit_table_de_hachage(table_de_hachage_t *table){
  free(table->Tab);
  free(table);
  return;
}


int h(table_de_hachage_t *table, char * cle){
  int somme;
  while(*cle!='\0'){
    somme+=(int)*cle;
  }
  return(somme%table->taille);


}
void insere(table_de_hachage_t* table, char * cle, int valeur){


    inserer_dans_liste(&table->Tab[h(table,cle)], valeur);

}


void main(){

table_de_hachage_t *t= cree_table_de_hachage(5);
char *c;
*c='k';
c++;
*c='a';
c--;


insere(t, c, 10);
printf("%d",&t->Tab[4]->premier->val);






}
