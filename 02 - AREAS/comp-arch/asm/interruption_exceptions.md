
Una interrupcion es una operacion que suspende la ejecucion de un programa de modo que el sistema pueda realizar una accion especial



Por lo general resultan en una transferencia forzada de la ejecución del programa o tarea en ejecución, a una rutina de software especial o tarea, denominada controlador de interrupciones o controlador de excepciones. Con el uso de interrupciones, el procesador puede dedicarse a ejecutar otras instrucciones mientras una operación de E/S está en curso.


El microprocesador sólo atiende al dispositivo cuando este está listo. El dispositivo “avisa” al microprocesador cuando necesita ser atendido y este analiza si las condiciones lo permiten e interrumpe lo que está ejecutando para atender al dispositivo.



Cuando el procesamiento de la interrupción se completa, la ejecución prosigue. Así, el programa de usuario no tiene que incluir ningún código especial para posibilitar las interrupciones; el procesador y el sistema operativo son los responsables de detener el programa de usuario y después permitir que prosiga en el mismo punto. 

Para permitir el uso de interrupciones, se añade un ciclo de interrupción al ciclo de instrucción.

![[Pasted image 20230930203536.webp]]


En el ciclo de interrupción, el procesador comprueba si se ha generado alguna interrupción, indicada por la presencia una señal de interrupción. Si no hay señales de interrupción pendientes, el procesador continúa con el ciclo de captación y accede a la siguiente instrucción del programa en curso. Si hay alguna interrupción pendiente, el procesador hace lo siguiente:

1. Suspende la ejecución del programa en curso y guarda su contexto. Esto significa almacenar la dirección de la siguiente instrucción a ejecutar (contenido actual del contador de programa) y cualquier otro dato relacionado con la actividad en curso del procesador.
2. Carga el contador de programa con la dirección de comienzo de una rutina de gestión de interrupción.


A continuación el procesador prosigue con el ciclo de captación y accede a la primera instrucción del programa de gestión de interrupción que dará servicio a la interrupción
Generalmente el programa de gestión de interrupción forma parte del sistema operativo. Normalmente, este programa determina el origen de la interrupción y realiza todas las acciones que sean necesarias. Las interrupciones pueden ser provocadas por:

- Hardware: se producen de forma aleatoria durante la ejecución de un programa, en respuesta a las señales de hardware, para manejar eventos externos al procesador, así como para brindar atención a los dispositivos periféricos.
- Software: se pueden generar interrupciones, a través de la instrucción `INT` n.


![[Pasted image 20230930203851.webp]]


> [!Info] Interrupciones enmascarables
> Son aquellas que cuando se solicitan pueden ser atendidas o no; esto depende de que esté habilitada la `IT` enmascarable y que la `IT` sea la más prioritaria. Se solicitan por el terminal `INT` del `MP`.
> 
> La habilitación general de la `IT` se realiza por la bandera `IF`:
> - `IF=1`: Con la instrucción STI la interrupción queda habilitada
> - `IF=0`: Con la instrucción CLI la interrupción queda deshabilitada

> [!Info] Interrupcion no enmascarable
> Son aquellas que necesitan atención urgente. Son solicitadas por el terminal `NMI` (No mascarable interruption) del microprocesador.
> 
> Fuentes de `NMI` en la computadora:
> - Error de paridad durante la lectura en memoria DRAM en la tarjeta principal del sistema.
> - Error de paridad en la tarjeta de memoria o en cualquier tarjeta de expansión.
> - Generación de `NMI` a través del BIOS.

## Cuando ocurre una excepcion

Las excepciones ocurren cuando la CPU intenta ejecutar una instrucción incorrectamente construida, como divisiones por cero, etc. 
Las excepciones, al igual que las interrupciones, deben estar identificadas. Las instrucciones de un programa pueden estar mal construidas por diversas razones:

- El código de operación puede ser incorrecto.
- Se intenta realizar alguna operación no definida, como dividir por cero.
- La instrucción puede no estar permitida en el modo de ejecución actual.
- La dirección de algún operando puede ser incorrecta o se intenta violar alguno de sus permisos de uso.

> [!Faq]- Feailue
> Excepción que **puede corregirse** permitiendo al programa retomar la ejecución de esa instrucción sin perder continuidad. 
> El procesador guarda en la **pila** la dirección de la instrucción que produjo la falla.

>[!Faq]- Trap
>Excepción producida inmediatamente a continuación de una instrucción de trampa. 
>Algunas permiten al procesador retomar la ejecución sin perder continuidad. 
>El procesador guarda en la pila la dirección de la instrucción a ejecutarse luego de la instrucción trampa.

> [!Faq]- Abort
> Excepción que no siempre puede determinar la instrucción que la causó, ni permite recuperar la ejecución de la tarea que la causó. Reporta errores severos de hardware o inconsistencias en tablas del sistema.


Para ayudar en el manejo de excepciones e interrupciones, cada arquitectura define sus excepciones y a cada condición que requiera interrupción el procesador asigna un número de identificación

Los vectores del 0 al 31 están reservados para las interrupciones y excepciones definidas en la arquitectura. Los vectores del 32 al 255 están designados para las interrupciones definidas por los usuarios y para las de hardware. Generalmente a dispositivos de E/S externos.

El proceso de interrupción está asociado a la ejecución de un programa llamado subrutina de interrupción (ISR) que determina las acciones que se realizan para atender el dispositivo. El microprocesador debe obtener la dirección de la subrutina de interrupción y esta dirección se almacena en la tabla de vectores de interrupción (TVI). La TVI está ubicada en la dirección 0000:0000H y cada vector ocupa 4 bytes.

![[Pasted image 20230930204901.webp]]

Principales acciones:

1. Cuando un dispositivo solicita interrupción; al microprocesador le llega la información por la señal `INT`
2. Finaliza la ejecución de la instrucción en curso y se salva en la pila el estado actual del procesador.
3. Con el número del vector el microprocesador conforma la dirección para leer en la `TVI`, al realizar la lectura obtiene la dirección de la rutina de atención a la interrupción del dispositivo.
4. La ejecuta y cuando termina recupera el registro bandera y la dirección de retorno de la instrucción siguiente a la última que ejecutó cuando ocurrió la interrupción.

## ¿Qué diferencia hay entre las interrupciones y las excepciones?

Cuando la CPU intenta ejecutar una instrucción incorrectamente construida, la unidad de control lanza una excepción para permitir al sistema operativo ejecutar el tratamiento adecuado. 
Al contrario que en una interrupción, la instrucción en curso es abortada. El sistema operativo ocupa una posición intermedia entre los programas de aplicación y el hardware. No se limita a utilizar el hardware a petición de las aplicaciones ya que hay situaciones en las que es el hardware el que necesita que se ejecute código del SO. En tales situaciones el hardware debe poder llamar al sistema, pudiendo deberse estas llamadas a dos condiciones:

1. Algún dispositivo de E/S necesita atención.
2. Se ha producido una situación de error al intentar ejecutar una instrucción del programa (normalmente la aplicación).

En ambos casos, la acción realizada no está ordenada por el programa de aplicación, es decir, no figura en el programa. Según los dos casos anteriores, se tienen las interrupciones y las excepciones:

1. Interrupción: señal que envía un dispositivo de E/S a la CPU para indicar que la operación de la que estaba ocupado, ya ha terminado.
2. Excepción: una situación de error detectada por la CPU mientras ejecutaba una instrucción, que requiere tratamiento por parte del sistema operativo.

![[Pasted image 20230930205255.webp]]

Se puede afirmar entonces que tanto las interrupciones como las excepciones alteran el flujo del programa

**Las interrupciones**: son usadas para manejar eventos externos (puertos seriales, teclado) 
**Las excepciones**: son usadas para manejar errores en las instrucciones (división por cero, opcode indefinido)

Las interrupciones son manejadas por el procesador después de que finaliza la instrucción actual. Si se encuentra una señal en su pin de interrupción, buscará la dirección del manejador de interrupciones en la tabla de interrupciones y pasará el control de la rutina. Después de retornar de el manejador de rutina de interrupciones, retornará la ejecución del programa en la instrucción posterior a la instrucción interrumpida.