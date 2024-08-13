IRQ0 - int 8


El timer se utiliza en la programación para generar una espera de tiempo o contar cuánto se demora un evento. Por lo general su rutina de atención a interrupciones tiene la estructura:

## Modos de Atencion
### Interrupcion

> [!Info] timer:
> 
> 1. Robar el vector de interrupción
>```nasm
>xor ax, ax          
>mov es, ax          
>mov ax, timer  
>mov [es: 8*4], ax          
>mov [es: 8*4+2], cs
>```
>2. Iniciar el contador de tiempo:
>```nasm
>xor dx, dx
>```
>3. Poner el código del evento a medir o generar la espera. Para la espera es:
>```nasm
>@@: 
>	cmp dx, 18*cant_segundos          
>	jne @b
>```
>
>4. Comprobar la demora del evento o acción a desarrollar luego de la espera. Para comprobar la demora del evento:
>```nasm
>mov ax, dx          
>mov bl, 18          
>div bl          
>mov [time], al
>```
>5. Resto del código del programa
>```nasm
>jmp $
>```
>
>6. Subrutina timer
> ```nasm
> timer:  
> 	cli  
> 	inc dx        ;se usa un registro para contar las interrupciones  
> 	mov al, 20h   ;eoi del 8259  
> 	out 20h, al   ;al pic maestro  
> 	sti  
> 	iret
> ```
>
>7. Declaración de la ISR
>![[Pasted image 20231022121031.webp]]






> [!Info] Ejemplo - 'x' en (0,0) despues que paso 3s
> 
>```nasm
>format binary as 'img'
>org 7c00h
>mov ax, cx
>mov ds, ax
>
>xor dx, dx
>
>
>; roba la atencion del vector de interrupcion IRQ-0
>xor ax, ax          
>mov es, ax   
>mov ax, timer       
>mov [es:8*4], ax     ; maestro 
>mov [es:8*4+2], cs   ; esclavo
>
>
>sti    ; habilita las interrupciones               
>
>
>; solo avanza cuando paso 3s
>@@:
>    cmp dx, 18 * 3
>    jne @b
>
>; codigo
>mov ax, dx
>mov bl, 18
>div bl
>mov [time], al
>call pintar
>
>jmp $
>
>color db 10011100b
>time db 0
>
>timer:
>    cli          ;inicia la atencion a la int
>
>    ;codigo
>    inc dx
>
>    ;cortamos la coneccion maestro-esclavo
>    mov al, 20h  ;EOI del 8259
>    out 20h, al   ;cierra la conexion con el maestro
>    sti          ;terminamos la atencion a la int      
>    iret         ;reinicia la atencion a la int
>
>
>pintar:
>    mov ax, 3
>    int 10h
>    mov ax, 0b800h
>    mov es, ax
>
>    ; display the time
>    xor di, di
>    mov ah, [color]
>    mov al, 'x'
>    
>    mov [es:di], ax 
>    ret
>
>times 510 - ($-$$) db 0
>dw 0aa55h
>```

