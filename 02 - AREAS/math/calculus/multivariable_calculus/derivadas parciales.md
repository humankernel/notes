---
cards-deck: computer_science::math::calculo_multivariable
---


- Derivadas parciales, interpretación geométrica. 
- Derivadas de orden superior. 
- Derivada direccional. 
- Gradiente


> Las funciones de varias variables la dirección del cambio puede considerarse hacia cualquier otro en los $360^*$, alrededor del mismo

para indicar la dirección usamos le vector unitario de $R^2$ $u=(u_1, u_2)$ 

> la derivada de $z = f(x,y)$ en el punto $P = (a,b)$ en la dirección u
> $D_uf(x,y)$


## Que es una Derivada Parcial? #card 
Las Derivadas en las direcciones que marcan los vectores de base canónica $(1,0)$ y $(0,1)$ se llaman `Derivadas Parciales` de la función en el punto P

![[derivadas parciales.webp]]


1) $u = (1,0)$, representa el cambio en x, mientras que se mantiene fijo en y, ósea $y=b$
$$f_x(a,b) = \lim_{h \to 0} \frac{f(a+h, b) - f(a,b)}{h}$$
2) $u=(0, 1)$ denota el cambio en y, con $x = a$
$$f_y(a,b) = \lim_{h \to 0} \frac{f(a, b+h) - f(a,b)}{h}$$

se denota también por $\frac{\delta f}{\delta x}$, $\frac{\delta f}{\delta y}$, $D_x$, $D_y$, $f_1$, $D_1f$


> REGLA PARA DETERMINAR LAS DERIVADAS PARCIALES DE $z = f(x,y)$ #card
> 1. Para determinar $f_x$, conservar a `y` constante y derivar $f(x,y)$, con respecto a `x`. 
> 2. Para determinar $f_y$, conservar a `x` constante y derivar $f(x, y)$ con respecto a $y$.
^1677961008225

### Ejemplo
::Question
Si $f(x,y) = x^3 + x^2y^3 - 2y^2$   determine $f_x(2,1)$ y $f_y(2,1)$

::Answer
Al considerar `y` constante y derivar con respecto a `x`
$f_x(x,y) = 3x^2 + 2xy^3$
$f_x(2,1) = 3*2^2 + 2*2*1^3 = 16$

Al considerar `x` constante y derivar con respecto a `y`
$f_y(x,y) = 3x^2y^2 - 4y$
$f_y(2,1) = 3*2^2*1^2-4*1=8$


### Interpretación grafica:
es la pendiente de la recta tangente a la curva de intersección de la superficie con el plano $y=2$

![[derivadas parciales-1.webp]]

2) para $f_y$: considere x como constante y derive $f(x,y)$ respecto a $y$
$$f_x = -4y$$
$$= -4(2) = -8$$

es la pendiente de la recta tangente a la curva de intersección de la superficie con el plano x = 1

![[derivadas parciales-2.webp]]


## Derivadas de Orden Superior #card

$f_{xx}, \frac{\delta^2 f}{\delta x^2}, \frac{\delta}{\delta x} ( \frac{\delta f}{\delta x} )$


> NOTA:
> Si las derivadas parciales son a su vez funciones derivables es posible hallar su derivada de orden 2 y así sucesivamente
^1677961008229
$$f(x,y) = x^3+x^2y^3 - 2y^2$$
Derivadas Primeras
$f_x(x,y) = 3x^2 + 2xy^3$           $f_y(x,y) = 3x^2y^2 - 4y$

Derivadas Segundas
$f_{xx}(x,y) = 6x+2y^3$            $f_{xy}(x,y) = 6xy^2$ 
$f_{yx}(x,y) = 6xy^2$               $f_{yy}(x,y) = 6x^2y - 4$ 

![[derivadas parciales 1.webp]]

![[derivadas parciales-3.webp]]

![[derivadas parciales-2 1.webp]]

> Teorema de Clairaut: `suficiente` #card 
> Si $f$ esta definido sobre un disco $D$ que contiene al punto $(a,b)$.
> Si tanto las funciones $f_{xy}$ y $f_{yx}$ son continuas en $D$, entonces:$$f_{xy}(a,b) = f_{yx}(a,b)$$
^1677961008232



## Gradiente #card

> El gradiente de una función es un **vector** que indica `la dirección` y `el sentido` de **máximo crecimiento** de la función en un punto.
> (ósea la dirección a la que debe ir para que `f` aumente mas rápido)
^1677968302158

> NOTA:
> El gradiente es perpendicular a la curva de nivel que pasa por ese punto 
 

![[gradiente.webp]]

> Si $f(x,y)$ es una función de dos variables, su vector gradiente es $$∇f(x,y) = (\frac{∂f}{∂x}, \frac{∂f}{∂y})$$Su valor en el punto $(a,b)$ es:$$∇f(a,b) = (\frac{∂f}{∂x}(a,b), \frac{∂f}{∂y}(a,b))$$


Función vectorial
$$▽ f (x,y) = <f_x(x,y), f_y(x,y)> = \frac{df}{dx}i + \frac{df}{dy}j$$
Función derivada direccional
$$D_u f(x_0, y_0) = ▽ f(x_0, y_0) * u$$


## Derivada Direccional:

> Que es la Derivada direccional? #card
> La derivada direccional es la tasa de cambio de una función multivariable en un punto en la dirección de un vector dado
^1677987339541


> Como se calcula? #card
> El producto escalar del gradiente de la función en ese punto y el 
> vector unitario en la dirección dada. $$∇f(x) • u$$`f`: es una función multivariable
  `u`: es un vector unitario (que representa la dirección en la que queremos calcular la derivada direccional)
  $∇f(x)$: es el gradiente de `f` en el punto `x` 
^1677987339544


> Si f es una función real de 3 variables: #card
> y `u` es un vector unitario $u=a_1i + b_2j + c_3k$ 
> se obtiene:
> $$D_uf(x,y,z) = f_x(x,y,z)a + f_y(x,y,z)b + f_z(x,y,z)c$$
^1677987339546



### Hallar vector unitario $u$ #card

> Usando otro vector $v$:
	$v = <1,6>$
	$|v| = \sqrt{(1)^2 + (6)^2}$
	$u = \frac{v}{|v|}$
^1677987339549

> Si el vector unitario $u$ forma un ángulo $O$ con el eje-x entonces
	$u = <cos O, sen O>$
	$D_u f(x,y) = f_x(x,y) cos O + f_y(x,y) sen O$

![[derivadas parciales-4.webp]]
^1677968302162


### Derivada Direccional Cuando Sera Maxima/Minima #card
1. La derivada direccional 
	$D_u f(x,y) = ▽f(x,y) * u$ será máxima en la dirección y sentido del vector gradiente. 
1. El `valor maximo` de $D_u f(x,y)$ es $|▽f(x_0, y_0)|$ y se obtiene cuando la dirección $u$ coincide con el vector $▽f(x_0, y_0)$
2. El `valor minimo` de la $D_u$ es $-|▽f(x_0, y_0)|$ y ocurre cuando $u$ tiene dirección opuesta al $▽f(x_0, y_0)$
^1677987339552


### Ejemplo $f(x,y) = xy$ 
::Question
Hallar Derivada direccional de `f` $D_u f$ en el punto $P=(1,-1)$ 
en la dirección dada por el vector $v = 3i + 4j$

::Answer
1. Hallar `u` vector unitario: $u = \frac{v}{|v|}$
	el modulo de un vector a partir  es $|v| = \sqrt{(x_2 - x_1) + (y_2 - y_1)}$
	$||3i + 4j|| = 5$
	$u = \frac{3i+4j}{5} = (\frac{3}{5}, \frac{4}{5})$
2. Hallar $fx(1,-1) = -1$  $f_y(1,-1) = 1$
3. Sustituir
	$D_yf(1,-1) = -1(\frac{3}{5}) + 1(\frac{4}{5}) = \frac{1}{5}$





### Ejemplo 4 p930
::Question
Encuentre la derivada direccional de la función $f(x,y) = x^2y^3 - 4y$
en el punto $(2,-1)$ en la dirección del vector $v = 2i+5j$

::Answer
1. calculamos el vector gradiente en $(2,-1)$
	$\nabla f(x,y) = <f_x, f_y> = <2xy^3, 3x^2y^2-4>$
2. `v` no es el vector unitario
	$u = \frac{v}{|v|}$
	$|v| = \sqrt{29}$
	$u = \frac{2*5}{\sqrt{29}} = <\frac{2}{\sqrt{29}}, \frac{5}{\sqrt{29}}>$
3. Calcular la Derivada Direccional
	$D_uf(2,-1) = \nabla f(2,-1) * u = <-4,8> * <\frac{2}{\sqrt{29}}, \frac{5}{\sqrt{29}}>$
	$= \frac{-4*2+8*5}{\sqrt{29}} = \frac{32}{\sqrt{29}}$


### Ejemplo 6 p939
::Question
Si $f(x,y) = xe^y$, encuentre la razon de cambio en `f` en el punto $(2,0)$, en la dirección de `P` a $Q(\frac{1}{2}, 2)$ 

b) en que dirección `f` tiene la maxima razon de cambio? 
c) Cual es esta maxima razon de cambio?

::Answer

1. Calculamos el vector gradiente en $(2,0)$
	$\nabla f(x,y) = <f_x, f_y> = <e^y, xe^y>$
	$\nabla f(2,0) = <1,2>$
2. El vector unitario en la dirección $PQ = <-1.5, 2>$ es $u = <-\frac{3}{5}, \frac{4}{5}>$
3. De modo que la razon de cambio de `f` en dirección de `P` a `Q` es
	$D_uf(2,0) = \nabla f(2,0) * u = <1,2> * <-\frac{3}{5}, \frac{4}{5}>$
	$=1(-\frac{3}{5} + 2(\frac{4}{5}) = 1$

b) `f` se incrementa mas rápido en la dirección del `vector gradiente` $\nabla f(2,0) = <1,2>$ 
c) La razon de cambio maxima es $|\nabla f(2,0)| = |<1,2>| = \sqrt{5}$

