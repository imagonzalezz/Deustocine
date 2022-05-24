#DeustoCine

### Base de datos
_Crear una base de datos llamada deustocinedb en MySQL y dar permisos al usuario por defecto_

```
DROP SCHEMA IF EXISTS deustocinedb;

DROP USER 'root'@'localhost';


CREATE SCHEMA deustocinedb;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'deusto';
GRANT ALL ON deustocinedb.* TO 'root'@'localhost';
```


_Comando para compilar el codigo _

```
mvn clean compile
```

_Para que las clases se usen en la BD_

```
mvn datanucleus:enhance
```

_Para probar los test_

```
mvn test
```

_Despues crear las tablas en la base de datos_

```
mvn datanucleus:schema-create
```

_Carga los datos de prueba en la BD_

```
mvn exec:java -Pdatos
```
_Lanzar el servidor_

```
mvn jetty:run
```
_Lanzar la parte cliente

```
mvn exec:java -Pclient
```
