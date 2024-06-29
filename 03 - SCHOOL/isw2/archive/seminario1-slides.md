---
theme: strange
highlightTheme: base16-gruvbox-dark-high
---

## Arquitectura por Capas
#layered-arch #n-tier


![[n-tier.excalidraw|400]]


---

Se basa en la **separación de las diferentes funcionalidades** del sistema en capas o niveles. 

Cada capa se encarga de un conjunto de tareas específicas y se comunica con los niveles adyacentes mediante **interfaces** bien definidas

---

![[layered-architecture-20240502204134744.webp|800]]

*Some layers can be bypassed

---

## Características

- Una capa es un conjunto de componentes o módulos de software que se encargan de realizar una función 
- Cada capa o nivel se comunica con las capas adyacentes a través de una interfaz bien definida, lo que permite la **separación de responsabilidades** y la **modularidad del sistema**. 

---
## Ventajas

👍Permite una mejor organización

👍Fácil agregar seguridad a diferentes niveles

👍Fácil insertar algo nuevo

👍Fácil remplazar una capa

👍Fácil rastrear un error

---
## Desventajas

👎 Cada capa solo se comunica con la capa inmediatamente debajo

👎 Difícil obtener un buen rendimiento (si algunas de las capas no son eficientes)

👎 No muy buena en cuando a modularidad, escalabilidad

---
## Casos de Uso

El **modelo OSI de redes** se utiliza para describir cómo las redes de computadoras operan y se comunican. Se divide en 7 capas

![[layered-architecture-20240502203352650.webp|300]]
