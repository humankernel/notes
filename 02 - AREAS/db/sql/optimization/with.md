# CTE - Common Table Expressions
#cte #with #common-table-expressions

- Permite especificar una o más subconsultas que serán referenciadas por su nombre en la consulta principal. 
- Actúan como tablas o vistas temporales por la duración de la consulta primaria.
- Variante a la utilización de ventanas.

**Ventajas**: Se ejecutan una única vez aunque se referencien en varias ocasiones en la consulta principal

```sql
WITH [RECURSIVE] name_statement as (
	SELECT column, ...
	FROM table1
	WHERE [cond]
)
```


## Ejemplo

¿Cuál es la diferencia del salario de cada uno de los empleados con respecto a la media de su departamento?

```sql
SELECT e1.empid, e1.departamento, e1.edad, e1.salario (
	SELECT avg(e2.salario)
	FROM empleado e2 
	WHERE e2.departamento = e1.departamento
) as promedio
FROM empleado e1;

-- FAV - function agregacion de ventana
SELECT empid, departamento, edad, salario, 
	avg(salario) OVER (PARTITION BY departamento) as promedio
FROM empleado

-- WITH 
WITH departamento_salario as (
	SELECT e2.departamento, avg(e2.salario) as salario_promedio
	FROM empleado e2
	GROUP BY departamento
)

SELECT e1.empid, e1.departamento, e1.salario, e1.edad, ds.salario_promedio
FROM empleado e1, departamento_salario ds
WHERE ds.departamento = e1.departamento
```


![[Pasted image 20240124232655.webp]]


## Recursive Query's

Las consultas recursivas son útiles cuando se trabaja con datos que tienen una estructura jerárquica o de árbol. 

Las consultas recursivas en SQL son una forma de hacer preguntas a una base de datos que requieren múltiples pasos para responder. 

Imagina que tienes una lista de empleados, y cada empleado tiene un gerente. Si quieres saber todos los empleados que trabajan bajo un gerente específico, necesitarías hacer una consulta recursiva.


```sql
WITH RECURSIVE jerarquia_empleados AS (
    SELECT empleado_id, nombre, gerente_id
    FROM empleados
    WHERE gerente_id IS NULL
    UNION ALL
    SELECT e.empleado_id, e.nombre, e.gerente_id
    FROM empleados e
    INNER JOIN jerarquia_empleados je ON je.empleado_id = e.gerente_id
)
SELECT * FROM jerarquia_empleados;
```



