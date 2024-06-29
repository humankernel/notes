> [!Faq]- Ejemplo de ED
> - EDO
> 1. $y' + 2y = 3x$
> 2. $3y'' + 8y + \frac{1}{2}y' = 0$
> - ED en DP
> 1. $z, \frac{\delta z}{\delta x}, \frac{\delta^2 z}{\delta x^2}, x, y$


La **rapidez de crecimiento de la población** es la derivada $\frac{dP}{dt}$ es proporcional al tamaño de la población, se escribe
$$\frac{dP}{dt} = kP$$
**k**: constante de proporcionalidad


## Clasificacion
- tipo 
	- Ordinaria
	- Derivadas Parciales
- orden (ej: $y''$ es de orden 2)
- grado (ej $(\frac{d^2x}{dt^2})^4$ es de grado 4)

## Solucion General 
*una familia de curvas

Resolver una ED es encontrar una funcion que cumpla con $y' - y = 0$ 

$$
\begin{align*} 
	y’ - y &= 0 \\ 
	y’ &= y \\ 
	\frac{dy}{dx} &= y \\ 
	\frac{dy}{y} &= dx \\
	\int\frac{1}{y}dy &= \int dx \\ 
	lny &= x + C \\
	e^{lny} &= e^{x + C} \\ 
	y &= e^x + \underbrace{e^C} \\ 
	y &= ke^x \quad , e^C = k: k > 0  \\ 
	y’ &= ke^x: \text{Solucion General} \\
	y' - y &= 0
\end{align*}
$$

![[Pasted image 20231030130947.webp]]
 

> [!Info]- Dada la EDO de 1r orden (variables NO separables)
> $$2y' + 3y = x + 1$$
> 1. Despejas $y'$
>    
> $$
> \begin{align*}
> y'  &= \frac{x + 1 - 3y}{2} \\
> \frac{dy}{dx}  &= \frac{x + 1 - 3y}{2}
> \end{align*}
> $$
>
> 2. Intentamos separar las variables
> $$\frac{dy}{dx}  = \frac{x + 1}{2} - \frac{3y}{2} $$






## Campos direccionales 

Grafico que muestra segmentos de **pendientes** de las rectas tangentes de las soluciones particulares que existen para una ecuacion diferencial


![[Pasted image 20231108142801.webp|400]]

Campo direccional que pasa por el punto $(0, 1)$

La solucion de equilibrio es donde tienden todas las soluciones parciales en el caso de esa grafica es una asintota obliqua

## Metodo de Euler

Los valores aproximados para la solucion del problema con valor inicial 
$y' = F(x,y)$  y   $y(x_0) = y_0$ con tamano de paso $h$, en $x_n = x_{n-1} + h$ son
$$y_n = y_{n-1} + hF(x_{n-1}, y_{n-1}) \quad n = 1,2,3,...$$

> [!Info] Ejemplo
> ![[Pasted image 20231108145944.webp|400]]
   ![[Pasted image 20231108145954.webp|400]]

## Ecuaciones variables separables

Es de variables separables cuando se puede escribir de esta forma
$$\frac{dy}{dx} = g(x)f(x)$$

Aislar las variables independientes
$$\frac{dy}{f(y)} = dxf(x)$$
$$\int \frac{1}{f(y)}dy = \int f(x)dx$$


> [!Info] Ejemplo
> $$\frac{dy}{dx} = \frac{x^2}{y^2}$$
> 1. Hacer que cada lado este en funcion de una sola variable
>  $$y^2 dy = x^2 dx$$
>  2. Integrar ambos miembros
> $$
> \begin{align*} 
> 	\int y^2 dy &= \int x^2 dx \\
> 	\frac{1}{3}y^3 &= \frac{1}{3}x^3 + c \\
> \end{align*}
> $$
> 3. Despejar `y`
> $$
> \begin{align*} 
> 	y &= \sqrt[3]{x^3 + 3c} \\
> 	K &= 3c \\
> 	y &= \sqrt[3]{x^3 + K} \quad \to \text{SG} \\
> \end{align*}
> $$
> Valores Iniciales
> $$
> \begin{align*} 
> 	\text{para} \quad y(0)&=2 \\
> 	\sqrt[3]{K} &= 2 \\
> 	K &= 8 \\
> 	y &= \sqrt[3]{x^3 + 8} \quad \to \text{SP}
> \end{align*}
> $$


## Ecuaciones exactas

Cuando se expresa en la forma 

$$M(x, y)dx + N(x, y)dy = 0$$
y se cumple que 
$$\frac{d(M)}{dy} = \frac{d(N)}{dx}$$


> [!Info] Forma 'Corta'
> $$(y+2)dx + (x+y^2)dy = 0$$
> 1. Comprobar que sea ED Exacta
>  $$
> \begin{align*}
> 	\frac{dM}{dy} &= \frac{dN}{dx} \\
> 	\frac{d(y+2)}{dy} &= \frac{d(x+y^2)}{dx} \\
> 	1 &= 1 \\
> \end{align*}
> $$
> 2. Integrar M y N
> $$
> \begin{align*}
> 	\int M dx &= \int y+2 dx = xy+2x \\
> 	\int N dy &= \int x+y^2 dy = xy + \frac{y^3}{3} \\
> \end{align*}
> $$
> 3. Hacer $f(x, y) = c$ donde $f(x, y) = \int M dx \cup \int N dy$ (los **repetidos** solo una vez)
> $$
> \begin{align*}
> 	f(x, y) &= xy + 2x + \frac{y^3}{3} \\
> 	f(x, y) &= C \\
> 	xy + 2x + \frac{y^3}{3} &= C \quad \to \text{SG} \\
> \end{align*}
> $$




> [!Info] Forma "Larga"
> $$(y+2)dx + (x+y^2)dy = 0$$
> 1. Comprobar que sea ED Exacta
> $$
> \begin{align*}
> 	\frac{dM}{dy} &= \frac{dN}{dx} \\
> 	\frac{d(y+2)}{dy} &= \frac{d(x+y^2)}{dx} \\
> 	1 &= 1 \\
> \end{align*}
> $$
> 2. Derivar una de las 2 (el resultado es f)
> $$
> \begin{align*}
> 	\int y + 2 dx &= xy + 2x + g(y) \\
> 	f(x,y) &= xy + 2x + g(y)
> \end{align*}
> $$
> 3. Derivar f
>  $$\frac{df}{dy} = x + g'(y)$$
> 4. igualo la otra a esto
> $$
> \begin{align*}
> 	x + y^2 &= x + g'(y) \\
> 	y^2 &= g'(y) \\
> 	\int y^2 &= \int g'(y) \\
> 	\frac{y^3}{3} &= g(y) \\
> \end{align*}
> $$
> 5. sustituir g en f
>  $$
> \begin{align*}
> 	f(x,y) &= xy + 2x + g(y) \\
> 	\frac{y^3}{3} &= g(y) \\ \\
> 	
> 	f(x,y) &= xy + 2x + \frac{y^3}{3} + C \\
> 	f(x,y) &= C \\
> 	xy + 2x + \frac{y^3}{3} &= C \\
> \end{align*}
> $$


## Ecuaciones lineales

Es lineal cuando se puede escribir de esta forma
$$\frac{dy}{dx} + P(x)y = Q(x)$$


> [!Info] Ejemplo 
> $$
> \begin{align*} 
> 	y' + \frac{1}{x}y &= 2 \\
> 	I = e^{\int P(x) dx} &= e^{\int \frac{1}{x}dx} = e^{lnx} = x \\
> 	\frac{dy}{dx} + \frac{1}{x}y &= 2 \\
> 	P(x) = \frac{1}{x} &\quad Q(x) = 2 \\ \\
> 	y * I &= \int Q(x) I dx \\
> 	yx &= \int 2x dx \\
> 	yx &= x^2 + c \\
> 	y &= \frac{x^2}{x} + \frac{c}{x} \\
> 	y &= x + \frac{c}{x} \quad \to \text{SG} \\
> \end{align*}
> $$


