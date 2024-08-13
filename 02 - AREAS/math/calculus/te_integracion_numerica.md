

**TAREA SOBRE INTEGRACIÓN NUMÉRICA.                        Curso 2023. Segundo Período**

**Nombre y apellidos**: Joaquin Rivas Sanchez                        
**Facultad/Grupo:** 4202

Aproximar la integral $$\int_{0.6}^{1.6} cos(\frac{1}{x})dx$$ con $n=8$ utilizando la regla de Simpson.


| $x_i$    | 0.6 | 0.725 | 0.85 | 0.975 | 1.1 | 1.225 | 1.35 | 1.475 | 1.6 |
| -------- | --- | ----- | ---- | ----- | --- | ----- | ---- | ----- | --- |
| $f(x_i)$ | -0.0957 | 0.1903 | 0.3842 | 0.5186 | 0.6145 | 0.6849 | 0.738 | 0.7789 | 0.811 |

$\triangle x = 0.125$

$$\int_{x_0}^{x_n} cos(\frac{1}{x})dx \approx \frac{\triangle x}{3} [f(x_0) + 4\sum_{i=1}^{n/2}f(x_{2i-1}) + 2\sum_{i=1}^{n/2 + 1}f(x_{2i}) + f(x_n)]$$
$$\int_{0.6}^{1.6} cos(\frac{1}{x})dx \approx \frac{0.125}{3}(-0.0957 + 4(0.1903) + 2(0.3842) + 4(0.5186) + 2(0.6145) + 4(0.6849) + 2(0.738) + 4(0.7789) + 0.811)$$
$$ = \frac{0.125}{3} (12.8795)$$
$$ = 0.5366$$
$$|E_s| = \frac{K(b-a)^5}{180n^4} = \frac{(2.75)(1)^5}{180(8^4)} = 0.0000037299$$
$$E = |0.5366 - 0.5367| = 0.0001 $$

![[Pasted image 20231021161221.webp]]

![[Pasted image 20231021154416.webp]]

Para el método de doble cálculo duplicamos el paso: $2 \triangle x = 0.25$, tomamos los números nodos que corresponden:


| $x_i$    | 0.6 | 0.85 | 1.1 | 1.35 | 1.6 |
| -------- | ---  | ----- | --- | ----- | ---- |  
| $f(x_i)$ | -0.0957 | 0.3842 | 0.6145 | 0.738 | 0.811 |

$$\int_{0.6}^{1.6} cos(\frac{1}{x})dx \approx \frac{0.25}{3}(-0.0957 + 4(0.3842) + 2(0.6145) + 4(0.738) + 0.811)$$
$$= 0.5361$$
$$|E_s| \le \frac{|I_{\triangle x} - I_{2\triangle x}|}{3} = \frac{|0.5366 -  0.5361|}{3} = 0.0002$$
