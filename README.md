# UCE Génie Logiciel Avancé : Techniques de tests Yassine BOUAZZATI ILSEN - ALT 1

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.

# Projet Pokedex
**Nom :** BOUAZZATI
**Prénom :** Yassine
**Groupe :** ILSEN - ALT - GRP 1

**Badge CircleCI :**
[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/DVzLVj9QfR8WvAZuxU3Evm/e299e9ec-0fef-4626-850a-9ab93bcf422f/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/circleci/DVzLVj9QfR8WvAZuxU3Evm/e299e9ec-0fef-4626-850a-9ab93bcf422f/tree/master)

**Badge CodeCov :**
[![codecov](https://codecov.io/github/BZT-T/ceri-m1-techniques-de-test/graph/badge.svg?token=G6CC6A2T1A)](https://codecov.io/github/BZT-T/ceri-m1-techniques-de-test)

**Choix d'implémentation :**

J'ai d'abord implémenté toutes les classes, puis j'ai modifié les tests pour qu'ils ne testent plus les mocks, mais les classes que j'ai implémentées.
Dans une classe de test, j'ai décidé de ne "démocker" que la classe à tester et de laisser les autres classes en mock.

Par exemple, dans la classe PokedexFactoryTest, j'ai laissé IPokemonMetadataProvider et IPokemonFactory en mock, car la classe que je teste est PokedexFactory.

J'ai fait ce choix, car, premièrement, le test est centré sur la classe concernée, et, deuxièmement, mon test n'est pas dépendant des autres classes implémentées.
Cela me garantit la fiabilité du test, car si j'avais également implémenté les autres classes, il se pourrait que le test échoue non pas à cause de la classe à tester, mais à cause des classes dépendantes.