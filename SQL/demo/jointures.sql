CREATE DATABASE jointures;

USE jointures;

CREATE TABLE utilisateurs (
id INT PRIMARY KEY AUTO_INCREMENT,
prenom VARCHAR(50) NOT NULL,
nom VARCHAR(50),
email VARCHAR(50),
ville VARCHAR(50),
actif INT
);

CREATE TABLE commandes (
utilisateur_id INT,
date_achat DATE,
num_facture CHAR(6),
prix_total DOUBLE 
);

INSERT INTO utilisateurs (prenom,nom, email, ville,actif)
VALUES
("helene","priche","helenep@gmail.com","lille",1),
("florian","aman","helenep@gmail.com","paris",0),
("lou","trap","helenep@gmail.com","bordeaux",1),
("camille","cotu","helenep@gmail.com","lille",1);

INSERT INTO commandes (utilisateur_id,date_achat,num_facture,prix_total)
VALUES 
(1,"2023-12-08",'A0150',10000),
(1,"2023-08-12",'AK150',2.500),
(3,"2023-05-14",'A0250',100),
(4,"2023-05-03",'A0850',500.4),
(2,"2023-05-01",'A0700',100.6),
(2,"2023-05-20",'A0300',300);


INSERT INTO commandes (utilisateur_id,date_achat,num_facture,prix_total)
VALUES 
(5,"2023-12-08",'A0150',10000);

INSERT INTO commandes (utilisateur_id,date_achat,num_facture,prix_total)
VALUES 
(8,"2023-12-08",'A0150',10000);

INSERT INTO utilisateurs (prenom,nom, email, ville,actif)
VALUES
("tam","priche","helenep@gmail.com","lille",1);

INSERT INTO utilisateurs (prenom,nom, email, ville,actif)
VALUES
("teo","priche","helenep@gmail.com","lille",1);

SELECT * FROM utilisateurs;
SELECT * FROM commandes;

SELECT id, prenom, nom, date_achat, num_facture, prix_total 
FROM utilisateurs 
INNER JOIN commandes ON utilisateurs.id = commandes.utilisateur_id;

-- LEFT JOIN EXEMPLE on va chercher tout ce qu'il y a dans la tablea de gauche premiere table ici utilisateurs et on va ajouter la correspondance et en dessous on met tous les utilisateurs qui n'ont pas de commandes

SELECT * 
FROM utilisateurs 
LEFT JOIN commandes ON utilisateurs.id = commandes.utilisateur_id;

-- Right join 

SELECT * 
FROM utilisateurs 
RIGHT JOIN commandes ON utilisateurs.id = commandes.utilisateur_id;

SELECT * 
FROM commandes 
RIGHT JOIN utilisateurs ON utilisateurs.id = commandes.utilisateur_id;

-- Exemple left join en excluant les nulls équivalent à un inner join

SELECT *
FROM utilisateurs 
LEFT JOIN commandes ON utilisateurs.id = commandes.utilisateur_id
WHERE utilisateur_id IS NOT NULL;

-- Le full join : n'est pas possible 

SELECT * 
FROM utilisateurs 
FULL JOIN comandes ON utilisateurs.id = commandes.utilisateur_id;

SELECT *
FROM utilisateurs
LEFT JOIN commandes ON utilisateurs.id = commandes.utilisateur_id
UNION
SELECT *
FROM utilisateurs
RIGHT JOIN commandes ON utilisateurs.id = commandes.utilisateur_id