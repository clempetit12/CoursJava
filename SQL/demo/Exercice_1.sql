-- Exercice 1 Création table personne 

CREATE DATABASE IF NOT EXISTS annuaire CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci";
SHOW DATABASES;
USE annuaire;


CREATE TABLE IF NOT EXISTS adresses(
rue VARCHAR(150) NOT NULL,
personne_id INT,
ville VARCHAR(150) NOT NULL,
code_postal INT NOT NULL,
adresse_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
CONSTRAINT fk_personne_id FOREIGN KEY (personne_id) REFERENCES personnes(personne_id)
);

CREATE TABLE IF NOT EXISTS personnes(
personne_id INT NOT NULL AUTO_INCREMENT,
titre VARCHAR(3),
prenom VARCHAR(50) NOT NULL,
nom VARCHAR(50) NOT NULL,
telephone VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
PRIMARY KEY (personne_id)
);

SHOW TABLES;

INSERT INTO  personnes (titre,prenom, nom, telephone,email) 
VALUES
 ("Mme","Catherine","Patard","0658595754","catherinep@gmail.com"),
 ("Mr","Louis","Patard","0658595755","louisp@gmail.com"),
 ("Mme","Clara","Lout","0658595757","claral@gmail.com");

INSERT INTO  adresses (rue,personne_id, ville, code_postal) 
VALUES
 ("Rue de la paix",1,"Lille",59800),
 ("Rue de la gare",2,"Bordeaux",78500),
 ("Rue des arts",3,"Paris",75000);

SELECT * FROM personnes;
SELECT * FROM adresses;


DROP TABLE IF EXISTS personnes;
DROP TABLE IF EXISTS adresses;

SHOW COLUMNS FROM adresses;
SHOW COLUMNS FROM personnes;

DELETE FROM adresses WHERE personne_id = 3;
DELETE FROM personnes WHERE  prenom = "louis";

UPDATE
	personnes
 SET
	telephone = "0000000000"
WHERE 
     nom = "Patard";
     
-- Liste ordonnée par nom de famille DESC
SELECT * FROM personnes ORDER BY nom DESC; 

SELECT * FROM personnes ORDER BY prenom DESC; 

-- Liste des personnes avec titre Mme
SELECT * FROM personnes ORDER BY titre;
-- Liste des personnes dont email est louisp@gmail.com
SELECT * FROM personnes WHERE email = "louisp@gmail.com";




