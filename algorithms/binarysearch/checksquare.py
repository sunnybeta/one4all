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

