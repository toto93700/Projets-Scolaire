-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 20 mai 2021 à 21:12
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
-- Base de données : `projetinfo`
--

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `IDfilm` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` varchar(40) NOT NULL,
  `Realisateur` varchar(40) NOT NULL,
  `ISO` varchar(20) NOT NULL,
  `Annee` int(11) NOT NULL,
  `Duree` int(11) NOT NULL,
  `img` text NOT NULL,
  PRIMARY KEY (`IDfilm`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`IDfilm`, `Titre`, `Realisateur`, `ISO`, `Annee`, `Duree`, `img`) VALUES
(1, 'Interstellar', 'Christopher Nolan', 'us', 2014, 169, 'https://i.pinimg.com/originals/11/1c/5c/111c5c9ad99661af2d80e38948cf29d8.jpg'),
(2, 'Fantomas', 'André Hunebelle', 'fr', 1964, 127, 'https://i.pinimg.com/564x/f5/9f/4d/f59f4d35ae19acbd411664ec6653067b.jpg'),
(4, 'Survivor', 'James McTeigue', 'us', 2006, 133, 'https://aws1.vdkimg.com/film/1/2/9/5/1295411_poster_scale_480x640.jpg'),
(5, 'Tokyo Drift', 'Justin Lin', 'us', 2006, 105, 'https://img6.cdn.cinoche.com/images/dd8a450d2c39302a94fdb7284a476da3.jpg'),
(6, 'Oldboy', 'Park Chan-wook', 'kor', 2004, 120, 'https://fr.web.img5.acsta.net/medias/nmedia/18/35/24/25/18383433.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `individu`
--

DROP TABLE IF EXISTS `individu`;
CREATE TABLE IF NOT EXISTS `individu` (
  `Nom` varchar(40) NOT NULL,
  `Prenom` varchar(40) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FilmJouer` text,
  `img` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `individu`
--

INSERT INTO `individu` (`Nom`, `Prenom`, `ID`, `FilmJouer`, `img`) VALUES
('Jean', 'Girault', 1, NULL, 'https://lh3.googleusercontent.com/proxy/lm5lRhpGC8g48VVM5pc1ehqNk_ElefGXXnLNEDdTVxrjt5ni5GRdUc8fPK9T4qi5MSXYltbJviuZCnlOOJjo-w64FvRrocGIWK8'),
('McTeigue', 'James', 3, NULL, 'https://media.elcinema.com/uploads/_315x420_e75eb03009d0abb66fd5ec0c334e1883fd13f22ad26c24fbae4bd4823d8e3afa.jpg'),
('Justin', 'Lin', 4, NULL, 'https://fr.web.img2.acsta.net/pictures/16/07/15/11/35/471844.jpg'),
('Nolan', 'Christopher', 5, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Christopher_Nolan%2C_London%2C_2013_%28crop%29.jpg/409px-Christopher_Nolan%2C_London%2C_2013_%28crop%29.jpg'),
('Chan-wook', 'Park', 6, NULL, 'https://www.lesinrocks.com/wp-content/uploads/2021/04/000_1A06YP.jpg?resize=850%2C540&quality=75'),
('De funes', 'Louis', 7, 'Le gendarme en balade,Le corniaud,La Soupe Aux Choux', 'https://gal.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fgal.2F2020.2F05.2F23.2Fd48dfb77-4ed0-4f2c-8465-13ac88094459.2Ejpeg/480x480/crop-from/top/focus-point/953%2C1251/louis-de-funes-cette-chanteuse-belge-a-appris-le-francais-grace-a-ses-comedies.jpg'),
('Walker', 'Paul', 8, 'Fast and furious,Tokyo Drift', 'https://pyxis.nymag.com/v1/imgs/b67/f31/98741d18a63243cda3123ee178d1f44292-11-paul-walker.rsquare.w330.jpg'),
('Portman', 'Natalie', 9, 'V pour Vendetta,Thor', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Natalie_Portman_Cannes_2015_5_%28cropped%29.jpg/220px-Natalie_Portman_Cannes_2015_5_%28cropped%29.jpg'),
('McConaughey', 'Matthew', 10, 'Interstellar', 'https://cdn.britannica.com/40/174140-050-0DDBED29/Matthew-McConaughey-2012.jpg'),
('Sun', 'Kang', 11, 'Tokyo Drift', 'https://mediamass.net/jdd/public/documents/celebrities/3930.jpg'),
('Steve', 'Kramer', 12, 'Oldboy', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRj8tfE70OVeEmeLJLrpQXmIz0Yryy5aQX4nJdAd-f5vl3SSSQb');

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `ID_compte` int(11) NOT NULL AUTO_INCREMENT,
  `ndc` varchar(30) NOT NULL,
  `mdp` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_compte`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `membre`
--

INSERT INTO `membre` (`ID_compte`, `ndc`, `mdp`) VALUES
(27, 'pero', '1'),
(28, 'mano77', 'sdsd'),
(29, 'brakoo93', '1111'),
(30, 'bjjemin', '222'),
(31, 'zzerty', '2'),
(32, 'pakou', '3'),
(33, 'pajka', '33'),
(34, 'rico', '555'),
(35, 'salut', 'salut');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `msgtxt` text NOT NULL,
  `IDmsg` int(11) NOT NULL AUTO_INCREMENT,
  `date_creation` date NOT NULL,
  `IDowner` int(11) NOT NULL,
  `IDtopic` int(11) NOT NULL,
  PRIMARY KEY (`IDmsg`),
  KEY `IDowner` (`IDowner`),
  KEY `IDtopic` (`IDtopic`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`msgtxt`, `IDmsg`, `date_creation`, `IDowner`, `IDtopic`) VALUES
('Aucun film de Christopher Nolan ne m\'a jusqu\'ici déçu, pourtant, j’appréhendais cet Interstellar ! Le fait de revoir Memento et Inception récemment m\'on décidé à me lancé dans ce périple, bien m\'en a pris. Aucun temps morts, les palpitations s\'accroissent de minute en minute et atteignent leurs maximum dans cette dernière demi-heure tout en surprise et rebondissement. Ce film est une claque, à tout point de vue, j\'ai été séduis de A à Z ... Aucunement utile de poursuivre cet critique, laissé passer la pilule, attendre et le revoir dans les années à venir !', 1, '2021-04-01', 27, 11),
('Les effets spéciaux sont parfaits, ce n\'est pas pour rien que le film a reçu un Oscar pour les meilleurs effets visuels. Les compositions Hans Zimmer sont un chef d\'oeuvre à elles toutes seules, c\'est vraie qu\'il se répétait ces derniers temps, mais là, il s\'est plus que renouvelé, non seulement elles accompagnent parfaitement le film, mais en plus elles font monter la tension rendant certaines scènes de cette odyssée stressantes. En conclusion, \" Interstellar \" est à mes yeux l\'oeuvre la plus aboutie de Christopher Nolan, ce n\'est peut être pas son meilleur film, mais c\'est sans aucun doute celui que je préfère. L\'hommage rendu à \" 2001 : l\'Odyssée de l\'Espace \" rend ce film culte, et fait de lui l\'un de mes SF préférés et surtout l\'un de mes films préférés. Un chef d\'oeuvre à mes yeux', 2, '2021-05-10', 32, 11),
('LE film de Christopher Nolan, celui qu\'il faut voir avant tous les autres. Et cette chance que j\'ai eu de le voir en avant-première m\'a également et surtout permis de vous offrir mon avis, et de vous le conseiller au plus haut point. Par où pourrais-je commencer? Je ne sais trop quoi dire, ce film est trop intense, trop beau, trop inimaginablement recherché pour que je puisse en parler comme il se devrait. C\'est exactement le même problème avec la trilogie du \"Seigneur des Anneaux\" : ce sont des films qui dépassent le cadre de films. Et pour cela, je peux donc le certifier, Christopher Nolan, au même titre que Peter Jackson à ses débuts, est un magicien du sptième art, quelqu\'un qui fait que le cinéma est encore un art,', 3, '2021-05-09', 30, 11),
('1111', 4, '2021-05-12', 27, 12),
('111', 5, '2021-05-12', 27, 12),
('blablaz azeazeaze', 6, '2021-05-12', 27, 12),
('<?php\r\n$erreur=3+3;\r\n?>\r\n<?=$erreur ?>', 7, '2021-05-12', 27, 12),
('wssqsq', 8, '2021-05-12', 27, 12),
('<?php\r\nqsq\r\n?>', 9, '2021-05-12', 27, 12),
(',nnfgnf', 15, '2021-05-12', 27, 11),
('fghfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfg', 16, '2021-05-12', 27, 11),
('m de Christopher Nolan, celui qu\'il faut voir avant tous les autres. Et cette chance que j\'ai eu de le voir en avant-première m\'a également et surtout permis de vous offrir mon avis, et de vous le conseiller au plus haut point. Par où pourrais-je commencer? Je ne sais trop quoi dire, ce film est trop intense, trop beau, trop inimaginablement recherché pour que je puisse en parler comme il se devrait. C\'est exactement le même problème avec la trilogie du \"Seigneur des Anneaux\" : ce sont des films qui dépassent le cadre de ', 17, '2021-05-12', 27, 11),
('m de Christopher Nolan, celui qu\'il faut voir avant tous les autres. Et cette chance que j\'ai eu de le voir en avant-première m\'a également et surtout permis de vous offrir mon avis, et de vous le conseiller au plus haut point. Par où pourrais-je commencer? Je ne sais trop quoi dire, ce film est trop intense, trop beau, trop inimaginablement recherché pour que je puisse en parler comme il se devrait. C\'est exactement le même problème avec la trilogie du \"Seigneur des Anneaux\" : ce sont des films qui dépassent le cadre de ', 18, '2021-05-12', 27, 11),
('m de Christopher Nolan, celui qu\'il faut voir avant tous les autres. Et cette chance que j\'ai eu de le voir en avant-première m\'a également et surtout permis de vous offrir mon avis, et de vous le conseiller au plus haut point. Par où pourrais-je commencer? Je ne sais trop quoi dire, ce film est trop intense, trop beau, trop inimaginablement recherché pour que je puisse en parler comme il se devrait. C\'est exactement le même problème avec la trilogie du \"Seigneur des Anneaux\" : ce sont des films qui dépassent le cadre de ', 19, '2021-05-12', 27, 11),
('m de Christopher Nolan, celui qu\'il faut voir avant tous les autres. Et cette chance que j\'ai eu de le voir en avant-première m\'a également et surtout permis de vous offrir mon avis, et de vous le conseiller au plus haut point. Par où pourrais-je commencer? Je ne sais trop quoi dire, ce film est trop intense, trop beau, trop inimaginablement recherché pour que je puisse en parler comme il se devrait. C\'est exactement le même problème avec la trilogie du \"Seigneur des Anneaux\" : ce sont des films qui dépassent le cadre de ', 20, '2021-05-12', 27, 11),
('jhgjghj', 21, '2021-05-12', 27, 13),
('jghjgh', 22, '2021-05-12', 27, 13),
('hgjghjfffffffffffffffff', 23, '2021-05-12', 27, 13),
('<div>', 25, '2021-05-12', 27, 11),
('<php\r\n$q=$db->query(\"DELETE  FROM  note_film WHERE  note=10\");\r\n ?>', 26, '2021-05-12', 27, 11),
('bjrf', 27, '2021-05-20', 34, 12),
('5434', 28, '2021-05-20', 34, 12),
('23\r\n2', 29, '2021-05-20', 34, 12);

-- --------------------------------------------------------

--
-- Structure de la table `note_film`
--

DROP TABLE IF EXISTS `note_film`;
CREATE TABLE IF NOT EXISTS `note_film` (
  `IDfilm` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `IDcompte` int(11) NOT NULL,
  KEY `note_film_ibfk_1` (`IDfilm`),
  KEY `IDcompte` (`IDcompte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `note_film`
--

INSERT INTO `note_film` (`IDfilm`, `note`, `IDcompte`) VALUES
(1, 1, 31),
(2, 5, 27),
(1, 1, 32),
(1, 4, 27),
(1, 10, 29),
(1, 3, 34),
(4, 5, 34),
(6, 3, 35);

-- --------------------------------------------------------

--
-- Structure de la table `topic`
--

DROP TABLE IF EXISTS `topic`;
CREATE TABLE IF NOT EXISTS `topic` (
  `IDtopic` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(60) NOT NULL,
  `date_creation` date NOT NULL,
  PRIMARY KEY (`IDtopic`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `topic`
--

INSERT INTO `topic` (`IDtopic`, `titre`, `date_creation`) VALUES
(11, 'forum du film : interstellar', '2021-04-17'),
(12, 'forum du film : Oldboy', '2021-04-13'),
(13, 'forum du film : Tokyo Drift', '2021-04-23'),
(14, 'forum du film : V pour Vandetta', '2021-04-20');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`IDowner`) REFERENCES `membre` (`ID_compte`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`IDtopic`) REFERENCES `topic` (`IDtopic`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `note_film`
--
ALTER TABLE `note_film`
  ADD CONSTRAINT `note_film_ibfk_1` FOREIGN KEY (`IDfilm`) REFERENCES `film` (`IDfilm`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `note_film_ibfk_2` FOREIGN KEY (`IDcompte`) REFERENCES `membre` (`ID_compte`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
