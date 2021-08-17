#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "DM15graphe.c"
#include "graph_mat-2.h"
#include "acm.h"
#include "liste.c"


int main()
{
	graph_mat *g = gm_init(5);
	gm_add_edge(g, 0, 1, 1.);
	gm_add_edge(g, 0, 4, 1.);
	gm_add_edge(g, 0, 2, 1.);
	gm_add_edge(g, 1, 2, 1.);
	gm_add_edge(g, 1, 3, 1.);

	mastruct * ma=ini2_struct(5,g);
    ma=parcoursProfondeur(g);
		exo3(ma);



		printf("\n\n ******************************************************************");
		mastruct *mb=ini2_struct(5,g);

	parcoursProfondeurrecursive(mb,0);

  //affichermastruct(mb);


//	{ /* partie Prim */
//		graph_mat *acm = gm_acm_prim(g, 0);
//		if (acm != NULL) {
//			gm_write_dot_with_mst(g, acm,
//					"acm_prim.dot");
//			system("dot -Tx11 acm_prim.dot");
//			gm_free(acm);
//		}
//	}
//	{ /* partie Kruskal */
//		graph_mat *acm = gm_acm_kruskal(g);
//		if (acm != NULL) {
//			gm_write_dot_with_mst(g, acm,
//					"acm_prim.dot");
//			system("dot -Tx11 acm_prim.dot");
//			gm_free(acm);
//		}
//	}
	gm_free(g);
	return EXIT_SUCCESS;
}
