> representación del conocimiento
> razonamiento
> tratamiento de la incertidumbre 
> aprendizaje


- Elaine Rich y Kevin Knight, Inteligencia Artificial
- Stuart J. Russell and Peter Norvig, Artificial Intelligence A Modern Approach. Capítulos 1, 2, 3 y 4


> [!note] Agent:
> Los agentes resolventes-problemas deciden qué hacer para encontrar secuencias de acciones que conduzcan a los estados deseables.
> ![[Untitled-20240502163613794.webp]]


## Search Problems

Para encontrar soluciones a un problema formulado en forma de estados y transiciones entre ellos
Busca un camino entre el estado inicial y el estado deseado


**initial state**: $S=(S_0, S_1)$

**actions**:  `ACTIONS(S) -> [S]`
- conjunto de acciones disponibles 
- puede verse como una función sucesor $S$
- dado un estado $x$, $S(x)$ retorna el conjunto de estados alcanzables desde x mediante una accion simple

**transition model**: `RESULT(s, a) -> s1`
- descripción de a que estado se llego después de ejecutar una accion disponible a otro estado
 ![[ai-20240504132811388.webp|400]]

**state space**:
	- conjunto de todos los posibles estados accesibles desde el estado inicial después de aplicar cualquier secuencia de acciones
	- ![[ai-20240504133052824.webp|400]]

**goal test / Criterio Objetivo**:
- define un criterio para saber si un estado es el final

**path cost / Función Costo**:
- determina el costo de la solución
 ![[ai-20240504133446069.webp|400]]


**heuristic function**:
- función que define cuan lejano/cercano se encuentra de la solución deseada
[Usar heurísticas (artículo) | Algoritmos | Khan Academy](https://es.khanacademy.org/computing/ap-computer-science-principles/algorithms-101/solving-hard-problems/a/using-heuristics)
- si existen varias heurísticas admisibles, entonces se forma una nueva que sera $h(n) = max(h_1(n), h_2(n), ...)$

**node**: 
- keeps track of:
- a state
- a parent 
- an action (action applied to parent to get node)
- a path cost (from initial state to node)



> [!example]- 2 Vacijas
> Estados:
> $S = [S_0, S_1]$
> 
> Estado inicial: $S = [0, 0]$
> Estado final: $S = [4, 0]$
> Acciones: $f: S_i \to [S_j, ...]$
> $$
> \begin{align}
> [S_0, S_1] &\to [5, S_1] \\
>            &\to [S_0, 3] \\
>            &\to [0, S_1] \\
>            &\to [S_0, 0] \\
> \end{align}
> $$
> Heuristica: $h(s) = [4 - S_0]$

## Approach

1. Start with a frontier that contains the initial state.
2. Start with an empty explored set
3. Repeat:
	1. if the frontier is empty, then no solution
	2. **remove a node from the frontier** 
	3. if node contains goal state, return the solution
	4. add node to the explored set
	5. expand node, add resulting nodes to the frontier (if they aren't already in the frontier or the explored set) 

## Search Algorithms

### A ciegas 
(no heurística): no existe información para decidir que nodo expandir
- [[bfs]]
- [[dfs]]

### Caminos
- [[best-first]] (necesito conocer la heurística)
- *[[a-star]] (usa costos)
- [[recursive breadth first search]]

[[local-search]]

### Adversarios
entornos competitivos. Los objetivos están en conflicto entre 2 o mas adversarios
- [[minimax]]

### Poblacionales
multiples agentes buscando la solución

- *[[genetic-algorithms]]
- [[swarm-intelligence]]


