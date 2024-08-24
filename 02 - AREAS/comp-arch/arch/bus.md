# Bus

> [!Info]
> Un **BUS** es un camino de comunicación entre dos o más  dispositivos
> Es un medio de transmision compartido. 
> Usualmente está constituido por varias lineas capaces de transmitir senales binarias. 
> Es un conjunto de conexiones físicas que se conectan entre sí, mediante un conjunto de líneas que transmiten señales con funciones específicas

1. **Bus de Datos**: Transporta los datos entre los diferentes componentes del sistema.
2. **Bus de Direcciones**: Lleva las direcciones de memoria donde deben leerse o escribirse los datos.
3. **Bus de Control**: Transmite señales de control que coordinan las actividades del sistema.

![[Pasted image 20230930103732.webp]]

## Clasificacion 

-  Serie y paralelo
	Los buses en serie transmiten bit a bit y los paralelos transmiten varios bits a la vez.

- Multiplexados y no multiplexados
	Realizan diferentes funciones según las necesidades del momento. Ejemplo: bus compartido para direcciones y datos, ahorro en hardware y por tanto en costo.

- Centralizado y distribuido
	Necesidad de determinar qué elemento transmite y cuál recibe. Generalmente es arbitrado por la CPU o procesador.

- Sincrónicos y asincrónicos (temporización)
	Cómo ocurren los diferentes eventos (comienzo, fin,..) implicados en la transmisión de la información. Utilizan una señal de reloj o unas líneas de protocolo.


## Jerarquia

Existen 3 buses

- Local
	micro con la memoria caché y controlador de entrada/salida.

- Sistema o Front Side Bus (FSB)
	el procesador con el chipset
	Este quedó en desuso frente a HyperTransport, Quickpath y actualmente el DMI


- Expansión (bus I/O)
	Une al microprocesador a los conectores entrada/salida y
	A las ranuras de expansión como PCI, USB, SATA, SCSI...

Ordenados segun el numero de lineas de datos que requiere (menor a mayor)
Bus de Expansion
Bus Local
Bus de Sistema


![[Pasted image 20230930104047.webp]]



## Bus del sistema (FSB)

1990

Genera latencia y elevado tiempo de respuesta, generando cuello de botella.

Es el tipo de bus que conecta al microprocesador con el Chipset en los primeros procesadores.

Incluye señales de datos, direcciones y control, así como señales de reloj que sincronizan su funcionamiento

A partir de los procesadores INTEL  Nehalem, y hace tiempo en los de AMD se usan otros tipos de buses como el Intel QuickPathInterconnect, el HyperTransport respectivamente. Actualmente fueron sustituidos por el DMI

![[Pasted image 20230930104508.webp]]

El bus de sistema FSB, en las computadoras modernos fue sustituido por tres tipos de tecnologías:

- Tecnología HyperTransport
- Tecnología QuickPathInterconnect
- Tecnología DMI


## Bus Technologies

### HyperTransport

2 Abril 2001

Existen cuatro versiones 1.x, 2.0, 3.0 y 3.1
Usa Lineas de 32 bits

Soporta conexiones autogestionadas para determinar la velocidad.

Esta es una tecnología de comunicaciones bidireccional, que funciona tanto en serie como en paralelo

Reduce el número de buses y suministra alto rendimiento a las aplicaciones y facilita sistemas de multiprocesadores altamente escalables.

Una conexión universal que está diseñada para reducir el número de buses dentro de un sistema, suministrando un enlace de alto rendimiento a las aplicaciones incorporadas y facilitando sistemas de multiprocesamiento altamente escalables.

El desarrollo de HyperTransport se hizo sobre la base de querer eliminar el Front Side Bus (FSB). No fue hasta la versión 3.0 cuando varios fabricantes de chipsets decidieron utilizar HyperTransport para sustituir el FSB con excelentes resultados

También ha dado grandes resultados en otras implantaciones, tales como interconexiones entre microprocesadores MIPS, servidores, sistemas informáticos de alto rendimiento, y en routers y switches.


### QuickPath Interconnect
2008

El Intel QuickPathInterconnect ("QuickPath", "QPI") es una conexión punto a punto con el procesador desarrollado por Intel para competir con HyperTransport

El QPI reemplazó el Front Side Bus en computadores de escritorio y plataformas Desktop, Xeon e Itanium.


Igual que HyperTransport asume que el procesador tiene el controlador de memoria integrado asi que obliga a los multiprocesadores a usar arquitectura NUMA.

Comprime dos conexiones punto a punto de 20 bits, una para cada dirección.

### DMI
Surge en el 2004 a la par del PCH ICH6

Es un bus de datos aunque también se desarrolla como interfaz para otros buses y como enlace punto a punto de alta velocidad entre dos chips.

Antiguamente, siempre se necesitaba un northbridge y un southbridge para la comunicación completa de cualquier componente con la CPU, así que eliminar uno de ellos era un paso importante para unificar criterios y reducir latencias, aparte de para simplificar las arquitecturas futuras.


DMI o Direct Media Interface por su acrónimo en inglés, y no es más que el enlace entre el procesador y su chip complementario que normalmente es el denominado PCH.

Esta primera DMI 1.0 conseguía como máximo y solo en algunos casos concretos una velocidad de 1 GB/s bidireccional, con la peculiaridad de que se podía ejercer en hasta 4 enlaces al mismo tiempo, por lo que teníamos 4 GB/s bidireccional en tiempo real.
![[Pasted image 20230930105504.webp]]

DMI 2.0
Esta versión no fue tocada por Intel hasta la llegada de DMI 2.0, por lo que se fue adaptando a cada plataforma en diferentes configuraciones. Pero en 2011 y con la nombrada versión de nueva factura 2.0, Intel duplicó la velocidad de transferencia a 2 GB/s con las mismas líneas disponibles y también terminó con el Southbridge como tal, y en cierta manera con el northbridge, dejando un único chip que ahora se denominaba como PCH o Platform Controller Hub, que hacía todas las funciones de ambos, mientras que otras las asumía la CPU.

![[Pasted image 20230930105646.webp]]


DMI 3.0
Arquitectura Broadwell que a su vez se basaba en Skylake

Los PCH determinantes fueron los de la serie 100, donde ya se permitió usar enlaces con transferencias de hasta 8 GT/s para las cuatro líneas y además se amplió la velocidad con el PCH hasta casi los 4 GB/s como enlace directo.

Algunos procesadores de Intel tienen el PCH integrado en el paquete físico como un troquel separado, denominado OPI (Interfaz de interconexión DMI en el paquete) y siguiendo de manera efectiva el diseño de sistema en un chip (SoC).