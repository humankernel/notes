
El desarrollo de programas modulares se basa en la posibilidad de ejecutar un bloque de código múltiples veces, con diferentes valores de un conjunto de variables denominadas “parámetros” que produce un resultado




la llamada a una subrutina se realiza mediante `CALL` cuyo único operando es la dirección de memoria, generalmente una etiqueta

Tras ejecutar esta instrucción el procesador continúa ejecutando la primera instrucción de la subrutina hasta que encuentra la instrucción RET que no tiene operandos

y transfiere la ejecución a la instrucción siguiente al CALL que inició el proceso

![[Pasted image 20230930211326.webp]]

La instrucción CALL tiene una funcionalidad similar a un salto incondicional, su único operando denota la siguiente instrucción a ejecutar. La instrucción RET no tiene operandos explícitos pero su efecto, el retorno a la siguiente instrucción tras la llamada, requiere la utilización de operandos implícitos

l procesador, además de modificar la secuencia, al ejecutar la instrucción CALL debe guardar la dirección de retorno en un lugar prefijado del cual será obtenido por la instrucción RET. Pero, durante la ejecución de un programa es preciso almacenar múltiples direcciones de retorno de forma simultánea



> [!Faq]- No es factible almacenar la direccion de retorno en registros generales
> Otra característica de las subrutinas es que su invocación se puede hacer de forma anidada, es decir, que desde una subrutina se invoca a otra y desde ésta a su vez a otra, hasta una profundidad arbitraria. El que las subrutinas se puedan invocar de forma anidada hace que la utilización de los registros de propósito general para almacenar la dirección de retorno no sea factible
> 
> La alternativa es almacenarlas en memoria, pero la instrucción RET debe tener acceso a su operando implícito siempre en el mismo lugar
> 
> Además, esta zona de memoria debe poder almacenar un número arbitrario de direcciones de retorno, pues la invocación de subrutinas se puede anidar hasta niveles arbitrarios de profundidad
> 
> La propiedad que tienen estas direcciones es que se almacenan por la instrucción CALL en un cierto orden, y son utilizadas por la instrucción RET en el orden inverso. (**PILA**)


La instrucción `CALL`, por tanto, realiza dos tareas: pasa a ejecutar la instrucción en la dirección dada como operando y almacena en la cima de la pila la dirección de la instrucción siguiente (al igual que lo haría una instrucción `PUSH`) que será la instrucción de retorno. Por su parte, la instrucción `RET` obtiene el dato de la cima de la pila (igual que lo haría la instrucción `POP`) y ejecuta un salto incondicional al lugar que indica. Ambas instrucciones, por tanto, modifican el contador de programa.


