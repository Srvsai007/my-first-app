pipeline {
    agent any

    tools {
        maven 'Maven-3.9.10' // Use the Maven version configured in Jenkins
    }

    environment {
        REPO_URL = 'https://github.com/Srvsai007/my-first-app'
        BRANCH = 'main'
    }

    options {
        ansiColor('xterm') // Enables colored output
        timestamps()       // Adds timestamps to logs
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${BRANCH}", url: "${REPO_URL}"
                echo 'Repository cloned successfully!'
                bat 'dir'
            }
        }

        stage('Build') {
            steps {
                echo 'Starting Maven build...'
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application...'
                bat 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo 'Archiving artifacts...'
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