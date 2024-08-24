---
cards-deck: computer_science::math::calculo
---

---
cards-deck: computer_science==math==calculo
^1677889875799
---

* Maximo/Mínimo
* Problemas de Optimización

Que son los extremos? #card
Los máximos y mínimos de f se llaman valores extremos de f
$f(c) >= f(x)$ para todo x: entonces es un máximo absoluto
$f(c) <= f(x)$ para todo x: entonces es un ^1677889888256
mínimo absoluto


`c` : punto de extremo. 
`f(c)` : extremo de la función (valor extremo de f).

## Ejemplo explicativo
![[extremos.webp]]

`f(1) = 5`: máximo local
`f(-1) = 37`: máximo absoluto (no es local porq esta en un punto extremo)

`f(0) = 0`: mínimo local
`f(3) = -27`: mínimo local y absoluto



## Punto Critico #card

es un $x=c$
$$f'(c) = 0 \text{ | no existe}$$

> Condición necesaria:
> si `f` tiene un mínimo local en $x=c$, entonces c es un numero critico

^1677890332349

::Question
Encuentre los números críticos de $f(x) = x^{\frac{3}{5}} (4-x)$

::Answer
![[derivada - extremos locales y globales. Problemas de optimizacion.webp]]

![[derivada - extremos locales y globales. Problemas de optimizacion-1.webp]]


### Ejemplo: intervalo cerrado #card
1. Hallar los puntos críticos $f' = 0$
2. evaluar estos y el de los extremos de los intervalos

intervalo $[-\frac{1}{2}, 4]$
$$f(x) = x^3 - 3x^2 + 1$$

^1677890332352
$$f'(x) = 3x^2 - 6x$$
$$3x(x-2) = 0$$
puntos críticos:
$x_1 = 0$
$x_2 = 2$
ambos están dentro del intervalo $[-\frac{1}{2}, 4]$

`f (puntos criticos)`
$f(0) = 1$
$f(2) = -3$
`f (puntos extremos)`
$f(-\frac{1}{2}) = \frac{1}{8}$ 
$f(4) = 17$ 

el mayor es $f(4) = 17$ por lo tanto $x=4$ es un máximo absoluto
el menor es $f(2) = -3$ por lo tanto $x=2$ es un mínimo absoluto 

![[derivada - extremos locales y globales. Problemas de optimizacion-2.webp]]








## Maximo/Mínimo Local
### Prueba de la 1ra Derivada $f'$ #card

Se usa para determinar máximos y mínimos locales

- hay un MAXIMO local en x = c: #card
	$f'$ pasa de (+) a (-) en x = c
	
- hay un mínimo local en x = c: #card
	$f'$ pasa de (-) a (+) en x = c,
	
- no hay ningún extremo local en x = c: #card
	$f'$ **NO** cambia de signo en x = c 

![[derivada - extremos locales y globales. Problemas de optimizacion-3.webp]]



### Prueba de la 2da Derivada $f''$ #card

Sirve para hallar también máximos/mínimos sabiendo la concavidad de la función en el punto critico `c`

$f''(c) > 0$, entonces tiene `mínimo` en `x = c`
$f''(c) < 0$, entonces tiene `MAXIMO` en `x = c`

### Ejemplo:

::Question
$f(x) = x^4 - 4x^3 + 3$
a) determinar extremos locales y valores extremos, si existen

::Answer
Prueba de la 1ra Derivada $f'$
$$f'(x) = 4x^3 - 12x^2$$	$$4x^3 - 12x^2 = 0$$$$x_1 = 0, x_2 = 3$$
![[monotonia.webp]]

en $x=0$ no hay cambio de signo por lo que no hay cambio de monotonía, por lo que ese valor **NO** es un extremo
 
$x=3, y = f(3) = -24$ es un extremo, valor mínimo local

	![[derivada - extremos locales y globales. Problemas de optimizacion-6.png]]

## Problemas de Optimización: 

Pasos:
1. Leer detenidamente el problema. 
2. Dibujar un diagrama. 
3. Asignar un símbolo a la cantidad que va a ser maximizada o minimizada y otros símbolos a las cantidades desconocidas. 
4. * Encontrar la relación entre los símbolos identificados. 
5. * Escribir la cantidad a optimizar en función de una sola variable. Hallar su dominio.
6. * Hallar los valores máximo o mínimo absolutos de esta función


### Problema: optimizar cerca
::Question
Un agricultor tiene 2 400 pies de material y quiere construir una barda para cercar un campo rectangular que bordea un río recto, de modo que no necesita barda a lo largo del río. ¿Cuáles son las dimensiones que debe tener el campo para encerrar el área más grande?

::Answer
![[derivada - extremos locales y globales. Problemas de optimizacion-7.webp]]

![[derivada - extremos locales y globales. Problemas de optimizacion-8.webp]]

![[derivada - extremos locales y globales. Problemas de optimizacion-9.webp]]

![[derivada - extremos locales y globales. Problemas de optimizacion-10.webp]]


### Problema: optimizar volumen cilindro

::Question

![[derivada - extremos locales y globales. Problemas de optimizacion-11.webp]]

::Answer
![[derivada - extremos locales y globales. Problemas de optimizacion-12.webp]]

![[derivada - extremos locales y globales. Problemas de optimizacion-13.webp]]

![[derivada - extremos locales y globales. Problemas de optimizacion-14.webp]]
