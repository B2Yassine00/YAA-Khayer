pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }


    stages {
        stage('Build backend') {
            steps {
                sh "YAA-Khayer/BackEnd-no-context/yaa-khayer"
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }
        stage('Test Backend') {
            steps {
                sh "YAA-Khayer/BackEnd-no-context/yaa-khayer"
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }
    }
}