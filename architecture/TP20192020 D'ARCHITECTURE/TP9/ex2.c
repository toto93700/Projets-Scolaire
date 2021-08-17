#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include "ex2.h"
// karim louail 11806111 ps: seul cette exercice a ete fait avec l'aide d'un amis 



int et_read(int fd, etudiant_t *pr)
{
	if ((read(fd, pr, sizeof(etudiant_t))) != sizeof(etudiant_t)) {
		return 0;
	}

 return 1;
}

int et_write(int fd, etudiant_t *pr)
{
	if (write(fd, pr, sizeof(etudiant_t)) != sizeof(etudiant_t)) {
		return 0;
	}

 return 1; 
}

int et_pos(int fd)
{
	off_t pos = lseek(fd,0, SEEK_CUR);
	off_t size = lseek(fd,0,SEEK_END);
	lseek(fd,pos,SEEK_SET);

 return (size/sizeof(etudiant_t));
}	

int et_seek(int fd, int n)
{
	off_t pos = lseek(fd, n*sizeof(etudiant_t), SEEK_SET);
	if(pos != n*sizeof(etudiant_t))
		return -1;

 return (pos/sizeof(etudiant_t));	
}

int et_end(int fd)
{
	off_t pos = lseek(fd,0, SEEK_CUR);
	lseek(fd,0,SEEK_END);
	if(pos == -1)
	{
		return -1;
	}

 return pos;
}

int et_search(int fd, int num_etud)
{
	etudiant_t etudiant;
	if(et_seek(fd,0) != 0)
	{
		perror("erreur seek");
		return -1;
	}

	for(int i = 0; et_read(fd,&etudiant);i++)
	{
		if((etudiant.num_etud - num_etud) == 0)
			return i;
	}
	
 return -1;
}

