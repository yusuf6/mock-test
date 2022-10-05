pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage("Build Maven") {
            steps {
                checkout scm
                sh 'mvn clean install'
            }
        }
        stage("Build Docker Image") {
            steps {
                sh 'docker build -t yusuf/mock-test .'
            }
        }
    }
}