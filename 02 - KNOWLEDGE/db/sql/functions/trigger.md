# Trigger

Son funciones que se ejecutan de forma automática en respuesta a ciertos eventos que ocurren en la base de datos.

Se almacenan en la tabla `pg_trigger`

> [!faq] Avoid Recursive Calls
> Don't use a sql declaration that calls the same trigger from wich it is called

> [!note] Pros
> - when `checks` are not enough and you want complex data checking
> - to ensure referential integrity
> - when its required to log or track changes of the data
> - can be nested and query other tables
> - more control over the db

> [!faq] Cons
>  - danger of posible data loss in reorganizations
>  - can't be directly invoked
>  - can't be used in temp tables
>  - slow times on the operations


## Syntax
``
```sql
-- trigger function
CREATE [OR REPLACE] FUNCTION name () 
	RETURNS trigger AS 
 $$ 
 DECLARE 
	 variables 
BEGIN 
	……… 
END 
$$

-- trigger definition
CREATE [OR REPLACE] TRIGGER name_trigger 
	[ AFTER | BEFORE ] [ INSERT | UPDATE | DELETE ] 
	ON name_table 
	FOR EACH [ROW | STATEMENT] 
	EXECUTE PROCEDURE function(); 
	
DROP TRIGGER [IF EXISTS ] name_trigger 
	ON name_table [CASCADE | RESTRICT]; 
	
ALTER TRIGGER
```


- `[AFTER | BEFORE]`: momento en que el desencadenador entra en acción. 
- `[INSERT | UPDATE | DELETE]`: la clase de sentencia que activa al disparador. 
- `FOR EACH [ROW | STATEMENT]`: Se activará por cada fila alterada por la operación o se activará solo una vez para una operación específica


```sql
create or replace function tg_example()  
    returns trigger as  
$$  
begin  
    raise exception '
	    new: % 
	    tg_relid: % 
	    tg_table_schema: %  
        tg_table_name: % 
        tg_relname: % 
        tg_op: % 
        tg_when: % 
        tg_level: %',  
        NEW, TG_RELID, TG_TABLE_SCHEMA, TG_TABLE_NAME,  
        TG_RELNAME, TG_OP, TG_WHEN, TG_LEVEL;  
    return new;  
end;  
$$ language plpgsql;
```

## Variables 

- `NEW`: new values of the modified table. 
- `OLD`: old values of the modified table
- `TG_OP`: string - INSERT | UPDATE | DELETE. 
- `TG_NAME`: string - trigger name. 
- `TG_WHEN`: string - BEFORE | AFTER
- `TG_TABLE_NAME`: table name


Una misma función se puede usar por varios disparadores en diferentes tablas
El disparador devuelve NULL o un valor RECORD con la estructura de la tabla que lo lanzó
Si utiliza en el trigger nivel de sentencia debe devolver `NULL` la función disparadora.
Un disparador puede ejecutar sentencias que active otro disparador. Esto se conoce como casacada


> [!note] Common Usage 
> - audit and monitor the activities of change of data
> - allow to validate data, changing or denying INSERT, UPDATE, DELETE
> - to demand referential integrity



## Special Trigger Types

### Column Trigger

Executed when one or more columns are updated by a user
Allow not to use conditional logic and value comparation in the functions

```sql
CREATE TRIGGER nombre_trigger 
	[AFTER | BEFORE] UPDATE
	OF nombre_columna ON nombre_tb 
	FOR EACH [ROW | STATEMENT] 
	EXECUTE PROCEDURE function;
```


### Conditional Trigger

Allow to specify a condition in the trigger definition

```sql
CREATE TRIGGER nombre_trigger 
	[AFTER | BEFORE] [INSERT | UPDATE | DELETE] 
	ON nombre_tabla 
	FOR EACH [ROW | STATEMENT] 
	WHEN (condición) 
	EXECUTE PROCEDURE function;
```


> [!example]
>  ```sql
>  create function fn_tg_check_fees()  
> 	 returns trigger as  
> $$  
> begin  
>   if new.fee < 10 or new.fee > 1000 then  
> 	  raise exception 'Please check the fee price to be between 10 and 1000';  
>   end if;  
> return new;  
> end;  
> $$ language plpgsql;  
> 
> create trigger tg_check_fee  
> 	before insert  
> 	on fine  
> 	for each row  
> execute procedure fn_tg_check_fees();
>  ```

