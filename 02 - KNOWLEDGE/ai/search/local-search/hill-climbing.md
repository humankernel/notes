# Hill Climbing
#local-search #hill-climbing
>Es un ciclo que se mueve en la dirección de máximo ascenso o descenso, en dependencia de si se esté maximizando o minimizando la función objetivo
>
>Es una variación de #dfs en la cual se usa la función heurística para estimar la distancia entre el nodo actual y el nodo objetivo


> [!question] Diferencia con Best First
> Hill Climbing no hace rollback

## Problem

![[hill-climbing-20240512130757084.webp]]

## Intuition

Con este método la estrategia es repetidamente expandir un nodo, inspeccionar sus sucesores recién generados, y seleccionar y expandir el mejor entre los sucesores <u>sin mantener referencias a los padres</u>


> [!fail] Consideraciones
> Es usado cuando existe una buena función heurística
> **irrevocable**: Cuando se llega a un nodo muerto no hay forma de hacer retroceso (salvo generar otro nodo raíz)


## ❌ Fail Conditions

Un **máximo local**: es un estado que es mejor que todos sus vecinos pero no es mejor que algunos otros estados más lejanos

![[hill-climbing-20240512133126151.webp]]


En una **meseta** no es posible determinar la mejor dirección para movernos haciendo comparaciones locales

![[hill-climbing-20240512133202326.webp]]


Una **cresta** es un área del espacio de búsqueda que es más alta que áreas colindantes pero no puede atravesarse mediante movimientos elementales en cualquier dirección


![[hill-climbing-20240512133336293.webp]]


## Approach

1. Formar una pila de un elemento consistente del nodo raíz
2. Iterar de (a) a (c) hasta que la pila este vacía
	1. Chequear si el elemento del top de la pila es una solución
	2. SALIR con ÉXITO si el elemento chequeado es solución.
	3. Si el primer elemento no es solución ordenar los descendientes del mismo según la distancia restante al objetivo y luego añadir el hijo al top de pila.
3. Salir con Falla


## Complexity

| complete | optimal | spatial complexity | temporal complexity |
| :------: | :-----: | ------------------ | ------------------- |
|    no    |   no    | $O(b)$             | $O(\infty)$         |
* Es óptimo si la heurística es admisible.

## Code


