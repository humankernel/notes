# Microprocesor


> [!Info] Orden de Operaciones
> 1. Lectura de la instrucción desde la memoria principal
> 1. Decodificación de la instrucción, consiste en determinar qué instrucción es y qué se debe hacer  
> 1. Ejecución, lanzamiento de las máquinas de estado que llevan a cabo el procesamiento
> 1. Escritura de los resultados en la memoria principal o en los registros



Solo ejecuta instrucciones programadas en lenguaje de bajo nivel, realizando operaciones aritméticas y lógicas simples, tales como sumar, restar, multiplicar, dividir, las lógicas binarias y accesos a memoria.

Puede contener una o más unidades centrales de procesamiento (CPU) constituidas, esencialmente, 
1. registros
2. una unidad de control, 
3. una unidad aritmético lógica (ALU)
4. una unidad de cálculo en coma flotante 

con varios microprocesadores trabajando en paralelo, y un microprocesador puede, a su vez, estar constituido por varios núcleos físicos o lógicos

`núcleo físico`: porción interna del microprocesador casi-independiente que realiza todas las actividades de una CPU solitaria
`núcleo lógico`:  simulación de un núcleo físico a fin de repartir de manera más eficiente el procesamiento


![[Pasted image 20230930132201.webp]]

Unidad aritmético lógica (ALU) 
se compone principalmente de un circuito operacional, registros de entrada, un registro acumulador, un registro de estados y una unidad de control

La Unidad Aritmético Lógica (ALU por sus siglas en inglés) es la encargada de realizar los cálculos. Los datos sobre los que se realizan las operaciones se denominan operandos. Al elemento encargado de ejecutar las operaciones se le denomina operador, y está formado por una serie de circuitos electrónicos que son capaces de sumar dos números binarios o hacer las operaciones lógicas elementales: disyunción, conjunción y negación; incluso algunos operadores son también capaces de multiplicar, dividir y realizar otras operaciones más complejas. Para que el operador realice la operación, los operandos se llevan a la ALU y se guardan en unos registros denominados registros de trabajo. El resultado de la operación se guarda también en un registro antes de ser llevado a la memoria o a la Unidad de Entrada y Salida. Frecuentemente se utiliza un mismo registro para guardar uno de los operandos y, también, el resultado, denominado registro Acumulador. 
El operador, además de calcular el valor de la operación, modifica el registro de estado según el resultado de la operación. 
Así, si el resultado es un valor negativo, se modifica un bit de dicho registro, llamado bit negativo o bit N, poniéndose a 1; por el contrario, el bit N permanecerá en estado 0 mientras el contenido del acumulador no sea negativo. De igual forma indicara la ALU a la UC si el resultado ha sido cero, o si ha producido algún acarreo, etc.


Entre los elementos fundamentales para la selección y correcta explotación de un microprocesador se encuentran:

- Tecnología: Tecnología de fabricación (CISC, RISC, híbrido)
- Velocidad del reloj: Velocidad de proceso en Mhz (8 Mhz, 12 Mhz, 40 Mhz, 75 Mhz, etc.)
- Ancho de bus de datos interno: Longitud en bits de la palabra (4 bits, 8 bits, 16 bits, etc.)
- Tamaño de la tecnología de fabricación: (65nm ,45nm ,32nm, etc.)
- Memoria Caché: Es una memoria en la que se almacena una serie de datos para su rápido acceso. La memoria caché de un procesador es un tipo de memoria volátil (del tipo RAM), pero de una gran velocidad. Existen 3 tipos de memorias L1, L2 y L3.
- Cantidad de instrucciones: Cantidad de instrucciones que soporta.
- Sockets: Pueden agruparse en 3 grandes familias:
    - ZIF (Zero Insertion Force): Dotados de una palanca para fijar el procesador a la placa.
    - LIF (Low Insertion Force): Carecían de palanca, por lo que era necesario aplicar una fuerza para fijar el procesador a la placa.
    - De tipo Slot (Slot A / Slot 1 /Slot 2): Existieron durante una generación importante de PCs. Es donde se conectan respectivamente los primeros procesadores Athlon de AMD / los procesadores Pentium II y primeros Pentium III y los procesadores Xeon de Intel dedicados a servidores de red.

## CISC (Complex Instruction Set Computer)

CISC tienen un conjunto de instrucciones que se caracteriza por ser muy amplio y permitir operaciones complejas entre operandos situados en la memoria o en los registros internos.


Este tipo de arquitectura dificulta el paralelismo entre instrucciones, por lo que en la actualidad la mayoría de los sistemas CISC de alto rendimiento implementan un sistema que convierte dichas instrucciones complejas en varias instrucciones simples, llamadas generalmente microinstrucciones

La microprogramación significa que cada instrucción de máquina es interpretada por un microprograma localizado en una memoria en el circuito integrado del procesador

Las instrucciones compuestas son decodificadas internamente y ejecutadas con una serie de microinstrucciones almacenadas en una ROM interna

Para esto se requieren de varios ciclos de reloj, al menos uno por microinstrucción


Cuando el sistema operativo o una aplicación requiere de una de estas acciones, envía al procesador el nombre del comando para realizarla junto con el resto de información complementaria que se necesite. Pero cada uno de estos comandos de la ROM del CISC varían de tamaño y, por lo tanto, el chip debe en primer lugar verificar cuanto espacio requiere el comando para ejecutarse y poder así reservárselo en la memoria interna

Para realizar una sola instrucción un chip CISC requiere de cuatro a diez ciclos de reloj


Entre las bondades de CISC destacan las siguientes:
- Reduce la dificultad de crear compiladores.
- Permite reducir el costo total del sistema.
- Reduce los costos de creación de software.
- Mejora la compactación de código.
- Facilita la depuración de errores.

## RISC 

Buscando aumentar la velocidad del procesamiento se descubrió en base a experimentos que, con una determinada arquitectura de base, la ejecución de programas compilados directamente con microinstrucciones y residentes en memoria externa al circuito integrado resultaban ser más eficientes gracias a que el tiempo de acceso de las memorias se fue decrementando conforme se mejoraba su tecnología de encapsulado


La arquitectura RISC funciona de modo muy diferente a la CISC, su objetivo no es ahorrar esfuerzos externos por parte del software con sus accesos a la RAM, sino facilitar que las instrucciones sean ejecutadas lo más rápidamente posible

La forma de conseguirlo es simplificando el tipo de instrucciones que ejecuta el procesador

Sin embargo, este diseño requiere de mucha más RAM y de una tecnología de compilador más avanzada.

Por ello, los procesadores RISC no solo tienden a ofrecer una capacidad de procesamiento del sistema de 2 a 4 veces mayor, sino que los saltos de capacidad que se producen de generación en generación son mucho mayores que en los CISC.

El procesador RISC puede además ejecutar hasta 10 comandos a la vez pues el compilador del software es el que determina qué comandos son independientes y por ello es posible ejecutar varios a la vez. Y al ser los comandos del RISC más sencillos, la circuitería por la que pasan también es más sencilla

Para ejecutar una sola instrucción normalmente les basta con un ciclo de reloj



Entre las ventajas de RISC tenemos las siguientes:
- La CPU trabaja más rápido al utilizar menos ciclos de reloj para ejecutar instrucciones.
- Utiliza un sistema de direcciones no destructivas en RAM. Eso significa que, a diferencia de CISC, RISC conserva después de realizar sus operaciones en memoria los dos operandos y su resultado, reduciendo la ejecución de nuevas operaciones.
- Cada instrucción puede ser ejecutada en un solo ciclo del CPU


## Combinación de las instrucciones (híbridos)

Las CPU modernas de Intel y AMD se basan en una combinación de instrucciones CISC y RISC:

Estos procesadores traducen las CISC a operaciones sencillas de longitud fija que se ejecutan en un núcleo de estilo RISC

## Ciclo de instruccion
#register #register-pc

![[Pasted image 20230930140016.webp]]


Al comienzo de cada ciclo de instrucción 
1. La CPU capta una instrucción de memoria: se utiliza un registro llamado contador de programa (Program Counter: **PC**) para seguir la pista de la instrucción que debe captase a continuación

2. incrementa el PC: A no ser que se indique otra cosa, de forma que captará la siguiente instrucción de la secuencia (es decir, la instrucción situada en la siguiente dirección de memoria).


Ej: Una computadora en la que cada instrucción ocupa una palabra de memoria de 16 bits

Se supone que el contador de programa almacena el valor 300

1. La CPU captará la próxima instrucción almacenada en la posición 300
2. En los siguientes ciclos de instrucción, captará las instrucciones almacenadas en las posiciones 301, 302, 303, y así sucesivamente
3. La instrucción captada se almacena en un registro de la CPU conocido como registro de instrucción (Instruction Register: IR)
4. La instrucción se escribe utilizando un código binario que especifica la acción que debe realizar la CPU
5. La CPU interpreta la instrucción y lleva a cabo la acción requerida, la cual puede ser de 4 tipos:
	- `Procesador-Memoria`: deben transferirse datos desde la CPU a la memoria, desde la memoria a la CPU.
	- `Procesador-E/S`: deben transferirse datos a o desde el exterior mediante transferencias entre la CPU y un módulo de E/S.
	- `Procesamiento de Datos`: la CPU ha de realizar alguna operación aritmética lógica con los datos.
	- `Control`: una instrucción puede especificar que la secuencia de ejecución se altere.

La ejecución de una instrucción puede implicar una combinación de estas acciones:

![[Pasted image 20230930140837.webp]]



> [!INFO] Calcular el tiempo que toma un ciclo de instruccion
> $\text{cycles time} = \text{(amount of cycles per captation)} + \text{(amount of cycles per execution)}$
> $\text{cycle time} = \frac{1}{\text{cpu frequency}}$
> $\text{amount of the instruction cycle} = \text{(cycles time)} * \text{(cycle time)}$
> 
> 


> [!Ejemplo]- Ejemplo Calculo de Ciclos
> Un procesador incluye una instruccion capaz de multiplicar dos numeros de 1 byte. 
> La captacion y la decodificacién inicial de la instruccion tarda 5 ciclos de reloj, la lectura de ambos operandos tarda 7 ciclos de reloj y la ejecucion de la operacion 12 ciclos de reloj. 
> El procesador funciona a una frecuencia de 1,2 GHz. demora el ciclo de instruccion?
> 
> Cantidad de ciclos empleados en el ciclo de captacion = 5
> Cantidad de ciclos empleados en el ciclo de ejecucion = 19 (7 en la lectura de operandos + 12 en la ejecucion de la operacion)
> Frecuencia del procesador = 1.2 GHz
> 
> $$\text{cycles time} = 5 + 19 = 24$$
> $$\text{cycle time} = \frac{1}{1.2 \text{ GHz}} = \frac{1}{1.2 * 10^9 \text{ Hz}} = \frac{1}{1.2} * 10^{-9} s$$
> $$\text{amount of the instruction cycle} = 24 * \frac{1}{1.2} * 10^{-9}s = 20 * 10^{-9}s = 20 \text{ns}$$

> [!Ejemplo]- Ejemplo Calculo de frecuencia
> La fórmula general es:
> $$\text{Tiempo de ejecución} = \frac{\text{Número de ciclos}}{\text{Frecuencia del procesador}}$$
> 
> Para la computadora X, tenemos:
> $$10 \text{ ns} = \frac{\text{Número de ciclos}}{1 \text{ GHz}}$$
> 
> Por lo tanto, el número de ciclos para X es 10.
> 
> Para la computadora Y, queremos que el tiempo de ejecución sea de 2 ns y que utilice 0.5 veces los ciclos de reloj que X. Por lo tanto, el número de ciclos para Y es 0.5 * 10 = 5.
> 
> Sustituyendo estos valores en la fórmula, obtenemos:
> $$2 \text{ ns} = \frac{5}{\text{Frecuencia de Y}}$$
> 
> Resolviendo para la Frecuencia de Y, obtenemos:
> 
> $$\text{Frecuencia de Y} = \frac{5}{2 \text{ ns}} = 2.5 \text{ GHz}$$
> Por lo tanto, la frecuencia objetivo para la computadora Y debería ser 2.5 GHz.
