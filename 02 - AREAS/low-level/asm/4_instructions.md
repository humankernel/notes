
- transferencia
- Lógicas
- Aritméticas
- comparación
- Condicionales
- Control de ciclo
- Desplazamiento y rotación
- Control del sistema

## Transferencia

> [!Info]- (`MOV`) - Instruction
> Esta instrucción permite mover datos entre registros o direcciones de memoria
> 
> - `source`: immediate value, general-purpose register or memory location.  
> - `destination`: ,general-purpose register, or memory location
> - both must be the same size
>   
> ```nasm
> MOV destination, source
> 
> ORG 100h           ; this directive required for a simple 1 segment .com program.
> MOV AX, 0B800h     ; set AX to hexadecimal value of B800h. 
> MOV DS, AX         ; copy value of AX to DS. 
> MOV CL, 'A'        ; set CL to ASCII code of 'A', it is 41h. 
> MOV CH, 1101_1111b ; set CH to binary value. 
> MOV BX, 15Eh       ; set BX to 15Eh. 
> MOV [BX], CX       ; copy contents of CX to memory at B800:015E 
> RET                ; returns to operating system. 
> ```

> [!Info]- (PUSH, POP) Stack Instruction
> Existen ocasiones en las que es necesario almacenar datos de manera temporal para que éstos no se vean afectados por otras operaciones
> 
> ```nasm
> PUSH origen
> PUSH AX
> PUSH 'hola'
> 
> POP destino
> ```

> [!Info]- (`XCHG`) Intercambia valores
> ```nasm
> // cambia valores entre operandos
> XCHG operando1, operando2
> ```

## Logicas

> [!Info]- (`AND`) - $\frac{\frac{1011}{1001}}{1001}$ - (multiplicacion)
> Esta instrucción se utiliza para la puesta a 0 lógico de bits seleccionados de un operando, así como un paso previo para la evaluación de bits individuales de un operando. 
> Realiza la operación lógica bit a bit entre los del operando destino y los del origen (usado como máscara), quedando el resultado en el operando destino.
> 
> `AND`: Se aplica el destino AND fuente y se almacena en destino
> ```nasm
> AND destino, fuente
> ```

> [!Info]- (`OR`) - $\frac{\frac{1011}{1001}}{1011}$ - (Suma)
> 
> ```nasm
> OR destino, fuente
> ```

> [!Info]- (`XOR`) - (Suma Logica Exclusiva)
> `XOR`: suma logica exclusiva, inversion logica de bits
> ```nasm
> XOR destino, fuente
> ```

> [!Info]- (`NOT`) - Negacion
> `NOT`: negacion
> ```nasm
> NOT operando
> ```

> [!Info]- (`TEST`) - Evaluacion - (usa un `and`)
> `TEST`: Permite la evaluación de bits individuales de un operando, pero sin que este se vea afectado
> El resultado no se almacena en los operandos, pero queda reflejado en el registro de estado
> ```nasm
> TEST destino, fuente
> ```


## Aritmeticas

Llevan a cabo las operaciones aritméticas básicas: 
- Suma, 
- Resta, 
- Multiplicación 
- División.

> [!Info]- (`ADD`) - Adition
> Esta instrucción nos permite sumar dos operandos guardándose el resultado en el primero, o lo que es lo mismo:
> 
> ```nasm
> MOV AX 3
> ADD AX, 2
> ```
> 
> Equal to 
> ```c
> int acumulator = 3;
> acumulator += 2;
> ```

> [!Info]- (`SUB`) - Substraction
> Esta instrucción nos permite restar dos operandos guardándose el resultado en el primero, o lo que es lo mismo:
> ```nasm
> MOV AX, 3
> SUB AX, 2
> ```

> [!Info]- (`MUL`) - Multiplication
> Esta instrucción nos permite multiplicar un operando por el valor que tengamos almacenado en `AL` guardándose el resultado en `AX`, o lo que es lo mismo:
> $\text{AX} = \text{AL} * \text{operando}$
> 
> ```nasm
> MOV AL, 3
> MUL 2
> ```

> [!Info]- (`DIV`) - Division
> Esta instrucción nos permite realizar la división entera del valor que tengamos almacenado en `AX` entre un operando guardándose el resultado en `AL` y el resto de la división en `AH`, o lo que es lo mismo:
> 
> $\text{AL} = \text{AX} / operando$
> $\text{AH} = \text{resto de division}$
> 
> Este operando puede ser una variable u otro registro de 8 bits. Para realizar la división con valores superiores a los 8 bits la operación se representa de la siguiente forma:
> 
> $\text{AX} = \text{AX} / operando$
> $\text{DX} = \text{resto de division}$
> 
> ```nasm
> MOV AX, 9
> DIV 2
> 
> ;AL = 4
> ;AH = 1
> ```


## Incrementar / Decrementar

```c
for (int i=0; i<n; i++)
```

Como aún no sabemos declarar variables utilizaremos el registro contador CX.

```nasm
MOV CX, 0  ;int i=0
		   ;i<n
		   
ADD CX, 1  ;i++
INC CX     ;mismo que arriba
```


> [!Info]- (INC) Increment
> ```nasm
> INC CX
> ```
> 
> Lo mismo que 
> 
> ```nasm
> ADD CX, 1
> ```

> [!Info]- (DEC) Decrement
> 
> ```nasm
> DEC CX
> ```
> 
> Lo mismo que
> 
> ```nasm
> SUB CX, 1
> ```


## Comparacion 

Las instrucciones de comparación son instrucciones de resta aritmética, aunque el **resultado se pierde** quedando inafectado el operando destino. 

> [!Info]- (`CMP`) Compare
> En vez de usar la sentencia if-else de los lenguajes de alto nivel, se emplea una comparación y luego un salto según el resultado de dicha comparación.
> 
> ```nasm
> CMP operando1, operando2
> ```
> Lo que realmente sucede al ejecutarse esta instrucción es que se restan los dos operandos y el resultado se almacena en las banderas del registro de estado:
> $\text{operando1} - \text{operando2}$
> 
> Inmediatamente después de una operación de comparación debe incluirse una instrucción de salto


## Saltos Condicionales

Los saltos (equivalente en ensamblador del comando `else`) son muy variados, siendo los más comunes el 
- `JMP` (salto incondicional)
- `JE`:	Igual
- `JNE`: Distinto
- `JZ`:	Cero
- `JNZ`: No es Cero
- `JA`: Mayor
- `JNBE`: ""
- `JAE`: Mayor o igual
- `JNB`: ""
- `JB`: Menor
- `JNAE`: ""
- `JBE`: Menor o igual
- `JNA`

Lo que hacen es ir de la línea de código en la que se encuentran a otra, ejecutando un conjunto de instrucciones específicas.


```nasm
JUMP_INST direccion
```

La dirección puede expresarse a través de cualquiera de los modos de direccionamiento o como una **etiqueta** dentro del programa, siendo esta última la forma más utilizada.

> [!Info] c's for TO assembly
> 
> ```c
> for (int i=0; i<n; i++)
> ```
> To Assembly
> ```nasm
> 	MOV CX, 0   ;int i=0
> 	MOV AX, 5   ;int n=5
> 
> et_ciclo:
> 	CMP CX, AX   ;comparamos cx: i con ax: 5  (i - 5)
> 	JE et_fin          ;si son iguales saltamos a la etiqueta et_fin para terminar
> 	INC CX            ;i++
> 	JMP et_ciclo    ;saltamos a la etiqueta et_ciclo
> 	
> et_fin:
> ```


## Control de Ciclo

Ya conocemos que a través de los saltos podemos crear y controlar un ciclo, sin embargo, estas no son las únicas instrucciones que nos permitirán trabajar con ellos.

> [!Info]- (LOOP)
> 
> LOOP va a usar el registro CX y lo decrementa automaticamente, evitando así ciclos infinitos
> Esta instrucción indica que un grupo de instrucciones se va a repetir mientras que CX sea distinto de 0, y en cada repetición CX se decrementará.
> 
> ```nasm
> LOOP direccion
> ```
> 
> La dirección puede expresarse a través de cualquiera de los modos de direccionamiento o como una etiqueta dentro del programa
> 
> 
> Supongamos que deseamos repetir 20 veces la instrucción `ADD AX, 2` Resulta bastante tedioso escribir a mano cada una de las instrucciones, sin embargo, podemos usar saltos o utilizar la instrucción `LOOP`:
> 
> ```nasm
> 	MOV CX, 20
> et_ciclo: 
> 	ADD AX, 2
> 	LOOP et_ciclo
> ```
> 
> Usando saltos seria 
> 
> ```nasm
>	MOV CX, 20
>et_ciclo: 
>	CMP CX, 0
>	JE et_fin
>	ADD AX, 2
>	DEC CX
>	JMP et_ciclo	
> et_fin:
> ```


## Desplazamiento y Rotacion

Las instrucciones de desplazamiento son parte de la capacidad lógica de la computadora, pueden realizar las siguientes acciones:

1. Hacer referencia a un registro o dirección de memoria.
2. Recorre bits a la izquierda o a la derecha.
3. Desplazamiento lógico o aritmético.
   
En este tipo de instrucciones debemos tener en cuenta el sentido de la rotación o desplazamiento.


> [!Info]- (SHR - SHL) Slide 
> Las instrucciones de desplazamiento permiten alterar el valor binario de un operando, estas son 
> - `SHR`: >> right 
> - `SHL`: << left
>   
>```nasm
>SHR operando, desplazamiento  ; >>
>SHL operando, desplazamiento  ; << 
>```
>
>Si se desplazan hacia la derecha, el bit que se salió de “la fila de asientos” es enviado a la bandera de acarreo CF, y el bit de más a la izquierda, es decir, el asiento que había, se queda con un cero, ha quedado vacío. Funciona exactamente igual en sentido contrario. Veamos un ejemplo
>
>```nasm
>MOV AL, 10110111b     ;AL = 10110111b
>SHR AL, 3             ;00010110b
>
>MOV AL, 10110111b     ;AL = 10110111b
>SHL AL, 3             ;10111000b
>```
>

> [!Info]- (ROR - ROL) Rotation
> A diferencia de los anteriores, ningún bit o “cliente” se queda sin silla, simplemente si se sale de la fila de sillas, va y se sienta a la que quedó vacía al otro extremo, 
> haciendo así un **Desplazamiento Circular**. 
> `ROR`: right > 
> `ROL`: left <
> 
> ```nasm
> MOV AL, 10110111b    ;AL = 10110111b
> ROR AL, 3            ;AL=11110110b
> 
> MOV AL, 10110111b    ;AL = 10110111b  
> ROL AL, 3            ;AL= 10111101b
> ```
> 


## Control del Sistema

Estas instrucciones carecen de operando específico y se pueden utilizar para habilitar o inhibir las interrupciones, llamar a una subrutina o retornar de ella, entre otras funciones. Por ahora nos centraremos en las instrucciones INT CLI, STI, CALL y RET.


- `INT`: permite la petición de una interrupción, por ejemplo, INT 10h.
- `CLI`: permite inhibir las interrupciones.
- `STI`: permite habilitar las interrupciones.
- `CALL`: realiza la llamada a una subrutina, por ejemplo, CALL destino.
- `RET`: permite retornar luego de la ejecución de una subrutina a la posición donde se encontraba antes de realizar la llamada.