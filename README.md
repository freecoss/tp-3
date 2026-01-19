# TP 3 Java : Entrées/Sorties et Gestion des Exceptions

Ce projet contient la solution pour le TP 3, divisé en deux parties principales : les opérations d'Entrées/Sorties (I/O) et la gestion des Exceptions en Java.

## Structure du Projet

```
.
├── instructions.txt                # Énoncé du TP
├── input_ls.txt                    # Fichier de test pour l'exercice LS
├── input_app.txt                   # Fichier de test pour l'exercice de sérialisation
├── products.dat                    # Fichier de données généré par la sérialisation
├── partie1
│   ├── exercice_ls
│   │   └── SimulateurLS.java       # Exercice 1 : Simulation de la commande 'ls'
│   └── exercice_serialization
│       ├── Application.java        # Exercice 2 : Main avec menu utilisateur
│       ├── IProduitMetier.java     # Interface métier
│       ├── MetierProduitImpl.java  # Implémentation avec sérialisation
│       └── Product.java            # Classe produit sérialisable
└── partie2
    ├── exercice_calculette
    │   └── Calculator.java         # Exercice 1 : Calculatrice avec gestion d'erreurs
    └── exercice_vehicule
        ├── TooFastException.java   # Exercice 2 : Exception personnalisée
        └── Vehicle.java            # Classe véhicule utilisant l'exception
```

---

## Partie 1 : Entrées/Sorties

### Exercice 1 : Simulation de la commande LS

L'objectif est de simuler la commande `ls` pour lister le contenu d'un répertoire donné, en affichant si c'est un fichier `<FILE>` ou un dossier `<DIR>`, ainsi que les permissions (r/w/h).

**Fichier source :** `partie1/exercice_ls/SimulateurLS.java`

**Exécution et Démonstration :**

Nous avons créé un dossier de test `test_ls` contenant :
- `dossier1` (Répertoire)
- `fichier1.txt` (Fichier en lecture seule)

*Commande :*
```bash
java -cp . partie1.exercice_ls.SimulateurLS
```
*(Entrée : chemin absolu vers `test_ls`)*

*Résultat :*
```
Entrez le chemin absolu du répertoire : C:\Users\DELL\Desktop\enset\java\tp 3\test_ls
C:\Users\DELL\Desktop\enset\java\tp 3\test_ls\dossier1 <DIR> rw-
C:\Users\DELL\Desktop\enset\java\tp 3\test_ls\fichier1.txt <FILE> r--
```

---

### Exercice 2 : Sérialisation d'Objets

Cet exercice met en œuvre la persistance de données (objets `Product`) dans un fichier binaire `products.dat` via la sérialisation Java. Une application console permet d'ajouter, lister, rechercher, supprimer et sauvegarder des produits.

**Fichiers sources :** `partie1/exercice_serialization/`

**Exécution et Démonstration :**

Scénario de test :
1. Ajout d'un produit (ID: 1, Nom: "Ordi", Marque: "Dell", Prix: 1000, Desc: "Laptop", Stock: 10).
2. Affichage de la liste.
3. Sauvegarde dans le fichier.
4. Quitter.

*Commande :*
```bash
java -cp . partie1.exercice_serialization.Application
```

*Résultat :*
```
Menu :
1. Afficher la liste des produits.
2. Rechercher un produit par son id.
3. Ajouter un nouveau produit.
4. Supprimer un produit par id.
5. Sauvegarder les produits.
6. Quitter.
Choisissez une option : 3
Entrez l'ID : 1
Entrez le nom : Ordi
Entrez la marque : Dell
Entrez le prix : 1000
Entrez la description : Laptop
Entrez le stock : 10
Produit ajouté.

Menu :
...
Choisissez une option : 1
Product{id=1, name='Ordi', brand='Dell', price=1000.0, description='Laptop', stock=10}

Menu :
...
Choisissez une option : 5
Produits sauvegardés.

Menu :
...
Choisissez une option : 6
Au revoir.
```

---

## Partie 2 : Gestion des Exceptions

### Exercice 1 : Calculatrice

Implémentation d'une calculatrice simple qui gère les cas d'erreurs courants (division par zéro, format de nombre invalide, opération inconnue) sans planter l'application.

**Fichier source :** `partie2/exercice_calculette/Calculator.java`

**Exécution et Démonstration :**

Le programme principal exécute une série de tests automatiques.

*Commande :*
```bash
java -cp . partie2.exercice_calculette.Calculator
```

*Résultat :*
```
--- Tests ---
Résultat : 15                      # Test de 10 + 5
Erreur : Division par zéro impossible.    # Test de 10 / 0
Erreur : Opération '&' non supportée      # Test d'opération invalide
Convert '123': 123                 # Conversion réussie
Erreur : 'abc' n'est pas un nombre valide # Test de conversion invalide
```

---

### Exercice 2 : Exception Personnalisée (TooFastException)

Création d'une exception personnalisée `TooFastException` levée lorsqu'un véhicule dépasse une certaine vitesse (90).

**Fichiers sources :** `partie2/exercice_vehicule/`

**Exécution et Démonstration :**

Le programme teste deux vitesses : 80 (OK) et 120 (Trop vite).

*Commande :*
```bash
java -cp . partie2.exercice_vehicule.Vehicle
```

*Résultat :*
```
Test de vitesse 80 :
Vitesse 80 est OK.

Test de vitesse 120 :
partie2.exercice_vehicule.TooFastException: C'est une exception de type TooFastException. Vitesse en cause : 120
        at partie2.exercice_vehicule.Vehicle.testSpeed(Vehicle.java:10)
        at partie2.exercice_vehicule.Vehicle.main(Vehicle.java:26)
```

```