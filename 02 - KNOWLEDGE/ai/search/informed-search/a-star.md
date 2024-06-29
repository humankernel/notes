# A* 
#informed-search #a-star

> defines a function $f'$ as an estimation of the cost to go from the initial node to the objetive, in the current path
> $f' = g' + h'$

## Problem

Se quiere hallar la mejor trayectoria de un nodo a otro, y se tiene un peso de transición entre nodos además de una heurística

![[a-star.excalidraw|700]]


## Intuition

Evitar expandir caminos que acumulan un costo elevado
Tener en cuenta lo que ha costado llegar al nodo actual

Se quiere llegar lo mas rápido a la meta minimizando el costo. Aquí hay 2 cosas a tener en cuenta 
1. Se expandiera al nodo con menor costo (puede desviarte de la meta)
2. Se expande al nodo mas cercano (menor heurística) al objetivo
Entonces se forma una 3ra heurística que sea la suma donde se minimiza la heurística a costa (+) del costo real

$$f(n) = g(n) + h(n)$$
$f$: costo total estimado
$g$: costo real desde el inicio a la pos actual
$h$: costo estimado hacia el objetivo


> [!NOTE] Cuando la heurística es admisible?
> Esto significa que no se sobreestime el costo real desde n a un nodo objetivo
> 
> Si para cualquier $h(n)$ se cumple que: $h(n) \le h^*(n)$, donde $h^*(n)$ es el costo del menor camino desde n hasta el nodo objetivo
> 

## Approach



## Complexity

| Complete | Optimal                            | Spatial Complexity | Temporal Complexity |
| -------- | ---------------------------------- | ------------------ | ------------------- |
| si       | si (si la heuristica es admisible) | $O(b^d)$           | $O(b^d)$            |

$b$: factor de ramificación
$d$: profundidad de la solucion


## Code

