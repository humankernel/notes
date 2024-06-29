ADT -> Abstract Data Type
every element has a certain priority
The Priority of the elements determine the order in which elements are removed

> NOTE:
> PQ only support **comparable data**

It's capability is based on a Heap

### use cases
* certain impl of [[Dijkstra]]'s Shortest Path Algorithm
* when you need the dynamically fetch the ('next best' || 'next worst') 
* [[Huffman]] coding (lossless data compression)
* [[bfs]] algorithms such a [[A]]* use PQ's to continuously grab the next most promising node
* Minimum Spanning Tree [[MST]] algorithms


## Complexity

| operation | complexity |
| :-:     | :-:    | 
| Binary Heap construction | O(n)  |
| Polling | O(log(n))  | 
| Peeking | O(1)   | 
| Adding  | O(log(n)) | 
| Naïve Removing | O(n) |
| Advanced removing with help from a [[hash-table]]| O(log(n)) |
| Naïve contains | O(n) |
| Contains check with help of a [[hash-table]] | O(1) |



Polling -> remove elem from root
Peeking -> see value on top
Adding  -> add

Naïve Removing -> do a lineal search and remove

> NOTE:
> using a hashtable to help optimize does take up lineal-space and adds some overhead to the binary heap impl


## Turning a Min PQ into Max PQ

since elements in a PQ are comparable they implement some sort of [[comparable-interface]] which we can simple **negate** to achieve a Max Heap

method #1
let x, y be nums in PQ
min PQ: x <= y
max PQ: x >= y

method #2 -> (only for nums)
negate the numbers before they are inserted and again once they are taken out

method #3 -> (string)
lex(s1, s2) = -1   if s1 < s2 lexicographically
lex(s1, s2) =  0   if s1 = s2 lexicographically
lex(s1, s2) = +1   if s1 > s2 lexicographically

nlex = -lex


## Adding elements to Binary Heap

PQ usually are implemented with [[heap]] cuz they give hem the best possible time complexity

