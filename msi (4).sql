-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 29 mai 2022 à 02:33
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `msi`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `id_administrateur` int(11) NOT NULL,
  `identifiant` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `id_chambre` int(11) NOT NULL,
  `nomchambre` varchar(20) NOT NULL,
  `maxplace` int(20) NOT NULL,
  `id_pavillon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`id_chambre`, `nomchambre`, `maxplace`, `id_pavillon`) VALUES
(3, '34G', 6, 5),
(4, '43G', 6, 5),
(5, '3A', 3, 1),
(6, '14B', 4, 2),
(7, '66C', 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id_etudiant` int(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `departement` varchar(20) NOT NULL,
  `niveau` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `numcarte` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id_etudiant`, `nom`, `prenom`, `departement`, `niveau`, `email`, `numcarte`) VALUES
(1, 'Dia', 'Arona', 'DGI', 'DUT2', 'rone@esp.sn', '201903y6k'),
(2, 'Nguirane', 'Babacar', 'DGI', 'DUT2', 'babacar@esp.sn', '201505o8p'),
(3, 'Aliou', 'Thiam', 'INFORMATIQUE', 'DUT2', 'mail', 'numcarte'),
(4, 'NIANG', 'GALLO', 'INFORMATIQUE', 'DUT2', 'galloniang@esp.sn', '2019G3M'),
(5, 'Nguirane', 'Babacar', 'DGI', 'DUT2', 'babacar@esp.sn', '2019C5M'),
(6, 'fall', 'modou', 'DGI', 'DUT2', 'modou@esp.sn', '2019E5M');

-- --------------------------------------------------------

--
-- Structure de la table `pavillon`
--

CREATE TABLE `pavillon` (
  `id_pavillon` int(11) NOT NULL,
  `nompavillon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pavillon`
--

INSERT INTO `pavillon` (`id_pavillon`, `nompavillon`) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'F'),
(5, 'G'),
(6, 'H');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` int(11) NOT NULL,
  `id_chambre` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `datereservation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `id_chambre`, `id_etudiant`, `datereservation`) VALUES
(1, 7, 1, '2021-05-18'),
(2, 7, 2, '2021-05-18'),
(4, 3, 4, '2021-05-18'),
(8, 6, 3, '2021-07-02');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id_administrateur`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`id_chambre`),
  ADD KEY `id_pavillon` (`id_pavillon`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id_etudiant`);

--
-- Index pour la table `pavillon`
--
ALTER TABLE `pavillon`
  ADD PRIMARY KEY (`id_pavillon`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `fk_idchambre` (`id_chambre`),
  ADD KEY `fk_idetudiant` (`id_etudiant`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `id_administrateur` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `id_chambre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id_etudiant` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `pavillon`
--
ALTER TABLE `pavillon`
  MODIFY `id_pavillon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id_reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `chambre_ibfk_1` FOREIGN KEY (`id_pavillon`) REFERENCES `pavillon` (`id_pavillon`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_idchambre` FOREIGN KEY (`id_chambre`) REFERENCES `chambre` (`id_chambre`),
  ADD CONSTRAINT `fk_idetudiant` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
