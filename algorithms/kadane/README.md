# Kadane's Algorithm

## Problem

### Maximum Subarray Problem*

Given an array of numbers, find the maximum sum of the elements of a contiguous subarray out of all the subarrays.

### Solution

#### Brute Force

Look at all the subarrays and find the maximum sum.

#### Kadane

This problem can be though of as a dynamic programming problem as well.

Let `dp[k]` denote the maximum sum out of all the subarrays ending at index `k`.

At index `k+1`, we have two choices:

1. Element at index `k+1` contributes towards the maximum sum and thus `dp[k+1] = dp[k] + a[k+1]` is a better sum
2. Element at index `k+1` is larger than `dp[k]` and hence the new maximum sum is `dp[k+1] = a[k+1]`

```python
a = [1,9,3,-4,100,1,0,0,-10,2]
n = len(a)

dp = [0] * n
dp[0] = a[0]
ans = dp[0]

for i in range(1,n):
    dp[i] = max(a[i], dp[i-1] + a[i])
    ans = max(dp[i], ans)

print(a)
print(f'Maximum Sum = {ans}')
```
