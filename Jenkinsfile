pipeline {
    agent any

    stages {

        stage('Clone GitHub Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/bensaadamine/devops_project.git'
            }
        }

        stage('Build & Test with Maven') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}

