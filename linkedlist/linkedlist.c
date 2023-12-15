#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	unsigned int data;
	struct Node *next;
} list;


void add(list *l, int data) {
	list *new = malloc(sizeof(list));
	new->data = data;
	new->next = NULL;
	list *p = l;
	while(p->next != NULL) p = p->next;
	p->next = l;
}

void update(list *l, int data, int index) {
	list *p = l;
	while(index--) p = p->next;
	if (p == NULL) {
		fprintf(stderr, "Index out of range");
		exit(EXIT_FAILURE);
	}
	p->data = data;
}

void delete(list *l, int index) {
	list *p = l;
	list *q = p->next;
	if (index == 0) {
		l = l->next;
		free(p);
		exit(EXIT_SUCCESS);
	}
	--index;
	while(index--) {
		p = q;
		q = q->next;
	}

	if (p == NULL) {
		fprintf(stderr, "Index out of range");
		exit(EXIT_FAILURE);
	}

	p->next = q->next;
	free(q);
}

list *reverse(list *l) {
	list *p = NULL;
	list *q = l;
	list *r = q->next;

	while(q != NULL) {
		q->next = p;
		p = q;
		q = r;
	}

	return p;

}

int main(int argc, char **argv) {
	return 0;
}
