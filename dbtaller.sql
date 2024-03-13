-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-03-2024 a las 20:29:06
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbtaller`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autoridades`
--

CREATE TABLE `autoridades` (
  `id` int(11) NOT NULL,
  `nombre` enum('WRITE','READ','ADMIN') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `autoridades`
--

INSERT INTO `autoridades` (`id`, `nombre`) VALUES
(1, 'WRITE'),
(2, 'READ'),
(3, 'ADMIN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion`
--

CREATE TABLE `clasificacion` (
  `id` int(11) NOT NULL,
  `id_competidor` int(11) NOT NULL,
  `id_competencia` int(11) NOT NULL,
  `nro_ganados` int(11) NOT NULL DEFAULT 0,
  `nro_empatados` int(11) NOT NULL DEFAULT 0,
  `nro_perdidos` int(11) NOT NULL DEFAULT 0,
  `fecha_baja` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clasificacion`
--

INSERT INTO `clasificacion` (`id`, `id_competidor`, `id_competencia`, `nro_ganados`, `nro_empatados`, `nro_perdidos`, `fecha_baja`) VALUES
(1, 1, 1, 3, 2, 1, NULL),
(2, 2, 2, 2, 3, 1, NULL),
(3, 3, 3, 1, 4, 1, NULL),
(4, 4, 4, 0, 5, 1, NULL),
(5, 5, 5, 3, 1, 2, NULL),
(6, 6, 6, 2, 2, 2, NULL),
(7, 7, 7, 1, 3, 2, NULL),
(8, 8, 8, 0, 4, 2, NULL),
(9, 9, 9, 3, 0, 3, NULL),
(10, 10, 10, 2, 1, 3, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `competencia`
--

CREATE TABLE `competencia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_baja` datetime DEFAULT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `competencia`
--

INSERT INTO `competencia` (`id`, `nombre`, `estado`, `fecha_baja`, `fecha_inicio`, `fecha_creacion`, `id_usuario`) VALUES
(1, 'Competencia 1', '1', NULL, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 1),
(2, 'Competencia 2', '1', NULL, '2024-02-01 00:00:00', '2024-01-15 00:00:00', 2),
(3, 'Competencia 3', '1', NULL, '2024-03-01 00:00:00', '2024-02-15 00:00:00', 3),
(4, 'Competencia 4', '1', NULL, '2024-04-01 00:00:00', '2024-03-15 00:00:00', 4),
(5, 'Competencia 5', '1', NULL, '2024-05-01 00:00:00', '2024-04-15 00:00:00', 5),
(6, 'Competencia 6', '1', NULL, '2024-06-01 00:00:00', '2024-05-15 00:00:00', 6),
(7, 'Competencia 7', '1', NULL, '2024-07-01 00:00:00', '2024-06-15 00:00:00', 7),
(8, 'Competencia 8', '1', NULL, '2024-08-01 00:00:00', '2024-07-15 00:00:00', 8),
(9, 'Competencia 9', '1', NULL, '2024-09-01 00:00:00', '2024-08-15 00:00:00', 9),
(10, 'Competencia 10', '1', NULL, '2024-10-01 00:00:00', '2024-09-15 00:00:00', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participante`
--

CREATE TABLE `participante` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `colores` varchar(100) DEFAULT NULL,
  `trofeos` varchar(500) DEFAULT NULL,
  `fecha_baja` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `participante`
--

INSERT INTO `participante` (`id`, `nombre`, `colores`, `trofeos`, `fecha_baja`) VALUES
(1, 'Participante 1', 'Rojo y blanco', 'Trofeo 1, Trofeo 2', NULL),
(2, 'Participante 2', 'Azul y blanco', 'Trofeo 3', NULL),
(3, 'Participante 3', 'Verde y blanco', 'Trofeo 4, Trofeo 5, Trofeo 6', NULL),
(4, 'Participante 4', 'Amarillo y negro', 'Trofeo 7', NULL),
(5, 'Participante 5', 'Negro y blanco', 'Trofeo 8, Trofeo 9', NULL),
(6, 'Participante 6', 'Azul y amarillo', 'Trofeo 10', NULL),
(7, 'Participante 7', 'Rojo y negro', 'Trofeo 11, Trofeo 12', NULL),
(8, 'Participante 8', 'Verde y amarillo', 'Trofeo 13', NULL),
(9, 'Participante 9', 'Azul y rojo', 'Trofeo 14, Trofeo 15, Trofeo 16', NULL),
(10, 'Participante 10', 'Amarillo y blanco', 'Trofeo 17', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE `partido` (
  `id` bigint(20) NOT NULL,
  `id_local` int(11) NOT NULL,
  `id_visitante` int(11) NOT NULL,
  `id_competencia` bigint(20) DEFAULT NULL,
  `goles_local` int(11) NOT NULL DEFAULT 0,
  `goles_visitante` int(11) NOT NULL DEFAULT 0,
  `fecha_baja` datetime DEFAULT NULL,
  `fecha_realizacion` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partido`
--

INSERT INTO `partido` (`id`, `id_local`, `id_visitante`, `id_competencia`, `goles_local`, `goles_visitante`, `fecha_baja`, `fecha_realizacion`) VALUES
(1, 1, 2, 1, 3, 1, NULL, '2024-01-01 00:00:00.000000'),
(2, 3, 4, 2, 2, 2, NULL, '2024-02-01 00:00:00.000000'),
(3, 5, 6, 3, 1, 0, NULL, '2024-03-01 00:00:00.000000'),
(4, 7, 8, 4, 0, 3, NULL, '2024-04-01 00:00:00.000000'),
(5, 9, 10, 5, 2, 1, NULL, '2024-05-01 00:00:00.000000'),
(6, 1, 3, 6, 1, 1, NULL, '2024-06-01 00:00:00.000000'),
(7, 2, 4, 7, 0, 0, NULL, '2024-07-01 00:00:00.000000'),
(8, 5, 7, 8, 3, 2, NULL, '2024-08-01 00:00:00.000000'),
(9, 6, 8, 9, 2, 3, NULL, '2024-09-01 00:00:00.000000'),
(10, 9, 1, 10, 1, 2, NULL, '2024-10-01 00:00:00.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `contrasenia` varchar(255) NOT NULL,
  `fecha_baja` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `mail`, `contrasenia`, `fecha_baja`) VALUES
(1, 'user_prueba', 'user2_prueba', 'mail@mail', 'sonUNpas123', NULL),
(2, 'Juan', 'Perez', 'juan.perez@mail.com', 'juan123', NULL),
(3, 'Maria', 'Gomez', 'maria.gomez@mail.com', 'maria123', NULL),
(4, 'Carlos', 'Rodriguez', 'carlos.rodriguez@mail.com', 'carlos123', NULL),
(5, 'Ana', 'Lopez', 'ana.lopez@mail.com', 'ana123', NULL),
(6, 'Pedro', 'Gonzalez', 'pedro.gonzalez@mail.com', 'pedro123', NULL),
(7, 'Laura', 'Martinez', 'laura.martinez@mail.com', 'laura123', NULL),
(8, 'Jose', 'Hernandez', 'jose.hernandez@mail.com', 'jose123', NULL),
(9, 'Carmen', 'Torres', 'carmen.torres@mail.com', 'carmen123', NULL),
(10, 'Manuel', 'Ramirez', 'manuel.ramirez@mail.com', 'manuel123', NULL),
(11, 'Sofia', 'Morales', 'sofia.morales@mail.com', 'sofia123', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_autoridades`
--

CREATE TABLE `usuario_autoridades` (
  `id` int(11) NOT NULL,
  `autoridad_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autoridades`
--
ALTER TABLE `autoridades`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_Participante` (`id_competidor`),
  ADD KEY `fk1_Competencia` (`id_competencia`);

--
-- Indices de la tabla `competencia`
--
ALTER TABLE `competencia`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `fk1_usuario` (`id_usuario`);

--
-- Indices de la tabla `participante`
--
ALTER TABLE `participante`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `partido`
--
ALTER TABLE `partido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_ParticipanteLocal` (`id_local`),
  ADD KEY `fk2_ParticipanteVisitante` (`id_visitante`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- Indices de la tabla `usuario_autoridades`
--
ALTER TABLE `usuario_autoridades`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_usuario_id` (`usuario_id`),
  ADD KEY `fk2_autoridad_id` (`autoridad_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `competencia`
--
ALTER TABLE `competencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `participante`
--
ALTER TABLE `participante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT de la tabla `partido`
--
ALTER TABLE `partido`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT de la tabla `usuario_autoridades`
--
ALTER TABLE `usuario_autoridades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD CONSTRAINT `fk1_Competencia` FOREIGN KEY (`id_competencia`) REFERENCES `competencia` (`id`),
  ADD CONSTRAINT `fk1_Participante` FOREIGN KEY (`id_competidor`) REFERENCES `participante` (`id`);

--
-- Filtros para la tabla `competencia`
--
ALTER TABLE `competencia`
  ADD CONSTRAINT `fk1_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `partido`
--
ALTER TABLE `partido`
  ADD CONSTRAINT `fk1_ParticipanteLocal` FOREIGN KEY (`id_local`) REFERENCES `participante` (`id`),
  ADD CONSTRAINT `fk2_ParticipanteVisitante` FOREIGN KEY (`id_visitante`) REFERENCES `participante` (`id`);

--
-- Filtros para la tabla `usuario_autoridades`
--
ALTER TABLE `usuario_autoridades`
  ADD CONSTRAINT `fk1_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `fk2_autoridad_id` FOREIGN KEY (`autoridad_id`) REFERENCES `autoridades` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
