# Deapth-First Search

#graph #dfs #graph-traversal #topo-sort #cycle-detection #connected-components #blind-search 



![[dfs 1.svg|500]]



## Aplications

- [ ] cycle detection 
	(when you encounter an edge that already have been visited then you have a cicle)
- [ ] finding connected components
	(run dfs multiple time - each time dfs encounter one component)
- [ ] topological sort

## Complex


| operation | O |
| :-:       | :-:    |
| time      | $O(V + E) - O(n^2)$ |
| space - adj list | $O(V + E)$  |
| space - adj matrix | $O(V^2)$  |


## Algorithm

1. start from a origin node
	(depth search algo) each time it encounters a vertice with more than one neighborhood, elijará uno de los vecinos no visitados y visitara su vertices

2. marked as VISITED
3. traverse each of its neighborhood while it's a non-VISITED node

## Implementation

Clasic implementation 
#dfs #python

```python
visited = [False] * len(graph)

def dfs_preorder(graph: list[list[int]], pos: int) -> None:
    visited[pos] = True
    for adj in graph[pos]:
        if not visited[adj]:
            dfs(graph, adj)


def dfs_posorder(graph: list[list[int]], pos: int) -> None:
    for adj in graph[pos]:
        if not visited[adj]:
            dfs(graph, adj)
    visited[pos] = True
```


Minimum distances - not weighted graph
#dfs #minimum-distance 

```python
distance: dict[int, int] = {}

def dfs(graph: list[list[int]], pos: int) -> None:
    for adj in graph[pos]:
        if distance.get(adj, -1) == -1:
            distance[adj] = distance[pos] + 1
            dfs(graph, adj)

        else:
            distance[adj] = min(distance.get(adj, 1000), distance[pos] + 1)


if __name__ == "__main__":
    graph = [
        [1, 2, 3],
        [0, 3],
        [0, 3],
        [1, 2, 4],
        [3],
    ]

    START_POS = 0
    distance[START_POS] = 0
    dfs(graph, pos=START_POS)

    assert distance.get(2, -1) == 1
    assert distance.get(1, -1) == 1
    assert distance.get(3, -1) == 1
    assert distance.get(4, -1) == 3

```



```cpp
typedef vector<int> vi;
typedef vector<vii> vvii;

const int UNVISITED = -1;
const int VISITED = 1;
vvii adjList;
vi dfs_visited(UNVISITED, n);

void dfs(int u){
    dfs_visited[u] = VISITED;
    for (auto v: adjList[u])
        if (dfs_visited[v.first] == UNVISITED)
            dfs(v.first);
}
```


// se basa en lo clásico de backtracking
```cpp
void backtrack(estado) {
	if (llega a estado final o estado no valido)
		return;  //necesitamos una situacion de terminacion o pada para evitar ciclos y acelerar busqueda
	for cada vecino de este estado  //probar todas las permutaciones
		backtrack(vecino)
}

```


## Problem UVa 11902 - Dominator: (send to judge)


In graph theory, a node X dominates a node Y if every path from the predefined start node to Y must go through X. If Y is not reachable from the start node then node Y does not have any dominator. By definition, every node reachable from the start node dominates itself.

Given a directed graph, find the dominators of every node assuming the zeroth node is the start node.

![[dominator.svg|300]]

### Explanation
1. Use [[dfs]] (or [[bfs]]) to **compute** an initially reachable set of nodes starting at node 0. 
2. Then, iteratively remove (or ignore) each node and recompute DFS (or BFS) reachability from node 0. 
3. If a given node i was reachable before removing another node j, then j dominates i.



### Optimization

-   It is only necessary to remove each node j to test for domination once. That is, test only O(N) node removals, not O(N2).
-   Consider storing the graph using an adjacency list instead of the given matrix form.
-   Directly generate the output string for each row instead of using a boolean matrix to print each element. This requires only O(N) printf (or write) calls to create the output instead of O(N^2) calls. However, I/O does not dominate this problem (pardon the pun!).

### Implementation

```cpp
const int UNVISITED = 0;
const int VISITED = 1;
int v, e;
vi visited(7);
vvi adjList(7);
set<int> reachable_from_origin;

//  a / b, los que estan solo en a
set <int> diff(set<int> a, set<int> b){
    set <int> sol;
    for (int n: a)
        if ( b.find(n) == b.end() ) sol.insert(n);
    return sol;
}

void dfs(int u, int x){
    visited[u] = VISITED;
    reachable_from_origin.insert(u);

    for (int v : adjList[u]){
        if (visited[v] == UNVISITED && v != x) //ignore x
            dfs(v, x);
    }
}

int main(){
    cin >> v >> e;
    int a, b;
    rep(i, 0, e){
        cin >> a >> b;
        adjList[a].push_back(b); // uni-directional
    }

    // 1. compute an initially reachable set of nodes starting at node 0
    dfs(0, -1);

    vector<set<int> > reachability(v+1);
    reachability[0] = reachable_from_origin;
    
    // 2. iteratively ignore each node recompute DFS reachability from node 0
    rep(i, 1, v){
        reachable_from_origin.clear(); //reset set
        transform(visited.begin(), visited.end(), visited.begin(), [](int x){return UNVISITED;}); //reset visited
        
        dfs(0, i);
        // If a given node i was reachable before removing another node j, then j dominates i.
        // reachability[i].insert(i); // every node is it own dominator
        reachability[i] = diff( reachability[0], reachable_from_origin );
    }

    rep(i, 0, v){
        cout << '\n'
             << i << ": ";
        for (int j : reachability[i])
            cout << j << ' ';
    }
    
    return 0;
}
```



## (DAG) Topo-Sort
#dag

How we can find a valid order to execute task in a directed-acyclic-graph (DAG)



![[Pasted image 20231112114440.webp|500]]


```python
order: list[int] = []

def dfs_postorder(graph: list[list[int]], visited: list[bool], pos: int) -> list[int]:
    for adj in graph[pos]:
        if not visited[adj]:
            dfs_postorder(graph, visited, adj)

    visited[pos] = True

    order.append(pos)
    return order


if __name__ == "__main__":
    graph = [
        [1, 2],
        [2, 3, 4],
        [],
        [5],
        [],
        [6, 7, 8],
        [],
        [8],
        [9],
        [],
    ]

    visited = [False] * len(graph)
    dfs_postorder(graph, visited, 0)

    order.reverse()
    print(order)
```
