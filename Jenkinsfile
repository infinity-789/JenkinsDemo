pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'C:/Users/BNMIT/AppData/Local/Programs/Python/Python314/python bin_search.py'
      }
    }

    stage('Test') {
      steps {
        echo 'Testing..'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying....'
      }
    }

  }
}