# Minimax
#adversal-search #ai

> El objetivo es decidir la mejor jugada en cada momento
> Usa una función de evaluación estática que evalúa la utilizad de cada nueva solución generada (generalmente es la suma de un puntaje menos la suma del puntaje ajeno)


[Algoritmo Minimax en 4 minutos (youtube.com)](https://www.youtube.com/watch?v=QJjM7EKDRuc)
Patrick Henry Winston, Inteligencia Artificial, 3ra edición, 1992. 
AI. A Modern Approach Russell Norvig 3rd ed. 2010. Capítulo 5. 
Elaine Rich & Kevin Knight, Inteligencia Artificial, 2da edición,1994. Capítulo 12. 
Rafael Bello, Métodos de solución de problemas,1998. Tema 10 y 11


> [!important] Requirements:
> - 2-player
> - turn-taking
> - perfect information
> - zero-sum (mientra mayor sea tu puntaje menor sera el del oponente)
>   
>   no juegos de azar


![[minimax-20240517212437557.webp|500]]


> [!faq]- ¿Será posible desarrollar el espacio de estado para estos tipos de problemas?
> 
> Ajedrez:
> Factor de ramificación promedio de 35
> En un juego promedio cada jugador realiza 50 movimientos
> 
> Para examinar el árbol del juego completo es necesario examinar $35^{100}$ posiciones



## Problem

Se quiere determinar la mejor jugada dado un estado. Para eso se necesita analizar todas las posibles jugadas 

## Intuition

Se usa una búsqueda DFS 
Se tienen 2 jugadores de los cuales uno quiere maximizar su puntaje a costa de minimizar el del jugador opuesto

Dado un estado de partida se escogerá la mejor jugada para eso se utilizara una <u>funcion de utilidad</u> que calcula un estimado de la utilidad de una posición desde el punto de vista de uno de los jugadores 
La calidad de esta influye en el resultado


**Función de evaluación estática:**
Una forma de construir la función de evaluación
$$f(S) = \sum_{i = 1}^n w_i f_i$$
$f_i$: la característica que se quiere analizar
$w_i$: los pesos


![[minimax-20240517214129187.webp|500]]


## Approach

$$
\begin{equation}
 \text{mini-max - value(n)} = 
  \begin{cases} 
   \text{utility(n)} & \text{si n es estado terminal}  \\
   max(x_{s \in \text{succesors(n)}}) \text{mini-max - value(s)} & \text{si n es nodo max} \\
   min(x_{s \in \text{succesors(n)}}) \text{mini-max - value(s)} & \text{si n es nodo  min} \\
  \end{cases}
\end{equation}
$$

si se llega a un nodo terminal se calcula la función de utilidad
si es un nodo max se busca el mayor de los hijos
si es un nodo min se busca el menor de los hijos


![[minimax.excalidraw|400]]


## Complexity

| operation |    O    |
| :-------: | :-----: |
|    --     | $O(--)$ |

## Code

