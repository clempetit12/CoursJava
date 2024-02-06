-- Manipulation de bases de données

-- Création de base de données 
CREATE DATABASE IF NOT EXISTS entreprise_demo CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci";

-- Permet d'afficher toutes les bases de données;
SHOW DATABASES;


-- Suppression de la base de données
DROP DATABASE IF EXISTS entreprise_demo;

-- Modification de base de données
-- ALTER DATABASE entreprise_demo COMMENT = "Base de donnée modifiée";
ALTER DATABASE entreprise_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER DATABASE entreprise_demo DEFAULT CHARACTER SET utf8mb4;
ALTER DATABASE entreprise_demo ENCRYPTION='N';

-- Afficher les schémas des bases de données
SELECT * FROM information_schema.SCHEMATA;

-- Pour se positionner sur la bonne base de donnée
USE entreprise_demo;


-- Création d'une seconde table 
CREATE TABLE IF NOT EXISTS service(
service_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
libelle VARCHAR(150) NOT NULL
);

-- création d'une table di elle n'existe pas 
CREATE TABLE IF NOT EXISTS salarie(
salarie_id INT NOT NULL AUTO_INCREMENT, -- clé primaire qui s'auto-incrémente
prenom VARCHAR(50) NOT NULL, -- obligation de fournir une valeur
nom VARCHAR(50) NOT NULL,
age INT NOT NULL CHECK( age > 18 AND age <65),-- Contrainte pour vérifier l'age
salaire FLOAT NOT NULL, -- Valeur par défaut
service_id INT NOT NULL, -- Ajout de la colonne pour la clé étrangère
PRIMARY KEY(salarie_id),
CONSTRAINT fk_service_id FOREIGN KEY (service_id) REFERENCES service(service_id)
);

DROP TABLE IF EXISTS salarie;

-- Affiche les tables 
SHOW TABLES;

-- Afficher le détail des colonnes 
SHOW COLUMNS FROM salarie;
SHOW COLUMNS FROM service;



-- Ajout de la contrainte après création de la table 
ALTER TABLE salarie
	ADD CONSTRAINT fk_service_id FOREIGN KEY(service_id) REFERENCES service(service_id);
	
-- Ajouter une colonne date-heure
ALTER TABLE service 
	ADD COLUMN date_modification DATETIME;
    
-- modifier la colonne en type 
ALTER TABLE service 
	MODIFY COLUMN date_modification DATE
    
    
