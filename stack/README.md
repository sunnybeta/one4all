# Stack

The **stack** is a linear data structure which peforms operations in a specfic order known as LIFO (Last In First Out - The element which is inserted last must come out first).

## C

```c
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
```


## Python

```python
from typing import Any, List, Optional

class Stack:
    def __init__(self, data: Optional[Any] = None) -> None:
        self.__stack: List = [data] if data != None else []

    def top(self) -> Any:
        if not self.__stack:
            raise LookupError('Stack is Empty')
        return self.__stack[-1]

    def push(self, data: Any) -> None:
        self.__stack.append(data)

    def pop(self) -> Any:
        return self.__stack.pop()
    
    def __repr__(self):
        return repr(self.__stack)

    def __str__(self) -> str:
        return f"{' --- '.join([str(item) for item in self.__stack])}"


if __name__ == '__main__':
    s = Stack()
    s.push(1)
    s.push(2)
    s.push('Beta')
    s.push(4)
    print(s)
    print()
    print(s.pop())
    print(s)
    print()
    print(s.pop())
    print(s)
    print()
    print(s.pop())
    print(s)
    print()
    print(s.pop())
    print(s)
    print()
    try:
        s.pop()
    except LookupError:
        print('Stack is Empty lol')
```
