# Boyre-Moore Majority Voting Algorithm

This is used for finding the majority element among the given elements that have more than N/ 2 occurrences.
It works by traversing over the given elements twice and works in `O(N)` time complexity and `O(1)` space complexity.


## Idea 

- Choose a candidate from the given set of elements.
- If it is the same as the candidate element, increase the votes.
- Otherwise, decrease the votes.
- If votes become 0, select another new element as the new candidate.

```python
from typing import List

def findMajority(arr: List[int]):
	size = len(arr)
	candidate = -1
	votes = 0
	 
	for i in range(size):
		if votes == 0:
			candidate = arr[i]
			votes = 1
		elif arr[i] == candidate:
				votes += 1
		else:
			votes -= 1
	return arr.count(size) > size // 2
```
