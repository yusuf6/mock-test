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
//         stage("Build Docker Image") {
//             steps {
//                 sh 'docker build -t mock-test .'
//             }
//         }
//
//         stage("Push Docker Image") {
//             steps {
//                 script{
//                     withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerhub-pwd')]) {
//                         sh 'docker login -u yuf4u -p ${dockerhub-pwd}'
//                     }
//                 }
//                 sh 'docker push mock-test'
//             }
//         }

       stage ('Docker Build') {
         // Build and push image with Jenkins' docker-plugin
            withDockerRegistry([credentialsId: "dockerhub", url: "https://index.docker.io/v1/"]) {
            image = docker.build("yusuf/mock-test", ".")
            image.push()
            }
        }

      stage ('K8S Deploy') {
        kubernetesDeploy(
            configs: 'deployments/prod-lb.yaml',
            kubeconfigId: 'K8S',
            enableConfigSubstitution: true
            )
        }
    }
}