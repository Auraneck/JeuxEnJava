-----

# Escape Game en Java

Bienvenue dans ce projet d'escape game en ligne de commande, entièrement développé en Java. Le jeu propose une aventure principale et plusieurs mini-jeux indépendants.

## Fonctionnalités

  * **Aventure principale** : Un petit labyrinthe en mode texte où le joueur se déplace avec les touches `ZQSD` pour trouver une clé et déverrouiller la porte de sortie. Des énigmes sont cachées dans le labyrinthe.
  * **Mini-jeux** : Trois mini-jeux sont accessibles depuis le menu principal :
      * **Devine le code** : Le joueur doit deviner un nombre aléatoire entre 1 et 99.
      * **Message chiffré (César)** : Le joueur doit déchiffrer un message crypté en utilisant une clé de décalage.
      * **Cadenas logique** : Un jeu d'association où le joueur doit relier des villes à leurs pays respectifs.
  * **Minuteur** : Un chronomètre visible en temps réel pendant les mini-jeux pour suivre le temps écoulé.
  * **Interface console** : Le jeu utilise des codes ANSI pour des couleurs et un affichage dynamique.

## Structure du projet

Le code est organisé en plusieurs classes Java, chacune ayant un rôle précis :

  * `Main.java` : Le point d'entrée du programme. Il gère le menu principal et le lancement des différents modes de jeu.
  * `GameWorld.java` : Gère la logique de l'aventure principale, y compris la carte, les mouvements du joueur et les interactions avec les objets.
  * `Step*.java` : Chaque classe (`StepDevineCode`, `StepCryptedMessage`, `StepCadenasLogique`) implémente un mini-jeu spécifique.
  * `Crypto.java` : Contient les fonctions cryptographiques, comme l'algorithme de chiffrement de César.
  * `TimerThread.java` : Une classe qui utilise un **thread** pour gérer et afficher le minuteur en arrière-plan.
  * `Colors.java` et `Terminal.java` : Ces classes utilitaires gèrent l'affichage des couleurs et les commandes de la console, comme effacer l'écran.

-----

## Comment lancer le jeu

Pour lancer le jeu, compilez et exécutez le fichier `Main.java`.

```bash
# Compilez le projet
javac app/*.java

# Exécutez le programme
java app.Main
```
