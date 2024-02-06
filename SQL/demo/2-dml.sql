-- Insert INTO

USE entreprise_demo;

-- Méthode 1 : sans préciser les colonnes 
INSERT INTO service 
VALUES (NULL, "RH", '2023-05-12');

-- Méthode 2 : en précisant le nom des colonnes (à privilégier)
INSERT INTO service (libelle, date_modification)
VALUES 
("ACHATS", "2023-12-08"),
("COMPTA", "2023-12-14");

-- Méthode 3 : via requête imbriquée (pas la methode à privilégier)
INSERT INTO service (libelle, date_modification)
SELECT 
"R&D" as libelle,
"2024-05-08" as date_modification;

SELECT * FROM service;
SELECT * FROM salarie;

-- DELETE FROM
-- Supprime tous les enregistrements de la table 
DELETE FROM service;

-- Suppression avec condition sur l'id
DELETE FROM service WHERE service_id = 7;

-- Suppression avec condition sur libelle
DELETE FROM service WHERE libelle = "achats";

-- Mise à jour de l'enregistrement 
UPDATE
	service
 SET
	libelle = "développement",
	date_modification = NOW()
WHERE 
     service_id = 8;
     
-- SELECT 
-- Sélectionner toutes les colonnes d'une table 
SELECT * FROM service;

-- Sélectionner une colonne d'une table
SELECT libelle FROM service;

-- Sélectionner plusieurs colonnes 

SELECT service_id, libelle FROM service;

-- Préfixer les colonnes du nom de la table 
SELECT service.service_id, service.libelle FROM service;

INSERT INTO salarie (prenom, nom, age, salaire, service_id)
VALUES 
("jeanne","duppont",40,2000,8),
("louise","duppont",30,1500,9),
("anne","duppont",19,2000,9),
("leo","duppont",60,1500,11);

-- Sélection sur plusieurs tables
SELECT * FROM service,salarie;

-- Instruction where
SELECT nom, prenom FROM salarie WHERE salaire >1800;

SELECT nom, prenom FROM salarie WHERE salaire <3000 AND age>33;

SELECT nom, prenom FROM salarie WHERE salaire > 3600 OR age >33;

SELECT nom, prenom FROM salarie WHERE age BETWEEN 19 AND 40;

-- DISTINCT :elimine les doublons

SELECT DISTINCT salaire FROM salarie;

-- LIMIT : spécifie le nombre de ligne à retourner

SELECT * FROM service LIMIT 2;

-- ORDER BY  : retourne le résultat dans un ordre défini 
SELECT * FROM service ORDER BY libelle ; -- ASC implicite 

SELECT * FROM service ORDER BY libelle DESC;

-- Requêtes imbriquées prenoms qui commencent par r
SELECT nom, prenom
FROM ( SELECT * FROM salarie WHERE prenom LIKE 'l%') AS prenom_en_l
WHERE age > 25;

SELECT * FROM salarie WHERE prenom LIKE 'l%';

SELECT service_id, COUNT(service_id) AS nombre_salarie FROM salarie GROUP BY service_id;

-- Quand on cherche par le prénom il est obligé de parcourir toute la table alors que en cherchant par la primary key la requete est plus optimisée car va chercher le row correspondant et ne scanne pas toute la table 
-- la primary key se comporte comme un index
SELECT * FROM salarie WHERE service_id = 10;


SELECT service_id, AVG(salaire) FROM salarie GROUP BY service_id HAVING AVG(salaire)>1000;
SELECT * FROM salarie;