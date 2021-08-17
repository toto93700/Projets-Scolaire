typedef struct etudiant_t {
    int num_etud;      /* numéro étudiant */
    char nom[33];      /* nom de famille de l'étudiant */
    char prenom[33];   /* prenom de l'étudiant */
} etudiant_t;


int et_read(int fd, etudiant_t *pr);

int et_write(int fd, etudiant_t *pr);

int et_pos(int fd);

int et_seek(int fd, int n);

int et_end(int fd);

int et_search(int fd, int num_etud);
