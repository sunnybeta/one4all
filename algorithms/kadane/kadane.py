a = [1,9,3,-4,100,1,0,0,-10,2]
n = len(a)

dp = [0] * n
dp[0] = a[0]
ans = a[0]

for i in range(1,n):
    dp[i] = max(a[i], dp[i-1] + a[i])
    ans = max(dp[i], ans)

print(f'Maximum Sum = {ans}')
