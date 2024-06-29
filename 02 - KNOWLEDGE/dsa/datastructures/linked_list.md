
# Singly and Doubly Linked Lists

- [Singly and Doubly Linked Lists](#singly-and-doubly-linked-lists)
  - [Complexity](#complexity)
  - [use cases](#use-cases)
  - [singly](#singly)
    - [Impl Details (singly)](#impl-details-singly)
  - [doubly](#doubly)
    - [Impl Details (doubly)](#impl-details-doubly)

sequantial list of nodes that hold data which point to other nodes also containing data.

![Alt text](linked_list.drawio.svg)
[impementation java](computer_science/datastruct_algo_repo/datastructures/DoublyLinkedList.java)

## Complexity

| operation | singly | doubly |
| :-:       | :-:    | :-:    |
| Search         | O(n)  | O(n)  |
| Insert at head | O(1)  | O(1)  |
| Insert at tail | O(1)  | O(1)  |
| Remove at head | O(1)  | O(1)  |
| Remove at tail | O(n)  | O(1)  |
| Remove at midd | O(n)  | O(n)  |

## use cases

- used in many list, queue & stack impl
- ``circular list``
- model real world objects like trains
- used in separate chaining in certain Hash table impl
    to deal hashing collisions
- impl adjacency lists for graphs

## singly

Only hold a reference to the next node

`PRO`: less memory | simpler impl
`CONS`: cannot easily access previos elem

### Impl Details (singly)

- insert 11
  1. start at the head
  2. traverse the linkedlist until (11) is reached
  3. add node (change ref 2d/ ref 3d)
  ![Alt text](singly_linkedlist_insert.webp)

- remove 9
  1. create 2 pointers (one in head, other in pos1)
  2. move two pointers at the same time until (9) is reached
  3. avance point-2 one position (9 has to be in the middle)
  4. change ref
   ![Alt text](singly_linkedlist_remove.webp)

## doubly

Only hold a reference to the next node and previous node

### Impl Details (doubly)

- insert 11
  1. start at the head
  2. traverse the linkedlist until third node is reached
  3. add node (change ref 2d/ ref 3d)
   ![Alt text](doubly_linkedlist_insert.webp)

- remove 9
  1. create 1 pointer
  2. move until (9) is find
  3. change ref (previous/next)
   ![Alt text](doubly_linkedlist_remove.webp)

`PRO`: can be traversed
`CONS`: takes 2x memory
