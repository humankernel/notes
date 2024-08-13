# Hard Drives

Un sector es la unidad de almacenamiento físico más pequeña del disco y en la mayoría de los sistemas de archivos tiene un tamaño fijo de 512 bytes
Los sectores se agrupan en clústeres
un clúster es una unidad de memoria más grande cuyo tamaño depende del sistema de archivos en particular que se utilice

![[hard-drives-20240325190051261.webp]]



Otro elemento importante de los discos duros es su formato a bajo nivel donde se define la geometría y la numeración de los sectores y pistas para lograr mejores tiempos de acceso a la información. Técnicas como el desajuste de cilindros, desajuste de cabeza o entrelazado contribuyen a lograr una lectura continua de los datos. Sobre estas y otros elementos del hardware y el software de los discos duros puedes abundar en:


## Request scheduling algorithms

> En un entorno de multiprogramacion existe por cada dispositivo una cola de solicitudes. 
> Estas necesitan ser procesadas por un **planificador**  


> [!info] I/O Time
> El tiempo para leer y escribir en un bloque de disco depende de:
> 1. tiempo de busqueda (el tiempo para desplazar el brazo al cilindro apropiado)
> 2. retraso rotacional (el tiempo para que el sector apropiado se coloque debajo de la cabeza)
> 3. tiempo de transferencia de datos actual

Al reducir el tiempo de búsqueda promedio se puede mejorar el rendimiento del sistema de manera considerable
Todos los algoritmos tienen el **propósito de disminuir el tiempo de búsqueda** de las pistas

![[disk-algos.mp4]]


![[disk-algos.excalidraw|600]]



(IT, cilindro)
**Cola de Peticiones**: EJ: (0, 44), (50, 11), (64, 79), (101, 23), (190, 19)

IT: instante de tiempo
CA: Cilindro Actual
CS: Cilindros Solicitados
CSig: Cilindro Siguiente 
D: Desplazamiento
TS: Tiempo 

$$
\begin{align}
	TS &= \text{despl } * \text{t.cilindros.continuos} + \text{t.latencia-tranf}  \\
	ts &= (d)(tcc)(tlt)
\end{align}
$$

| IT  | CA  | C.Solic | C.Sig | Desplz     | TS               |
| --- | --- | ------- | ----- | ---------- | ---------------- |


### FCFS - First Come First Served

> atiende las solicitudes por orden de llegada 

**Cola de Peticiones**: (0, 44), (50, 11), (64, 79), (101, 23), (190, 19)
**Cantidad de Cilindros**: 100 del 0-99
**Cilindro inicial**: 90
**Tiempo latencia-tranferencia/rotacion**: 10u
**Tiempo cilindros continuos**: 2u

| IT  | CA  | C.Solic    | C.Sig | Desplz     | TS               |
| --- | --- | ---------- | ----- | ---------- | ---------------- |
| 0   | 90  | 44         | 44    | $90-44=46$ | $46*2 + 10= 102$ |
| 102 | 44  | 11, 79, 23 | 11    | 33         | 76               |
| 178 | 11  | 79, 23     | 79    | 68         | 146              |
| 324 | 79  | 23, 19     | 23    | 56         | 122              |
| 446 | 23  | 19         | 19    | 4          | 18               |
| 464 | 19  | --         | --    | --         |                  |
TTotal Servicio = 446


### SSF / SSTF - Shortest Seek-Time First

> Consiste en atender la solicitud cuya pista esté más cerca de la actual posición

> [!error] Inanicion
> Tiene la desventaja que puede crear inanición (“starvation”) para las solicitudes más alejadas de la posición inicial del brazo
> Pues si existe un flujo continuo de nuevas solicitudes, muchas de ellas cercanas a la posición actual, las solicitudes de pistas más alejadas tardarán en atenderse

### Elevador

> [!important] Elevador
> Politica en la cual el cabezal recorre las pistas a todo lo largo 
> **No cambia la direccion de movimiento** hasta llegar al final, entonces es que **invierte** el sentido
> El final es el que varia segun la variante

#### SCAN 

> Empieza en una pista extrema (inicial/ultima) se mueve hacia la otra atendiendo las que esten de por medio 
> Al llegar al otro extremo, invierte el sentido y repite


#### C-SCAN

> Funciona como el SCAN pero **siempre en el mismo sentido** 
> Se mueve de extremo a extremo y luego se vuelve al inicio y se repite 

El C-SCAN parte de la lógica de que las nuevas solicitudes en el extremo inicial deben ser las que más tiempo deben llevar esperando y además de que en esta área es donde debe haber una mayor concentración de solicitudes pendientes


#### LOOK

> optimizacion al SCAN, en vez de llegar al final llega al extremo util


#### C-LOOK 

> Se mueve en un sentido hasta la ultima solicitud en esa direccion. 
> Cuando no quedan vuelve a la primera