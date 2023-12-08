# Queue

Like the [Stack](/stack), **queue** is also a linear data structure which performs operations in the FIFO order (First In First Out - The first element inserted must be removed first).

## Code

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct Queue {
	int data;
	struct Queue *next;
} Queue;

int     pop(Queue *);
Queue * add(Queue *, int);
void    display(Queue *);

int main() {
	Queue *q = NULL;
	q = add(q, 1);
	add(q, 2);
	add(q, 3);
	add(q, 4);
	display(q);
	pop(q);
	display(q);
	add(q, -1);
	add(q, -2);
	display(q);
}

int pop(Queue *q) {
	Queue *p = q;
	q = q->next;
}

Queue *add(Queue *q, int data) {
	Queue *item = malloc(sizeof(Queue));
	item->data = data;
	item->next = NULL;
	if (q == NULL) return item;
	Queue *p = q;
	while (p->next != NULL) p = p->next;
	p->next = item;
	return q;
}

void display(Queue *q) {
	Queue *p = q;
	while (p != NULL) {
		printf("%d * ", p->data);
		p = p->next;
	}
	printf("END\n\n");
}
```
