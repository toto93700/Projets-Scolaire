#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "DM15graphe.c"
#include "graph_mat-2.h"
#include "liste.c"


int main()
{
	graph_mat *g = gm_init(8);
	gm_add_edge(g, 0, 1, 1.);
	gm_add_edge(g, 0, 2, 1.);
	gm_add_edge(g, 2, 3, 1.);
	gm_add_edge(g, 1, 3, 1.);
	gm_add_edge(g, 1, 4, 1.);
	gm_add_edge(g, 3, 4, 1.);
	gm_add_edge(g, 4, 5, 1.);
	gm_add_edge(g, 4, 6, 1.);
	gm_add_edge(g, 6, 7, 1.);


	mastruct * ma=ini2_struct(5,g);
    ma=parcoursProfondeur(g);
		exo3(ma);



		printf("\n\n ******************************************************************");
		mastruct *mb=ini2_struct(5,g);

	parcoursProfondeurrecursive(mb,0);


	gm_free(g);
	return EXIT_SUCCESS;
}
