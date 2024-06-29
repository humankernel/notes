- [x] Integral Definida
- [x] Integral Impropia
- [x] Integral Indefinida
- [x] Aplicaciones
	- [x] Area entre 2 curvas (poner el $u^2$)
- [x] Integrales Dobles (e iteradas)
- [x] Aplicaciones IDobles (Volumen, Area)
- [x] Regla Sust y Integracion por partes
 
- [x] Propiedades
- [x] Teorema Fundamental del Calculo
- [ ] Representar Funciones (lineal, cuadratica, cubica, radicales, exp, log, trigo, elipses, circ, hiperb)

- [ ] Campos direccionales 
	- [ ] Como se contruyen 
	- [x] Como se obtiene un segmento 
	- [x] Representar una Solucion Parcial
	- [x] Identificar Solucion de Equilibrio
- [ ] Metodo Euler
	- [ ] interpretacion grafica
- [x] Clasificacion
	- [x] tipo
	- [x] orden
	- [x] grado

- [x] EDO 
	- [x] variables separables
	- [x] exactas
	- [x] lineales
- [x] SG - SP
- [ ] Propiedades de la Solucion
	- [ ] derivada-monotonia
	- [ ] derivada-extremos
	- [ ] derivada-concavidad
	- [ ] derivada-puntoinflexion


## Introduccion: Area Bajo Curva
$$y = x^2$$
$[0, 1]$: intervalo cerrado


Suponga que dividimos S en cuatro franjas, S1, S2, S3 y S4, al trazar las rectas verticales x = 1/4, x = 1/2 y x = 3/4

![[area.webp]]



## Integral Definida
(*Area Debajo de la Curva)

Es definida cuando
- [x] $f$ es continua
- [x] $[a,b]$ cerrado


> [!Definicion]
> Sea $f$ una funcion definida en `[a,b]` cerrado
> 
> $\triangle x = \frac{(b-a)}{n}$
>  $x_i = a + i\triangle x$
>  
>  $$\int f(x)dx = \lim_{n \to \infty} \sum_{i=1}^{n} f(x_i)\triangle x$$
>  
>  Si existe el limite, decimos que $f$ es integrable sobre [a, b].



> [!Note 3] 
> p14 - book
> Si $f$ toma valores tanto positivos como negativos,  entonces la suma de Riemann es la suma de las áreas de los rectángulos que se encuentran arriba del eje x y los negativos de las áreas de los rectángulos que están debajo del eje x (las áreas de los rectángulos en azul menos las áreas de los rectángulos en oro).
> 
> ![[Pasted image 20230924163611.webp]]
> 
> $$\int_a^b f(x)dx = A_1 - A_2$$
> - $A_1$: el area de la region arriba del eje x



> [!Important] Teorema
> Si f es continua sobre `[a, b]`, o si $f$ tiene sólo un número finito de discontinuidades de salto, entonces $f$ es integrable sobre `[a, b]`; es decir, la integral definida $\int_a^b f(x) dx$ **existe**


### Regla del Punto Medio

![[Pasted image 20230924181609.webp]]

### Propiedades Integral Definida

$$\int_b^a f(x) dx = -\int_a^b f(x) dx$$
porque si invertimos a y b entonces $\triangle x = \frac{a-b}{n}$

$$\int_a^a f(x) dx = 0$$
porque $\triangle x = \frac{a-a}{n} = 0$
$$\int_a^b cdx = c(b-a)$$c: constante
porque $c(b-a) = A_\triangle$ 
$$\int_a^b [f(x) \pm g(x)]dx = \int_a^b f(x)dx \pm \int_a^b g(x)dx$$
$$\int_a^b cf(x)dx = c\int_a^b f(x)dx$$

![[Pasted image 20230924183005.webp]]

> [!Info] Propiedades de comparacion
> $f(x) \ge 0$ para $a \le x \le b$ entonces $\int_a^b f(x)dx \ge 0$
> $f(x) \ge g(x)$ para $a \le x \le b$ entonces $\int_a^b f(x)dx \ge \int_a^b g(x)dx$
> $m \le f(x) \le M$ para $a \le x \le b$ entonces $m(b-a) \le \int_a^b f(x)dx \le M(b-a)$


## Integral Impropia

Es **in**definida cuando
- [x] $f$ es continua
- [ ] $[a,b]$ cerrado

$$\int_a^{\infty} 3x + 5 dx$$

![[integrales_indefinidas.excalidraw.svg|300]]
%%[[integrales_indefinidas.excalidraw.excalidraw|🖋 Edit in Excalidraw]], and the [[integrales_indefinidas.excalidraw.dark.svg|dark exported image]]%%


la solucion es en vez de ir de $a \to \infty$ ir de $a \to t$ pero que t se acerque a $\infty$

$$\lim_{t \to \infty} \int_a^t 3x + 5 dx$$

![[integrales_indefinidas2.svg|300]]
%%[[integrales_indefinidas2.excalidraw|🖋 Edit in Excalidraw]], and the [[integrales_indefinidas2.dark.svg|dark exported image]]%%


$$
\begin{align*}
	& \lim_{t \to \infty} \int_a^t 3x + 5 dx \\
	&= \lim_{t \to \infty} [\frac{3}{2}x^2]_5^t  + [5x]_5^t \\
	&= \lim_{t \to \infty} [\frac{3}{2}(t^2 - 25)  + 5(t - 5) \\
	&= + \infty \\
\end{align*}
$$
En este caso dio $+\infty$, lo que significa que no existe esa **Area** 
En caso de dar un numero entonces ese numero seria el **Area**


## Integrales Indefinidas

$$\int x^2 dx = \frac{x^3}{3} + C$$
porque
$$\frac{d}{dx}(\frac{x^3}{3} + C) = x^2$$

![[Pasted image 20230924190327.webp|400]]




## Teorema Fundamental del Calculo

Derivacion y Integracion como procesos inversos

### Parte 1

- [x] $f$ es continua
- [x] $[a,b]$ cerrado
$$\int_a^xf(t)dt = F(x)$$
entonces $F(x)$ es continua y derivable en $[a,b]$ y 
$$F'(x) = f(x) * x'$$
(*se multiplica por $x'$ si el limite superior de la integral es una funcion, seria como una* **regla de la cadena**)

![[Pasted image 20230924183752.webp|400]]


> [!Info]- Ejemplo - P1
> $$\frac{d}{dx}[\int_x^{-3}tan(t^3)dt]$$
> La $x$ tiene que estar arriba y la constante abajo
> Entonces se intercambian (pero cambia el signo)
> $$- \frac{d}{dx}[\int_{-3}^x tan(t^3)dt] = -tan(x^3)$$

> [!Info]- Ejemplo 2 - P1
> $$\frac{d}{dx}[\int_1^{3x^2} e^{sent}dt] = e^{sen(3x^2)} * (3x^2)'$$

### Parte 2

$$\int_a^bf(x)dx = F(b) - F(a)$$

donde $F$ es una *antiderivada* de $f$ osea $F'(x) = f(x)$


> [!Info] Ejemplo - P2
> $$\int_{\frac{\pi}{6}}^{\frac{\pi}{3}} cosx dx = senx ]_{\frac{\pi}{6}}^{\frac{\pi}{3}} = sen(\frac{\pi}{3}) - sen(\frac{\pi}{6}) = \frac{\sqrt{3}}{2} - \frac{1}{2} = \frac{\sqrt{3} - 1}{2}$$


## Tabla de Integrales indefinidas

$\int cf(x)dx = c\int f(x)dx$
$\int [f(x) + g(x)]dx = \int f(x)dx + \int g(X)dx$

$\int kdx = kx+C$ 
$\int x^ndx = \frac{x^{n+1}}{n+1} + C$   $n \ne -1$
$\int e^xdx = e^x + C$

$\int senxdx = -cosx + C$
$\int cosxdx = senx + C$

$\int sec^2xdx = tanx + C$
$\int csc^2xdx = -cotx + C$

$\int secx * tanx * dx = secx + C$
$\int cscx * cotx * dx = -cscx + C$

$\int \frac{1}{x^2 + 1}dx = tan^{-1}x + C$
$\int \frac{1}{\sqrt{1 - x^2}}dx = sen^{-1}x + C$

$\int senhxdx = coshx + C$
$\int coshxdx = senhx + C$

![[Pasted image 20231008114229.webp]]


## Regla de sustitucion


> [!Info] Regla 
> Si $u=g(x)$ es una función derivable cuyo rango es un intervalo `I` y `f` es continua sobre `I`, entonces
> $$\int f(g(x)) g'(x)dx = \int f(u) du$$ 
> porque por la regla de la cadena
> $$\frac{d}{d x}[F(g(x))]=F^{\prime}(g(x)) g^{\prime}(x)$$




Técnica para hallar antiderivadas de integrales no difinidas por las reglas
$$\int 2x \sqrt{1 + x^2}dx$$
usaremos la estrategia para la resolución de problemas de introducir algo adicional.
cambiemos de una variable x a una variable u
$$u = 1 + x^2$$
entonces 
$$du = 2x dx$$
entonces
$$\int 2x \sqrt{1 + x^2}dx$$
$$= \int \sqrt{1 + x^2} 2xdx = \int \sqrt{u} du$$
$$= \frac{2}{3}u^{\frac{3}{2}} + C = \frac{2}{3}(x^2 + 1)^{\frac{3}{2}} + C$$


## Regla de Integracion por Partes


> [!Info] Integracion por Partes (Indefinida)
> 
> $$\int u dv = uv - \int v du$$
> 
> por la regla del producto
> $$\frac{d}{d x}[f(x) g(x)]=f(x) g^{\prime}(x)+g(x) f^{\prime}(x)$$

> [!Info] Integracion por Partes (Definida)
> $$\int_a^b u dv dx = uv\vert_a^b - \int_a^b vdu$$
> formalmente
> $$\int_a^b f(x) g'(x) dx = f(x)g(x)\vert_a^b - \int_a^b g(x)f'(x)dx$$


> [!Info]- Ejemplo
> $$
\begin{array}{l}
\int x \operatorname{sen} x d x \\
u=x \quad d v=\operatorname{sen} x d x \\
d u=d x \quad v=-\cos x \\
-x \cos x-\int-\cos x d x \\
-x \cos x+\int \cos x d x \\
-x \cos x+\operatorname{sen} x+c
\end{array}
$$

> [!Info]- Ejemplo Doble
>$$
>	\begin{array}{l}\int t^2 e^t d t 
>		\\ U=t^2 \quad d v=e^t d t 
>		\\ d u=2 t d t \quad v=e^t 
>		\\ t^2 e^t-\int e^t 2 t d t 
>		\\ t^2 e^t-2 \underbrace{\int e^t t d t} 
>		\\ u=t \quad d v=e^t d t 
>		\\ d u=d x \quad v=e^t 
>		\\ t e^t-\int e^t d x
>		\\ t^2 e^t-2\left[t e^t-e^t\right]+c
>		\\
>	\end{array}$$

> [!Info]- Ejemplo Definida
> $$\int_0^1 tan^{-1}x dx$$
> 
> $u = tan^{-1}x$          
> $du = \frac{dx}{1 + x^2}$        
> $dv = dx$
> $v=x$
> 
> $$\int_0^1 xdx = xtan^{-1}x \vert_0^1 - \int_0^1 \frac{x}{1+x^2} dx$$
> $$= 1 * tan^{-1} - 0 * tan^{-1}0 - \int_0^1 \frac{x}{1+x^2} dx$$
> $$= \frac{\pi}{4} - \underbrace{\int_0^1 \frac{x}{1+x^2}dx}$$
> 
> $u = 1+ x^2$
> $du = xdx$
> ...



## Integracion aproximada (metodos numericos)

Hay dos situaciones en las cuales es imposible encontrar el valor exacto de 
una integral definida

### Regla del Punto Medio

> [!Info] Regla del Punto Medio
> $$\int_a^b f(x) dx \approx \triangle x [f(\bar{x_1}) + f(\bar{x_2}) + ... + f(\bar{x_n})]$$
> donde $\triangle x = \frac{b - a}{n}$
> y $\bar{x_i} = \frac{1}{2}(x_{i-1} + x_i)$

> [!Faq] Error
> Suponga que $|f''(x)| \le K$ para $a \le x \le b$
> $$|E_M| \le \frac{K(b-a)^3}{24n^2}$$


![[Pasted image 20231008130514.webp]]

### Regla del Trapecio

> [!Info] Regla del Trapecio
> $$\int_a^b f(x)dx \approx \frac{\triangle x}{2}[f(x_0) + 2[f(x_1) + ... + f(x_{n-1})] + f(x_n)  ] $$
> donde $\triangle x = \frac{b-a}{n}$
> y $x_i = a + i \triangle x$


> [!Faq] Error
> Suponga que $|f''(x)| \le K$ para $a \le x \le b$
> $$|E_T| \le \frac{K(b-a)^3}{12n^2}$$


![[Pasted image 20231008130549.webp]]


### Regla de Simpson

> [!Info] Regla de Simpson
> $$\int_a^b f(x) dx \approx \frac{\triangle x}{3} [f(x_0) + 4f(x_1) + 2f(x_2) + 4f(x_3) + ... + f(x_n)]$$
> $$\int_a^b f(x) dx \approx \frac{\triangle x}{3} [E + 4I + 2P]$$

> [!Faq] Error
> Suponga que $|f^{(4)}(x)| \le K$  para $a \le x \le b$
> $$|E_S| \le \frac{K(b-a)^5}{180n^4}$$



## Aplicaciones de la Integracion

### Area entre curvas

> [!Info] Area entre curvas
> $y = f(x)$
> $y = g(x)$
> en el intervalo $[a,b]$
> $$f(x) \ge g(x)$$
> $$A = \int_a^b [f(x) - g(x)]dx$$
> poner al final $u^2$


![[Pasted image 20231008144531.webp]]


![[Pasted image 20231008152951.webp]]

$$A = \int_c^d [f(y) - g(y)]dy$$

> [!Info]- Ejemplo - Interesante
> ![[Pasted image 20231105114226.webp]]

### Volumen (Solido en Revolucion)

> [!Info] Volumen
> $$V = \pi \int_a^b f(x)^2 dx  $$


> [!Info]- Ejemplo: Demuestre que el volumen de una esfera de radio `r` es $V = \frac{4}{3} \pi r^3$
> 
> La formula de Volumen 
> $$\pi \int_a^b f(x)^2 dx$$
> 
> $f(x)$ es la altura de las secciones en $x_i$ para hallarla lo hacemos mediante pitagoras 
> - Se sabe que la distancia de la base de este triangulo es $x_i$ 
> - Se sabe que el otro lado es `r` porque siempre es el radio
> Queda 
> $$\sqrt{x^2 - r^2}$$
> 
> Asi que queda
> $$\pi \int_{-r}^r (r^2 - x^2) dx$$
> De `[0, r]` 2 veces
> $$= 2\pi \int_0^r (r^2 - x^2) dx$$
> $$= 2\pi [r^2x - \frac{x^3}{3} \vert_0^r ] = 2\pi (r^3 - \frac{r^3}{3})$$
> $$= \frac{4}{3} \pi r^3$$
> Por lo que se cumple
> 
> ![[Pasted image 20231008154843.webp]]

> [!Info]- Ejemplo: Volumen de la curva $y = \sqrt{x}$ en revolucion
> rango de $[0, 1]$
> $$= \pi \int_0^1 xdx = \frac{1}{2} \pi x^2 \vert_0^1 = \frac{\pi}{2}$$
> 
> ![[Pasted image 20231008164149.webp]]

> [!Info]- Ejemplo: Volumen de solido al girar respecto el eje y
> $$y = x^3$$
> Limitada por $y = 8, x=0$
> 
> Puesto que la region gira alrededor del eje `y`, tiene sentido "rebanar" el solido en forma perpendicular al eje `y` , por tanto, **integrar respecto a y**
> 
> $$\pi \int_0^8 f(y)^2 dy$$
> $$= \pi \int_0^8 (\sqrt[3]{y})^2 dy$$
> $$= \pi [\frac{3}{5}y^{\frac{5}{3}} \vert_0^8 ] = \frac{96\pi}{5}$$
> ![[Pasted image 20231008165302.webp]]

> [!Info]- Ejemplo: Volumen entre 2 curvas de un solido
> 
> La region `R` encerrada por las curvas $y = x$ y $y = x^2$ gira alrededor del eje x
> 
> 1. Se cortan en los puntos $(0, 0)$ y $(1, 1)$
> 2. De modo que queda el area debajo de una - area debajo de otra
> $$\pi \int_0^1 x^2 dx - \pi \int_0^1 x^4 dx$$
> $$= [\frac{1}{3}\pi x^3 - \frac{1}{5} \pi x^5 ]\big\vert_0^1 = \frac{2}{15}\pi$$
> 
> ![[Pasted image 20231008172507.webp]]



### Longitud de Arcos


> [!Info] Regla
> Si $f'$ es continua sobre $[a,b]$, entonces la longitud de la curva $y = f(x)$ es
> $$L = \int_a^b \sqrt{1 + [f'(x)]^2}dx$$
> 
> Si la curva tiene la ecuacion $x = g(y)$ es 
> $$L = \int_c^d \sqrt{1 + [g'(x)]^2}dy$$
> 


![[Pasted image 20231008174035.webp]]

![[Pasted image 20231008173650.webp]]


La longitud L de C es aproximadamente la longitud de este polígono y la aproximación es mejor cuando se incrementa n.

El procedimiento para definir la longitud de arco es muy similar al utilizado para definir área y volumen: se divide la curva en un gran número de partes pequeñas. Luego, se determinan las longitudes aproximadas de éstas y se suman. Por último, se toma el límite cuando $n \to \infty$

La Longitud del arco de $P_{i-1} \to P_i$ se calcula por pitagoras

$$|P_{i-1}P_i| = \sqrt{(x_i - x_{i-1})^2 + (y_i - y_{i-1})^2} = \sqrt{(\triangle x)^2 + (\triangle y_i)^2}$$

???

> [!Info]- (!No entiendo) Ejemplo: Longitud del arco de una parabola semicubica $y^2 = x^3$
> entre los puntos $(1,1)$ y $(4,8)$
> 
> ![[Pasted image 20231008181144.webp]]
> 
> La mitad superior se tiene
> $$y = x^{\frac{3}{2}}$$
> $$\frac{dy}{dx} = \frac{3}{2}x^{\frac{1}{2}}$$
> Por tanto la formula de la longitud del arco da
> $$L = \int_1^4 \sqrt{1 + (\frac{dy}{dx})^2}dx$$
> $$= \int_1^4 \sqrt{\underbrace{1 + \frac{9}{4}x}}dx$$
> $u = 1+\frac{9}{4}x$
> $du = \frac{9}{4}dx$
> 
> cuando $x = 1 \to u=\frac{13}{4}$
> cuando $x = 4 \to u=10$
> 
> $$L = \frac{4}{9} \int_{\frac{13}{4}}^{10} \sqrt{u} du$$
> $$ = \frac{4}{9} * \frac{2}{3} u^{\frac{3}{2}} \big\vert_{\frac{13}{4}}^{10}$$
> $$= \frac{8}{27} [10^{\frac{3}{2}} - (\frac{13}{4})^{\frac{3}{2}}]$$
> $$= \frac{1}{27}(80\sqrt{10} - 13\sqrt{13})$$




## Integrales Dobles Sobre rectangulos

### Volumen
$$\int \underbrace{\int_R f(x,y)} dA = \int_a^b \int_c^d f(x,y) dy dx$$
La integral de adentro se llama **integral iterada**


![[Pasted image 20231015091259.webp]]



Sea $R = [a,b] * [c,d] = \{(x,y) \in R^2 | a \le x \le b, c \le y \le d \}$ la superficie que proyecta la funcion $z = f(x,y)$

Se quiere hallar el volumen definido entre $f$ y $R$


> [!Info]- 1. Se divide $R$ en rectangulos de longitud $\triangle x$ y ancho $\triangle y$ 
> 
> ![[Pasted image 20231015091827.webp]]
> 
> formando asi rectangulos cada uno de area $\triangle A = \triangle x \triangle  y$

> [!Info]- 2. Se elige el **punto muestra** $(x_{ij}^*,y_{ij}^*)$ en cada $R_{ij}$ y la altura de ese rectangulo seria la imagen del punto muestra en la funcion $f(x_{ij}^*,y_{ij}^*)$
> 
> Entonces el volumen seria la base por la altura quedando 
> $$f(x_{ij}^*,y_{ij}^*) \triangle A$$
> 
> Entonces para todos los rectangulos seria
> $$V \approx \sum_{i=1}^m \sum_{j=1}^n f(x_{ij}^*,y_{ij}^*) \triangle A$$
> 
> ![[Pasted image 20231015092342.webp]]
> 
> ![[Pasted_image_20231015093527-removebg-preview.webp]]
> ![[Pasted image 20231015093527.webp]]

> [!Info]- 3. Cuanto mayor crece $n,m$ mejor es la aproximacion
> $$V = \lim_{m,n \to \infty} \sum_{i=1}^m \sum_{j=1}^n f(x_{ij}^*,y_{ij}^*) \triangle A$$


> [!Info] Teorema de Fubine ("reciproco")
> $$\int \int_R f(x,y) dA = \int_a^b \int_c^d f(x,y) dydx = \int_c^d \int_a^b f(x,y) dxdy$$


## Integrales Dobles sobre regiones generales

Suponemos que D es una región acotada, lo que significa que D puede ser encerrada en una región rectangular R como en la figura 2. Entonces se define una nueva función F con dominio R mediante
$$
F(x,y)= 
	\left\{ 
		\begin{array}{lcc} 
		f(x,y) & \text{si } (x,y) \text{ esta en D} \\ 
		0 & \text{si } (x,y) \text{ esta en R pero no en D} \\ \end{array} 
	\right.
$$ 
![[Pasted image 20231015115825.webp]]



![[Pasted image 20231015120142.webp]]


> [!Info] Tipo I: (esta entre las graficas de 2 funciones continuas de x)
> $$\int_a^b \int_{g_1(x)}^{g_2(x)} f(x,y) dydx$$
> $$D = {(x,y) | a \le x \le b, g_1(x) \le y \le g_2(x)}$$ 
> donde $g_1$ y $g_2$ son continuas
> 
> ![[Pasted image 20231015120645.webp]]


> [!Info] Tipo II
> $$\int_c^d \int_{h_1(y)}^{h_2(y)} f(x,y) dxdy$$
> $$D = {(x,y) | c \le y \le d, h_1(y) \le x \le h_2(y)}$$ 
> donde $g_1$ y $g_2$ son continuas
> 
> ![[Pasted image 20231015120950.webp]]
> 


### Propiedades Integrales Dobles
1. $$\int\int_D [f(x) \pm g(x)]dx = \int\int_D f(x)dx \pm \int\int_D g(x)dx$$
2. $$\int\int_D cf(x)dx = c\int\int_D f(x)dx$$
3. Si $f(x,y) \ge g(x,y)$
$$\int\int_D f(x,y) dA \ge \int\int_D g(x,y)dA$$

4. $$\int\int_D f(x,y) dA = \int\int_{D_1} fdA + \int\int_{D_2} fdA$$

![[Pasted image 20231015132901.webp|400]]


5.  Si se integra una funcion constante $f(x,y) = 1$ sobre la region `D` se obtiene el area de `D`
$$\int\int_D 1dA = A(D)$$


