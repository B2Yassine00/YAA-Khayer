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
                    bat "docker build -t byassine00/yaa-khayer-backend:latest ."
                }
            }
        }
        stage('Push Backend Image'){
            steps{
               withCredentials([usernamePassword(credentialsId: 'DOCKERHUBCREDENTIALS', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    bat "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
                    bat "docker pull byassine00/yaa-khayer-backend:latest"
                    bat "docker push byassine00/yaa-khayer-backend:latest"
                }
            }
        }
        stage('Build Frontend'){
            steps {
                dir('Frontend/yaa-khayer-front'){
                    bat "npm install"
                    bat "npm build"
                }
            }
        }
        stage('Deploy NGINX'){
            steps{
                dir('Frontend/yaa-khayer-front'){
                    bat 'docker pull nginx:1.21.3'
                    bat 'docker run -d -p 80:80 --name my-nginx-container -v %cd%:/usr/share/nginx/html nginx:1.21.3'
                }
            }
        }
        stage('Build Front Docker Image'){
            steps{
                dir('Frontend/yaa-khayer-front'){
                    bat "docker build -t byassine00/yaa-khayer-frontend:latest ."
                }
            }
        }
        stage('Push Frontend Image'){
            steps{
               withCredentials([usernamePassword(credentialsId: 'DOCKERHUBCREDENTIALS', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    bat "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
                    bat "docker push byassine00/yaa-khayer-frontend:latest"
                }
            }
        }
    }
}