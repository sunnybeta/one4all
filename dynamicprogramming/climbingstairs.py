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
