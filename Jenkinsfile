pipeline {
    agent{
        docker { image 'maven:3.8.5-openjdk-17-slim' }
    }

    tools{
        maven 'maven'
        jdk 'Java17'
    }
    
    triggers {
        pollSCM '* * * * *'
    }


    stages {
        stage('Build backend') {
            steps {
                dir('BackEnd-no-context/yaa-khayer'){
                    sh "${MAVEN_HOME}/bin/mvn clean package -DskipTests"
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
            agent any
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