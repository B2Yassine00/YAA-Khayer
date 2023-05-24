pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }


    stages {
        stage('Build backend') {
            steps {
                dir('backend'){
                    sh "cd /BackEnd-no-context/yaa-khayer"
                    sh "${MAVEN_HOME}/bin/mvn clean package"
                }
            }
        }
        stage('Test Backend') {
            steps {
                dir('Backend'){
                    sh "cd /BackEnd-no-context/yaa-khayer"
                    sh "${MAVEN_HOME}/bin/mvn test"
                }
            }
        }
    }
}