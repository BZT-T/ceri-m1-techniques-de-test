# Rapport d'analyse du code

## Remarque globale
- Aucune documentation
- 24 erreurs de style détectées par Checkstyle.
<details>
  <summary>Cliquez ici pour voir les erreurs Checkstyle</summary>
[INFO] There are 24 errors reported by Checkstyle 9.3 with sun_checks.xml ruleset. 
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[1] (misc) NewlineAtEndOfFile: Il manque un caractère NewLine à la fin du fichier.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[10] (regexp) RegexpSingleline: Line has trailing spaces.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[10,1] (whitespace) FileTabCharacter: Le fichier contient des caractères de tabulation (ce n'est que la première occurence).
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[11,9] (javadoc) JavadocVariable: Commentaire Javadoc manquant.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[20] (regexp) RegexpSingleline: Line has trailing spaces.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[23,17] (whitespace) WhitespaceAfter: Il manque une espace après 'for'.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[23,26] (whitespace) WhitespaceAround: Il manque une espace après '='.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[23,26] (whitespace) WhitespaceAround: Il manque une espace avant '='.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[23,34] (coding) MagicNumber: '1000000' devrait être défini comme une constante.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[24,17] (blocks) LeftCurly: '{' à la colonne 3 devrait être sur la ligne précédente.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[29,32] (coding) MagicNumber: '10000' devrait être défini comme une constante.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[32,9] (design) DesignForExtension: La classe 'RocketPokemonFactory' semble être conçue pour extension (p
eut être héritée), mais la méthode'createPokemon' n'a pas de Javadoc qui explique comment le faire en toute sécurité. Si la classe n'est pas conçue pour extension, envisagez de rendre la classe 'RocketPokemonFactory' finale ou de rendre la méthode 'createPokemon' static/final/abstract/empty, d'ajouter les annotations permises pour la méthode.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[33] (sizes) LineLength: La ligne excède 80 caractères (trouvé 86).
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[33,38] (misc) FinalParameters: Le paramètre index devrait être final.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[33,49] (misc) FinalParameters: Le paramètre cp devrait être final.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[33,57] (misc) FinalParameters: Le paramètre hp devrait être final.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[33,65] (misc) FinalParameters: Le paramètre dust devrait être final.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[33,75] (misc) FinalParameters: Le paramètre candy devrait être final.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[35,17] (whitespace) WhitespaceAfter: Il manque une espace après 'if'.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[44,17] (whitespace) WhitespaceAfter: Il manque une espace après 'if'.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[45,34] (coding) MagicNumber: '1000' devrait être défini comme une constante.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[46,35] (coding) MagicNumber: '1000' devrait être défini comme une constante.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[47,35] (coding) MagicNumber: '1000' devrait être défini comme une constante.
<br>[ERROR] src\main\java\fr\univavignon\pokedex\api\RocketPokemonFactory.java:[55] (sizes) LineLength: La ligne excède 80 caractères (trouvé 122).
</details>

## Erreurs dans `index2name`
- Il n'est pas nécessaire de spécifier que le `HashMap` est de type `<Integer, String>`.
- Les noms des Pokémon sont en anglais.
- L'indexage est décalé de 1.
- Deux Pokémon non souhaités par notre système : Ash's Pikachu et MISSINGNO.
- Elle est inutile, car les noms des Pokémon se trouvent déjà dans `PokemonMetadatProvider`.
- De plus, cela crée une vulnérabilité dans la cohérence des données.

## Erreurs dans `createPokemon`
- Selon les test-driven developers, les Pokémon avec un index trop élevé ou trop faible devraient renvoyer un `null`, mais ici, cela renvoie un Pokémon `MISSINGNO`.
- L'IV est mal calculé, elle est toujours égal à 1 sauf Pokemon MISSINGNO qui a un iv à 0.
- L'attaque, la défense et l'endurance sont bornés entre 0 et 100 pour tous les Pokémons
- La méthode n'utilise pas `PokemonMetadataProvider` pour récupérer les données de l'espèce.
- Le morceau de code :
  ```java
  String name;
  if(!index2name.containsKey(index)) {
  name = index2name.get(0);
  } else {
  name = index2name.get(index);
  }
  ``` 
  peut être remplacé par
   ```java
  String name = index2name.getOrDefault(index, index2name.get(0));
   ```
## Erreurs dans `generateRandomStat`
- La méthode fait une boucle jusqu'à 1 000 000 pour au final diviser le résultat par 10 000 pour au final renvoyer un entier donc autant faire un for jusqu'à 100 et sans division
- Lors de la phase de conception, nous avons décidé que les statistiques aléatoires des Pokémons seraient bornées entre 0 et 15 inclus.

## Génération de test

J'ai décidé de ne pas implémenter de nouveaux tests, car la team Rocket n'a pas respecté les critères mis en place par les 
test-driven developers. Faire des tests sur une conception absolument pas souhaitée n'apporte aucune plus-value. 
Il est plus judicieux d'envoyer ce rapport à la team Rocket pour qu'ils revoient toute la conception de leur code 
et qu'il y ait une utilité à faire les tests. Une fois que les erreurs de conception auront été corrigées et que les 
critères de tests seront respectés, nous pourrons alors mettre en place des tests cohérents et fiables pour garantir 
la qualité du code.