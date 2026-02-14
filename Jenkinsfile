pipeline {
    // Specifies that this pipeline can run on any available agent
    agent any

    // Ensure Maven is available (uses the name configured in 'Global Tool Configuration')
    tools {
        maven 'Maven 3.9' 
    }

    stages {
        stage('Checkout') {
            steps {
                // Automatically checks out code from the SCM (Git)
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Compiles the code and packages it into a JAR
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Executes the JUnit tests
                sh 'mvn test'
            }
            post {
                always {
                    // Uses the JUnit plugin to archive and display test results
                    // Path is standard for Maven projects: target/surefire-reports/
                    junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Tests passed successfully!'
        }
        failure {
            echo 'Build or Tests failed. Please check the logs and JUnit report.'
        }
    }
}
