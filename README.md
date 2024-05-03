Parking project
=============

## Objetivo general:
Desarrollar un microservicio que gestione eficientemente el proceso de registro de vehículos en un parqueadero.
Este microservicio permitirá agregar, borrar, actualizar información y mostrar la lista de vehículos registrados. Además, se enfocará en adquirir los conocimientos técnicos y habilidades blandas que debe poseer un desarrollador Java back-end Junior.


## Problema
La falta de sistemas de información en los parqueaderos conlleva una serie de problemáticas que afectan tanto a los usuarios como a los operadores de estos espacios. Sin un sistema que registre y controle el ingreso y salida de vehículos, los parqueaderos pueden enfrentarse a un uso ineficiente del espacio, resultando en congestión y largos tiempos de espera para los usuarios.
La ausencia de datos en tiempo real sobre la ocupación del estacionamiento dificulta la toma de decisiones informadas por parte de los operadores, lo que puede resultar en errores a gran escala debido a sobrecupos o espacio no utilizado. Esto puede generar una experiencia frustrante para los usuarios, así como una pérdida de ingresos para los operadores del parqueadero.
La implementación de un sistema de información adecuado no solo puede abordar estas problemáticas, sino también mejorar en gran medida la experiencia de estacionamiento y la eficiencia en el manejo de los parqueaderos.


## Bloqueos, restricciones
- Seguridad: Se deben implementar medidas de seguridad suficientes para proteger la privacidad de los usuarios y la integridad de los datos.
- Cumplimiento Normativo: El sistema debe cumplir con las regulaciones y normativas a nivel nacional relacionadas con la gestión de datos personales, derechos de autor y accesibilidad web.
- El sistema además debe cumplir con normativas establecidas para la gestión de parqueaderos reguladas en Colombia 
- Documentación y Capacitación: Se debe proporcionar documentación detallada para los usuarios del sistema. 
- Tecnología: El sistema debe desarrollarse utilizando las siguientes tecnologías: cualquier framework de java: Spring o micronaut que se pueda consumir una API REST desde una
colección de postman, versión Java JDK 17,  base de datos a libre elección, se debe utilizar un sistema de manejo de versiones (GitHub) y el framework Junit para la realización de testing.
- Pruebas y Calidad del Software: Se deben realizar pruebas durante todo el desarrollo para garantizar la calidad del software.


## Reglas de negocio
- Software únicamente para Colombia
- Se admitirán pagos en pesos colombianos
- Pagos con tarjeta débito, crédito o efectivo
- Se aplican leyes de Colombia para la gestión de parqueaderos 
- Tarifas y cobros establecidos 
- Debe haber protección de datos personales


## Recursos
- Desarrollador Java Back-end junior
- Líder técnico
- Entorno integrado de desarrollo (IntelliJ IDE)
- Base de datos y sistemas gestor de base de datos (MySQL)
- Herramienta de gestión de versiones del código (GitHub)
- Colección de postman o insomnia 


## Tiempo
Se estima que la duración del proyecto para gestión de vehículos de un parqueadero será de 4 meses 

## Análisis de Stakeholders
| Types of Stakeholders  | Name  | Description |
| :------------ |:---------------: |:---------------:|
| Owners - Manager      | Propietario del Parqueadero | Representante legal de la compañía quien además de ello patrocina el proyecto, tiene un interés directo con la eficiencia del sistema planteado |
| Customers      | Clientes del Parqueadero        |   Personas que estaciona su vehículo en dicho parqueadero asumiendo el costo del mismo |
| Employees | Empleados del parqueadero   |    Trabajadores encargados de la gestión y supervisión de los vehículos y el funcionamiento general del estacionamiento |
| Government | Regulatory authorities (Alcaldía mayor de Bogotá, secretaria general de la alcaldía mayor de Bogotá, Consejo de Bogotá, secretaria distrital de transito y de transporte, concejo del estado, concejo distrital)       |    Entes legales que generan pautas para que se pueda llevar a cabo el funcionamiento de un parqueadero   |
| Society | Vecinos y comunidad      |    Personas cercanas a la ubicación de dicho establecimiento que pueden llegar a tener un impacto |

## Requisitos funcionales
RF001. El sistema debe permitir al usuario registrar los datos de diferentes vehículos 
RF002. El sistema de be permitirle al usuario eliminar vehículos
RF003. El sistema debe permitirle al usuario actualizar la información de los diferentes vehículos
RF004. El sistema debe permitirle al usuario visualizar la lista de los vehículos agregados y su información especifica

## Requisitos no funcionales

RNF001. El sistema debe ser desarrollado utilizando cualquier framework de Java, como Spring o Micronaut.
RNF002. El microservicio debe ser consumible a través de una API REST, que permita realizar operaciones como GET, POST y DELETE.
RNF003 El sistema debe ser compatible con Java JDK 17.
RNF004. El sistema debe tener conexión a una base de datos, la cual puede ser elegida por el desarrollador.
RNF005. Todo el código del microservicio debe ser guardado en un repositorio en GitLab, GitHub, o cualquier otro repositorio de elección del desarrollador.
RNF006. Se recomienda el uso de patrones de software, principios de clean code, librerías y dependencias adecuadas para el desarrollo del microservicio.
RNF007. Se recomienda la realización de pruebas unitarias utilizando JUnit o cualquier otro framework de testing desead

## Historias de Usuario
### RF001 - Registro de vehículos 

### Descripción  

Como usuario del parqueadero (Especificación de usuarios)
Yo quiero agregar los datos de mi vehículo a un formulario
Para registrar mi vehículo y poder hacer uso de servicio del parking

### Definición 
El alcance de esta historia de usuario es describir el flujo correspondiente para el registro de vehículos en el sistema.
El usuario podrá visualizar un formulario de registro del vehículo con los siguientes campos:
- Placa
- Color
- Marca
- Dueño
- Modelo
- Hora de entrada

Después de llenar todos los campos va a poder finalizar el proceso al seleccionar “Registrar”, si el proceso se completa con éxito se mostrará un mensaje de éxito confirmando el registro, de lo contrario se presenta el mensaje de error.

### Criterios de aceptación 

| Orden | Dado | Cuando | Entonces | Notas |
| :------------: |:---------------: |:---------------: |:---------------:| :---------------:|
|1|El usuario desea registrar un vehículo | Accede al formulario de registro | Visualizara los campos para ingresar los siguientes datos: Placa, Color, Marca, Dueño, Modelo y Hora de entrada | Esta visualización no debe contar con diseño
|2|El usuario ingresa la información del vehículo|Selecciona “Registrar”|El sistema debe validar que todos los campos se hayan diligenciado
|3|El usuario ingresa la información del vehículo|Selecciona “Registrar”|El sistema debe validar que los datos cumplan con la longitud especificada 
|4|El usuario ingresa la información del vehículo|Selecciona “Registrar”|El sistema debe validar que los campos no tengan caracteres diferentes a los especificados
|5|El usuario ingresa la información del vehículo|Selecciona “Registrar”|El sistema debe validar que los campos cumplan con el formato requerido 
|6|El usuario ingresa la información del vehículo|Selecciona “Registrar|El sistema debe validar si el vehículo ya se encuentra registrado mediante su placa 
|7|El proceso de registro se completa con éxito|Se selecciona “Registrar”|El sistema debe mostrar un mensaje de éxito para confirmar el registro
|8|El proceso de registro no se completa con éxito por errores de validación |Se selecciona “Registrar”|El sistema debe mostrar un mensaje de alerta para para informar al usuario del tipo de error 
|9|El usuario ha registrado exitosamente el vehículo|Accede a la lista de vehículos |La lista de vehículos debe actualizarse mostrando este nuevo registro 
