CREATE TABLE IF NOT EXISTS `usuarios` (
  `usuario_id` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `id` varchar(23) NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasenya` varchar(80) NOT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `unique_id` (`id`),
  UNIQUE KEY `correo` (`correo`)
)