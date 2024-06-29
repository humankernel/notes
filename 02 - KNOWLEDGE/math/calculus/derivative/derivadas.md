---
cards-deck: computer_science==math==calculo
---

* Reglas
* Continuidad
* Monotonía
* Derivada Implícita


Ecuación de la recta tangente #card
$$y - f(a) = m(x-a)$$
$$m_{rt} = \lim_{h \to 0} \frac{f(a+h) - f(a)}{h}$$
^1677638116503


Tabla de Derivadas Esenciales #card
| $f(x)$ | $\frac{df}{dx}$  |
| --- | --- |
| c | 0 | 
| x | 1 |
| 3x | 3 |
| $x^m$ | $mx^{m-1}$ |
| $ln(x)$ | $\frac{1}{x}$ | 
| $e^x$ | $e^x$ |
| $sin(x)$ | $cos(x)$ | 
| $cos(x)$ | $-sin(x)$ |
| $tan(x)$ | $sec^2x$ |
^1677638116512


![[derivada_tabla.webp]]


## Ejemplo de la taza 🍵:

Temperatura en función del tiempo de enfriamiento

$$T(t) = 24 + 76e^{-0pBI}$$
| t | T |
|-|-|
| 0 | $100^∘C$ |
| 5 | $75^∘C$ |
| 10 | $58^∘C$ |
| 15 | $47^∘C$ |
| 20 | $39^∘C$ |
| 25 | $34^∘C$ |

![[Pasted image 20230220194510.webp]]

![[Pasted image 20230220194532.webp]]

### Velocidad de enfriamiento
$$V = \frac{\vartriangle T}{ \vartriangle t}$$
* $\vartriangle$ -> variacion
variacion de temp respecto al tiempo

1. Nos paramos en un punto A
![[Pasted image 20230220194901.webp]]

2. luego nos desplazamos variacion de tiempo (20m)
![[Pasted image 20230220195000.webp]]

3. calcular. Da como resultado la velocidad
![[Pasted image 20230220195045.webp]]
> eso es una velocidad promedio 

4. si se traza una linea se optiene una recta [[secante]], su pendiente es esa vel de enfriamiento promedio
![[Pasted image 20230220195149.webp]]

### Se puede saber la velocidad **exacta** en el punto A ?

para eso no es necesario considerar un tiempo tan grande por eso quieres que $\vartriangle t → 0$ (var de tiempo tienda a 0).

$$\vartriangle t → 0 \equiv dt $$
-> si lo movemos acercándolo a cero
![[Pasted image 20230220200118.webp]]

llega un momento donde casi son el mismo y esa recta ahora es tangente
y su pendiente es la vel en ese punto
![[Pasted image 20230220200140.webp]]




$$\frac{\vartriangle T}{\vartriangle t} = Velocidad\ Promedio = Pendiente\ Recta\ Secante$$
$$\frac{d T}{d t} = Velocidad\ Instantanea = Pendiente\ Recta\ Tangente$$


$$\vartriangle T = T (t + \vartriangle t) - T(t) $$
$$\frac{\vartriangle T}{\vartriangle t} = \frac{T (t + \vartriangle t) - T(t)}{\vartriangle t} $$

Dado que la $\vartriangle t$ variación de la temperatura sera tan pequeña casi cero se usa limite

$$\frac{\delta T}{\delta t} = \lim_{\delta t \to 0} \frac{T (t + \delta t) - T(t)}{\delta t} $$
$$\frac{\delta T}{\delta t} = \lim_{h \to 0} \frac{T (t + h) - T(t)}{h} $$
> se lee (la derivada de la Temperatura con respecto del tiempo)




-> Función
$$T(t)$$

-> Velocidad a la que cambia la función al instante 
$$\frac{\delta T}{\delta t}$$



## Continuidad #card

> Teorema: 
> Si la función 𝑓 es derivable en $𝑥 = 𝑎$, entonces 𝑓 es continua en $𝑥 = 𝑎$

> Contrarrecíproco:
> Si `f` NO es continua en un punto `a`, entonces, `f` no es derivable en dicho punto 
^1677638116521

## Derivas de orden superior

$𝑓′′(𝑥) = (𝑓′(𝑥))′ , 𝑓 ′′ ′(𝑥) = (𝑓 ′ ′(𝑥))′ , 𝑓 (𝐼𝑉) (𝑥) = (𝑓′′′(𝑥))′, …, 𝑓 (𝑛) (𝑥) = (𝑓^{(𝑛−1)} (𝑥))′$


## Monotonía #card

$f'(x) > 0$, entonces $f$ es ↗ `creciente`
$f'(x) < 0$, entonces $f$ es ↙ `decreciente`

$f'(x) = 0$  -> Punto Critico

^1677638116527

![[derivada - extremos locales y globales. Problemas de optimizacion-4.webp]]

![[derivada - extremos locales y globales. Problemas de optimizacion-5.webp]]

![[Pasted image 20230220203155.webp]]
![[Pasted image 20230220203214.webp]]


## Reglas de Derivación

### 0) Regla cf(x) [[card]]
$$(cf)′ = cf′$$
^1677638116539

### 1) Regla Suma/Resta [[card]]
$$f(x) = x^2 + sin(x)$$
$$ \frac{d(g + h)}{d x} = \frac{d(g)}{d x} + \frac{d(h)}{d x}$$
^1677638116544

#### Demostración
Dadas 
1. $g(x) = x^2$
2. $h(x) = sin(x)$

![[Pasted image 20230220215519.webp]]

$f(x) = g(x) + h(x)$
$f(x) = x^2 + sin(x)$

![[Pasted image 20230220215645.webp]]

$$ \delta(x^2 + sin(x)) = \delta(x^2) + \delta(sin(x))$$
![[Pasted image 20230220215905.webp]]


### 2) Regla Producto [[card]]
$$\frac{\delta (f*g)}{\delta x} = g \frac{\delta f}{\delta x} + \frac{\delta g}{\delta x}  f$$
-> EJEMPLO
$$f(x) = x^2 * sin(x)$$
$$\frac{\delta (x^2 * sin(x))}{\delta x} = x^2 * \frac{\delta (sin(x))}{\delta x} + sin(x) * \frac{\delta (x^2)}{\delta x} $$
^1677638116550


#### Demostración
![[Pasted image 20230220220911.webp]]

![[Pasted image 20230220221117.webp]]

Hallamos la variación del Area (ósea la derivada de las funciones) que son el rectángulo naranja y violeta
$$\delta A = sin(x) * \delta(x^2) + d(sin(x)) * x^2$$
$$\delta A = sin(x) * (2x* \delta x) * + (cos(x) * \delta x) * x^2$$
$$\delta A = \delta x [ (sin(x) * 2x) + (cos(x) * x^2)  ]$$
$$ \frac{ \delta (x^2 * sin(x))}{\delta x} = sin(x) * 2x + cos(x) * x^2 $$

-> EN RESUMEN
$$ \frac{ \delta (x^2 * sin(x))}{\delta x} = sin(x) * \frac{\delta (x^2)}{\delta x} + \frac{\delta sin(x)}{\delta x} * x^2 $$


>OJO!!: se desprecia ya que el celeste es muy pequeño respecto a los otros 2





### 3) Regla de la Cadena [[card]]
$$f(x) = sin(x^2)$$
$$\frac{d(sin(x^2))}{dx} = \frac{d(sin(x^2))}{dx} * \frac{d(x^2)}{dx}$$
$$\frac{d(sin(x^2))}{dx} = cos(x^2) * 2x$$
^1677638116556

#### Demostración
1.
	$d (x^2) = 2x * d x$
	$d (sin (z)) = cos(z) * d (z)$
2. remplaza z por $x^2$
	$d (sin (x^2)) = cos(x^2) * d (x^2)$
	$d (sin (x^2)) = cos(x^2) * 2x * d(x)$
	$\frac{d (sin (x^2))}{dx} = cos(x^2) * 2x$

la derivada de lo de afuera * la derivada de lo de adentro
	![[Pasted image 20230221121222.webp]]

$$f(x) = ln[sin(x^2)]$$
![[Pasted image 20230221121425.webp]]

$$\frac{d(f)}{dx} = \frac{d(ln(sin(x^2)))}{dx} * \frac{d(sin(x^2))}{dx} * \frac{d(x^2)}{dx}$$
$$\frac{d(ln(sin(x^2)))}{dx} = \frac{1}{sin(x^2)} * cos(x^2) * 2x$$




### 4) Regla del Cociente [[card]]
$$\frac{d(\frac{f}{g})}{dx} = \frac{\frac{df}{dx}g - f\frac{dg}{dx}}{g^2}$$
#### Demostración
$$\frac{f}{g} = f * \frac{1}{g} = f * g^{-1}$$
$$\frac{dx (f*g^{-1})}{dx} = \frac{d(g^{-1})}{dx}f + g^{-1} *\frac{df}{dx} $$
$$ = \frac{d(g^{-1})}{dx}f + \frac{1}{g} * \frac{df}{dx} $$
^1677638116562

-> dado que $\frac{d(x^m)}{dx} = mx^{m-1}$
![[Pasted image 20230221124402.webp]]
$$\frac{d (g^{-1})}{dx} = -1 g^{-1-1}$$
Por regla de cadena o composición:
$$ \frac{d(g^{-1})}{dx} = -1 * g^{-2} * \frac{dg}{dx}$$

-> queda entonces que
$$\frac{d(f*g^{-1})}{dx} = \frac{df}{dx}g^{-1} + f\frac{d(g^{-1})}{dx}$$
$$ = \frac{\frac{df}{dx}}{g} + f(-1*g^{-2}*\frac{dg}{dx})$$
$$ = \frac{\frac{df}{dx}}{g} -  \frac{f * \frac{dg}{dx}}{g^2}$$
$$ = \frac{g*\frac{df}{dx}}{g^2} -  \frac{f * \frac{dg}{dx}}{g^2}$$
$$ = \frac{\frac{df}{dx}}{g} - f \frac{{dg}{dx}}{g^2} $$



## Derivada Implícita #card

`explicita`: $y = 3x^2 -5x + 2$
`implícita`: $y - 3x^2 + 5x - 2 = 0$

^1677638116568


### ejemplos

::Question
Derivada de $3x^2$

::Answer
$6x \frac{dx}{dx} = 6x$


::Question
Derivada de $3y^2$

::Answer
$= 6y \frac{dy}{dx} = 6yy'$


::Question
Derivada de $5x^2 = 3y^3$

::Answer
$= \frac{dx}{dx}10x = 9y^2 \frac{dy}{dx}$
$= 10x = 9y^2 \frac{dy}{dx}$

::Question
Derivada de $x^2 + y^2 = 25$

::Answer
$(x^2 + y^2)' = (25)'$
$2x+2y\frac{dy}{dx} = 0$
$\frac{dy}{dx} = -\frac{x}{y}$


::Question
Derivada de $x^3 + y^3 = 6xy$

::Answer
$(x^3)' + (y^3)' = (6x * y)'$
$3x^2 + 3y^2y' = (6x)'y + 6x(y)'$$
$3y^2y' - 6xy' = 6y - 3x^2$
$y'(3y^2 - 6x) = 6y - 3x^2$
$y' = \frac{6y-3x^2}{3y^2-6x}$




