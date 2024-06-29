# Probabilidades

**Experimento aleatorio** (E)
No se puede predecir su resultado
- Lanzamiento de una moneda
- Lanzamiento de un dado

**Punto Muestral**
Cada uno de los posibles resultados de un experimento aleatorio

**Espacio Muestral** (S)
Conjunto de todos los **Puntos Muestrales
$S = \{1,2,3,4,5,6\} \text{ o } S = \{n ∈ N | n < 7\}$

**Suceso o evento**
- aleatorio
	Subconjunto de **S**
	$S = \{1,2,3,4,5,6\}$ 
	serian eventos:
	Un numero par: $A = \{2,4,6\}$
	Un numero primo: $B = \{1,2,3,5\}$
	
- cierto, seguro
	Si ocurre necesariamente como resultado del experimento E
	Ej: Al lanzar una moneda salga cara o escudo

- imposible (Ф)
	Nunca ocurre en la realizacion del experimento
	Ej: Al lanzar dos dados, la suma de sus caras mostradas sea el numero 13

## Relaciones entre sucesos

> [!Info] $A + B$ o $A \cup B$ - suma
> Cuando $A \cup B = S$ se dice que los eventos A, B son *exhaustivos* 

> [!Note] $AB$ o $A \cap B = Ф$ - producto
> $AB$ representa el suceso que ocurre si ambos ocurren
> 
> Cuando $A \cap B = Ф$ se dice que los eventos A, B son *mutuamente excluyentes*

> [!Note] $A^c$ - complemento
> "que no ocurra a"
> 
> $A \cup A^c = S$  es exhaustivo
> $A \cap A^c = Ф$  son mutuamente excluyentes
> 

> [!Note] $B \subset A$ - subevento
> B es un subevento de A si para toda ocurrencia de B ocurre A
> Cuando $A \subset B$ y $B \subset A$ entonces $A = B$ son equivalentes


![[venn_diagram.excalidraw]]


### Ejemplo

Tenemos una urna con 9 bolas enumeradas del 1 al 9 y sean los siguientes eventos: 

A: la bola muestre un número par. 
B: la bola muestre un número impar. 
C: la bola muestre un múltiplo de tres. 
D: la bola muestre un múltiplo de cuatro. 
G: la bola muestre un divisor de 24. 

El espacio muestral S del experimento es: $S = \{1, 2, 3, 4, 5, 6, 7, 8, 9\}$

Definamos los eventos tales que: 
- M = la bola sea impar y múltiplo de 3. 
$$M = B \cap C = \{3, 9\}$$
- R = la bola sea par ó múltiplo de tres. 
$$R = A \cup C = \{2, 3, 4, 6, 8, 9\}$$
- T = la bola no muestre un múltiplo de cuatro. 
$$T = D^c = \{1, 2, 3, 5, 6, 7, 9\}$$

exhaustivos 
1. $A \cup B = S$, 
mutuamente excluyentes
1. $A \cap B = Ф$
2. $B \cap D = Ф$

## Leyes de De Morgan

$$(A \cap B)^c = A^c \cup B^c$$
$$(A \cup B)^c = A^c \cap B^c$$



## Definicion clásica
$$P(A) = \frac{N_A}{N}$$
A: suceso
$N_A$: total de resultados favorables a A
$N$: total de posibilidades


> [!Faq] Se aplica a un espacio finito (0 ... 1)
> - Aplicable solo a espacios finitos
> - Los resultados deben ser *equiprobables*
> 
> $$
> P(A) = 
> \left\{ 
>	\begin{array}{lcc} 
>		1 & \text{A es un suceso seguro} & P(A) = \frac{N_A}{N} = \frac{N}{N} = 1  \\ 
>		0 & \text{A es un suceso imposible} & P(A) = \frac{0}{N} = 0 \\ 
>		0 < N_A < N
>		\end{array} 
>	\right.
> $$

## Definicion Estadistica de Probabilidad

Se basa en el concepto de frecuencia relativa de un suceso
$$f_r(A) = \frac{f(A)}{n}$$

$f_r(A)$: frecuencia relativa de ocurrencia de A
$f(A)$: numero de veces que ocurre A
$n$: numero total de repeticiones del experimento

## Axiomas y Teoremas de Probabilidad

Axiomas
1. $0 \le P(A) \le 1$
2. $P(S) = 1$
3. $AB = Ф$ entonces $P(A \cup B) = P(A) + P(B)$

Teoremas
1. $P(A_1 \cup A_2 \cup A_3 \cup ...) = P(A_1) + P(A_2) + P(A_3) + ...$
	siempre que $A_1, A_2, A_3, ...$ sean mutuamente excluyentes entre si
2. $P(A \cup B) = P(A) + P(B) - P(A \cap B)$
3. $P(A^c) = 1 - P(A)$
4. P(Ф) = 0
5. $P(A \cap B^c) = P(A) - P(A \cap B)$
6. $A \subset B$ entonces $P(A) \le P(B)$


## Probabilidad condicional

**Probabilidad condicional de A dado B:**
Cual es la probabilidad de un suceso A si se sabe que ha ocurrido un suceso B

Ej: El muestreo sin reemplazo modifica el espacio muestral, pues el resultado del elemento extraido ya no forma parte del nuevo espacio muestral

> [!Info] $P(A|B)$ Probabilidad de A si ya ha ocurrido B
> $$P(A|B) = \frac{N_{AB}}{N_B} = \frac{P(AB)}{P(B)}; P(B) \ne 0$$
> $$P(B|A) = \frac{N_{AB}}{N_A} = \frac{P(AB)}{P(A)}; P(A) \ne 0$$


## Eventos Independientes
Cuando un evento A no depende de que ocurra un evento B
$$P(A|B) = P(A)$$
$$P(B|A) = P(B)$$

$P(B|A) = \frac{P(AB)}{P(A)}$  <=>  $P(AB) = P(A) * P(B|A)$
$P(A|B) = \frac{P(AB)}{P(B)}$  <=>  $P(AB) = P(B) * P(A|B)$

> [!Faq] Regla general de la multiplicacion de probabilidad
> $$P(A \cap B) = P(A) * P(B|A) \\ = P(B) * P(A|B)$$
> y si A y B son independientes entonces dado que $P(B|A) = P(B)$
> $$P(A \cap B) = P(A) * P(B)$$
> 
> Se puede demostrar que 2 eventos son independientes aplicando lo de arriba

## Probabilidad total

Si los eventos posibles $A_1, A_2, ..., A_n$ son mutuamente excluyentes (la intersección entre ellos es vacía) y exhaustivos (su suma es igual a S), con probabilidades conocidas $P(Ai)$, tales que $\sum_{i=1}^n P(A_i) = 1$

![[Pasted image 20240125221344.webp]]

$$P(B) = \sum_{i=1}^4 P(B|A_i) P(A_i)$$
### Ejemplo

El primer paso consiste en definir los diferentes eventos y designarlos por una letra mayúscula. C → El especialista proviene del centro de desarrollo C. D → El especialista proviene del centro de desarrollo D. E → El especialista proviene del centro de desarrollo E. B → El especialista seleccionado es programador. Veamos que se cumple que: C ∩ D ∩ E = ϕ y que P(C) + P(D) + P(E) = 1, es decir, son mutuamente excluyentes y exhaustivos

El segundo paso es extraer (o calcular) las probabilidades individuales y condicionales: P(C) = 0.60 P(B|C) = 0.45 P(D) = 0.30 P(B|D) = 0.40 P(E) = 0.10 P(B|E) = 0.65 Luego como: B = (B ∩ C) U (B ∩ D) U (B ∩ E) calculando probabilidades en ambos miembros, se tiene: P(B) = P[(B ∩ C) U (B ∩ D) U (B ∩ E)] Y aplicando la Ley de la suma

P(B) = P(B ∩ C) + P(B ∩ D) + P(B ∩ E) = P(C)∙P(B|C) + P(D)∙P(B|D) + P(E)∙P(B|E) = (0.60)(0.45) + (0.30)(0.40) + (0.10)(0.65) = 0.27 + 0.12 + 0.065 = 0.455 Por tanto, la probabilidad de que un especialista del proyecto P sea programador es de 0.455. También podemos expresar la probabilidad en porcentaje. Así, se pudiera responder que los programadores en el proyecto P representan el 45.5% de todos los especialistas


## Fórmula de Bayes.

Es posible calcular la probabilidad condicional de un evento cualquiera perteneciente a una familia de *eventos exhaustivos* y *mutuamente excluyentes*, si sabemos que ha ocurrido un evento B del espacio y conocidas las probabilidades indicadas para el caso anterior. 

Supongamos, del ejemplo anterior, que se seleccionó un especialista programador, pero queremos saber cuál es la probabilidad de que el mismo provenga del centro de desarrollo C. En términos de probabilidad condicional, se pide P(C|B)

Por definición de probabilidad condicional tenemos que



## FALTA