CREATE DATABASE exercice_5;

USE exercice_5;

CREATE TABLE IF NOT EXISTS villes_france_free (
  ville_id int NOT NULL,
  ville_departement varchar(3) DEFAULT NULL,
  ville_slug varchar(255) DEFAULT NULL,
  ville_nom varchar(45) DEFAULT NULL,
  ville_nom_simple varchar(45) DEFAULT NULL,
  ville_nom_reel varchar(45) DEFAULT NULL,
  ville_nom_soundex varchar(20) DEFAULT NULL,
  ville_nom_metaphone varchar(22) DEFAULT NULL,
  ville_code_postal varchar(255) DEFAULT NULL,
  ville_commune varchar(3) DEFAULT NULL,
  ville_code_commune varchar(5) NOT NULL,
  ville_arrondissement smallint DEFAULT NULL,
  ville_canton varchar(4) DEFAULT NULL,
  ville_amdi smallint DEFAULT NULL,
  ville_population_2010 int DEFAULT NULL,
  ville_population_1999 int DEFAULT NULL,
  ville_population_2012 int DEFAULT NULL ,
  ville_densite_2010 int DEFAULT NULL,
  ville_surface float DEFAULT NULL,
  ville_longitude_deg float DEFAULT NULL,
  ville_latitude_deg float DEFAULT NULL,
  ville_longitude_grd varchar(9) DEFAULT NULL,
  ville_latitude_grd varchar(8) DEFAULT NULL,
  ville_longitude_dms varchar(9) DEFAULT NULL,
  ville_latitude_dms varchar(8) DEFAULT NULL,
  ville_zmin int DEFAULT NULL,
  ville_zmax int DEFAULT NULL,
  PRIMARY KEY (ville_id)
);

CREATE TABLE IF NOT EXISTS departement (
  departement_id INT NOT NULL,
  departement_code VARCHAR(3) ,
  departement_nom VARCHAR(255),
  departement_nom_uppercase VARCHAR(255),
  departement_slug VARCHAR(255),
  departement_nom_soundex VARCHAR(20),
  PRIMARY KEY (departement_id)
);
SELECT * FROM villes_france_free;
SELECT * FROM departement;

-- Liste des 10 villes les plus peuplées en 2012
SELECT ville_nom,ville_population_2012 FROM villes_france_free ORDER BY ville_population_2012 DESC LIMIT 10;

-- Liste des 50  villes plus faible superficie
SELECT ville_nom,ville_surface FROM villes_france_free ORDER BY ville_surface LIMIT 50;

--  liste des départements d’outre-mer, c’est-à-dire ceux dont le numéro de département commenç ant par 97
SELECT * FROM departement WHERE departement_code LIKE '97%';

--  nom 10 villes les plus peuplées en 2012, ainsi que le nom du département associé
SELECT ville_nom,ville_population_2012,ville_departement,departement_nom
FROM villes_france_free
INNER JOIN departement ON villes_france_free.ville_departement = departement.departement_code ORDER BY ville_population_2012 DESC LIMIT 10;

--  liste du nom de chaque département, associé à son code et du nombre de commune au sein de ces départements, en triant afin d’obtenir en priorité les départements qui possèdent le plus de communes
SELECT departement_nom,departement_code,ville_departement, COUNT(ville_code_commune) AS nombre_communes
FROM departement
INNER JOIN villes_france_free ON villes_france_free.ville_departement = departement.departement_code GROUP BY departement.departement_nom,
    departement.departement_code ORDER BY nombre_communes DESC;

-- Obtenir la liste des 10 plus grands départements, en termes de superficie
SELECT departement_nom,departement_code,ville_departement, SUM(ville_surface) AS surface_departement
FROM departement
INNER JOIN villes_france_free ON villes_france_free.ville_departement = departement.departement_code GROUP BY departement.departement_nom,
    departement.departement_code ORDER BY surface_departement DESC LIMIT 10;
    
-- Compter le nombre de villes dont le nom commence par “Saint
SELECT  COUNT(*) AS nombre_ville_Saint FROM villes_france_free WHERE ville_nom LIKE "Saint%";

-- Obtenir la liste des villes qui ont un nom existants plusieurs fois, et trier afin d’obtenir en premier celles dont le nom est le plus souvent utilisé par plusieurs communes
SELECT ville_nom, COUNT(*) FROM villes_france_free GROUP BY ville_nom HAVING COUNT(*)>1 ORDER BY COUNT(*) DESC;

-- ville dont le nom est pluss utilisé 14 fois
SELECT * FROM villes_france_free WHERE ville_nom = "sainte-colombe";

-- Obtenir en une seule requête SQL la liste des villes dont la superficie est supérieure à la superficie moyenne
SELECT ville_nom, ville_surface FROM villes_france_free WHERE ville_surface >(
SELECT
 AVG(ville_surface)
 FROM 
 villes_france_free);

-- Obtenir la liste des départements qui possèdent plus de 2 millions d’habitants
SELECT departement_nom, departement_code, ville_departement, SUM(ville_population_2012) 
FROM departement
INNER JOIN villes_france_free ON villes_france_free.ville_departement = departement.departement_code GROUP BY departement.departement_nom,  departement.departement_code
HAVING SUM(ville_population_2012) > 2000000
;

-- Remplacez les tirets par un espace vide, pour toutes les villes commençant par “SAINT-” (dans la colonne qui contient les noms en majuscule)
UPDATE villes_france_free
SET ville_nom = REPLACE(ville_nom, '-', ' ')
WHERE ville_nom LIKE 'Saint%';

SELECT * FROM villes_france_free WHERE ville_nom LIKE 'Saint%';

