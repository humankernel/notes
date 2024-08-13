> Array is one of the fundamental blocks in algorithms. Since a string is just formed by an array of characters, they are both similar. Most interview questions fall into this category. Here we will discuss some common techniques to help you solve these problems.


These kind of problems usually involve two pointers:

> One slow-runner and the other fast-runner.
> or
> One pointer starts from the beginning while the other pointer starts from the end.

A classic example is to *remove duplicates from a sorted array*, which is available for you to practice [here](https://leetcode.com/problems/remove-duplicates-from-sorted-array/).


## Algo
1) you have [[two-pointers]]:
	`i` -> begin
	j -> end
2) they move toward each other until they both meet
	i++; j--;    i -> <- j
	

## [[Problem]]: Reverse the characters in a string

The idea is to swap the first with the end char and so and until the middle

### Complexity
time: O(n)
space: O(n)

```c++
for (int i=0; i<n/2; i++)
	swap(str, i, n-i-1);
```

or also using [[two-pointers]] technique
```cpp
int i=0, j=str.length-1;
while (i < j){
	swap(str, i, j);
	i++;
	j--;
}
```



## [[Problem]]: Remove Duplicates from Sorted Array

[Remove Duplicates from Sorted Array - LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)

"without use extra space so space - O(1)"

After populating our map, we get all the unique elements from our array.
We then iterate our map and push all the keys in our input array
However, without using extra space it makes it a bit tricky as we have to modify the existing input array


[0,0,1,1,2,2,2,3,3,4,4] 
= [0,1,2,3,4,_,_,_,_,_,_], k=5

[1,1,2]
= [1,2,_], k=2


### Approach 1: [[two-pointers]] 

### Intuition:

To solve the problem, let's look at the condition carefully,
> It is **guaranteed** that the given array is a **sorted array**.

Let `k` be the count of unique elements in our input array.
> It doesn't matter what elements we place after the first `k` elements.

From the condition, we can have a few observations here,
-   Since the array we have is sorted, all duplicate values will be one after the other.
    
-   We need to update the first `k` elements in an array with unique values and return the value of `k`.

[[two-pointers]] approach:
* The **first index** updates the value in our input array while reading the data from the **second index**


#### Algorithm
1) Start both indexes `(insertIndex, i)` from 1.
2) check if the previous elem is different from the current
3) if different then:
	`arr[insertIndex] = arr[i]`
	`insertIndex++`
4) increment `i` until the end


#### Complexity
time: O(n)
space: O(1)

#### Implementation
```cpp
int solution(vector<int>& nums){
    int n = nums.size();
    int insert_index = 1;

    for (int i = 1; i < n; i++){
        // if isn't a duplicate then insert
        if (nums[i - 1] != nums[i]){
            nums[insert_index] = nums[i];
            insert_index++;
        }
    }
    return insert_index;
};
```





## [[Problem]]: Two Sum

Given a **1-indexed** array of integers `numbers` that is already **_sorted in non-decreasing order_**, find two numbers such that they add up to a specific `target` number

**Example 1:**

**Input:** numbers = [2,7,11,15], target = 9
**Output:** [1,2]
**Explanation:** The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

**Example 2:**

**Input:** numbers = [2,3,4], target = 6
**Output:** [1,3]
**Explanation:** The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

**Example 3:**

**Input:** numbers = [-1,0], target = -1
**Output:** [1,2]
**Explanation:** The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

### Approach: [[two-pointers]] 

given an ordered array

### Algorithm
1) two pointers 
	`i` -> 0
	j -> nums.Length
3) if `nums[i] + nums[j] == target` return `(i, j)`
	if `nums[i] + nums[j] > target` j--  
	else i++


