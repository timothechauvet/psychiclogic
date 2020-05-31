-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  Dim 31 mai 2020 à 08:59
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `psychiclogic`
--

-- --------------------------------------------------------

--
-- Structure de la table `comportement`
--

DROP TABLE IF EXISTS `comportement`;
CREATE TABLE IF NOT EXISTS `comportement` (
  `PK_Comportement` int(11) NOT NULL AUTO_INCREMENT,
  `FK_RDV` int(11) NOT NULL,
  `comportement` varchar(32) NOT NULL,
  PRIMARY KEY (`PK_Comportement`),
  KEY `FK_RDV` (`FK_RDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

DROP TABLE IF EXISTS `notes`;
CREATE TABLE IF NOT EXISTS `notes` (
  `PK_Notes` int(11) NOT NULL AUTO_INCREMENT,
  `FK_RDV` int(11) NOT NULL,
  `mot_clef` varchar(32) NOT NULL,
  PRIMARY KEY (`PK_Notes`),
  KEY `FK_RDV` (`FK_RDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `PK_Participation` int(11) NOT NULL AUTO_INCREMENT,
  `FK_Patient` int(11) NOT NULL,
  `FK_RDV` int(11) NOT NULL,
  `noteAnxieté` tinyint(4) NOT NULL,
  PRIMARY KEY (`PK_Participation`),
  KEY `FK_RDV` (`FK_RDV`),
  KEY `FK_Patient` (`FK_Patient`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`PK_Participation`, `FK_Patient`, `FK_RDV`, `noteAnxieté`) VALUES
(1, 1, 1, 0),
(2, 4, 1, 0),
(3, 6, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `PK_Patient` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `prénom` varchar(25) NOT NULL,
  `2prénom` varchar(25) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `adresse` tinytext NOT NULL,
  `DNaissance` date NOT NULL,
  `moyenRencontre` tinytext NOT NULL,
  PRIMARY KEY (`PK_Patient`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`PK_Patient`, `mail`, `password`, `prénom`, `2prénom`, `nom`, `adresse`, `DNaissance`, `moyenRencontre`) VALUES
(1, 'b.b@mail.com', 'oui', 'Billy', '', 'McGregor', '1 allée de la peine', '2003-02-01', 'Une brochure'),
(4, 'gr@gmail.com', 'mdp', 'Gregoire', 'Greg', 'Roy', 'Rue de la Fame', '2006-06-06', 'internet'),
(6, 'Jesus', 'Christ', 'js@hotmail.fr', 'God', 'Christ', 'heaven', '0000-01-01', 'Bible'),
(8, 'EVil@gmail.com', '666', 'Elen', '', 'Vilaine', 'HAAAAAAAAA', '2000-12-24', 'Elle sait TOUT !');

-- --------------------------------------------------------

--
-- Structure de la table `posture`
--

DROP TABLE IF EXISTS `posture`;
CREATE TABLE IF NOT EXISTS `posture` (
  `PK_Posture` int(11) NOT NULL AUTO_INCREMENT,
  `FK_RDV` int(11) NOT NULL,
  `posture` varchar(32) NOT NULL,
  PRIMARY KEY (`PK_Posture`),
  KEY `FK_RDV` (`FK_RDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `profession`
--

DROP TABLE IF EXISTS `profession`;
CREATE TABLE IF NOT EXISTS `profession` (
  `PK_Profession` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`PK_Profession`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `profession`
--

INSERT INTO `profession` (`PK_Profession`, `NAME`) VALUES
(1, 'Secrétaire');

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `PK_RDV` int(11) NOT NULL AUTO_INCREMENT,
  `SDate` timestamp NOT NULL,
  `montant` double NOT NULL,
  `moyenPayment` varchar(20) NOT NULL,
  PRIMARY KEY (`PK_RDV`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`PK_RDV`, `SDate`, `montant`, `moyenPayment`) VALUES
(1, '2000-12-31 23:00:00', 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `travaille`
--

DROP TABLE IF EXISTS `travaille`;
CREATE TABLE IF NOT EXISTS `travaille` (
  `PK_Travaille` int(11) NOT NULL AUTO_INCREMENT,
  `FK_Patient` int(11) NOT NULL,
  `FK_Profession` int(11) NOT NULL,
  `SDate` date NOT NULL,
  `EDate` date NOT NULL,
  PRIMARY KEY (`PK_Travaille`),
  KEY `FK_Patient` (`FK_Patient`),
  KEY `FK_Profession` (`FK_Profession`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `travaille`
--

INSERT INTO `travaille` (`PK_Travaille`, `FK_Patient`, `FK_Profession`, `SDate`, `EDate`) VALUES
(1, 1, 1, '2001-02-03', '2003-02-01');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `comportement`
--
ALTER TABLE `comportement`
  ADD CONSTRAINT `comportement_ibfk_1` FOREIGN KEY (`FK_RDV`) REFERENCES `rdv` (`PK_RDV`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `notes_ibfk_1` FOREIGN KEY (`FK_RDV`) REFERENCES `rdv` (`PK_RDV`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`FK_RDV`) REFERENCES `rdv` (`PK_RDV`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`FK_Patient`) REFERENCES `patient` (`PK_Patient`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `posture`
--
ALTER TABLE `posture`
  ADD CONSTRAINT `posture_ibfk_1` FOREIGN KEY (`FK_RDV`) REFERENCES `rdv` (`PK_RDV`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `travaille`
--
ALTER TABLE `travaille`
  ADD CONSTRAINT `travaille_ibfk_1` FOREIGN KEY (`FK_Patient`) REFERENCES `patient` (`PK_Patient`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `travaille_ibfk_2` FOREIGN KEY (`FK_Profession`) REFERENCES `profession` (`PK_Profession`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
