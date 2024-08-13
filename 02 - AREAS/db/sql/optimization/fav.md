# FAV (Aggregated Window Functions)

[SQL Window Functions in 10 Minutes - YouTube](https://www.youtube.com/watch?v=y1KCM8vbYe4)


> [!Note] Cuando usar una?
> 1. **Cálculos agregados sin agrupación**: 
> A diferencia de las funciones de agregado estándar, las funciones de ventana *no agrupan el conjunto de resultados*. 
> El número de filas en la salida es el mismo que el número de filas en la entrada. Esto es útil cuando necesitas realizar cálculos agregados pero aún quieres mantener todas las filas de datos
> 2. **Cálculos agregados en una ventana de filas**: 
> Por ejemplo, si quisieras mostrar el salario total de los empleados junto con cada valor de fila, podrías usar una función de ventana


¿Cuál es la diferencia del salario de cada uno de los empleados con respecto a la media de su departamento?

```sql
SELECT e1.empid, e1.departamento, e1.edad, e1.salario, (
	SELECT avg(e2.salario) 
	FROM empleado e2 
	WHERE e2.departamento=e1.departamento 
) as salario_medio 
FROM empleado e1;
```

![[Pasted image 20240124195643.webp|700]]

This runs very SLOW !!!

## FAV vs GROUP BY

![[Pasted image 20240124200554.webp|400]]


![[Pasted image 20240124200601.webp|400]]



![[Pasted image 20240124200533.webp|400]]


Mostrar el empid, departamento, salario, edad y el promedio de los salarios por departamento, para poder realizar la comparación.

```sql
SELECT empid, departamento, edad, salario 
	avg (salario) OVER
	(PARTITION BY departamento) AS salario_medio
FROM empleado;


select dateid, pricepaid,
sum(pricepaid) over(order by dateid, pricepaid rows unbounded preceding) as sumpaid
from sales
```

## Frame

Conjunto de filas que se tendran en cuenta para computar el resultado

```sql
[RANGE | ROWS] frame_start
[RANGE | ROWS] BETWEEN frame_start AND frame_end
```

El marco puede ser un conjunto simple de filas hasta la fila actual, que se incluye.

{UNBOUNDED PRECEDING | offset PRECEDING | CURRENT ROW}

O bien, puede ser un conjunto de filas entre dos límites.

BETWEEN
{ UNBOUNDED PRECEDING | offset { PRECEDING | FOLLOWING } | CURRENT ROW }
AND
{ UNBOUNDED FOLLOWING | offset { PRECEDING | FOLLOWING } | CURRENT ROW }

|  |
| ---- |
$$\text{frame start} < \text{frame end}$$


```sql
-- calcular el promedio de los salario teniendo en cuenta la fila actual mas los salarios de las 2 filas siguientesS
SELECT empid, departamento, salario, edad, 
avg (salario) OVER 
	(PARTITION BY departamento 
	ROWS BETWEEN CURRENT ROW AND 2 FOLLOWING) AS salario_medio 
FROM empleado
```

![[Pasted image 20240124215247.webp]]


## Aggregated Built in 

| fn               | desc                                                                                                                                                 |
| ---------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| `row_number()`   | el numero de la fila actual dentro de su partición (a partir de 1 cada vez)                                                                          |
| `rank()`         | Returns the rank of the current row, with gaps; that is, the `row_number` of the first row in its peer group.                                        |
| `dense_rank()`   | Returns the rank of the current row, without gaps; this function effectively counts peer groups.                                                     |
| `percent_rank()` | Returns the relative rank of the current row, that is <br>(`rank` - 1) / (total_partition_rows - 1). <br>The value thus ranges from 0 to 1 inclusive |
| `first_value()`  | Returns _`value`_ evaluated at the row that is the first row of the window frame                                                                     |
| `last_value()`   |                                                                                                                                                      |

```sql
SELECT
  columna,
  RANK() OVER (
    [PARTITION BY expresion_de_particion, ... ]
    ORDER BY expresion_de_ordenacion [ASC | DESC], ...
  ) AS numero_de_rango
FROM
  tabla;
```

*those agg fn are meant to be used primarily with order by


| Salary | `row_number` | `rank` | `dense_rank` |
| ------ | ------------ | ------ | ------------ |
| 1000   | 1            | 1      | 1            |
| 1500   | 2            | 2      | 2            |
| 1500   | 3            | 2      | 2            |
| 2000   | 4            | 4      | 3            |

## WINDOW (variante a un frame)

Siempre se utiliza cuando una ventana se va a usar en más de una ocasión en la consulta

```sql
OVER window_name
...
--- then the window statement is defined
WINDOW window_name as
(window_definition) [,...]
```



```sql
SELECT empid, departamento, salario, edad,
	avg(salario) OVER ventana_departamento,
	max(edad) OVER ventana_departamento,
FROM empleado

WINDOW ventana_departamento AS (PARTITION BY departamento)
```


## Ejemplos 

```sql
-- promedio móvil de 7 días de las ventas
SELECT fecha, ventas, 
	avg(ventas) OVER (
		ORDER BY fecha 
		ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS promedio_movil_7d
FROM ventas_diarias;
```
