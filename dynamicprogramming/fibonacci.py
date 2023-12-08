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
