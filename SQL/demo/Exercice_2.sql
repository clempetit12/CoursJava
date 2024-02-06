-- Exercice 2 compte bancaire

CREATE DATABASE IF NOT EXISTS banque CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci";
SHOW DATABASES;
USE banque;

CREATE TABLE IF NOT EXISTS compte(
compte_id INT NOT NULL AUTO_INCREMENT,
pseudo VARCHAR(50) NOT NULL,
mot_de_passe VARCHAR(50) NOT NULL,
date_creation DATETIME NOT NULL,
derniere_connexion VARCHAR(50) NOT NULL,
PRIMARY KEY (compte_id)
);


CREATE TABLE IF NOT EXISTS roles(
role_id INT NOT NULL AUTO_INCREMENT,
libelle VARCHAR(50) NOT NULL,
PRIMARY KEY (role_id)
);


CREATE TABLE IF NOT EXISTS compte_role(
compte_id INT NOT NULL,
role_id INT NOT NULL,
date_ajout INT NOT NULL DEFAULT NOW(),
CONSTRAINT fk_compte_id FOREIGN KEY (compte_id) REFERENCES compte(compte_id),
CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles(role_id),
PRIMARY KEY (compte_id, role_id)
);






SHOW COLUMNS FROM compte;
SHOW COLUMNS FROM compte_role;
SHOW COLUMNS FROM roles;

DROP TABLE IF EXISTS compte_role;