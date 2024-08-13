# Von Neumann & Harvard

> [!INFO]
> Es el modelo y descripción funcional de los requerimientos e implementaciones de diseño para varias partes de una PC.
> 
> Es el diseño conceptual y estructura operacional de un sistema que conforman una PC.


> [!Important] Resumen
> La arquitectura **Von Neumann** es una arquitectura de computadoras que utiliza el mismo dispositivo de memoria tanto para las instrucciones como para los datos. Los componentes de esta arquitectura son: ALU, memoria principal, dispositivos de E/S y el bus que proporciona un medio de transporte de los datos entre las distintas partes.
> 
> Por su parte, la arquitectura **Harvard** tiene pistas de almacenamiento y de señal físicamente separadas para las instrucciones y para los datos.


![[Pasted image 20230930092247.webp]]

## Arquitectura Harvard

![[Pasted image 20230930092313.webp]]

1930

Se basa en Reles

Pistas de almacenamiento y de señal físicamente separadas para las instrucciones y para los datos

Los programas necesitaban ser cargados por un operador; el procesador no podría arrancar por sí mismo

La arquitectura de Harvard tiene una amplia aplicación en los productos de procesamiento de video y audio

## Arquitectura Von Neumann (Princenton)

1940

> [!INFO]
> Utilización de la codificación binaria para almacenar la información.
> La unidad de procesamiento siempre está ejecutando un programa de forma secuencial.
> Utilización de programa almacenado.
> 
> La arquitectura de Von Neumann constan de cinco partes: 
> 1.  La unidad aritmético-lógica (ALU), 
> 2. la unidad de control, 
> 3. 
> 4. dispositivo de E/S
> 5. la memoria principal.
>    
> Aunque los buses de interconexión (como FSB, Hypertransport) y los puertos USB son partes esenciales de una computadora moderna, no se especifican en la arquitectura básica de Von Neumann.




![[Pasted image 20230930092918.webp]]


Se basa en el primer borrador sobre EDVAC

Estos sub-sistemas se interconectan por medio de un bus, que contiene líneas de datos, de dirección y de control

La idea fundamental de Von Neumann se apoya en el hecho de que una operación compleja normalmente se puede dividir como una secuencia ordenada de operaciones más simples.

En otras palabras lo que propuso fue construir una máquina capaz de ejecutar algoritmos en forma explícita.

Para ello introdujo el concepto de "programa almacenado" como una "secuencia lógicamente ordenada de instrucciones", siendo las "instrucciones" las operaciones básicas que implementa el hardware a través de sus circuitos lógicos

 [En la arquitectura de Von Neumann, la Unidad de Control es responsable de decodificar las instrucciones](https://www.icomputo.com/2019/02/arquitectura-de-von-neumann-la-unidad.html)[1](https://www.icomputo.com/2019/02/arquitectura-de-von-neumann-la-unidad.html)[2](https://teoriaonline.com/teoria-von-neumann/). [La Unidad de Control busca la instrucción en la memoria principal, luego traduce la instrucción a un lenguaje que pueda entender la Unidad Aritmético-Lógica (ALU), y finalmente ejecuta la instrucción](https://teoriaonline.com/teoria-von-neumann/)[2](https://teoriaonline.com/teoria-von-neumann/). [Después de que la ALU ejecuta la instrucción, la Unidad de Control almacena los resultados en la memoria principal](https://teoriaonline.com/teoria-von-neumann/)
 
> [!INFO] Cuello de Botella
> El concepto ha evolucionado para convertirse en un computador de programa almacenado en el cual no pueden darse simultáneamente una búsqueda de instrucciones y una operación de datos, ya que comparten un bus en común. 
> 
> Esto se conoce como el cuello de botella Von Neumann, y muchas veces limita el rendimiento del sistema


> [!Important] Es Von Neumann cuando
> 1. Los programas y los datos se almacenan en una memoria en común.
> 2. Cada celda de memoria de la máquina se identifica con un número único, llamado dirección.
> 3. Las diferentes partes de la información (los comandos y los datos) tienen diferentes modos de uso, pero la estructura no se representa en memoria de manera codificada.
> 4. Cada programa se ejecuta de forma secuencial que, en el caso de que no haya instrucciones especiales, comienza con la primera instrucción. Para cambiar esta secuencia se utiliza el comando de control de transferencia.

