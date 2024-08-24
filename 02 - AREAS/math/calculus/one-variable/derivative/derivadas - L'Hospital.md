---
cards-deck: computer_science::math::calculo
---

* Propiedades L'Hospital
* Transformaciones

Se usa para resolver las formas indeterminadas $\frac{0}{0}, \frac{\infty}{\infty}$ en el calculo de limite de funciones

$$\lim_{x \to a} \frac{f(x)}{g(x)} = \lim_{x \to a} \frac{f'(x)}{g'(x)}$$


Las restantes formas indeterminadas, deben expresarse en estas dos formas, haciendo las transformaciones que sean necesarias para lograrlo.

* $0 * \infty$, $\infty - \infty$
* $0^{\infty}$, $\infty ^ 0$, $1^\infty$


## Propiedades L'Hospital: #card
1. La Regla de L´Hospital puede aplicarse a límites laterales
2. El punto a puede ser finito o inclusive infinito.
3. La Regla de L´Hospital se puede aplicar cuantas veces sea necesario
4. CUIDADO!!!:
	Si el límite del cociente de las derivadas NO EXISTE, nada puede asegurarse acerca del límite original
^1677862540632


## Transformaciones

## $0*\infty$ a $\frac{0}{0}$, $\frac{\infty}{\infty}$ #card

$$\lim_{x \to a} f(x)g(x): 0*\infty$$
$$\lim_{x \to a} \frac{\frac{f(x)}{1}}{g(x)} : \frac{0}{0}$$
o también 
$$\lim_{x \to a} \frac{\frac{g(x)}{1}}{f(x)} : \frac{\infty}{\infty}$$
^1677862601200




## $\infty - \infty$ a $\frac{0}{0}$, $\frac{\infty}{\infty}$ #card

$$\lim_{x \to a} [f(x) - g(x)] : \infty - \infty$$


Queremos llegar a una indeterminación $\frac{0}{0}$ o $\frac{\infty}{\infty}$ para poder usar L'Hospital

$$f-g = \frac{fg}{g} - \frac{gf}{f}$$
se saca el factor común
$$\frac{fg}{g} - \frac{gf}{f} = ( \frac{1}{g} - \frac{1}{f} ) fg$$
y llegamos a una indeterminación $0 * \infty$

$$\frac{\frac{1}{g} - \frac{1}{f}}{\frac{1}{fg}} : \frac{0}{0} $$
^1677862611801

## $1^\infty, 0^0, \infty^0$ a $\frac{0}{0}$, $\frac{\infty}{\infty}$ #card


$$\lim_{x \to a} f(x)^{g(x)} = e^{\lim_{x \to a} g(x) lnf(x)}$$
$$ g(x) * lnf(x) : 0*\infty$$
$$ \lim_{x \to a} g(x) * lnf(x) = \lim_{x \to a} \frac{lnf(x)}{\frac{1}{g(x)}} : \frac{\infty}{\infty}$$
se le aplica L'Hospital
$$e^{\text{resultado}}$$

^1677862662037

## Ejemplos

::Question
$$\lim_{x \to 1} \frac{ln(x)}{x-1}$$

::Answer
Aplicando L'Hospital

$$\lim_{x \to 1} \frac{ln(x)}{x-1}$$
$$\lim_{x \to 1} \frac{(ln(x))'}{(x-1)'} = \lim_{x \to 1} \frac{\frac{1}{x}}{1} = 1$$

::Question
$$\lim_{x \to \infty} \frac{e^x}{x^2}$$
::Answer
L'Hospital aplicada 2 veces
$$\lim_{x \to \infty} \frac{e^x}{x^2}: \frac{\infty}{\infty} FI$$
$$\lim_{x \to \infty} \frac{e^x}{2x} : \frac{\infty}{\infty} FI$$
$$\lim_{x \to \infty} \frac{e^x}{2} = \infty$$

$$\left(\frac{f}{g}\right)‘(x)=\frac{f’(x)g(x)-f(x)g’(x)}{[g(x)]^2}$$

