# NoSQL - "not only SQL" or "non relational"
> types of databases optimized specifically for applications that **require flexible data models, large data volume, and low latency**, which are achieved by relaxing some of the data consistency restrictions of relational databases

[How do NoSQL databases work? Simply Explained!](https://www.youtube.com/watch?v=0buKQHokLK8)

| SGBD Relacional                                                                                                                         | BD NoSQL                                                                                                                                                    |
| --------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Es fundamental la estructura de las entidades y cómo se relacionan.                                                                     | El rendimiento es más importante que preservar el modelo, aunque también modelamos estos aspectos                                                           |
| Respondió a la necesidad de resolver las anomalías en los datos y a la dificultad de reutilizar BD existentes para nuevas aplicaciones. | Surgen ante una necesidad: las dificultades para escalar y dar respuesta a las crecientes demandas de altos volúmenes de operaciones de lectura y escritura |

> [!faq] When NoSQL ?
> NoSQL database is best for handling indeterminate, unrelated, or rapidly changing data
>  
>  You can use it for applications that:
>  - high volume of reads & writes
>  - Need flexible schemas that enable faster and more iterative development.  
>  - **Prioritize performance over strong data consistency** and maintaining relationships between data tables (referential integrity).
>  - **Require horizontal scaling** by sharding across servers.
>  - Support for semi-structured and unstructured data.
>  - latency is important 
>  - availability & recovery from loses
>  - tolerance for inconsistency in data


> [!success] Advantages
> Applications **process** a large data volume from **disparate sources** like social media, smart sensors, and third-party databases. All of this disparate data doesn't fit neatly into the relational model
> 
> **Flexibility**: 
> provide flexible schemas that enable faster and more iterative development. 
> This makes it ideal for semi-structured and unstructured data.
> 
> **Scalability**:
> designed to scale out by using distributed clusters of hardware, 
> 
> **High Performance**:
> optimized for specific data models and access patterns
> 
> **Highly functional**:
> provide highly functional APIs and data types that are purpose-built for each of their respective data models

> [!fail] Disadvantages
> - **not standard language**: 
> 	- this dificult migration from one to other
> 	- forced to learn each individual language
> 	- complex querys involve programming 
> - concistency has to be mantained in the application not in the schema


> [!important]- use cases
> **Real-Time data managment**:
> - You can deliver real-time recommendations, personalization
> - It can scale and deliver popular features such as Continue Watching, Watchlist, and Personalized Recommendations with [Amazon DynamoDB](https://aws.amazon.com/dynamodb/)
> 
> **Cloud Security**:
> - You can use graph databases to quickly discover complex relationships within your data
> - [Wiz](https://aws.amazon.com/blogs/database/the-world-is-a-graph-how-wiz-reimagines-cloud-security-using-a-graph-in-amazon-neptune/) re-imagined cloud security as a graph using [Amazon Neptune](https://aws.amazon.com/neptune/).The Wiz risk engines traverse the graph and within seconds, weave together a series of interconnected risks factors in a security graph
>   
> **High-availability applications** 
> - Distributed NoSQL databases are excellent for building high-availability, low-latency applications for messaging, social media, file sharing, and more
> - Snapchat uses NoSQL database systems to reduce the median latency of sending messages by 20%.


> [!NOTE]- Big Data 
> 
> ![[no-sql-20240331134530877.webp]]


## How do NoSQL databases work?

![[no-sql.excalidraw]]

In a relational database, a book record is often disassembled (or “normalized”) and stored in separate tables, and relationships are defined by primary and foreign key constraints

The relational model is designed to enable the database to **enforce referential integrity** between tables in the database, normalized to reduce the redundancy, and generally optimized for storage

In a NoSQL database, a book record is usually stored as a document, in this model, data is optimized for intuitive development and horizontal scalability.


## SQL vs. NoSQL

✔️ Aplicando MapReduce, las bases de datos NoSQL pueden **paralelizar operaciones complejas** como agregaciones estadísticas, filtros, agrupaciones o ordenación

✔️ En NoSQL, los datos son recuperados de manera mucho más rápida que en un RDBMS
❌ sin embargo las consultas que se pueden hacer son más limitadas y requieren trasladar complejidad a la aplicación 

❌ RDBMS para escribir usan locks y redos para garantizar ACID, pero NoSQL no soporta a menudo Atomicy, Consistency o Durability. 
❌ No soporte transaccional integral
❌ Aplicaciones que generan informes emplean consultas complejas para las que NoSQL no es muy adecuado


> [!NOTE] Key differences:
> 
> - No usan SQL como el principal lenguaje de consultas. 
> - Normalmente no soportan operaciones JOIN, 
> - Ni garantizan completamente ACID (atomicidad, consistencia, aislamiento y durabilidad), 
> - Habitualmente escalan bien horizontalmente
> 
> - Los datos almacenados no requieren estructuras fijas como tablas 
> - Utilizan una variedad de modelos de datos para acceder y administrar datos.



|                   | Relational                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | NoSQL                                                                                                                                                                                                                                                                                                                                            |
| ----------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Optimal workloads | [Relational databases](https://aws.amazon.com/relational-database/) are designed for transactional and strongly consistent online transaction processing (OLTP) applications. They are also good for online analytical processing (OLAP).                                                                                                                                                                                                                                                                               | NoSQL databases are designed for a number of data access patterns that include low-latency applications. NoSQL search databases are designed for analytics over semi-structured data.                                                                                                                                                            |
| Data model        | - data is normalized <br>- its s strict schema<br>- referential integrity is inforced                                                                                                                                                                                                                                                                                                                                                                                                                                   | - key-value<br>- document<br>- graph<br>- column                                                                                                                                                                                                                                                                                                 |
| ACID properties   | Relational databases provide atomicity, consistency, isolation, and durability (ACID) properties:<br><br>- Atomicity requires a transaction to execute completely or not at all.<br>- Consistency requires that the data must conform to the database schema when a transaction has been committed.<br>- Isolation requires that concurrent transactions execute separately from each other.<br>- Durability requires the ability to recover from an unexpected system failure or power outage to the last known state. | Most NoSQL databases offer trade-offs by relaxing some of the ACID properties of relational databases in favor of a more flexible data model that can scale horizontally. This makes NoSQL databases an excellent choice for high-throughput, low-latency use cases that need to scale horizontally beyond the limitations of a single instance. |
| Performance       | generally dependent on the disk subsystem. The optimization of queries, indexes, and table structure is often required to achieve peak performance.                                                                                                                                                                                                                                                                                                                                                                     | Performance is generally a function of the underlying hardware cluster size, network latency, and the calling application.                                                                                                                                                                                                                       |
| Scale             | Relational databases typically scale up by increasing the compute capabilities of hardware or scale out by adding replicas for read-only workloads.                                                                                                                                                                                                                                                                                                                                                                     | NoSQL databases are typically partitionable. This is because access patterns can scale out by using distributed architecture to increase throughput that provides consistent performance at near-boundless scale.                                                                                                                                |
| APIs              | Requests to store and retrieve data are communicated using queries that conform to a structured query language (SQL). These queries are parsed and executed by the relational database.                                                                                                                                                                                                                                                                                                                                 | Object-based APIs allow app developers to easily store and retrieve data structures. Partition keys let apps look up key-value pairs, column sets, or semi-structured documents that contain serialized app objects and attributes.                                                                                                              |

### Terminology

| **SQL**                | **MongoDB**       | **DynamoDB**           | **Cassandra**     | **Couchbase** |
| ---------------------- | ----------------- | ---------------------- | ----------------- | ------------- |
| Table                  | Collection        | Table                  | Table             | Data bucket   |
| Row                    | Document          | Item                   | Row               | Document      |
| Column                 | Field             | Attribute              | Column            | Field         |
| Primary key            | ObjectId          | Primary key            | Primary key       | Document ID   |
| Index                  | Index             | Secondary index        | Index             | Index         |
| View                   | View              | Global secondary index | Materialized view | View          |
| Nested table or object | Embedded document | Map                    | Map               | Map           |
| Array                  | Array             | List                   | List              | List          |



## types 

![[no-sql-types.excalidraw]]


![[no-sql-20240331154811496.webp|500]]


### key-value 
> A key-value database stores data as a collection of key-value pairs in which a **key serves as a unique identifier**

[Key-value databases](https://aws.amazon.com/nosql/key-value/) are highly partitionable and allow horizontal scaling at a level that other types of NoSQL databases may not achieve
Based on DHT (Distributed Hash Tables)
Son las bases de datos NoSQL más simples. Cada elemento de la base de datos se almacena como un nombre de atributo (o «clave»),junto con su valor

> [!success] Good for 
> 1. Lecturas y escrituras pequeñas pero frecuentes 
> 2. Modelo de datos sencillo 
> 3. Dominios sencillos (strings, enteros, booleanos, …), o estructurados (listas, conjuntos, …) 
> 4. Menor capacidad de consultas que BD orientadas a documentos, orientadas a grafos y de familia de columnas.


> [!NOTE] use cases 
> - Almacenamiento de sesiones de usuarios 
> - Caché de BD relacional para mejorar el rendimiento 
> - Atributos temporales en aplicaciones web (carrito de compra) 
> - Datos de configuración y usuario en aplicaciones móviles 
> - Almacenamiento de grandes objetos, como imágenes o audio
> - Juegos, tecnología publicitaria e IoT

![[no-sql-20240331142702484.webp|400]]

### document
> They store data as (JSON - XML - BSON) objects that are flexible, semi-structured, and hierarchical in nature..


> [!success] Good for
> Modelado de datos natural 
> Amigables al programador 
> Desarrollo rápido 
> Orientas a la web: CRUD

> [!NOTE] use cases 
> - catalogs
> - user profiles
> - CMS
> - Sitios web con alta carga de lecturas y escrituras 
> - Gestión de tipos de datos con atributos variables 
> - Aplicaciones que utilizan estructuras de datos JSON 
> - Aplicaciones que sacan partido de la desnormalización de datos (embebiendo documentos)


![[no-sql-20240331143412907.webp|400]]

```json
{
      "backdrop_path": "/sR0SpCrXamlIkYMdfz83sFn5JS6.jpg",
      "genre_ids": [
        28,
        878,
        12
      ],
      "id": 823464,
      "original_language": "en",
      "original_title": "Godzilla x Kong: The New Empire",
      "overview": "Following their explosive showdown, Godzilla and Kong must reunite against a colossal undiscovered threat hidden within our world, challenging their very existence – and our own.",
      "popularity": 5072.084,
      "poster_path": "/iG5sbWWK1JEPAxdt3ItsCMGGV4p.jpg",
      "release_date": "2024-03-27",
      "title": "Godzilla x Kong: The New Empire",
      "video": false,
      "vote_average": 6.806,
      "vote_count": 276
    }
```

### graph
> built to make it easy to build and run applications that work with highly connected datasets

They use nodes to store data entities and edges to store relationships between entities


> [!success] Good for
> - model a domain in graph format, as a common way to represent and understanding datasets 
> - Excelente rendimiento cuando los datos están interconectados y no tabulares
> - Realizar operaciones transaccionales que exploten las relaciones entre entidades

> [!NOTE] use cases 
> - social networking 
> - recommendation engines
> - fraud detection
> - knowledge graphs
> - Gestión de redes e infraestructuras
> - Autovías que conectan ciudades, 
> - Proteínas que interactúan 
> - Investigadores que colaboran
> - Recomendación de productos y servicios

![[no-sql-20240331144955908.webp|300]]


### in-memory
> While other non-relational databases store data on disk or SSDs, [in-memory data stores](https://aws.amazon.com/nosql/in-memory/) are designed to eliminate the need to access disks

They are ideal for applications that require microsecond response times or have large spikes in traffic

Example: Redis

> [!info] use cases 
> - gaming 
> - ad-tech applications (leaderboards, session stores, and real-time analytics)

### search
> dedicated to the search of data content, such as application output logs used by developers to troubleshoot issues

They use indexes to categorize similar characteristics among data and facilitate search capability. Search-engine databases are optimized for sorting unstructured data like images and videos




### columns 

Modelo de datos: familia de columnas, esto es, un modelo tabular donde cada fila puede tener una configuración diferente de columnas 
- Guardan datos por columna en vez de las BBDD tradicionales que lo hacen por filas 


![[no-sql-20240331143058236.webp]]


> [!success] Good for
> ❌ No está pensada para funcionar en un servidor único. 
> 
> Son especialmente indicadas cuando: 
> - Grandes volúmenes de datos (cientos de TB), rendimiento de lectura/escritura, alta disponibilidad. 
> - Aplicaciones requieran alta carga de escritura en la BD 
> - Aplicaciones distribuidas geográficamente en múltiples centros de datos 
> - Aplicaciones que toleren cierta (breve) inconsistencia en las réplicas


> [!NOTE] use cases: 
> - Blogs
> - Event logging


![[no-sql-20240331143237029.webp]]
























![[no-sql-20240331154916984.webp]]




BD Relacional 
- Conjunto finito de relaciones 
- Estructura bidimensional (tabla) formada por columnas (atributos) y filas (tuplas) 
- Para mantener la semántica se deben respetar las restricciones de integridad 
- Esquema rígidos definidos a priori. Diseño con el DER 
- Utilizan el lenguaje estándar SQL. 
- Garantiza las propiedades ACID (Atomicity, Consistency, Isolation and Durability)

SQL es el lenguaje de consultas predominante Basado en:
1. Algebra Relacional (teoría de conjuntos) 
	Obtiene resultado aplicando varios operadores 
2. Cálculo Relacional (lógica de primer orden) 
	Orientado a tuplas Orientado a dominios

Objeto -> base de datos -> tabla -> fila
Modelo de datos: 
Normalización del esquema de la base de datos a BCNF o 3NF 
Algoritmos: descomposición o síntesis 
Dependencias funcionales- 1NF, 2NF, 3NF, BCNF (Forma Normal de Boyce-Codd)

Disminuir la redundancia de datos, evitar las anomalías de actualización Los datos están dispersos en pequeños trozos (alta granularidad), por lo que hay que volver a unir estos trozos al realizar la consulta.



## ACID vs BASIC Transactions

 ![[acid.excalidraw]]

Mayority of Relational DB are ACID compliend and some NoSQL 





BAsic availability: Siempre se obtiene una respuesta del sistema a una petición de datos aunque esta sea un fallo o que sean inconsistentes o estén en fase de cambio. 

Soft-state: el estado del sistema cambia constantemente a lo largo del tiempo, incluso aunque no hayan entradas de datos en ese periodo, debido a la consistencia eventual. 

Eventual consistency: eventualmente, el sistema se volverá consistente a partir de que deje de recibir datos. Los datos se propagarán pero el sistema seguirá recibiendo datos sin evaluar la consistencia de los datos para cada transacción antes de avanzar a la siguiente


| ACID                  | BASE             |
| --------------------- | ---------------- |
| high consistency      | low consistency  |
| isolation             | availability     |
| requires "commit"     | better effort    |
| anidated transactions | faster responses |
| low availability      | intuitive        |
| hard to scale         | easy to scale    |


## CAP Theorem (Brewer's Theorem)
#cap-theorem #brewer-theorem

> any distributed system can only provide 2 of these 3 garantees

**Consistency**: all clients watch the same data at the same time, regardless of the node they are connected. 

**Availability**: every client gets a response to his request, even if one or more nodes are unavailable 

**Partition tolerance**: the system must go on even if a failure has occur


![[cap-theorem.excalidraw]]

**CA**
- capacidad de escalabilidad horizontal es limitada
- PostgreSQL, MySQL, ...

**CP**
- pueden ocurrir fallos de comunicacion temporales entre los nodos pero siempre se garantiza la consistencia de los datos
- MongoDB, Redis, MemCache

**AP**
- no implementan maestro esclavo, usan P2P
- pej: lo que lleva consigo que se escriba en varios nodos y la conciliacion se alcance en un intervalo de tiempo $t \gt 0$



## newSQL

Nuevas arquitecturas Google Spanner, CockroachDB, Altibase, Apache Ignite, Microsoft Cosmos DB, GridGain, TiDB, Clustrix, VoltDB, MemSQL, NuoDB, HarperDB and Trafodion

Motores SQL: optimizada como motor de almacenamiento de SQL MySQL Cluster, Infobright, TokuDB, MyRocks, SQL Server (with ColumnStore and InMemory features), and MariaDB Columnstore.

Protección transparente Estos sistemas proporcionan una capa de middleware de fragmentación para dividir automáticamente las bases de datos en varios nodos dbShards, Scalearc, Scalebase y MySQL Cluster.


![[no-sql-20240331152531567.webp]]


