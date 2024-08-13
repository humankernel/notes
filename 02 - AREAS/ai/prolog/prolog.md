# Prolog
#prolog
> Lenguaje de programación lógica utilizado principalmente en inteligencia artificial

**Programación Lógica**: Enfoque declarativo donde se especifica qué hacer y no cómo hacerlo.

## Elementos Fundamentales

**Hechos**: Declaraciones básicas sobre el mundo.
  ```prolog
  hombre(juan).
  padre(juan, maria).
  ```

**Preguntas**: Consultas al motor de inferencia.
  ```prolog
  ?- hombre(juan).
  ?- padre(X, maria).
  ```

**Reglas**: Definen relaciones complejas usando el operador `:-`.
  ```prolog
  padre(X) :- hijo(Y, X).
  abuelo(X) :- padre(Y, X), padre(Z, Y).
  ```

**Predicados**: Relaciones entre objetos.
  ```prolog
  progenitor(tomas, raul).
  ```

## Tipos de Datos
- **Atómicos**: Átomos, cadenas, enteros, flotantes.
- **No Atómicos**: Listas, estructuras.

## Operadores
- **Comparación**: `=`, `\=`.
- **Aritméticos**: `+`, `-`, `*`, `/`, `//`, `^`.
- **Evaluación**: `X is E`.

## Mecanismos
- **Unificación**: Proceso de hacer coincidir dos términos.
- **Backtracking**: Búsqueda de todas las posibles soluciones.

## Recursividad
- Ejemplo de factorial en Prolog:
  ```prolog
  fact(0, 1).
  fact(X, F) :- X > 0, 
				X1 is X - 1, 
				fact(X1, F1), 
				F is F1 * X.
  ```

 
## Listas

Una lista es una secuencia de elementos que puede ser vacía (`[]`) o no vacía `[Cabeza | Cola]`.


> [!warning] `L[2] !=`
> No se puede acceder a un elemento directo en una lista

### **Representación de Listas**
Las listas en PROLOG son manejadas como árboles binarios

- **Lista vacía**: `[]`
- **Lista no vacía**: `.(Cabeza, Cola)`


```prolog
[Cabeza | Cola] 

[a, b, c, d]
[a, b | [c, d]]
[a | [b, c, d]]
[a | [b | [c, d]]]


.(a, .(b, .(c, .(d, []))))  
```


Ejemplos:
```prolog
prog(tomas, ana).
prog(tomas, raul).
prog(tomas, pedro).
prog(maria, ana).
prog(maria, felipe).
prog(maria, rosa).

prog(tomas, [ana, raul, pedro])
prog(maria, [ana, felipe, rosa]).
```


**Acceso a Elementos de Listas**
```prolog
?- L = [nora, angel, jose], L = [X|P].
   L = [nora, angel, jose], X = nora, P = [angel, jose].

?- [nora | [angel, jose]] = [nora, angel | [jose]] = [nora, angel, jose | []].
   yes
```


**Miembro**: Comprueba si un elemento es miembro de una lista.
  ```prolog
  member(X, [X|_]).
  member(X, [_|T]) :- member(X, T).
  ```

**Concatenar**: Une dos listas.
  ```prolog
  append([], L, L).
  append([H | T], L2, [H | R]) :- append(T, L2, R).
  ```


**Longitud**
```prolog
length([], 0).
length([_ | C], L) :- longitud(C, L1),
					   L is L1 + 1.
```



Si se quiere preguntar
1. ¿Quién no tiene hijos?
2. ¿Quién tiene un solo hijo?
3. ¿Quién tiene al menos un hijo?
4. ¿Quién tiene exactamente dos hijos?
5. ¿Quién tiene al menos dos hijos?
6. ¿Quién es el primer hijo de Tomás?


### **Recorrido de Listas**

- Utiliza recursividad en lugar de bucles iterativos.
- Ejemplo de recorrido:
  ```prolog
  imprimir([]).
  imprimir([H|T]) :- write(H), nl, imprimir(T).
  ```




### **Uso de Predicados**
```prolog
?- member(ana, [ana, felipe, rosa]).
% yes

?- append([ana, felipe], [rosa], X).
% X = [ana, felipe, rosa]
```
