# Cased Based System

> Técnica para resolver problemas nuevos adaptando soluciones de problemas previos.
> Alternativa a los sistemas basados en reglas.


> [!success]- Ventajas
> - Captura el esfuerzo en la solución de problemas para ahorrar trabajo futuro.
> - Utiliza experiencias previas exitosas para justificar nuevas soluciones.
> - Anticipa problemas con experiencias previas no exitosas.
> - Comunicación basada en ejemplos concretos.
> - Trabaja con bases de datos existentes, sin necesidad de entrevistas a expertos.
> - Algoritmo de aprendizaje incremental.
> - Propuesta rápida de soluciones.
> - Útil en dominios no completamente comprendidos.
> - Focaliza el razonamiento en partes importantes del problema.
> - Aplicable a un amplio rango de problemas

> [!fail]- Desventajas
> - No explora todo el espacio de soluciones, no encuentra soluciones óptimas.
> - Requiere una base de datos grande y bien seleccionada.
> - Difícil mantener consistencia entre varios casos.
> - Dependencia de una adecuada función de semejanza.


**Bases**:
- Los casos son el elemento primario en el proceso de razonamiento
- El razonamiento es un proceso de recordar y modificar
- La 2d vez que se resuelve una tarea es mas fácil que la 1r porque se recuerda y repite soluciones previas

## Características

- Razona recordando y modificando casos previos.
- Alternativa a sistemas basados en reglas cuando estas son inmanejables o la teoría del dominio es débil.
- Uso común en el dominio jurídico y atención a clientes.
- Aprendizaje incremental.

## Enfoques

- **Solucionador**: Adapta y combina soluciones viejas.
- **Interpretativo**: Explica y justifica nuevas situaciones basándose en casos anteriores.


## Uso

- Difícil formular reglas, pero hay casos disponibles.
- Reglas formulables requieren más información de la disponible.
- Costoso usar reglas debido a su cantidad.
- Fácil verificar la utilidad de la solución.
- Formalización similar en casos con soluciones similares.
- Casos disponibles

## Arquitectura

1. **Base de casos**: Almacena los casos.
2. **Mecanismo de inferencia**:
    - Recuperar casos relevantes.
    - Seleccionar casos más similares.
    - Adaptar y derivar una solución.
    - Evaluar la solución.
    - Almacenar el nuevo caso resuelto.

## Proceso de Solución

1. **Presentación**: Se presenta el problema.
2. **Recuperación**: Recuperar casos similares.
3. **Adaptación**: Crear una nueva solución adaptando la anterior.
4. **Validación**: Verificar y aceptar/rechazar la nueva solución.
5. **Actualización**: Añadir el caso resuelto a la base de casos.

## Estructura de un Caso

- **Descripción del problema**
- **Solución**


**Rasgos**:
puede tomar valores nulos y se representa con *
- identificador
- descripción
- dominio

## Organización de la Base de Casos

- **Lineal**
- **Jerárquica**
- **Redes de discriminación**

## Construcción de la Base de Casos

- Creación automática desde bases de datos existentes.
- Asistencia inteligente en la adquisición de casos.


## Mecanismo de Inferencia

![[case-based-system-20240615143254592.webp|400]]


1. **Presentación**: se presenta una descripción del problema a resolver o problema actual
2. **Recuperación**: Recuperar casos relevantes que resuelven problemas similares al actual
3. Se determina que partes del viejo caso se deben focalizar para resolver el subproblema actual
4. **Adaptación**: Crear una nueva solución adaptando la solución previa a las nuevas restricciones
5. **Validación**: Verificar la consistencia de la nueva respuesta con la descripción del problema y <u>aceptar o rechazar este</u>
6. **Actualización**: Si se considera apropiada la solución validada se añade a la base de casos


## Módulos

- **Módulo recuperador de casos** 
	Se puede recuperar/seleccionar los items de 2 formas
	- recuperación por semejanza parcial 
	- recuperación por analogia

- **Módulo de adaptación** 
	Proceso de ajustar una solución conocida a las restricciones impuestas por el problema a resolver

- **Módulo de evaluación de soluciones** 

- **Módulo de almacenamiento**



**Selección de los mejores casos:**
Se determinan los casos mas similares a la descripción del problema:
- Los valores de los rasgos en el nuevo problema (P) pueden no ser iguales a los de algún caso (C) 
- Pueden existir valores erróneos o desconocidos para uno o mas rasgos
- Normalmente los rasgos no tienen la misma importancia ($W_i$)
	(por convención normalmente $\sum W_i = 1$)


**Métodos para determinar los $W_i$**
- Funciones de evaluación dinámica
- Análisis dimensional Preferencia heurística
- Grafos de similitud
- Pesos de una red neuronal artificial


### Modulo de recuperación
#### Funciones de semejanza

Función de semejanza: 
$$\beta(P, C) = \sum_{i=1}^n w_i * \delta_i(P_i, C_i)$$
$P$: problema
$C$: caso
$w_i$: importancia del rasgo
$P_i$: valores que el rasgo i tiene en el problema
$C_i$: valores que el rasgo i tiene en el caso
$\delta_i$: función de comparación para el rasgo i

#### Funciones de comparación de rasgos
mas en la conferencia


igualdad exacta:
$$
\begin{align}
\delta(a, b) =
	\begin{cases} 
	1 & \text{si } x = y \\
	0 & \text{si } x \neq y 
	\end{cases}
\end{align}
$$

Rango:
$$
\begin{align}
\delta(a, b) =
	\begin{cases} 
	1 & \text{si } |a - b| \le \epsilon \\
	0 & \text{si } |a - b| \gt \epsilon
	\end{cases}
\end{align}
$$


Sea $M_i = A_1 \in ... \in A_r$
$$
\begin{align}
\delta(a, b) =
	\begin{cases} 
	1 & \text{si } a \in A_p \text{ y } b \in A_p \\
	0 & \text{en otro caso} 
	\end{cases}
\\
\delta(a, b) = 1 - \frac{|a - b|}{\max{a} - \min{a}} \text{ para a } \in M_i
\end{align}
$$




### Módulo de adaptación

Proceso de ajustar una solución conocida a las restricciones impuestas por el problema a resolver


**Pasos**:
1. Decidir qué adaptar.
2. Determinar la viabilidad de la adaptación.
3. Especificar cómo reducir inconsistencias.
4. Seleccionar y aplicar un método.


**Métodos**:
- Re-instanciación
- Ajuste de parámetros
- Búsqueda local
- Analogía derivacional
- Crítica basada en adaptación
- Sistemas cooperativos
- Heurísticas de generalización y refinamiento
- Adaptación basada en similitud
- Interpolación
- Reglas de aprendizaje inductivo
- Algoritmos genéticos


### Módulo de evaluación de soluciones

- Explicar diferencias entre lo esperado y lo ocurrido.
- Justificar diferencias entre la solución propuesta y las usadas previamente.
- Ordenar alternativas.

**Evaluación**: Retroalimentación y simulación. Resultados pueden requerir adaptación adicional o reparación.


### Módulo de almacenamiento

- Almacena el caso recién resuelto en la base de casos.

## Aprendizaje

- Acumulación de nuevos casos.
- Generación automática de casos.
- Reordenamiento de la base de casos.
- **Pasos**:
    - Determinar qué almacenar.
    - Indexar el caso.
    - Integrar lo aprendido a la memoria de casos.



