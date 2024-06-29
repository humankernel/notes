# DML (Data Modeling Language)

## SELECT

```sql
SELECT colum, another_column, ... FROM mytable
SELECT * FROM mytable
```


> [!Info]
> Is recommend that when expressions are used in the `SELECT` part of the query, that they are also given a descriptive _alias_ using the `AS` keyword

```sql
SELECT particle_speed / 2.0 AS half_particle_speed
FROM physics_data
WHERE ABS(particle_position) * 10.0 > 500;

-- with column
SELECT col_expression AS expr_description, …
FROM mytable;

-- with tables
SELECT column AS better_column_name, …
FROM a_long_widgets_table_name AS mywidgets
	INNER JOIN widget_sales
	ON mywidgets.id = widget_sales.widget_id;

-- list of acumulated sales in millions
SELECT * , (domestic_sales + international_sales)/1000000 as combined_sales FROM movies
    JOIN boxoffice
    ON movies.id = boxoffice.movie_id
```

### Constrains

```sql
SELECT column, another_column, … 
FROM mytable 
WHERE condition 
	AND/OR another_condition 
	AND/OR …;
```


| Operator | Condition | SQL Example |
| ---- | ---- | ---- |
| =, !=, < <=, >, >= | Standard numerical operators | col_name != 4 |
| BETWEEN … AND … | Number is within range of two values (inclusive) | col_name BETWEEN 1.5 AND 10.5 |
| NOT BETWEEN … AND … | Number is not within range of two values (inclusive) | col_name NOT BETWEEN 1 AND 10 |
| IN (…) | Number exists in a list | col_name IN (2, 4, 6) |
| NOT IN (…) | Number does not exist in a list | col_name NOT IN (1, 3, 5) |
| LIKE | Case insensitive exact string comparison | col_name LIKE "ABC" |
| NOT LIKE | Case insensitive exact string inequality comparison | col_name NOT LIKE "ABCD" |
| % | Used anywhere in a string to match a sequence of zero or more characters (only with LIKE or NOT LIKE) | col_name LIKE "%AT%" (matches "AT", "ATTIC", "CAT" or even "BATS") |
| _ | Used anywhere in a string to match a single character (only with LIKE or NOT LIKE) | col_name LIKE "AN_" (matches "AND", but not "AN") |
| IN (…) | String exists in a list | col_name IN ("A", "B", "C") |
| NOT IN (…) | String does not exist in a list | col_name NOT IN ("D", "E", "F") |


### WHERE - ORDER BY

```sql
SELECT DISTINCT column, another_column, …
FROM table1, ...
WHERE condition(s)

ORDER BY column ASC/DESC;
LIMIT num_limit OFFSET num_offset;
```

`DISTINCT`: remove duplicates rows
`ORDER BY column ASC/DESC`: 
`LIMIT number OFFSET num`


### JOIN

```sql
SELECT column, another_table_column, …
FROM mytable
INNER/LEFT/RIGHT/FULL JOIN another_table
    ON mytable.id = another_table.id
WHERE condition(s), (subquerys, LIKE ...)
ORDER BY column, … ASC/DESC
LIMIT num_limit OFFSET num_offset;
```

![[Pasted image 20230913163725.webp]]


### Aggregates

```sql
SELECT AGG_FUNC(column_or_expression) AS aggregate_description, …
FROM mytable
WHERE constraint_expression;
```


| fn                          | description                                                                                                                                                                                     |
| --------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `COUNT(*),` `COUNT(column)` | A common function used to counts the number of rows in the group if no column name is specified. Otherwise, count the number of rows in the group with non-NULL values in the specified column. |
| `MIN(column)`               | Finds the smallest numerical value in the specified column for all rows in the group.                                                                                                           |
| `MAX(column)`               | Finds the largest numerical value in the specified column for all rows in the group.                                                                                                            |
| `AVG(column)`               | Finds the average numerical value in the specified column for all rows in the group.                                                                                                            |
| `SUM(column)`               | Finds the sum of all numerical values in the specified column for the rows in the group.                                                                                                        |
|                             | [docs](https://www.postgresql.org/docs/16/functions-window.html)                                                                                                                                |


#### ejemplo 
 
`row_number():` asigna un número de fila a cada empleado dentro de su departamento, ordenado por salario

```sql
SELECT nombre, departamento, salario, 
row_number() OVER (
	PARTITION BY departamento 
	ORDER BY salario DESC) AS rango_salario
FROM empleados;
```

`percent_rank():` calcula el rango percentil de las ventas de cada miembro del personal

```sql
SELECT CONCAT_WS(' ', first_name, last_name) AS nombre_completo,
       net_sales, percent_rank() OVER (
	       ORDER BY net_sales DESC) AS percent_rank
FROM ventas;
```

`rank()`: otorga un rango a los productos de inventario según sus ventas

```sql
SELECT nombre, ventas, 
rank() OVER (ORDER BY ventas DESC) AS rango_ventas
FROM ventas;
```

`dense_rank()`: otorga un rango a los productos de inventario según sus ventas, pero a diferencia de rank(), siempre genera valores de rango consecutivos

```sql
SELECT nombre, ventas, 
DENSE_RANK() OVER (ORDER BY ventas DESC) AS rango_ventas
FROM ventas;
```

`last_value(column):` devuelve el nombre del producto más caro

```sql
SELECT nombre, precio, 
	last_value(nombre) OVER (ORDER BY precio) AS producto_mas_caro
FROM productos;
```

`first_value(column)`: devuelve el nombre del producto más barato

```sql
SELECT nombre, precio, 
first_value(nombre) OVER (ORDER BY precio) AS producto_mas_barato
FROM productos;
```



### Grouped aggregate functions

In addition to aggregating across all the rows, you can instead apply the aggregate functions to individual groups of data within that group (ie. box office sales for Comedies vs Action movies).

```sql
SELECT AGG_FUNC(column_or_expression) AS aggregate_description, …
FROM mytable
WHERE constraint_expression
GROUP BY column;

SELECT SUM(years_employed) FROM employees
WHERE role = "Engineer"
GROUP BY role

-- the same as

SELECT SUM(years_employed) FROM employees
GROUP BY role
HAVING role = "Engineer"
```


## Order of execution (SELECT)

```sql
-- complete select query
SELECT DISTINCT column, AGG_FUNC(column_or_expression), …
FROM mytable
    JOIN another_table
      ON mytable.column = another_table.column
    WHERE constraint_expression
    GROUP BY column
    HAVING constraint_expression
    ORDER BY column ASC/DESC
    LIMIT count OFFSET COUNT;
```

![[sql_SELECT_order_of_execution.excalidraw.svg]]


### 1. `FROM` and `JOIN`s

The `FROM` clause, and subsequent `JOIN`s are first executed to determine the total working set of data that is being queried. This includes subqueries in this clause, and can cause temporary tables to be created under the hood containing all the columns and rows of the tables being joined.

### 2. `WHERE`

Once we have the total working set of data, the first-pass `WHERE` constraints are applied to the individual rows, and rows that do not satisfy the constraint are discarded. Each of the constraints can only access columns directly from the tables requested in the `FROM` clause. Aliases in the `SELECT` part of the query are not accessible in most databases since they may include expressions dependent on parts of the query that have not yet executed.

### 3. `GROUP BY`

The remaining rows after the `WHERE` constraints are applied are then grouped based on common values in the column specified in the `GROUP BY` clause. As a result of the grouping, there will only be as many rows as there are unique values in that column. Implicitly, this means that you should only need to use this when you have aggregate functions in your query.

### 4. `HAVING`

If the query has a `GROUP BY` clause, then the constraints in the `HAVING` clause are then applied to the grouped rows, discard the grouped rows that don't satisfy the constraint. Like the `WHERE` clause, aliases are also not accessible from this step in most databases.

### 5. `SELECT`

Any expressions in the `SELECT` part of the query are finally computed.

### 6. `DISTINCT`

Of the remaining rows, rows with duplicate values in the column marked as `DISTINCT` will be discarded.

### 7. `ORDER BY`

If an order is specified by the `ORDER BY` clause, the rows are then sorted by the specified data in either ascending or descending order. Since all the expressions in the `SELECT` part of the query have been computed, you can reference aliases in this clause.

### 8. `LIMIT` / `OFFSET`

Finally, the rows that fall outside the range specified by the `LIMIT` and `OFFSET` are discarded, leaving the final set of rows to be returned from the query.


## INSERT

```sql
INSERT INTO mytable
VALUES (value_or_expr, another_value_or_expr, …),
       (value_or_expr_2, another_value_or_expr_2, …),
       …;
```

In some cases, if you have incomplete data and the table contains columns that support default values, you can insert rows with only the columns of data you have by specifying them explicitly

```sql
INSERT INTO mytable
(column, another_column, …)
VALUES (value_or_expr, another_value_or_expr, …),
      (value_or_expr_2, another_value_or_expr_2, …),
      …;

-- you can use mathematical and string expressions
INSERT INTO boxoffice
(movie_id, rating, sales_in_millions)
VALUES (1, 9.9, 283742034 / 1000000);
```

> [!Tip]
> In these cases, the number of values need to match the number of columns specified. Despite this being a more verbose statement to write, inserting values this way has the benefit of being forward compatible. For example, if you add a new column to the table with a default value, no hardcoded `INSERT` statements will have to change as a result to accommodate that change.




## UPDATE

you have to specify exactly which table, columns, and rows to update.

```sql
UPDATE mytable
SET column = value_or_expr, 
    other_column = another_value_or_expr, 
    …
WHERE condition;
```

> [!Tip]
> One helpful tip is to always write the constraint first and test it in a `SELECT` query to make sure you are updating the right rows, and only then writing the column/value pairs to update.


## DELETE

```sql
DELETE FROM mytable
WHERE condition;
```




## Schemas

> [!Info]
> The _database schema_ is what describes the structure of each table, and the datatypes that each column of the table can contain




