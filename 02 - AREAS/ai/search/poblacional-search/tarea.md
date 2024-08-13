Teniendo la siguiente población inicial para maximizar la función $(2x+3)x$ en el intervalo $[0..63]$: 
$101011, 111100, 101111, 101001$ 

a) Obtenga la próxima generación aplicando un operador de selección. Indique cómo ocurre el proceso paso por paso.

Utilice la siguiente secuencia de números aleatorios: $0.98, 0.08, 0.50, 0.33, 0.67, 0.82, 0.02, 0.44, 0.78, 0.12, 0.24, 0.81$

b) Mencione los operadores que pueden ser utilizados para realizar el cruzamiento y la mutación.

## Selección

Se calcula la función de fitness y la probabilidad de selección para hacer la ruleta en este caso

| individuos | X   | $(2x+3)x$ | Probabilidad de Seleccion | Cant Esperada |
| ---------- | --- | --------- | ------------------------- | ------------- |
| 101011     | 43  | 3827      | 0.198                     | 0.792         |
| 111100     | 60  | 7380      | 0.383                     | 1.532         |
| 101111     | 47  | 4559      | 0.236                     | 0.944         |
| 101001     | 41  | 3485      | 0.181                     | 0.724         |

**Parámetros de la población**: 
Suma: 19,251
Promedio: 4,812.75
Maximo: 7380


**intervalos de selección**:
$[0 - 0.198)$
$[0.198 - 0.581)$
$[0.581 - 0.817)$
$[0.817 - 1)$

números aleatorios: ($0.98, 0.08, 0.50, 0.33$) 
resultado: ($4, 1, 2, 2$)


**nueva población**

| individuos | X   | $(2x+3)x$ |
| ---------- | --- | --------- |
| 101001     | 41  | 3485      |
| 101011     | 43  | 3827      |
| 111100     | 60  | 7380      |
| 111100     | 60  | 7380      |
**Parámetros de la población**: 
suma: 22,072
promedio: 5,518.0
máximo: 7380

## Cruzamiento

Se crean intervalos de cruze para saber que pares se cruzan luego se determina el punto de cruze en este caso

$PC = 0.8$
$[0 - 0.8)$: se cruza   
$[0.8 - 1)$: no se cruza
números aleatorios: ($0.67, 0.82$)

| individuos | X   | $(2x+3)x$ | se cruza? |
| ---------- | --- | --------- | --------- |
| 101001     | 41  | 3485      | si        |
| 101011     | 43  | 3827      |           |
| 111100     | 60  | 7380      | no        |
| 111100     | 60  | 7380      |           |

se puede usar:
- un punto
- uniforme
- mas de un punto de cruze

$PPC = \frac{1}{5} = 0.2$
numero aleatorio: ($0.02$)

| gen | intervalo     |
| --- | ------------- |
| 2   | $[0 - 0.2)$   |
| 3   | $[0.2 - 0.4)$ |
| 4   | $[0.4 - 0.6)$ |
| 5   | $[0.6 - 0.8)$ |
| 6   | $[0.8 - 1)$   |

| cadenas a cruzar | punto de cruze | fragmento 1 | frag 2 | nuevo individuo |
| ---------------- | -------------- | ----------- | ------ | --------------- |
| 101001           | 2              | 1           | 01001  | 101011          |
| 101011           | 2              | 1           | 01011  | 101001          |

**nueva población** 

| individuos | X   | $(2x+3)x$ |
| ---------- | --- | --------- |
| 101001     | 41  | 3485      |
| 101011     | 43  | 3827      |
| 111100     | 60  | 7380      |
| 111100     | 60  | 7380      |
**Parámetros de la población**: 
suma: 22,072
promedio: 5,518.0
máximo: 7380

## Mutación

Se eligen los individuos que se mutaran y luego el gen que mutara

$PM = 0.2$
$[0 - 0.2)$: muta    
$[0.2-1)$ no muta
números aleatorios: ($0.44, 0.78, 0.12, 0.24$)

| individuos | X   | $(2x+3)x$ | muta? |
| ---------- | --- | --------- | ----- |
| 101001     | 41  | 3485      | no    |
| 101011     | 43  | 3827      | no    |
| 111100     | 60  | 7380      | si    |
| 111100     | 60  | 7380      | no    |

se puede usar:
- cambio de bit
- mutación binaria
- mutación binaria variante probabilística

$PGM = \frac{1}{6} = 0.166$
numero aleatorio: $0.81$ 

| gen | intervalo       |
| --- | --------------- |
| 1   | $[0 - 0.16)$    |
| 2   | $[0.16 - 0.32)$ |
| 3   | $[0.32 - 0.48)$ |
| 4   | $[0.48 - 0.64)$ |
| 5   | $[0.64 - 0.8)$  |
| 6   | $[0.8 - 1)$     |

| cadenas a mutar | muta? | gen que muta | individuo nuevo |
| --------------- | ----- | ------------ | --------------- |
| 101001          | no    |              |                 |
| 101011          | no    |              |                 |
| 111100          | si    | 6            | 111101          |
| 111100          | no    |              |                 |

**nueva población** 

| individuos | X   | $(2x+3)x$ |
| ---------- | --- | --------- |
| 101001     | 41  | 3485      |
| 101011     | 43  | 3827      |
| 111101     | 61  | 7625      |
| 111100     | 60  | 7380      |
**Parámetros de la población**: 
suma: 22,317
promedio: 5,579.25
máximo: 7625
