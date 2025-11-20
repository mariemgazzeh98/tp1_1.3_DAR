# Activité 1.3 : Calculatrice Réseau sur Machines Distinctes

## 📋 Description
Cette activité marque une étape importante dans le développement d'applications réparties.
Contrairement aux exercices précédents exécutés en local ("localhost"), cette version est conçue pour fonctionner sur un **vrai réseau local (LAN)**.

Elle permet de connecter un Client situé sur une Machine A à un Serveur situé sur une Machine B.
De plus, le service a été enrichi : au lieu d'une simple multiplication, le client peut choisir parmi **4 opérations** arithmétiques (Addition, Soustraction, Multiplication, Division) qui seront appliquées au nombre 5 côté serveur.

## 🛠️ Architecture & Nouveautés
Le projet introduit l'utilisation des classes réseaux avancées :

1.  **`serverPackage.Server`** :
    *   Utilise `InetAddress.getLocalHost()` pour récupérer et afficher sa propre adresse IP réelle sur le réseau.
    *   Utilise `InetSocketAddress` pour lier le serveur à cette adresse IP spécifique.
    *   Traite 4 types d'opérations via un menu (Switch/Case).
2.  **`clientPackage.Client`** :
    *   Permet à l'utilisateur de saisir manuellement **l'adresse IP du serveur** cible.
    *   Envoie deux informations successives : le nombre à calculer et le choix de l'opération.

## ⚙️ Fonctionnalités
Le client envoie un nombre $x$, puis choisit une opération. Le serveur calcule :
1.  **Addition :** $x + 5$
2.  **Soustraction :** $x - 5$
3.  **Multiplication :** $x \times 5$
4.  **Division :** $x / 5$

## 🚀 Prérequis et Configuration Réseau

1.  **Matériel :** Deux machines (PC) connectées au même réseau (Wi-Fi ou Câble), ou une machine avec deux terminaux.
2.  **Port :** Le port **1234** doit être ouvert.
3.  **Pare-feu (Firewall) :** Si vous testez sur deux machines distinctes, assurez-vous que le pare-feu de la machine Serveur autorise les connexions entrantes sur le port 1234 (ou désactivez-le temporairement).

## ▶️ Instructions d'Exécution

### Étape 1 : Lancer le Serveur (Machine A)
Exécutez la classe `serverPackage.Server`.
Le serveur va afficher son adresse IP. **Notez cette adresse.**

> **Console Serveur :**
> ```text
> Le serveur est demarre sur 192.168.1.15:1234
> Je suis un serveur en attente la connexion d'un client
> ```

### Étape 2 : Lancer le Client (Machine B)
Exécutez la classe `clientPackage.Client`.
Le programme vous demandera l'IP notée à l'étape précédente.

> **Console Client :**
> ```text
> Je suis un client pas encore connecte…
> Entrez l'adresse IP du serveur : 192.168.1.15
> Connexion au serveur 192.168.1.15:1234...
> Je suis connecté au serveur...
> ```

### Étape 3 : Utilisation du Service
Suivez les instructions du menu.

> **Exemple Client :**
> ```text
> Donner x : 10
> 
> Choisissez une opération :
> 1. Addition (+5)
> 2. Soustraction (-5)
> 3. Multiplication (*5)
> 4. Division (/5)
> Entrez votre choix (1-4) : 3
> 
> Le resultat = 50
> ```

## ⚠️ Limitations Techniques (Rappel)
Cette application utilise toujours les méthodes basiques `write(int)` et `read()`.
*   Les valeurs échangées (opérandes et résultat) doivent être comprises entre **0 et 255** (taille d'un octet).
*   Si le résultat d'une multiplication dépasse 255, ou si une soustraction donne un nombre négatif, l'affichage sera incorrect.

