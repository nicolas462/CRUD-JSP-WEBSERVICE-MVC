-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2021 a las 05:18:58
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `quileia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `idCita` int(11) NOT NULL,
  `fecha_solicitada` date NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idMedico` int(11) NOT NULL,
  `fecha_asignada` date NOT NULL,
  `hora_asignada` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`idCita`, `fecha_solicitada`, `idPaciente`, `idMedico`, `fecha_asignada`, `hora_asignada`) VALUES
(1, '2021-05-17', 1, 2, '2020-01-01', '05:40'),
(2, '2021-05-17', 1, 2, '2020-01-01', '06:40'),
(3, '2021-05-17', 1, 2, '2020-12-01', '08:00'),
(8, '2021-05-17', 1, 2, '2020-01-01', '09:00'),
(9, '2021-05-17', 1, 2, '2020-01-01', '10:00'),
(11, '2021-05-17', 1, 2, '2020-01-01', '08:00'),
(12, '2021-05-17', 1, 2, '2021-05-17', '20:19'),
(13, '2021-05-17', 1, 5, '2021-05-17', '00:50'),
(14, '2021-05-17', 1, 2, '2021-05-17', '15:00'),
(15, '2021-05-17', 1, 2, '2021-05-17', '17:30'),
(16, '2021-05-17', 1, 2, '2021-05-17', '18:30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `idMedico` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `identificacion` varchar(45) NOT NULL,
  `tipo_identificacion` varchar(3) NOT NULL,
  `numero_tarjeta` varchar(45) NOT NULL,
  `anos_experiencia` double NOT NULL,
  `especialidad` varchar(45) NOT NULL,
  `inicio_atencion` varchar(45) NOT NULL,
  `fin_atencion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`idMedico`, `nombre`, `identificacion`, `tipo_identificacion`, `numero_tarjeta`, `anos_experiencia`, `especialidad`, `inicio_atencion`, `fin_atencion`) VALUES
(2, 'Lina Linares', '123', 'CC', '41548-Y', 8.7, 'Dermatologia', '05:40', '20:55'),
(5, 'Ricardo Lopez', '456', 'CC', '45644-Y', 5.7, 'Pediatra', '20:30', '04:30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `identificacion` varchar(45) NOT NULL,
  `tipo_identificacion` varchar(45) NOT NULL,
  `eps` varchar(45) NOT NULL,
  `historia_clinica` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombre`, `fecha_nacimiento`, `identificacion`, `tipo_identificacion`, `eps`, `historia_clinica`) VALUES
(1, 'Javier Montenegro', '2016-01-01', '5', 'CC', 'Nueva EPS', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vestibulum, ante et condimentum venenatis, nisl urna blandit massa, eget egestas lectus felis sed velit. Nam elementum lectus ac nulla accumsan interdum. Nulla purus diam, lacinia vulputate lacinia id, malesuada quis tellus. Nullam id arcu ac lacus bibendum vestibulum sit amet eu urna. Aliquam ut magna nulla, in fringilla neque. Duis faucibus arcu vel quam dictum id tincidunt sem bibendum. Nulla risus sem, euismod a mollis et, iaculis a mi. Etiam tincidunt aliquam turpis, ut fermentum massa tincidunt in. Mauris non quam ante, sed congue neque. Vestibulum egestas sodales arcu, a convallis ipsum luctus nec. Suspendisse potenti. Praesent accumsan sapien id erat elementum et suscipit tellus sollicitudin. Cras sed libero sem, sed porttitor massa. Phasellus a augue sapien.'),
(2, 'Lorena Parra', '2011-11-11', '333', 'TI', 'Compensar', 'BLOKK has unusually large character widths, which adds much length to \"standard\" bits of dummy text, and also creates unecessarily ragged rags in my copy. Redacted solves this by using sane character widths; averaging character widths of narrow, regular, and wide characters of standard fonts. This gives a more realistic look to the text and helps it fit into narrow columns like real text would. Redacted Font also comes with script versions in three weights, regular, bold and light.');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`idCita`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `idMedico` (`idMedico`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`idMedico`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `idCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `idMedico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`idMedico`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
