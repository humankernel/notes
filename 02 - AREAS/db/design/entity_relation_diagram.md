
## DER

- Un **campo o atributo** es la unidad menor de informacion sobre un objeto
- Un atributo puede tomar diferentes valores sobre un cierto conjunto que se denomma **dominio**.
- **ocurrencia** del atributo: A un valor de un atributo definido en el dominio dado
- Un `articulo o registro` es una coleccion identificable de campos asociados y representa un objeto con sus propiedades.
- Un archivo o fichero es un conjunto de ocurrencias de un mismo tipo de articulo.
- Existen `asociaciones` o `relaciones` enlazando Ias entidades, que pueden tener o no atributos. Pueden establecerse sobre la misma entidad o sobre entidades diferentes. En una relacion puede participar cualquier cantidad de entidades.
- Las relaciones pueden ser 
	1.  (1:1)
	2. (1:m)
	3. (m:m)
- El MER permite representar logicamente un fenomeno.

 ![[der.svg]]
%%[[der.excalidraw|🖋 Edit in Excalidraw]], and the [[der.dark.svg|dark exported image]]%%

## Llave
`(n:m)`: la combinacion de las 3 llaves no.maquina, id.trab, no.pieza
`(m: 1)`: la llave es la de la entidad del extremo muchos (m)
`(1: 1)`: podria ser cualquiera de las 2

## Cardinalidad

$1:1$
$1:M$
$0:M$
$N:M$

## Generalizacion - Especializacion

La llave de cada especializacion es la misma de la generalizacion

**Generalizacion**: Formar una nueva entidad mediante la union de otras entidades
**Especializacion**: Dividir una entidad en cierto nuero de otras entidades


![[relacion_ternaria.excalidraw.svg]]


Un trabajador puede trabajar en (n) maquinas, produciendo (p) piezas y una pieza puede ser producida por (m) trabajadores en (n) maquinas 



![[generalizacion_especializacion.svg]]
%%[[generalizacion_especializacion.excalidraw|🖋 Edit in Excalidraw]], and the [[generalizacion_especializacion.dark.svg|dark exported image]]%%


El atributo `tipo.trabaj` es una caracterizacion porj `tipo.trabaj=1` es la caracterizacion de la entidad `Administrativo` 

Los atributos de y relaciones de la entidad generalizada son heredados por las entidades especializadas. 

La llave de la una especializacion es la llave de la generalizacion

**Cobertura**: 

La totalidad de las ocurrencias de la generalizacion pueden o no estar contenidas en alguna o algunas de las especializaciones

- Totales 
- Parciales

Una ocurrencia de la generalizada puede o no estar en mas de un conjunto Ti

- Solapadas
- Disjuntas

**Especificacion** 

- (T, S) Total y solapada
- (T, D) Total y disjunta
- (P, S) Parcial y solapada
- (P, D) Parcial y disjunta

En el ejemplo anterios
`T`: (total), ya que todo trabajador es administrativo o dirigente y obrero
`D`: (disjunto), pues un trabajador pertenece solo a una de las especializaciones

![[generalizacion_especializacion2.svg]]
%%[[generalizacion_especializacion2.excalidraw|🖋 Edit in Excalidraw]], and the [[generalizacion_especializacion2.dark.svg|dark exported image]]%%

`P`: (parcial) AlumnoAyudante y Becario es un caso especial, es decir no todos los estudiantes entran en uno de esos 2
`S`: (solapada) Un AlumnoAyudante puede tambien ser Becario



## Agregacion 

La llave de la entidad agregada `Equipo` es la llave de la relacion que la origina, como es (m, n) entonces la llave de obrero + llave de maquina
O puede ser un atributo identificador de la entidad agregada

Los atributos de la relacion pasan a ser los de la entidad agregada

![[agregacion.svg]]
%%[[agregacion.excalidraw|🖋 Edit in Excalidraw]], and the [[agregacion.dark.svg|dark exported image]]%%




## Entidad debil 

Una entidad cuyos atributos no sean suficientes para identificarla se denomina **débil** y su llave esta formada por algun o algunos de sus atributos mas la llave de la entidad que le da Origen. 

Esta relacion es de, a Io sumo, 
`m`: (por el extremo de la débil) 
`1`: (por el extremo de la entidad que la origina).

Ej municipo de provincia si los municipios estan listados autoincrementalmente ya que puede existir el municipio 1 o 3 en cualquier otra provincia

![[Pasted image 20231001170612.webp]]



