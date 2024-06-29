
# DDL (Data Definition Language) 

## CREATE

```sql
CREATE [object_type] [object_name] [object_definition] 
```

- **object_type**: DATABASE | TABLE
- **object_name**: 
- **object_definition**: (col data_type contraints, col2 data_type contraints)

```sql
CREATE TABLE table1 (
    col1 data_type [(size)] [NULL/NOT_NULL] [CHECK (condition)],
    col2 data_type [(size)] [NULL/NOT_NULL] [DEFAULT value] UNIQUE,
    …
    PRIMARY KEY (col1, ...),
    FOREIGN KEY (col2, ...) REFERENCES table2 (table2_id, ...)
);

-- create table example
CREATE TABLE product (
	no integer NOT NULL,
	s_no integer NOT NULL,
	name character varying(20),
	price real,
	PRIMARY KEY (no),
	FOREIGN KEY (s_no) REFERENCES service(s_no)
);
```

**constrains**:
- domain restrinctions
- validations
- allow nulls or not
- default values


`UNIQUE`: non-key value that is unique




```sql
CREATE TABLE movies (
    id INTEGER PRIMARY KEY,
    title TEXT,
    director TEXT,
    year INTEGER, 
    length_minutes INTEGER
);
```


## ALTER

As your data changes over time, SQL provides a way for you to update your corresponding tables and database schemas by using the `ALTER TABLE` statement to add, remove, or modify columns and table constraints.

### add

The syntax for adding a new column is similar to the syntax when creating new rows in the `CREATE TABLE` statement. You need to specify the data type of the column along with any potential table constraints and default values to be applied to both existing _and_ new rows

```sql
ALTER TABLE mytable
ADD column DataType OptionalTableConstraint 
    DEFAULT default_value;
```

### alter drop

Dropping columns is as easy as specifying the column to drop, however, some databases (including SQLite) don't support this feature. Instead you may have to create a new table and migrate the data over.

```sql
ALTER TABLE mytable
DROP column_to_be_deleted;
```

### rename

If you need to rename the table itself, you can also do that using the `RENAME TO` clause of the statement.

```sql
ALTER TABLE mytable
RENAME TO new_table_name;
```

## DROP

> [!Info]
> you may want to remove an entire table including all of its data and metadata, and to do so, you can use the `DROP TABLE` statement, which differs from the `DELETE` statement in that it also removes the table schema from the database entirely

```sql
DROP TABLE IF EXISTS mytable;
```

> [!Warning]
> Like the `CREATE TABLE` statement, the database may throw an error if the specified table does not exist, and to suppress that error, you can use the `IF EXISTS` clause
> 
>  if you have another table that is dependent on columns in table you are removing (for example, with a `FOREIGN KEY` dependency) then you will have to either update all dependent tables first to remove the dependent rows or to remove those tables entirely







