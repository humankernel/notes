# Breath-First Search
#graph #bfs #flood-fill  #graph-traversal #blind-search

Its start in a node and it will travel the graph across the width
It will visit every direct neighborhoods and then they neighborhoods

## Algorithm

1. it add the start node to a queue
2. pop up the highest elem u form the queue (first in the line)
	and add his neighborhoods and marked as visited

## Complex 

| operation | O |
| :-:       | :-:    |
| time      | $O(V + E) - O(n^2)$ |
| space - adj list | $O(V + E)$  |
| space - adj matrix | $O(V^2)$  |


## Implementation

```cpp
void bfs(int start){
    // distance from origin to x
    vi distance(v, INF);  distance[start] = 0;
    //1. add start to queue
    queue <int> q; q.push(start);
    
    while (!q.empty()){
        int u = q.front(); q.pop();
        for (int v: adjList[u]){
            if (distance[v] == INF){ //no-visited
                distance[v] = distance[u]+1;
                q.push(v);
            }
        }
    }
    // return distance;
}
```


Graph

![[bfs 1.svg|300]]

Capa 1

![[bfs-capa1 1.svg|100]]

Capa 2

![[bfs-capa2 1.svg|200]]

Capa 3

![[bfs-capa34 1.svg|200]]



## Minimum Distances (not weighted graph) 
#minimum-distance  #graph-traversal

```python
from collections import deque

def shortest_path(graph: dict[int, list[int]], start: int, end: int) -> int:
    distance: dict[int, int] = {}

    distance[start] = 0
    queue = deque([start])

    end_reached = False
    while not end_reached and len(queue) > 0:
        current = queue.popleft()

        for adj in graph.get(current, []):
            if distance.get(adj, -1) == -1:
                queue.append(adj)
                distance[adj] = distance[current] + 1

            if adj == end:
                end_reached = True

    return distance.get(end, -1)


if __name__ == "__main__":
    graph: dict[int, list[int]] = {}

    graph[1] = [0, 2, 3, 4]
    graph[2] = [0, 1]
    graph[3] = [1, 5]
    graph[4] = [1]
    graph[5] = [3, 6, 7, 8]
    graph[6] = [5]
    graph[7] = [5, 8]
    graph[8] = [5, 7, 9]
    graph[9] = [8]

    print(shortest_path(graph, 1, 2))  # 1
    print(shortest_path(graph, 1, 6))  # 3
    print(shortest_path(graph, 2, 8))  # 4
    print(shortest_path(graph, 7, 4))  # 4
```

## Flood Fill Problem
#bfs

![[Pasted image 20231111193026.webp|400]]


```python
moves: list[tuple[int, int]] = [(0, 1), (0, -1), (1, 0), (-1, 0)]


def valid_pos(row: int, col: int, grid: tuple[int, int]) -> bool:
    rows, cols = grid
    return (row >= 0 and row < rows) and (col >= 0 and col < cols)


def flood_fill(
    img: list[list[int]], pos: tuple[int, int], color: int
) -> list[list[int]]:
    rows = len(img)
    cols = len(img[0])

    start_row, start_col = pos
    start_color = img[start_row][start_col]
    queue = [(start_row, start_col)]

    while len(queue) > 0:
        curr_row, curr_col = queue.pop(0)
        img[curr_row][curr_col] = color

        for row_offset, col_offset in moves:
            new_row = curr_row + row_offset
            new_col = curr_col + col_offset

            if (
                valid_pos(new_row, new_col, grid=(rows, cols))
                and img[new_row][new_col] == start_color
            ):
                queue.append((new_row, new_col))

    return img


if __name__ == "__main__":
    img = [
        [1, 0, 1, 1, 0],
        [0, 1, 0, 1, 0],
        [1, 1, 1, 1, 1],
        [0, 0, 1, 0, 1],
        [1, 0, 0, 0, 0],
    ]

    img = flood_fill(img, pos=(2, 2), color=2)

    assert img == [
        [1, 0, 2, 2, 0],
        [0, 2, 0, 2, 0],
        [2, 2, 2, 2, 2],
        [0, 0, 2, 0, 2],
        [1, 0, 0, 0, 0],
    ], "non equal"

    print(img)
```