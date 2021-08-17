#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define ORDRE_MAX 50

int mat[ORDRE_MAX][ORDRE_MAX];

void afficher_mat(int n);
void graphe_complet(int n);
int ecrire_dot(int n, const char *nom_fichier);
void graphe_stable(int n);
void graphe_cycle(int n);
void graphe_biparti_complet(int m, int p);
void graphe_alea(int n, double p);
int lire_dot(const char *nom_fichier);

int main(){


graphe_biparti_complet(5,3);

afficher_mat(8);
ecrire_dot(8,"ontest.dot");

return 0;

}




void graphe_biparti_complet(int m,int p) {
	int i,j;
  int n=m+p;
	for(i=0;i<n,i++){
    for(j=0;j<n;j++){
			if(i<=m-1 && j<=m-1 || i>=m && j>=m){
			 mat[i][j]=1;
		}
		else {
			mat[i][j]=0;
		}
	}
 }
}

void graphe_cycle(int n) {

	int i ,j;
j=1;
mat[n-1][0]=1;
	for(i=0;i<=n-2;i++){

			mat[i][j]=1;
			mat[j][i]=1;
			if(j<=n){
				j++;
			}

	}
}
void afficher_mat(int n)
{
	int i, j;
	for (i = 0; i < n; ++i)
		for (j = 0; j < n; ++j) {
			printf("%d", mat[i][j]);
			if (j == n - 1)
				printf("\n");
			else
				printf("\t");
		}
	printf("\n");
}

void graphe_complet(int n)
{
int i,j;
for(i=0; i<n;i++){
  for(j=0;j<n;j++){
		if(j==i) mat[i][j]=0;
		else mat[i][j]=1;
  }
}


}

void graphe_stable(int n)
{
	for(int i=0; i<n;i++){
	  for(int j=0;j<n;j++){
			mat[i][j]=0;
	  }
 }
}


int ecrire_dot(int n, const char *nom_fichier)
{
	FILE *f;
   f=fopen(nom_fichier,"w");
	 if (f == NULL) {
		 perror("fopen"); /* écrit la dernière erreur rencontrée */
		 return 1;
   }
	 fprintf(f, "graph { \n");



	 for(int h=0;h<n;h++){
		 fprintf(f,"%d \n",h);
	 }

	 for (int i =0 ;i<n ; i++){

    for(int j =i ;j<n ; j++){


			if(mat[i][j]>=1) {
				for(int k=0;k<mat[i][j];k++){
				fprintf(f,"%d -- %d \n",i,j);

        }
      }
		}

}
fprintf(f, "}\n");
return 0;
}
