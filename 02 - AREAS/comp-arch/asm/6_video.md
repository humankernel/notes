
## Modos de video

Dependiendo del adaptador con que cuente el sistema podremos usar o no determinados modos de visualización. Veamos entonces lo modos de video compatibles con la tarjeta VGA, la cual es compatible con las actuales que utilizan nuestras computadoras:

![[Pasted image 20231022151658.webp]]


## La interrupción al BIOS 10h en la programación del video

La interrupción 10h provee rutinas para establecer servicios de video, nosotros estaremos trabajando con el modo `03h` para texto y el `13h` para gráfico:

Servicio `00h`: establece el modo de video y limpia la pantalla.

- Modo `03h`: texto, 80x25, 16 colores.
- Modo `13h`: gráfico, 320x200, 256 colores

En `AH` se le pasa el servicio y en `AL` el modo.

Por ejemplo:

```nasm
mov AX,03h
int 10h
```

Este fragmento limpia la pantalla y establece el modo texto de video


## Modo Texto 03h

Cuando el PC arranca, por defecto el BIOS establece el modo 3, de manera que es posible utilizar el segmento B800h para acceder al hardware de video. 

El adaptador de video requiere 2 bytes para definir cada carácter a desplegar: un byte de atributos y un byte para el ASCII del carácter. La pantalla cuenta con una resolución 80x25. En cada celda de este arreglo cabe un carácter.

![[text_mode.excalidraw.svg]]
%%[[text_mode.excalidraw.excalidraw|🖋 Edit in Excalidraw]], and the [[text_mode.excalidraw.dark.svg|dark exported image]]%%

Y se pinta primero caracter y luego el atributo (AL caracter, AH atributo). Veamos la estructura del byte de atributo:
![[Pasted image 20231022152208.webp]]

Por estas razones para ubicarse en pantalla el desplazamiento en memoria es:

$$160* \text{fil} + 2 * \text{col}$$


## **Modo Gráfico 13h**

La diferencia fundamental es que la unidad de manipulación del video es el píxel. Cada pixel es un byte. 
Para este modo el segmento de acceso al framebuffer lineal es el `0xA000`.  

Los primeros 16 colores son compatibles con los modos de texto.La posición del pixel en la pantalla queda determinada por el desplazamiento de su byte dentro del segmento `A000h`. La pantalla cuenta con una resolución 320x200. En cada celda de este arreglo cabe un carácter.


![[Pasted image 20231022152651.webp]]

Por estas razones para ubicarse en pantalla el desplazamiento en memoria es:

$$320 * \text{fil} + \text{col}$$

Si se usa para pintar un registro de 16 bits (ejemplo AX) , primero se pinta Al y luego Ah.

![[Pasted image 20231022152800.webp]]

# Pasos para la programación del video

Para programar video debe tener en cuenta:

![[Pasted image 20231022153807.webp]]

![[Pasted image 20231022153810.webp]]

![[Pasted image 20231022153816.webp]]

![[Pasted image 20231022153819.webp]]

![[Pasted image 20231022153821.webp]]

![[Pasted image 20231022153824.webp]]


> [!Info]- Ejemplo - Modo Texto - 'Hola'
> ![[Pasted image 20231022155847.webp]]
> 
> ![[Pasted image 20231022155745.webp]]


> [!Info]- Ejemplo - Modo Grafico
>  
>  ![[Pasted image 20231022155914.webp]]
>  
>  ![[Pasted image 20231022160254.webp]]

