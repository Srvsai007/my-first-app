pipeline {
    agent any

    tools {
        maven 'Maven-3.9.10' // Use the Maven version configured in Jenkins
    }

    environment {
        REPO_URL = 'https://github.com/Srvsai007/my-first-app'
        BRANCH = 'main'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git branch: "${BRANCH}", url: "${REPO_URL}"
				echo 'Repository cloned successfully!'
				bat 'dir'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
				echo 'Starting Maven build...'	
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run Maven tests
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the application
                bat 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Archive the JAR file
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check the logs.'
        }
    }
}