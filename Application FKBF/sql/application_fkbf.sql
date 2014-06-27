-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 26, 2014 at 09:08 PM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

DROP DATABASE IF EXISTS `application_fkbf`;

CREATE DATABASE IF NOT EXISTS `application_fkbf`
--
-- Database: `application_fkbf`
--

DROP TABLE IF EXISTS `classement_equipe`;
CREATE TABLE IF NOT EXISTS `classement_equipe` (
  `id_equipe` int(11) NOT NULL AUTO_INCREMENT,
  `rang` varchar(11) DEFAULT NULL,
  `logo` varchar(10) DEFAULT NULL,
  `nom_equipe` varchar(50) DEFAULT NULL,
  `points` varchar(11) DEFAULT NULL,
  `match_joue` varchar(11) DEFAULT NULL,
  `premiere_place` varchar(11) DEFAULT NULL,
  `deuxieme_place` varchar(11) DEFAULT NULL,
  `troisieme_place` varchar(11) DEFAULT NULL,
  `forfait` varchar(11) DEFAULT NULL,
  `nb_periode` varchar(11) DEFAULT NULL,
  `esprit_sportif` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_equipe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `classement`;
CREATE TABLE IF NOT EXISTS `classement` (
  `id_classement` int(11) NOT NULL AUTO_INCREMENT,
  `division` varchar(10) DEFAULT NULL,
  `sexe` varchar(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `id_equipe` int(10) DEFAULT NULL,
  `html` longtext,
  PRIMARY KEY (`id_classement`),
  FOREIGN KEY (id_equipe)  REFERENCES classement_equipe(id_equipe)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `match_equipe`;
CREATE TABLE IF NOT EXISTS `match_equipe` (
  `id_equipe` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(10) DEFAULT NULL,
  `nom_equipe` varchar(50) DEFAULT NULL,
  `isForfait` tinyint(1) DEFAULT NULL,
  `p1` varchar(11) DEFAULT NULL,
  `p2` varchar(11) DEFAULT NULL,
  `p3` varchar(11) DEFAULT NULL,
  `p4` varchar(11) DEFAULT NULL,
  `p5` varchar(11) DEFAULT NULL,
  `p6` varchar(11) DEFAULT NULL,
  `p7` varchar(11) DEFAULT NULL,
  `prol1` varchar(11) DEFAULT NULL,
  `prol2` varchar(11) DEFAULT NULL,
  `prol3` varchar(11) DEFAULT NULL,
  `prol4` varchar(11) DEFAULT NULL,
  `prol5` varchar(11) DEFAULT NULL,
  `prol6` varchar(11) DEFAULT NULL,
  `prol7` varchar(11) DEFAULT NULL,
  `prol_deuxieme` varchar(11) DEFAULT NULL,
  `nb_periode` varchar(11) DEFAULT NULL,
  `esprit_sportif` varchar(11) DEFAULT NULL,
  `points` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_equipe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

-- --------------------------------------------------------

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
CREATE TABLE IF NOT EXISTS `match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_match` varchar(11) DEFAULT NULL,
  `bleu` int(11) DEFAULT NULL,
  `gris` int(11) DEFAULT NULL,
  `noir` int(11) DEFAULT NULL,
  `arbitre_chef` varchar(50) DEFAULT NULL,
  `arbitre_adjoint` varchar(50) DEFAULT NULL,
   `html` longtext,
  PRIMARY KEY (`id`),
  FOREIGN KEY (bleu)  REFERENCES match_equipe(id_equipe),
  FOREIGN KEY (gris)  REFERENCES match_equipe(id_equipe),
  FOREIGN KEY (noir)  REFERENCES match_equipe(id_equipe)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1  ;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
