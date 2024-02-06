## TDD BDD

TDD : test development driven

 - **Test End to End** : Tester  l'application de bout en bout (démarre appli et test toutes les fonctionnailtés) :
   - coût énorme
   -  Exemple logiciel pour tester :  selenium (desktop), appium (mobile)

 - **Tests d'intégration**  : nombre dépend du nombre de composants :
   - coût moindre que TEE
 
- **Test unitaire** : nombre très élevé, un test par branche (ex if else deux branches): 
  -  coût pas très élevé 
  

## Règles pour écrire un test

Les triples AAA(arrange, act, assert)
- Objet à tester
- Méthode ou action 
- vérification

JUnit, Xunit, Spock : framework de test 
Utilisation de JUnit 

## Principe du TDD

Pricipe de faire émerger le code par les tests 
R(red) : écriture du code par les tests(plein d'erreurs)
G(green) : écris pour corriger les tests
R(refactor) : amélioration du code

Test unitaire doit être stateless il doit toujours se comporter de la meme façon.




