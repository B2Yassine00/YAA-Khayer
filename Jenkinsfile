pipeline {
    agent any

    tools{
        maven 'maven'
        jdk 'Java17'
    }
    
    triggers {
        pollSCM '* * * * *'
    }


    stages {
        stage('change the branch'){
            steps { 
                checkout([$class: 'GitSCM', branches: [[name: '*/branch-DEV']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/B2Yassine00/YAA-Khayer']]])
            }
        }
        stage('Build backend') {
            steps {
                dir('BackEnd-no-context/yaa-khayer'){
                    sh "mvn clean install"
                }
            }
        }
        stage('Test Backend') {
            steps {
                dir('BackEnd-no-context/yaa-khayer'){
                    sh "${MAVEN_HOME}/bin/mvn test"
                }
            }
        }
        stage('Build Docker Image'){
            steps{
                dir('BackEnd-no-context/yaa-khayer'){
                    sh "docker build -t yaa-khayer-backend:latest ."
                }
            }
        }
        /*stage{
            steps{
               withCredentials([usernamePassword(credentialsId: 'DOCKERHUBCREDENTIALS', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {

}
            }
        }*/
        stage('Test the access to front repository'){
            steps {
                dir('Frontend/yaa-khayer-front'){
                    sh "cat file.txt"
                }
            }
        }
    }
}
