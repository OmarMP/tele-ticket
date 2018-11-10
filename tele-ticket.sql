-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 10, 2018 at 03:33 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tele-ticket`
--

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `descricion` varchar(100) NOT NULL,
  `usuariocreo` varchar(100) NOT NULL,
  `usuariomodifico` varchar(100) DEFAULT NULL,
  `fechamodifico` date DEFAULT NULL,
  `fechacreo` date NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `departamento`
--

CREATE TABLE `departamento` (
  `idDepartamento` int(10) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `usuariocreo` varchar(100) NOT NULL,
  `usuariomodifico` varchar(100) DEFAULT NULL,
  `fechamodifico` date DEFAULT NULL,
  `fechacreo` date NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `estado`
--

CREATE TABLE `estado` (
  `idEstado` int(11) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `usuariocreo` varchar(100) NOT NULL,
  `usuariomodifico` varchar(100) DEFAULT NULL,
  `fechamodifico` date DEFAULT NULL,
  `fechacreo` date NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `incidencia`
--

CREATE TABLE `incidencia` (
  `idIncidencia` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `idUsuario` varchar(100) NOT NULL,
  `usuariomodifico` varchar(100) DEFAULT NULL,
  `fechacreo` date NOT NULL,
  `fechamodifico` date DEFAULT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `prioridad`
--

CREATE TABLE `prioridad` (
  `idPrioridad` int(11) NOT NULL,
  `prioridad` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `usuariocreo` varchar(100) NOT NULL,
  `usuariomodifico` varchar(100) DEFAULT NULL,
  `fechamodifico` date DEFAULT NULL,
  `fechacreo` date NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `usuariocreo` varchar(100) NOT NULL,
  `usuariomodifico` varchar(100) DEFAULT NULL,
  `fechamodifico` date DEFAULT NULL,
  `fechacreo` date NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL,
  `idUsuario` varchar(100) NOT NULL,
  `idPrioridad` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFinal` datetime NOT NULL,
  `idIncidencia` int(11) NOT NULL,
  `comentario` varchar(100) NOT NULL,
  `usuariomodifico` varchar(100) DEFAULT NULL,
  `fechamodifico` date DEFAULT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` varchar(100) NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `usuariocreo` varchar(100) NOT NULL,
  `usuariomodifico` varchar(100) DEFAULT NULL,
  `fechamodifico` date DEFAULT NULL,
  `fechacreo` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indexes for table `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`idDepartamento`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indexes for table `incidencia`
--
ALTER TABLE `incidencia`
  ADD PRIMARY KEY (`idIncidencia`),
  ADD KEY `idCategoria` (`idCategoria`);

--
-- Indexes for table `prioridad`
--
ALTER TABLE `prioridad`
  ADD PRIMARY KEY (`idPrioridad`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idTicket`),
  ADD KEY `idPrioridad` (`idPrioridad`),
  ADD KEY `idEstado` (`idEstado`),
  ADD KEY `idIncidencia` (`idIncidencia`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `idDepartamento` (`idDepartamento`,`idRol`),
  ADD KEY `idDepartamento_2` (`idDepartamento`,`idRol`),
  ADD KEY `idRol` (`idRol`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `incidencia`
--
ALTER TABLE `incidencia`
  ADD CONSTRAINT `incidencia_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  ADD CONSTRAINT `incidencia_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`idPrioridad`) REFERENCES `prioridad` (`idPrioridad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`idEstado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_4` FOREIGN KEY (`idIncidencia`) REFERENCES `incidencia` (`idIncidencia`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
