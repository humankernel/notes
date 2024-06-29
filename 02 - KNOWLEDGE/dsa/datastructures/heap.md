
[[Tree-Based]] DS that satisfies the [[heap-invariant]] (heap property):

the parent node is *always* (greater || smaller) that all the child nodes

![[Pasted image 20230206144142.webp]]


### Examples
![[Pasted image 20230206144455.webp]]

![[Pasted image 20230206144512.webp]]



### Types of Heap

-> **Binary Heap**
-> Fibonacci Heap
-> Binomial Heap
-> Pairing Heap
...


### Binary Heap

Is a [[Binary-Tree]] that supports the [[heap-invariant]] 


!IMPORTAN PROPERTY
[[complete-binary-tree]] is a tree in which at every level, except possibly the last is completely filled and all the nodes are far left as possible
![[Pasted image 20230206152617.webp]]

## Representation
![[Pasted image 20230206155645.webp]]

let i be the parent node index

left child index:  2i + 1
right child index: 2i + 2
(zero based)

### Adding

insert(x)
* insert in the last position
* satisfy the [[heap-invariant]] 
	* while if it doesn't belongs here "bobble up" (swap pos with is parent)
-> insert (1) in heap
![[Pasted image 20230206160555.webp]]
-> satisfy [[heap-invariant]] (swap pos with parent)
![[Pasted image 20230206160624.webp]]
![[Pasted image 20230206160709.webp]]
![[Pasted image 20230206160718.webp]]

### Poll-ing

Poll () - O(log(n))
* return root (poll-ing) (red)
* swap with last node in array (purple)
* satisface [[heap-invariant]] 


-> remove root (red)
![[Pasted image 20230206160918.webp]]
-> swap with last node (purple)
![[Pasted image 20230206161032.webp]]
-> (bubble-down) swap with smallest children
![[Pasted image 20230206161144.webp]]

![[Pasted image 20230206161219.webp]]

![[Pasted image 20230206161228.webp]]



### Removing

remove(x) - O(n)
-> begin in root and do a **lineal** scan until x is find
 ![[Pasted image 20230206161453.webp]]
-> swap x-node with last node purple
![[Pasted image 20230206161620.webp]]
-> remove last node (now x-node)
![[Pasted image 20230206161647.webp]]
-> [[bubble-up]] swap with parent
![[Pasted image 20230206161818.webp]]
![[Pasted image 20230206161827.webp]]


-> remove(3)
-> find him
![[Pasted image 20230206162026.webp]]
-> swap with last-node
![[Pasted image 20230206162055.webp]]
-> [[bubble-down]] (because we already satisfy the [[heap-invariant]] from above)
![[Pasted image 20230206162249.webp]]
![[Pasted image 20230206162314.webp]]

### Removing in O(log(n))

the inefficiency of removal comes from that we have to perform a lineal search, to find out where the element is indexed

For that we use a [[hashtable]]
[[hashtable]] provides a **constant** time lookup and update for a mapping from a key (the node value) to a value (the index)

Multiple Value Problem:
Instead of mapping one-value -> one-position
we map one-value -> multiple-positions
We can maintain a [[Set]] or [[TreeSet]] of indexes for which a particular node value (key) maps to
![[Pasted image 20230206163353.webp]]