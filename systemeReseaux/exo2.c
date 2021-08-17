#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <pthread.h>
#include <dirent.h>
#include <sys/types.h>

void *mon_ls(void* dir) {
  char* t = (char*) dir;
  struct dirent *a;
  DIR *ra;
  if ( (ra=opendir(t)) ==NULL)
    printf("Erreur d'ouverture !\n");

  while( (a = readdir(ra)) !=NULL) {
    printf("%s\n",a->d_name);
  }

}

int main(int argc, char argv[]) {
  int nombre_rep =  argc-1;
  pthread_t* threads = malloc(nombre_rep * sizeof(pthread_t));
  for (int i=0; i<nombre_rep; i++) {
    pthread_create(&threads[i], NULL, mon_ls, (void*)argv[i+1]);
  }
sleep(2);//

//  for (int i=0; i<nombre_rep; i++) {
  //  pthread_join();
//  }

  return EXIT_SUCCESS;
}
