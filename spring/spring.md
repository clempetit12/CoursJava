## Spring

Deux concepts fondamentaux derrieère :
- IOC (inversion of control) : aucun moment on instancie le controller et c'est spring qui s'occupe d'instancier l'objet. 
- Injection de dépendances : créer l'objet et injecter une dépendance dans l'objet qui utilise cet objet
- Exemple : class voiture (caractéristiques de l'objet dont Moteur(autre classe) spring va le créer automatiquement et l'injecter dans la classe voiture)

### Spring batch 
Permet de chercher des info dans des bases de données complètement différentes, possibilité de regrouper dans une seule bdd ou dans plusieurs bdd


Design pattern : MVC (model view controller)

Metadonnées du head : informations utiles pour le programme mais pas pour l'utilisateur 

mvnw and mvnw.cmd are scripts used in projects built with Maven to facilitate building, testing, and managing dependencies without requiring an explicit installation of Maven on the system

static : css
templates : views

Couplage fort : on passe par une et une seule classe seulement 
Couplage faible : composants moins dépendants possibles

Autowired par 
- Controller (à privilégier) injection de dépendances via controller: 
- => construction de dépendances et apres controller

- Si au niveau getter ou attribut (à ce niveau possibilité d'erreurs et de plantage)
- => D'abord controller et apresè construction dépendances 