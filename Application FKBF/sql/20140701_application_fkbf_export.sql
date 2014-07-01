-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost:3307
-- Generation Time: Jul 01, 2014 at 04:43 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `application_fkbf`
--

-- --------------------------------------------------------

--
-- Table structure for table `classement`
--

DROP TABLE IF EXISTS `classement`;
CREATE TABLE IF NOT EXISTS `classement` (
  `id_classement` int(11) NOT NULL AUTO_INCREMENT,
  `division` varchar(10) DEFAULT NULL,
  `sexe` varchar(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `id_equipe` int(10) DEFAULT NULL,
  `html` longtext,
  PRIMARY KEY (`id_classement`),
  KEY `id_equipe` (`id_equipe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `classement`
--

INSERT INTO `classement` (`id_classement`, `division`, `sexe`, `date`, `id_equipe`, `html`) VALUES
(1, 'D1M1', 'F', '2014-07-01', NULL, '<table class="tableau_classement_poule" cellspacing="0">\r\n	<tr class="premiere_ligne">\r\n		<td colspan="11"></td>\r\n	</tr>\r\n	<tr class="premiere_ligne">\r\n		<td colspan="3">Classement</td>\r\n		<td>Points</td>\r\n		<td>MJ</td>\r\n		<td>Premire place</td>\r\n		<td>Deuxime place</td>\r\n		<td>Troisime place</td>\r\n		<td>Forfait</td>\r\n		<td>Nb priodes</td>\r\n		<td>Esprit sportif</td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang"></td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang"></td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang"></td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang"></td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n</table>\r\n'),
(2, '', 'F', '2014-07-16', NULL, '<table class="tableau_classement_poule" cellspacing="0">\r\n	<tr class="premiere_ligne">\r\n		<td colspan="11"></td>\r\n	</tr>\r\n	<tr class="premiere_ligne">\r\n		<td colspan="3">Classement</td>\r\n		<td>Points</td>\r\n		<td>MJ</td>\r\n		<td>Premire place</td>\r\n		<td>Deuxime place</td>\r\n		<td>Troisime place</td>\r\n		<td>Forfait</td>\r\n		<td>Nb priodes</td>\r\n		<td>Esprit sportif</td>\r\n	</tr>\r\n</table>\r\n'),
(3, '', 'F', '2014-07-16', NULL, '<table class="tableau_classement_poule" cellspacing="0">\r\n	<tr class="premiere_ligne">\r\n		<td colspan="11"></td>\r\n	</tr>\r\n	<tr class="premiere_ligne">\r\n		<td colspan="3">Classement</td>\r\n		<td>Points</td>\r\n		<td>MJ</td>\r\n		<td>Premire place</td>\r\n		<td>Deuxime place</td>\r\n		<td>Troisime place</td>\r\n		<td>Forfait</td>\r\n		<td>Nb priodes</td>\r\n		<td>Esprit sportif</td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang">1</td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang">2</td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang">3</td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang">4</td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n</table>\r\n'),
(4, 'D1', 'F', '2014-07-01', NULL, '<table class="tableau_classement_poule" cellspacing="0">\r\n	<tr class="premiere_ligne">\r\n		<td colspan="11">D1</td>\r\n	</tr>\r\n	<tr class="premiere_ligne">\r\n		<td colspan="3">Classement</td>\r\n		<td>Points</td>\r\n		<td>MJ</td>\r\n		<td>Premire place</td>\r\n		<td>Deuxime place</td>\r\n		<td>Troisime place</td>\r\n		<td>Forfait</td>\r\n		<td>Nb priodes</td>\r\n		<td>Esprit sportif</td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang">1</td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang">2</td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n	<tr>\r\n		<td class="rang">3</td>\r\n		<td class="drapeau"><img src="http://www.kin-ball.fr/images/clubs/logo__mini.png" border="0"/></td>\r\n		<td class="equipe"></td>\r\n		<td class="points"></td>\r\n		<td class="mj"></td>\r\n		<td class="1erep"></td>\r\n		<td class="2emep"></td>\r\n		<td class="3emep"></td>\r\n		<td class="forfait"></td>\r\n		<td class="periodes"></td>\r\n		<td class="fairplay"></td>\r\n	</tr>\r\n</table>\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `classement_equipe`
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
  `id_classement` int(11) DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_equipe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=61 ;

--
-- Dumping data for table `classement_equipe`
--

INSERT INTO `classement_equipe` (`id_equipe`, `rang`, `logo`, `nom_equipe`, `points`, `match_joue`, `premiere_place`, `deuxieme_place`, `troisieme_place`, `forfait`, `nb_periode`, `esprit_sportif`, `id_classement`, `idx`) VALUES
(50, '', '', '', '', '', '', '', '', '', '', '', 1, 0),
(51, '', '', '', '', '', '', '', '', '', '', '', 1, 1),
(52, '', '', '', '', '', '', '', '', '', '', '', 1, 2),
(53, '', '', '', '', '', '', '', '', '', '', '', 1, 3),
(54, '1', '', '', '', '', '', '', '', '', '', '', 3, 0),
(55, '2', '', '', '', '', '', '', '', '', '', '', 3, 1),
(56, '3', '', '', '', '', '', '', '', '', '', '', 3, 2),
(57, '4', '', '', '', '', '', '', '', '', '', '', 3, 3),
(58, '1', 'kbar', 'Rennes 1', '', '1', '', '', '', '', '', '', 4, 0),
(59, '2', 'nakc', '', '', '', '', '', '', '', '', '', 4, 1);

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
  KEY `bleu` (`bleu`),
  KEY `gris` (`gris`),
  KEY `noir` (`noir`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `match`
--

INSERT INTO `match` (`id`, `id_match`, `bleu`, `gris`, `noir`, `arbitre_chef`, `arbitre_adjoint`, `html`) VALUES
(1, 'D1M1', 1, 2, 3, '', '', '<input id="buttonMatchD1M1" src=" http://www.kin-ball.fr/images/plus.jpg" type="image" onclick="toggleVisibility(''MatchD1M1'');">\r\n<div id="MatchD1M1Plus" style="visibility: visible; display: block;">\r\nDtail du match<br><br>\r\n<table class="tableau_match" cellspacing="0">\r\n<tbody><tr>\r\n<td class="premiere_colonne">Match #D1M1</td>\r\n<td colspan="7" class="bleu"></td>\r\n<td colspan="7" class="gris"></td>\r\n<td colspan="7" class="noir"></td>\r\n</tr>\r\n<tr>\r\n<td class="premiere_colonne">Priodes gagnes</td>\r\n<td colspan="7"></td>\r\n<td colspan="7"></td>\r\n<td colspan="7"></td>\r\n</tr>\r\n</tbody></table>\r\n</div>\r\n<div id="MatchD1M1Moins" style="display: none;">\r\nRduire le dtail du match\r\n<br><br>\r\n<table class="tableau_match" cellspacing="0">\r\n<tbody><tr>\r\n<td class="premiere_colonne"> Match #D1M1</td>\r\n<td colspan="7" class="bleu"></td>\r\n<td colspan="7" class="gris"></td>\r\n<td colspan="7" class="noir"></td>\r\n</tr> \r\n<tr> \r\n<td class="premiere_colonne">Priode</td>\r\n<td>1</td>\r\n<td>2</td>\r\n<td>3</td>\r\n<td>4</td>\r\n<td>5</td>\r\n<td>6</td>\r\n<td>7</td>\r\n<td>1</td>\r\n<td>2</td>\r\n<td>3</td>\r\n<td>4</td>\r\n<td>5</td>\r\n<td>6</td>\r\n<td>7</td>\r\n<td>1</td>\r\n<td>2</td>\r\n<td>3</td>\r\n<td>4</td>\r\n<td>5</td>\r\n<td>6</td>\r\n<td>7</td>\r\n</tr>\r\n<tr>\r\n<td class="premiere_colonne">Pointage</td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n</tr>\r\n<tr>\r\n<td class="premiere_colonne">Prolongation 1</td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n<td></td>\r\n</tr>\r\n<tr>\r\n<td class="premiere_colonne">Priodes gagnes</td>\r\n<td colspan="7"></td>\r\n<td colspan="7"></td>\r\n<td colspan="7"></td>\r\n</tr>\r\n<tr>\r\n<td class="premiere_colonne">Prolongation 2me position</td>\r\n<td colspan="7"></td>\r\n<td colspan="7"></td>\r\n<td colspan="7"></td>\r\n</tr>\r\n<tr>\r\n<td class="premiere_colonne">Esprit sportif</td>\r\n<td colspan="7">5</td>\r\n<td colspan="7">5</td>\r\n<td colspan="7">5</td>\r\n</tr>\r\n<tr>\r\n<td class="premiere_colonne">Points championnats</td>\r\n<td colspan="7"></td>\r\n<td colspan="7"></td>\r\n<td colspan="7"></td>\r\n </tr>\r\n</tbody>\r\n</table>\r\n<strong>Arbitres</strong> :  & \r\n</div>\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `match_equipe`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `match_equipe`
--

INSERT INTO `match_equipe` (`id_equipe`, `color`, `nom_equipe`, `isForfait`, `p1`, `p2`, `p3`, `p4`, `p5`, `p6`, `p7`, `prol1`, `prol2`, `prol3`, `prol4`, `prol5`, `prol6`, `prol7`, `prol_deuxieme`, `nb_periode`, `esprit_sportif`, `points`) VALUES
(1, 'bleu', '', 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '5', ''),
(2, 'gris', '', 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '5', ''),
(3, 'noir', '', 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '5', '');

-- --------------------------------------------------------

--
-- Table structure for table `parametres`
--

DROP TABLE IF EXISTS `parametres`;
CREATE TABLE IF NOT EXISTS `parametres` (
  `id_parametres` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  `value` varchar(100) NOT NULL,
  PRIMARY KEY (`id_parametres`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `parametres`
--

INSERT INTO `parametres` (`id_parametres`, `libelle`, `value`) VALUES
(1, '', 'D1,D2,D3,D4,D5'),
(2, 'divisions', 'D1,D2,D3,D4,D5');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classement`
--
ALTER TABLE `classement`
  ADD CONSTRAINT `classement_ibfk_1` FOREIGN KEY (`id_equipe`) REFERENCES `classement_equipe` (`id_equipe`);

--
-- Constraints for table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `match_ibfk_1` FOREIGN KEY (`bleu`) REFERENCES `match_equipe` (`id_equipe`),
  ADD CONSTRAINT `match_ibfk_2` FOREIGN KEY (`gris`) REFERENCES `match_equipe` (`id_equipe`),
  ADD CONSTRAINT `match_ibfk_3` FOREIGN KEY (`noir`) REFERENCES `match_equipe` (`id_equipe`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
