# Maze Problem

## Problem

Given an NxM grid, in how many ways can a rabbit get from the top-left to the bottom-right corner if it can only move down or right?

## Intuition


![[Pasted image 20231111151721.webp|600]]


$$
solution(n, m) =  
	\left 
	\{
		\begin{array}{lcc}
			1 & \text{if} & (1,1) \\ \\
			solution(n-1, m) + solution(n, m-1) & \text{if} & (n, m)
		\end{array}
	\right.
$$

## Approach


## Complexity

| operation | O |
| :-:       | :-:    |
| bottom-up      | $O(n * m)$  |


## Code


```py
def grid_paths(rows: int, cols: int) -> int:
    memo: dict[tuple[int, int], int] = {}

    for i in range(1, rows + 1):
        memo[(i, 1)] = 1

    for i in range(1, cols + 1):
        memo[(1, i)] = 1

    for i in range(2, rows + 1):
        for j in range(2, cols + 1):
            memo[(i, j)] = memo.get((i - 1, j), 0) + memo.get((i, j - 1), 0)

    return memo[(rows, cols)]

print(grid_paths(18, 6))   #26334
print(grid_paths(75, 19))  #5873182941643167150
```

