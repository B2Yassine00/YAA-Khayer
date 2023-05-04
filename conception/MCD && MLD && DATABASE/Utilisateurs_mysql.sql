CREATE DATABASE IF NOT EXISTS `ASSOCIATIONS` DEFAULT CHARACTER SET UTF8MB4 COLLATE utf8_general_ci;
USE `ASSOCIATIONS`;

CREATE TABLE `ASSOCIATION` (
  `id_association` VARCHAR(42),
  `type` VARCHAR(42),
  `adresse` VARCHAR(42),
  `justificatifs` VARCHAR(42),
  `image` VARCHAR(42),
  `id_utilisateur` VARCHAR(42),
  PRIMARY KEY (`id_association`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `COMMENTAIRE` (
  `id_commenataire` VARCHAR(42),
  `contenu` VARCHAR(42),
  `date_puublication` VARCHAR(42),
  `id_utilisateur` VARCHAR(42),
  `id_don` VARCHAR(42),
  PRIMARY KEY (`id_commenataire`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `COMPAGNE` (
  `id_compagnw` VARCHAR(42),
  `montant` VARCHAR(42),
  `date_colture` VARCHAR(42),
  `id_association` VARCHAR(42),
  PRIMARY KEY (`id_compagnw`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `DON` (
  `id_don` VARCHAR(42),
  `titre` VARCHAR(42),
  `description` VARCHAR(42),
  `image` VARCHAR(42),
  `date_publication` VARCHAR(42),
  `etat` VARCHAR(42),
  PRIMARY KEY (`id_don`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `DONNER` (
  `id_individu` VARCHAR(42),
  `id_compagnw` VARCHAR(42),
  PRIMARY KEY (`id_individu`, `id_compagnw`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `INDIVIDU` (
  `id_individu` VARCHAR(42),
  `id_utilisateur` VARCHAR(42),
  PRIMARY KEY (`id_individu`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `NOTIFICATION` (
  `id_notification` VARCHAR(42),
  `contenu` VARCHAR(42),
  `date_envoi` VARCHAR(42),
  `checked` VARCHAR(42),
  `id_utilisateur` VARCHAR(42),
  PRIMARY KEY (`id_notification`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `OFFERT` (
  `id_offert` VARCHAR(42),
  `quantite` VARCHAR(42),
  `type` VARCHAR(42),
  `id_individu` VARCHAR(42),
  `id_association` VARCHAR(42),
  PRIMARY KEY (`id_offert`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `UTILISATEUR` (
  `id_utilisateur` VARCHAR(42),
  `name` VARCHAR(42),
  `password` VARCHAR(42),
  `email` VARCHAR(42),
  `numero` VARCHAR(42),
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

ALTER TABLE `ASSOCIATION` ADD FOREIGN KEY (`id_utilisateur`) REFERENCES `UTILISATEUR` (`id_utilisateur`);
ALTER TABLE `COMMENTAIRE` ADD FOREIGN KEY (`id_don`) REFERENCES `DON` (`id_don`);
ALTER TABLE `COMMENTAIRE` ADD FOREIGN KEY (`id_utilisateur`) REFERENCES `UTILISATEUR` (`id_utilisateur`);
ALTER TABLE `COMPAGNE` ADD FOREIGN KEY (`id_association`) REFERENCES `ASSOCIATION` (`id_association`);
ALTER TABLE `DONNER` ADD FOREIGN KEY (`id_compagnw`) REFERENCES `COMPAGNE` (`id_compagnw`);
ALTER TABLE `DONNER` ADD FOREIGN KEY (`id_individu`) REFERENCES `INDIVIDU` (`id_individu`);
ALTER TABLE `INDIVIDU` ADD FOREIGN KEY (`id_utilisateur`) REFERENCES `UTILISATEUR` (`id_utilisateur`);
ALTER TABLE `NOTIFICATION` ADD FOREIGN KEY (`id_utilisateur`) REFERENCES `UTILISATEUR` (`id_utilisateur`);
ALTER TABLE `OFFERT` ADD FOREIGN KEY (`id_association`) REFERENCES `ASSOCIATION` (`id_association`);
ALTER TABLE `OFFERT` ADD FOREIGN KEY (`id_individu`) REFERENCES `INDIVIDU` (`id_individu`);