pipeline {
    agent any

    environment {
        // Liste des microservices
        SERVICES = "gateway-service config-service discovery-service keynote-service conference-service"
        FRONTEND_DIR = "frontend"
        // Utilisation de la syntaxe de chemin Windows standard pour la variable
        DEPLOY_DIR = "C:\\jenkins-deploy"
        // Adapte selon ton système
        JAVA_HOME = "C:/Program Files/Java/jdk-21"
        // Assure que Java est prioritaire dans le PATH
        PATH = "${env.JAVA_HOME}/bin;${env.PATH}"
    }

    stages {

        stage('📥 Checkout du code') {
            steps {
                echo 'Clonage du dépôt Git...'
                // Si le repository est privé, l'agent doit être configuré pour utiliser les credentials
                // checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'VOTRE_URL_GIT', credentialsId: 'github-ci-token']]])
                checkout scm // Utilise la configuration du job, qui inclut déjà les credentials
            }
        }

        stage('⚙️ Build des microservices') {
            steps {
                script {
                    for (service in SERVICES.split(' ')) {
                        echo "➡️ Build du microservice : ${service}"
                        dir(service) {
                            // Nettoyage et packaging sans tests (pour l'instant, pour la rapidité)
                            bat 'mvn clean package -DskipTests'
                        }
                    }
                }
            }
        }

        stage('🧱 Build Frontend (Angular)') {
            steps {
                dir("${FRONTEND_DIR}") {
                    echo 'Build du frontend Angular...'
                    // Assurez-vous que NodeJS est correctement configuré dans Jenkins
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        stage('🚀 Déploiement local') {
            steps {
                echo 'Création du répertoire de déploiement si nécessaire...'
                // CORRECTION : Utilisation de la syntaxe Windows Batch IF NOT EXIST pour créer le répertoire
                bat """
                    IF NOT EXIST "${DEPLOY_DIR}" (
                        mkdir "${DEPLOY_DIR}"
                        echo Dossier de déploiement créé.
                    ) ELSE (
                        echo Dossier de déploiement existe déjà.
                    )
                """

                echo 'Copie des fichiers générés vers le dossier de déploiement...'
                script {
                    for (service in SERVICES.split(' ')) {
                        // Utilisation de la commande copy pour les JARs
                        bat "copy \"${service}\\target\\*.jar\" \"${DEPLOY_DIR}\\${service}.jar\""
                    }
                }

                // Copie récursive du contenu du dossier de build Angular (dist)
                // Note : Vous devrez ajuster le chemin après 'dist' si Angular crée un sous-dossier de nom d'application
                bat "xcopy \"${FRONTEND_DIR}\\dist\" \"${DEPLOY_DIR}\\frontend\" /E /I /Y"
            }
        }

        // --- Étape de DOCKERISATION (Ajout futur) ---
        stage('🐳 Dockeriser') {
            steps {
                echo 'Conteneurisation de tous les microservices et du frontend...'
                // Lancement de Docker Compose pour déployer l'ensemble de l'application
                // Nécessite un fichier docker-compose.yml à la racine du workspace
                // bat 'docker compose up -d' // ou 'docker-compose up -d' selon la version
                echo 'TODO: Lancer Docker Compose ici pour un déploiement complet.'
            }
        }
        // ---------------------------------------------
    }

    post {
        success {
            echo '✅ Tous les microservices et le frontend ont été buildés et déployés avec succès !'
        }
        failure {
            echo '❌ Échec du pipeline. Vérifie les logs Jenkins.'
        }
    }
}