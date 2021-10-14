-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 30 sep. 2021 à 13:11
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projetwebpool`
--

-- --------------------------------------------------------

--
-- Structure de la table `advertissement`
--

DROP TABLE IF EXISTS `advertissement`;
CREATE TABLE IF NOT EXISTS `advertissement` (
  `id_adv` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `mail` varchar(40) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id_adv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `advertissement`
--

INSERT INTO `advertissement` (`id_adv`, `name`, `mail`, `phone`, `description`) VALUES
(1, 'adv1', 'blabla@blabla.com', '01-23-12', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée.'),
(2, 'adv2', 'blobloblo@lo.com', '12223', 'Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu\'il est prêt ou que la mise en page est achevée.');

-- --------------------------------------------------------

--
-- Structure de la table `companies`
--

DROP TABLE IF EXISTS `companies`;
CREATE TABLE IF NOT EXISTS `companies` (
  `id_comp` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `mail` varchar(40) NOT NULL,
  PRIMARY KEY (`id_comp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `info`
--

DROP TABLE IF EXISTS `info`;
CREATE TABLE IF NOT EXISTS `info` (
  `id_comp` int(11) NOT NULL,
  `id_people` int(11) NOT NULL,
  `mail_sent` text NOT NULL,
  KEY `id_comp` (`id_comp`),
  KEY `id_people` (`id_people`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `people`
--

DROP TABLE IF EXISTS `people`;
CREATE TABLE IF NOT EXISTS `people` (
  `id_people` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `surname` varchar(25) NOT NULL,
  `email` text NOT NULL,
  `phone` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id_people`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `people`
--

INSERT INTO `people` (`id_people`, `name`, `surname`, `email`, `phone`, `status`, `password`) VALUES
(1, '', '', '', '', '', 'ppapaa'),
(2, 'toto', 'rico', ':email', '12233', 'cand', ':password'),
(3, 'toto', 'rico', ':email', '12233', 'cand', ':password'),
(4, 'toto', 'rico', 'karim.louail@epitech.eu', '12233', 'cand', 'sqfsq'),
(5, 'toto', 'rico', 'karim.louail@epitech.euk,', '12233', 'cand', 'sdffsd');

-- --------------------------------------------------------

--
-- Structure de la table `relpeopleadvert`
--

DROP TABLE IF EXISTS `relpeopleadvert`;
CREATE TABLE IF NOT EXISTS `relpeopleadvert` (
  `id_people` int(11) NOT NULL,
  `id_adv` int(11) NOT NULL,
  `mail_sent` text NOT NULL,
  KEY `id_adv` (`id_adv`),
  KEY `id_people` (`id_people`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `relpublisheradvert`
--

DROP TABLE IF EXISTS `relpublisheradvert`;
CREATE TABLE IF NOT EXISTS `relpublisheradvert` (
  `id_people` int(11) NOT NULL,
  `id_adv` int(11) NOT NULL,
  KEY `id_adv` (`id_adv`),
  KEY `id_people` (`id_people`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `info`
--
ALTER TABLE `info`
  ADD CONSTRAINT `info_ibfk_1` FOREIGN KEY (`id_comp`) REFERENCES `companies` (`id_comp`),
  ADD CONSTRAINT `info_ibfk_2` FOREIGN KEY (`id_people`) REFERENCES `people` (`id_people`);

--
-- Contraintes pour la table `relpeopleadvert`
--
ALTER TABLE `relpeopleadvert`
  ADD CONSTRAINT `relpeopleadvert_ibfk_1` FOREIGN KEY (`id_adv`) REFERENCES `advertissement` (`id_adv`),
  ADD CONSTRAINT `relpeopleadvert_ibfk_2` FOREIGN KEY (`id_people`) REFERENCES `people` (`id_people`);

--
-- Contraintes pour la table `relpublisheradvert`
--
ALTER TABLE `relpublisheradvert`
  ADD CONSTRAINT `relpublisheradvert_ibfk_1` FOREIGN KEY (`id_adv`) REFERENCES `advertissement` (`id_adv`),
  ADD CONSTRAINT `relpublisheradvert_ibfk_2` FOREIGN KEY (`id_people`) REFERENCES `people` (`id_people`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
