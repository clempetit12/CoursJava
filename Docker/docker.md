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
  - Conteneur A / Conteneur B 
Quand on lance un conteneur on ne précise pas les données matérielles, il ne prend que l'espace dont il a besoin 
  - Docker va installer un Noyau Linux (noyau de systeme d'expoitation : il va demander au processeur pour la puissance de calcul lien entre logiciel et ressources materielles )
  - 