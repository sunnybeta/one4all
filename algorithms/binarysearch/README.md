# Binary Search

Binary search is the most important algorithm in the world.

It is used to search for objects where the iterating space is in some sorted order reducing time complexity from `O(n)` to `O(log n)`.

## Standard Implementation

```python
import sys

arr = [1,3,4,6,7,8,9,10,23,59] 

try:
    key = int(sys.argv[1])
except IndexError:
    print('Please enter a key value')
    print('Proceeding with key = -1')
    key = -1

n = len(arr)

l = 0
h = n-1
m = -1

found = False

while l <= h:
    m = l + (h-l)//2
    if arr[m] == key:
        found = True
        break
    elif arr[m] < key:
        l = m+1
    else:
        h = m-1

print(arr)
print(key)
if found:
    print(f"Key {key} found at index {m}")
else:
    print("Oops")

```

## Infinite Sequence

Binary search can also be used if there is no limit on one end of the iterating space.

*Evaluate whether given integer `x` is a square of a number or not.*

```python
import sys

x = int(sys.argv[1])

l = 1
h = x
m = -1

found = False

while l <= h:
    m = l + (h - l)//2
    if m*m == x:
        found = True
        break
    elif m*m < x:
        l = m + 1
    else:
        h = m - 1


if found:
    print(f'Square root of {x} is {m}.')
else:
    print(f'{x} is not the square root of any integer')
```

## First Value Greater Than x

The sorted iterable helps us to solve this with binary search.

```python
import sys

arr = [1,3,4,6,7,8,9,10,23,59] 

try:
    key = int(sys.argv[1])
except IndexError:
    print('Please enter a key value')
    print('Proceeding with key = -1')
    key = -1

n = len(arr)

l = 0
h = n-1
m = -1

while l <= h:
    m = l + (h-l)//2
    if arr[m] <= key:
        l = m+1
    elif arr[m] > key:
        h = m-1

print(arr)
print(key)
print(f"First value greater than {key} is found at index {l}")
```

## Calculate the Square Root of a non-square number

```python
import sys

x   = int(sys.argv[1])
try:
    eps = float(sys.argv[2])
except IndexError:
    eps = 0.0001


l = 0
r = x
m = 0

while r - l > eps:
    m = l + (r-l)/2
    if m*m == x:
        break
    if m*m > x:
        r = m
    else:
        l = m

print(f'The square root of {x} is {m}.')
```
