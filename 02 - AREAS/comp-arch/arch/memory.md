La memoria tiene la misión de servir como almacén de las instrucciones y datos que constituyen los programas.


Las características más importantes de los diferentes tipos de memoria son 
- Localización
	- memoria dentro del chip del procesador (registros y cache)
	- memoria interna (RAM)
	- memoria externa (discos duros, etc)
- Capacidad
- Método de acceso
	- **Secuencial** 
		- Acceso debe realizarse con una secuencia lineal específica. 
		- La memoria se organiza en unidades llamadas registros
		- Ejemplo: *Cinta*
	- **Directo** 
		- Tiene asociado un mecanismo de lectura-escritura
		- Los bloques individuales o registros tienen una dirección única basada en su dirección física
		- Se accede directamente a una vecindad dada, seguido de una búsqueda secuencial, hasta alcanzar la posición final. 
		- Ejemplo: *Discos*
	- **Aleatorio** 
		- Cada posición direccionable de memoria tiene un único mecanismo de acceso cableado físicamente
		- El tiempo para acceder a una posición dada es constante e independiente de la secuencia de accesos previos
		- Cualquier dirección puede seleccionarse aleatoriamente y ser direccionada y accedida directamente
		- Ejemplo: *Memoria principal y cache*.
	
	-  **Asociativo**
		- Es del tipo de acceso aleatorio que permite hacer una comparación de ciertas posiciones de bits dentro de una palabra buscando que coincidan con unos valores dados y hacer esto para todas las palabras simultáneamente. 
		- Una palabra es recuperada en base a una porción de su contenido en lugar de su dirección. 
		- Ejemplo: *Memorias cache*.
- la organización de los datos en una memoria
	- **palabra de memoria** (unidad de organizacion de memoria para un proc, se especifica en bytes o bits)
	- **unidad de direccionamiento**:  
	- **unidad de transferencia**
- el tiempo de acceso y velocidad
	- **RAM**: (el tiempo que transcurre desde que una dirección de memoria es visible para los circuitos de la memoria hasta que el dato está almacenado o está disponible para ser utilizado)
	- **memorias de acceso no aleatorio**, se considera como tiempo de acceso, al tiempo necesario en el que se realiza la lectura o escritura.
	- **memorias de acceso aleatorio**, el tiempo de un ciclo de memoria, se considera el tiempo de acceso, más el tiempo necesario antes de que pueda empezar otra tarea de acceso a la memoria.
	- **La velocidad de transferencia** es aquella que transcurre entre leer o escribir un dato en memoria (En las memorias RAM será el inverso de tiempo de ciclo.)
- unidad de transferencia
	- **memoria interna**: el numero de lineas de E/S de datos
	- **memoria externa**: los datos se transfieren en unidades mas grandes llamados bloques
- Prestaciones
	- **tiempo de acceso (latencia)**: tiempo que tarda en realizarse una operacion de escritura / lectura
	- **tiempo de ciclo de memoria**: medida de rapidez con la que la memoria puede estar lista para un nuevo conjunto de comandos
	- **velocidad de transferencia**: para unidades de acceso aleatorio = al inverso del tiempo de ciclo
- clasificacion segun tipo
	- **Semiconductoras**: Memoria RAM
	- **De superficie magnética**: Discos duros, disquetes, etc.
	- **Ópticas y magneto-ópticas**: CDs, DVDs, etc
- caracteristicas fisicas
	- **volatil**: 
		- la informacion se pierde cuando se desconecta la alimentacion
		- ej: SRAM (static, Basada en flip flops), DRAM (dynamic, Cargas almacenadas en transistores (capacitores))
	- **no volatil**: 
		- **ROM**: 
			es una cantidad pequeña de memoria de sólo lectura que guarda las instrucciones para iniciar la computadora
		- **PROM**: 
			- Es un chip de memoria en la cual se puede salvar un programa y una vez que se haya utilizado no se puede reusar para salvar algo más, por lo que se considera una memoria permanente
		- **EPROM**: 
			- se programan mediante un dispositivo electrónico y pueden ser borradas exponiéndolas a la luz ultravioleta.
		- **EEPROM**: 
			- puede ser programada, borrada y reprogramada eléctricamente. Puede ser leída un número ilimitado de veces y puede ser borrada y reprogramada un número limitado de veces. No hay necesidad de luz ultravioleta para su borrado.
		- memorias Flash
		- CPLD (Dispositivo lógico programable complejo)
		
	- **no borrable**: las memorias semiconductoras de este tipo son de solo lectura (ROM, Read Only Memory)




- A menor tiempo de acceso mayor coste.
- A mayor capacidad menor coste por bit.
- A mayor capacidad menor velocidad.



Parametros generales aplicables a todas las memorias

![[Pasted image 20231009134249.webp]]

## Jerarquia de memoria

El principio de localidad establece que los programas acceden a una parte relativamente pequeña del espacio de direcciones en un determinado instante

### Localidad temporal

Consiste en que si se accede a una dirección de memoria, esta dirección será utilizada de nuevo en un corto intervalo de tiempo. 

O sea, si usted ha llevado recientemente un libro a su mesa para consultarlo, probablemente pronto necesitará consultarlo de nuevo.

### Localidad espacial

Si se accede a una dirección de memoria, las direcciones de memoria que se encuentran próximas a ella serán utilizadas en un corto intervalo de tiempo. 

Por ejemplo, cuando sacaste de la estantería el libro sobre las primeras computadoras inglesas para encontrar información sobre EDSAC, quizás viste cerca de él otro libro que trataba sobre las primeras computadoras mecánicas; así que también lo llevaste a la mesa, y posteriormente encontraste en ese libro alguna información que fue útil. Los libros que tratan un mismo tema se colocan juntos en las estanterías de las bibliotecas para incrementar la localidad espacial.


Por ejemplo, los accesos a elementos de una matriz o una tupla experimentarán por naturaleza un alto grado de localidad espacial.

Las jerarquías de memoria aprovechan la localidad temporal guardando los datos recientemente accedidos en un lugar próximo al procesador.
Y la localidad espacial transmitiendo hacia niveles superiores de la jerarquía bloques de varias palabras que se almacenan en posiciones contiguas de memoria

![[Pasted image 20231009135317.webp]]


## Organizacion de la memoria

Podemos indicar que los seres humanos tenemos básicamente dos tipos de memoria: una transitoria, cuyo contenido puede variar, y otra fija, que se mantiene inalterable atendiendo actividades imprescindibles y no modificables

![[Pasted image 20231009135942.webp]]

**RAM**: Cuando se quieren procesar programas o datos intercambiables se utilizan memorias volátiles, que se pueden leer y escribir, son de tecnología de semiconductores y constituyen el área de trabajo de una computadora

**ROM**: Los programas y los datos fijos, asociados en forma directa a la CPU, se almacenan en memorias no volátiles (o perennes) de semiconductores, que sólo se pueden leer, por lo que su contenido no se altera
El acceso tambien es dinamico
Las memorias ROM se utiliza en:
- Microprogramación
- Subrutinas de bibliotecas para funciones de uso frecuente
- Programas del sistema
- Tablas de funciones

**Memoria Principal**: La memoria principal conocida como memoria central o interna es un tipo de memoria volátil, es decir, que la información se guarda temporalmente y es borrada una vez que se desconecta la PC. Su principal función es almacenar datos, parámetros y resultados que deben ser actualizados y que están sujetos a ser cambiados, primero lo coloca en la memoria y después lo empieza a leer o ejecutar. Esta memoria se comunica con el microprocesador a través del bus de datos y el bus de direcciones





## RAM 

La memoria RAM actual es de tipo DRAM o Dynamic RAM debido a que necesita una señal de tensión para que los datos almacenados en ella no se pierdan



Single in line Memory Module es un formato para módulos de memoria RAM que consisten en placas de circuito impreso sobre las que se montan los integrados de memoria DRAM. Los contactos en ambas caras están interconectados.
![[Pasted image 20231009150127.webp]]


### DDR

Es la última generación de la SDRAM, con 64 bits de ancho del Bus de direcciones.

- Permite la lectura de datos tanto en la fase alta como baja del ciclo del reloj, con lo que se duplica el ancho de banda de la SDRAM estándar sin aumentar la frecuencia del reloj
- Se presenta en módulos DIMM de 184 contactos.

![[Pasted image 20231009150347.webp]]


### DDR2

- Admite hasta 4GB de capacidad.
- Posee una velocidades más altas, anchos de banda de datos más grandes, menor consumo de energía y desempeño térmico mejorado


### DDR3

La DDR3 trae consigo una nueva forma de recibir, leer y almacenar los datos. Aumentando el rendimiento sin necesariamente disminuir las latencias y aumentar la frecuencia de las memorias con respecto a la DDR2.

### DDR4

la memoria DDR4 es más eficiente que la DDR3, la cual operaba en 1.5 voltios, mientras que la nueva generación ahorra de 20% a 40% más energía y sólo necesita 1.2 voltios para trabajar.

### DDR5

La DDR5 es el salto más considerable en una RAM para PC desde el lanzamiento de la primera DDR a principios de la década de los 2000. No solo por el hecho que empezará en el DDR5-4800, lo que significa que el controlador de memoria realiza 4800 millones de transferencias por segundo. Tampoco por haber bajado su voltaje a los 1,1 voltios, lo que le permite consumir un 30% menos de energía que la memoria RAM DDR4 estándar por bit transmitido.

La gran diferencia es el hecho de soportar el doble de canales de memoria pero sin aumentar el ancho de banda total. Cada módulo DIMM DDR5 puede efectuar dos transferencias simultáneas de 32 bits de ancho de banda por ciclo de reloj. Esto es un cambio importante, ya que la DDR4 puede efectuar una transferencia, pero de 64 bits por ciclo. 

Aunque aún no se han confirmado latencias finales en las memorias DDR5 comerciales, el estándar dicta que la latencia será igual o muy similar a la de las memorias DDR4.

Diferencias físicas

![[Pasted image 20231009151135.webp]]

Comparación

![[Pasted image 20231009151150.webp]]

Todas las memorias DDR pueden transferir 16byte en un solo ciclo de bus

## Características principales de la Memoria RAM

### Arquitectura

Podemos decir que la arquitectura es la forma en la que las memorias se comunican con los diferentes elementos a los que están conectadas. Actualmente tenemos la arquitectura DDR en su versión 5, la cual es capaz de escribir y leer 8 celdas de información en dos operaciones simultáneas en cada ciclo de reloj.

### Capacidad

### Velocidad

- **Frecuencia de reloj**: que será a la velocidad de refresco de los bancos de memoria.
- **Frecuencia de bus**: es la mitad de la frecuencia de la memoria, será la frecuencia a la que realmente trabaja el reloj de la memoria RAM. 
- **Frecuencia de la memoria**: es la velocidad efectiva que alcanza los datos y transacciones, que en las DDR será el doble de la frecuencia del bus por tener un doble bus.

Por ejemplo: una memoria DDR4-3200 tiene una frecuencia de reloj de 800 MHz, mientras que su bus trabaja a 1600 MHz dando como resultado una frecuencia de 3200 MHz.


### Latencia

La latencia es el tiempo que tarda la memoria RAM en atender una petición hecha por la CPU. Mientras más frecuencia, más latencia habrá, aunque la velocidad siempre hará que sean módulos más rápidos a pesar de tener mayor latencia. Los valores se miden en ciclos de reloj. Las latencias se representan de la forma X-X-X-XX. 
- **CAS Latency (CL):**
- **RAS to CAS Delay (tRCD):** 
- **RAS Precharge Time (tRP):** 
- **Row Active Time (tRAS):** 


### BUS

Esta característica es una función muy importante en las memorias actuales y que influye en el rendimiento de una memoria. Veamos cuáles son los diferentes buses que una memoria RAM tiene para comunicarse con la CPU.

- **Bus de datos**: línea por la que circula el contenido de las instrucciones que se procesarán en la CPU. Es de 64 bits en la actualidad.
- **Bus de direcciones**: la petición de un dato se realiza a través de una dirección de memoria. Hay un bus específico para realizar estas peticiones e identificar dónde está almacenado el dato.
- **Bus de control**: bus específico usado por señales de lectura, escritura, reloj y reseteo de la RAM.

La tecnología Dual Channel lo que permite es el acceso simultáneo a dos módulos de memoria distintos. En lugar de tener un bus de datos de 64 bits, este se duplica a 128 bits para que a la CPU lleguen mayor cantidad de instrucciones. 

El uso de modos de trabajo multicanal depende solamente del chipset.
Los controladores de memorias integrados en la CPU (puente norte) disponen de esa capacidad mientras que los módulos estén conectados al DIMM del mismo color en la placa. 

De lo contrario trabajarán de forma independiente.  
En las placas con chipset X399 de AMD y X299 de Intel se permite trabajar con hasta cuatro módulos en paralelo, es decir, Quad Channel, generando un bus de 256 bits. Para ello, dichas memorias deben de tener en sus especificaciones dicha capacidad. El rendimiento mejora tanto que si elegimos tener 16 GB de RAM en es mejor hacerlo con dos módulos de 8 GB a tener un solo módulo de 16 GB.


### ECC y Non ECC (Error Correcting Code)

Estos términos aparecen con frecuencia en las especificaciones de la memoria RAM y también en la placa base. ECC (Error Correcting Code), es un sistema por el cual la RAM tiene un bit extra de información en las trasferencias para detectar errores entre los datos transferidos de memoria y procesador.  
Mientras mayor sea la velocidad, más susceptible será un sistema de tener errores, y por esto existen las memorias ECC y Non-ECC. Sin embargo, nosotros usaremos siempre en nuestros PC domésticos las de tipo Non-ECC, es decir, sin corrección de errores. Las otras, están destinadas a equipos como servidores y ámbito profesional en donde se puedan corregir los bits alterados sin perder datos en el funcionamiento. Solo los procesadores de la gama Pro de Intel y AMD y los de servidores admiten memorias ECC.

## ¿Cómo influye la memoria RAM en la ejecución de una instrucción?

> [!Info]- Ejemplo: Calculo de memoria
> Un procesador que trabaja a una **frecuencia** de 2GHz posee una instrucción capaz de realizar trasferencias múltiples a memoria. La captación, decodificación y resolución de las direcciones tardan en realizarse un total de **10 ciclos de reloj**. 
> ¿Cuánto tardaría en ejecutarse una transferencia de **128 bytes** a memoria si eI sistema dispone de dos módulos **PC2-6400** en la configuración **dual channel**?
> $$\text{capacidad} = \frac{\text{CantModulos} * \text{AnchoBus}}{8}$$
> el bus es de 64 bits (8 bytes) en las DDR
> $$\text{AnchoBanda(BW)} = \frac{2 * \text{FBus} * \text{AnchoBus}}{8}$$
> Si el ancho del bus es de 64 bits el ancho de banda es
> $$\text{BW} = 16 * \text{FBus}$$
> 
> 1. Datos
> - frecuencia procesador: `2Ghz`
> - captacion, decodificacion y resolucion: `10 ciclos`
> - bus: `64 bits`
> - ancho de banda (BW): `6400 MB/s`
> - Cantidad de datos a trasferir: `128 bytes`
>   
>  2. Calcular tiempo de la instruccion
>   el tiempo que demora un 1 ciclo es 
>   $$P = \frac{1}{\text{FProcesador}} = \frac{1}{2} = 0.5$$
>   por lo tanto si la captacion, decodificacion y resolucion tarda `10 ciclos`, entonces cada instruccion tarda `5ns` ($10 * 0.5 = 5$)
>   
>  3. Calcular la frecuencia del bus
>    $$\text{FBus} = \frac{6400}{16} = 400Mhz$$
>   
>  4. Tiempo que demora una transferencia
>  $$P = \frac{1}{\text{FBus}} = \frac{1}{400} = 2.5ns$$    
>  
>  5. Calcular la cantidad de transferencias
>  $$\text{CantTransf} = \frac{\text{cbytes}}{\text{capacidad (ancho del bus bytes* canales)}}$$
>  $$\text{CantTransf} = \frac{128}{16} = 8$$
>  
>  6. Calcular el tiempo total de la transferencia
>  $$8 \text{(CantTransf)} * 2.5ns \text{(Tiempo 1 transferencia)} + 5ns \text{(TProces)} = 25ns$$

> [!Info]- Ejemplo: Calculo de memoria
> Un procesador que trabaja a una frecuencia de 3 GHz posee una instrucción capaz de realizar trasferencias múltiples a memoria. La captación, decodificación y resolución de las direcciones tardan en realizarse un total de 15 ciclos de reloj. Se desea hacer una transferencia de 64 bytes a memoria y el sistema dispone de dos módulos DDR2-800 en la configuración dual channel. Teniendo en cuenta esta información responda:
> 
> a) $TP = \frac{CC}{FP} = 5ns$
> b) $FM = 800Mhz$
> c) $FB = \frac{FM}{2} = \frac{800}{2} = 400Mhz$
> d) $BW = 8FM = 8 * 800 = 6400MB/s$
> d) $CT = \frac{cbytes}{8 * canales} = \frac{64}{8 * 2} = 4$
> e) $TT = TP + TM = 5 + \frac{CT}{FB} = 5 + \frac{4}{400} = 5.01ns$



