# TP 3 Java : Entrées/Sorties et Gestion des Exceptions

Ce projet contient les solutions du TP 3, portant sur la manipulation des flux d'Entrées/Sorties (I/O) et la mise en œuvre de la gestion des exceptions en Java.

## 🛠️ Technologies Utilisées
- **Langage :** Java (JDK 8 ou supérieur)
- **Concepts :** File I/O, Sérialisation d'objets, Exception handling, Interfaces.

## 📂 Structure du Projet

```text
.
├── README.md                       # Documentation du projet
├── instructions.txt                # Énoncé original du TP
├── test_ls/                        # Dossier de test pour l'exercice LS
├── partie1/                        # Partie I : Entrées/Sorties
│   ├── exercice_ls/
│   │   └── SimulateurLS.java       # Simulation de la commande 'ls'
│   └── exercice_serialization/
│       ├── Product.java            # Modèle (Serializable)
│       ├── IProduitMetier.java     # Interface de gestion
│       ├── MetierProduitImpl.java  # Implémentation de la logique
│       └── Application.java        # Interface console (Menu)
└── partie2/                        # Partie II : Gestion des Exceptions
    ├── exercice_calculette/
    │   └── Calculator.java         # Calculatrice avec try-catch
    └── exercice_vehicule/
        ├── TooFastException.java   # Exception personnalisée
        └── Vehicle.java            # Test de l'exception
```

---

## 🚀 Comment exécuter les exercices

### 1. Compilation globale
Depuis la racine du projet, compilez tous les fichiers :
```bash
javac partie1/exercice_ls/*.java partie1/exercice_serialization/*.java partie2/exercice_calculette/*.java partie2/exercice_vehicule/*.java
```

### 2. Exécutions individuelles

#### Exercice LS (Partie 1)
L'application demande un chemin de répertoire et affiche son contenu avec les permissions.
- **Commande :** `java partie1.exercice_ls.SimulateurLS`
- **Exemple :**
  ```text
  Entrez le chemin : C:\...\test_ls
  .../dossier1 <DIR> rw-
  .../fichier1.txt <FILE> r--
  ```

#### Gestion des Produits (Partie 1 - Sérialisation)
Permet de gérer une liste de produits persistée dans `products.dat`.
- **Commande :** `java partie1.exercice_serialization.Application`
- **Fonctionnalités :** Ajout, Recherche, Suppression, Affichage, et Sauvegarde (Sérialisation).

#### Calculatrice (Partie 2)
Démontre la capture d'exceptions standard (ArithmeticException, NumberFormatException).
- **Commande :** `java partie2.exercice_calculette.Calculator`
- **Résultat :** Affiche des messages d'erreur personnalisés au lieu de faire planter le programme.

#### Véhicule (Partie 2 - Exception Personnalisée)
Démontre la création et le lancement d'une exception propre au domaine métier.
- **Commande :** `java partie2.exercice_vehicule.Vehicle`
- **Comportement :** Si la vitesse > 90, une `TooFastException` est levée et sa trace est affichée.

---

## 📝 Détails des Implémentations

### Simulation LS
Le programme utilise la classe `java.io.File` pour explorer le système de fichiers. Il vérifie les méthodes `isDirectory()`, `canRead()`, `canWrite()` et `isHidden()` pour construire la chaîne de caractères descriptive de chaque élément.

### Sérialisation de Produits
- **Product.java** : Implémente `Serializable` pour permettre l'écriture binaire.
- **MetierProduitImpl.java** : Utilise `ObjectOutputStream` et `ObjectInputStream` pour sauvegarder et charger la liste complète des produits en une seule opération.

### Gestion des Exceptions
- Dans la **Calculatrice**, nous utilisons des blocs `try-catch` pour intercepter les erreurs de saisie ou de calcul mathématique.
- Pour le **Véhicule**, l'exception `TooFastException` hérite de `Exception`, ce qui en fait une "checked exception" (elle doit être déclarée ou capturée).
