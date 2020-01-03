pipeline {
  agent any
  stages {
    stage('Melding og sove') {
      steps {
        echo 'Starter'
        sleep 4
      }
    }

    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }

  }
  environment {
    test = '3'
  }
}