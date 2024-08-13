
* Derivada de funciones compuestas de varias variables. Regla de la cadena. 
* Derivada de funciones implícitas


## Regla de la Cadena

> CASO 1: #card
> Sea $z = f(x,y)$, $x = g(t)$, $y=h(t)$
> $$\frac{dz}{dt} = \frac{\partial f}{\partial x}\frac{dx}{dt} + \frac{\partial f}{\partial y}\frac{dy}{dt}$$

> CASO 2: #card
> Sea $z = f(x,y)$, $x = g(s,t)$, $y=h(s,t)$
> $$\frac{dz}{dt} = \frac{\partial z}{\partial x}\frac{dx}{dt} + \frac{\partial z}{\partial y}\frac{dy}{dt}$$$$\frac{dz}{ds} = \frac{\partial z}{\partial x}\frac{dx}{ds} + \frac{\partial z}{\partial y}\frac{dy}{ds}$$

> GENERAL: #card 
> Suponga que `u` es una función diferenciable de las `n` variables $x_1,x_2,...,x_n$ y cada $x_j$ es una función diferenciable de las `m` variables $t_1,t_2,...,t_m$. Entonces `u` es una función de $t_1,t_2,...,t_m$ $$\frac{\delta u}{\delta t_i} = \frac{\delta u}{\delta x_1}\frac{\delta x_1}{\delta t_i} + \frac{\delta u}{\delta x_2}\frac{\delta x_2}{\delta t_i} + ... + \frac{\delta u}{\delta x_n}\frac{\delta x_n}{\delta t_i}$$
> para cada $i = 1,2,...,m$


Arbol de dependencia funcional
![[derivadas - regla cadena funciones implicitas.webp]]
`x` y `y` variables intermedias
`t` variable independiente

### Ejemplo 1 p925
::Question
Determine la de derivada de `z` en función de `t` donde $t=0$

$z=x^2y + 3xy^4$
$x=sen(2t)$
$y=cos(t)$


::Answer
Regla de la cadena
$$\frac{dz}{dt} = \frac{\delta f}{\delta x}\frac{dx}{dt} + \frac{\delta f}{\delta y}\frac{dy}{dt}$$

$\frac{\delta f}{\delta x} = 2xy+3y^4$    $\frac{dx}{dt} = 2cos(2t)$

$\frac{\delta f}{\delta y} = x^2 + 12xy^3$   $\frac{dy}{dt} = -sen(t)$


$$\frac{dz}{dt} = (2xy+3y^4)(2cos(2t)) + (x^2 + 12xy^3)(-sen(t))$$
$$\frac{dz}{dt}|_{t=0} = (0+3)(2cos0) + (0+0)(-sen0) = 6$$
 



### Ejemplo 3 p926 
::Question
Halle la derivada de `z` en función de `s` y de `z` en función de `t`
$z = e^x seny$ 
$x=st^2$
$y=s^2t$

::Answer

![[derivadas - regla cadena funciones implicitas-1.webp]]

Regla de la cadena
$$\frac{\delta z}{\delta s} = \frac{\delta z}{\delta x}\frac{\delta x}{\delta s} + \frac{\delta z}{\delta y}\frac{\delta y}{\delta s}$$
$$\frac{\delta z}{\delta s} = e^x sen(y) t^2 + e^xcos(y)2st$$


$$\frac{\delta z}{\delta t} = \frac{\delta z}{\delta x}\frac{\delta x}{\delta t} + \frac{\delta z}{\delta y}\frac{\delta y}{\delta t}$$
$$\frac{\delta z}{\delta s} = e^x sen(y) 2st + e^xcos(y)s^2$$





### Ejemplo 4 p904
![[derivadas - regla cadena generalizada, funciones implicitas.webp]]
## Derivadas de funciones implícitas 

> Se supone que una ecuación de la forma $F(x, y) = 0$ define a 
> `y`: en forma implícita como una función diferenciable de `x` es decir, $y = f(x,)$ 
> donde $F(x, f(x)) = 0$ para toda `x` en el dominio de `f`. 
> 
> Si `F` es diferenciable, aplica el `caso 1` de la `regla de la cadena` para diferenciar ambos miembros de la ecuación $F(x, y) = 0$ con respecto a `x`
> Puesto que tanto `x` como `y` son funciones de `x` obtiene: $$\frac{\delta F}{\delta x}\frac{dx}{dx} + \frac{\delta F}{\delta y}\frac{dy}{dx} = 0$$
> $\frac{dx}{dx} = 1$, y si $\frac{\delta F}{\delta y} \neq 0$ se resuelve $\frac{dy}{dx}$: $$\frac{dy}{dx} = - \frac{\frac{\delta F}{\delta x}}{\frac{\delta F}{\delta y}} = -\frac{F_x}{F_y}$$


> Teorema de la función implícita: #card 
> Si `F` esta definida en un disco que contiene `(a,b)` donde:
> * $F(a,b) = 0$
> * $F_y(a,b) \neq 0$
> * $F_x$, $F_y$ son continuas en el disco
> entonces $F(x,y)=0$ define `y` como función de `x` cerca del punto `(a,b)`

> Teorema de la función implícita: #card 
> Si `F` esta definida dentro de una esfera que contiene `(a,b,c)` donde:
> * $F(a,b,c) = 0$
> * $F_z(a,b,c) \neq 0$
> * $F_x$, $F_y$, $F_z$ son continuas dentro de la esfera
> * entonces $F(x,y,z) = 0$ define `z` como función de `x` cerca del punto `(a,b,c)`



> $F(x,y,z) = 0$
> Podemos usar la regla de la cadena para derivar esto $$\frac{dF}{dx}\frac{dx}{dx} + \frac{dF}{dy}\frac{dy}{dx} + \frac{dF}{dz}\frac{dz}{dx} = 0$$pero $\frac{dx}{dx}=1$ y $\frac{dy}{dx}=0$   ($\frac{dy}{dx} = 0$ porque `x` e `y` son variables independientes por lo que `y` no cambia respecto de `x`)
> 
> Queda: $$\frac{dF}{dx} + \frac{dF}{dz}\frac{dz}{dx} = 0$$si $\frac{dF}{dz} \neq 0$   despejamos $\frac{dz}{dx}$ $$\frac{dz}{dx} = - \frac{\frac{dF}{dx}}{\frac{dF}{dz}} = -\frac{F_x}{F_z}$$$\frac{dz}{dy}$ se obtiene de modo semejante $$\frac{dz}{dy} = - \frac{\frac{dF}{dy}}{\frac{dF}{dz}} = - \frac{F_y}{F_z}$$



> Aspectos fundamentales de las funciones implícitas
> 1. la ecuación debe estar inicialmente igualada a 0 para determinar la función `F`
> 2. no toda ecuación $F(x,y) = 0$ o $F(x,y,z) = 0$ define una variable como función implícita de otra
> 3. se asumirá que estas condiciones se satisfacen
> 4. asumiremos que la derivada del denominador es $\neq 0$



### Ejemplo 8 p306 #card 
::Question
Determine `y'` si $x^3 + y^3 = 6xy$

::Answer
dado que piden `y'` de esta función que esta implícita se aplica el teorema
$$F(x,y) = x^3 + y^3 - 6xy = 0$$
$$\frac{dy}{dx} = -\frac{F_x}{F_y} = -\frac{3x^2 - 6y}{3y^2 - 6x} = -\frac{x^2 - 2y}{y^2 - 2x}$$




### Ejemplo 9 p307
::Question
Determine $\frac{\delta z}{\delta x}$ y $\frac{\delta z}{\delta y}$ si $x^3 + y^3 + 6xyz = 1$

::Answer
sea $F(x,y,z) = x^3 + y^3 + 6xyz - 1$

$$\frac{\delta z}{\delta x} = -\frac{F_x}{F_z} = -\frac{3x^2 + 6yz}{3z^2 + 6xy}$$
$$\frac{\delta z}{\delta x} = -\frac{F_x}{F_z} = -\frac{3y^2 + 6xz}{3z^2 + 6xy}$$
