# Form of Knowledge Representation


Clasificación 
- Declarativas
- Procedurales


## Declarativas
La mayor parte del conocimiento se representa como una colección estática de hechos junto con un pequeño conjunto de procedimientos generales para manipularlos

- Logica
- Semantic Networks
- Frames
- Scripts


> [!success] Ventajas:
> - Cada hecho sólo necesita almacenarse una vez, sin importar el número de maneras diferentes en que pueda usarse.
> - Es fácil añadir nuevos hechos al sistema sin cambiar los otros hechos ni los procedimientos pequeños


## Procedurales

Donde la mayor parte del conocimiento se representa como procedimientos para usarlo

- Reglas de producción. 
- Strips.

> [!success] Ventajas
> - Es fácil representar el conocimiento sobre cómo hacer cosas. 
> - Es fácil representar el conocimiento que no encaja bien en muchos esquemas declarativos simples, como por ejemplo razonamientos por defecto y probabilísticos. 
> - Es fácil representar conocimiento heurístico de cómo realizar las cosas eficientemente.


### Ontología

Forma de describir el mundo usando (conceptos y sus relaciones)
Generalmente en forma de arboles

![[forms-representatio-20240615121418785.webp|500]]
**Individuos**: instancias u objetos. 
Clases: conjuntos, colecciones, conceptos, clases en programación, tipos de objetos,o tipos de cosas. 

**Atributos**: aspectos, propiedades, rasgos, características, o parámetros que objetos (y clases) pueden tener. 

**Relaciones**: formas en la cual clases y los individuos se pueden relacionar unos con otros. 

**Funciones**: Complejas estructuras formadas de cierta relación que pueden ser usada en lugar de un término individual en una declaración. 

**Restricciones**: establecen descripciones formales de lo que debe ser verdad con el objetivo de que alguna aserción pueda ser aceptada como entrada

**Reglas**: Declaraciones con forma de oraciones si-entonces (antecedente-consecuente) que describen inferencias lógica que puede ser derivables de una aserción en una forma particular. 

**Axiomas**: aserciones (incluyendo reglas) en una forma lógica que juntos incluyen toda la teoría que la ontología describe en su dominio de aplicación. En las ontologías, "axiomas" también incluyen teorías derivadas de declaraciones axiomáticas. 

**Eventos**: los cambios de los atributos o relaciones


Tipos de Ontologías:
- Ontologías de Dominio 
- Ontologías Generales 
- Ontología de Tareas 
- Ontología Terminológicas 
- Ontología de Información 
- Ontología de modelado del conocimiento


## Redes Semánticas

> Es un tipo de ontología

Los vertices se llamaran: $t_1, t_2, ..., t_n$

vertices: objetos | conceptos | eventos | acciones | atributos
aristas: relaciones, ej. `es_un`, `parte_de`, `instancia`, `tiene`

![[forms-representatio-20240615122002435.webp|800]]


![[forms-representatio-20240615122307435.webp|500]]

Cualquier nodo puede ser el punto de partida
Tipos similares de conocimiento son adyacentes




> [!example]-
> ![[forms-representatio-20240615122436523.webp|400]]
> 
> ![[forms-representatio-20240615122453731.webp|500]]




## Frames

> Estructura de datos compleja que contiene información acerca de un objeto


Tantos los marcos como la POO proponen organizar el conocimiento en términos de objetos, pero en los marcos se hace más énfasis en la representación (las ranuras y sus facetas) mientras que la POO hace un mayor énfasis en el cálculo (pase de mensajes)


## Scripts

> Los guiones son estructuras de datos complejas designadas para almacenar el conocimiento sobre una secuencia estereotipada de acciones.


- Sitio (Setting): es el lugar donde ocurren los eventos.
- Sujetos (Roles): son los sujetos que actúan en los eventos descritos
- Objetos (Props): son los objetos que aparecen en los eventos descritos. 
- Condiciones (Conditions): son las condiciones que deben cumplirse antes de que los eventos se realicen. 
- Escenas (Scenes): describen los eventos. 
- Resultados (Results): son condiciones que existen una vez concluidos los eventos


![[forms-representatio-20240615131140115.webp|400]]


GUION RESTAURANTE
Sitio: Restaurante de autoservicio y su contorno. 
Sujetos: Cliente (C),Dependiente (D), Cajero (J). 
Objetos: Contadora, bandeja, comida, dinero. 
Condición: C tiene hambre, C tiene dinero. 
Escena 1: “Entrada al restaurante” 
- C entra al restaurante. 
- C se pone en cola ante la contadora. 
- C lee el menú en la pared y decide qué pedir.
Escena 2: “Tomar los alimentos” 
- C toma la bandeja vacía. 
- C le pide a D los alimentos. 
- D coloca los alimentos en la bandeja. 
- C le paga a J.
Escena 3: “Comer los alimentos” 
- C toma la bandeja con los alimentos. 
- C coloca la bandeja en una mesa vacía. 
- C ingiere los alimentos. 
Escena 4: “Salida del restaurante” 
- C se levanta de la mesa. 
- C abandona el restaurante. 
Resultados: C no tiene hambre, C tiene menos dinero, 
C está satisfecho o no, C está demasiado lleno


## Production Rules

Una regla de producción consta de un par ordenado (A,B), representado en el cálculo proposicional como $A => B,$

donde A representa el antecedente y B el consecuente de la regla.


Las reglas de producción pueden adoptar varias formas: 
a) Si condición P entonces conclusión C. 
b) Si situación S entonces acción A. 
c) Si condición C1 entonces no condición C2.

> [!example]-
> Si el paciente tiene manchas rojas y fiebre y está en edad escolar, entonces tiene varicela. 
> Si un animal tiene los ojos enfocados hacia delante y tiene dientes y tiene garras, entonces es un carnívoro. 
> Si la temperatura del horno es mayor que 120°C o es menor que 70°C, entonces ajustar válvula de presión


**Tienen fuerza expresiva** para: 
- representar reglas de inferencia dependientes del dominio 
- representar especificaciones de comportamiento 
- almacenar el conocimiento que pueda ser expresado como heurística experimental 
- expresar conocimiento orientado a un objetivo 
- expresar relaciones causales

**Componentes**:
- base de datos
- conjunto de reglas
- interprete


