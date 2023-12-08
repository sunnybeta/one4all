# Set

A **set** is a data structure which stores a collection of distinct elements in no specific order.
In standard sets, there can be no duplicate elements.
Lookup in sets happen in constant time and are useful for existence search.
Other Variants Include: Multiset and Ordered Set.

## Methods

- `add`: Add elements to a set
- `union`: The union of two sets is all the elements from both the sets
- `intersection`: The intersection is the set of all common elements from both sets
- `complement`: Given a subset, complement of this set is the set of elements not container in the subset
- `contain`: Check whether an element exists in the set
- `size`: Return the total number of elements in the set
- `display`: Print the contents of the set

```python
from typing import Any

class Set:

    def __init__(self, *args) -> None:
        self.__set = set(args)

    def add(self, data: Any) -> None:
        self.__set.add(data)

    def union(self, other) -> set:
        return self.__set.union(other.__set)

    def intersection(self, other) -> set:
        return self.__set.intersection(other.__set)

    def complement(self, other) -> set:
        return set([element for element in other.__set if not self.contain(element)])

    def contain(self, data: Any) -> bool:
        return data in self.__set

    def size(self) -> int:
        return len(self.__set)
```
