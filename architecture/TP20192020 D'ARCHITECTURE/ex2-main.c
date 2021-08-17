#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include "ex2.h"

int affiche_db(int fd);
int affiche_et(int fd, int pos);
int append_et(int fd, etudiant_t *et);
int swap_et(int fd, int pos1, int pos2);

char *fname = "ex2-etudiants.db";
char *commline = "************************************************************";


/************************************************************
 ****
 ****    Fonctions pratique
 ****
 ************************************************************/

/****************************************
 * Affiche le contenu du database fd ouvert en lecture
 */

int affiche_db(int fd) {
  int i; //n_rec;
  etudiant_t et;
  
  if (et_seek(fd, 0) != 0) {
    perror("Erreur seek");
    return -1;
  }
  for (i = 0; et_read(fd, &et); i++) {
    printf("%2d : %d : %s : %s :\n", i, et.num_etud, et.prenom, et.nom);
  }

  return i;
}


/****************************************
 * Affiche l'enregistrement à la position pos du database fd ouvert en lecture
 */

int affiche_et(int fd, int pos) {
  etudiant_t et;
  
  if (et_seek(fd, pos) == -1) {
    perror("Erreur seek");
    return -1;
  }  
  if (et_read(fd, &et) == 0) {
    perror("Erreur lecture enregistrement");
    return -1;
  }
  printf("%2d: %d : %s : %s :\n", pos, et.num_etud, et.prenom, et.nom);

  return pos;
}

/****************************************
 * Append un enregistrement au database fd ouvert en lecture
 */
int append_et(int fd, etudiant_t *et) {
  if (et_end(fd) == -1) {
    perror("Erreur end");
    return -1;
  }
  if (et_write(fd, et) == 0) {
    perror("Erreur ecriture enregistrement");
    return -1;
  } 

  return et_pos(fd);
}

/****************************************
 * Echange l'enregistrement en position pos1 avec l'enregistrement en
 * position pos2 dans le database fd ouvert en lecture
 */
int swap_et(int fd, int pos1, int pos2) {
  etudiant_t et1, et2;
  
  if (et_seek(fd, pos1) != pos1) {
    perror("Erreur seek");
    return 0;
  }
  if (et_read(fd, &et1) == 0) {
    perror("Erreur lecture enregistrement");
    return 0;
  }
  if (et_seek(fd, pos2) != pos2) {
    perror("Erreur seek");
    return 0;
  }
  if (et_read(fd, &et2) == 0) {
    perror("Erreur lecture enregistrement");
    return 0;
  }

  if (et_seek(fd, pos1) != pos1) {
    perror("Erreur seek");
    return 0;
  }
  if (et_write(fd, &et2) == 0) {
    perror("Erreur ecriture enregistrement");
    return 0;
  }
  if (et_seek(fd, pos2) != pos2) {
    perror("Erreur seek");
    return 0;
  }
  if (et_write(fd, &et1) == 0) {
    perror("Erreur ecriture enregistrement");
    return 0;
  }

  return 1;
}


/************************************************************
 ****
 ****    Tests
 ****
 ************************************************************/

int test_affichage(int fd) {
  int n_rec;
  
  printf("%s\n", commline);
  printf("****  Affichage du fichier %s\n", fname);
  printf("****  Test : seek, read, pos\n****\n");
  
  if ((n_rec = affiche_db(fd)) == -1) {
    perror("Erreur affichage fichier db");
    exit(EXIT_FAILURE);
  };
  
  return n_rec;
}

void test_compte_et(int fd, int n_rec) {
  
  printf("****\n%s\n", commline);
  printf("****  Nombre d'enregistrements dans le fichier\n");
  printf("****  Test : pos\n****\n");

  if (et_pos(fd) == n_rec) {
    printf("%d etudiants\n", n_rec);
  } else {
    perror("Erreur pos (eof)");
    exit(EXIT_FAILURE);
  }
}

void test_lecture(int fd, int n_rec) {
  int i;
  
  printf("%s\n", commline);
  printf("****  Lecture d'enregistrements avec pos\n");
  printf("****  Test : seek, read \n****\n");
  
  for (i = 0; i < n_rec; i += 3) {
    printf("Enregistrement %d\n", i);
    affiche_et(fd, i);
  }
}

void test_append(int fd, int n_rec, etudiant_t *pet) {
  
  printf("****\n%s\n", commline);
  printf("****  Append enregistrement\n");
  printf("****  Test : end, write, pos\n****\n");
    
  if (append_et(fd, pet) != ++n_rec) {
    perror("Erreur append");
    exit(EXIT_FAILURE);
  };
  
  affiche_et(fd, n_rec-1);
}

void test_swap(int fd, int pos1, int pos2) {

  printf("****\n%s\n", commline);
  printf("****  Swap enregistremente : %d <-> %d\n", pos1, pos2);
  printf("****  Test : seek, read, write\n****\n");

  printf("****  Avant\n");
  affiche_et(fd, pos1);
  affiche_et(fd, pos2);
  
  if (!swap_et(fd, pos1, pos2)) {
    perror("Erreur swap");
    exit(EXIT_FAILURE);
  }

  printf("****  Apres\n");
  affiche_et(fd, pos1);
  affiche_et(fd, pos2);
}

void test_search(int fd, int pos, int invalid_num_etud) {
  etudiant_t et;
  
  printf("****\n%s\n", commline);
  printf("****  Search : pos %d, invalid %d \n", pos, invalid_num_etud);
  printf("****  Test : search\n****\n");

  if (et_seek(fd, pos) != pos) {
    perror("Erreur seek");
    exit(EXIT_FAILURE);
  }
  if (et_read(fd, &et) == 0) {
    perror("Erreur lecture enregistrement");
    exit(EXIT_FAILURE);
  }

  if (et_search(fd, et.num_etud) == pos) {
    affiche_et(fd, pos);
  } else {
    perror("Erreur search element present");
    exit(EXIT_FAILURE);
  }

  if (et_search(fd, invalid_num_etud) == -1) {
    printf("OK Search element non present %d\n", invalid_num_etud);
  } else {
    perror("Erreur search element non present");
    exit(EXIT_FAILURE);
  }
}


/************************************************************
 ****
 ****    main
 ****
 ************************************************************/

int main() {
  etudiant_t new_et = { 12245329, "Bernard", "Thomas" };
  int n_rec;

  /****************************************
   * Ouverture fichier
   ****************************************/
  int fd = open(fname, O_RDWR | O_CREAT, 0660);
    
  if (fd == -1) {
    perror("Erreur d'ouverure du fichier");
    exit(EXIT_FAILURE);
  }
  
  /****************************************
   * Affichahe db
   ****************************************/
  n_rec = test_affichage(fd);
  
  /****************************************
   * Nombre d'enregistrements dans le fichier
   ****************************************/
  test_compte_et(fd, n_rec);
  
  /****************************************
   * Lectures d'enregistrements avec pos
   ****************************************/
  test_lecture(fd, n_rec);
  
  /****************************************
   * Append
   ****************************************/
  test_append(fd, n_rec, &new_et);

  /****************************************
   * Swap
   ****************************************/
  test_swap(fd, 3, 7);
  
  /****************************************
   * Search
   ****************************************/
  test_search(fd, 11, 11111111);

  /****************************************
   * Affichahe db
   ****************************************/
  n_rec = test_affichage(fd);
}
