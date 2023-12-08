#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	int data;
	struct Node *next;
} Stack;

int size(Stack *s) {
	if (s == NULL) return 0;
	return 1 + size(s->next);
}

void push(Stack **s, int data) {
	Stack *node = (Stack *)malloc(sizeof(Stack));
	node->next = NULL;
	node->data = data;
	if (*s == NULL) *s = node;
	else {
		node->next = *s;
		*s = node;
	}
}

int pop(Stack **s) {
	if (*s == NULL) return -999;
	int data = (*s)->data;
	Stack *curr = *s;
	*s = (*s)->next;
	free(curr);
	return data;
}

void display(Stack *s) {
	printf("TOP -> ");
	Stack *curr = s;
	while (curr != NULL) {
		printf("%d ", curr->data);
		curr = curr->next;
	}
	printf("-> END\n");
}

int main() {
	Stack *st = NULL;
	display(st);
	push(&st, 1);
	display(st);
	push(&st, 2);
	display(st);
	push(&st, 3);
	display(st);
	push(&st, 4);
	display(st);
	printf("%d\n", pop(&st));
	display(st);
	printf("%d\n", pop(&st));
	display(st);
	printf("%d\n", pop(&st));
	display(st);
	printf("%d\n", pop(&st));
	display(st);
	printf("%d\n", pop(&st));
	display(st);
	printf("%d\n", pop(&st));
	return 0;
}
