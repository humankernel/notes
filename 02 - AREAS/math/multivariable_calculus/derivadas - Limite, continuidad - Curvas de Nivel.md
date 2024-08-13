---
cards-deck: computer_science::math::calculo_multivariable
---


* Sistema cartesiano en $R^3$, rectas y planos
* Funciones de varias variables, definición, propiedades
* Limite y continuidad 
* Curvas de nivel



Sistema Cartesiano en $R^3$, rectas y planos
![[derivadas - funciones de varias variables.webp]]

![[derivadas - funciones de varias variables-1.webp]]

Ecuación cartesiana general de un plano:
$$𝐴𝑥 + 𝐵𝑦 + 𝐶𝑧 + 𝐷 = 0$$

## Planos en $R^3$

![[planos_r3.webp]]

![[planos_r3-1.webp]]

![[planos_r3-2.webp]]

![[planos_r3-3.webp]]

![[planos_r3-4.webp]]

![[planos_r3-5.webp]]

![[planos_r3-6.webp]]



## Rectas en $R^3$

Se representa como la intersección de 2 planos
por lo que se denota como un SEL

$$\left.  
Ax + By + Cz + D = 0 \atop  
A_1x + B_1y + C_1z + D_1 = 0
\right\}$$

### Ejemplo
$$\left.  
2x + 3y + z - 2 = 0 \atop  
x + y + 2z - 2 = 0
\right\}$$

![[Pasted image 20230226150226.webp]]



## Función de 2 variables

A cada (x, y) le corresponde 1 y solo 1 numero real imagen

$$f: R^2 → R$$
$$(x,y) → Z = f(x,y)$$

1) $f(x,y) = 3-3x-4y$  $Domf = R^2$

![[derivadas - funciones de varias variables-2.webp]]

2) $f(x,y) = \frac{\sqrt{1-x+y}}{x-3}$   $Domf = \{ (x,y) \in R^2: y \geq x-1 ∧ x \neq 3 \}$
	

![[derivadas - funciones de varias variables-3.webp]]

3) $f(x,y) = \ln(x-y^2 +5y -4)$m     
	$Domf = \{ (x,y) \in R^2 : y^2 - 5y + 4 < x \}$
![[derivadas - funciones de varias variables-5.webp]]



## Limite y Continuidad #card

> El Limite existe si al evaluar en ambas direcciones el limite dio igual
> ej.$$f(x,y) = \frac{x^2 + y^2}{x^2 + y^2 + 1}$$$$\lim_{x \to 0} f(x,0) = \frac{x^2}{x^2+1} = 0$$$$\lim_{y \to 0} f(0,y) = \frac{y^2}{y^2+1} = 0$$


> `f` es continua en $(a, b)$ si el limite existe y:$$\lim_{(x,y) \to (a,b)} f(x,y) = f(a,b)$$



> Condición Suficiente:
> El `limite no existe` si si escojo 2 trayectorias al azar y al evaluar sus limites ambos son diferentes entonces el limite **NO** existe
> 
> El reciproco no se cumple
> (si son iguales no se puede afirmar nada)



Son continuas en su dominio las funciones
* Potenciales, logarítmicas, exponenciales, trigonométricas. 
* Suma y diferencia de funciones continuas. 
* Producto de funciones continuas. 
* Cociente de funciones continuas (excepto cuando el denominador es nulo)


### Ejemplo 1: 
::Question
Calcule el limite para $(0,0)$
$$f(x,y) = \frac{x-y}{x^2 - y^2}$$
::Answer
1. Dominio $$Dom f = \{ (x,y) \in R^2: x \neq y, x \neq -y \}$$
2. Limite $$\lim_{(x,y) \to (0,0)} \frac{x-y}{x^2 - y^2} : \frac{0}{0}$$
$$\lim_{(x,y) \to (0,0)} \frac{x-y}{ (x-y)(x+y)} $$
$$\lim_{(x,y) \to (0,0)} \frac{1}{ x+y} = \infty $$

### Ejemplo 2: 
::Question
Calcule el limite para $(0,0)$
$$f(x,y) = \frac{x^2 - y^2}{x^2 + y^2}$$
::Answer
$$Domf = \{ (x,y) \in R^2 : (x,y) \neq (0,0) \}$$
tiene una discontinuidad en (0,0), hay que evaluar el limite por el eje-x y por el eje-y

$$\lim_{(x,y) \to (x,0)} \frac{x^2 - 0}{x^2 + 0} = 1$$
$$\lim_{(x,y) \to (0,y)} \frac{0 - y^2}{0 + y^2} = -1$$
el limite por lo tanto no existe

### Ejemplo 3: función por intervalos 
::Question
Calcule el limite de la función por intervalos
Evalúe la continuidad en $(0,0)$

$$g(x)= \left\{ 
	\begin{array}{lcc}  
       \frac{x^-y^2}{x^2 + y^2} &   si  & (x,y) \neq (0,0) \\  
       0 &  si & (x,y) = (0,0) \\
     \end{array}  
   \right.$$
   
::Answer
1) existe $g(0,0)$ vale `0` 
$$g(0,0) = 0$$
2) limite por izq
$$\lim_{(x,y) \to (x,0)} = 1$$
3) limite por der
$$\lim_{(x,y) \to (x,0)} = -1$$
Por lo tanto no existe el limite

> El limite tiene que existir y ser igual a lo que se evalúa en la función ósea $$\lim_{(x,y) \to (0,0)} g(x,y) = g(0,0) $$

Conclusion: no es continua en (0, 0)


### Ejemplo: trayectorias
::Question
Evalué el limite de `f` para $(0,0)$

$$f(x,y) = \frac{x^2 - y^2}{x^2 + y^2}$$

::Answer
$$\lim_{(x,y) \to (0,0)} \frac{x^2 - y^2}{x^2 + y^2} : \frac{0}{0}$$

> Dado que da una indeterminación escogemos trayectorias que pasen por el punto $(0,0)$
> $y=x$  y  $y=2x$

> NOTA: 
> Las trayectorias se escogen hasta verificar que 2 de ellas dan como resultado limites diferentes, mientras sean iguales no es conclusivo

![[derivadas - funciones de varias variables 1.webp]]

-> por $y=x$
$$\lim_{(x,y) \to (0,0)} \frac{x^2 - y^2}{x^2 + y^2} = \lim_{x \to 0} \frac{x^2 - x^2}{x^2 + x^2} = 0$$
-> por $y=2x$
$$\lim_{(x,y) \to (0,0)} \frac{x^2 - y^2}{x^2 + y^2} = \lim_{x \to 0} \frac{x^2 - 4x^2}{x^2 + (2x)^2} = \lim_{x \to 0} \frac{-3x^2}{5x^2} = -\frac{3}{5}$$

Son diferentes significa que el limite no existe


## Curvas de Nivel #card

> DEFINICIÓN: 
> Las curvas de nivel de una función `f` de dos variables son las curvas cuyas ecuaciones son: $$f(x,y) = k$$
> k es una constante (en el rango de f)
^1677949378099


Una curva de nivel $f(x,y) = k$ es el conjunto de todos los puntos del dominio de $f$ donde $f$ toma un valor k (ósea donde tiene altura k)

![[derivadas - funciones de varias variables-1.webp]]
