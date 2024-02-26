
## Programmation Réactive asynchrone

Contrairement à la programmation impérative traditionnelle, où le contrôle du flux de programme est déterminé par des instructions séquentielles, la programmation réactive asynchrone se concentre sur la réaction aux événements et sur la manipulation de flux de données de manière asynchrone.

Websocket : On initie une première requête et on garde la connexion ouverte, on garde le flux ouvert.

Http2 : plus performant que le web socket , le air socket par exemple qui l'utilise

Augmentation des echanges de communication on nécessité de trouver des protocoles non bloquants 

Programmation réactive possible grâce à Reactor(avec Spring réactif) pour créer EventLoop possible grâcr à deux types d'objets :
- mono : renvoie 0 ou 1 (1 seul flux)
- flux : : réception d'info en continu au niveau de event loop (javascript ne peux pas recevoir des flux en continu)
Les deux sont regroupés dans spring flux

Netty 

Mecanisme du fallback : si une des deux api ne repond pas je devrai générer un mono par défaut 
car chaque microservice fonctionne de manière autonome 
Impossible de zipper un mono et un flux il faut que se soit du même type



