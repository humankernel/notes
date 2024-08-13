# Primes Numbers


[[bitset]]

## Sieve of Erastoteles

Optimizations:
1. limit the range $[2 ... \sqrt{N}]$ 
2. check if N is divisor of one multiple of a previous prime $[3, 5, 7, ..., \sqrt{N}]$
3. don't check with even numbers


Implementation

```cpp
ll _sieve_size;
bitset<10000007> bs;
vi primes;

void sieve(ll upperbound) {
    _sieve_size = upperbound + 1;
    bs.set();

    bs[0] = bs[1] = 0;
    for (ll i = 2; i <= _sieve_size; i++)
        if (bs[i]) {
            for (ll j = i * i; j < _sieve_size; j += i)
                bs[j] = 0;
            primes.push_back((int)i);
        }
}

bool isPrime(ll n) {
    // this only works if n < (last prime number in vi primes)^2
    if (n <= _sieve_size) return bs[n];
    for (int i = 0; i < (int)primes.size(); i++)
        if (n % primes[i] == 0) return false;
    return true;
}
```


```python
_sieve_size: int
bs: list[bool] = []
primes: list[int] = []

def sieve(upperbound: int):
    _sieve_size = upperbound + 1
    bs = [True for _ in range(_sieve_size+1)]

    bs[0] = bs[1] = False
    for i in range(2, _sieve_size+1):
        if bs[i] is True:
            for j in range(i*i, _sieve_size, i):
                bs[j] = False
            primes.append(i)

def is_prime(n: int) -> bool:
    if n <= _sieve_size:
        return bs[n]
    for i in range(len(primes)):
        if n % primes[i] == 0:
            return False
    return True

sieve(10000007)
print(primes)
```

