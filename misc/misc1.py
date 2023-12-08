"""
Create a class which supports the following operations:

(i)   Add a value with no duplicates
(ii)  Remove a value
(iii) Retrieve a random value from the list of values

"""

import random
from typing import Any


class Store:

    def __init__(self) -> None:
        self.__index  = {}
        self.__values = []

    def add(self, data: Any) -> None:
        if data in self.__index:
            return
        self.__values.append(data)
        self.__index[data] = len(self.__values) - 1

    def remove(self, data: Any) -> None:
        if data in self.__index:
            return
        index = self.__index[data]
        last_value = self.__values[-1]
        self.__index[last_value] = index
        self.__index.pop(data)
        self.__values[index] = last_value
        self.__values.pop()

    def retrieve(self) -> Any:
        return random.choice(self.__values)

"""
(*) Follow up: allow duplicate values
"""

import random
from typing import Any
from collections import defaultdict



class MultiStore:

    def __init__(self) -> None:
        self.__index  = defaultdict(list)
        self.__values = []

    def retrieve(self) -> Any:
        return random.choice(self.__values)

    def add(self, data: Any) -> None:
        self.__values.append(data)
        self.__index[data].append(len(self.__values) - 1)

    def remove(self, data: Any) -> None:
        if data in self.__index:
            return
        index = self.__index[data].pop()
        last_value = self.__values[-1]

        self.__values[index] = last_value
        self.__index[last_value].append(index)
        self.__values.pop()
        if len(self.__index[data]) == 0:
            self.__index.pop(data)


"""
Summary
-------

1. Using a set is alright but then retriving a random element is sub optimal
2. Using a combination of map and list helps us optimize this. We swap the last value with what we need to remove and make the removal constant.
"""
