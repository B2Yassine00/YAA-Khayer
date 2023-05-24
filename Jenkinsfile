pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }


    stages {
        stage('Build backend') {
            steps {
                sh "/BackEnd-no-context/yaa-khayer"
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }
        stage('Test Backend') {
            steps {
                sh "/BackEnd-no-context/yaa-khayer"
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }
    }
}