pipeline {
    agent any

    tools{
        maven 'maven'
    }


    stages {
        stage('Build backend') {
            steps {
                dir('BackEnd-no-context/yaa-khayer'){
                    bat "mvn clean install -DskipTests"
                }
            }
        }
        stage('Test Backend') {
            steps {
                dir('BackEnd-no-context/yaa-khayer'){
                    bat "mvn test"
                }
            }
        }
        stage('Build Docker Image'){
            steps{
                dir('BackEnd-no-context/yaa-khayer'){
                    bat "docker build -t yaa-khayer-backend:latest ."
                }
            }
        }
        stage{
            steps{
               withCredentials([usernamePassword(credentialsId: 'DOCKERHUBCREDENTIALS', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    bat "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"

                    bat "docker push yaa-khayer-backend:latest"
                }
            }
        }
        stage('Test the access to front repository'){
            steps {
                dir('Frontend/yaa-khayer-front'){
                    bat "cat file.txt"
                }
            }
        }
    }
}