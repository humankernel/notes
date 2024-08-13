# Knapsack 01

## Problem
Definición del problema de la mochila: 

Supongamos que queremos llenar una mochila seleccionando elementos de un conjunto de $n$ objetos, de los cuales cada uno tiene un peso $w_i$ y un costo $c_i$. 

La capacidad máxima de la mochila es de un peso $W$. 

El problema consiste en llenar la mochila con un subconjunto óptimo de los objetos de tal forma que se minimice el costo total y no se sobrepase la capacidad de la mochila

## Intuition

Sean $x_j$ variables binarias tales que: $x_j = 1$ si el elemento j es seleccionado 0 si no

Luego el problema de la mochila puede ser representado de la siguiente forma:

$$
\begin{align}
min \sum_{j=1}^n c_jx_j \\
s.t \sum_{j=1}^nw_ix_j &\le W \\
x_j = \{0, 1\} &\hspace{1cm} j= 1,2,...,n
\end{align}
$$
Este problema es conocido como el problema de la mochila $0-1$, pura programación entera con una sola restricción, que deviene en una clase muy importante de programación entera. 

Hay muchas variaciones del problema de la mochila tales como de 
- selección múltiple
- acotado
- no acotado 
- de múltiples restricciones.


## Approach


## Complexity

| operation |    O    |
| :-------: | :-----: |
|    --     | $O(--)$ |


## Code

