# Blind 75 Challenge

### Question 1

Link: [Two Sum](https://leetcode.com/problems/two-sum/)

*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.*

*You may assume that each input would have exactly one solution, and you may not use the same element twice.*

*You can return the answer in any order.*

<details>
<summary>Solution</summary>
```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        di = {}
        for i, num in enumerate(nums):
            if target-num in di:
                return[i,di[target-num]]
            di[num] = i
```
</details

### Question 2

Link: [Best Time To Buy and Sell](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

*You are given an array prices where prices[i] is the price of a given stock on the ith day.

*You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.*

*Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.*


<details>
<summary>Solution</summary>
```cpp
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0;
        int minimum = prices[0];
        for (int price: prices) {
            if (price < minimum) minimum = price;
            ans = max(price - minimum, ans);
        }
        return ans;
    }
}
```

### Quesstion 3

Link: [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.*

<details>
<summary>Solution</summary>
```java
class Solution {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i=0; i < nums.length; i++) {
            ans += i - nums[i];
        }
        return ans;
    }
}
```
</details>


