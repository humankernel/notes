
## identifiers, data types, declarations

```c
//<tipo de datos>  <nombre de la variable> <inicialización o valor inicial>;
int var = 3;
```

```nasm
;<identificador>  <tipo> <valor inicial>
var1 DB 65
var2 DW 1234
var3 DD 651234
```

### identifiers (variables)

Los identificadores son las variables

Este identificador no es más que un nombre que se le da a un elemento del programa. Sus características son:

- Pueden usar letras de la A a la Z
- Números desde el 0 al 9, siempre y cuando no se usen como el primer carácter
- Puede usarse signo de interrogación, guión bajo, signo de pesos y arroba
- También puede usar punto, pero este no debe ser el primer carácter
- No debe coincidir con una palabra reservada
- Máximo 31 caracteres

### types

Cuando hablamos de tipo no nos referimos al tipo de datos que se almacenarán en nuestra variable. A diferencia de los lenguajes de alto nivel, en ensamblador no contamos con tipos de datos convencionales como int, bool, float o string; sino que los tipos de datos estás asociados al tamaño máximo de los valores que almacenaremos en esa variable. Estos se declaran a través de directivas, siendo los más utilizados:

- `DB`: byte y admite valores hasta 8 bits
- `DW`: word, podemos almacenar hasta 16 bits
- `DD`: double word, se utiliza para almacenar valores de hasta 32 bits

### initial value 

No podemos inicializar las variables con valores que sean mayores a los admitidos por el tipo de datos seleccionado.

```nasm
var1 DB 65
var2 DW 1234
var3 DD 651234

cadena_nums DW ‘1’, ‘3’, ‘5’, ‘8’, ‘1356’, ‘56’;
cadena_nums DW 32, 98, 43   ;se interpreta como ' ','d','+' por ASCII

;empty list
cadena DW 32 dup (?)   ;32 veces '','','','',...
var db 32 dup()   ;no es valida



```


## array

```nasm
;this are the same
a DB 48h, 65h, 6Ch, 6Ch, 6Fh, 00h  
b DB 'Hello', 0


;You can access the value of any element in array using square brackets, for example:  
MOV AL, a[3]


;You can also use any of the memory index registers BX, SI, DI, BP, for example:  
MOV SI, 3  
MOV AL, a[SI]
```

![[array.gif]]


