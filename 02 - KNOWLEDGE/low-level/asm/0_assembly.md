# Assembly

Cada una de estas líneas puede estructurarse hasta en 4 campos o columnas separadas

> [!Info] Estructura
> ```nasm
> etiqueta:   instrucción operando1, operando2  ;comentarios
> ```


![[Pasted image 20231009174950.webp]]


## access stored information

Para comprender los diferentes modos de direccionamiento que veremos a continuación, es imperativo recordar el ciclo de operación básico de la computadora. La unidad de control de una computadora está diseñada para recorrer un ciclo de instrucciones que se divide en tres fases principales:

1. Búsqueda de la instrucción de la memoria
2. Decodificar la instrucción
3. Ejecutar la instrucción

Aunque la mayoría de los modos de direccionamiento modifican el campo de dirección de la instrucción, hay dos modos que no necesitan el campo de dirección. Son los modos implícito e inmediato.

> [!Info]- Modo Implicito 
> Se especifican los operandos en forma implícita en la definición de la instrucción. 
> ej: "`complementar acumulador`" es una instrucción de modo implícito porque el operando en el registro de acumulador está implícito en la definición de la instrucción.

> [!Info]- Modo inmediato
> En este modo se especifica el operando en la instrucción misma. 
> En otras palabras, una instrucción de modo inmediato tiene un campo operando, en lugar de un campo de dirección. 
> 
> Se mencionó antes que el campo de dirección de una instrucción puede especificar una palabra de memoria o un registro de procesador. Cuando el campo de dirección especifica un registro de procesador se dice que la instrucción esta en modo de registro.
> 
> ```nasm
> MOV AX,50H
> ```

> [!Info]- Modo de registro
> En este modo, los operandos están en registros que residen dentro de la CPU. Se selecciona el registro particular de un campo de registro en la instrucción. Un campo k bits puede especificar cualquiera de 2 a la k registros.
> 
> Restricciones:
> - No se permite combinar registros de diferentes longitudes en una misma instrucción.
> - El registro de segmento de código (`CS`) no puede ser utilizado como destino.
> - No se permite hacer `MOV` de segmento a segmento.
> 
>  Ejemplo:
>  ```nasm
>  MOV AL,BL   ;(1 byte)
>  MOV AX,BX   ;(1 palabra)
>  MOV EAX,EBX ;(doble palabra)
>  ```
            
> [!Info]- Modo de direccionamiento directo
> En este modo la dirección efectiva es igual a la parte de dirección de la instrucción. El operando reside en memoria y su dirección la proporciona en forma directa el campo de dirección de la instrucción. 
> En una instrucción de tipo salto el campo de dirección especifica la dirección de transferencia de control del programa real.
> 
> Ejemplo:
> ```nasm
> MOV AL,[50H]    ;aquí lo que se mueve hacia AL es el contenido de la dirección de memoria con desplazamiento 50H.
> ```

> [!Info]- Modo de direccionamiento indirecto
> En este modo, el campo de dirección de la instrucción proporciona la dirección en que se almacena la dirección efectiva en la memoria. 
> El control recupera la instrucción de la memoria y utiliza su parte de dirección para acceder la memoria una vez más con el fin de leer la dirección efectiva.
> 
> Unos cuantos modos de direccionamiento requieren que el campo de dirección de la instrucción se sume al contenido de un registro específico en la CPU. En estos modos la dirección efectiva se obtiene del cálculo siguiente:
> 
> 
> $$\text{Dirección efectiva} = \text{Parte de la instrucción} + \text{El contenido de registro CPU}$$
> 
> El registro de CPU utilizado en el cálculo puede ser el contador de programa, un registro de índice o un registro base. En cualquier caso tenemos un modo de direccionamiento diferente que se utiliza para una aplicación distinta.
> 
> Existen cuatro métodos de direccionamiento indirecto: 
> 1. Indirecto a registro
> 2. Relativo a base
> 3. Indexado
> 4. Indexado a base

> [!Info]- Indirecto a registro
> El registro seleccionado contiene la dirección del operando en lugar del operando mismo.
> 
> Antes de utilizar una instrucción de modo indirecto por registro, el programador debe asegurarse de que la dirección de memoria del operando está colocada en el registro del procesador con una instrucción previa. 
> Entonces una referencia al registro es equivalente a especificar una dirección de memoria. La ventaja de una instrucción de modo de registro indirecto es que el campo de dirección de la instrucción utiliza menos bits para seleccionar un registro de los que necesitaría para especificar una dirección de memoria en forma directa.
> 
> Ejemplo:
> ```nasm
> MOV AL,[BX]    ;aquí lo que se mueve hacia AL es el contenido de la dirección de memoria hacia donde apunta BX.
> ```
> similar a 
> ```c
> int a = &b
> ```

> [!Info]- Relativo a base
> 
> Ejemplo:
> ```nasm
> mov CL, [SP+DESP] 
> ;La instrucción copia el contenido de la posición de memoria cuya dirección de memoria está determinada por la suma del contenido de `BP` y `DESP` en el registro `CL`.
> ```
> 
> En este modo, el contenido de un registro base se suma a la parte de dirección de la instrucción para obtener la dirección efectiva. 
> Esto es similar al modo de direccionamiento indexado, excepto en que el registro se denomina ahora registro base, en lugar de registro índice. 
> La diferencia entre los dos modos está en la manera en que se usan más que en la manera en que se calculan. 
> Se considera que un registro base contiene una dirección base y que el campo de dirección de la instrucción proporciona un desplazamiento en relación con esta dirección base. 
> El modo de direccionamiento de registro base se utiliza en las computadoras para facilitar la localización de los programas en memoria.
> 
> 

> [!Info]- Indexado
> En este modo el contenido de un registro índice se suma a la parte de dirección de la instrucción para obtener la dirección efectiva. 
> El registro índice es un registro CPU especial que contiene un valor índice. 
> Un campo de dirección de la instrucción define la dirección inicial del arreglo de datos en la memoria. Cada operando del arreglo se almacena en la memoria en relación con la dirección inicial.
> 
> La distancia entre la dirección inicial y la dirección del operando es el valor del índice almacenado en el registro de índice. Cualquier operando en el arreglo puede accederse con la misma instrucción siempre y cuando el registro índice contenga el valor de índice correcto. El registro índice puede incrementarse para facilitar el acceso a operandos consecutivos. Nótese que si una instrucción de tipo índice no incluye un campo de dirección en su formato, la instrucción se convierte al modo de operación de indirecto por registro.
> 
> Algunas computadoras dedican un registro de CPU para que funcione exclusivamente como un registro índice. De manera implícita este registro participa cuando se utiliza una instrucción de modo índice. En las computadoras con muchos registros de procesador, cualquiera de los registros de la CPU puede contener el número de índice. En tal caso, el registro debe estar especificado en forma explícita en un campo de registro dentro del formato de instrucción. 
> 
> Ejemplo:
> ```nasm
> SUB AH, Matriz[SI]
> ;Esta instrucción resta del contenido de AH, el valor contenido en la posición de memoria especificada por la suma del desplazamiento indicado por el identificador Matriz y el contenido del registro SI.
> ```

> [!Info]- Indexado a base
> Resulta la combinación de los modos de direccionamiento Relativo a Base e Indexado directo.
> 
> Ejemplo:
> ```nasm
> mov DH, Vector[[BX][DI]]
> ```
> 
> La instrucción señala que el contenido de la posición de memoria cuya dirección viene indicada por la suma de los contenidos BX y DI y del desplazamiento indicado por el identificados Vector, sea copiado en DH.


## convert $\text{words} \to \text{numbers}$

![[Pasted image 20231009201613.webp]]

- La tabla muestra el valor decimal y el valor hexadecimal que toma cada caracter o símbolo.
- Existe una versión de la tabla ASCII de 128 bits, que se conoce como tabla reducida y una versión de 256 que se conoce como tabla ASCII extendida.
- Las letras mayúsculas están ubicadas entre el `65-90`, las minúsculas del `97-122` y los números del 0 al 9 entre el `48-57`.
- Desde hace mucho tiempo sabemos acceder a los valores de la tabla ASCII aunque creamos que no: cuando utilizamos la combinación Alt+164 para escribir la ñ, estamos escribiendo este valor directamente desde la tabla.







## BIOS (Basic Input-Output System)

Este se encarga de 
- controlar el modo en que trabaja el hardware (monitor, teclado, mouse, bocinas, etc.),
- cómo se administra la memoria temporal, 
- el almacenamiento permanente (disco duro, memoria USB) y 
- la comunicación entre el procesador y los demás dispositivos. 

En pocas palabras, es el responsable del funcionamiento básico de la computadora. Realiza el inicio de la computadora desde tres posibles fuentes:

- ROM de la tarjeta madre
- ROM de una tarjeta adaptadora
- Cargada en la RAM desde un disco


Tiene 4 Funciones
1. `BIOS`: 
		coleccion de drivers que actuan como interfaz entre el OS y el hardware
1. `POST (Power On-Self Test)`: 
		Comprueba el procesador, la memoria, el chipset, el adaptador de video, controlador de discos, teclado, etc.
1. `SETUP`: 
		Configura la tarjeta madre, el chipset, secuencia de arranque, contraseña, hora, fecha, etc.
1. `Boot strap loader (cargador de arranque)`: 
		Rutina encargada del arranque de la computadora iniciando la carga del sistema operativo a través de la carga del sector de arranque contenido en un disco.


¿Qué ocurre cuando se adiciona hardware a la pc para el cual no hay hardware en la ROM?
1. Es una tarjeta adaptadora que incluye su ROM: ej tarjeta de video. En ese caso la ROM escanea un rango de direcciones de memoria predefinidos y si encuentra la nueva ROM ejecuta su codigo y adiciona sus funcionalidades a las ya existentes
2. Especificar en el fichero de configuracion del SO los drivers necesarios\

## Proceso de arranque 

El término boot proviene del término «bootstrap» y describe el método por el cual la computadora se vuelve funcional

Detallar el proceso de arranque puede ayudar a la localización de un problema si se examina el código del error que se produce. Los programas capaces de mostrar mensajes de error durante el arranque pueden ser independientes del sistema operativo o dependientes de él. Estos son:

### Independientes del sistema operativo
- ROM-BIOS de la tarjeta madre
- ROM-BIOS de tarjetas adaptadores
- Registro de arranque maestro (MBR)
- Registro de arranque de volumen (VBR)

### Dependientes del sistema operativo
- ficheros del sistema
- manejadores de dispositivos (drivers)
- programas que corren en el inicio


El arranque consta de 2 etapas:

1. Arranque del hardware: Es independiente del Sistema Operativo e idéntico para todas las PC. Consta de 27 pasos.
2. Arranque del software: Varía según el sistema operativo instalado y cargado.


## bootloader

Para llevar a la memoria RAM un código mayor del que puede contener un sector del medio de almacenamiento se usan los cargadores de arranque.

Son aplicaciones especializadas para la carga de código después del encendido del sistema y funcionan en dos o más etapas.

El cargador de arranque tiene que:

1. Cargar el kernel (y todo lo que este necesite para iniciar)  en memoria.
2. Proveer al kernel con la información que necesita para trabajar apropiadamente.
3. Cambiar a un entorno que determine el kernel
4. Transferir el control al kernel


## multiboot

Existe un cargador muy versátil y potente: GRUB que está construido a partir de la especificación multiarranque (multiboot).

Ventajas:

1. Configura el modo protegido.
2. Tamaño del código.
3. Es portable.

Requisito:  El formato del fichero debe responder al estándar multiboot.

¿Qué diferencias tiene un código que puede ser cargado desde un sector de arranque, con respecto a otro que se compila para ser usado por GRUB? 
Esencialmente consiste en 12 bytes obligatorios que comienzan con el identificador `0x1BADB002`. Durante el arranque se accede a direcciones específicas de memoria 
¿cuál es su estructura física y lógica?¿cómo se organiza la información memoria?


## Carga de código en la memoria RAM

El espacio de direccionamiento de un PC se denomina memoria lógica o memoria física:

![[Pasted image 20231009180946.webp]]

El BIOS realiza una abstracción de bajo nivel en los medios de almacenamiento. Por tanto, es capaz de acceder de forma primitiva a cualquier dispositivo (CD, DVD, HDD, memoria flash) y cargar el primer sector lógico del medio de almacenamiento. Una abstracción interesante de los medios de almacenamiento es:

- El BIOS los ve todos como una caja negra (un bloque lógico).
- Por ello todos los medios de almacenamiento masivo son dispositivos o bloques lógicos, y eso significa que esos pedazos de información se pueden direccionar

El tamaño estándar de los sectores para la mayoría de los medios de almacenamiento es 512 bytes, excepto en dispositivos ópticos como CDs y DVDs que son de 2 KB y algunos dispositivos usan 4 KB.


### **Para la realización de un código booteable debe tenerse en cuenta:**

> [!Info]- 1 - Las direcciones del código deben partir de la dirección del sector de arranque (0000: 7C00h)
> La forma que empleamos para indicar el sector de arranque es a través de la directiva `org`, siendo una de las directiva obligatorias que utilizaremos en nuestros programas :
> ```nasm
> org 7C00h
> ```

> [!Info]- 2 - El código debe finalizar con la firma de arranque (0AA55h)
> La firma del sector de arranque se declara de la siguiente forma:
> ```nasm
> dw 0AA55h
> ```

> [!Info]- 3 - Debe cumplir con las normas de tamaño de este tipo de código.
> Estaremos escribiendo código para ser utilizado en discos magnéticos, por lo que su tamaño máximo debe ser de `512`.
> ```nasm
> times 510 - ($-$$) db 0
> ```
> - la instrucción `times` (funciona de forma similar al `dup`), para rellenar con `0` los espacios vacíos (`db 0`).
> - `$` indica el final de nuestro segmento de código y el `$$` el inicio de la sección, por tanto el resultado de `$-$$` se corresponde con el espacio en memoria donde está ubicado nuestro programa.
> - Por tanto cuando decimos `510 - ($-$$)`, estamos separando del total del espacio disponible la parte que actualmente contiene nuestro código.
> - Como resultado la expresión times `510 - ($-$$) db 0` indica que del total del espacio disponible (`512`), restemos la sección donde está escrito nuestro código y rellenemos el espacio vacío restante con `0`.
> 
> ¿Por qué decimos entonces `times 510` y no `times 512`? La respuesta a esta pregunta parte de los datos que conocemos:
> Entonces para calcular el espacio vacío decimos que:  
> $$\text{espacio vacío} = \text{tamaño total (512)} - \text{firma de arranque (2)} - \text{tamaño de mi programa(\$-\$\$)}$$

> [!Info]- 4 - Debe generarse con las extensiones `*.img` en los discos magnéticos o `*.iso` para los ópticos.
> 
> Para esto escribimos el siguiente código:
> ```nasm
> format binary as 'img'
> ```
> 
> Lo que significa que nuestro programa se guardará en formato binario en un archivo cuya extensión será `.img`.
> 
> Así que allá vamos con nuestra **plantilla de código booteable**:
> 
> ```nasm
> format binary as 'img'    ;se define la extension del fichero  
> org 7C00h                 ;se define la dirección base de trabajo en RAM  
> MOV AX, CS  
> MOV DS, AX         ;inicialización de los registros de segmento. 
> Colocamos al registro de segmento de código y al registro de segmento de datos a apuntar a la misma dirección de memoria. Lo hacemos a través del registro `AX`, porque recordemos que entre las restricciones del direccionamiento entre registros está que no se puede realizar movimiento de datos directamente entre ellos.
> 
> .. .            ;aquí escribimos el código de nuestro programa
>
> jmp $       ;al concluir con el código le indicamos al compilador que debe detener la ejecución a través de un salto sin condición a la sección final del programa
> ...            ;En este espacio declaramos las variables y subrutinas que utilizaremos en nuestro programa  
> times 510-($-$$) db 0        ;rellena con cero hasta completar 510  
> dw 0AA55h                    ;completa los 512 con la firma de arranque
> ```
> Aunque ensamblador nos permite declarar las variables en cualquier lugar del código, recomendamos seguir esta plantilla para facilitar la comprensión del mismo.


## basic assembly program structure

![[Pasted image 20231009181856.webp]]

1. Definir los registros de índice a utilizar
2. Establecer la dirección del arreglo o cadena
3. Establecer el número de iteraciones
4. Leer el dato
5. Realizar operación
6. Pasar al siguiente valor
7. Cerrar el ciclo
8. Condición del fin de programa



## Copiar de una cadena hacia otra

Pasos
1. Leer bien el problema
2. Extraer los datos
3. Definir las variables
4. Establecer la lógica para la solución.

> [!Info] 2, 3 - Extraer datos - Definir variables
> Puedo asumir que una de mis cadenas tendrá un contenido y la otra debe estar vacía, por tal motivo se necesitarán al menos dos variables. ¿Cómo declaramos una variable? Recordemos la estructura: 
>
> ```nasm
> <identificador> <tipo> <valor inicial>
> ```
>
> ```nasm
> lista DB 'El contenido de mi lista es este'
> 
> ;la segunda variable debe estar vacía
> otra DB 32 dup(?)    ;su tamaño será de 32, porque es la cantidad de caracteres que encontramos en la cadena a copiar, si la variable ¨otra¨ fuera menor no podríamos realizar una copia total de la misma. 
> 
> ```

> [!Info] 4 - Logica
> La primera cadena llamada lista y copiaremos cada uno de los valores hacia la otra cadena. 
> ```nasm
> format binary as 'img'   
> org 7C00h   
> MOV AX, CS
> MOV DS, AX  
>       
> XOR AX, AX      ;para que el registro AX queda vacío y usarlo posteriormente
> ;1. registros apuntador a utilizar (SI) 
> ;2. ponerlos a apuntar hacia la primera posición de la cadena fuente
> MOV SI, lista    
> ;1. registros apuntador a utilizar (DI) 
> ;2. ponerlos a apuntar hacia la primera posición de la cadena destino 
> MOV DI, otra
> MOV CX, 32      ;cantidad de iteraciones a realizar
> ciclo:
> 	MOV AL, [SI]     ;almacenarlo  en un registro el dato que se encuentra en la posición a la que está apuntando SI 
> 	MOV [DI], AL     ;Realizar la operación, en este caso la copia de una cadena a otra. El dato almacenado en la posición a la que apunta SI y posteriormente guardado en AL para realizar las operaciones, se guarda en la posición a la que apunta DI.
> 	INC SI        ;Pasar a la siguiente posición
> 	INC DI       
> 	LOOP ciclo      ;Estamos indicando que las operaciones comprendidas entre esta línea de código y la etiqueta ciclo, deben repetirse hasta que CX=0, es decir, hasta que hayamos copiado nuestra cadena en su totalidad.
>   
> jmp $  
> lista DB 'El contenido de mi lista es este'        
> otra DB 32 dup(?) 
>  
> times 510-($-$$) db 0   
> dw 0AA55h
> ```


> [!Info] Ejemplo copiar inverso de una cadena a otra
> ```nasm
> format binary as 'img'
> org 7c00h
> 
> mov ax, cs 
> mov ds, ax 
>
> xor si, si
> xor di, di
> 
> mov cx, 12
> @@:
>    mov al, [cadena + si]
>    mov [cadena1 + di], al
>    inc si
>    dec di
>    loop @b
>
> jmp $
> cadena1 db 12 dub(?)
> cadena db 'Arquitectura'
> times 510 - ($-$$) db 0
> dw 0AA55h
> ```