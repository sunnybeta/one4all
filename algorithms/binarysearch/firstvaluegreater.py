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
