#DeustoCine
_Código para compilar y hacer una instalación limpia de mvn_

```
mvn clean install
```
### Base de datos
_Crear una base de datos llamada deustocinedb en MySQL y dar permisos al usuario por defecto_

```
DROP SCHEMA IF EXISTS deustocinedb;

DROP USER 'root'@'localhost';

CREATE SCHEMA deustocinedb;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
GRANT ALL ON deustocine.* TO 'root'@'localhost';
```
_Despues crear las tablas en la base de datos_

```
mvn datanucleus:schema-create
```
_Lanzar el servidor_

```
mvn jetty:run
```

_Lanzar el cliente_

```
mvn exec:java -Pclient
```
