# CoursJava

## Architecture

### Developpement par le comportement

Les fonctionnalités spécifiques sont définies par le PO via des user stories.
On fait des tests en amont :
- Given (afin de)
- When(quand)
- Then(reponse)

Cucumber(framework) pour réaliser les BDD (behavior-driven development)


Le domain recoit une notification d'un brocker un autre composant hexagonal qui s'occupe de lancer une notification sms ou email (peut etre par interface par exemple)


