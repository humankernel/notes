# Location module 
data owner: #CPO
basic object: Location

The Location objects live in the CPO back-end system. They describe the charging locations of an operator

## Referencias: 
- [Place to Plug](https://placetoplug.com/)
- [Chargemap - charging stations for electric cars](https://chargemap.com/)


## TODO
- [x] estudio de la plataforma
- [x] OCPI 2.2
- [ ] estructura de datos (que usar de esa estructura de datos)
- [ ] noSQL


Estudio de concepto DB's:
mongodb
casandra o [ScyllaDB](https://www.scylladb.com/)
[redis.io](https://redis.io/)


## Requirements

filtrar por tipo de conector
filtrar por region del mapa
filtrar por estado


## Schema

![[location-module-20240522171228652.webp]]







## Concepts

[Un **eMSP** (E-Mobility Service Provider) es una entidad que ofrece un conjunto de servicios relacionados con la carga de vehículos eléctricos (EV) para los conductores de EV](https://www.chargepanel.com/ev-glossary/emsp-e-mobility-service-provider/)[1](https://www.chargepanel.com/ev-glossary/emsp-e-mobility-service-provider/). Los eMSP sirven como intermediarios, facilitando el acceso a una amplia red de estaciones de carga, a menudo a través de múltiples Operadores de Puntos de Carga (CPOs). [Proporcionan a los usuarios de EV herramientas y plataformas, como aplicaciones móviles o tarjetas RFID, para localizar, acceder y pagar las sesiones de carga](https://www.chargepanel.com/ev-glossary/emsp-e-mobility-service-provider/)[1](https://www.chargepanel.com/ev-glossary/emsp-e-mobility-service-provider/).

[Por otro lado, un **NSP** (Network Service Provider) puede definirse como una empresa u organización que proporciona servicios de red, como acceso a Internet, transmisión de datos y ofrece servicios de telecomunicaciones](https://techwatch.de/en/blog/understanding-the-definition-of-network-service-provider-nsp-expand-your-tech-knowledge/)[2](https://techwatch.de/en/blog/understanding-the-definition-of-network-service-provider-nsp-expand-your-tech-knowledge/). [Son responsables de establecer y mantener la infraestructura que permite la comunicación y la transferencia de datos entre múltiples dispositivos, redes y usuarios](https://techwatch.de/en/blog/understanding-the-definition-of-network-service-provider-nsp-expand-your-tech-knowledge/)[2](https://techwatch.de/en/blog/understanding-the-definition-of-network-service-provider-nsp-expand-your-tech-knowledge/).



## Endpoints


GET List: Request Parameters
Endpoint structure definition:

`{locations_endpoint_url}?[date_from={date_from}]&[date_to={date_to}]&[offset={offset}]&[limit={limit}]`

Examples:

`https://www.server.com/ocpi/cpo/2.2/locations/?date_from=2019-01-28T12:00:00&date_to=2019-01-29T12:00:00`

`https://ocpi.server.com/2.2/locations/?offset=50`

`https://www.server.com/ocpi/2.2/locations/?date_from=2019-01-29T12:00:00&limit=100`

`https://www.server.com/ocpi/cpo/2.2/locations/?offset=50&limit=100`



## QUESTIONS ????

how to define the types 
how to define those complex validations
what DStructure?
tests 

como se emplean los mapas en el entorno de electromovilidad





