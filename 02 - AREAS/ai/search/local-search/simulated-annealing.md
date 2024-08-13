# Simulated Annealing
#simulated-annealing #local-search

> El Enfriamiento o Recocido Simulado es un algoritmo de búsqueda por entornos con un criterio probabilístico de aceptación de soluciones basado en Termodinámica


![[Simulated Annealing.webm]]


## Problem

Se puede usar en el #traveling-salesman-problem. 
Busca aproximarse al máximo global de una función
Se usa cuando se quiere una solución optima a encontrar un optimo global y no tanto la solución exacta


## Intuition

El algoritmo #hill-climbing tenia el problema de quedarse en una solución local, una posible solución a esto es <u>permitirle al algoritmo moverse a posiciones peores</u> de manera controlada usando una **función de probabilidad**

La temperatura se decrementa lentamente desde un valor inicial positivo hasta 0
En cada paso, el algoritmo elije de forma random una solución cercana a la actual, mide su calidad y se mueve dependiendo de la probabilidad asociada a la temperatura

Entre mas espacio explore mas probable sera de llegar a la solución optima
Utiliza una heurística 
- cualquier método que genere una solución vecina de la actual
- puede ser cambiar un valor aleatorio de la solución actual o intercambiar 2, k-ops

![[simulated-annealing.excalidraw|700]]

## Approach

1. Se comienza con una solución aleatoria (para evitar quedar atrapado en un mínimo local)
2. hacer
	1. Se calcula una función objetivo de la solución inicial (esto permite al algoritmo evaluar la calidad de esa solución inicial)
	2. Genera una solución vecina
	3. Se calcula la función objetivo de la nueva solución
	4. Se decide si la nueva solución es mejor que la actual
		1. si lo es, entonces la acepta 
		2. si no, la acepta con una probabilidad dada por la temperatura
	5. Se reduce la temperatura
3. repetir hasta que la temperatura alcance un valor predefinido



## Complexity

| complete | optimal | space complexity | time complexity |
| :------: | :-----: | ---------------- | --------------- |
|    no    |   no    | $O(1)$           | -               |

## Code

