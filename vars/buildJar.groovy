#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t mrmxvlasov/demo-jma-app .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push mrmxvlasov/demo-jma-app'
    }
}