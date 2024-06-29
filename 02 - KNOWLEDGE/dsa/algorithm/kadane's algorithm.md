[[kadane]] [[max-subarray]]

![[Pasted image 20230207162242.webp]]

## Intuition
We have to find the maximum sum of the sub-array. That means we have to **avoid negative numbers** as much as possible.

## Approach
We can use **Kadane's Algorithm** to optimize the code.

1) create two variables to store current and maximum sub-array sum
	`curSum`: that stores the maximum sum contiguos subarray ending at current index and variable
	`maxSum`: stores the maximum sum of contiguos subarray found so far
2) iterate from index 1 to n-1
3) keep increasing the current sub-array sum
4) If, curSum becomes negative, reset it to 0
5) If, curSum >= maxSum the update maxSum

## Complexity
* time: O(n)
* space: O(1)


## Code
```pseudocode
Initialize:
    maxSum = INT_MIN
    `curSum` = 0

Loop for each element of the array

  (a) `curSum` = `curSum` + a[i]
  (b) if(maxSum < `curSum`)
            maxSum = `curSum`
  (c) if(`curSum` < 0)
            `curSum` = 0
return maxSum
```

```java
class Solution {
	public int maxSubArray(int[] nums) {
	    // We will need two variables. One will store current sub-array sum.
	    // Other will store maximum sub-array sum.
	    int curSum = nums[0];
	    int maxSum = nums[0];   // consider 1st element to be greatest sub-array.
	
	    for(int i = 1; i < nums.length; i++){
	        // If the cur sub-array sum is negative then reset is to 0.
	        if(curSum < 0)
	            curSum = 0;
	        
	        // Iterate over the array and calculate sub-array sum.
	        curSum += nums[i];
	
	        // maxSum will be greater of curSum and maxSum.
	        maxSum = max(maxSum, curSum);
	    }
	    // finally, return the maxSum.
	    return maxSum;
	}
}
```
