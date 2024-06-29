#stable

> *Insert the unsorted element where it should be*

## Complexity

| operation | O |
| :-:       | :-:    |
| Sort      | $O(n^2)$  |

Stable: in any given time the algoritm does not unorder the array

## Concept

Sort in $n^2$ first search the most small element and insert it in the first position


```pseudo
Start from the 1rs idx (the 0 is taken as already sorted)
for each unsorted element:
	for each sorted elements find where to put the i element:
		if can be here then:
			remove the element 
			put here the element 
			and stop find
```

## Implementation

```java
for (int i = 1; i < arr.size(); i++) {  
	for (int j = 0; j <= i; j++) { 
		if (arr.get(i) <= arr.get(j)) {  
			int elem = arr.remove(i);  
			arr.add(j, elem);  
			break;  
		}
	}	  
}
```

