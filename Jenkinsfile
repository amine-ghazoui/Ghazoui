pipeline {
    agent any

    environment {
        SERVICES = "gateway-service config-service discovery-service keynote-service conference-service" // liste des microservices
        FRONTEND_DIR = "frontend"
        DEPLOY_DIR = "C:/jenkins-deploy"
        JAVA_HOME = "C:/Program Files/Java/jdk-21" // adapte selon ton système
        PATH = "${env.JAVA_HOME}/bin;${env.PATH}"
    }

    stages {

        stage('📥 Checkout du code') {
            steps {
                echo 'Clonage du dépôt Git...'
                checkout scm
            }
        }

        stage('⚙️ Build des microservices') {
            steps {
                script {
                    for (service in SERVICES.split(' ')) {
                        echo "➡️ Build du microservice : ${service}"
                        dir(service) {
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
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        stage('🚀 Déploiement local') {
            steps {
                echo 'Copie des fichiers générés vers le dossier de déploiement...'
                bat "mkdir ${DEPLOY_DIR} || echo dossier existe déjà"

                script {
                    for (service in SERVICES.split(' ')) {
                        bat "copy ${service}\\target\\*.jar ${DEPLOY_DIR}\\${service}.jar"
                    }
                }

                bat "xcopy ${FRONTEND_DIR}\\dist ${DEPLOY_DIR}\\frontend /E /I /Y"
            }
        }
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
