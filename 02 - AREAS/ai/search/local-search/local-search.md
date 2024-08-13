# Local Search
#local-search

- *[[hill-climbing]]
- *[[simulated-annealing]]
- [[local-beam-search]]
- [[tabu-search]]

El término LOCAL se utiliza frecuentemente en los estudios teóricos y prácticos de las metaheurísticas de búsqueda. Se asocia al uso de estructuras de entorno, reflejando el concepto de proximidad o vecindad entre las soluciones alternativas del problema. Todas las soluciones incluidas en el entorno de la solución actual, que viene delimitado por un operador de generación de soluciones, se denominan soluciones vecinas.

Así, los algoritmos basados en esta estrategia efectúan un estudio local del espacio de búsqueda, puesto que analizan el entorno de la solución actual para decidir cómo continuar el recorrido de la búsqueda.

![[ai-20240512122527264.webp]]

Una búsqueda local es un proceso que, dada la solución actual en la que se encuentra el recorrido, selecciona iterativamente una solución de su entorno para continuar la búsqueda.



## Estructura de Entorno
Basta con diseñar la estructura de entorno para obtener un modelo genérico de algoritmo de búsqueda

Descripción 
- Se fija una codificación para las soluciones. 
- Se define un operador de generación de vecino y, en consecuencia, se fija una estructura de entorno para las mismas. 
- Se escoge una solución del entorno de la solución actual hasta que se satisfaga el criterio de parada.

Elementos básicos: 
- Proceso de elección de la solución inicial. 
- Proceso de selección de solución/generación de una solución vecina:
$$S \to S', S' \in E(S)$$
- Proceso de aceptación de solución vecina como solución actual.

![[local-search-20240512125515657.webp]]