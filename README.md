Parking project
=============

## Tabla de Contenidos


1. [Objetivo general](#objetivo-general)
2. [Problema](#problema)
3. [Bloqueos, restricciones](#bloqueos,-restricciones)
2. [Reglas de negocio](#reglas-de-negocio)
2. [Recursos](#recursos)
2. [Tiempo](#tiempo)
2. [Análisis de Stakeholders](#análisis-de-Stakeholders)
2. [Requisitos funcionales](#requisitos-funcionales)
2. [Requisitos no funcionales](#requisitos-no-funcionales)
2. [Historias de Usuario](#historias-de-Usuario)
2. [Problema](#problema)
2. [Problema](#problema)
2. [Problema](#problema)
2. [Problema](#problema)
2. [Problema](#problema)
2. [Problema](#problema)
2. [Problema](#problema)
2. [Problema](#problema)
3. 
4. 
5. 
    - [Funcionalidades](#funcionalidades)
    - [Enfoque de Desarrollo](#enfoque-de-desarrollo)
    - [Objetivos de Aprendizaje](#objetivos-de-aprendizaje)


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

### RF002 - Visualización de vehículos  

### Descripción  
Como usuario del parqueadero
Yo quiero visualizar la lista de vehículos registrados
Para tener un mejor conocimiento de los mismos y generar un eficiente seguimiento

### Definición 
El alcance de esta historia de usuario es describir el flujo correspondiente para la visualización de todos los vehículos registrados en el sistema.
El usuario contará con un apartado en el cual tendrá acceso a una lista de todos los vehículos registrados actualmente en el sistema, en esta lista el usuario verá la placa y dueño de cada vehículo.

### Criterios de aceptación
| Orden | Dado | Cuando | Entonces | Notas |
| :------------: |:---------------: |:---------------: |:---------------:| :---------------:|
|1|El usuario desea visualizar la lista de vehículos registrados|Accede al respectivo apartado |Debería visualizar una lista completa de todos los vehículos registrados en el sistema
|2|La lista de vehículos se actualiza regularmente|El usuario está visualizando la lista|La lista debe actualizarse automáticamente para reflejar cualquier cambio reciente en la base de datos

### RF003 - Visualización de vehículos especidifcos

### Descripción 
Como usuario del parqueadero
Yo quiero visualizar la información registrada de un vehículo especifico 
Para tener un apropiado manejo de procesos respecto a este teniendo en cuenta sus detalles 

### Definición
El alcance de esta historia de usuario es describir el flujo correspondiente para la visualización de información de un vehículo especifico registrado en el sistema.
El usuario podrá ingresar en un campo de entrada de datos la placa del vehículo que desea consultar, si esta placa se encuentra registrada, al seleccionar “consultar”, el usuario podrá visualizar información detallada del vehículo al cual le pertenece dicha placa, incluyendo:
- Placa
- Color
- Marca
- Dueño
- Modelo
- Hora de entrada

Si el vehículo no se encuentra registrado se mostrará un mensaje de error informando al usuario al respecto.
### Criterios de aceptación 
| Orden | Dado | Cuando | Entonces | Notas |
| :------------: |:---------------: |:---------------: |:---------------:| :---------------:|
|1|El usuario desea visualizar la información de un vehículo específico|Accede al respectivo apartado de consulta|Debería visualizar un campo de entrada de datos para ingresar la placa del vehículo
|2|El usuario diligencia la placa del vehículo|El usuario selecciona la opción "Consultar"|El sistema debe validar si el vehículo ya se encuentra registrado mediante su placa
|3|El usuario diligencia la placa del vehículo|El usuario selecciona la opción "Consultar"|El sistema debe validar que la placa cumpla con el formato requerido
|4|La placa ingresada está registrada|El usuario selecciona la opción "Consultar"|El sistema debe mostrar información detallada del vehículo al cual le pertenece la placa.
|5|El usuario genero la consulta|Accede al apartado la información detallada del vehículo|Debería ver claramente los detalles del vehículo, incluyendo Placa, Color, Marca, Dueño, Modelo y Hora de entrada
|6|El usuario desea obtener información detallada de un vehículo no registrado|Selecciona la opción "Consultar"|El sistema debe mostrar un mensaje de error informando al usuario que el vehículo no está registrado|La información ingresada puede ser editada para un nuevo intento
|7|El proceso de consulta no se completa con éxito por errores de validación|Selecciona la opción "Consultar"|El sistema debe mostrar un mensaje de alerta para para informar al usuario del tipo de error 

### RF004 - Eliminación de vehículos

### Descripción 
Como usuario del parqueadero
Yo quiero eliminar la información de vehículos 
Para gestionar de manera efectiva la información conservando únicamente aquella que pueda ser relevante para el sistema

### Definición 
El alcance de esta historia de usuario es describir el flujo correspondiente para la eliminación de vehículos en el sistema.
El usuario podrá ingresar en un campo de entrada de datos la placa del vehículo que desea eliminar, si esta placa se encuentra registrada el usuario podrá seleccionar la opción “Eliminar”, posterior a ello podrá visualizar un mensaje de confirmación para ratificar la decisión del usuario mediante la opción “Aceptar”, si el vehículo no se encuentra registrado se mostrará un mensaje de error informando al usuario al respecto.

### Criterios de aceptación 
| Orden | Dado | Cuando | Entonces | Notas |
| :------------: |:---------------: |:---------------: |:---------------:| :---------------:|
|1|El usuario desea eliminar un registro|El usuario accede al apartado de consulta|Podrá ingresar la placa del vehículo que desea consultar para posteriormente poder eliminarlo|No se hace énfasis en la consulta debido a que ese requisito ya se encuentra documentado
|2|El usuario encuentra un registro de ese vehículo|Selecciona la opción "Consultar"|Debería ver claramente los detalles del vehículo, incluyendo Placa, Color, Marca, Dueño, Modelo y Hora de entrada
|3|Accede al apartado la información detallada del vehículo|El usuario selecciona “Eliminar”|El sistema debe mostrar un mensaje de confirmación solicitando la ratificación del usuario mediante la opción "Aceptar".
|4|El usuario quiere confirmar la eliminación del vehículo|El usuario selecciona “Aceptar”|El sistema debe permitir la finalización del proceso y muestra el mensaje de éxito
|5|El vehículo se ha eliminado con éxito|El usuario visualiza la lista de registros|La lista debe estar actualizada y el registro que se elimino previamente no debe visualizarse

### RF005 - Actualización de vehículos
### Descripción 
Como usuario del parqueadero
Yo quiero actualizar la información de los vehículos
Para que la información sea acorde con la realidad
### Definición
El alcance de esta historia de usuario es describir el flujo correspondiente para la actualización de vehículos en el sistema.
El usuario podrá ingresar en un campo de entrada de datos la placa del vehículo que desea actualizar, si esta placa se encuentra registrada el usuario podrá visualizar un formulario en el cual se encuentran por defecto los datos actuales del vehículo, cada campo es editable excepto la placa, por ende, el usuario puede generar los cambios que desee, posterior a ello podrá seleccionar la opción “Actualizar” para poder finalizar la acción, si el proceso se completa satisfactoriamente se mostrara un mensaje de éxito confirmando la actualización, de lo contrario se presenta el mensaje de error.
Si el vehículo no se encuentra registrado se mostrará un mensaje de error informando al usuario al respecto.

### Criterios de aceptación 
| Orden | Dado | Cuando | Entonces | Notas |
| :------------: |:---------------: |:---------------: |:---------------:| :---------------:|
|1|El usuario desea eliminar un registro|El usuario accede al apartado de consulta|Podrá ingresar la placa del vehículo que desea consultar para posteriormente poder eliminarlo|No se hace énfasis en la consulta debido a que ese requisito ya se encuentra documentado
|2|El usuario encuentra un registro de ese vehículo|Selecciona la opción "Consultar"|Debería ver claramente los detalles del vehículo, incluyendo Placa, Color, Marca, Dueño, Modelo y Hora de entrada
|2|Accede al apartado la información detallada del vehículo|El usuario selecciona la opción "Actualizar"|El sistema debe mostrar un formulario prellenado con los datos actuales del vehículo, donde cada campo, excepto la placa, es editable
|3|El usuario ingresa la información del vehículo|Selecciona “Actualizar”|El sistema debe validar que todos los campos estén diligenciados
|4|El usuario ingresa la información del vehículo|Selecciona “Actualizar”|El sistema debe validar que los datos cumplan con la longitud especificada 
|5|El usuario ingresa la información del vehículo|Selecciona “Actualizar”|El sistema debe validar que los campos no tengan caracteres diferentes a los especificados
|6|El usuario ingresa la información del vehículo|Selecciona “Actualizar”|El sistema debe validar que los campos cumplan con el formato requerido 
|7|El usuario ingresa la información del vehículo|Selecciona “Actualizar”|El sistema debe validar que por lo menos un dato se haya modificado
|8|La validación es exitosa|El usuario genero la actualización|El sistema debe mostrar un mensaje de éxito confirmando la actualización satisfactoria
|9|El proceso de actualización no se completa con éxito por errores de validación|Selecciona la opción "Actualizar"|El sistema debe mostrar un mensaje de alerta para para informar al usuario del tipo de error 
|10|El usuario ha realizado cambios en los datos del vehículoSelecciona la opción "Actualizar" sin haber realizado modificaciones|El sistema debe mostrar un mensaje informativo indicando que no se han realizado cambios
|11|La placa ingresada no está registrada|El usuario selecciona la opción "Actualizar"|El sistema debe mostrar un mensaje de error informando al usuario que el vehículo no está registrado|La información ingresada puede ser editada para un nuevo intento
|12|El vehículo ha sido actualizado con éxito|El usuario revisa la lista de vehículos registrados|La lista debe actualizarse automáticamente para reflejar los cambios realizados

## Restricciones de validación

### Placa
- Requerido
- Formato especifico: AAA-123
- Pude contener letras en Mayúsculas y números
- Tiene que tener estrictamente una longitud de 7 caracteres
- Admite espacios vacíos 

### Color
- Requerido
- Debe tener un mínimo de 4 caracteres y un máximo de 20
- El color no debe contener números
- Puede contener caracteres especiales como tildes 
- Admite espacios vacíos 

### Marca
- Requerido
- Debe tener un mínimo de 4 caracteres y un máximo de 30 caracteres
- Puede contener caracteres especiales como tildes, diéresis, Guiones 
- Admite espacios vacíos 

### Dueño
- Requerido
- Puede contener caracteres en mayúsculas y minúsculas 
- Mínimo 3 caracteres máximo 50
- Puede contener caracteres especiales como tildes, diéresis
- Admite espacios vacíos 

### Modelo
- Requerido
- Debe ser un numero entero positivo
- Con una longitud obligatoria de 4 caracteres
- No puede contener letras
- No puede contener caracteres especiales de ningún tipo
- No admite espacios vacíos 

### Fecha entrada
- Debe tener un formato especifico: HH:MM AM/PM
- Puede contener caracteres especiales como “:”
- Admite espacios vacíos 

### Fecha salida
- Debe tener un formato especifico: HH:MM AM/PM
- Puede contener caracteres especiales como “:”
- Admite espacios vacíos

## Diagramas de casos de uso
![](https://github.com/val132005/parkingProject/blob/main/Images/casosDeUso/casosDeUsoDiagramaGeneral.png)
### RF001 - Registro de vehículos 
![](https://github.com/val132005/parkingProject/blob/main/Images/casosDeUso/casosDeUsoDiagramaRegistro.png)
### RF002 - Visualización de vehículos  
![](https://github.com/val132005/parkingProject/blob/main/Images/casosDeUso/casosDeUsoDiagramaConsultaGeneral.png)
### RF003 - Visualización de vehículos específicos
![](https://github.com/val132005/parkingProject/blob/main/Images/casosDeUso/casosDeUsoDiagramaConsultaIndividual.png)
### RF004 - Eliminación de vehículos
![](https://github.com/val132005/parkingProject/blob/main/Images/casosDeUso/casosDeUsoDiagramaEliminacion.png)
### RF005 - Actualización de vehículos
![](https://github.com/val132005/parkingProject/blob/main/Images/casosDeUso/casosDeUsoDiagramaModificacion.png)

## Diagramas de procesos
### RF001 - Registro de vehículos 
![](https://github.com/val132005/parkingProject/blob/main/Images/procesos/procesosDiagramaRegistro.png)
### RF002 - Visualización de vehículos  
![](https://github.com/val132005/parkingProject/blob/main/Images/procesos/procesosDiagramaConsultaGeneral.png)
### RF003 - Visualización de vehículos específicos
![](https://github.com/val132005/parkingProject/blob/main/Images/procesos/procesosDiagramaConsultaIndividual.png)
### RF004 - Eliminación de vehículos
![](https://github.com/val132005/parkingProject/blob/main/Images/procesos/procesosDiagramaEliminacion.png)
### RF005 - Actualización de vehículos
![](https://github.com/val132005/parkingProject/blob/main/Images/procesos/procesosDiagramaModificacion.png)

## Diagramas de secuencia
### RF001 - Registro de vehículos 
![](https://github.com/val132005/parkingProject/blob/main/Images/secuencia/secuenciaDiagramaRegistro.png)
### RF002 - Visualización de vehículos  
![](https://github.com/val132005/parkingProject/blob/main/Images/secuencia/secuenciaDiagramaConsultaGeneral.png)
### RF003 - Visualización de vehículos específicos
![](https://github.com/val132005/parkingProject/blob/main/Images/secuencia/secuenciaDiagramaConsultaIndividual.png)
### RF004 - Eliminación de vehículos
![](https://github.com/val132005/parkingProject/blob/main/Images/secuencia/secuenciaDiagramaEliminacion.png)
### RF005 - Actualización de vehículos
![](https://github.com/val132005/parkingProject/blob/main/Images/secuencia/secuenciaDiagramaModificacion.png)

## Diagrama de despliegue
![](https://github.com/val132005/parkingProject/blob/main/Images/despliegue/diagramaDeDespliegue.png)

## Wireframes
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesConsultaGeneral1.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesConsultaGeneral2.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesConsultaIndividual1.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesConsultaIndividual2.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesConsultaIndividual3.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesEliminacion1.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesGenral.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesModificacion1.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesModificacion2.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesRegistro1.png)
![](https://github.com/val132005/parkingProject/blob/main/Images/wireframes/wireframesRegistro2.png)





