
#dp #memoization

## Problem

![[Pasted image 20231111100301.webp|600]]


## Complexity

| operation | O |
| :-:       | :-:    |
| non-memo      | $O(2^{\frac{n}{2}})$  |
| memo      | $O(n)$  |

la complejidad se duplica 


## Code

Without memo

```py
def fib(n):
    if n <= 2:
        return 1
    return fib(n-1) + fib(n-2)
```


With memo

```py
memo = {}

def fib(n):
    if n in memo:
        return memo[n]

    if n <= 2:
        return 1

    result = memo[n] = fib(n - 1) + fib(n - 2)
    return result

print(fib(50))
```

bottom-up aproach

```py
memo = {}
def fib2(n: int):
    for i in range(1, n + 1):
        if i <= 2:
            memo[i] = 1
        else:
            memo[i] = memo[i - 1] + memo[i - 2]

    return memo[n]
```

