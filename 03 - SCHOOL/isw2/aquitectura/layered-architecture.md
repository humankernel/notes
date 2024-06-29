# Layered Arch
#layered-arch #n-tier

> Se basa en la separación de las diferentes funcionalidades del sistema en capas o niveles. 
> Cada capa se encarga de un conjunto de tareas específicas y se comunica con los niveles adyacentes mediante interfaces bien definidas


![[layered-architecture-20240502204134744.webp]]

Some layers can be bypassed


![[layered_arch]]



## Características

**Capas**: 
Una capa es un conjunto de componentes o módulos de software que se encargan de realizar una función específica dentro del sistema. 
Cada capa o nivel se comunica con las capas adyacentes a través de una interfaz bien definida, lo que permite la separación de responsabilidades y la modularidad del sistema. 
Algunas de las capas más comunes son: 
1. la capa de presentación (o capa de usuario), 
2. la capa de lógica de negocio, 
3. la capa de acceso a datos y la de almacenamiento


**Interfaces**: Una interfaz es un conjunto de definiciones de métodos y propiedades que proporciona una forma estandarizada de comunicación entre dos capas adyacentes, se utilizan para determinar cómo las capas interactúan entre sí y se comunican entre ellas.


**Separación de responsabilidades**: 
Cada capa se encarga de una tarea muy definida, por ejemplo, la capa de presentación solo se preocupa por presentar la información de forma agradable al usuario, pero no le interesa de donde viene la información ni la lógica de negocio que hay detrás

La capa de negocio solo se encarga de aplicar todas las reglas de negocio y validaciones, pero no le interesa como recuperar los datos, guardarlos o borrarlos, ya que para eso tiene una capa de persistencia que se encarga de eso

## Ventajas
Este modelo permite una mejor organización y modularidad del sistema
Es mas fácil agregar seguridad a diferentes niveles
Es fácil insertar algo nuevo
Es fácil remplazar una capa
Fácil rastrean un error
facilita su mantenimiento y evolución a largo plazo1

## Desventajas
Cada capa solo se comunica con la capa inmediatamente debajo
Difícil obtener un buen rendimiento (si algunas de las capas no son eficientes)
No muy buena en cuando a modularidad, escalabilidad

## Casos de Uso

**Modelo OSI de redes**: Este modelo se utiliza para describir cómo las redes de computadoras operan y se comunican. El modelo OSI se divide en 7 capas

![[layered-architecture-20240502203352650.webp|400]]


**Patron MVC**: El patrón Modelo-Vista-Controlador (MVC) es otro ejemplo de arquitectura en capas que se utiliza comúnmente en el desarrollo de aplicaciones web. 
En este patrón, la “Vista” se encarga de la presentación de la información al usuario, el “Modelo” gestiona los datos y la lógica de negocio, y el “Controlador” coordina las interacciones entre el Modelo y la Vista

**Patrón Cliente-Servidor** en sistemas distribuidos: En este patrón, la capa de presentación (cliente) y la capa de procesamiento (servidor) se separan en dos componentes distintos, lo que permite una mayor flexibilidad y escalabilidad.

**Sistemas bancarios**: Los sistemas bancarios suelen utilizar la arquitectura en capas para separar las funciones de la interfaz de usuario, el procesamiento de transacciones y la gestión de datos.