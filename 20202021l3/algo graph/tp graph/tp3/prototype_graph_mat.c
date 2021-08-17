#include <stdio.h>
#include <stdlib.h>

struct graphe {
	unsigned n; /* ordre du graphe */
	unsigned *adj; /* matrice d'adjacence */
};

void afficher(struct graphe *g);

///////////////////////////////////////////////////////////////////////////////////////////////////////

void afficher(struct graphe *g)
{
	unsigned v, w;
	for (v = 0; v < g->n; ++v)
		for (w = 0; w < g->n; ++w) {
			printf("%3u", g->adj[v * g->n + w]);
			if (w != g->n - 1)
				printf(" ");
			else
				printf("\n");
		}

}

int main()
{
	unsigned n = 4;
	struct graphe *g = malloc(sizeof(struct graphe));
  if(g==NULL) {
    perror("malloc");
    exit(-1);
  }

	g->n = n;
	g->adj = calloc(n * n, sizeof(unsigned));

	g->adj[2 * n + 1] = g->adj[1 * n + 2] = 1;
  g->adj[n-1]=g->adj[3*n-3]=1;

	afficher(g);

	free(g->adj);
	free(g);
	return 0;
}
