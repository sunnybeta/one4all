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
