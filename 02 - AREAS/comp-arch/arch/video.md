## Principales componentes

### GPU

 Tres de las más importantes de dichas características de **GPU** son la frecuencia de reloj del núcleo, que puede oscilar entre 825 MHz en las tarjetas de gama baja, y 1600 MHz (e incluso más) en las de gama alta, el número de sombreadores y el número de tuberías (de vértices o fragmentos) encargadas de traducir una imagen 3D compuesta por vértices y líneas en una imagen 2D compuesta por píxeles. Elementos generales de una GPU:

![[Pasted image 20231022143751.webp]]

### GRAM

La memoria gráfica de acceso aleatorio (GRAM) son chips de memoria que almacenan y transportan información entre sí, no son determinantes en el rendimiento máximo de la tarjeta gráfica, pero unas especificaciones reducidas pueden limitar la potencia de la GPU. Existen memorias gráficas de dos tipos:

- Dedicada: cuando la tarjeta gráfica o la GPU dispone exclusivamente para sí esas memorias, esta manera es la más eficiente y la que mejores resultados da.
- Compartida: cuando se utiliza memoria en detrimento de la memoria principal de la PC (RAM).


### Capacidad

La capacidad de la memoria determina el número máximo de datos y texturas que puede procesar, una capacidad insuficiente se traduce en un retardo ya que se tendría que esperar a que los datos existentes se vacíen para colocar nuevos datos.

### Interfaz de memoria (bits)

También denominado bus de datos, es la multiplicación resultante del ancho de bits de cada chip por su número de unidades. Es una característica importante y determinante, junto a la frecuencia de la memoria, a la cantidad de datos que puede transferir en un tiempo determinado, denominado ancho de banda

### Frecuencia de la memoria (hz)

Es la frecuencia a la que las memorias pueden transportar los datos procesados, por lo que es complemento a la interfaz de memoria para determinar el ancho de banda total de datos en un tiempo determinado. Continuando la analogía de la circulación de los vehículos de la autopista, la frecuencia de memoria se traduciría en la velocidad máxima de circulación de los vehículos, dando resultado a un mayor transporte de mercancía en un mismo periodo de tiempo. 

### Ancho de banda (GB/s)

Es la tasa de datos que pueden transportarse en una unidad de tiempo. Un ancho de banda insuficiente se traduce en un importante limitador de potencia de la GPU. 

Habitualmente se mide en gigabytes por segundo (GB/s).

$$BW \text{(GPU)}= \frac{IM * FM}{8} $$

Su fórmula general es el cociente del producto de la interfaz de memoria (expresada en bits) por la frecuencia efectiva de las memorias (expresada en gigahercios), entre 8 para convertir bits a bytes.

Por ejemplo, tenemos una tarjeta gráfica con 256 bits de interfaz de memoria y 4200 MHz de frecuencia efectiva y necesitamos hallar su ancho de banda:


Una parte importante de la memoria de un adaptador de video es el z-buffer, encargado de gestionar las coordenadas de profundidad de las imágenes en los gráficos 3D, es decir, es el espacio de memoria donde se gestiona la profundidad en los gráficos. Está profundidad a veces se gestiona por hardware y otras por software.


### RAMDAC

El convertidor digital-analógico de memoria de acceso aleatorio (RAMDAC) es un conversor de señal digital a señal analógica de memoria RAM. Se encarga de transformar las señales digitales producidas en el ordenador en una señal analógica que sea interpretable por el monitor. Según el número de bits que maneje a la vez y la velocidad con que lo haga, el conversor será capaz de dar soporte a diferentes velocidades de refresco del monitor (se recomienda trabajar a partir de 75 Hz, y nunca inferior a 60). Dada la creciente popularidad de los monitores de señal digital, el RAMDAC está quedando obsoleto, puesto que no es necesaria la conversión analógica si bien es cierto que muchos conservan conexión VGA por compatibilidad.

### Espacio que ocupan las texturas almacenadas

El espacio que ocupa una imagen representada en el monitor viene dado en función de su resolución y su profundidad de color, es decir, una imagen sin comprimir en formato estándar Full HD con 1920 × 1080 píxeles y 32 bits de profundidad de color ocuparía 66 355 200 bits, es decir, 8 294 MiB.


## Conexión de la tarjeta gráfica con el dispositivo visualizador

### VGA

El video graphics array (VGA) o super video graphics array (SVGA o Súper VGA) fue el estándar analógico de los años 1990; diseñado para dispositivos con tubo de rayos catódicos (CRT); sufre de ruido eléctrico y distorsión por la conversión de digital a analógico y el error de muestreo al evaluar los píxeles a enviar al monitor. Se conecta mediante 15 pines con el conector D-sub: DE-15. **Su utilización continúa muy extendida y a pesar de haber surgido otros estándares este aún se mantiene.**

### DVI

Digital visual interface (DVI)es sustituta de la anterior, pero digital; fue diseñada para obtener la máxima calidad de visualización en las pantallas digitales o proyectores. Se conecta mediante pines. Evita la distorsión y el ruido al corresponder directamente un píxel a representar con uno del monitor en la resolución nativa del mismo. Cada vez más adoptado, aunque compite con el HDMI, pues el DVI no es capaz de transmitir audio.

### HDMI

La interfaz multimedia de alta definición o high-definition multimedia interface (HDMI) es una tecnología propietaria transmisora de audio y video digital de alta definición cifrado sin compresión, en un mismo cable. Se conecta mediante patillas de contacto. Fue ideado inicialmente para televisores, y no para monitores, por eso no apaga la pantalla cuando deja de recibir señal y debe apagarse manualmente en caso de monitores.

### DisplayPort

Puerto para tarjetas gráficas creado por VESA y rival del HDMI, transfiere video a alta resolución y audio. Sus ventajas son que está libre de patentes, y por ende de regalías para incorporarlo a los aparatos, también dispone de unas pestañas para anclar el conector impidiendo que se desconecte el cable accidentalmente. Cada vez más tarjetas gráficas van adoptando este sistema, aunque sigue siendo su uso minoritario, existe una versión reducida de dicho conector llamada Mini DisplayPort, muy usada para tarjetas gráficas con multitud de salidas simultáneas.

## **Interfaces con la placa base**

Los sistemas de conexión entre la tarjeta gráfica y la placa base han sido principalmente (en orden cronológico):

1. Ranura MSX: bus de 8 bits usado en los equipos MSX.
2. ISA: arquitectura de bus de 16 bits a 8 MHz, dominante durante los años 1980; fue creada en 1981 para los IBM PC.
3. Zorro II: usado en los Commodore Amiga 2000 y Commodore Amiga 1500.
4. Zorro III: usado en los Commodore Amiga 3000 y Commodore Amiga 4000
5. NuBus: usado en el ordenador Apple Macintosh.
6. Processor Direct Slot: usado en los Apple Macintosh.
7. MCA: en 1987, intento de sustitución de ISA por IBM. Disponía de 32 bits y una velocidad de 10 MHz, pero era incompatible con los anteriores.
8. EISA: en 1988, respuesta de la competencia de IBM; de 32 bits, 8,33 MHz y compatible con las placas anteriores.
9. VESA: extensión de ISA que solucionaba la restricción de los 16 bits, duplicando el tamaño de bus y con una velocidad de 33 MHz.
10. PCI: bus que desplazó a los anteriores, a partir de 1993; con un tamaño de 32 bits y una velocidad de 33 MHz, permitía una configuración dinámica de los dispositivos conectados sin necesidad de ajustar manualmente los jumpers. PCI-X fue una versión que aumentó el tamaño del bus hasta 64 bits y aumentó su velocidad hasta los 133 MHz.
11. AGP: bus dedicado, de 32 bits como PCI; en 1997, la versión inicial incrementaba la velocidad hasta los 66 MHz.
12. PCI-Express (PCIe): desde 2004, es la interfaz serie que empezó a competir contra AGP; en 2006, llegó a doblar el ancho de banda del AGP. Sufre de constantes revisiones multiplicando su ancho de banda, ya existe la versión 4.0. No debe confundirse con PCI-X, versión de PCI.


## Funcionamiento del video

La pantalla de una computadora trabaja igual que lo hace la de un TV corriente, un cañón electrónico controlado por tres haces de electrones (Rojo-Verde-Azul) que recorren la pantalla vertical y horizontalmente provocando que se activen los diminutos puntos que conforman la superficie de la pantalla y que se denominan **píxeles**.

Existen 2 formas comunes o típicos en que una PC envía información a la pantalla. 

### **Framebuffer**

El framebuffer es la denominación en inglés para la técnica de manejo del video mediante E/S mapeada en memoria, lo que significa que el hardware de video intercepta los accesos a direcciones especiales y actúa de manera transparente. Estas direcciones especiales están dedicadas y no pueden utilizarse para otros propósitos. El framebuffering es la técnica más simple de acceso al hardware de video, pero no permite aprovechar funciones avanzadas como las técnicas involucradas en la aceleración hardware2D y 3D. La configuración del hardware de video se lleva a cabo mediante los registros del sistema de video.

En otras palabras, toda la información que se escribe en estas direcciones de memorias es reproducida punto a punto en la pantalla. Por lo que, lo que deseemos pintar en pantalla, lo escribimos en la dirección de memoria correspondiente a la posición en la pantalla donde queremos visualizar.

### **Mapeo de memoria**

La técnica de mapeo de memoria consiste en que el CPU y el adaptador de video comparten una parte de la memoria direccionable. El adaptador continuamente lee la memoria y muestra lo que está codificado en ella, mientras que la CPU puede escribir información en la pantalla simplemente modificando lo que está en memoria. En los adaptadores monocromáticos, la RAM de video estaba mapeada al segmento B000h. En los adaptadores de color (CGA, VGA y derivados), la RAM de video está mapeada al segmento:

- `B800h` en modo texto
- `A000h` en modo gráfico

