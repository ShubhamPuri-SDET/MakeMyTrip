            
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Sample Pipeline code'
            }
        }
        stage('Test') {
            steps {
                echo 'Test Instances are executing'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Build has been deployed to prod'
            }
        }
    }
    
    post 
    {
        always
        {
            mail bcc: '', body: 'Test Pipeline project', cc: '', from: '', replyTo: '', subject: 'Pipeline status', to: 'qatest2951@gmail.com'
        }
    }
}
