# Index

Cuando muchas consultas solamente hacen referencia a una pequeña proporción de los datos.

>[!faq]- When?
>When you need to **search** something (`SELECT, UPDATE, DELETE, joins`)
>
>- High Selectivity (more unique elements than duplicated)
>	- unleas the more frecuent used values are the low percent 
>- columns where joins are performed
>- when you want the result in order
>- 🙅 no in frecuent **modified** columns
>- 🙅 no in short tables
>- 🙅 no in tables that return a great amount of data
>
>
>- No indexar columnas que solamente aparecen en sentencias WHERE con operadores o funciones (que no sean `MIN` y `MAX`)

> [!faq]- When NOT?
> - SLOW update, insert, delete times ...
> - Takes disk space to store the index, somethings more space
> - It requires CPU time to stay sync

> [!info]- Selectividad
>  The rate amount of unique data
>  $$S = \frac{u}{n}$$
> ```sql
> select (count(distinct age)::float / count(*)::float) 
> 	as selectivity  
> from member;
> ```
>  
> **High** (close to 1): 
> Usar indices es viable. Es útil cuando las consultas a menudo buscan valores únicos o raros..
> 	
> **Low** (close to 0): 
> la base de datos podría terminar escaneando una gran parte de la tabla de todos modos, incluso con el índice.


## Syntax

```sql
CREATE [UNIQUE] INDEX [CONCURRENTLY] name_index 
ON table1 [USING method] 
( {column | (expression)} [ASC | DESC] [NULLS {FIRST | LAST}] [, ...] ) 
[WHERE predicate]

ALTER INDEX name RENAME TO new_name

DROP INDEX name

-- in case of corruption you can rebuild the indexes
-- similar to delete and re-create the index
REINDEX {INDEX | TABLE | DATABASE | SYSTEM} name
```


`column`: 
	El nombre de la columna de la tabla a la cual desea asociar el índice.
	(puede ser más de una columna (índices multicolumnas) cada una con sus opciones)

`expresion`: Una expresión basada en una o más columnas de la tabla.
	
`NULLS {FIRST | LAST}`: 
	Especifica la posición de los valores nulos. La opción `FIRST` se activa por defecto cuando se especifica `DESC`.

`UNIQUE`: 
	Crea un índice para los cuales los valores deben ser únicos y diferentes. 
	(Provoca que el sistema compruebe si existen valores duplicados en la tabla cuando se crea el índice (si ya existen datos) y cada vez que se añaden datos. Solo los índices Btree pueden ser declarados UNIQUE. Los valores nulos no se consideran iguales)

`CONCURRENTLY`: 
	Normalmente PostgreSQL bloquea contra escritura la tabla para que se indexe e interpreta todo el índice con una sola exploración de la misma. 
	Otras transacciones pueden hacer uso de la tabla, pero no podrán insertar, actualizar o eliminar filas en ella hasta que la construcción del índice haya terminado. Con la opción CONCURRENTLY, se creará el índice sin utilizar bloqueos

`USING method`: 
	Especifica el nombre del método de acceso que se utilizará para el índice  (defecto es BTREE). 

`WHERE predicate`: 
	permite crear índices para una parte de la tabla definida por un predicado
	(Cuando la cláusula WHERE está presente, se crea un índice parcial)



```sql
-- multi-column
SELECT * FROM empleado WHERE edad < 35 AND salario = 3000;
CREATE INDEX idx_empleado_edad_salario 
	ON empleado (edad, salario);

select * from empleado where salario > 3000;
CREATE INDEX empleado_salario_idx 
	ON empleado 
	USING btree (salario);

-- case insensitive without write-locks
CREATE INDEX CONCURRENTLY idx_lower_dpto ON empleado (lower(departamento));

-- index with order by departm with first the nulls
CREATE INDEX idx_dpto_nulls_first ON empleado (departamento NULLS FIRST);

-- reconstruir los indices de la tabla empleado
REINDEX TABLE empleado;
```


> [!note]- Methods:
> **BTREE**: 
> Una implementación de los btrees de alta concurrencia. 
> 👍:  $(\lt,\le,=,\ge,\gt)$. 
> 
> **HASH**: 
> Una implementación de las dispersiones lineales de Litwin. 
> 👍: $(=)$, 
> 👎: no admiten búsquedas usando operadores `IS NULL`
> 
> **GiST (Generalized Search Tree)**: 
> 👍: Para datos complejos (datos geométricos o de texto). 
> 
> **GIN (Generalized Inverted Index)**: 
> 👍: Búsquedas de texto completo (para indexar palabras o frases en documentos)
> son los antiguos Rtree. 
> 
> **BRIN**: 
> 👍: el trabajo con rangos de bloques físicos almacenados consecutivamente


## Classification

- Physical Order:
	- **Clustered Index**: 
		It modify the order in which the data related to the index are store
		This OPTIMIZE the performance 
		`cluster table1 using idx_name;`
		
	- **Non-Clustered Index**: 
		Don't modify the order of the data

- Data Relation:
	1. **Primary Index**: 
		Automatically created for primary keys. 
		
	2. **Secondary Index**: 
		Used defined for simple columns
		
	3. **Partial Index (Where)**: 
		Este contiene entradas sólo para una parte de la tabla
		
	4. **Multicolumn Index:**
		- Columnas que son frecuentemente usadas juntas en condiciones WHERE combinadas con operadores AND
		- Especialmente si su selectividad combinada es mejor que la selectividad de cualquiera de las columnas en forma separada
		- (sólo los Btree y los Gist soportan índices de varias columnas)


### Multicolumn

- In the index the columns at used in the `WHERE` condition has to be at first

- Si todas las columnas se usan en las sentencias WHERE con igual
frecuencia, se mejora la performance de la consulta ordenando las
columnas en la sentencia CREATE INDEX desde la más selectiva a la
menos selectiva.

- Si todas las columnas se usan con la misma frecuencia en la sentencia
WHERE pero los datos están físicamente ordenados en una de esas
columnas, se debe ubicar esa columna en primer lugar del índice
compuesto.




B-Tree
![[Pasted image 20240206143438.webp|400]]


Hash Table
![[Pasted image 20240206143457.webp|400]]


R-Tree:
![[Pasted image 20240206153245.webp]]

![[Pasted image 20240206153329.webp]]






