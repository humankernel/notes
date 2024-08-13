

**TAREA SOBRE INTEGRACIÓN NUMÉRICA.                        Curso 2023. Segundo Período**

**Nombre y apellidos**: Naylin Brizuela Capote                        
**Facultad/Grupo:** 4202

Aproximar la integral $$\int_{1}^{2} e^{xlnx}dx$$ con $n=8$ utilizando la regla de Trapecios.


| $x_i$    | 1   | 1.125 | 1.25 | 1.375 | 1.5 | 1.625 | 1.75 | 1.875 | 2   |
| -------- | --- | ----- | ---- | ----- | --- | ----- | ---- | ----- | --- |
| $f(x_i)$ | 1   | 1.1417 | 1.3217 | 1.5494 | 1.8371 | 2.2011 | 2.6627 | 3.2499 | 4    |

$\triangle x = 0.125$ 

$$\int_{x_0}^{x_n} e^{xln(x)}dx \approx \frac{\triangle x}{2} [f(x_0) + 2\sum_{i=1}^{n-1}f(x_i) + f(x_n)]$$
$$\int_{1}^{2} e^{xln(x)}dx \approx \frac{0.125}{2}(1 + 2(1.1417 + 1.3217 + 1.5494 + 1.8371 + 2.2011 + 2.6627 + 3.2499) + 4)$$
$$ = \frac{0.125}{2} (32.9272)$$
$$ = 2.058$$
$$|E_T| \le \frac{K(b-a)^3}{12n^2} = \frac{16.3 (1^3) }{12 * (8^2)} = 0.0212239583$$

![[Pasted image 20231021164323.webp]]
![[Pasted image 20231021164403.webp]]

Para el método de doble cálculo duplicamos el paso: $2 \triangle x = 0.25$, tomamos los números nodos que corresponden:

| $x_i$    | 1   |  1.25   |  1.5    |  1.75   | 2   |
| -------- | --- | ---     | --      | ---     | -- |
| $f(x_i)$ | 1   |  1.3217 |  1.8371 |  2.6627 | 4    |

$$\int_{1}^{2} e^{xln(x)}dx \approx \frac{0.25}{2}(1 + 2(1.3217 + 1.8371 + 2.6627) + 4)$$
$$= 2.0804$$
$$|E_s| \le \frac{|I_{\triangle x} - I_{2\triangle x}|}{3} = \frac{|2.058 - 2.0804|}{3} = 0.0075$$
