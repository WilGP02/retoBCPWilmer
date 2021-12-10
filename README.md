### Docker
JDK 11
####
Apache Maven 3.6.3
####
1.- Compilar el proyecto con "mvn clean install".
###
2.- Construir la imagen con "docker build -t exchange-currency:v1 ."
###
3.- Levantar la imagen con "docker run -p 8090:8090 --name exchange-currency exchange-currency:v1"
###
Se levantará en el puerto 8090.
###
Endpoints:

Conseguir Token para el consumo de APIS:
localhost:8090/user?user=wilmer&password=12345

Listar Tipos de Cambios:
localhost:8090/reto/api/currency

Realizar el Cambio:
localhost:8090/reto/api/change

Actualizar el Tipo de Cambio:
localhost:8090/reto/api/updateCurrency