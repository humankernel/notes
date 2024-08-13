# Knapsack (Multiple Selection)

## Problem
Se define como un problema de la mochila con la adición de restricciones de múltiple selección disjuntas

Se tiene una mochila con capacidad limitada, y los objetos para ser almacenados en la mochila están clasificados en clases disjuntas. El problema consiste en seleccionar algunos elementos de las clases de tal forma que minimice el costo total, mientras que el peso total no sobrepase la capacidad de la mochila

## Intuition

puede ser representado de la siguiente forma:

$$
\begin{align}
min \sum_{i=1}^m \sum_{j=1}^{n_i} c_{ij}x_{ij} \\
s.t \sum_{i=1}^m \sum_{j=1}^{n_i} w_{ij}x_{ij} &\le W \\
\sum_{j=1}^{n_i} x_{ij} = 1 &\hspace{1cm} i=1,2...,m \\
x_{ij} \in \{0, 1\} &\hspace{1cm}
\end{align}
$$
donde i es el índice de la clase, j el índice del artículo dentro de cada clase, $n_i$ el número del total de elementos dentro de la clase i, $c_{ij}$ el costo del elemento j-ésimo en la clase i-ésima, m el número total de clases, $w_{ij}$ el peso del elemento j-ésimo en la clase i-ésima y W la capacidad máxima de la mochila.


## Approach


## Complexity

| operation |    O    |
| :-------: | :-----: |
|    --     | $O(--)$ |


## Code

