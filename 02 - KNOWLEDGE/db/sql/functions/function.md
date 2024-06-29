# Functions

Encapsulan lógica del negocio, puede minimizar complejidad y se ejecutan más rápido.


> [!note]- Pros
>  - mejor control de errores
>  - El acceso directo a los datos necesarios para manipular y sólo necesita enviar el resultado final al usuario.
>  - Unificar/Ejecutar varias sentencias SQL, 
>  - Posibilidad de ejecutar las sentencias SQL utilizando lenguajes procedimentales (PL).
>  - DRY (dont repeat yourself)
>  - mejora en la legibilidad y eficiencia del código
>  - Hacer referencia a otras funciones minimiza complejidad
>  - La función se compila en el servidor cuando se crea; por tanto, se ejecuta con mayor rapidez que las instrucciones SQL individuales. 

> [!faq]- Extensiones SQL-99
> - Entre las propuestas definidas en el estándar SQL-99 están
> 	- IF, WHERE, LOOP, etc
> 	- PostgreSQL tiene una versión propia de estas extensiones "procedurales" tiene su versión llamada PL/pgSQL

> [!note]- "Good Practices"
> - Document the code
> - Correctly defined data-types
> - Use procedures calls from the apps
> - Avoid dynamic code generation 
> - Avoid unnecesary functions calls

## PL/PGSQL

> [!faq] Not checked
> - OJO: no se comprueba la sintaxis de las funciones hasta que no son ejecutadas. (Es difícil depurar el código)

```sql
CREATE [or REPLACE] FUNCTION name ( [ [argmode] [argname] argtype [{ DEFAULT | = } default_expr ] [, ...] ] ) 
[RETURNS rettype AS 
$BODY$ 
	 DECLARE 
		 var_name [CONSTANT] type [NOT NULL] [{DEFAULT | :=}] [expression]
	 BEGIN 
		 ……… 
	 END 
$BODY$
```


```sql
-- sum a + b
create function sum_ab(int4, b int4)  
    returns int4 as  
$$  
declare  
    c int4;  
begin  
    if b = 0 then  
        raise exception 'B cannot be zero';  
    end if;  
  
    c := $1 + b;  
    return c;  
end;  
$$ language plpgsql;
```


## Variables

```sql
DECLARE 
	var_name [CONSTANT] type [NOT NULL] [{DEFAULT | :=}] [expression]

-- examples
id_usuario INTEGER;
cantidad NUMERIC(5, 2);
url VARCHAR;

-- asignment
var_name := expresion;
SELECT exp INTO var_name FROM ...;
```


> [!info]- The type can be infered (`table.campo%TYPE`, `table%ROWTYPE`)
> `%ROWTYPE` reserva sitio para toda la tupla. Reteniendo la estructura de los datos 
> ```sql
> micampo mitabla.campo%TYPE; 
> mitupla mitabla%ROWTYPE;
> 
> DECLARE
> 	mivar empleado.salario%TYPE; 
> BEGIN 
> 	… 
> RETURN mivar*2;
> ```


> [!faq] More than one field - `SETOF`
> Si el `SELECT INTO` devuelve mas de una tupla, se ignoran todas menos la primera
>
> `SETOF`: indica que la función retorna un conjunto de items.


> [!example]- Example: returning a row if exists
> 
> ```sql
> create function found_employee(int)  
> 	returns empleado as  
> $$  
> declare  
> 	tuple empleado%ROWTYPE;  
> begin  
> 	select * into tuple from empleado where id = $1;  
> 	if not found then 
> 		return null;  
> 	else  
> 		return tuple; 
> end if;  
> end;  
> $$ language plpgsql;
> ```
> 
> Es lo mismo que 
> ```sql
> create function found_employee2(int)  
> 	returns setof empleado as  
> $$  
> begin  
> 	return query select * from empleado where id = $1;  
> end;  
> $$ language plpgsql;
> ```



## Control Flow 

### Conditionals

`IF…THEN…ELSE…ELSE IF`

```sql
create function clasifica_empleado(int)  
    returns varchar(10) as  
$$  
declare  
    ed int;  
begin  
    select edad into ed from viajero where numero = $1;  
    if not found then  
        return 'No hay empleado';  
    elseif ed <= 35 then  
        return 'Empleado joven';  
    elseif ed <= 55 then  
        return 'Empleado adulto';  
    else  
        return 'Empleado anciano';  
    end if;  
end;  
$$ language plpgsql;  
```

`CASE WHEN ... THEN ELSE`

```sql
create function clasifica_empleado2(int)  
    returns varchar(20) as  
$$  
declare  
    res varchar(20);  
begin  
    select case when edad <= 35 then 'Empleado joven'  
                when edad <= 55 then 'Empleado adulto'  
                else 'Empleado anciano'  
           end  
    into res  
    from viajero  
    where numero = $1;  
  
    if not found then  
        res := 'No hay empleado';  
    end if;  
  
    return res;  
end;  
$$ language plpgsql;
```

### Loops

`LOOP … END LOOP, WHILE.. LOOP … END LOOP, FOR … LOOP… END LOOP`

```sql
[label]
LOOP 
	statements 
END LOOP [label];

WHILE bool-expression 
LOOP 
	statements 
END LOOP;
```

> [!example]- conditional | no conditional | range
> 
> ```sql
> declare  
> 	i int := 0;  
> begin  
> 	-- no conditional loop
> 	loop  
> 		i := i + 1;    
> 		if i = n then  
> 			exit;  
> 		end if;  
> 	end loop;  
> 	
> 	-- conditional loop
> 	while i < n  
> 	loop  
> 		i := i + 1;  
> 	end loop;
> 	
> 	-- range loop
> 	for i in 1..n
> 	loop
> 	end loop;
> end;  
> ```

> [!example]- range - return all employee
> ```sql
> DECLARE 
> 	resultado empleado%rowtype; 
> BEGIN 
> 	FOR resultado IN (SELECT * FROM empleado WHERE salario = $1) 
> 	LOOP 
> 		RETURN NEXT resultado; 
> 	END LOOP; …… 
> END
> ```


## Exceptions

RAISE se usa para imprimir mensajes y, en el caso de excepción, 
`RAISE { NOTICE | EXCEPTION}`

```sql
RAISE NOTICE
RAISE NOTICE 'No hagas eso!';
RAISE NOTICE 'El señor' || id || 'no está en casa';
RAISE NOTICE 'el señor % no está en casa' , id;
```

> [!example]- Example: Insert if not exist
> ```sql
>create or replace function insert_employee(id int, nombre varchar, terminal int, direccion varchar)  
> 	returns bool as  
> $$  
> declare  
>   result bool;  
>     emp_tmp empleado%rowtype; 
> begin  
>   select * into emp_tmp from empleado where empleado.id = $1;  
>     if found then  
>         raise exception 'The item already exists'
>	 else
>		 insert into empleado values ($1, $2, $3, $4);  
>		 result := true;  
>		 end if;  
>	return result;  
> end;  
> $$ language plpgsql;


## Return Types

PostgreSQL posee diversas formas de efectuar el retorno de múltiples filas de datos en una función PLpgSQL, 

### `out`  params

Es posible retornar mas de un registro de datos usando los parámetros de salida de la función (`OUT`) e indicando a su vez en el `RETURNS` de la misma, que la salida serán registros (`RECORD`):

> [!important] Important Parts:
> 1. `out` params
> 2. `returns setof record`
> 3. `declare reg record;`
> 4. `for reg in ...`  -> `return next;`


```sql
create or replace function list_employees(out out_id int, out out_nombre varchar)  
    returns setof record as  
$$  
declare  
    reg record;  
  
begin  
    for reg in (select * from empleado)  
        loop  
            out_id = reg.id;  
            out_nombre = reg.nombre;  
            return next;  
        end loop;  
end;  
$$ language plpgsql;

select list_employees();

-- "(1212,""Ana María"")"
-- "(1213,""Juana Rosa"")"
-- ... 
```

### Defined Types

Esta es una de las opciones mas explotadas en PostgreSQL

Requiere crear una estructura de datos previamente, ya sea esta una tabla, vista o bien podemos crear nuestra propia estructura con el comando `CREATE TYPE`

#### Using the Table Structure

Para devolver una consulta a una tabla o vista en particular

```sql
create or replace function list_employee()  
    returns setof empleado as  
$$  
declare  
    emp empleado%rowtype;  
begin  
    for emp in (select * from empleado)  
        loop  
            return next emp;  
        end loop;  
end;  
$$ language plpgsql;
```

#### Using a Data Type `create type`

Cuando se realizan consultas con estructuras mixtas (JOINS) o bien a columnas específicas de una tabla.

> [!important] Important Parts
> 1. `create type`
> 2. `returns setof type_name`
> 3. `declare reg record`
> 4. `for reg in`
> 5. `return next reg`


```sql
-- 1. create the special type  
create type employee_data as  
(  
    id     int,  
    nombre varchar  
);  
  
create function list_employee2()  
    returns setof employee_data as  
$$  
declare  
    reg record;  
begin  
    for reg in (select id, nombre from empleado)  
        loop  
            return next reg;  
        end loop;  
end;  
$$ language plpgsql;  
```


## Stored Procedures

- Similares a las funciones 
- Son código escrito por una razón específica y se pueden utilizar siempre que se necesiten. 

- Se diferencian de las funciones.
	- Los procedimientos almacenados pueden devolver nada, un valor único o varios valores
	- Las funciones no pueden incluir transacciones, mientras que los procedimientos almacenados sí


```sql
create or replace procedure public.testing(  
    in int,  
    in text,  
    in int,  
    in varchar  
)  
    language sql  
as  
$$  
insert into empleado (id, nombre, terminal, direccion)  
values ($1, $2, $3, $4);  
$$;  
  
alter procedure public.testing(int, text, int, varchar)  
    owner to postgres;  
  
call testing(5005, 'lanalga', 3, 'Culo Holguin');
```

