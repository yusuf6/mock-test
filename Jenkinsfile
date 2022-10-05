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
                sh 'docker build -t mock-test .'
            }
        }

        stage("Push Docker Image") {
            steps {
                script{
                    withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerhub-pwd')]) {
                        sh 'docker login -u yuf4u -p ${dockerhub-pwd}'
                    }
                }
                sh 'docker push mock-test'
            }
        }
    }
}