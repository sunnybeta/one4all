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
