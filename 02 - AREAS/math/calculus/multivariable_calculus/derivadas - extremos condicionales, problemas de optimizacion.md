
1. Extremos condicionados.
2. Método de los multiplicadores de Lagrange. 
3. Problemas de optimización.



## ¿Qué es un extremo condicionado?

Cuando `f` una función de `n` variables esta sujeta a una o mas restricciones y se le quiere hallar los puntos extremos. ya que los extremos están sujetos a uno o mas restricciones

Ejemplo
![[derivadas - extremos condicionales, problemas de optimizacion.webp]]

Hay varias curvas de nivel con ecuaciones $f(x,y)=c$,  $c=7,8,9,10,11$

Maximizar $f(x,y)$ sujeta a $g(x,y)=k$ es encontrar el valor mas grande de `c` tal que la curva de nivel $f(x,y)=c$ se interseque con $g(x,y)=k$ 

Esto sucede cuando las curvas se tocan apenas (ósea cuando tienen una `recta tangente` común)

Significa que las rectas normales en $(x_0,y_0)$ donde se tocan son idénticas
De modo que los `vectores gradiente` son paralelos: ósea $\nabla f(x_0,y_0) = \lambda \nabla g(x_0,y_0)$ para algún escalar $\lambda$ 

$\lambda$: es el `multiplicador de Lagrange`


> Esta clase de razonamiento también se aplica al problema de encontrar los valores extremos de $f(x,y,z)$ sujeta a la restricción $g(x,y,z)=k$ 
> Por lo tanto: 
> El punto $(x,y,z)$ esta restringido a estar ubicado en la `superficie de nivel` S con ecuación $g(x,y,z)=k$



En lugar de las curvas de nivel. 
Consideramos las superficies de nivel $f(x,y,z) = c$ y argumentamos que si el valor máximo de `f` es $f(x_0,y_0,z_0)=c$, entonces la superficie de nivel $f(x,y,z)=c$ es tangente a la superficie $g(x,y,z)=k$ y de este modo los vectores gradientes correspondientes son paralelos




## Método de los multiplicadores de Lagrange #card

### funciones de 2 variables:

Para determinar los valores extremos de $f(x,y)$ sujeta a la restricción $g(x,y)=k$, 

Buscamos valores de `x` y `y` tal que:
	$\nabla f(x,y) = \lambda \nabla g(x,y)$   y  $g(x,y)=k$
Esto equivale a resolver 3 ecuaciones con 3 incógnitas
	$f_x = \lambda g_x$   $f_y = \lambda g_y$   $g(x,y)=k$

#### Ejemplo: #card
::Question
Determinar los extremos de la función
$f(x,y) = x^2 + 2y^2 + 1$   sobre la elipse  $x^2 + 4y^2 = 1$
![[derivadas - extremos condicionales, problemas de optimizacion-1.webp]]

::Answer
Usando el Método de multiplicadores de Lagrange:

* buscamos valores de x, y, z, $\lambda$ 
* tal que $\nabla f = \lambda \nabla g$   y   $g(x,y) = 1$

De ahi se obtienen las ecuaciones
	$f_x = \lambda g_x$   $f_y = \lambda g_y$    $x^2 + 4y^2 = 1$
Las cuales se transforman en:
	$2x = 2\lambda x$   $4y = 8 \lambda y$   $x^2 + 4y^2 = 1$

> No existe un método general para resolver este tipo de `sistema no lineal`
> Pero intentar la eliminación de $\lambda$ (valor q no es necesario conocer) nos llevaría a un sistema con solo las variables `x` y `y`

1. $\left.   2x = 2\lambda x \atop   4y = 8\lambda y   \right\}$

2. Multiplicando la 1ra por `4y` y la segunda por `x`
	$\left.   2x(4y) = (4y) 2\lambda x \atop   4y(x) = (x) 8\lambda y   \right\}$
	$\left.  8xy = 8\lambda xy \atop   4xy = 8\lambda xy   \right\}$

3. Restando (1) y (2) tenemos
	$4xy = 0$ 
	$x=0$  y  $y=0$
	$x^2 + 4y^2 = 1$


Si $x=0$
	$4y^2 = 1$
	$y = -\frac{1}{2}$
	$y = \frac{1}{2}$
Se obtiene los puntos $(0,\frac{1}{2})$, $(0,-\frac{1}{2})$

Si $y=0$
	$x^2=1$
	$x=-1$
	$x=1$
Se obtiene los puntos $(-1,0)$, $(1,0)$

Evaluamos la función en esos puntos

	$f(0,-\frac{1}{2}) = \frac{3}{2}$
	$f(0,\frac{1}{2}) = \frac{3}{2}$
	* mínimo condicionado en  $(0,\frac{1}{2})$, $(0,-\frac{1}{2})$

	$f(-1,0)=2$
	$f(1,0)=2$
	* máximo condicionado en $(-1,0)$, $(1,0)$

> Las imágenes son iguales 2a2 porque tanto el paraboloide elíptico como la elipse son simétricos
![[derivadas - extremos condicionales, problemas de optimizacion-2.webp]]


### funciones de `n` variables

Para determinar los valores máximos y mínimos de $f(x,y,z)$ sujeta a la restricción $g(x,y,z) = k$ 
(suponiendo que estos valores existan y que $\nabla g \neq 0$ se encuentre en la superficie $g(x,y,z) = k$)

1) Determine los valores de `x`,`y`,`z`,$\lambda$ tal que:
	$\nabla f(x,y,z) = \lambda \nabla g(x,y,z)$    y    $g(x,y,z)=k$
2) Evalué `f` en todos los puntos $(x,y,z)$ que resulten del paso `1)`
	El mas grande es el `valor máximo` de `f`,
	El mas grande es el `valor mínimo` de `f`,

Si escribimos la ecuación vectorial $\nabla f = \lambda \nabla g$ en términos de sus componentes
$f_x = \lambda g_x$   $f_y = \lambda g_y$   $f_z = \lambda g_z$   $g(x,y,z)=k$

> NOTA:
> Este es un sistema de 4 ecuaciones con 4 incógnitas, pero no es necesario determinar los valores explícitos de $\lambda$

#### Ejemplo 1 p959-960: #card 

::Question
Una caja rectangular sin tapa se hace con $12m^2$ de carton
Calcule el `volumen máximo` de esta caja

::Answer
Buscamos maximizar $V = xyz$ sujeta a la restricción $g(x,y,z) = 2xz+2yz+xy=12$

Usando el `método de multiplicadores de Lagrange`

Buscamos x, y, z, $\lambda$ tal que:
	$\nabla V = \lambda \nabla g$   y  $g(x,y) = 12$
De aquí obtenemos las ecuaciones:
$V_x = \lambda g_x$   $V_y = \lambda g_y$   $V_z = \lambda g_z$   $2xz+2yz+xy=12$

$yz=\lambda (2z+y)$  / * x
$xz=\lambda (2z+x)$  / * y
$xy = \lambda (2x+2y)$  / * z
$2xz+2yz+xy=12$ 

$xyz=\lambda (2xz+xy)$
$xyz=\lambda (2yz+xy)$
$xyz = \lambda (2xz+2yz)$
 
> $\lambda \neq 0$ porque:
> * $\lambda = 0$ implicaría que $yz = xz = xy = 0$
> de acuerdo con la ecuación 1ra, 2da, 3ra y contradice la cuarta

![[derivadas - extremos condicionales, problemas de optimizacion-3.webp]]



#### Ejemplo 4 p960-961

::Question
Determine los puntos sobre la esfera

$x^2 + y^2 + z^2 = 4$ que están mas cercanos y mas lejanos al punto $(3,1,-1)$

::Answer
La distancia desde un punto $(x,y,z)$ al punto $(-3,1,-1)$ es:
$d = \sqrt{(x-3)^2 + (y-1)^2 + (z+1)^2}$

Pero los pasos algebraicos son mas sencillos si maximizamos y minimizamos el cuadrado 
$d^2 = f(x,y,z) = (x-3)^2 + (y-1)^2 + (z+1)^2$

La restricción es que el punto $(x,y,z)$ esta sobre la esfera ósea $g(x,y,z) = x^2 + y^2 + z^2 = 4$


Usando el método de multiplicadores de Lagrange:
$\nabla V = \lambda \nabla g$  ,  $g=4$

Eso da
$2(x-3) = 2x\lambda$ 
$2(y-1) = 2y\lambda$ 
$2(z-1) = 2z\lambda$ 
$x^2 + y^2 + z^2 = 4$

> La manera más sencilla de resolver estas ecuaciones es:
> 1. expresar `x`, `y` y `z` en términos de $\lambda$ a partir de la 1r, 2d y 3r ecuación
> 2. luego sustituir estos valores en la cuarta ecuación. 

Según en la primera ecuación se tiene:
	$x-3=x\lambda$   o   $x(1-\lambda) =3$   o   $x = \frac{3}{1-\lambda}$

![[derivadas - extremos condicionales, problemas de optimizacion-4.webp]]


![[derivadas - extremos condicionales, problemas de optimizacion-5.webp]]

![[derivadas - extremos condicionales, problemas de optimizacion-6.webp]]