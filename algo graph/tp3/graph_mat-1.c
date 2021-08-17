#include "graph_mat-1.h"
#include <stdlib.h>
#include <stdio.h>

struct graph_mat {
	unsigned n;
	unsigned m;
	unsigned *adj;
	/* int is_or; in future version*/
	/* double *values; in future version*/
};

graph_mat *gm_init(unsigned n)
{
  return NULL;
}

void gm_free(graph_mat *g)
{
}

unsigned gm_n(const graph_mat *g)
{
  return 0;
}

unsigned gm_m(const graph_mat *g)
{
  return 0;
}

unsigned gm_mult_edge(const graph_mat *g, unsigned v, unsigned w)
{
  return 0;
}

void gm_add_edge(graph_mat *g, unsigned v, unsigned w)
{
}

void gm_rm_edge(graph_mat *g, unsigned v, unsigned w)
{
}

unsigned gm_degree(const graph_mat *g, unsigned v)
{
  return 0;
}

graph_mat *gm_sum(graph_mat * g1, graph_mat * g2)
{
  graph_mat * g = gm_init(gm_n(g1));
  if (gm_n(g1) != gm_n(g2)) abort();

  /* à compléter */

  return g;
}

graph_mat *gm_prod(graph_mat * g1, graph_mat * g2)
{
  graph_mat * g = gm_init(gm_n(g1));
  if (gm_n(g1) != gm_n(g2)) abort();

  /* à compléter */

  return g;
}

void gm_disp(const graph_mat *g)
{
	unsigned v, w;
	printf("n = %d, m = %d\n", gm_n(g), gm_m(g));
	for (v = 0; v < gm_n(g); ++v)
		for (w = 0; w < gm_n(g); ++w) {
			printf("%3d", gm_mult_edge(g, v, w));
			if (w != gm_n(g) - 1)
				printf(" ");
			else
				printf("\n");
		}
}

int gm_write_dot(const graph_mat *g, const char *filename)
{
	/* début solution */
	FILE *f;
	unsigned v, w, k;

	f = fopen(filename, "w");
	if (f == NULL) {
		perror("fopen in gm_write_dot");
		return -1;
	}

	fprintf(f, "graph {\n");
	for (v = 0; v < gm_n(g); ++v)
		fprintf(f, "\t%d;\n", v);

	fprintf(f, "\n");

	for (v = 0; v < gm_n(g); ++v)
		for (w = v; w < gm_n(g); ++w)
			for (k = 0; k < gm_mult_edge(g, v, w); ++k)
				fprintf(f, "\t%d -- %d;\n", v, w);
	fprintf(f, "}\n");
	fclose(f);
	/* fin solution */
	return 0;
}

graph_mat *gm_random(unsigned n, double p)
{
	unsigned v, w;
	graph_mat *g = gm_init(n);

	if (g == NULL) {
		perror("gm_init in gm_random");
		return NULL;
	}
	for (v = 0; v < gm_n(g); ++v)
		for (w = v + 1; w < gm_n(g); ++w) {
			double u = (double) rand() / RAND_MAX;
			if (u < p)
				gm_add_edge(g, v, w);
		}
	return g;
}
