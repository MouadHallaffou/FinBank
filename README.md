# 🏦 FinBank - Application Bancaire Java

## 📋 Description du Projet

Ce projet consiste à concevoir et développer une application bancaire en Java permettant de gérer les clients, leurs comptes et leurs transactions. L'application offre la possibilité à un banquier de créer des comptes pour les clients, d'effectuer des opérations financières (dépôts, retraits, virements) et de générer automatiquement un relevé bancaire sous forme de fichier texte.

## ✨ Fonctionnalités

- 👥 **Gestion des clients** : Création et gestion des profils clients
- 💳 **Gestion des comptes** : Création et administration des comptes bancaires
- 💰 **Opérations financières** :
    - 📥 Dépôts
    - 📤 Retraits
    - 🔄 Virements
- 📄 **Relevés bancaires** : Génération automatique de relevés au format texte
- 🔐 **Authentification** : Système de connexion pour gestionnaires et clients

## 🏗️ Structure du Projet

```
finbank/
└── src/
        ├── main/
        │   ├── java/
        │   │   ├── 🚀 Main.java
        │   │   ├── 🎮 controllers/
        │   │   │   ├── ClientController.java
        │   │   │   └── GestionnaireController.java
        │   │   ├── 🏷️ enums/
        │   │   │   └── TypeCompte.java
        │   │   ├── 📊 models/
        │   │   │   ├── User.java
        │   │   │   ├── Client.java
        │   │   │   ├── Gestionnaire.java
        │   │   │   ├── Compte.java
        │   │   │   └── Transaction.java
        │   │   ├── ⚙️ services/
        │   │   │   ├── BanqueService.java
        │   │   │   └── FichierService.java
        │   │   ├── 🔧 utils/
        │   │   │   └── Validation.java
        │   │   └── 🖥️ views/
        │   │       ├── ClientMenu.java
        │   │       ├── GestionnaireMenu.java
        │   │       └── Console.java
        │   └── resources/
        │       └── 📁 releves/
```

## 🛠️ Technologies Utilisées

- ☕ **Java** - Langage de programmation principal
- 📁 **File I/O** - Gestion des fichiers de relevés
- 🏗️ **Architecture MVC** - Modèle-Vue-Contrôleur

## 🚀 Installation et Utilisation

1. **Cloner le projet**
     ```bash
     git clone https://github.com/MouadHallaffou/FinBank.git
     cd FinBank
     ```

2. **Compiler le projet**
     ```bash
     javac -d bin src/main/java/**/*.java
     ```

3. **Exécuter l'application**
     ```bash
     java -cp bin Main
     ```

## 👥 Types d'Utilisateurs

- 🏦 **Gestionnaire** : Accès complet aux fonctionnalités de gestion
- 👤 **Client** : Consultation de comptes et opérations limitées

## 📝 Licence

Ce projet est développé dans un cadre éducatif.
