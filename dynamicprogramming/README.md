# Dynamic Programming

Dynamic Programming is an optimization technique over recursion.
For recursion calls which would give us the same value, we can avoid the overhead calculation by storing this result in an external data structure and utilising it later.

## Fibonacci

```python
"""
Fibonacci numbers are formed by adding the previous two numbers
0,1,1,2,3,5,8,13,...
"""
def fibo(n: int):
    """Return the n-th fibonacci number
    """
    dp = [0 for _ in range(n)]
    dp[1] = 1
    print(dp[0])
    print(dp[1])
    for i in range(2,n):
        dp[i] = dp[i-1] + dp[i-2]
        print(dp[i])
    print('---')
    return dp[n-1]

if __name__ == '__main__':
    print(fibo(10))
```

## Climbing Stairs

```python
"""
Starting from position 0, a person can climb either 1 step or 2 steps.
In how many ways, can the user reach the top of the stairs of size n?
"""

def climbing_stairs(n: int):
    """
    The idea is as follows:

    If I am at the k-th step, I must have reached there from either the
    (i)  (k-1)-th step by taking 1 step
    (ii) (k-2)-th step by taking 2 steps

    Let dp[k] denote the number of ways to reach the k-th step.

    Then,

    dp[k] = dp[k-1] + dp[k-2]
    """
    dp = [0 for _ in range(n+1)]
    dp[0] = 1
    dp[1] = 1
    for i in range(2,n+1):
        dp[i] = dp[i-1] + dp[i-2]
    return dp[n]

if __name__ == '__main__':
    print(climbing_stairs(3))
```

## Minimize Cost

```python
"""
There are n steps and it takes energy |H[i-1]-H[j-1]| to go from the i-th step to the j-th step
Minimize the energy required to reach step n.
"""
def minimize_energy(H: list):
    """
    dp[k] = the minimum energy required to reach the (k+1)-th step
    Answer = dp[n-1]
    """
    n = len(H)
    dp = [0 for _ in range(n)]
    dp[0] = 0
    dp[1] = H[1] - H[0]
    for i in range(2,n):
        dp[i] = min(
            dp[i-1] + abs(H[i]-H[i-1]),
            dp[i-2] + abs(H[i]-H[i-2]),
        )
    return dp[n-1]


if __name__ == '__main__':
    H = [10,20,30,10]
    print(minimize_energy(H))
```
