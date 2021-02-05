pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script{
                    currentBuild.displayName = "#${BUILD_NUMBER} Environment: ${environment}"
                }
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Run') {
            steps {
                sh "java -javaagent:\"target/libs/aspectjweaver.jar\" -cp target/cbc-ui-0.0.1-SNAPSHOT.jar:target/cbc-ui-0.0.1-SNAPSHOT-tests.jar:target/libs/* -Denvironment=${environment} org.testng.TestNG src/test/resources/testng.xml"
            }
            post {
                always{
                    script {
                        allure([
                                includeProperties: false,
                                jdk: '',
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'allure-results']],
                        ])
                    }
                }
            }
        }
    }
}