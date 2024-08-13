
![[Pasted image 20230206113006.png]]



```python
def move(orig: int, dest: int):
    pass
  
def hanoi(n: int, orig: int, aux: int, dest: int) -> int:
    if n == 1:
        move(orig, dest)
        pass
    else:
        hanoi(n-1, orig, dest, aux)
        move(orig, dest)
        hanoi(n-1, aux, orig, dest)
```



