# Security

> [!NOTE]- Integrity Constrains
> Exactitud y precicion de los datos
> 
> Ej: un cliente no puede sacar mas datos del que tiene
> 
> **Restricción del Dominio**: cada atributo debe ser atomico
> **Restricción de Clave Primaria**: No puede tomar valores repetidos (UNIQUE, PRIMARY KEY) 
> **Restricción de integridad de entidad**: La clave primaria no puede ser nula (NOT NULL) 
> **Restricción de Integridad referencial** (FOREIGN KEY)
> 
> - Las restricciones deben ser especificadas en un lenguaje adecuado 
> - Las restricciones deben ser mantenidas en el catálogo del sistema 
> - El sistema debe vigilar las operaciones del usuario para asegurarse que cumplan estas restricciones

> [!note]- System Catalog `pg_catalog`
> Colección de tablas y vistas que almacenan metadatos sobre la base de datos. Estos metadatos incluyen información sobre las tablas, columnas, índices, procedimientos almacenados, usuarios, roles, permisos, entre otros
> 
> Contenido del Catálogo del Sistema
> - tables & columns
> - users
> - views
> - privileges
>   
>   | table          |                        |
>   | -------------- | ---------------------- |
>   | `pg_attribute` | attribute info         |
>   | `pg_authid`    | users ids (roles)      |
>   | `pg_index`     | indices aditional info |
>   | `pg_trigger`   | trigger info           |
>   
>   ```sql
>   SELECT * FROM pg_catalog.pg_tables;
>   ```
>   ![[Pasted image 20240307150338.webp|700]]

> [!success]- Good Practices
> - Identificar los datos sensibles.
• Monitorizar el acceso a las bases de datos.
• Utilizar técnicas de encriptación de la información.
• Administrar los derechos de acceso de los usuarios y eliminar los privilegios
excesivos y los usuarios inactivos.
• Capacitar a los empleados en técnicas de mitigación de riesgos con las mejores
prácticas en torno al uso de Internet y del correo electrónico, y la gestión de
contraseñas.
• Evaluar las vulnerabilidades de la base de datos, identificando los puntos finales
comprometidos y clasificando los datos confidenciales.
 Supervisar toda la actividad de acceso a la base de datos y los patrones de uso en
tiempo real para detectar ataques y fugas de datos.
• Automatizar la auditoría con una plataforma de auditoría y protección de bases de
datos.
• Bloquear las solicitudes web maliciosas.
• Archivar datos externos, cifrar bases de datos y enmascarar los campos de la base
de datos para ocultar información confidencial.
• Realizar backups o copias de seguridad de la información.

> [!fail]- Weak Points
• Gestión de permisos inadecuada
• Abuso de privilegios y accesos no autorizados
• Ataques de inyección de base de datos por SQL
• Malware
• Auditorías débiles
• Exposición de los medios de almacenamiento
• Explotación de vulnerabilidades y bases de datos mal configuradas
• Datos sensibles mal gestionados
• Ataques de denegación de servicio
• Formación y concienciación en seguridad insuficiente


La seguridad de los datos se refiere a la protección de estos contra el acceso por parte de las personas no autorizadas y contra su indebida destrucción o alteración

Ej: un cliente solo pude acceder al saldo de su cuenta y no la puede alterar


Proteger
- Los datos dentro de la base de datos, 
- El sistema de gestión de la base de datos 
- Las aplicaciones asociadas, los sistemas
- Los servidores físicos y virtuales
- La infraestructura de red

Aspectos a proteger:
- Canal de comunicacion
- de autenticacion (verificar la informacion recibida proceda de quien se supone)
- fisica (proteccion del soporte fisico)
- suplantacion (verificar que los usuarios no estan siendo suplantados por intrusos)
- de informacion (preservacion de la informacion frente a observadores no autorizados)

Aspectos a considerar
- Legales, sociales y éticas 
- Controles físicos 
- Cuestiones de política 
- Problemas operacionales 
- Soporte del Sistema Operativo 
- Sistema de Base de Datos

Se protegen:
	- Vistas
	- Funciones
	- Secuencias
	- ...

La base de datos debe ser protegida contra el fuego, el robo y otras formas de destrucción. 
Los datos deben ser reconstruibles. 
Los datos deben poder ser sometidos a procesos de auditoría. 
La BD debe diseñarse a prueba de intromisiones
Seguridad de las redes (Firewalls) 

## Access Administration 

- Authentication
- Authorization
- Control

System Access Security (.conf) [[1.security-conf]]
Data Security [[2.security-data]]


## Security Politic

Una política de seguridad de bases de datos es un plan de acción para afrontar riesgos de seguridad, o un conjunto de reglas para el mantenimiento de cierto nivel de seguridad

Es un documento de alto nivel que denota el compromiso de la gerencia con la seguridad de la información. Contiene la definición de la seguridad de la información bajo el punto de vista de cierta entidad

Comprende:
- Identificación de los activos. 
- Evaluación de amenazas potenciales
- Evaluación del riesgo
- Herramientas y tecnologías
- Desarrollo de una política de uso.
- Procedimiento de auditoría

en el trabajo es solo definir roles y que politica de seguridad garantizar a esos roles

> [!faq] Las decisiones sobre que usuarios se les permite realizar que operaciones sobre que objetos NO son decisiones tecnicas




## Threat Protection 
- Audit
- Threat detection 

## Information Protection 
- Data Encryption
- Backup & Recovery
- Fisic Security



















▪ Seguridad de acceso al sistema
▪ Seguridad de los datos. Comandos SQL para la definición 
de usuarios y permisos
▪ Seguridad a nivel de filas. 
▪ Catálogo del sistema
▪ Política de seguridad