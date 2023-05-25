pipeline {
    agent any

    tools{
        maven 'maven'
        jdk 'Java17'
        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
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