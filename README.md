# l2s4-projet-2024

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)
Un unique fork doit être réalisé par équipe.

Une fois cela réalisé, supprimer ces premières lignes et remplissez les noms des membres de votre équipe.
N'oubliez pas d'ajouter les autres membres de votre équipe aux membres du projet, ainsi que votre enseignant·e (statut Maintainer).

# Equipe

- sacha SPUND
- ilyes KIDARI
- adil ZOUAR

# Sujet

[Le sujet 2024](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2024.pdf)

# Livrables

## Livrable 1

### Atteinte des objectifs
Modélisation de la TrainingCity finie

### Difficultés restant à résoudre
Difficulté concernant le vrai plateau de jeu car "this.cellList" is null

### Génération non demandée pour cette semaine!

## Livrable 2
Pour ce livrable, nous avons fait tous nos choix de manière à ce que l'ouverture aux extensions soit simple :
    - Pour les acteurs, une classe abstraite Actor, les classes Player et Zombie extend cette classe. Ensuite, Zombie est aussi une classe abstraite qui possède des sous-classes qui représentent les différents types de Zombies, idem pour Player sauf que c'est un héritage simple.

    - Pour les équipements, une classe abstraite Equipment, les classes abstraites Weapon et Consumable étendent cette classe. Ces deux sous-classes ont elles-mêmes des sous-classes qui définissent les différents équipements.
    Les équipements dans Consumable sont utilisables une seule fois alors que dans Weapon non.

    - Pour les actions, nous avons une interface Action qui déclare une méthode Do(). Les différentes classes qui implémentent Action vont avoir une méthode Do sans paramètre obligatoire et une ou plusieurs autres méthodes Do avec différents paramètres. Cela permet de réaliser différentes actions en fonction de l'objet en paramètre tout en gardant le même intitulé de fonction pour faciliter le codage.

### Atteinte des objectifs
Tous les Objectifs ont été atteint

### Difficultés restant à résoudre
Difficulté pour faire la methode qui permet de déplacer les acteurs

### Générer la javadoc
```
javadoc -sourcepath src -subpackages Action Actor Cell City Equipment Actor/Player Actor/Zombie Cell/Room Cell/Street Equipment/Consumable Equipment/Weapon
```
### Compilation et création d'un jar
```
javac -sourcepath src src/*.java src/Action/*.java src/Actor/*.java src/Actor/Player/*.java src/Actor/Zombie/*.java src/Cell/*.java src/Cell/Room/*.java src/Cell/Street/*.java src/City/*.java src/Equipment/*.java src/Equipment/Consumable/*.java src/Equipment/Weapon/*.java -d classes
```
```
jar cvfe Livrable2.jar Livrable2.java -C classes
```
#### Compilation des tests
```
javac -classpath junit-console.jar:classes test/*.java test/Action/*.java test/Actor/*.java test/Actor/Player/*.java test/Actor/Zombie/*.java test/Cell/*.java test/Cell/Room/*.java test/Cell/Street/*.java test/City/*.java test/Equipment/*.java test/Equipment/Consumable/*.java test/Equipment/Weapon/*.java
```
### Execution des tests
```
java -jar junit-console.jar -classpath test:classes -scan -classpath
```

## Livrable 3
  Dans ce livrable, comme mentionné dans le livrable précédent, nous avons une interface nommée Action qui déclare une méthode Do(). Les différentes classes qui implémentent cette interface Action auront une méthode Do() sans paramètre obligatoire, ainsi qu'une ou plusieurs autres méthodes Do() avec différents paramètres. Ceci permet d'effectuer différentes actions en fonction de l'objet passé en paramètre, tout en conservant le même nom de fonction pour faciliter la programmation, ou en utilisant des vérifications telles que instanceof pour détecter les types d'objets.

### Atteinte des objectifs
On a atteint tous les objectifs
### Difficultés restant à résoudre
Dans un toString() qui affiche le nom des player et d'autres informations, le nom des joueurs est null alors qu'on l'a définie.

test de attack et lookaround ne marchent pas pourtant les actions marchent bel et bien. Cela pose problème dans les tests quand on placeActor pourtant placeActor marchent aussi.

### Générer la javadoc
```
javadoc -sourcepath src -subpackages Action Actor Cell City Equipment Actor.Player Actor.Zombie Cell.Room Cell.Street Equipment.Consumable Equipment.Weapon ListChooser ListChooser.Elements ListChooser.Game -d docs
```
### Compilation et création d'un jar
```
javac -sourcepath src src/*.java src/Action/*.java src/Actor/*.java src/Actor/Player/*.java src/Actor/Zombie/*.java src/Cell/*.java src/Cell/Room/*.java src/Cell/Street/*.java src/City/*.java src/Equipment/*.java src/Equipment/Consumable/*.java src/Equipment/Weapon/*.java -d classes
```
```
jar cvfe Livrable3.jar Livrable3 -C classes .

```
#### Compilation des tests
```
javac -classpath junit-console.jar:classes test/*.java test/Action/*.java test/Actor/*.java test/Actor/Player/*.java test/Actor/Zombie/*.java test/Cell/*.java test/Cell/Room/*.java test/Cell/Street/*.java test/City/*.java test/Equipment/*.java test/Equipment/Consumable/*.java test/Equipment/Weapon/*.java
```
### Execution des tests
```
java -jar junit-console.jar -classpath test:classes -scan -classpath
```


## Livrable 4
  Dans ce livrable, nous avons dû terminer la modélisation complète du jeu zombicide. Nous nous sommes donc inspirés du goosegame et bataille navale du s3 en mettant le GameMain mais aussi une classe Game a la racine de src.  
  Le GameMain s'occupe donc de juste l'initialisation des players et le game s'occupe du reste.  
  De plus forcément pour le rendu finale, nous sommes repassés sur quelque classes(notamment les actions pour clarté de l'affichage dans GameMain).  
  Nous avons ajouter une méthode SkipTurn pour passer son tour, et ajouter des couleurs à la City.  

  Extensions :  
  -Les zombie qui errent aléatoirement sur la map.  
  -Une option qui permet aux utilisateurs de passer leur tour.  
  -On a une version interactive du jeu.  

  - IMPORTANT:  Le coverage atteint bien 90% si on masque le manque des tests pour les mains (pas de test pour les mains).
### Atteinte des objectifs

### Difficultés restant à résoudre

### Générer la javadoc
```
javadoc -sourcepath src -subpackages Action Actor Cell City Equipment Actor.Player Actor.Zombie Cell.Room Cell.Street Equipment.Consumable Equipment.Weapon ListChooser ListChooser.Elements ListChooser.Game -d docs
```
```
javadoc -sourcepath src src/Game.java -d docs
```

### Compilation et création d'un jar
```
javac -sourcepath src src/*.java src/Action/*.java src/Actor/*.java src/Actor/Player/*.java src/Actor/Zombie/*.java src/Cell/*.java src/Cell/Room/*.java src/Cell/Street/*.java src/City/*.java src/Equipment/*.java src/Equipment/Consumable/*.java src/Equipment/Weapon/*.java -d classes
```
```
jar cvfe GameMain.jar GameMain -C classes .

```
- Veillez à compiler avant de crée le jar  

#### Compilation des tests  

```
javac -classpath junit-console.jar:classes test/*.java test/Action/*.java test/Actor/*.java test/Actor/Player/*.java test/Actor/Zombie/*.java test/Cell/*.java test/Cell/Room/*.java test/Cell/Street/*.java test/City/*.java test/Equipment/*.java test/Equipment/Consumable/*.java test/Equipment/Weapon/*.java test/Input/*.java test/ListChooser/*.java test/ListChooser/Elements/*.java test/ListChooser/Game/*.java
```
### Execution des tests

```
java -jar junit-console.jar -classpath test:classes -scan -classpath
```


# Journal de bord

## Semaine 1
diagrame UML
## Semaine 2
début du code Java
## Semaine 3
code Java, la classe City pas encore finit
## Semaine 4
fin du code java pour le livrable 1
## Semaine 5
Conception de l'UML
## Semaine 6
Uml terminée
## Semaine 7
--(Vacances)---
## Semaine 8
---(Examen)----
## Semaine 9
code des acteurs: zombie et player + Equipement : consommable et armes + classe Move qui implémente l'interface Action qui permet de déplacer un acteur d'une case + Livrable2.java + ListChooser
## Semaine 10
Restructuration uml
## Semaine 11
codage de methodes d'actions
## Semaine 12
livrable 3 + dernières methodes
