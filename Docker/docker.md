##  Docker 

# Virtualisation

Machine : 
_ CPU (4GHZ (nombre de calculs en 1 secondes) et nombre de coeur)
- RAM (8 Go)
- DisqueDur (128 Go espace de stockage disponible TeraOctet)
- 
Machine de base et je vais la découper :
- Machine A ( 1Ghz/2Go/50Go)
- Machine B ( 3Ghz/2Go/78Go)
On peut faire autant de machine en fonction des ressources totales
- 
Android studio est de la virtualisation (simulation d'un autre téléphone)

Pour que ça fonctionne il faut un système d'exploitation

Hyperviseur d'installé (pas de windows ) ProxMox systeme d'exploitation son but est de faire tourner d'autres machines virtuelles 


# Conteneurisation

Docker 
Machine :
- OS (systeme d'exploitation installé)
- Docker :
  - Conteneur A / Conteneur B (découpage logiciel et pas matériel)
Quand on lance un conteneur on ne précise pas les données matérielles, il ne prend que l'espace dont il a besoin 
  - Docker va installer un Noyau Linux (noyau de systeme d'expoitation : il va demander au processeur pour la puissance de calcul lien entre logiciel et ressources materielles )

Image : classe  (metaphore)
Conteneur : objets  (metaphore)

Tout conteneur est basé sur une image 
Si on dispose de l'image un conteneur peut etre créé
Sinon on va chercher dans docker registry et téléchaarger l'image

docker run (image) => toujours terminer par nom de l'image

# Commandes linux (Conteneurs et images)

/ => plus haut niveau des dossiers (sur machine windows C:/)
#Role => USER:ROOT il a tous les droits 
$Role classique 
Pour connaitre son role : whoami 

- pwd : où je suis 
- ls -l : détails des répertoires
- cacher un fichier il faut qu'il commence par un point
- ls -a : voir fichiers cachés
- . repertoire courant 
- .. repertoire parent
- apk upgrade, apk update (mettre à jour des logiciels avant de les installer)
- upgrade mettre à jour les packages va demander la mise à jour des nouvelles version sdes logiciels interroger les serveurs en questions 
- rm -r : supprimer repertoire
- mv nomdufichier nouveaunomdefichier : renommer un fichier
- docker ps -a : afficher tous les conteneurs
- docker inspect image : exposedPort(port disponible sur mon conteneur), clé env (variables environnements),Cmd (instruction lancée quand conteneur démarre)
Telecharger tree pour avoir l'arboresence : tree >> => ajouter le resultat au fichier en cours 
- docker ps pour voir tous les dockers
Liste de port souvent utilisés :
- 3000 
- 8080
- 5000

Port par defaut à ne pas utiliser pour mettre les serveurs web 

-p permet de faire une liaison entre le conteneur et la machine locale 
-p Machine locale : conteneur 

0.0.0.0 => ouvre les ports si j'ai la machine ip qui lance lappli et jajoute 8080 je peux avoir acees au serveur 

Pour créer une image à partir d'un conteneur (pas la pratique à utiliser)
docker commit demobuild demoimage (on peut rajouter la version sinon c'est la dernière version)

Pour envoyer une image sur docker hub : nomd'utilisateur /nomdel'image:tag

Pour déplacer un ficher mv assets index.html .. (se placer où il y a les fichiers et .. pour le dossier parent)

Pour créer une image (à partir d'un conteneur) : docker commit exercice-site-3(nom du conteneur) imageOlivia(nom image)
Pour renommer limage : docker tag imageolivia clempetit12/imageolivia
Pour push image sur docker hub docker push clempetit12/imageolivia

## Volumes

3 types :
- Anonyme
- Nomme
- Bind Mount

Permet de garder les fichiers et les repertoires de nos conteneurs, si le conteneur vient à disparaitre j'ai la sauvegarde du fichier

On peut avoir trois conteneurs :
- BDD/Mysql
- Back/java
- Front:react
Pour qu'ils puissent communiquer entre eux on va les mettre sur le même réseau 

On pourra interroger les conteneurs avec le name du contneur plus besoin de l'adresse ip
Pour pouvoir accéder que au front on ouvre un port sur le front


Créer un volume
docker volume create mydata
docker run -v mydata:/root -it demoimage : on met les données qui se trouvent dans /root de demoimage dans mon volume mydata


DNS : tel nom est relié à tel adresse ip 


## Créer un reseau 

docker network create mynetwork : créer réseau 
ajouter un contenair au reseau : docker run -name machinea -d --network mynetwork nginx

apt-get update && apt-get install -y iputils-ping  : installer ping pour recuperer adresse ip 

Ajouter un conteneur à un réseau existant : docker network connect mynetwork machinec
Ajouter un conteneur à un réseau existant : docker network disconnect mynetwork machinec

## DockerFile

CMD :  rajoute des instructions apres image je viens ajouter 
Entrypoint : vient remplacer la commande 

tar.gz archive sous linux 


Docker build pour créer image à partir du dockerfile : docker build -t demodockerfile2 .

Pour créer un conteneur et le lancer docker run --name imagedocker2 -it demodockerfile2
Pour rentrer dans le shell : docker run --name imagedocker2test -it demodockerfile2 sh


dockerfile utilisation nocache pour forcer à recommencer du début 


Si on veut lancer un conteneur en disant de prendr en compte les variables d'environnement : docker run -e PORT=5000 -p 5005:5000 -d image

## DockerFile pour java

.mvn : pour ne pas avoir besoin de maven sur son poste et pouvoir lancer le projet
Image maeven

FROM maven AS builder

WORKDIR /app

# Envoyer toutes les dépendances du projet (pom.xml), commande Maven qui télécharge toutes les dépendances de votre projet et les rend disponibles hors ligne.
COPY pom.xml .
RUN mvn dependency:go-offline

# copie les fichiers sources et execution de la construction
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk

WORKDIR /app

# copie de l'artefact JAR depuis l'étape précédente : artefactId-version
COPY --from=builder /app/target/TP_Blog-0.0.1-SNAPSHOT.jar .

#voir dans application.properties
EXPOSE 8081

ENTRYPOINT [ "java","-jar","TP_Blog-0.0.1-SNAPSHOT.jar" ]



