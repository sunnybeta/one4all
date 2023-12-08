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
