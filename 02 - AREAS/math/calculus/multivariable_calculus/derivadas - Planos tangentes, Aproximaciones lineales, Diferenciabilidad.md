---
cards-deck: computer_science::math::calculo_multivariable
---

* Planos tangentes
* Aproximaciones lineales
* Diferenciabilidad de una función de varias variables. Diferencia total, formas diferenciales

Sí, eso es correcto. La diferencial total representa el cambio en el valor de la función cuando todas las variables independientes cambian simultáneamente en una pequeña cantidad. Por otro lado, el plano tangente representa una aproximación lineal de la función en un punto dado. Ambas ecuaciones son útiles para aproximar el comportamiento de una función cerca de un punto dado.


## Planos tangentes #card

![[derivadas - Planos tangentes, Aproximaciones lineales, Diferenciabilidad.webp]]
^1677692539357

> En general, una ecuación del `plano tangente` a la grafica de una 
> función `f` de 2 variables en el punto $(a,b,f(a,b))$ es: $$L(x,y) = a(x-x_0) + b(y-y_0) + z_0$$$$L(a,b) = f_x(a,b)(x-a) + f_y(a,b)(y-b) + f(a,b)$$
> Función lineal (aprox lineal del plano tangente de `f` en $(a,b)$):
> $$f(x,y) \approx L(a,b)$$

### Explicación:
* una superficie S -> $z=f(x,y)$ 
* con un punto $P(x_0, y_0)$
* $C_1$ y $C_2$ dos curvas que pasan por el punto `P`

La ecuación de cualquier plano que pasa por el punto $P(x_0,y_0,z_0)$
1. $$A(x-x_0) + B(y-y_0) + C(z-z_0) = 0$$
2. al dividir por C y hacer $a=-\frac{A}{C}$, $b=-\frac{B}{C}$
$$z-z_0 = a(x-x_0) + b(y-y_0)$$
3. la ecuación representa al plano tangente en `P`

> al hacer $y=y_0$:
> $z-z_0 = a(x-x_0)$  ->  $a=f_x(x_0,y_0)$
> (representa la recta tangente $T_1$)

> al hacer $x=x_0$:
> $z-z_0 = b(y-y_0)$  ->  $b=f_y(x_0, y_0)$
> (representa a la recta tangente $T_2$)



## Aproximación Lineal #card

> visto como linealización de `f` (ósea aproximación lineal) $$L(a,b) = f_x(a,b)(x-a) + f_y(a,b)(y-b) + f(a,b)$$donde $f(x,y) \approx L(x,y)$ para puntos en un entorno de $(x_0,y_0)$
^1677692539369

> IMPORTANTE:
> Para poder usar el plano tangente como una linealización se debe cumplir el teorema que dice que $f_x$ y $f_y$ tienen que ser continuas

### ejemplo 1 p916 #card

::Question
Calcule el plano tangente al paraboloide elíptico en el punto $(1,1,3)$
$$z=2x^2 + y^2$$
^1677692539376


::Answer
ecuación del plano tangente en el punto $(1,1,3)$
$$z-z_0 = f_x(x_0,y_0)(x-x_0) + f_y(x_0,y_0)(y-y_0)$$
$f_x(x,y) = 4x$        $f_y(x,y) = 2y$
$f_x(1,1) = 4$         $f_y(1,1)=2$
$$z-3 = 4(x-1) + x(y-1)$$
$$z=4x+2y-3$$


Aproximación lineal o linealización de `f` en $(1,1)$
$L(x,y) = 4x+2y-3$
$f(x,y) \approx 4x + 2y -3$ cerca de $(1,1)$


## Diferenciabilidad

> Criterio Diferenciabilidad: (suficiente) #card
> Si $f_x$ y $f_y$ existen cerca de $(a,b)$ y son continuas en $(a,b)$, 
> entonces `f` es diferenciable en $(a,b)$
> 
> OJO:
> Es posible que una función diferenciable tenga derivadas parciales discontinuas

#### Ejemplo 2 p895

::Question
Demuestre que $f(x,y) = xe^{xy}$ es `diferenciable` en $(1,0)$
Y determine su linealización. Luego úsela para aproximar $f(1.1 , -0.1)$

::Answer
> si puedes calcular las derivadas parciales de una función en un punto, entonces eso significa que existen en ese punto. 
> Una vez que tienes las derivadas parciales, puedes verificar si son continuas en un entorno del punto. 
$$f(x,y) = xe^{xy}$$
$f_x(x,y) = e^{xy} + e^{xy}xy$     $f_y(x,y) = x^2e^{xy}$
$f_x(1,0) = 1$                     $f_y(1,0)=1$


Ambas derivadas parciales son `funciones continuas` para todo $(x,y)$ porque están `compuestas` por `funciones elementales` que son continuas en todo su dominio (la `función exponencial` y las `funciones polinómicas` son continuas en todo su dominio). 
Por lo tanto, las derivadas parciales de $f(x,y)$ son continuas para todo $(x,y)$

> $f_x$ y $f_y$ son funciones continuas, por lo que `f` es diferenciable


La Linealización es:
$$L(x,y) = f(1,0) + f_x(1,0)(x-1) + f_y(1,0)(y-0)$$
$$= 1 + 1(x-1) + 1 * y$$
$$=x+y$$

La aproximación lineal correspondiente es:
$$xe^{xy} \approx x + y$$
de modo que $f(1.1, -0.1) \approx 1.1 - 0.1 = 1$

Comparando con el valor real
$f(1.1, -0.1) = 1.1e^{-0.11} \approx 0.98542$


### Diferencial

## Diferencial Total `dz/df` #card:

> La Diferencial Total representa el cambio en el valor de la función cuando todas las variables independiente cambian simultáneamente en una pequeña cantidad

Sea `f` una función diferenciable:
$$\triangle f \approx df = f_xdx + f_ydy$$

`dz`, `df`: Diferencial Total 
$dx = \triangle x = (x-a)$
$dy = \triangle y = (y-b)$



$dz$: representa el cambio en altura del plano tangente
$\triangle z$: representa el cambio en la altura de la superficie 
cuando $(x,y)$ para de $(a,b)$ -> $(a + \triangle x, b + \triangle y)$

![[derivadas - Planos tangentes, Aproximaciones lineales, Diferenciabilidad-1.webp]]


> Aproximación Lineal en Notación de Diferenciales: #card $$f(x,y) \approx f(a,b) + dz$$


### ejemplo 4 p897
::Question
1. Determine la diferencial de `dz` si $z = f(x,y) = x^2 + 3xy - y^2$

2. Si `x` cambia de 2 -> 2.05 y `y` cambia de 3 -> 2.96 compare los valores de $\triangle z$ y $dz$

::Answer
1. $dz = f_x(x,y)dx + f_y(x,y)dy$
	 $= (2x + 3y)dx + (3x - 2y)dy$
	 
	 $dx = 0.05$
	 $dy = -0.04$

   $dz = [2(2) + 3(3)]0.05 + [(3(2) - 2(3))](-0.04)$
     $= 0.65$
2. $\triangle z = f(2.05, 2.96) - f(2,3)$
	  $ = 0.6449$
	$\triangle z \approx dz$




### ejemplo 5 p921
::Question

Un cono tiene circular recto
`r`: radio 10cm
`h`: altura 25cm
con un posible error de medición de 0.1 en ambos

Halle el máximo error en el volumen calculado

::Answer
$$V = \frac{\pi r^2 h}{3}$$
$$dV = V_r dr + V_h dh$$
$$= \frac{500\pi}{3}(0.1) + \frac{100\pi}{3}(0.1) = 20 \pi$$
Por lo tanto, el error máximo en el volumen es de casi $20\pi cm^3$


### ejemplo 6 p921
::Question
Las dimensiones de una caja rectangular son
`75`, `60`, `40cm` y cada medida no difiere `0.2 cm` del valor real.

Estime el error mas grande posible cuando el volumen de la caja se calcula a partir de estas medidas

::Answer
$$V = xyz$$
$$dV = V_x dx + V_y dy + V_z dz$$
$$\triangle V \approx dV =1980 cm^3$$

## Formas diferenciales: #card

> Son las expresiones con la forma de un diferencial $$g(x,y)dx + h(x,y)dy$$
> Para que exista una función $f(x,y)$ cuyo diferencial es de la forma $g(x,y)dx + h(x,y)dy$ debe cumplirse #card $$g_y = h_x$$se dice que la forma diferencial es exacta


No cualquier forma diferencial es el diferencial de una función.
a) $(2xy + 1)dx + x^2dy$
	Si
b) $xy^2 dx + (x + y)dy$
	No


Para $(2xy+1)dx + x^2 dy$ se puede verificar que
$$\frac{dg}{dy} = 2x = \frac{dh}{dx}$$
lo que no se cumple en el inciso `b)`


