Ensamblador trabaja con registros del procesador para controlar las instrucciones a realizar y manejar los espacios de memoria

![[cpu.gif]]

- **AX** - the accumulator register (divided into **AH / AL**).
- **BX** - the base address register (divided into **BH / BL**).
- **CX** - the count register (divided into **CH / CL**).
- **DX** - the data register (divided into **DH / DL**).
- **SI** - source index register.
- **DI** - destination index register.
- **BP** - base pointer.
- **SP** - stack pointer.


## General Proprose Registers

> [!Info]- Los registros de propósito general en un procesador x86
> - `eax`
> - `esp`
> - `ebp`
> - `ebx`
> - `ah`
> - `al`
>   
>   [Por favor, ten en cuenta que “eax”, “esp”, “ebp”, “ebx” son registros de 32 bits, mientras que “ah” y “al” son partes de 8 bits del registro "ax"](https://en.wikibooks.org/wiki/X86_Assembly/X86_Architecture)[1](https://en.wikibooks.org/wiki/X86_Assembly/X86_Architecture). Los otros elementos en tu lista no son registros de propósito general en un procesador x86.

Para el manejo de datos se emplean otros segmentos de memoria

`AX`= **00110000-00111001b**, then 
`AH`=**00110000b** 
`AL`=**00111001b**.

Therefore, when you modify any of the 8 bit registers 16 bit register is also updated, and vice-versa.

![[Pasted image 20230930155641.webp]]

> [!Info]- (AX) Acumulator - (aritmetica, E/S)
> Utilizado para operaciones que implican **entrada/salida** y la mayor parte de la **aritmética**. 
> Por ejemplo, las instrucciones para 
> - multiplicar, 
> - dividir 
> - traducir 
> 
> También, algunas operaciones generan código más eficiente si se refieren al AX en lugar de a los otros registros.

> [!Info]- (BX) Base - (used for indexed direction)
> El único registro de propósito general que puede ser índice para direccionamiento indexado. 
> También es común emplear el BX para cálculos

> [!Info]- (CX) Counter - (i of for)
> Se emplea normalmente como un contador para controlar ciclos (como el i del ciclo for).

> [!Info]- (DX) Data - Register
> Algunas operaciones de **entrada/salida** requieren su uso, y las operaciones de **multiplicación** y **división** con cifras grandes implican al DX y al AX trabajando juntos.



## Segment Registers

> [!Faq] 
> Although it is possible to store any data in the segment registers, this is never a good idea. The segment registers have a very special purpose - pointing at accessible blocks of memory



> [!Info]- (`CS`) Code Segment - (points at the segment containing the current program) 
> Para la ejecución de código, se emplea el registro de código `CS`. Este más el apuntador de instrucción `IP`, se mueve por todo el registro, ejecutando las instrucciones que correspondan.

> [!Info]- (`DS`) Data Segment - (generally points at segment where variables are defined)
> No es posible hacer como en los lenguajes de alto nivel mandando a llamar la función de mostrar y asignándole directamente el mensaje; debe de manejarse por una variable.
> 
> En el segmento de datos se declaran e inicializan las variables a utilizar
> El registro de datos DS almacena el comienzo del segmento de datos
> 
> Si se quiere acceder a una variable en especial, deberá hacer referencia este segmento (el cual dice “aquí empieza”) y también cuánto deberá moverse para llegar a dicha variable
> 
> Eso es similar a cuando una persona busca una palabra en el diccionario: Primero se posiciona al principio de la página, luego recorre la hoja hasta llegar a la palabra que está buscando.

> [!Info]- (`SS`) Stack Segment - (points at the segment containing the stack)
> LIFO. 
> Un programa puede no necesitar segmento de pila, pero es útil para ciertas operaciones, en especial aquellas que manejan cadenas de caracteres. 
> 
> El registro SS permite la colocación en memoria de una pila. 
> 
> La dirección de inicio del segmento de pila se almacena en SS. Esta, más un valor de desplazamiento del apuntador de la pila **SP** indican el dato actual que se encuentra disponible en la pila.

> [!Info]- (`ES`) Extra Segment
> 
> Por cuestiones de memoria, habrá ocasiones en las que será necesario utilizar un segmento extra
> Su registro correspondiente es el ES. Por otra parte, en los procesadores 80386 existen registros extra como los FS y GS.

Las instrucciones y variables se manejan por medio de segmentos
Esto es debido a que en la arquitectura de los procesadores x86 el mayor número de palabra que se podía manejar era de 16 bits de memoria

Cada segmento proporciona un espacio de memoria para direccionamiento

En pocas palabras, en cada segmento se maneja una parte del programa y ensamblador manipula el contenido de dichos segmentos mediante los registros de segmento los cuales sirven como puerta de entrada

## Pointers Registers

Cuando necesitamos apuntar a una dirección de memoria específica debemos utilizar los Registros Apuntadores:

> [!Info]- (SP) Stack Pointer
> `16 bits` está asociado con el registro **SS** y proporciona un valor de desplazamiento que se refiere a la palabra actual que está siendo procesada en la pila. Los procesadores 80386 y posteriores tienen un apuntador de pila de 32 bits, el registro ESP. El sistema maneja de forma automática estos registros.

> [!Info]- (BP) - 
> `16 bits` facilita la referencia de parámetros, los cuales son datos y direcciones transmitidos vía pila. Los procesadores 80386 y posteriores tienen un BP ampliado de 32 bits llamado el registro EBP.

> [!Info]- (IP) Instruction Pointer - (apunta a la instruccion en curso)
> 
> **IP** register always works together with **CS** segment register and it points to currently executing instruction


## Index Registers

- Direccionamiento indexado
- sumas 
- restas
- operaciones de cadenas de datos.

> [!Info]- (SI) Source Index
> Proporciona la dirección inicial para que una cadena sea manipulada. 
> 
> Los procesadores 80386 y posteriores permiten el uso de un registro ampliado de 32 bits, el ESI.

> [!Info]- (DI) Destination Index
> Proporciona la dirección de destino donde por lo general una cadena será almacenada después de alguna operación de transferencia. 
>   
>  Los procesadores 80386 y posteriores permiten el uso de un registro ampliado de 32 bits, el EDI.


## Flags Registers

The Current state of the microprocessor

**Flags register** is modified automatically by CPU after mathematical operations

Generally you cannot access these registers directly, the way you can access AX and other general registers, but it is possible to change values of system registers using some tricks

> [!Info]- (OF) Overflow Flag - (se paso del tamano)
> Indica desbordamiento de un bit de orden alto (más a la izquierda) después de una operación aritmética.

> [!Info]- (DF) Direction Flag - (izq o der del desplazamiento)
> Designa la dirección hacia la izquierda o hacia la derecha para mover o comparar cadenas de caracteres.

> [!Info]- (IF) Interruption Flag - (ej: ctrl-c interrumple)
> Indica que una interrupción externa, como la entrada desde el teclado, sea procesada o ignorada.

> [!Info]- (TF) Trap Flag - (debug)
> Permite la operación del procesador en modo de un paso. Los programas depuradores, como el DEBUG, activan esta bandera de manera que usted pueda avanzar en la ejecución de una sola instrucción a un tiempo, para examinar el efecto de esa instrucción sobre los registros de memoria.

> [!Info]- (SF) Sign Flag - (0: `+`, 1: `-`)
> Contiene el signo resultante de una operación aritmética 
> `0`: positivo
> `1`: negativo

> [!Info]- (ZF) Zero Flag - (cmp returns 0)
> Indica el resultado de una operación aritmética o de comparación
> `0`: resultado diferente de cero
> `1`: resultado igual a cero

> [!Info]- (AF) Auxiliar Carry Flag
> Contiene un acarreo externo del bit 3 en un dato de 8 bits para aritmética especializada.

> [!Info]- (PF) Parity Flag - (`x % 2`)
> Indica paridad par o impar de una operación en datos de 8 bits de bajo orden (más a la derecha).

> [!Info]- (CF) Carry Flag
> Contiene el acarreo de orden más alto (más a la izquierda) después de una operación aritmética
> También lleva el contenido del último bit en una operación de corrimiento o de rotación.





