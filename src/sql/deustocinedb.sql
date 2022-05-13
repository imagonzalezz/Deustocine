/* DELETE 'nucleus' database*/
DROP SCHEMA IF EXISTS deustocinedb;

/* DELETE USER 'root' AT LOCAL SERVER*/
DROP USER 'root'@'localhost';


/* CREATE 'nucleus' DATABASE */
CREATE SCHEMA deustocinedb;

/* CREATE THE USER 'root' AT LOCAL SERVER WITH PASSWORD 'root' */
CREATE USER 'root'@'localhost' IDENTIFIED BY 'deusto';
GRANT ALL ON deustocinedb.* TO 'root'@'localhost';