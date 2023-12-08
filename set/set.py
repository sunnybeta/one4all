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
