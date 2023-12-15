#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Node {
	int data;
	struct Node *left, *right;
} Node;


Node * insert (Node *, int);
bool   search (Node *, int);
void   display(Node *      );

int main() {
	Node *root = NULL;

	char choice;
	int input;
	bool search_result;

	printf("--- WELCOME TO BST ---\n\n");

	do {
		printf("Select ([i]nsert/[s]earch/[d]isplay/[q]uit)\n\n");
		scanf(" %c", &choice); 
		switch(choice) {
			case 'i': printf("\nInsert: ");
					  scanf("%d", &input);
					  root = insert(root, input);
					  printf("\n");
					  break;
			case 's': printf("\nSearch: ");
					  scanf("%d", &input);
					  search_result = search(root, input);
					  if (search_result) printf("Key %d: PRESENT\n\n",     input);
					  else               printf("Key %d: NOT PRESENT\n\n", input);
					  break;
			case 'q': printf("--- BYE BYE ---\n");
					  break;
			case 'd': printf("\n\n--- DISPLAY ---\n\n");
					  display(root);
					  printf("\n\n");
					  break;
			default : printf("Option %c is not available\n\n", choice);
					  break;
		}
	} while (choice != 'q');

	return 0;
}


Node *insert(Node *root, int data) {
	Node *node = malloc(sizeof(Node));
	node->left = NULL;
	node->right = NULL;
	node->data = data;

	if (!root) return node;

	Node *p = root;

	while (1) {
		if (data > p->data) {
			if (p->right != NULL) p = p->right;
			else                  {p->right = node; break;}
		} else if (data < p->data) {
			if (p->left  != NULL) p = p->left;
			else                  {p->left  = node; break;}
		}
	}

	return root;
}

bool search(Node *node, int key) {
	if      (node ==   NULL)   return false;
	if      (key > node->data) return search(node->right, key);
	else if (key < node->data) return search(node->left , key);
	else                       return true;
	return false;
}

void display(Node *node) {
	if (node != NULL) {
		display(node->left);
		printf ("%d * ", node->data );
		display(node->right);
	}
}
