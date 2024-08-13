
# Stack (LIFO)

![Alt text](stack.webp)

## Complexity

| operation | singly |
| :-:       | :-:    |
| Pushing   | O(1)  |
| Popping   | O(1)  |
| Peeking   | O(1)  |
| Searching | O(n)  |
| Size      | O(1)  |

## use cases

* undo mechanisms in text editors
* *compiler syntax checking for matching brackets and braces*
* to model a pile of books  
* behind the scenes to support recursion by keeping track of
    previos functions calls
* DFS

## Example - Brackets

Problem: Given a string of brackets, determine if the brackets are balanced.
Solution: [Python](brackets.py)

[{}]     -> **Valid**
(()())   -> **Valid**
{]       -> Invalid
[()]))() -> Invalid
[]{}({}) -> **Valid**

## Example - Tower of Hanoi

![Alt text](tower_hanoi.webp)
![Alt text](tower_of_hanoi.gif)

## Impl Details

* Like Singly LinkedList
* [Impl Java](Stack.java)
