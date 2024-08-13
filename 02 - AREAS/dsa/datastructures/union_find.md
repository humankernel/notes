[[dsu]] [[disjoint-set-tree]] [[mst]] [[minimun-spanning-tree]] [[union]] [[find]] 

# Disjoint Set

Union Find is a DS that keeps track of elements which are split into one or more disjoint sets
Its has two primary operations: [[find]] and [[union]]


## Summary:
* in general we keep an array that store the root of each node
* in the beginning root[i] = i (the root of the i-th node is himself)
[[find]]:
* to find which component a particular element belongs follow the parent nodes until a self loop is reached (a node who's parent is itself)
[[union]] :
* to unify two elements 
* find which are the root nodes of each component
* if the root nodes are different make one be the parent of the other


Remarks
* we do not "un-union" elements. Cuz its a very inefficient thing to do since would have to update all the children of a node
* the number of components is equal to the number of roots remaining
* the number of root nodes never increases





## Complexity

| operation | complexity|
| :-:       | :-:    |
| construction | O(n) |
| Union        | α(n) |
| Find         | α(n) |
| Get component size | α(n) | 
| Check if connected | α(n) |
| Count components | O(1) |

α(n) -> amortized constant time (only with [[path-compression]] optimization)




## use cases
* [[Kruskal's]] minimum spanning tree algorithm
* [[grid-percolation]]
* network connectivity
* [[least-common-ancestor]] in trees
* image processing




## [[magnets]] Example

![[Pasted image 20230206185109.webp]]

-> union(6,8) //since they are closest
![[Pasted image 20230206185210.webp]]

-> union(2,3,4)
![[Pasted image 20230206185247.webp]]

-> union(10,14,13)
![[Pasted image 20230206185312.webp]]

-> union(blue, 9)

![[Pasted image 20230206185709.webp]]

-> union(blue, yellow)
![[Pasted image 20230206185733.webp]]


![[Pasted image 20230206185832.webp]]



## Creating Union Find

1) first construct a [[bijection]] (a mapping) between your object and the integers in the range [0, n)
> NOTE:
> this step is not necessary in general, but it will allow us to construct an array-based union find

[[hashtable]] 
![[Pasted image 20230206192658.webp]]

![[Pasted image 20230206192707.webp]]
2) construct an [[array]]
![[Pasted image 20230206192818.webp]]


in the array the value of the elem represents its **root-node** 
in the beginning each has himself has his **root-node**

	![[Pasted image 20230206193026.png]]

3) to union(a,b)
	if root[a] != root[b] then connect

union(C,K):
	root[C] = 4
	root[K] = 9
	they are different then union(C,K)
	root[K] = root[C]

4) to union(A, B)
	![[Pasted image 20230206194024.webp]]
	since the direct-parent of A isn't himself A:5 but root[A] != 5
	we find the root of A and compare with the root of B which is himself
	and then since they both are different then connect A, B

WE MERGE SMALLER COMPONENTS INTRO LARGER ONES
![[Pasted image 20230206194449.webp]]
![[Pasted image 20230206194457.webp]]

## Path-Compression

Hypothetical Union-Find path compression example
![[Pasted image 20230206200438.webp]]
OPERATION: Take the union of E and L

union(E, L)
-> search the parent of E
	-> search the parent of D
		...
			-> we find F is the root
			

-> search the parent of L
	-> search the parent of K
		...
			-> we find G is the root


-> now we know who is the parent of {E,D,C,B,A} we point all to the parent directly (same with {L,K,J,I,H} -> G )
![[Pasted image 20230206201048.webp]]

with normal method
![[Pasted image 20230206201240.webp]]
with path-compression
![[Pasted image 20230206201352.webp]]