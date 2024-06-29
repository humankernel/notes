
* Puntos de extremos y valores extremos de funciones de varias variables.
* `Condición necesaria/suficiente` para la existencia de `puntos de extremos locales`. 
* `Extremos globales` de funciones de varias variables


## Extremos locales de funciones de varias variables

`Puntos de extremos`: 
* `máximo local`: en $(a,b)$ si $f(x,y) \leq f(a,b)$ cuando $(x,y)$ está cerca de $(a, b)$.
* `mínimo local`: en $(a,b)$ si $f(x,y) \geq f(a,b)$ cuando $(x,y)$ está cerca de $(a, b)$.

si $(a,b)$ es un `mínimo/máximo` extremo entonces $f(a,b)$ es el `valor` mínimo/máximo 


![[derivadas - extremos locales y globales.webp]]


> `Condición Necesaria`: para existencia de puntos `extremos locales`
> El punto a evaluar tiene que ser punto critico (raíz de las derivadas parciales)
> $f_x(a,b)=0$ y $f_y(a,b)=0$  o no existen

### Ejemplo
::Question
Determinar los puntos críticos de la función 

$$f(x,y) = 9-2x+4y-x^2-4y^2$$
::Answer
$f_x=-2-2x$   $f_y = 4-8y$

al igualar a 0
$-2-2x=0$  y $4-8y=0$

$x=-1$,  $y=\frac{1}{2}$

El punto critico es $(-1, \frac{1}{2})$



## `Condición Suficiente` para existencia de puntos `extremos locales`

### Prueba de la segunda derivada

> Condiciones Necesarias:
> 1. $(a,b)$ es un punto critico de `f` 
> 	$f_x(a,b) = 0$  y  $f_y(a,b)=0$  
> 1. las segundas derivadas de `f` son continuas

Sea 
$$D = D(a,b) = f_{xx}(a,b)f_{yy}(a,b) - [f_{xy}(a,b)]^2$$
`> > minimo`
`> < Maximo`
`<   ensilladura`

* $D > 0$ y $f_{xx}(a,b) > 0$: entonces $f(a,b)$ es un `mínimo local`
* $D > 0$ y $f_{xx}(a,b) < 0$: entonces $f(a,b)$ es un `maximo local`
* $D < 0$: entonces no es ni máximo ni mínimo
	(en el punto $(a,b)$ se llama punto de ensilladura de `f`)
	ej: $z=y^2 - x^2$ 
	(aquí $f(0,0) = 0$ es un máximo en la dirección del eje x pero mínimo en la dirección del eje y)
	![[derivadas - extremos locales y globales-1.webp]]
* $D = 0$, la prueba no da ninguna información

D se puede escribir como el determinante
$$D = 
\begin{bmatrix}
f_{xx} & f_{xy} \\
f_{yx} & f_{yy}
\end{bmatrix} = f_{xx}f_{yy} - (f_{xy})^2$$


## Extremos globales

Si `f` es continua sobre un conjunto `D` cerrado y acotado en $R^2$
entonces alcanza un valor `maximo absoluto`/`minimo absoluto` en algunos puntos en `D`

Pasos
1. Determinar valores de los `puntos criticos` de `f` en `D`
2. Determinar los `valores extremos` de `f` en la frontera de `D`
3. El mas grande de los pasos `1)` y `2)` es el `máximo absoluto` y el mas pequeño el `minimo absoluto`

### Ejemplo 7 p952

::Question
Encuentre los valores máximo/mínimo absoluto de:
$$f(x,y) = x^2 -2xy + 2y$$
sobre el rectángulo Dominio $D = {(x,y) | 0 \leq x \leq 3, 0 \leq y \leq 2}$
::Answer
![[derivadas - extremos locales y globales-3.webp]]

1. calcular los puntos críticos
	$f_x = 2x-2y = 0$     $f_y = -2x + 2 = 0$
	el único punto critico es $(1,1)$
	$f(1,1) = 1$
2. Observar valores de `f` en la frontera de `D` que son $L_1, L_2, L_3, L_4$
	$L_1$ -> (x,0)
		$f(x,0) = x^2$   $0 \leq x \leq 3$
		es creciente de x
		$f(0,0) < f(3,0)$
		
	$L_2$ -> (3,y) 
		$f(3,y) = 9-4y$   $0 \leq y \leq 2$
		es creciente de -y
		$f(3,0) > f(3,2)$
		
	$L_3$ -> (x,2) 
		$f(x,2) = 2^2 - 4x +4$   $0 \leq x \leq 3$
			   $= (x-2)^2$  
		valor mínimo es $f(2,2) = 0$
		valor máximo es $f(0,2)=4$

	$L_4$ -> (0,y) 
		$f(0,y) = 2y$   $0 \leq y \leq 2$
		valor máximo $f(0,2) = 4$
		valor mínimo $f(0,0)=0$

	Sobre la frontera el valor `mínimo` de `f` es 0 y el `máximo` es 9
3. Comparar `1)` con `2)`

El valor mínimo absoluto es $f(0,0) = f(2,2) = 0$
El valor máximo absoluto es $f(3,0) = 9$


## Questions
::Question
¿Qué es un punto crítico?
::Answer
Es un punto a analizar donde 
$f_x(a,b) = 0$ y $f_y(a,b)=0$ 
o uno de las Derivadas parciales no existe

::Question
Cuál es la condición necesaria para la existencia de puntos de extremos locales?
::Answer
Cuando
$f_x(a,b) = 0$ y $f_y(a,b)=0$ 
o uno de las Derivadas parciales no existe

::Question
Cuál es la condición suficiente para la existencia de puntos de extremos?
::Answer 
Hacer la prueba de la 2da Derivada para determinar si es máximo/mínimo/ensilladura

Es condición necesaria primeramente:
1. Las derivadas 2da sean continuas en $(a,b)$  (ósea existan)
2. $f_x(a,b) = 0$ y $f_y(a,b) = 0$  (ósea $(a,b)$ sea PC)

$D = D(a,b) = f_xx(a,b)f_yy(a,b) - f_{xy}(a,b)^2$

Luego si:
1. $D > 0$, $f_{xx} \geq 0$: `maximo local`
2. $D > 0$, $f_{xx} \leq 0$: `maximo local`
3. $D < 0$: `ensilladura`

::Question
Cuál es el procedimiento para determinar los puntos de extremos locales de una función de dos variables?
::Answer
