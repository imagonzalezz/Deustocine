DROP SCHEMA IF EXISTS deustocine;
DROP USER 'root'@'localhost';

CREATE SCHEMA deustocine;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'deusto';
GRANT ALL ON deustocine.* TO 'root'@'localhost';