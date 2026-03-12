pipeline {
    agent any

    tools {
        maven 'Default' 
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // JaCoCo will automatically attach to this execution
                bat 'mvn test -Dtest=CalculatorTest'
            }
            post {
                always {
                    // 1. Archive JUnit results
                    junit testResults: '**/target/surefire-reports/*.xml'
                    
                    // 2. Record JaCoCo Coverage
                    // This creates the "Code Coverage" link and trend graph in Jenkins
                    jacoco(
                        execPattern: '**/target/jacoco.exec',
                        classPattern: '**/target/classes',
                        sourcePattern: '**/src/main/java',
                        inclusionPattern: '**/*.class'
                    )
                }
            }
        }
    }

    post {
        success {
            echo 'Build, Tests, and Coverage analysis completed successfully!'
        }
        failure {
            echo 'Something went wrong. Check the logs, JUnit, and JaCoCo reports.'
        }
    }
}
