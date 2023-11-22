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
