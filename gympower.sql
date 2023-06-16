-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-06-2023 a las 06:30:45
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gympower`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cedula` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `edad` tinyint DEFAULT NULL,
  `genero` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fk_instructor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mryyq0lytmscgndt7wcyt2fyy` (`fk_instructor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_aud`
--

DROP TABLE IF EXISTS `cliente_aud`;
CREATE TABLE IF NOT EXISTS `cliente_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `apellido` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cedula` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `edad` tinyint DEFAULT NULL,
  `genero` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fk_instructor_id` int DEFAULT NULL,
  PRIMARY KEY (`rev`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_rutina`
--

DROP TABLE IF EXISTS `cliente_rutina`;
CREATE TABLE IF NOT EXISTS `cliente_rutina` (
  `cliente_id` int NOT NULL,
  `rutina_id` int NOT NULL,
  UNIQUE KEY `UK_h6n61vlrufhtpoxvcynjlqypi` (`rutina_id`),
  KEY `FKtfd9auvggybnqsle9gpcicddv` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_rutina_aud`
--

DROP TABLE IF EXISTS `cliente_rutina_aud`;
CREATE TABLE IF NOT EXISTS `cliente_rutina_aud` (
  `rev` int NOT NULL,
  `cliente_id` int NOT NULL,
  `rutina_id` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  PRIMARY KEY (`cliente_id`,`rev`,`rutina_id`),
  KEY `FK1ovkwt53m23385r4xskd196r4` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio`
--

DROP TABLE IF EXISTS `ejercicio`;
CREATE TABLE IF NOT EXISTS `ejercicio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descipcion` varchar(2500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `repeticiones` smallint DEFAULT NULL,
  `fk_maquina_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8bcd8mlu87l4iaxf8w5wqn0p4` (`fk_maquina_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio_aud`
--

DROP TABLE IF EXISTS `ejercicio_aud`;
CREATE TABLE IF NOT EXISTS `ejercicio_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `descipcion` varchar(2500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `repeticiones` smallint DEFAULT NULL,
  `fk_maquina_id` int DEFAULT NULL,
  PRIMARY KEY (`rev`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramienta`
--

DROP TABLE IF EXISTS `herramienta`;
CREATE TABLE IF NOT EXISTS `herramienta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramienta_aud`
--

DROP TABLE IF EXISTS `herramienta_aud`;
CREATE TABLE IF NOT EXISTS `herramienta_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `descripcion` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`rev`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instructor`
--

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE IF NOT EXISTS `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cedula` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `edad` tinyint DEFAULT NULL,
  `genero` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instructor_aud`
--

DROP TABLE IF EXISTS `instructor_aud`;
CREATE TABLE IF NOT EXISTS `instructor_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `apellido` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cedula` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `edad` tinyint DEFAULT NULL,
  `genero` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`rev`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revision_info`
--

DROP TABLE IF EXISTS `revision_info`;
CREATE TABLE IF NOT EXISTS `revision_info` (
  `id` int NOT NULL,
  `revision_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol_aud`
--

DROP TABLE IF EXISTS `rol_aud`;
CREATE TABLE IF NOT EXISTS `rol_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `nombre` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`rev`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina`
--

DROP TABLE IF EXISTS `rutina`;
CREATE TABLE IF NOT EXISTS `rutina` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(2500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tiempo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_aud`
--

DROP TABLE IF EXISTS `rutina_aud`;
CREATE TABLE IF NOT EXISTS `rutina_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `descripcion` varchar(2500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tiempo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`rev`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_ejercicio`
--

DROP TABLE IF EXISTS `rutina_ejercicio`;
CREATE TABLE IF NOT EXISTS `rutina_ejercicio` (
  `rutina_id` int NOT NULL,
  `ejercicio_id` int NOT NULL,
  UNIQUE KEY `UK_3e64qs04c4epw22ndn5u2akmw` (`ejercicio_id`),
  KEY `FKlbaibt7r0i47yof7mmbdwphay` (`rutina_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_ejercicio_aud`
--

DROP TABLE IF EXISTS `rutina_ejercicio_aud`;
CREATE TABLE IF NOT EXISTS `rutina_ejercicio_aud` (
  `rev` int NOT NULL,
  `rutina_id` int NOT NULL,
  `ejercicio_id` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  PRIMARY KEY (`rev`,`rutina_id`,`ejercicio_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seq_revision_id`
--

DROP TABLE IF EXISTS `seq_revision_id`;
CREATE TABLE IF NOT EXISTS `seq_revision_id` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `seq_revision_id`
--

INSERT INTO `seq_revision_id` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
CREATE TABLE IF NOT EXISTS `usuario_rol` (
  `usuario_id` int NOT NULL,
  `rol_id` int NOT NULL,
  UNIQUE KEY `UK_5gtipd65p6pda9ltx23lm68ge` (`rol_id`),
  KEY `FK5ctlfe74bikw2s6ac8cha630m` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol_aud`
--

DROP TABLE IF EXISTS `usuario_rol_aud`;
CREATE TABLE IF NOT EXISTS `usuario_rol_aud` (
  `rev` int NOT NULL,
  `usuario_id` int NOT NULL,
  `rol_id` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  PRIMARY KEY (`usuario_id`,`rev`,`rol_id`),
  KEY `FKudobkg2hyfayks15xmxhfna9` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FKlw53kqdr3pyfr3gwc41tixp0i` FOREIGN KEY (`fk_instructor_id`) REFERENCES `instructor` (`id`);

--
-- Filtros para la tabla `cliente_aud`
--
ALTER TABLE `cliente_aud`
  ADD CONSTRAINT `FK2cwy5m86dqvvt3yfrou3cuak0` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `cliente_rutina`
--
ALTER TABLE `cliente_rutina`
  ADD CONSTRAINT `FKotrk6fk0ls3yuqqaswjho8kay` FOREIGN KEY (`rutina_id`) REFERENCES `rutina` (`id`),
  ADD CONSTRAINT `FKtfd9auvggybnqsle9gpcicddv` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `cliente_rutina_aud`
--
ALTER TABLE `cliente_rutina_aud`
  ADD CONSTRAINT `FK1ovkwt53m23385r4xskd196r4` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `ejercicio`
--
ALTER TABLE `ejercicio`
  ADD CONSTRAINT `FK9gfx8ssmvjxjr2g3mwme45gb6` FOREIGN KEY (`fk_maquina_id`) REFERENCES `herramienta` (`id`);

--
-- Filtros para la tabla `ejercicio_aud`
--
ALTER TABLE `ejercicio_aud`
  ADD CONSTRAINT `FKgeajqyv5s6qkoki82kmulvvjr` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `herramienta_aud`
--
ALTER TABLE `herramienta_aud`
  ADD CONSTRAINT `FKs0c0h3kvji9ttryse1ii8s0ow` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `instructor_aud`
--
ALTER TABLE `instructor_aud`
  ADD CONSTRAINT `FK8hngtf0pc5qpyx868ou85hqqh` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `rol_aud`
--
ALTER TABLE `rol_aud`
  ADD CONSTRAINT `FK8hav4bg9294w6mt32ncr68mlx` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `rutina_aud`
--
ALTER TABLE `rutina_aud`
  ADD CONSTRAINT `FK7lbnk86ccp08xgouj928rvfbr` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `rutina_ejercicio`
--
ALTER TABLE `rutina_ejercicio`
  ADD CONSTRAINT `FK7v0s69x4cxrhdsx7hj1gnj858` FOREIGN KEY (`ejercicio_id`) REFERENCES `ejercicio` (`id`),
  ADD CONSTRAINT `FKlbaibt7r0i47yof7mmbdwphay` FOREIGN KEY (`rutina_id`) REFERENCES `rutina` (`id`);

--
-- Filtros para la tabla `rutina_ejercicio_aud`
--
ALTER TABLE `rutina_ejercicio_aud`
  ADD CONSTRAINT `FKaykxgjmmt8cjjd9ugscf9n84` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FK5ctlfe74bikw2s6ac8cha630m` FOREIGN KEY (`usuario_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK610kvhkwcqk2pxeewur4l7bd1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);

--
-- Filtros para la tabla `usuario_rol_aud`
--
ALTER TABLE `usuario_rol_aud`
  ADD CONSTRAINT `FKudobkg2hyfayks15xmxhfna9` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
