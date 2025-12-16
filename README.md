# Application de Gestion de Conférences - Architecture Microservices

## 📋 Description du Projet

Application complète de gestion de conférences et de keynotes basée sur une architecture microservices avec Spring Boot, Angular et sécurisée par Keycloak. Ce projet permet de gérer des conférences, leurs keynotes associés et les reviews.

## 🏗️ Architecture Technique

L'application est composée de 7 modules principaux :

```
Ghazoui/
├── discovery-service/      # Eureka Server (Service Registry)
├── config-service/         # Spring Cloud Config Server
├── gateway-service/        # Spring Cloud Gateway (API Gateway)
├── keynote-service/        # Microservice de gestion des Keynotes
├── conference-service/     # Microservice de gestion des Conférences
├── frontend/              # Application Angular
├── config-repo/           # Configuration centralisée
└── docker-compose.yml     # Orchestration Docker
```

### Schéma d'Architecture

```
┌─────────────┐
│   Frontend  │ (Angular)
│   :4200     │
└──────┬──────┘
       │
       ↓
┌─────────────────────┐
│   Gateway Service   │ :8888
│  (Spring Cloud GW)  │
└──────────┬──────────┘
           │
    ┌──────┴───────┬─────────────┐
    ↓              ↓             ↓
┌──────────┐  ┌────────────┐  ┌────────┐
│ Keynote  │  │Conference  │  │Eureka  │
│ Service  │  │  Service   │  │Server  │
│  :8081   │  │   :8082    │  │ :8761  │
└──────────┘  └────────────┘  └────────┘
    │              │
    └──────┬───────┘
           ↓
    ┌────────────┐
    │  Keycloak  │ :8080
    │   (OAuth2) │
    └────────────┘
```

## 🚀 Technologies Utilisées

### Backend
- **Spring Boot ** - Framework principal
- **Spring Cloud Gateway** - API Gateway
- **Eureka Server** - Service Discovery
- **Spring Cloud Config** - Configuration centralisée
- **Spring Data JPA** - Couche de persistance
- **H2 Database** - Base de données (dev/test)
- **OpenFeign** - Communication inter-microservices
- **Resilience4J** - Circuit Breaker (fault tolerance)
- **OpenAPI (Swagger)** - Documentation API

### Frontend
- **Angular 17+** - Framework frontend
- **TypeScript** - Langage de développement
- **Bootstrap/Tailwind** - Framework CSS

### Sécurité
- **Keycloak** - Identity Provider (OAuth2/OIDC)
- **Spring Security** - Sécurisation des endpoints

### DevOps
- **Docker** - Conteneurisation
- **Docker Compose** - Orchestration
- **Jenkins** - CI/CD (Jenkinsfile inclus)

## 📦 Services et Fonctionnalités

### 1. Keynote Service (Port 8081)
Gère les informations des keynotes :
- CRUD complet des keynotes
- Attributs : id, nom, prénom, email, fonction
- API REST documentée avec Swagger

### 2. Conference Service (Port 8082)
Gère les conférences et leurs reviews :
- CRUD des conférences (id, titre, type, date, durée, nombre d'inscrits, score)
- Type : Académique ou Commerciale
- Gestion des reviews (id, date, texte, note de 1-5 étoiles)
- Communication avec keynote-service via OpenFeign

### 3. Gateway Service (Port 8888)
- Point d'entrée unique pour tous les microservices
- Routage intelligent des requêtes
- Intégration avec Keycloak pour l'authentification

### 4. Discovery Service (Port 8761)
- Enregistrement et découverte des microservices
- Dashboard Eureka accessible

### 5. Config Service (Port 8888)
- Centralisation des configurations
- Support de configuration Git-based

## 🔐 Configuration Keycloak

### Realm Configuration
Le realm `myrealm` est pré-configuré avec :
- Clients pour chaque microservice
- Rôles utilisateurs (USER, ADMIN)
- Configuration OAuth2/OIDC

<img width="1497" height="761" alt="image" src="https://github.com/user-attachments/assets/1b601970-ae69-49ea-9556-3a6636db45b7" />

<img width="1502" height="640" alt="image" src="https://github.com/user-attachments/assets/5d646ab9-ef40-4ae5-87c5-411277e0a41b" />

<img width="1502" height="668" alt="image" src="https://github.com/user-attachments/assets/c6112c40-0188-418c-96e7-c7bbd5ea7f9b" />



## 🖥️ Captures d'écran Frontend

### Page des Keynotes
<img width="1699" height="849" alt="image" src="https://github.com/user-attachments/assets/b382dbf0-1658-4dea-9026-0b13f4b403a2" />


### Page des Conférences
<img width="1669" height="869" alt="image" src="https://github.com/user-attachments/assets/bc1b3c1d-3144-4b4a-9c2e-1e3b9a635cd7" />

## 🛠️ Installation et Exécution

### Prérequis
- Java 17+
- Node.js 18+
- Docker & Docker Compose
- Maven 3.8+

### Démarrage avec Docker Compose

```bash
# Cloner le repository
git clone https://github.com/amine-ghazoui/Ghazoui.git
cd Ghazoui

# Lancer tous les services
docker-compose up -d

# Vérifier les services
docker-compose ps
```

### Démarrage Manuel

```bash
# 1. Config Service
cd config-service
mvn spring-boot:run

# 2. Discovery Service
cd discovery-service
mvn spring-boot:run

# 3. Gateway Service
cd gateway-service
mvn spring-boot:run

# 4. Keynote Service
cd keynote-service
mvn spring-boot:run

# 5. Conference Service
cd conference-service
mvn spring-boot:run

# 6. Frontend Angular
cd frontend
npm install
ng serve
```

## 🌐 URLs d'Accès

| Service | URL | Description |
|---------|-----|-------------|
| Frontend | http://localhost:4200 | Application Angular |
| Gateway | http://localhost:8888 | API Gateway |
| Eureka Dashboard | http://localhost:8761 | Service Discovery |
| Keynote Service | http://localhost:8081/swagger-ui.html | API Keynotes |
| Conference Service | http://localhost:8082/swagger-ui.html | API Conferences |
| Keycloak | http://localhost:8080 | Identity Provider |

## 📚 Documentation API

Chaque microservice expose sa documentation OpenAPI :
- Keynote Service : http://localhost:8081/swagger-ui.html
- Conference Service : http://localhost:8082/swagger-ui.html

## 🔧 Configuration

Les fichiers de configuration sont centralisés dans le dossier `config-repo/` :
- `keynote-service.yml`
- `conference-service.yml`
- `gateway-service.yml`


## 🎯 Fonctionnalités Implémentées

✅ Architecture microservices complète  
✅ Service Discovery avec Eureka  
✅ API Gateway avec Spring Cloud Gateway  
✅ Configuration centralisée  
✅ Communication inter-services avec OpenFeign  
✅ Circuit Breaker avec Resilience4J  
✅ Documentation API avec OpenAPI/Swagger  
✅ Sécurité OAuth2/OIDC avec Keycloak  
✅ Frontend Angular responsive  
✅ Conteneurisation Docker  
✅ Orchestration Docker Compose  
✅ Pipeline CI/CD (Jenkinsfile)


---

*Dernière mise à jour : Décembre 2024*
