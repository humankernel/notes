Selector de hijos

```css
/* aplica el estilo a todos los párrafos que sean hijos directos de un div1. */
div > p { color: white;}
```



Selector adyacente

```css
/* Sólo seleccionará un elemento especificado que esté inmediatamente después de otro elemento especificado */

elemento_anterior + elemento_afectado { estilos }
li:first-of-type + li { color:  red; }
```



Selector de atributos

```css
a[title] { color: purple; } 
/* selecciona todos los elementos `<a>` con un atributo `title` y les aplica el color púrpura */
```


