#stable 

## Complexity

| operation | O |
| :-:       | :-:    |
| Sort      | $O(n^2)$  |

Stable: in any given time the algoritm does not unorder the array

## Concept

Sort in $n^2$ comparing two subsecuent arr items

## Implementation

```java
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j+1]){
            int tmp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = tmp;
        }
    }
}
```

### Optimization #1

Not to go to the end when this is already sorted

```java
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1 - i; j++) {
```

### Optimization #2: Swap without extra var

```python
a = 10
b = 5

a = a + b  # 15
b = a - b  # 10
a = a - b  # 5
```

```java
for (int i = 0; i < arr.length - 1; i++)
    for (int j = 0; j < arr.length - i - 1; j++)
        if (arr[j] > arr[j+1]) {
            arr[j] = arr[j] + arr[j+1];
            arr[j+1] = arr[j] - arr[j+1];
            arr[j] = arr[j] - arr[j+1];
        };
```

### Optimization #3: Execute unless its already sorted

```java
boolean stop = false;  
for (int i = 1; i <= arr.length - 1 && !stop; i++) {  
	stop = true;  
	for (int j = 0; j < arr.length - i; j++) {  
		if (arr[j] > arr[j + 1]) {  
			arr[j] = arr[j] ^ arr[j + 1];  
			arr[j + 1] = arr[j] ^ arr[j + 1];  
			arr[j] = arr[j] ^ arr[j + 1];  
			stop = false;  
		}  
	}	  
}
```

