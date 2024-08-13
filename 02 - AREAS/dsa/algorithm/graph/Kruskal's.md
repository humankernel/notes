[[Kruskal]] [[MST]]
minimum spanning tree algorithm

PROBLEM: 
Given a graph G = (V,E) 
we want to find a [[MST]] in the graph (it may not be unique)


A [[MST]] is a subset of the edges which connect all vertices in the graph with the minimal total edge cost

![[Pasted image 20230206190839.webp]]

![[Pasted image 20230206190855.webp]]


1) Sort edges by (ascending edge weight)

![[Pasted image 20230206191419.webp]]

2) Walk through the sorted edges 
	and look at the two nodes the edge belongs to,
	if the nodes *are already unified* we don't include this edge
	else we include it and unify the nodes

![[Pasted image 20230206191557.webp]]

C -> I: C don't belongs to any group but I yes

C -> J: C already belongs to J group, then don't include that edge
![[Pasted image 20230206191935.webp]]

3) the algo ends when every edge has been processed or all the vertices have been unified

![[Pasted image 20230206192155.webp]]