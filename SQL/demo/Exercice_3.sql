-- Exercice 3 Professeur

CREATE DATABASE IF NOT EXISTS ecole CHARACTER SET = "utf8mb4" COLLATE = "utf8mb4_general_ci";
SHOW DATABASES;
USE ecole;

CREATE TABLE IF NOT EXISTS professeurs(
professeur_id INT NOT NULL AUTO_INCREMENT,
prenom VARCHAR(50) ,
nom VARCHAR(50) ,
numero_classe INT ,
numero_departement INT ,
email  VARCHAR(50) ,
telephone VARCHAR(10) NOT NULL,
derniere_connexion DATE, 
PRIMARY KEY (professeur_id)
);

CREATE TABLE IF NOT EXISTS etudiants(
etudiant_id INT NOT NULL AUTO_INCREMENT,
prenom VARCHAR(50) ,
nom VARCHAR(50) ,
numero_classe INT,
date_diplome DATE ,
telephone VARCHAR(10)  ,
PRIMARY KEY (etudiant_id)
);

CREATE TABLE IF NOT EXISTS classes(
etudiant_id INT NOT NULL ,
professeur_id INT NOT NULL,
CONSTRAINT fk_etudiant_id FOREIGN KEY (etudiant_id) REFERENCES etudiants(etudiant_id),
CONSTRAINT fk_professeur_id FOREIGN KEY (professeur_id) REFERENCES professeurs(professeur_id)
);

INSERT INTO  professeurs (prenom,nom, numero_classe, numero_departement,email, telephone,derniere_connexion) 
VALUES
 ("Louis","Blot",2,12,"louisb@gmail.com","0687895456","2023-12-05"),
  ("Louise","Blot",3,12,"louiseb@gmail.com","0687895457","2023-12-12"),
 ("Lou","Clos",4,12,"louc@gmail.com","0687895458","2023-12-09");

INSERT INTO  etudiants (prenom,nom, numero_classe, date_diplome, telephone) 
VALUES
 ("Theo","Tram",2,"2024-01-09","0687895456"),
  ("Tara","Camo",2,"2024-01-18","0687895486"),
  ("Olivia","Pigani",2,"2024-02-09","0687885456");
  
  INSERT INTO  classes (etudiant_id,professeur_id) 
VALUES
(1,1),
(2,1),
(3,1);
   
DROP TABLE IF EXISTS etudiants;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS professeurs;

ALTER TABLE etudiants
	MODIFY telephone VARCHAR(10) NOT NULL;

ALTER TABLE classes 
	ADD CONSTRAINT PRIMARY KEY(etudiant_id, professeur_id);
    
ALTER TABLE etudiants 
	ADD CONSTRAINT telephone UNIQUE (telephone);

ALTER TABLE professeurs 
	ADD CONSTRAINT telephone UNIQUE (telephone),
    ADD CONSTRAINT email UNIQUE (email);



SHOW COLUMNS FROM professeurs;
SHOW COLUMNS FROM etudiants;
SHOW COLUMNS FROM classes;
    
SELECT * FROM professeurs;
SELECT * FROM etudiants;
SELECT * FROM classes;
