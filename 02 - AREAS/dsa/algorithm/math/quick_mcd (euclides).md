
maximun common divisor


![[Pasted image 20230206105621.png]]


```python
def mcd_euclides(a: int,b: int) -> int:
    if b == 0:
        return a
    return mcd_euclides(b, a%b)
```

