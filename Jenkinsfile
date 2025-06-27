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
        timestamps() // Adds timestamps to logs
    }

    stages {
        stage('Checkout') {
            steps {
                ansiColor('xterm') {
                    git branch: "${BRANCH}", url: "${REPO_URL}"
                    echo 'Repository cloned successfully!'
                    bat 'dir'
                }
            }
        }

        stage('Build') {
            steps {
                ansiColor('xterm') {
                    echo 'Starting Maven build...'
                    bat 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                ansiColor('xterm') {
                    echo 'Running tests...'
                    bat 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                ansiColor('xterm') {
                    echo 'Packaging application...'
                    bat 'mvn package'
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                ansiColor('xterm') {
                    echo 'Archiving artifacts...'
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Push JAR to GitHub') {
            steps {
                ansiColor('xterm') {
                    script {
                        // Ensure the artifact directory exists
                        bat 'mkdir artifact || exit 0'

                        // Copy the JAR file to the artifact directory
                        bat 'copy target\\*.jar artifact\\'

                        // Configure Git
                        bat 'git config user.name "Jenkins"'
                        bat 'git config user.email "jenkins@example.com"'

                        // Add the JAR file to the repository
                        bat 'git add artifact\\*.jar'
                        bat 'git commit -m "Add JAR file from Jenkins build"'
						
						bat 'git push https://github.com/Srvsai007/my-first-app.git main'
                        // Push changes to GitHub using Jenkins credentials
                       // withCredentials([usernamePassword(credentialsId: 'github-token', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
                         //   bat "git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/Srvsai007/my-first-app.git ${BRANCH}"
                        //}
                    }
                }
            }
        }
    }

    post {
        success {
            ansiColor('xterm') {
                echo 'Pipeline completed successfully!'
            }
        }
        failure {
            ansiColor('xterm') {
                echo 'Pipeline failed. Please check the logs.'
            }
        }
    }
}