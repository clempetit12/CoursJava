## Spring Security

Il faut authentifier (rôles : user/admin)

- Erreur 401 : authentification
- Erreur 403 : authorization

JWT : JSON Web Token


Granted Authority : gestion des rôles  

1) Register
2) LogIn 
3) Quand on est login on envoie un JTW(jeton) et si User veut faire des requetes dans l'ent^te des requetes il faut le JTW dans l'entete

Ldap User : annuaire  LDAP (Lightweight Directory Access Protocol) est un protocole utilisé pour accéder à des services d'annuaire. Un annuaire est une base de données spécialisée qui stocke des informations sur des ressources réseau telles que des utilisateurs, des groupes, des ordinateurs, des imprimantes, etc. LDAP fournit un moyen standardisé pour accéder à ces annuaires et pour rechercher, ajouter, modifier et supprimer des entrées.

UserDetilsService récupère les informations d'authentification et donne lieu à un UserDetails