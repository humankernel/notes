---
cards-deck: computer_science::math::calculo
---


* Aproximaciones lineales 
* Diferenciales
* Aproximación polinomial (Taylor Series)
* Método de Newton-Raphson para resolver ecuaciones no lineales.


## Aproximación Lineal #card

> Básicamente consiste en usar la propia $f'$ como función para conseguir una aproximación de $f(a)$, siempre y cuando `a` este proximo al punto de tangencia
^1677863633429

$$f(x) \approx L(x) = f(a) + f'(a)(x - a)$$

![[aplicaciones_lineales.webp]]
^1677863600380

> NOTA:
> Linealización de la función es lo mismo que aproximación lineal


### Ejemplos
::Question
Encuentre la linealización de la función $f(x) = \sqrt{x+3}$ en $a=1$
úsala para obtener una aproximación de los números $\sqrt{3.98}, \sqrt{4.05}$ 

::Answer
$f(x) = \sqrt{x+3}$
$f'(x) = \frac{1}{2} (x+3)^{-\frac{1}{2}} = \frac{1}{2\sqrt{x+3}}$

calculamos la aproximación lineal L(x)

$f(1) = 2$ y $f'(1) = \frac{1}{4}$

$L(x) = f(a) + f'(a)(x-a)$
$L(x) = f(1) + f'(1)(x-1) = \frac{7+x}{4}$


la aproximación lineal corresponde
$f(x) \approx f(a) + f'(a)(x-a)$ 
$\sqrt{x+3} \approx \frac{7+x}{4}$  cuando x esta cerca de 1
$\sqrt{3.98} \approx \frac{7+0.98}{4}$ 
$1.9949 \approx 1.995$


![[derivada - aplicaciones lineales.webp]]

![[derivada - aplicaciones lineales - tabla.webp]]


## Diferencial #card 

La diferencial de una función es `dy`: 
	$dy = (y)' * dx$
	$dy = (y)'^1677863861518
 * \triangle x$

$dy \approx \triangle y$ -> la diferencial de la variable dependiente
$dx = \triangle x$ -> la diferencial de la variable independiente

Interpretación geométrica:

![[diferencial_grafica.webp]]

> Teorema: #card
> Para que `f` sea diferenciable en un punto `x`, es necesario y suficiente que $f(x)$ tenga derivada finita $f'(x)$ en ese punto
^1677863817786


> Teorema: #card 
> Si `f` es diferenciable en el punto dado, es continua en ese punto


### $dy \approx \triangle y$ #card 

> 1. mejora a medida que $\triangle x$ se hace mas pequeña
> 2. es mas fácil calcular $dy$ que $\triangle y$
^1677864288093

::Question
Compara el valor de $dy$ y $\triangle y$
$$f(x) = x^3 + x^2 - 2x + 1$$

::Answer
1. $x = a$  cambia de 2 -> 2.05

$$\triangle y = f(x + \triangle x) - f(x)$$
$$= 9.717625 - 9$$
$$= 0.717625$$


$$dy = f' * dx$$
$$= (x^3 + x^2 - 2x +1)' * \triangle x$$
$$ = (3x^2 + 2x - 2) * 0.05 $$
$$ = (3(2)^2 + 2(2) - 2) * 0.05 $$
$$ = 0.7 $$

$$\triangle y \approx dy$$
$$0.717625 \approx 0.7$$

2. 1. $x = a$  cambia de 2 -> 2.01

$$\triangle y = f(x + \triangle x) - f(x)$$
$$= 0.140701$$


$$dy = f' * dx$$
$$ = (3(2)^2 + 2(2) - 2) * 0.01 $$
$$ = 0.14 $$


$$\triangle y \approx dy$$
$$0.140701 \approx 0.14$$



### L(x) (approx. lineal) en notación de diferenciales #card
$$f(x) \approx L(x) = f(a) + f'(a)(x-a)$$se escribirse:
$$f(a+dx) \approx f(a) - dy$$
^1677864288096


Ejemplo #card:
$$f(x) = \sqrt{x+3}$$
$$dy = f'(x) dx = \frac{dx}{2\sqrt{x+3}}$$
si $a = 1$ y $dx = \triangle x = 0.05$ entonces:
$$dy = \frac{0.05}{2\sqrt{1+3}} = 0.0125$$
$$f(1.05) \approx f(1) + dy = 2.0125$$


## Problema: error de radio #card

::Question
Se midió el radio de una esfera y se encontró que es 21 cm con un posible error en la medición de cuanto mucho 0.05 cm. 
¿Cuál es el `error máximo` al usar este valor del radio para calcular el volumen de la esfera?
^1677889515335

![[derivada - aplicaciones lineales-1.webp]]

![[derivada - aplicaciones lineales-2.webp]]



## Polinomio de Taylor (aproximación polinomial) #card

Método para la aproximación de una función usando un polinomio con características similares a las de la función cercanas a $x=a$

![[derivadas - aproximacion lineales.webp]]
$$T_n(x) = \sum_{i=0}^{n} \frac{f^i (a)}{i !} (x-a)^i$$
$$T_n(x) = f(a) + f'(a)(x-a) + \frac{f''(a)}{2!}(x-a)^2 + ... + \frac{f^n(a)}{n!}(x-a)^n$$
^1677889515339

[▷ Polinomio de Taylor: fórmula y ejemplos - Estudyando](https://estudyando.com/polinomio-de-taylor-formula-y-ejemplos/)


## Método de Newton-Raphson para resolver ecuaciones no lineales

El método de Newton-Raphson es un algoritmo iterativo utilizado para hallar las raíces de una función. 

Es un método iterativo que utiliza la derivada de la función para mejorar la precisión de la estimación de la raíz en cada iteración
Para encontrar el máximo o mínimo de una función, encontrando los ceros de su primera derivada


Para aplicar el método de Newton-Raphson, sigue estos pasos:

Escoge un $x_0$
$$x_{\text{nuevo}} = x_{\text{viejo} - \frac{f(x_{\text{viejo}})}{f'(x_{\text{viejo}})}}$$


> IMPORTANTE!!
> Tener en cuenta que este método no está garantizado su `convergencia global`
> 
> La única manera de alcanzar la convergencia es seleccionar un valor inicial lo suficientemente cercano a la raíz buscada
