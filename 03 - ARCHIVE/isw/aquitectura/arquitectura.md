![[arquitectura-20240501211737769.webp|200]]

![[arquitectura-20240502203827814.webp]]



Diseño de software.



## Principios del diseño de software.
1. El diseño debe poderse rastrea hasta el modelo de requerimientos
2. Siempre tomar en cuenta la arquitectura que se va a construir
3. El diseño de los datos y de funciones de procesamiento son igualmente importantes
4. Las interfaces deben diseñarse con cuidado
5. El diseño de la interfaz de usuario debe ajustarse a las necesidades del usuario final
6. El diseño en el nivel de componentes debe tener independencia funcional. 
7. Los componentes deben estar acoplados con holgura entre sí y con el ambiente externo. 
8. Las representaciones del diseño (modelos) deben entenderse con facilidad. 9. El diseño debe desarrollarse en forma iterativa.


## Diseño de interfaces de usuario (UI)

Reglas de oro:
1. Dar el control al usuario 
	- Definir los modos de interacción de manera que no 
	obligue a que el usuario realice acciones innecesarias y 
	no deseadas.
	- Tener en consideración una interacción flexible.
	- Permitir que la interacción del usuario se pueda 
	interrumpir y deshacer.
	- Ocultar al usuario los elementos técnicos internos.
	- Diseñar la interacción directa con los objetos que 
	aparecen en la pantalla

2. Reducir la carga de memoria del usuario 
	- Reducir la demanda de memoria a corto plazo.
	- Establecer valores por defecto útiles.
	- Definir las deficiencias que sean intuitivas.
	- El formato visual de la interfaz se deberá basar en 
	una metáfora del mundo real.
	- Desglosar la información de forma progresiva.

3. Construir una interfaz consistente
	- Permitir que el usuario realice una tarea en el 
	contexto adecuado.
	- Mantener la consistencia en toda una familia de 
	aplicaciones.
	- Si modelos interactivos anteriores han generado 
	expectativas en el usuario, no hacer cambios a 
	menos que haya razones inexcusables.


Proceso de análisis y diseño: 
1. análisis del usuario, la tarea y el entorno 
2. Validación de la interfaz
3. Implementación
4. Diseño de la interfaz

3 Actividades fundamentales - Proceso de analisis y diseño de la UI:
- Análisis del usuario.
- Prototipado del sistema.
- Evaluación de la interfaz


## Arquitectura de software.

Vista estructural de alto nivel.
Define estilo o combinación de estilos para una solución informática.
Se concentra en requisitos no funcionales.


Atributos de calidad:
**Observables vía ejecución**: Determinan el comportamiento del sistema en tiempo de ejecución. 
- availability
- confidentiality
- functionality
- performance
- reliability
- safety
- security
**No observables vía ejecución**: Se establecen durante el desarrollo del sistema
- configurability
- integrability
- interoperability
- modifiability
- maintainability
- portability
- reusability
- scalability
- testability


## Vistas para la representación de la arquitectura de software.

### **Vista de presentación**: Interfaz UI
- Arquitectura de informacion
  encargada del estudio, análisis, organización, disposición y estructuración de la información, así como de la selección y presentación de los datos en los sistemas de información interactivos y no interactivos.
  
  ![[arquitectura-20240501213735570.webp|300]]
  
  ![[arquitectura-20240501213751219.webp|300]]
  
  ![[arquitectura-20240501213803999.webp|300]]

  
- Mapa de navegación
  Representación esquemática de la estructura del hipertexto.
  ![[arquitectura-20240501213902751.webp|500]]
	Tipos:
	- **Navegación lineal**: Sigue una secuencia lineal
	- **Navegación lineal en estrella**: Va a una pagina y regresa al inicio
	- **Navegación jerárquica**: Muestra la relación entre un tema principal y los subtemas o contenidos asociados que dependen de este
	- **Navegación no lineal**: Permite al usuario moverse libremente
	- **Navegación compuesta**: Combinación de otros sistemas
	- **Navegación múltiple**: Permite moverse a traves de multiples rutas o caminos
	  
	![[arquitectura-20240501213957843.webp]]
	
	![[arquitectura-20240501215708741.webp|400]]



- Definición de contenidos de pantalla de bienvenida
- Definición de contenidos de pantallas genéricas por roles
  

### Vista lógica

Describe el modelo de objetos del diseño cuando se usa un método de diseño orientado a objetos
Para diseñar una aplicación muy orientada a los datos, se puede utilizar un enfoque alternativo para desarrollar algún otro tipo de vista lógica, tal como diagramas de entidad-relación.


### Vista Implementación

Describe la organización estática del software en su ambiente de desarrollo.


### Vista Despliegue

Describe el mapeo del software en el hardware y refleja los aspectos de distribución.


Mapas de navegación.




## Conceptos asociados al diseño 
Bibliografía: Pressman. 7ma Ed. Capítulo 8. Págs. 189-196.

### Abstracción
Facilita la resolución de problemas al reducir su complejidad.
La abstracción es un proceso que simplifica la realidad, enfocándose en lo esencial e ignorando los detalles menos relevantes. 

En programación, se utilizan dos tipos de abstracciones:
1. **Abstracción de procedimiento**: Simplifica una secuencia de instrucciones. Ejemplo: “abrir” para referirse a todos los pasos necesarios para abrir una puerta.
2. **Abstracción de datos**: Agrupa características que describen un objeto. Ejemplo: “puerta” para referirse a sus atributos como tipo, tamaño, etc.


### Modularidad
La modularidad es un concepto clave en el diseño de software que implica dividir un sistema en partes o módulos independientes. Cada módulo tiene una funcionalidad específica y puede desarrollarse de manera independiente, lo que facilita la comprensión, el desarrollo y el mantenimiento del software.

Tener muchos módulos es malo 


### Independencia funcional
La independencia funcional es un concepto clave en el diseño de software que se refiere a la capacidad de un módulo para realizar su función de manera independiente, sin interactuar excesivamente con otros módulos. Este concepto es el resultado de la separación de problemas y de los conceptos de abstracción y ocultamiento de información.

La independencia funcional se evalúa mediante dos criterios: la **cohesión** y el **acoplamiento**.

1. **Cohesión**: 
	Un módulo cohesivo realiza una sola tarea, interactuando poco con otros componentes del programa. Idealmente, un módulo cohesivo debería hacer solo una cosa. Sin embargo, a veces es necesario y aconsejable que un componente de software realice múltiples funciones. A pesar de ello, se debe evitar que un módulo realice funciones no relacionadas.

3. **Acoplamiento**: 
	Es una indicación de la interconexión entre módulos en una estructura de software. . En el diseño de software, se debe buscar el mínimo acoplamiento posible. 
	Una conectividad simple entre módulos resulta en un software que es más fácil de entender y menos propenso a errores que se propagan por todo el sistema.


### Refinamiento 

El **refinamiento stepwise** es como construir un edificio. Comienzas con un plan general (la abstracción) que muestra cómo se verá el edificio cuando esté terminado.

A medida que avanzas en la construcción, empiezas a agregar más detalles al plan


### Refabricación 

práctica de revisar y mejorar la estructura interna de un sistema de software sin cambiar su comportamiento externo


### Clases de diseño

1. **Clases de usuario de la interfaz**: Son las que definen cómo los usuarios interactúan con el software. Por ejemplo, cómo se ve y se usa una página web.
    
2. **Clases del dominio de negocios**: Representan los elementos clave del problema que el software está tratando de resolver. Por ejemplo, en un software de gestión de inventario, podrías tener clases como “Producto” o “Proveedor”.
    
3. **Clases de proceso**: Se encargan de las operaciones de bajo nivel que necesitan las clases del dominio de negocios. Por ejemplo, cómo se actualiza la cantidad de un producto en el inventario.
    
4. **Clases persistentes**: Son las que manejan el almacenamiento de datos, como guardar la información en una base de datos.
    
5. **Clases de sistemas**: Se encargan de las funciones de administración y control del software, como la comunicación con otros sistemas.


Para que una clase de diseño esté “bien formada”, debe ser:

- **Completa y suficiente**: Debe tener todos los atributos y métodos necesarios para su función, y solo esos.
- **Primitiva**: Cada método debe centrarse en realizar una sola tarea.
- **Cohesiva**: Debe tener un conjunto pequeño y centrado de responsabilidades.
- **Poco acoplada**: Debe interactuar lo menos posible con otras clases para facilitar cambios y mantenimiento.






