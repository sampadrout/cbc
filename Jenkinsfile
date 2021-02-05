pipeline {
    agent any
    tools {
        maven 'Maven'
    }
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
                sh "java -javaagent:\"target/libs/aspectjweaver.jar\" -cp target/accel-agent-ui-test-suite-1.0-SNAPSHOT.jar:target/accel-agent-ui-test-suite-1.0-SNAPSHOT-tests.jar:target/libs/* -DHUB_HOST=192.168.29.71 -Dheadless=true -Denvironment=${environment} org.testng.TestNG src/test/resources/testng.xml"
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