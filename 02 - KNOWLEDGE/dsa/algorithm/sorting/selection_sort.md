#stable

> *select the lowest element - put it at first - repeat*

## Complexity

| operation | O |
| :-:       | :-:    |
| Sort      | $O(n^2)$  |


## Concept 

Search the lowest element and copy at first then ignoring the previous ordered elements repeat the process

## Implementation

```java
for (int i = 0; i < arr.size(); i++) {  
	int min = arr.get(i);  
	int min_idx = i;  
	for (int j = i; j < arr.size(); j++) {  
		if (min < arr.get(j)) {  
			min = arr.get(j);  
			min_idx = j;  
		}  
	}  
	int elem = arr.remove(min_idx);  
	arr.addFirst(elem);  
}
```