# Trie

A trie is a multiway tree data structure used for storing large amounts of strings over a dictionary.

```cpp
const int ALPHABET_SIZE = 26;

typedef struct Trie {
    bool end;
    struct TrieNode *childern[ALPHABET_SIZE];
} Trie;

Trie *getNode() {
    struct Trie *p = new Trie;
    p->end = false;
    for (int i = 0; i < ALPHABET_SIZE; i++) p->children[i] = NULL;
    return p;
}
```


## Insert

Every character in a trie is an individual edge starting from an initial node. When we come across a new character, we create another trie node using the children array. If the character is the last character of the string, we can mark that character as the *end of the word* and set the corresponding value to true.

Since we use common prefixes for storing and searching, trie takes less space to contain a large number of short strings and trie searches are faster as the lookup of keys depends upon the heigh of the binary search

```cpp
void insert(Trie *root, string key) {
    struct Trie *p = root;
    for (int i = 0; i < key.length(); i++) {
        int index = key[i] - 'a';
        if (!p->children[index]) p->children[index] = getNode();
        p = p->children[index];
    }
    p->end = true;
}
```


## Search

Searching in trie is as simple as compare the character and go next assuming you have not reached the end of the word.


```cpp
void search(Trie *root, string key) {
    struct Trie *p = root;
    for (int i = 0; i < key.length(); i++) {
        int index = key[i] - 'a';
        if (!p->children[index]) return false;
        p = p->children[index];
    }
    return p->end;
}
```


## Complexity

Insert and Search costs `O(K)` time where `K` is the length of the key.
Memory requirements of trie is given by `O(alphabets * |key| * N)` where N is the number of keys in the trie.
