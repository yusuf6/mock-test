pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    
    stages {
        stage("Checkout SCM") {
            steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'githubcredential', url: 'https://github.com/yusuf6/mock-test.git']]])    
            }
        }
        stage("Build Maven") {
            steps {
                bat 'mvn -v'
                bat 'mvn clean install'
            }
        }

       stage ('Docker Build') {
         steps {
             script {
                withDockerRegistry([credentialsId: "dockerhub", url: ""]) {
                        def image = docker.build("yuf4u/mock-test", ".")
                        image.push()
                    }
                }
            }
        }

    stage ('K8S Deploy') {
        steps {
            script {
                withKubeConfig(caCertificate: '', clusterName: '', contextName: '', credentialsId: 'K8S', namespace: '', serverUrl: '') {
                    bat 'kubectl apply -f deployments/prod-lb.yaml'
                    }
                }
            }
        }
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
