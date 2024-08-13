
```python
def quick_pow(base: int, exp: int) -> int:
    if exp == 0:
        return 1
    if exp == 1:
        return n
    if exp % 2 == 0:
        return quick_pow(base * base, exp // 2)
    else:
        return n * quick_pow(base * base, exp // 2)
```



```c
```c
int pow( int base, int exponent)

{   // Does not work for negative exponents. (But that would be leaving the range of int) 
    if (exponent == 0) return 1;  // base case;
    int temp = pow(base, exponent/2);
    if (exponent % 2 == 0)
        return temp * temp; 
    else
        return (base * temp * temp);
}
```
```
