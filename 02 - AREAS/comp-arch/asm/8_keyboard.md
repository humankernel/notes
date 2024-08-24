IRQ1 - int 9


![[Pasted image 20231120175341.webp]]

**El 8042** es el controlador del teclado, el encargado en el sistema, de interpretar los datos procedentes del teclado y después de traducirlos, enviarlos al CPU


El 8042 dispone para su trabajo, de todo un protocolo para la recepción y envío de datos si errores. Tiene cuatro registros:

- Entrada
- Salida
- Estado
- Configuración

A estos registros puede accederse a través de los puertos 60h y 64h y a través de estos es posible aprovechar al máximo las posibilidades de cada teclado.



> [!Info]
> Tras el arranque del sistema el teclado realiza una autocomprobación denominada BAT (Basic Assurance Test) donde chequea su ROM, RAM y enciende y apaga todos los LED. Al acabar el BAT y cuando sea posible establecer la comunicación con el ordenador envía un byte 0AAh si todo ha ido bien y 0FCh si ha habido fallos.
> 
> La operación rutinaria del teclado es informar al 8042 acerca de todas las teclas pulsadas, esperando cada vez por la verificación de éste para enviar los siguientes datos. Eventualmente puede recibir instrucciones como la activación de leds, teclas específicas o pasar a estado de bloqueo.


## **Código SCAN**

Las teclas se identifican con un número que indica su posición física. Este número se conoce como Scan Code o código de rastreo.

Estos indicadores son los que se intercambian el teclado y su controlador en la placa base, cada vez que se presiona o libera una tecla.


![[Pasted image 20231120175606.webp]]

Las teclas generan un código Scan diferentes en dependencia de si fueron presionadas o liberadas. Cuando son liberadas el bit 7 del código Scan se habilita:

![[Pasted image 20231120175634.webp]]


## Mecanismos de atencion

### Encuesta


![[teclado encuesta.excalidraw.svg|400]]
%%[[teclado encuesta.excalidraw|🖋 Edit in Excalidraw]]%%


En la encuesta se hace uso de los cuatro registros del teclado: uno de entrada, uno de salida, uno de estado y otro de configuración, que pueden accederse a través de los puertos 60hy 64h.

```nasm
@@:   
	; si se presiono una tecla
	in al, 64h  
	test al, 1     
	jz @b  
	
	; cual fue
	in al,60h 
	cmp al, [scan]
	jne @b
	 
	; codigo
```

Se lee el estado en el puerto 64h para saber en el bit 0 si hay tecla activa. De haberlo se lee entonces en el puerto 60h el código Scan.


> [!Info]- Ejemplo  uso independiente de las teclas Shift izq, Shift der, y Alt izq
> 
> ```nasm
> @@:
> 	int al, 64h
> 	test al, 1
> 	jz, @b
> 	int al, 60h
> 	cmp al, 38h
> 	je AltKey         ;detecta el Alt izquierdo
> 	cmp al, 2Ah
> 	je LShift          ;detecta el Shift izquierdo
> 	cmp al, 36h
> 	je RShift          ;detecta Shift derecho
> ``` 


> [!Info]- Ejemplo
> Imprime lo que hay en `cadena` caracter por caracter cada vez que se presiona una tecla cualquiera
> 
> ```nasm
> format binary as 'img'
> org 7c00h
> mov ax, cs
> mov ds, ax
> 
> ;modo texto
> mov ah, 3
> int 10h
> mov ax, 0b800h
> mov es, ax
> 
> mov cx, 11
> xor si, si
> xor di, di
> 
> mov ah, 01001001b
> @@:
> 	;ver si alguna tecla fue presionada
>     in al, 64h
>     test al, 1
>     jz @b
>     
>     ;saber cual tecla se esta usando
>     in al, 60h
>     cmp al, 127
>     ja @b
>     
>     ;pintar el caracter en pantalla apartir de (0,0)
>     mov al, [cadena+si]
>     mov [es:di], ax
> 
>     inc si
>     add di, 2
>     loop @b
> 
> jmp $
> 
> cadena db 'Hello World'
> 
> times 510-($-$$) db 0
> dw 0aa55h
> ```


### Interrupcion de hardware

En la arquitectura Intel, la interrupción hardware, la IRQ1 o int 9, es para el teclado. Ocurre cuando se presiona o libera cualquier tecla.

Para detectar combinaciones de estas es preciso manejar los registros del controlador del teclado.

```nasm
;robo del vector de interrupciones   
xor ax,ax
mov es, ax
mov ax, keyboard
mov [es: 9*4], ax
mov [es: 9*4+2], cs

sti          ;habilita las interr
...

jmp $

;implementación de la subrutina de atención a interrupciones
keyboard:
	cli
    xor eax, eax
    in 60h, al
    cmp al, 128
    ja @f
@@: 
	mov al, 20h
    out 20h, al
    sti
    iret
```

### Interrupcion del BIOS

La interrupción generada por el teclado también la podemos atender a través de las interrupciones del BIOS, en este caso empleamos `int 16h`, la cual provee las rutinas para establecer los servicios del teclado:

**Servicio 00h:** Esta función lee el carácter del buffer de teclado apuntado por el puntero de lectura y actualiza dicho puntero. Si el teclado esta vacío la función espera hasta que se introduzca un nuevo carácter.

- Entrada:  `AH =  00h`
- Salida :  `AL =  Código` ASCII de la tecla | Cero (Si es un carácter especial)
-  `AH =  Código de exploración de la tecla`


> [!Info] **Ejemplo:** Lee un carácter entrado por teclado (lo recibe en al).
> 
> ```nasm
> xor eax, eax
> mov ah, 00h        ;Esperar por el teclado
> int 16h            ;Interrupción del teclado
> mov [tecla], al    
> ```


**Servicio 01h:** Esta función determina si hay algún carácter en el buffer de teclado. En caso afirmativo entrega el carácter a la función invocadora, pero no actualiza el buffer puntero de lectura. 

Entrada: `AH = 01h`  
Salida :  
- Indicador de cero = 0 : No hay caracteres en el buffer de teclado  
- Indicador de cero = 1  : Hay un carácter disponible      

AH = Código de exploración de la tecla - 'SCAN'
AL = Código ASCII / Cero  


> [!Info] **Ejemplo:** Verificar si se presionó una tecla.
> ```nasm
> no_presionada:  
> 	xor eax, eax  
> 	mov ah, 01h             ;Esperar por el teclado  
> 	int 16h                 ;Interrupción del teclado  
> 	jnz no_presionada  
> 	mov [tecla], al
> ```


> [!Info]- Ejemplo: 'x' despues de presionar 'space'
>```nasm
>format binary as 'img'
>org 7c00h
>mov ax, cs
>mov es, ax
>
>@@:
>    xor ah, ah
>    int 16h      ;AH = scancode  AL = ascii char
>
>    cmp ah, 39h
>    jne @b
>
>    mov [tecla], al
>
>    call print
>    jmp @b
>
>
>jmp $
>
>tecla db 0
>
>print:
>    mov ax, 3
>    int 10h 
>    mov ax, 0b800h
>    mov es, ax
>
>    xor di, di
>
>    mov ah, 10101100b
>    mov al, 'x'
>    mov [es:di], ax
>
>    ret
>
>times 510 - ($-$$) db 0
>dw 0xaa55
>```


### Encuesta de los bytes de teclado extendido

Una forma adicional es a través del los bytes de estado extendido. 

El sistema dispone de dos bytes que se definen como 
1. byte de estado del teclado y 
2. byte de estado del teclado ampliado

a través de los que puede verificarse y modificarse el estado de un grupo de teclas denominadas teclas de cambio (estas teclas no tienen representación ASCII). 

El byte de estado del teclado ampliado es útil para manipular los teclados de 102 teclas o posteriores. Los bytes ubicados en las posiciones de memoria 40h:17h y 40h:18h contienen información sobre las teclas no ASCII de los teclados de 84 teclas y superiores respectivamente.


> [!Info]  Ejemplo: detectar la combinación de teclas Ctrl+Shift+A
> ```nasm
> mov ax, 40h  
> mov es, ax  
> esp:  
> 	mov al, [es:17h]  
> 	and al, 00000110b; detecta shift izq+ ctrl  
> 	cmp al, 00000110b  
> 	jne esp  
> 	in al, 60h  
> 	cmp al, 1eh  
> 	jne esp
> ```
> ![[Pasted image 20231120183034.webp]]

