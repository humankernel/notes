Un módulo de E/S contiene la lógica necesaria para para permitir la comunicación entre el periférico y el bus.

> [!Faq]- Por qué los periféricos no se conectan directamente al bus del sistema?
> ![[Pasted image 20231022113555.webp]]


Funciones principales módulo de E/S:
- Realizar la interfaz entre el procesador y la memoria a través del bus del sistema o un conmutador central
- Realizar la interfaz entre uno o más dispositivos periféricos mediante enlaces de datos específicos


![[Pasted image 20231022113908.webp]]


## Características

- **Comportamiento**
	- entrada (se lee un sola vez), 
	- salida (solo escritura, no puede ser leída), 
	- almacenamiento (puede ser releída y rescrita muchas veces), 
	- comunicación (puede ser releída y rescrita muchas veces)
	- mixtos (puede ser releída y rescrita muchas veces).

- **Interlocutor**
	Persona o máquina que está al otro lado del dispositivo de E/S y que le envía datos a su entrada o lee datos de su salida.

- **Ritmo de transferencia de datos**
	Ritmo máximo al cual los datos pueden ser transferidos entre el dispositivo E/S y la memoria principal o el procesador.
	*Es útil conocer, al diseñar un sistema de E/S, cuál es la demanda máxima que el dispositivo puede generar.


Por ejemplo, un teclado es un dispositivo de entrada utilizado por un humano con un **ritmo de transferencia** de datos máximo de alrededor de 10 bytes por segundo.


## ¿Cómo se conectan el procesador, la memoria y los dispositivos de E/S?

- **BUS**
	**Ventajas**:
	- la versatilidad y el bajo coste. 
	- los nuevos dispositivos pueden añadirse fácilmente, y los periféricos pueden incluso ser instalados en distintas computadoras que utilizan el mismo tipo de bus. 
	- los buses son eficientes en coste debido a que un único conjunto de conductores se comparte de varias formas.
	
	**Desventaja**:
	Consiste en que genera un *cuello de botella* en las comunicaciones, posiblemente limitando el número máximo de operaciones de E/S. 
	Cuando la E/S debe atravesar un único bus, su ancho de banda limita el número máximo de operaciones de E/S.

## Chipset

*Existe un conjunto de dispositivos que trabajan de apoyo y llevan el nombre de chipset.*

Es un conjunto de microprocesadores especialmente diseñados para funcionar como si fueran una única unidad y para desempeñar una o varias funciones.

Es una serie de circuitos electrónicos, que gestionan las transferencias de datos entre los diferentes componentes de la computadora (procesador, memoria, tarjeta gráfica, unidad de almacenamiento secundario, etc.).


![[Pasted image 20231022114507.webp|600]]

### North Bridge o GMCH (Grafic Memory Controller Hub)

Es el encargado de gestionar 
- Memoria RAM
- los puertos gráficos (AGP, PCIe x16) 
- el acceso al resto de los componentes del chipset, (así como la comunicación entre estos y el procesador). 
- CPU
  
Gestiona la interconexión entre el microprocesador, la memoria RAM y la unidad de procesamiento gráfico.
Dado su alto rendimiento, generan una alta temperatura, por lo que suelen tener algún tipo de refrigeración, ya sea activa o pasiva. 

*Actualmente se encuentran integrados dentro del microprocesador.

### South Bridge o ICH (I/O Controller Hub)

Es el chip encargado de controlar los restantes elementos I/O (Input/Output), audio, red, IDE, SATA, USB, etc. 
Gestiona la interconexión entre los periféricos y los dispositivos de almacenamiento, como los discos duros o las unidades de disco óptico. 

___ 

Los avances en los microprocesadores (más rápidos y de más núcleos) hacen que la conexión del bus de sistema sea insuficiente. Como solución a este problema se ha rediseñado el chipset en el siguiente sentido:

- El puente norte desaparece y la mayoría de sus funciones (control de memoria RAM, control de gráficos, etc.) pasan al microprocesador.
- Se crea un nuevo chip llamado PCH, que sustituirá al puente sur, asumiendo todas sus funciones y algunas del puente norte que no se han adjudicado al microprocesador.
- El canal de comunicación del PCH con el microprocesador es DMI, con capacidad máxima de 10 GBps



## ¿Cómo se transfiere la información desde y hacia los dispositivos de E/S?

El sistema operativo desempeña un papel importante en la gestión de E/S, actuando como interfaz entre el hardware y el programa que solicita la operación de E/S.
Las responsabilidades del sistema operativo surgen de tres características de los sistemas de E/S:

![[Pasted image 20231022114933.webp]]

Para enviar un comando a un dispositivo de E/S, el procesador debe poder seleccionar o direccionar el dispositivo y proveer comandos de una o más palabras. Para direccionar un dispositivo se utilizan dos métodos:

### E/S asignada al espacio de memoria

En la E/S asignada al espacio de memoria (memory-mapped), se asignan porciones del espacio de direccionamiento a los dispositivos de E/S. 

Las lecturas y escrituras a esas direcciones se interpretan como comandos para el dispositivo de E/S.

Por ejemplo, una operación de escritura se puede utilizar para enviar datos a un dispositivo de E/S, donde los datos serán interpretados como un comando. 

Cuando el procesador pone la dirección y los datos en el bus de memoria, el sistema de memoria ignora la operación porque la dirección pertenece a una parte del espacio de memoria usado para E/S. 

El controlador del dispositivo, sin embargo, detecta la operación, recoge el dato y lo transmite al dispositivo como un comando. Los programas del usuario no pueden realizar operaciones de E/S directamente porque el SO no proporciona acceso al espacio de direccionamiento asignado a los dispositivos de E/S y las direcciones están protegidas por el mecanismo de conversión de direcciones.


### Instrucciones especiales de E/S

La alternativa a la E/S asignada al espacio de memoria es utilizar instrucciones especiales de E/S del procesador. Estas instrucciones de E/S pueden especificar el número de dispositivo y la palabra del comando (o la posición de la palabra del comando en memoria). El procesador envía la dirección de dispositivo a través de una serie de líneas incluidas normalmente como parte del bus de E/S. El comando puede enviarse a través de las líneas de datos en el bus. Haciendo que la ejecución de instrucciones de E/S no esté permitida cuando no se está en modo núcleo o supervisor, se puede impedir o prevenir que los programas del usuario tengan acceso directo a los dispositivos.

## Forma de Comunicacion

Para enviar datos al procesador el dispositivo puede utilizar las siguientes formas:

- Encuestas o interrogación
- E/S dirigida por interrupciones
- Acceso directo a memoria (DMA)

###  Encuesta

Es la forma más sencilla  para que un dispositivo de E/S se comunique con el procesador.

El procesador tiene todo el control y hace todo el trabajo.
No es vital garantizar una transferencia de elevado ancho de banda.
Adecuados para dispositivos de menor ancho de banda.
Conector mecánico que conecta los dispositivos periféricos al bus de sistema


El proceso de comprobar periódicamente los bits del estado para ver si es el momento de realizar la siguiente operación de E/S, se llama encuesta (polling). La encuesta es la manera más sencilla para que un dispositivo de entrada-salida se comunique con el procesador. El dispositivo de E/S simplemente pone la información en un registro de Estado, y el procesador debe obtener esta información. El procesador tiene todo el control y hace todo el trabajo.

La encuesta o interrogación se puede utilizar de diferentes modos. Las aplicaciones para sistemas empotrados en tiempo real encuestan a los dispositivos de E/S puesto que las frecuencias de E/S están predeterminadas. Eso hace que el tiempo de sobrecarga de la E/S sea más predecible, lo cual es útil para tiempo real. Esto permite que la encuesta pueda ser utilizada aun cuando la frecuencia de la E/S sea algo más alta.

La desventaja de la encuesta es que puede desperdiciar mucho tiempo de procesador porque los procesadores son mucho más rápidos que los dispositivos de E/S. Puede ocurrir que el procesador lea muchas veces el registro de Estado sólo para encontrar que el dispositivo todavía no ha terminado una operación de E/S que es comparativamente más lenta, o que el ratón no se ha movido desde la vez última que se realizó la encuesta. Cuando el dispositivo termina una operación, aún debemos leer el estado para determinar si se ejecutó con éxito. El tiempo de sobrecarga de la E/S por encuesta fue reconocido hace tiempo y condujo a la propuesta de usar interrupciones para notificar al procesador que un dispositivo de E/S requiere la atención del procesador.

### E/S dirigida por interrupciones
Conector mecánico que conecta los dispositivos periféricos al bus de sistema

Es utilizada por casi todos los sistemas para al menos algunos dispositivos.


El dispositivo genera una interrupción al finalizar la transferencia de datos o cuando se genera un error.

Es generada cuando un dispositivo quiere notificar al procesador que ha terminado cierta operación o necesita atención.




La E/S dirigida por interrupciones es una técnica que permite a los dispositivos de E/S notificar al procesador cuando necesitan atención, eliminando la necesidad de que el procesador esté constantemente verificando el estado del dispositivo. Esto se logra a través de interrupciones que el dispositivo envía al procesador.

Existen dos métodos principales para la transferencia de datos entre el dispositivo de E/S y la memoria: la transferencia por encuesta y la transferencia dirigida por interrupción. En ambos casos, es el procesador quien realiza el movimiento de datos y gestiona la transferencia.

En la transferencia por encuesta, el procesador carga datos desde los registros del dispositivo de E/S y los almacena en memoria. En la transferencia dirigida por interrupción, el sistema operativo (SO) realiza la transferencia de datos en pequeñas cantidades desde o hacia el dispositivo, permitiendo al SO trabajar en otras tareas mientras los datos se están leyendo desde el dispositivo o se están escribiendo al dispositivo.

Aunque la E/S dirigida por interrupción libera al procesador de tener que esperar cada acontecimiento de E/S, si se utiliza para transferir datos desde o hacia un disco duro, la sobrecarga de tiempo podría ser intolerable, ya que podría consumir una gran fracción del procesador cuando el disco está realizando transferencias.

###  Acceso directo a memoria (DMA)

Es idóneo para dispositivos de ancho de banda elevados con transferencias de datos con  bloques de información relativamente grandes.	


El Acceso Directo a Memoria (DMA) es un mecanismo que permite a los controladores de dispositivos transferir datos directamente hacia o desde la memoria sin la intervención del procesador. Este método es especialmente útil para dispositivos de alto ancho de banda como los discos duros, que suelen transferir bloques de datos relativamente grandes.

El DMA se implementa con un controlador especializado que se convierte en el “maestro del bus” y dirige las lecturas o escrituras entre él mismo y la memoria. Aunque el mecanismo de interrupción todavía se utiliza para comunicarse con el procesador, sólo se hace al finalizar la transferencia de E/S o cuando ocurre un error.

La transferencia por DMA consta de tres pasos:

1. El procesador envía una solicitud de transferencia de DMA al controlador de DMA, especificando la operación (lectura o escritura), la dirección del dispositivo, la dirección de inicio en memoria y el número de palabras a transferir.
2. El procesador continúa ejecutando instrucciones mientras el controlador de DMA transfiere datos directamente entre el dispositivo y la memoria.
3. Una vez que la transferencia de DMA se ha completado, el controlador de DMA envía una interrupción al procesador. Así, el procesador sabe que la transferencia de DMA ha terminado y que los datos están disponibles en memoria.

El uso de DMA para la transferencia de datos reduce la carga del procesador y permite un mayor ancho de banda para las operaciones de E/S. Sin embargo, si el procesador necesita acceder a la memoria mientras se está realizando una transferencia por DMA, puede tener que esperar hasta que la memoria esté disponible.

## Controlador de interrupciones 8259

En las primeras computadoras existía un dispositivo llamado 8259 el cual tenía como función controlar las interrupciones de hardware, fungiendo como un intermediario entre el Sistema de Entrada/ Salida y el procesador. Actualmente estas funciones son asumidas por el chipset y mantiene por compatibilidad los mismos modos de funcionamiento, programación y direcciones. La estructura física del 8259 es:

![[Pasted image 20231022120606.webp]]

Este circuito integrado está especialmente diseñado para controlar las interrupciones y puede controlar hasta 8 interrupciones vectorizadas. Sus principales elementos son:

1. D0 a D7: Bus de datos bidireccional, por el que se transmite la indormación de control/estado y el número de vector de interrupción
2. RD: Permite al 8259 dejar la información en el bloque de datos
3. WR: Permite al 8259 aceptar comandos del CPU
4. A0: Para el direccionamiento
5. CS: Habilita la comunicaión con el CPU
6. Cas0 a Cas2: Líneas de cascada, actúan como salida en el 8259 maestro y como entrada en los 8259 esclavos en un sistema con varios 8259 interconectados sustiuyendo al bus local.
7. INT: Para la conexión al terminal del procesador del mismo nombre por el cual se envía la petición de atención
8. INTA: Línea de reconocimiento de interrupción, fuerza al 8259 a depositar en el bus la información del vector de interrupción.
9. IRQ0 a IRQ7: A estos terminales iban conectados los dispositivos para la realización de sus peticiones de atención. Aunque es programable por defecto va en orden ascendente de prioridad.
10. SP/EN: Pin con doble función, dependiendo del modo (real o protegido) actuará para habilitar lso buffers del bus o indicar si es maestro o esclavo


Anteriormente se analizó que cuando un dispositivo solicita ser atendido por interrupciones ocurre el siguiente proceso:

1. Al procesador le llega la información por la señal `INT`
2. Finaliza la ejecución de la instrucción en curso y se salva en la pila el estado actual del procesador así como la dirección de la instrucción próxima a ejecutar, y envía una señal `INTA`.
3. El procesador accede al número de la interrupción a través del Bus de Datos
4. Con el número de la interrupción, el procesador conforma la dirección para leer en la Tabla de Vectores de Interrupción (`IVT`), que contiene la dirección de la rutina de atención a interrupciones (`ISR`) correspondiente.
5. Va a la dirección, ejecuta la ISR y cuando termina recupera el registro bandera y la dirección de retorno de la instrucción siguiente a la última que ejecutó cuando ocurrió la IT.

¿Cómo interviene el 8259?

1. El 8259 recibe todas las peticiones de atención por interrupciones de los diferentes dispositivos a través de los IRQ y establece una cola de prioridades.
2. Cuando se encuentra listo envía una señal INT al procesador quién a su vez cuando está preparado para atender (pasos a y b anteriores) envía una señal INTA.
3. Al recibir el INTA el 8259 envía por el bus de datos el número de interrupciones correspondiente al IRQ que va a ser atendido. A partir de aquí se ejecutan los pasos c al e anteriores.

Una vez finalizado el proceso el controlador debe repetir el proceso con la siguiente petición IRQ en cola. Físicamente existían dos controladores 8259 en configuración Maestro- Esclavo:

![[Pasted image 20231022120836.webp|500]]

Esto permite extender a 15 el número de dispositivos a atender por este mecanismo de comunicación. El proceso de atención es muy similar al descrito anteriormente.

1. Si la solicitud llega por el controlador esclavo este a su vez realiza la petición al maestro a través del IRQ2. El maestro es el encargado de gestionar la petición al procesador.
2. Los dos 8259 reciben el INTA y a través de las señales Cas0 a la 2 el maestro le indica al esclavo que ponga el número del vector de interrupción en el bus de datos.
3. Si la solicitud llega por el maestro las señales Cas0 a la 2 se usan para indicar al esclavo que no debe escribir en el bus de datos.

Los dispositivos conectados son:

![[Pasted image 20231022120845.webp]]

Para poder dar paso al siguiente IRQ en la cola establecida por la lista de prioridades es preciso que el 8259 tenga información de que se finalizó de atender. Es por ello que en las ISR de Hardware hay que agregar un comando de fin de interrupción (EOI). Si la solicitud es al esclavo se debe enviar el comando a los dos controladores. Los controladores se encuentran en las direcciones 20h/ 21 h el maestro y A0h y A1h el esclavo. Las interrupciones que uilizaremos son:

![[Pasted image 20231022120850.webp]]


### **Rutinas de atención a interrupciones (ISR)**

Las rutinas de atención a interrupciones son el conjunto de códigos que ejecuta el procesador para atender a cada una de las interrupciones. Teniendo en cuenta la forma en el que el procesador las procesa Cualquier manejo de interrupciones se ha de basar en tres consideraciones:

- Apuntar a la ISR adecuada sustituyéndola en la Tabla de Vectores de Interrupción.

```nasm
xor ax, ax
mov es, ax  
mov ax, dir_rutina  
mov [es: interrupción*4], ax  
mov [es: interrupción*4+2], cs
```

- Verificar si la interrupción manejada genera algún código de error (pop eax) y proceder según eax (código de error)
- En caso de que la interrupción sea de hardware hay que incorporar antes del IRET el EOI.
- Asegurar que se ejecute la instrucción iret que finaliza la ISR y es la encargada de sacar de la pila el estado del procesador anterior al momento de la interrupción, así como la dirección de la instrucción donde la ejecución se había quedado.

Para deshabilitar o habilitar las interrupciones hardware se utiliza la bandera de interrupción, pero el procedimiento más común es mediante las instrucciones:

- CLI: Hace I=0. Se ignoran las interrupciones hardware.
- STI: Hace I=1. Se reconocen las interrupciones hardware.

Entonces las ISR quedan de la siguiente manera

![[Pasted image 20231022120911.webp]]

  
## Temporizador 8253/ 8253

El 8253/4 es un chip temporizador que puede ser empleado como:

- Reloj de tiempo real
- Contador de sucesos
- Generador de ritmo programable
- Generador de onda cuadrada

​​​​​​​![[Pasted image 20231022120936.webp]]


Está conformado internamente por tres contadores. Cada contador tiene conectado como señal de reloj de entrada, cuya frecuencia es Freloj= 1.193180 MHz. Tienen 6 modos posibles de trabajo: 0, 1, 2, 3, 4, 5

- Los modos 0, 1,4 y 5 son como contador.
- Los modos 2 y 3 son modo generador.

El contador 0 funciona como temporizador en la computadora y funciona en el modo 3. Va conectado al IRQ0 del 8259 siendo la interrupción de hardware de mayor prioridad.

![[Pasted image 20231022120946.webp]]


En el modo 3 la salida del C (OUT) va a ‘1’, y cuando el C llega a la mitad del conteo pasa a cero. Cuando el C llega a 0, se recarga automáticamente el valor inicial anterior, la salida cambia a 1 y se repite el ciclo. Así se genera un tren de pulsos.

![[Pasted image 20231022120954.webp]]

El temporizador se programa para generar una señal que interrumpe al microprocesador cada 55 ms. Es decir, generan aproximadamente 18 interrupciones por segundo. Los Sistemas Operativos (SO) actuales no permiten el robo de la interrupción del Timer, con el fin de proteger el sistema.

