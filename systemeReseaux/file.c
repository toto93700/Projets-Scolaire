#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <pthread.h>

#define N 3

void generation_aleatoire(int matrice[N][N]) {

  int i, j;
  for (i=0; i<N; i++) {
    for (j=0; j<N; j++) {
      matrice[i][j] = rand()%100;
    }
  }
}
void imprimer_matrice(int matrice[N][N]) {
  srand(time(NULL));
  int i, j;
  for (i=0; i<N; i++) {
    for (j=0; j<N; j++) {
      printf("%d\t",matrice[i][j]);
    }
    printf("\n");
  }
}

void *somme(void* arg) {
  int** t = (int**) arg;
  for(int i=0;i<N;i++){
    t[0][i] = t[1][i] + t[2][i];
  }

  pthread_exit(NULL);
}



int main(int argc, char argv[]) {
  int A[N][N], B[N][N], C[N][N], i, j;
  srand(time(NULL));
  generation_aleatoire(A);
  //srand(time(NULL));
  generation_aleatoire(B);
  pthread_t*threads = malloc(N*sizeof(pthread_t));

  for(i=0; i<N; i++) {
    int** arg = malloc(sizeof(int*));
    arg[0] = C[i];
    arg[1] = A[i];
    arg[2] = B[i];
    pthread_create(&threads[i], NULL, somme, (void*)arg);
  }

  for (i=0; i<N; i++) {
    for (j=0; j<N; j++)
      pthread_join(threads[i], NULL);
  }

  imprimer_matrice(A);
  printf("///////////////////////////////////////////\n");
  imprimer_matrice(B);
    printf("///////////////////////////////////////////\n");
  imprimer_matrice(C);

  //free(arg);
  return EXIT_SUCCESS;
}
