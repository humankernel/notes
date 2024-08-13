# database optimization

[[algebraic-adjustments]]
[[fav]]
[[with]]


![[Pasted image 20240124200032.webp]]


## Algebraic - Adjustments

- Solo seleccionar los atributos necesarios
- Evitar `SELECT *`, porque se debe leer primero la estructura de la tabla
- Utilizar `JOIN` para unir las tablas
- Evitar subconsultas innecesarias

## Query Life-Cycle:

![[Pasted image 20240206142329.webp|400]]


1. El analizador de consultas se asegura de que la consulta **sea sintácticamente y semánticamente correcta**. Si es correcta, entonces la convierte en una expresión algebraica.
2. El planeador y optimizador de consultas hace el trabajo pesado de pensar
	- Primero realiza optimizaciones directas. 
	- Después considera diferentes "planes de consulta" que pueden tener diferentes optimizaciones, estima el costo (CPU y tiempo) de cada consulta con base en el número de registros en las tablas relevantes
	- después escoge el plan óptimo. 
3. El ejecutor de la consulta toma el plan y lo convierte en operaciones de la base de datos, regresándo los resultados si los hay.


- [[explain]]
- [[fav]]
- [[with]]
- [[index]]
