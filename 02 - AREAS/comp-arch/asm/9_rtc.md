IRQ8 - int 70h

El reloj de tiempo real (RTC) es uno de los periféricos que se usa con mayor frecuencia para el control del tiempo en el ordenador. 

- Mantiene la fecha y la hora actualizadas
- Fabricado en tecnología CMOS
- Se alimenta mediante una batería (o pila)
- En el arranque el sistema lee su valor
- También contiene una pequeña memoria.
- Sirve para almacenar la configuración

![[Pasted image 20231022121103.webp]]


**70h**: Su lógica está diseñada para escribir el número del puerto que se quiere acceder en la dirección `70h` y 
**71h**: leer o escribir su valor en el puerto `71h`. 

Las operaciones típicas con el RTC se realizan mediante manejo de puertos.  Hay dos formas de atender al hardware de RTC:  por encuesta y apoyándose en el trabajo de la interrupción hardware IRQ8.

## Propiedades 

1. Lleva un registro de la hora y fecha y otras funciones. 
2. Está conectado a los puertos `70h` y `71h`. El puerto 70h accede al selector de registros y el puerto 71h accede a los valores de los registros seleccionados. con la IRQ0 que se ejecuta cada 55 ms
3. Se asocia a la IRQ8 y para su periodicidad se apoyarán en trabajo. 
4. También lleva la cuenta del tiempo transcurrido. 
5. Funciona con la señal de 1 Hz suministrada. 
6. Su resolución mínima es de 1s. 
7. Detecta la distinta duración de cada mes. 
8. Detecta los años bisiestos. 
9. Puede funcionar en modo 12h AM/PM o 24h. 
10. Y los datos son almacenados en binario o en BCD.


![[Pasted image 20231022121112.webp]]

## Pasos para la programación

### Encuesta

Se escribe en el `70h` el valor que se desea conocer y se lee en el `71h`. Por ejemplo para las horas:

```nasm
mov al, 4; registro de las horas  
out dx, 70h  
in al, 71h
```

## Interrupción

Hay que realizar el robo de la interrupción del RTC que es la 70h


```nasm
xor ax, ax  
mov es, ax  
mov ax, show_time  
mov [es: 70h*4], ax  
mov [es: 70h*4+2], cs
```


Se deben habilitar:

1. Las interrupciones periódicas en el rtc (bit 6 del registro 0bh)
2. La irq8 en el PIC esclavo (bit 0 del puerto 0a1h)
3. En la ISR, cada vez que se genera una interrupción del RTC, se debe leer el puerto 0ch para que sigan ocurriendo. Se necesita enviar el comando EOI al PIC esclavo.