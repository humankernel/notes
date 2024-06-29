# Query Planner

```sql
EXPLAIN (
	ANALYZE [boolean],
	VERBOSE [boolean],
	COSTS   [boolean],
	BUFFERS [boolean],
	TIMING  [boolean],
	FORMAT  {TEXT | XML | JSON | YAML}
)
SELECT department, avg(salario) FROM empleado GROUP BY department
```


| VERBOSE | permite la representación interna completa<br>del árbol del plan de consulta, en vez de un resumen.<br>Es únicamente útil para la corrección de errores de<br>Postgres. |
| --- | --- |
| ANALYZE | causa que la sentencia sea ejecutada<br>realmente, no solo planeada. Se devuelven y muestran<br>la duración total medida para cada nodo (en<br>milisegundos) y el número total de filas devueltas<br>realmente |


> [!Faq] `EXPLAIN ANALYZE` actually execute the query
> If you want to use it with out modifying the table use 
> ```sql
> BEGIN;
> EXPLAIN ANALYZE 
> 	...;
> ROLLBACK;
> ```

