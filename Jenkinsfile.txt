pipeline {
    agent any
    stages {
        stage('Compile Stage') {
            steps{
                withMaven (maven :Maven_3_8_6) {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Testing Stage') {
            steps{
                withMaven (maven :Maven_3_8_6) {
                    sh 'mvn test'
                }
            }
        }
        stage('Deployment Stage') {
            steps{
                withMaven (maven :Maven_3_8_6) {
                    sh 'mvn deploy'
                }
            }
        }
        
    }
}
