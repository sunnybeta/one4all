#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	int data;
	struct Node *next;
} stack;


void push(stack *s, int data) {
	stack *new = malloc(sizeof(stack));
	new->data = data;
	new->next = NULL;
	stack *t = s;
	while (t->next != NULL) t = t->next;
	t->next = s;
}

int pop(stack *s) {
	stack *t = s;
	while (t->next != NULL) t = t->next;
	return t->data;
}

unsigned int size(stack *s) {
	if (s == NULL) return 0;
	return 1 + size(s->next);
}


int main() {
	return 0;
}
