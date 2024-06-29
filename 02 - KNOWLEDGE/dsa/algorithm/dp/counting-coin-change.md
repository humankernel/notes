
# Counting Coin Change
#dp #counting-coin 

## minimum number of coins

### Problem

Given a set of coin values $coins=\{cl, c2, ..., ck\}$ and a target sum of money m, what's
the minimum number of coins that form the sum m?

coins = {1, 4, 5}
Taget Sum: 13

**solution**: 3 cons (4+4+5)

### Intuition

### Geedy
One greedy solution is to always pick the largest one 

coins = {1, 4, 5}
Taget Sum: 13

**greedy**: 5 coins (5+5+1+1+1)
**optimal**: 3 cons (4+4+5)

### Brute Force - Recursive

coins = {1, 4, 5}
Taget Sum: 13

We compute each posible path given a coin and if it leads to the solution the lenght of that paths and the chosen coins are the answer

We define cases
minimun_coins(coins, m)

$$
\text{min\_coins}(coins, m) = 
	\left
	\{ 
		\begin{array}{lcc} 
			0 & \text{if} & m = 0 \\ \\ 
			min \ (solution(m - c) + 1) & \text{else} &  c \in coins\\ 
		\end{array} 
	\right.
$$


![[Pasted image 20231111110838.webp|500]]

We **CAN't** go below 0
We only chose coins that leads to posible states





### Complexity

**m**: target sum
**n**: number of coins


| operation | O |
| :-:       | :-:    |
| bf - recursive      | $O(--)$  |
| bf - recursive + memo      | $O(m*n)$  |

### Code

Without memo

```py
def minimum_coins(m: int, coins: list[int]) -> int:
    if m == 0:
        return 0

    answer = 1000
    for coin in coins:
        subproblem = m - coin
        if subproblem < 0:
            continue

        answer = min(answer, minimum_coins(subproblem, coins) + 1)

    return answer
```


With memo

```py
memo: dict[int, int] = {}

def minimum_coins_memo(m: int, coins: list[int]) -> int:
    if m in memo:
        return memo[m]

    if m == 0:
        answer = 0

    else:
        answer = 1000
        for coin in coins:
            subproblem = m - coin
            if subproblem < 0:
                continue

            answer = min(answer, minimum_coins_memo(subproblem, coins) + 1)

    memo[m] = answer
    return answer

print(minimum_coins_memo(150, [1, 4, 5]))
```

bottom-up

```py
def minimum_coins_bottom_up(m: int, coins: list[int]) -> int:
    memo: dict[int, int] = {}

    memo[0] = 0

    for i in range(1, m + 1):
        answer = 1000
        for coin in coins:
            subproblem = i - coin
            if subproblem < 0:
                continue
            answer = min(answer, memo[subproblem] + 1)

        memo[i] = answer

    return memo[m]
```





## amount posible solutions

### Problem

Given a set of coin values $coins=\{cl, c2, ..., ck\}$ and a target sum of money m, in how many ways we form the sum m using these coins?

coins = {1, 4, 5}
Taget Sum: 5

**solution**: 4 
1. 1+1+1+1+1
2. 1+4
3. 4+1
4. 5

### Intuition

coins = {1, 4, 5}
Taget Sum: 5

$$
\text{amount\_possible\_ways}(coins, m) = 
	\left
	\{ 
		\begin{array}{lcc} 
			1 & \text{if} & m = 0 \\ \\ 
			\sum solution(m - c) & \text{else} & c \in coins
		\end{array} 
	\right.
$$


![[Pasted image 20231111125745.webp|500]]


### Complexity

**m**: target sum
**n**: number of coins


| operation | O |
| :-:       | :-:    |
| bf - recursive      | $O(--)$  |
| bf - recursive + memo      | $O(m*n)$  |
| dp      | $O(m*n)$  |

### Code

**memo**: will contain the amount of posible solutions


```py
def amount_possible_ways(m: int, coins: list[int]) -> int:
    memo: dict[int, int] = {}
    memo[0] = memo[1] = 1

    for i in range(2, m + 1):
        answer = 0
        for coin in coins:
            subproblem = i - coin
            if subproblem < 0:
                continue

            answer += memo[subproblem]
        memo[i] = answer
        
    return memo[m]

print(amount_possible_ways(5, [1, 4, 5]))  # 4
print(amount_possible_ways(87, [1, 4, 5, 8]))  # 3306149332861088
```
