pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                script {
                    try {
                        sh 'docker stop frontend_ca'
                    }
                    catch (err) {
                        echo "Warning: no such container frontend_ca"
                    }
                    try {
                        sh 'docker rm frontend_ca'
                    }
                    catch (err) {
                        echo "Warning: no such container frontend_ca"
                    }
                    try {
                        sh 'docker rmi frontend_ca'
                    }
                    catch (err) {
                        echo "Warning: no such image frontend_ca"
                    }
                }
            }
        }
        stage('Build') { 
            steps {
                sh 'npm install'
                sh 'npm run build'
            }
        }
        stage('Deliver') {
            steps {
                sh 'docker build -t frontend_ca .'
                sh 'docker run -d -p 8081:80 --name frontend_ca frontend_ca'
                sh 'echo "Deliver success"'
            }
        }
    }
}
