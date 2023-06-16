-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-06-2023 a las 04:41:03
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
  `edad` tinyint DEFAULT NULL,
  `fk_instructor_id` int DEFAULT NULL,
  `fk_rutina_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `cedula` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `genero` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mryyq0lytmscgndt7wcyt2fyy` (`fk_instructor_id`),
  UNIQUE KEY `UK_pibcf6p7ipwyibbnk3myriboq` (`fk_rutina_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_aud`
--

DROP TABLE IF EXISTS `cliente_aud`;
CREATE TABLE IF NOT EXISTS `cliente_aud` (
  `edad` tinyint DEFAULT NULL,
  `fk_instructor_id` int DEFAULT NULL,
  `fk_rutina_id` int DEFAULT NULL,
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `cedula` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `genero` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK2cwy5m86dqvvt3yfrou3cuak0` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio`
--

DROP TABLE IF EXISTS `ejercicio`;
CREATE TABLE IF NOT EXISTS `ejercicio` (
  `fk_maquina_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `repeticiones` smallint DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descipcion` varchar(2500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8bcd8mlu87l4iaxf8w5wqn0p4` (`fk_maquina_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio_aud`
--

DROP TABLE IF EXISTS `ejercicio_aud`;
CREATE TABLE IF NOT EXISTS `ejercicio_aud` (
  `fk_maquina_id` int DEFAULT NULL,
  `id` int NOT NULL,
  `repeticiones` smallint DEFAULT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descipcion` varchar(2500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKgeajqyv5s6qkoki82kmulvvjr` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramienta`
--

DROP TABLE IF EXISTS `herramienta`;
CREATE TABLE IF NOT EXISTS `herramienta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKs0c0h3kvji9ttryse1ii8s0ow` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instructor`
--

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE IF NOT EXISTS `instructor` (
  `edad` tinyint DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `cedula` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `genero` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instructor_aud`
--

DROP TABLE IF EXISTS `instructor_aud`;
CREATE TABLE IF NOT EXISTS `instructor_aud` (
  `edad` tinyint DEFAULT NULL,
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `cedula` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `genero` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK8hngtf0pc5qpyx868ou85hqqh` (`rev`)
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
-- Estructura de tabla para la tabla `rutina`
--

DROP TABLE IF EXISTS `rutina`;
CREATE TABLE IF NOT EXISTS `rutina` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` varchar(2500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` varchar(2500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tiempo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK7lbnk86ccp08xgouj928rvfbr` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_ejercicio`
--

DROP TABLE IF EXISTS `rutina_ejercicio`;
CREATE TABLE IF NOT EXISTS `rutina_ejercicio` (
  `ejercicio_id` int NOT NULL,
  `rutina_id` int NOT NULL,
  UNIQUE KEY `UK_3e64qs04c4epw22ndn5u2akmw` (`ejercicio_id`),
  KEY `FKlbaibt7r0i47yof7mmbdwphay` (`rutina_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina_ejercicio_aud`
--

DROP TABLE IF EXISTS `rutina_ejercicio_aud`;
CREATE TABLE IF NOT EXISTS `rutina_ejercicio_aud` (
  `ejercicio_id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `rutina_id` int NOT NULL,
  PRIMARY KEY (`ejercicio_id`,`rev`,`rutina_id`),
  KEY `FKaykxgjmmt8cjjd9ugscf9n84` (`rev`)
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

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FKda74abxxf19jjc47ss7weedrl` FOREIGN KEY (`fk_rutina_id`) REFERENCES `rutina` (`id`),
  ADD CONSTRAINT `FKlw53kqdr3pyfr3gwc41tixp0i` FOREIGN KEY (`fk_instructor_id`) REFERENCES `instructor` (`id`);

--
-- Filtros para la tabla `cliente_aud`
--
ALTER TABLE `cliente_aud`
  ADD CONSTRAINT `FK2cwy5m86dqvvt3yfrou3cuak0` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
