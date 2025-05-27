# numerotation
num
# Générateur de Noms (Numerotation Service)

Ce projet permet de générer des identifiants personnalisés à partir de règles dynamiques configurables.

## 🔧 Technologies utilisées

- **Frontend** : Angular 17
- **Backend** : Spring Boot
- **Base de données** : PostgreSQL
- **Communication** : REST API


## 🚀 Fonctionnalités

### 🔹 Config-Service
- Ajout et modification de règles de génération (préfixe, suffixe, longueur, etc.)
- Ajouter ou mettre à jour une règle :  
  `POST http://localhost:8081/api/rules`
- Récupérer les règles pour un ID de configuration (triées par ordre) :  
  `GET http://localhost:8081/api/rules/{configid}`
- Récupérer toutes les règles :  
  `GET http://localhost:8081/api/rules`

### 🔹 Counter-Service
- Gère l’incrémentation automatique du compteur utilisé lors de la génération
- Fournit des compteurs uniques par configuration

### 🔹 Generator-Service
- Génération dynamique d’identifiants à partir des règles et des données fournies via formulaire
- Générer un identifiant :  
  `POST http://localhost:8080/api/generator`
- Gestion des erreurs et validation des données
- Communication avec Config-Service et Counter-Service



## ⚙️ Installation

### ✅ Backend

Assurez-vous que Maven est installé :

## 🌐 Routes principales du frontend

| Route                       | Description                                  |
|----------------------------|----------------------------------------------|
| `/inscription`             | Formulaire d'inscription                     |
| `/admin/config`            | Interface de configuration des règles        |

URL de base : `http://localhost:4200`
### ✅ frontend


```bash
cd backend/
mvn clean install
./mvnw spring-boot:run
