# DB Schema


![[coffee-shop.svg|800]]


## Tables
### User Table

| column name | variable type | example                                       | PK   |
| ----------- | ------------- | --------------------------------------------- | ---- |
| id          | serial        | 1                                             | true |
| name        | varchar(255)  | John Doe                                      |      |
| user        | varchar(255)  | johndoe                                       |      |
| pass        | varchar(255)  | sdfhj##$#hj                                   |      |
| role        | enum          | manager \| almacenero \| customer \| supplier |      |
**Supplier**

| column name | variable type       | example            | PK   | FK   |
| ----------- | ------------------- | ------------------ | ---- | ---- |
| id          | serial              | 1                  | true | true |
| phone       | varchar(255)        | 53535353           |      |      |
| email       | varchar(255)        | supplier@email.com |      |      |
| sales       | int                 | 31                 |      |      |
| products    | array: varchar(255) | ['milk', 'coffee'] |      |      |

### Purchase Order


| column name | variable type | example                          | PK   | FK   |
| ----------- | ------------- | -------------------------------- | ---- | ---- |
| id          | serial        | 1                                | true |      |
| supplier_id | int           | 1                                |      | true |
| created_at  | date          | 2024-10-10                       |      |      |
| status      | enum          | pending \| rejected \| fullfiled |      |      |

**Purchase Order Product**

| column name | variable type | example | PK   | FK   |
| ----------- | ------------- | ------- | ---- | ---- |
| id          | serial        | 1       | true |      |
| product_id  | int           | 1       |      | true |

### Product

| column name | variable type | example     | PK   | FK  |
| ----------- | ------------- | ----------- | ---- | --- |
| id          | serial        | 1           | true |     |
| name        | varchar(255)  | Cappucino   |      |     |
| desc        | text          |             |      |     |
| price       | float         | 1.5         |      |     |
| type        | enum          | menu \| raw |      |     |

**Menu Product**

| column name | variable type | example | PK   | FK   |
| ----------- | ------------- | ------- | ---- | ---- |
| id          | serial        | 1       | true | true |


**Raw Product**

| column name | variable type | example | PK   | FK   |
| ----------- | ------------- | ------- | ---- | ---- |
| id          | serial        | 1       | true | true |
| stock       | int           | 100     |      |      |

**Drink**

| column name | variable type | example        | PK   | FK   |
| ----------- | ------------- | -------------- | ---- | ---- |
| id          | serial        | 1              | true | true |
| size        | enum          | sm \| md \| lg |      |      |
| sugar       | bool          | 1 \| 0         |      |      |
| temp        | enum          | cold \| hot    |      |      |
| drink_type  | varchar(255)  | coffee         |      |      |

**Food**

| column name | variable type       | example           | PK   | FK   |
| ----------- | ------------------- | ----------------- | ---- | ---- |
| id          | serial              | 1                 | true | true |
| food_type   | varchar(255)        | icecream          |      |      |
| ingredients | array: varchar(255) | ['milk', 'cream'] |      |      |


### Sale

| column name | variable type | example    | PK   | FK   |
| ----------- | ------------- | ---------- | ---- | ---- |
| id          | serial        | 1          | true |      |
| user_id     | int           | 1          |      | true |
| created_at  | date          | 2024-10-10 |      |      |

**Sale Product**

| column name | variable type | example | PK   | FK   |
| ----------- | ------------- | ------- | ---- | ---- |
| id          | serial        | 1       | true |      |
| product_id  | int           | 1       |      | true |
| amount      | int           | 20      |      |      |

### QS

| column name | variable type | example                 | PK   | FK  |
| ----------- | ------------- | ----------------------- | ---- | --- |
| id          | serial        | 1                       | true |     |
| desc        | text          |                         |      |     |
| created_at  | date          | 2024-10-10              |      |     |
| type        | enum          | Complaint \| Suggestion |      |     |

### Report

| column name | variable type | example            | PK   | FK  |
| ----------- | ------------- | ------------------ | ---- | --- |
| id          | serial        | 1                  | true |     |
| desc        | text          |                    |      |     |
| created_at  | date          | 2024-10-10         |      |     |
| type        | enum          | missing \| surplus |      |     |






## Queries

- [ ] user can login
- [ ] user can insert an anonymous Q&S 
	- [ ] manager can CRUD

- [ ] manager can CRUD a user
	- [ ] customer can register
- [ ] manager can CRUD reports
- [ ] manager can CRUD providers

- [ ] manager can make a purchase order
	- [ ] supplier can change status
- [ ] manager can CRUD products


- [ ] status
	- [ ] day with most sales
	- [ ] most sale products

- [ ] system register sale when user submit his shopping cart
- [ ] almacenero can create a report


