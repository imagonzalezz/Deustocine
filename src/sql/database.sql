/* DELETE 'nucleus' database*/
DROP SCHEMA IF EXISTS deustocine;

/* DELETE USER 'root' AT LOCAL SERVER*/
DROP USER 'root'@'localhost';


/* CREATE 'nucleus' DATABASE */
CREATE SCHEMA deustocine;

/* CREATE THE USER 'root' AT LOCAL SERVER WITH PASSWORD 'root' */
CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
GRANT ALL ON deustocine.* TO 'root'@'localhost';