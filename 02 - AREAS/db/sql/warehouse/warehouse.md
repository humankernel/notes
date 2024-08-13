# Data Warehouse

- Mantener control sobre la información de las empresas 
- Generar pedidos en bajos tiempos de respuestas 
- Centralizar información 
- Lograr un alto grado de concurrencia.

- Los directivos pueden dedicar más tiempo al análisis de los datos en vez de a su búsqueda.
- Se pueden detectar tendencias y hacer previsiones. 
- Facilitan la toma de decisiones estratégicas

## Business Intelligence 

Habilidad para transformar los datos en información, y la información en conocimiento, de forma que se pueda optimizar el proceso de toma de decisiones en los negocios 

Conjunto de metodologías, aplicaciones y tecnologías que permiten reunir, depurar y transformar datos de los sistemas transaccionales para su explotación directa o para su análisis y conversión en conocimiento.

### Herramientas

![[warehouse-20240324100444112.webp|500]]



### Proceso Inteligencia de Negocio

Para hacer el proceso se debe cumplir con 4 fases:

![[warehouse-20240324100804427.webp|294]]

Es un ciclo constante

**Analisis**: 
1. Cuales son los datos imprescindibles para tomar decisiones
2. Identificar donde estan sus fuentes, que pueden ser
	- sistemas transaccionales (bd)
	- datos no estructurados (web, correo, chat)

**Integracion de los datos**:
	Se modelan los datos y se integran de una manera que sea mas facil a las soluciones de BI trabajar sobre el 

**Soluciones BI**
	- hacer mineria
	- objetener reportes
	- pronosticos
	- predicciones

**Despliegue**:
	En el despliegue surgen nuevas interrogantes y eso lleva al analisis de nuevo


> [!info] Data Warehousing #DWH
> Proceso de:
> - extraccion
> - transformacion
> - consolidacion
> - **integracion** 
> - centralizacion de los datos internos (ej: compras, ventas) y los datos externos relacionados
> 
> Permitiendo el **acceso, analisis y exploracion**
> Con el **objetivo** de dar soporte al **proceso de toma de decisiones** estratégico y táctico.
> 
:LiSettings:  Data Warehousing (DWH) es un proceso
:LiDatabase: Data Warehouse (DW) es una BD multidimensional



## DB Clasifications (OLTP vs OLAP)

Segun el **procesamiento de la informacion** que manejan:



**On-Line Transaction Processing (OLTP)**:  
	Maneja las operaciones diarias del negocio
	![[warehouse-20240324110240982.webp]]
	Caracteristicas
		- transacciones en tiempo real
		- los datos **cambian** continuamente
		- estructuras **normalizadas**
		- limitado para la toma de decisiones
		- usa diagrama entidad-relacion (ERD)



**On-Line Analytical Processing (OLAP)**: 
	Sustenta el estudio del comportamiento del negocio y su proyección
	![[warehouse-20240324110222995.webp]]
	Caracteristicas
		- optimizado para consultas
		- almacena varios niveles de datos
		- datos generalmente desnormalizados
		- vista multidimensional
		- grandes volumenes de datos
	



Que pasa si en un OLTP se trata de hacer un OLAP? 
Que pasa si las base de datos tradicional se trata de hacer un analisis de datos?
El resultado es un analisis lento que entorpece el trabajo transaccional diario



|                | OLTP                         | OLAP                         |
| -------------- | ---------------------------- | ---------------------------- |
| Usuario        | Operativos, Profesionales TI | Trabajadores de conocimiento |
| Uso            | Predecible & Repetitivo      | Heuristics                   |
| Accesos        | High                         | Medium - Low                 |
| Tipo de Acceso | R/W & Updates                | R & Sumarizacion             |
| Response Time  | secs                         | secs -> mins                 |
| **Content**    | Atomics Values               | Derived Data                 |
| **Stability**  | Dinamic                      | Static until update          |
| **Function**   | day to day operations        | decision support             |
| **db design**  | application oriented         | subject oriented             |
| **Structure**  | transactional (normalized)   | queries (un-normalized)      |
| # rows         | hundreds                     | millions                     |
| # users        | thousands                    | hundreds                     |
| db size        | 100 MB-GB                    | 100 GB-TB                    |
| metric         | transaction performance      | query performance            |



## Data Warehouse

![[warehouse-20240324115404021.webp|321]]

**orientado al negocio**: 
**integrado**: porque los datos vienen de diferentes fuentes y son integrados en una
**variante en el tiempo**: porque tiene datos historicos
**no volatil**: no se borran datos 

> [!NOTE] Data Marks: 
> Es un subconjunto del DWH, usado normalmente para el análisis parcial de los datos. Es orientado a un área o departamento específico de la organización (por ejemplo, Compras, Ventas, RRHH, etc

![[warehouse-20240324120538290.webp|400]]

![[warehouse-20240324120104567.webp|400]]

**CRM**: Gestion de relacion del cliente (ej: como se atiende al cliente)

A partir de las fuentes de datos se pobla el almacen de datos a partir de un ETL (Extraction - Transform - Load)

## DWH Arquitecture

![[warehouse-20240324120712369.webp|400]]

**Data Sources**: xml, excel, internet
**Load Manager**: ETL
**DW Manager**: 
	- :BoBxsUser: gestiona la autenticacion de los usuarios
	- :BoBxCube: puebla los cubos
	-      gestiona el enlace con la BD 
	- :LiTags: tiene un componente fuerte con los metadatos
**Query Manager**: 
	- consultas relacionadas: como `join` y agregaciones (`sum`, `count`, `avg`, ...) 
	- consultas propias del analisis de datos: `drill-up` y `drill-down`
**Software Analytics**: 
	- reporting
	- OLAP
	- dashboards
	- data mining
	- EIS

## Data Modeling

![[data-modeling.excalidraw|300]]

**fact**: Sales
**measures**: number of products sold
**dimensions**: product - period - location


## Methodologies

> Un DWH no se puede comprar, se tiene que construir

![[dw-metods.excalidraw|300]]

### DW & BI
![[warehouse-20240324124150621.webp|500]]

### CRIPS DM
![[warehouse-20240324124700455.webp|400]]


### Hefesto
![[warehouse-20240324124718150.webp|400]]

1. Analisis de Requerimientos
	- identificar los requisitos informacionales a partir de preguntas
	- identificar los indicadores (medidas), perspectivas (dimensiones)
	- modelo conceptual
	  
2. Analisis de los OLTP
	- hago un mapeo de las fuentes de datos
	- se establece el nivel de detalles con el que se quiere los datos
	- modelo conceptual ampliado
	  
3. Modelo Logico del DW
	- tipo de modelo logico del DW
	- tablas de dimensiones
	- tablas de hechos 
	- uniones

5. Integracion de los datos
	- carga inicial
	- actualizacion


> [!abstract]- DWH Guide
> Análisis de los REQ de información
> 1. Planificar entrevistas 
> 2. Identificar preguntas. 
> 3. Identificar dimensiones y medidas 
> 4. Construcción del modelo conceptual. 
> 5. Validación de los requisitos
>    
>  Análisis del estado de las fuentes de datos
>  1. Definir estado general de los sistemas fuentes. 
>  2. Determinación de las medidas 
>  3. Establecer correspondencias. 
>  4. Nivel de granularidad 
>  5. Ampliación del modelo conceptual 
>  6. Definir reglas del negocio
>     
>  Modelado del Almacén de Datos
>  1. Definir tipo de modelo lógico del almacén de datos. 
>  2. Definir estándares para objetos físicos 
>  3. Identificar dimensiones. • Identificar hechos. 
>  4. Realizar uniones entre dimensiones y hechos 
>  5. Diseñar tablas y columnas físicas
>     
>  Integración de Datos
>  1. Mapeo de datos. 
>  2. Establecer condiciones adicionales y restricciones. 
>  3. Cargas incrementales de datos. 
>  4. Diseño y construcción de la automatización del sistema ETL
>     
>  Representaci ón de la información.
>  1. Diseñar dimensiones y cubos de información. 
>  2. Configurar herramientas de análisis
>     
>   Prueba
>   1. Pruebas de rendimiento y estrés. 
>   2. Aplicación de listas de chequeo

## Conceptual design

![[conceptual-design.excalidraw|500]]


## Logic Design (Schemas)


| Schema       | Complexity | Space  | Response Time | Support |
| ------------ | ---------- | ------ | ------------- | ------- |
| star         | medium     | low    | high          | medium  |
| snowflake    | medium     | medium | medium        | medium  |
| constelation | high       | medium | medium        | high    |


### Star Scheme

- un hecho central 
- tablas de dimensiones relacionadas

![[warehouse-20240324130810028.webp|400]]


### Snowflake Scheme

Cuando la dimension X se quiere con mas detalle y entonces se descompone

![[warehouse-20240324130941356.webp|500]]


### Constelation Scheme

- varias tablas de hechos

![[warehouse-20240324131112948.webp|500]]
## Physical Design 

Como se almacena fisicamente?

![[warehouse-20240324131859646.webp|200]]


![[warehouse-20240324131931985.webp|600]]

![[warehouse-20240324131959084.webp|400]]

### ROLAP 

En los sistemas ROLAP (Relational On Line Analytic Processing), los Cubos Multidimensionales se generan en el momento en que se realizan las consultas

Este proceso se puede resumir a través de los siguientes pasos: 
1. Se describe los metadatos del Cubo: Indicadores, Atributos, Jerarquías, etc. 
2. Se almacena los metadatos. 
3. El Motor Multidimensional del visor OLAP que se esté utilizando, carga la metadatos con la cual realizará un mapeo entre los datos del DW y los Atributos, Indicadores, etc. 
4. Cada vez que se actualiza el DW, se debe borrar la caché del Motor Multidimensional a fin de visualizar los nuevos datos. Esto se debe a que los motores ROLAP hacen uso exhaustivo del caché, lo cual permite que el motor evite consultar dos veces el mismo dato, ya que una vez consultado será almacenado en caché

### MOLAP

MOLAP (Multidimentional On Line Analytic Processing) precalcula los Cubos Multidimensionales y los almacena físicamente.

Este proceso se puede resumir a través de los siguientes pasos: 
1. Se seleccionan los Indicadores, Atributos, Jerarquías, etc., que compondrán el Cubo Multidimensional. 
2. Se precalculan los datos del Cubo, es decir, todas las combinaciones posibles entre los niveles de las Jerarquías de cada Dimensión. 
3. Se ejecutan las consultas sobre los datos precalculados del Cubo. 
4. Cada vez que se actualiza el DW, se debe precalcular y guardar el Cubo, para que contenga los nuevos datos


### HOLAP

HOLAP (Hybrid On Line Analytic Processing) constituye un sistema híbrido entre MOLAP y ROLAP, que combina estas dos implementaciones.

Los datos agregados y precalculados se almacenan en estructuras multidimensionales y los de menor nivel de detalle en estructuras relacionales. Es decir: 
- se utilizará ROLAP para navegar y explorar los datos a bajos niveles de granularidad y 
- se utilizará MOLAP para la explotación de datos precalculados, por lo general sumatorias o funciones de alto de nivel de agregación, 
- suelen se los más utilizados en los dashboards.


### Mapeos

![[warehouse-20240324132053990.webp|300]]





## Ejemplo - Requisitos de información

- Se desea conocer cuántas unidades de cada producto fueron vendidas a sus clientes en un periodo determinado. 
	*Unidades vendidas* de cada <u>producto</u> a cada <u>cliente</u> en un <u>tiempo determinado</u>.

- Se desea conocer cuál fue el monto total de ventas de productos a cada cliente en un periodo determinado.
	*Monto total de ventas* de cada <u>producto</u> a cada <u>cliente</u> en un <u>tiempo determinado</u>. 
	Monto total de ventas (Unidad vendida * Precio de Venta)

![[warehouse-20240324132513908.webp|500]]

![[warehouse-20240324132528577.webp|400]]



## Ejemplo - 

Se desea realizar un análisis estadístico del acceso a la web de la UCI. 
Se desea responder a las siguientes necesidades del negocio
- Días más visitados. 
- Horas con mayor afluencia 
- Número de visitas 

![[warehouse-20240324133509274.webp]]

Se tiene almacenado fecha y hora de visita, ip de quien visitó, navegador_usado, url del recurso accedido, si tuvo éxito o no en el acceso, etc

**Proceso de negocio**: Visita (HECHO)
**Dimensiones**: 
	- cliente: ip 
	- Recurso: desc_recurso 
	- Navegador: desc, versión 
	- Fecha: año, mes, desc_mes, semana_año, desc_semana, día, desc_dia, hora, minuto, segundo 
	- Resultado: dec_res, código 
**Medida**: Número de visitas

![[warehouse-20240324133733911.webp|500]]

![[warehouse-20240324133748144.webp|500]]

