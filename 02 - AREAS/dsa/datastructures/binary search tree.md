## Complexity

| Operation | Average     | Worst  |
| --------- | ----------- | ------ |
| Insert    | $O(log(n))$ | $O(n)$ |
| Delete    | $O(log(n))$ | $O(n)$ |
| Remove    | $O(log(n))$ | $O(n)$ |
| Search    | $O(log(n))$ | $O(n)$ |


## Adding

* Elements must be **comparable** 

`<`:   Recurse down left subtree
`>`:  Recurse down right subtree
`=`:  Handle finding a duplicate value
`null leaf`: create a new node


![[bst - binary search tree.webp]]


WORST CASE
![[bst - binary search tree-1.webp]]



## Removing

1) `Find` the element (if it exist)
2) `Replace` the node we want to remove with its successor (if any)


### Find phase

`null node`: the value does not exist
comparator value `equal to 0`:  (found it!)
comparator value `less than 0`:  (is in the left subtree)
comparator value `greater than 0`:  (is in the right subtree)

### Remove phase

![[bst - binary search tree-2.webp]]


Node has both left right subtree

remove(7)

1. Find left most node of the right child
 ![[bst - binary search tree-3.webp]]
	Replace 7 with 11
	Then to remove 11 it encounters the 2 case
		remove 11 
		

![[bst - binary search tree-4.webp]]

![[bst - binary search tree-5.webp]]


## Tree Traversal

![[bst - binary search tree-6.webp]]

## Level Order Traversal

![[bst - binary search tree-7.webp]]

Its posible by doing a Breadth First Search (BFS)

## Implementation

[[BinarySearchTree.java]]