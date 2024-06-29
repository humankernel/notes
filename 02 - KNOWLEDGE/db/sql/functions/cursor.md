# Cursor

> Used to process a row o set of rows from a result of a query


> [!success] Ventajas
> - allow to place in a specific row
> - allow to recover a row o setof rows
> - allow to be used in functions
> - avoid memory overrun when the result contains a large number of rows

> [!note] Desventajas
> - recover a row from the cursor can be slow (because of the time to send peticion and wait for the response)
> - cursors reserve resources
> - if a cursors is not closed can result in a memory overflow

![[Pasted image 20240225130519.webp|600]]


> [!faq] There are restrictions on what the cursor's query can be (in particular, no grouping)

## 1. `declare` cursor

> [!note]-  cursors are of type `refcursor`
> One way to create a cursor variable is just to declare it as a variable of type `refcursor`. 
> Another way is to use the cursor declaration syntax, which in general is

```sql
declare 
	name [[no] scroll] cursor [(arg1 datatype, ...)] for query;
	name refcursor;

declare 
	cursor1 refcursor;
	cursor2 cursor for 
		select * from empleado where departamento='ventas' and edad=50;
	cursor3 cursor (e int) for
		select * from empleado where departamento='ventas' and edad=e;
```

> [!faq]- `SCROLL`
> If `SCROLL` is specified, the cursor will be capable of scrolling backward; if `NO SCROLL` is specified, backward fetches will be rejected; if neither specification appears, it is query-dependent whether backward fetches will be allowed

## 2. `open` cursor. 

1. allocate memory 
2. execute `SELECT`
3. place the cursor pointer one row before the beginning

```sql
open curs1 for query;
open curs2 [[no] scroll] for execute query_string
						[using expression [,...]];

-- cursor1 es un refcursor
open cursor1 for select empid from empleado order by edad;
open curs2;

open curs2 FOR EXECUTE format('SELECT * FROM %I WHERE col1 = $1',tabname) USING keyvalue;
```

```sql
-- open a bound cursor
declare
    key integer;
    curs4 CURSOR FOR SELECT * FROM tenk1 WHERE unique1 = key;
begin
    key := 42;
    open curs4;
	-- or
    open curs3(42);
    open curs3(key := 42);
```


> [!note]- portal datastructure
> Opening a cursor involves creating a server-internal data structure called a _portal_, which holds the execution state for the cursor's query

> [!note]- execute
> [pg cursor - open for execute](https://www.postgresql.org/docs/current/plpgsql-cursors.html#PLPGSQL-CURSOR-OPENING:~:text=%2C%20...%20%5D%20%5D%3B-,The%20cursor%20variable%20is%20opened%20and%20given%20the%20specified%20query%20to,SCROLL%20options%20have%20the%20same%20meanings%20as%20for%20a%20bound%20cursor.,-An%20example%3A)


## 3. using cursor. 

```sql
fetch [direction] {from | in} <cursor_name> into target;
move  [direction] {from | in} <cursor_name>;


fetch cursor1 into numero_emp;
fetch cursor1 into foo, bar, baz;
fetch last cursor3 into dato_emp;
fetch relative -2 from cursor2 into x

move cursor1;
```

```sql
update table_name set ... where current of cursor_name 
delete from table_name where current of cursor_name 
```


- `fetch` (place the cursor & <u>returns</u> the row)
- `move` (place the cursor only)

`direction`
- next, prior, first, last
- absolute cont, relative cont
- forward o backward


- `... current of curs1`:  for deleting | updating a row
- `is open`:  true if cursor is open
- `found`:  true if last `fetch` returned a row

> [!note]- you can use a returning cursor from a function
> These manipulations need not occur in the same function that opened the cursor to begin with. You can return a `refcursor` value out of a function and let the caller operate on the cursor. (Internally, a `refcursor` value is simply the string name of the portal containing the active query for the cursor. This name can be passed around, assigned to other `refcursor` variables, and so on, without disturbing the portal.)


## 4. `close` cursor.

1. close cursor
2. free memory

```sql
close <cursor_name>;
```


## Examples

```sql
loop 
	fetch cursor1 into v_number;
	exit when not found;
end loop;
close cursor1;
```



> [!note] `for` statements automatically open and close the cursor 

```sql
for recordvar in bound_cursor [(arg_values, ...)]
loop
	statements
end loop

for r in curs3
loop
	update empleado set salario=salario+1 where current of curs3;
	return next r.empid;
end loop
```


```sql
create or replace function f()  
    returns setof int as  
$$  
declare  
    curs cursor for select *  
                    from member  
                    where country = 'Cuba'  
                      and age = 30;  
begin  
    for r in curs  
        loop  
            update member set age=age+1 where current of curs;  
            return next r.id_member;  
        end loop;  
end ;  
$$ language plpgsql;
```


