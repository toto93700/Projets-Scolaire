#include <stdio.h>
#include <stdlib.h>



void main(){

int n;

FILE *f;
int i;
char nom_fichier[] = "complet10.dot";
f = fopen(nom_fichier, "w");
if (f == NULL) {
perror("fopen"); /* écrit la dernière erreur rencontrée */
return 1;
}


fprintf(f,"graph {\n");
for(n=0; n<10;n++){
fprintf(f," %d\n",n);
}


for(n=0;n<10;n++){

  for(int i=n+1;i<10;i++){
  fprintf(f,"%d -- %d \n",n,i);
  }
}

fprintf(f," } \n");
}
