## Succession

*Una sucesión se puede pensar como una lista de números escritos en un orden definido*:
$$a1, a2, a3, a4, ..., an, . . .$$

![[Pasted image 20230926173050.webp]]


> [!EJEMPLO]- Encuentre la Sucesion
> Encuentre una fórmula para el término general an de la sucesión
> $$\frac{3}{5}, -\frac{4}{25}, \frac{5}{125}, -\frac{6}{625}$$
> 
$-1^{n-1}$: para hacer que sea negativa alternante
$$a_n = (-1)^{n-1} \frac{n+2}{5^n}$$


> [!INFO] Definicion
> Una sucesion `{a_n}` tiene el **limite** L si podemos hacer que los terminos de $a_n$ se aproximen a L tanto como se quiera tomando n lo suficientemente grande
> 
> $$\lim_{n \to \infty} a_n = L$$
> 
> **Converge**:  El limite existe y es un numero


## Relacion asintotica
$a_n = (2n - 1)!$
$b_n = (2n + 1)!$
$$
\begin{equation}
\lim_{n \to \infty}\frac{a_n}{b_n} \\
= \lim_{n \to \infty}\frac{(2n - 1)!}{(2n + 1)!} \\
= \lim_{n \to \infty}\frac{(2n - 1)!}{(2n -1)!(2n)(2n + 1)} \\ 
= \lim_{n \to \infty}\frac{1}{(2n)(2n + 1)} = 0
\end{equation}
$$

entonces
$$a_n = O(b_n)$$
porque 
$O(b_n) \gt O(a_n)$



## Propiedades
$$
\begin{equation}
 \lim_{n \to \infty} a_n = 
  \begin{cases} 
   L & L=0 \text{:infinitesimal} \\
   \infty & \text{:infinito} \\
   NE & \text{alterna} \\
  \end{cases}
\end{equation}
$$

$\lim_{n \to \infty}\frac{L1}{\infty} = 0$               $\lim_{n \to \infty}\frac{L1}{0} = \infty$
$\lim_{n \to \infty}(a_n \pm \infty) = \pm \infty$

Sea {$a_n$}, {$b_n$} sucesiones **convergentes** y c una constante

$\lim_{n \to \infty}(c * a_n) = c * \lim_{n \to \infty}a_n$
$\lim_{n \to \infty} (a_n \pm b_n) = L_1 + L_2$          
$\lim_{n \to \infty}(a_n * b_n) = L_1 * L_2$
$\lim_{n \to \infty}(\frac{a_n}{b_n}) = \frac{L_1}{L_2}$                 si  $\lim_{n \to \infty}b_n \ne 0$
$\lim_{n \to \infty}(a_n^p) = [\lim_{n \to \infty}a_n]^p$   si  $p \gt 0$ and $a_n \gt 0$
$$
\begin{equation}
 \lim_{n \to \infty} (a_n)^{b_n} = 
  \begin{cases} 
   0 & \text{si } (L^{-\infty})  \\
   0 & \text{si } (\infty^{-L}) \\
   0 & \text{si } (-\infty^{-\infty}) \\
  \end{cases}
\end{equation}
$$

> [!FAQ]- Formas Indeterminadas
> $$\frac{\infty}{\infty}, \frac{0}{0}, \infty - \infty, 0 * \infty, 1^\infty, \infty^0, 0^0$$

> [!INFO]- Ordenes de Complejidad
> $$
> \log(n) \lt 
> n^{p \gt 1} \lt 
> a^n :(a \gt 1) \lt
> n! \lt
> n^n$$


> [!INFO] Teorema: Sucesiones Alternantes
> $$\lim_{n \to \infty}|{a_n}| = 0$$
> entonces 
> $$\lim_{n \to \infty}{a_n} = 0$$


> [!Ejemplo]- Calcula el limite de una Serie alternante:
> $$\lim_{n \to \infty}\frac{(-1)^n}{n} = ?$$
> 1. Calculamos el limite del valor absoluto
> $$\lim_{n \to \infty}|\frac{(-1)^n}{n}| = lim_{n \to \infty}\frac{1}{n} = 0$$
> Entonces **CONVERGE**


> [!Teorema]
> Si $\lim_{n \to \infty}a_n = L$ y la funcion $f$ es continua en $L$, entonces
> $$\lim_{n \to \infty}f(a_n) = f(L)$$

> [!Ejemplo]-
> $$a_n = \frac{1}{n}$$
> Dado que 
> $$\lim_{n \to \infty}{a_n} = 0$$
> 
> Sea
> $$f(x) = x^2$$
> $$f(a_n) = (\frac{1}{n})^2$$
> $$\lim_{n \to \infty}f(a_n) = f(\lim_{n \to \infty}a_n)$$
> 
> OSEA $$\lim_{n \to \infty} \frac{1}{n^2} = [\lim_{n \to \infty} (\frac{1}{n})]^2$$

> [!TIP]
> Si tengo $$\lim_{n \to \infty}sen(\frac{\pi}{n})$$ 
> evaluas el limite de la funcion interna
> $$\lim_{n \to \infty}\frac{\pi}{n} = 0$$
> y luego a eso le hallas la imagen
> $$sen(0) = 0$$


> [!Teorema]
> $$\begin{equation}
 \lim_{n \to \infty} r^n = 
  \begin{cases} 
   \infty & \text{si } r > 1 \\
   0 & \text{si } 0 < r < 1 \\
  \end{cases}
  \end{equation}$$



## Monotonia

> [!Sucesion Creciente/Decreciente]
> {$a_n$}: Creciente si $a_n \lt a_{n+1}$
> 
> Es **Monotona** si es creciente o decreciente

> [!Ejemplo]- Demuestre que es decreciente
> Demuestre que $a_n = \frac{n}{n^2 + 1}$ es decreciente para $n \ge 1$
> 
> Comprobar que $a_{n+1} \lt a_n$
> $$\frac{n+1}{(n+1)^2 + 1} \lt \frac{n}{n^2 + 1}$$
> $$(n+1)(n^2 + 1) \lt n((n+1)^2 + 1)$$
> $$n^3 + n^2 + n + 1 \lt n^3 + 2n^2 + 2n$$
> $$1 \lt n^2 + n$$
> entonces efectivamente se cumple lo que se asumio 
> 
> **OJO** solo para $n \ge 1$


## Acotada

> [!Definicion] 
> Una sucesion {$a_n$} esta 
> 
> **ACOTADA** por arriba si existe un **M** tal que $a_n \le M$: $n \ge 1$
> **ACOTADA** por abajo si existe un **m** tal que $m \le a_n$: $n \ge 1$
> 
> Si esta acotada por arriba y por abajo entonces {$a_n$} es una **sucesion acotada**

> [!Ejemplo]- Diga si es acotada
> $a_n = \frac{n}{n + 1}$ para $n \ge 1$ esta acotada?
> 
> limite superior = $\lim_{n \to \infty} a_n = 1$
> limite inferior = $n = 1$:  $a_1 = \frac{1}{2}$
> 
> Tiene cota superior e inferior por lo tanto esta acotada



> [!Important]
> NO toda **sucesion acotada** es convergente
> 
> $$a_n = (-1)^n$$
> satisface $-1 \le a_n \le 1$ pero es **divergente**
> 
> NO toda **sucesion monotona** es convergente
> 
> Si es **monotona** y **acotada** entonces es **CONVERGENTE**






## Series Numéricas

Si tratamos de sumar los términos de una sucesión infinita $\{a_n\}_{n=1}^\infty$ , obtenemos una expresión de la forma
$$a_1 + a_2 + a_3 + ... + a_n + ...$$
Se denomina **SERIE** y se denota
$$\sum_{n=1}^\infty a_n$$

> [!INFO] Definicion
> Data una serie 
> $$\sum_{n=1}^\infty a_n = a_1 + a_2 + ...$$
> Y sea $S_n$ la n-esima suma parcial 
> $$S_n = \sum_{i=1}^n a_i = a_1 + a2 + ... + a_n$$
> 
> Si la sucesion $\{S_n\}$ es convergente y $\lim_{n \to \infty}S_n = s$ existe, entonces la serie $\sum a_n$ es **CONVERGENTE**
> 
> `s`: la suma de la serie


> [!INFO]-
> Si se suprime o agrega un numero finito de terminos al inicio **SE MANTIENE** el caracter
> $$\{a_n, 3, 4, 5, ..., n, ...\}$$


### Serie Geometrica
Sea $a \ne 0$
$$a + ar + ar^2 + ar^3 + ... + ar^{n-1} + ... = \sum ar^{n-1}$$

> [!INFO] Convergente si $|r| \lt 1$
> $$\sum_{n=1}^\infty ar^{n-1} = \frac{a}{1-r}$$
> 
> Si $|r| \ge 1$ entonces es **DIVERGENTE**



> [!Ejemplo]- Ejemplo de Serie Geometrica
> $$\sum \frac{1}{2^{n-1}} = \sum (\frac{1}{2})^{n-1}$$
> `a`: 1
> `r`: $\frac{1}{2}$
> 
> Entonces dado que
> $$|r| > 1$$
> $$0 < \frac{1}{2} < 1$$
> Es **CONVERGENTE**


> [!Ejemplo]- Una serie geometrica mas dificil
> $$\sum 3^{2n} 2^{1-n}$$
> $$= \sum 9^n * \frac{2^1}{2^n}$$
> $$= \sum 2 * (\frac{9}{2})^n$$
> `a`: 2
> `r`: $\frac{9}{2}$
> 
> Dado que
> $$|\frac{9}{2}| \gt 1$$
> 
> Entonces es **DIVERGENTE**


### Serie Armonica

Siempre **DIVERGE**

$$\sum \frac{1}{n} = 1 + \frac{1}{2} + \frac{1}{3} + ... + \frac{1}{n} + ...$$

### Serie P

**CONVERGE** si $p \gt 1$

$$\sum \frac{1}{n^p} = 1 + \frac{1}{2^p} + \frac{1}{3^p} + ... + \frac{1}{n^p} + ...$$


> [!INFO] Teorema $\sum a_n$ es convergente cuando
> Si  $\sum a_n$ es convergente entonces  $\lim a_n = 0$
> 
> el reciproco no se cumple


> [!INFO] Prueba de Divergencia
> Si $\sum a_n \ne 0$ o NE entonces es **DIVERGENTE**

> [!Ejemplo]- Esta serie es divergente
> $$\sum \frac{3n^2}{5n(n-1)} = \frac{3}{5}$$
> $$lim = \frac{3}{5} \ne 0$$
> 
> Es **DIVERGENTE**



> [!INFO] Prueba de la Integral
> Suponga que $f$ es una función 
> 1. **continua**
> 2. **positiva** y 
> 3. **decreciente** en $[1, \infty)$ . 
>  
> En tal caso la serie es convergente si y sólo si la integral impropia es convergente. 
> 
> $$
> \begin{equation}
 \int_1^\infty f(x)dx = 
  \begin{cases} 
   \text{Converg} & \text{entonces } \sum_{n=1}^\infty a_n & \text{Converg} \\
   \text{Diverg} & \text{entonces } \sum_{n=1}^\infty a_n & \text{Diverg} \\
  \end{cases}
  \end{equation}
  $$



## Criterios de Convergencia

### Criterio de Comparacion
La idea es comparar una serie dada con una serie que ya se sabe que es convergente o divergente
$$\sum_{n=1}^\infty \frac{1}{2^n + 1}$$
se parece a la serie geometrica 
$$\sum_{n=1}^\infty \frac{1}{2^n}$$
`a`: $\frac{1}{2}$
`ar`: $\frac{1}{2}$
por lo tanto es **CONVERGENTE**

Como es similar a una serie convergente, se presiente que tambien es convergente
De hecho
$$\frac{1}{2^n + 1} \le \frac{1}{2^n}$$


> [!FAQ] PRUEBA POR COMPARACION
> Suponga que $\sum a_n$ y $\sum b_n$ son series con terminos positivos
> 
> Si $\sum b_n$ es **CONVERGENTE** y $a_n \le b_n$ entonces $\sum a_n$ es **CONVERGENTE**
> Si $\sum b_n$ es **DIVERGENTE** y $a_n \ge b_n$ entonces $\sum a_n$ es **DIVERGENTE**
> 
> Se puede comparar con las series
> p$[\sum \frac{1}{n^p}]$ que **CONVERGE** si $p \gt 1$
> geometrica$[\sum ar^{n-1}]$ que **CONVERGE** si $|r| \lt 1$
> 


> [!INFO] Criterio de Comparacion en el limite
>  $\sum_{n=k}^\infty a_n$  :  $a_n \ge 0$
>  $\sum_{n=k}^\infty b_n$  : $b_n \gt 0$  de criterio conocido 
>  Si 
>  $$\lim_{n \to \infty} \frac{a_n}{b_n} \ne 0 \ne \infty$$
>  $$\lim_{n \to \infty} \frac{a_n}{b_n} = c$$
>  `c`: $c \gt 0$
>  Entonces las 2 series tienen el **MISMO CRITERIO**


> [!INFO]- Ejemplo Comprueba Convergencia mediante Criterio Comparacion
> $$\sum \frac{1}{n^2 + 3n + 7}$$
> 
> 1. Prueba de divergencia: *Si el limite != 0 es divergente*
>  $$\lim_{n \to \infty} \frac{1}{n^2+3n + 7} = 0$$
>  
>  1. Hallar una serie $b_n$ similar
>  $$b_n = \frac{1}{n^2}$$
>  $b_n$ es **CONVERGENTE** ahora se comprueba si $a_n$ tiene el mismo criterio que $b_n$
>  
>  1. Prueba
>  $$\lim_{n \to \infty} \frac{a_n}{b_n} = \lim_{n \to \infty} \frac{n^2}{n^2 + 3n + 7}: \frac{\infty}{\infty} \text{FI}$$
>  $$\lim_{n \to \infty} \frac{n^2}{n^2} = 1 \gt 0$$
>  Entonces $a_n$ es **CONVERGENTE**

> [!Ejemplo]- Ejemplo Trickie-One
> $$\sum \frac{2 + cos(n^3)}{2^n + n}$$
> 1. CN
>  $$
>  \lim_{n \to \infty} \frac{2 + cos(n^3)}{2^n + n} 
>  =  \frac{\lim_{n \to \infty} (2 + cos(n^3) }{ \lim_{n \to \infty}(2^n + n)}
>  = \frac{-3 | 3}{\infty}
>  = 0
>  $$
>  2. 


### Criterio Cociente

> [!Criterio Cociente]
>  $$\begin{equation}
 \lim_{n \to \infty} |\frac{a_{n+1}}{a_n}| = c 
  \begin{cases} 
   \text{converg} & \text{si } 0 \le c \lt 1  \\
   \text{diverg} & \text{si } c \gt 1 \\
  \end{cases}
  \end{equation}$$
  Se usa para **Factoriales** y **Exponenciales**


> [!Ejemplo]- Ejemplo de una Exponencial
> $$\sum \frac{n}{2^n}$$
> 1. Comprobar si es Divergente
>  $$\lim_{n \to \infty} \frac{n}{2^n} = 0$$
> 2. Criterio Cociente
> $$\lim_{n \to \infty} \frac{a_{n+1}}{a_n} \lt 1$$
> $$= \lim_{n \to \infty} \frac{(n+1)2^n}{2^{n+1} n}$$
> $$= \lim_{n \to \infty} \frac{(n+1)}{2n} = \frac{1}{2}$$

> [!Ejemplo]- Ejemplo de una Factorial
> $$\sum \frac{1}{(2n + 1)!}$$
> 1. Comprobar si es Divergente
>  $$\lim_{n \to \infty} \frac{1}{(2n + 1)!} = 0$$
> 2. Criterio Cociente
> $$\lim_{n \to \infty} \frac{a_{n+1}}{a_n} \lt 1$$
> $$= \lim_{n \to \infty} \frac{(2n +1)!}{(2(n+1) + 1)!}$$
> $$= \lim_{n \to \infty} \frac{(2n + 1)!}{(2n + 3)!} = \frac{1}{2n + 2} = 0 \lt 1$$

> [!Ejemplo]- Ejemplo de una Raiz
> $$\sum \frac{1}{\sqrt{3n^2 + n}}$$
> 1. Comprobar si es Divergente
>  $$\lim_{n \to \infty} \frac{1}{\sqrt{3n^2 + n}} = 0$$
> 2. Criterio Cociente
> $$\lim_{n \to \infty} \frac{a_{n+1}}{a_n} \lt 1$$
> $$= \lim_{n \to \infty} \frac{\sqrt{3n^2 + n}}{\sqrt{3(n+1)^2 + (n+1)}} = \frac{\sqrt{3n^2}}{\sqrt{3n^2}} = 1 \not \lt 1$$
> 
> Es **NO CONCLUYENTE**


### Criterio Raiz

> [!INFO] Criterio Raiz
> $$\begin{equation}
> \lim_{n \to \infty} \sqrt[n]{a_n} = L
  \begin{cases} 
   \text{converg} & \text{si } 0 \lt L \lt 1 \\
   \text{diverg} & \text{si } L \gt 1 \\
   \text{no concluy} & \text{si } L = 1
  \end{cases}
  \end{equation}$$


> [!Ejemplo]- Ejemplo de Exponencial
> $$\sum \frac{n}{2^n}$$
> 
> 1. Comprobar si es Divergente
> $$\lim_{n \to \infty} \frac{n}{2^n} = 0$$
> 2. Criterio Raiz
> $$\lim_{n \to \infty} \sqrt[n]{\frac{n}{2^n}} = \frac{\sqrt[n]{n}}{2}  = \frac{1}{2} \lim_{n \to \infty} \sqrt[n]{n}$$
> $$\frac{1}{2} \lim_{n \to \infty} \sqrt[n]{n}: [\infty^0] \text{ FI}$$
> 
> 2.1 Transformacion
> $$
> \frac{1}{2} \lim_{n \to \infty}(n^{\frac{1}{n}}) \\
> = \frac{1}{2} \lim_{n \to \infty} (e^{\frac{1}{n}ln(n)}) \\
> = \frac{1}{2} e^{\lim_{n \to \infty}(\frac{ln(n)}{n})} \\
> = \frac{1}{2} e^0 \\
> = \frac{1}{2} \lt 1
> $$
> Entonces es **CONVERGENTE**



## Ejercicios

> [!INFO]- $\sum \frac{1}{\sqrt{n\sqrt{n+1}}}$
> 
> 1. CN
>  $$\lim_{n \to \infty} \frac{1}{\sqrt{n\sqrt{n+1}}} = 0$$
>  El termino se parece al de una serie `p`: $\frac{1}{\sqrt{n}}$
>  Asi que ese sera $b_n$
>  
>  2. Criterio Comparacion
>  $$\lim_{n \to \infty} \frac{a_n}{b_n} \ne 0 \ne \infty$$
>  $$
>  \lim_{n \to \infty} \frac{\frac{1}{\sqrt{n\sqrt{n+1}}}}{\frac{1}{\sqrt{n}}} 
>  = \lim_{n \to \infty} \frac{\sqrt{n}}{\sqrt{n \sqrt{n+1}}}
>  = \lim_{n \to \infty} \sqrt{\frac{n}{n \sqrt{n+1}}}
>  = \sqrt{\lim_{n \to \infty} \frac{n}{n \sqrt{n+1}}}
>  = \sqrt{\lim_{n \to \infty} \frac{1}{\sqrt{n+1}}}
>  = \sqrt{0} = 0
>  $$
>  Ese resultado indica que $\frac{1}{\sqrt{n \sqrt{n+1}}} \le \frac{1}{\sqrt{n}}$ lo que no es cierto
>  Por lo que es **NO CONCLUYENTE** escojemos otro criterio y serie de referencia
>  
>  1. Criterio Cociente
>  vamos a usar la serie armonica $\frac{1}{n}$
>  $$
>  \lim_{n \to \infty} \frac{\frac{1}{\sqrt{n\sqrt{n+1}}}}{\frac{1}{n}} 
>  = \lim_{n \to \infty} \frac{n}{\sqrt{n \sqrt{n+1}}}
>  = \infty
>  $$
>  Lo que indica que $a_b$ > $b_n$
> Si $\sum b_n$ es **DIVERGENTE** y $a_n \ge b_n$ entonces $\sum a_n$ es **DIVERGENTE**

> [!INFO]- $\sum \frac{2n - 1}{(\sqrt{n})^n}$
> 1. CN
> $$\lim_{n \to \infty} \frac{2n - 1}{(\sqrt{n})^n} = 0$$
> Pues las exponenciales son de orden mayor
> 
> 2. Criterio del Cociente
> $$\lim_{n \to \infty} |\frac{a_n}{b_n}| = c $$
> $$0 \le c \lt 1$$
> 
> $$
> \lim_{n \to \infty} \frac{ \frac{2n + 2}{(\sqrt{2})^{n+1}}  }{  \frac{2n -1}{(\sqrt{2})^n}  }
> = \lim_{n \to \infty} \frac{(2n+2)(\sqrt{2})^n}{(2n-1)(\sqrt{2})^n\sqrt{2}}
> = \lim_{n \to \infty} \frac{(2n+ 2)}{(2n-1)\sqrt{2}}
> = \frac{1}{\sqrt{2}} \lt 1
> $$
> Entonces es **CONVERGENTE**

> [!INFO]- $\sum \frac{2n^3 - 1}{n + \sqrt{n}}$
> 1. CN
>  $$\lim_{n \to \infty} \frac{2n^3 - 1}{n + \sqrt{n}} = \infty$$
>  
>  Entonces es **DIVERGENTE**

> [!INFO]- $\sum \frac{n}{n^3 -3n +3}$
> 
> 1. CN
> $$\lim_{n \to \infty} \frac{n}{n^3 -3n +3} = 0$$
> 
> Se puede pensar que es convergente por la forma que tiene 
> por lo que para $b_n$ cojemos una serie `p` convergente
> $$
> \lim_{n \to \infty} \frac{\frac{n}{n^3 -3n +3}}{\frac{1}{n^2}} 
> = \lim_{n \to \infty} \frac{n^3}{n^3 -3n +3} = 1 
> $$
> Entonces es **CONVERGENTE**> 

> [!INFO]- $\sum \frac{n^3}{2n^4 +3n -1}$
> 1. CN
> $$\lim_{n \to \infty} \frac{n^3}{2n^4 +3n -1} = 0$$
> 
> 2. Criterio Comparacion
> para simplificar podemos escojer $\frac{1}{n}$ que es divergente
> 
> $$
> \lim_{n \to \infty} \frac{ \frac{n^3}{2n^4 + 3n -1} }{ \frac{1}{n} } 
> = \lim_{n \to \infty} \frac{n^3}{2n^4 + 3n -1}
> = \frac{1}{2} \ne 0
> $$
> 
> Entonces tienen el mismo caracter
> Entonces $a_n$ es **DIVERGENTE**



