

[[1.memory-manager]]
[[2.memory-managment-schema]]
[[3.virtual-mem]]
[[4.page-replacement-algorithms]]


Preguntas:
- ¿Por qué es necesaria la memoria principal para la ejecución de los procesos?
- ¿Cómo se almacenan los programas dentro de la misma?
- [ ] calculo de la fragmentacion interna-externa
- 

**RAM**: words/bytes array. Each word/byte has its own direction
La memoria principal es generalmente el único dispositivo de almacenamiento que el CPU es capaz de direccionar y acceder directamente


**Directions Space**: El conjunto de direcciones propias e independiente que puede utilizar cada proceso para direccionar la memoria se conoce como: 

Las direcciones a memoria generadas por el proceso se conocen comúnmente como una dirección **lógica**, mientras que una dirección **fisica** se refiere a aquella que designa una posición real dentro de la memoria principal.


![[nibble|400]]


$$
\begin{align*}
	2^{10} &= kb \\
	2^{20} &= mb \\
	2^{30} &= gb \\
	2^{40} &= tb \\
\end{align*}
$$




> [!note] Que usan los SO actuales? 
> - UNIX utiliza una variante del **reloj**, 
> - Linux además de tener un esquema de **tabla de páginas** de varios niveles utiliza el **sistema camarada** para la asignación del espacio y para el reemplazo de páginas una **variante del reloj con el manejo de la antigüedad** de las páginas, 
> - Windows utiliza igualmente un esquema de memoria virtual con **paginación** y como algoritmo de reemplazo una variante del **LRU**.

> [!important] Los algoritmos más utilizados en la actualidad son LRU y las variantes del reloj


## Ejercicio 

Un sistema es capaz de trabajar en dos modos diferentes. 
1. “modo real”, solo maneja direcciones físicas de `14bit`. 
2. “modo protegido”, dónde emplea paginación, maneja direcciones virtuales de `24bit` y físicas de `16bit`.

**¿Cuánta memoria RAM puede manejar el sistema en cada modo?**

La cantidad de memoria RAM (física) estará limitada por la capacidad del hardware para emitir direcciones físicas (combinaciones eléctricas en el bus de direcciones). 
 
modo real: $2^{14}=2^4 * 2^{10} = 2^4 kbyte = 16K$ 
protegido: $2^{16}=2^6 * 2^{10} =64K$

**¿Qué tamaño máximo puede tener un proceso en cada modo?**

El tamaño de un proceso está limitado por la **cantidad de direcciones lógicas** que pueda emitir su código. Esto es, el espacio lógico de direcciones. 

*modo real*: el único espacio de direcciones es el físico, este indicará también el tamaño máximo de un proceso en dicho modo.  El tamaño máximo será también `16K`

*protegido*: $2^{24}=2^4 * 2^{20} = 2^4Mbyte = 16M$

**Si el sistema se configura en modo real para ejecutar procesos que realizan operaciones de E/S el 90% de su tiempo de ejecución y tienen un tamaño mínimo de 1K ¿Podría alcanzarse el 90% en el uso del CPU? ¿Por qué?**

El cálculo estadístico de uso del CPU se lleva acabo mediante $usoCPU = 1-p^n$ . En este caso se indica un requerimiento mínimo de 0.9 (90%) de ahí que:
$$
\begin{align*}
	0.9 &= 1 - 0.9^n \\
	0.1 &= 0.9^n \\
\end{align*}
$$
Ya que el porciento de bloqueos es también del 90%. Para determinar el valor de n (la cantidad de procesos necesarios) basta
$$
\begin{align*}
	log(0.1) &= nlog(0.9) \\\\
	n &= \frac{log(0.1)}{log(0.9)} \\\\
	n &= 21.7
\end{align*}
$$

De ahí que la cantidad de procesos con esas características que deben ejecutarse para alcanzar el uso indicado sea 22. 

Puesto que se habla del modo real, entonces el único espacio posible para código es exactamente el espacio de direcciones físicas, que consta de 16K Como cada proceso requiere un mínimo de 1K, el caso óptimo sería aquel en el que todos los procesos tuvieran ese tamaño, pero aún en esas condiciones, en la RAM solo hay espacio para 16 procesos. Como la cantidad de procesos en memoria es menor que la necesaria para el uso calculado, se puede afirmar que en las condiciones expuestas no será posible un uso del 90% del CPU

