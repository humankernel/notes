

## Static/Dynamic Array

- [Static/Dynamic Array](#staticdynamic-array)
  - [Complexity](#complexity)
  - [How to Implement Dynamic Array](#how-to-implement-dynamic-array)

A static array is a fixed length container containing n elements ``indexable``
from the range [0, n)

![Alt text](static_array.webp)


## Complexity

| operation | Static | Dynamic |
| :-:       | :-:    | :-:     |
| Access    | O(1)   | O(1)    |
| Search    | O(n)   | O(n)    |
| Insertion | N/A    | O(n)    |
| Appending | N/A    | O(1)    |
| Deletion  | N/A    | O(n)    |



## How to Implement Dynamic Array

with a static array

1. Create a static array with an initial size capacity
2. Add elements to the underlying static array, keeping track of the
   number of elements
3. If adding another element will exceed the capacity,
   then create a new static array with ``twice`` the capacity
   and copy the original elements into it.

![Alt text](dynamic_array.webp)
[implementation java](DynamicArray.java)
