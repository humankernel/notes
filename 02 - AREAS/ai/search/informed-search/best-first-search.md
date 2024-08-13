# Best First Search
#informed-search #best-first-search #greedy

> uses an evaluation function for each node, and then it expands to the best node

- Se codifica en un estado el padre y la accion
- Se tiene un control de todos los estados actuales y sus heurísticas
- Se toma el estado de mejor valor entre todos los estados terminales
- Se generan todos los estados hijos del estado de mejor valor


## Problem

Se tiene un grafo no ponderado y tienes información para hacer una función heurística (naive) y reducir la búsqueda

![[best-first.excalidraw|800]]

## Intuition

El objetivo es optimizar de forma greedy la cantidad de iteraciones necesarias usando la función heurística
👎No siempre tiene solución

## Approach

`open: S[]`: estados NO expandidos 
`closed: S[]`: estados expandidos (necesario en un grafo para evitar los bucles)

1. `open <- S.initial`:  Poner el estado inicial en una lista de nodos no expandidos `open`
2. `if !open then exit`: si open esta vacía salir con fallo
3. `closed <- min( f(open[i]) )`: poner en la lista de nodos expandidos `closed` el nodo n para el cual `f` es minima
4. expandir n
5. `if n' === S.final`: salir y construir la solución (el camino) si un adyacente es el final
6. `for each n' of n`
	2. `open <- n' if n' not in open and n' not in closed`: Para cada n' si no esta ni en open ni en close calcula su $f(n')$ y añádelo a `open`
	3. `open <- n' if f.new(n') < f.old(n')`: Y ahora n' debe actualizar su padre


## Complexity

| Complete | Optimal | Spatial Complexity | Temporal Complexity |
| -------- | ------- | ------------------ | ------------------- |
| no       | no      | $O(b^m)$           | $O(b^m)$            |

$b$: factor de ramificación
$m$: profundidad maxima del espacio de búsqueda

## Code
