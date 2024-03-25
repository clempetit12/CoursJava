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
Si on dispose de l'image un contenur peut etre créé
Sinon on va chercher dans docker registry et téléchaarger l'image

docker run (image) => toujours terminer par nom de l'image

# Commandes linux 

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
