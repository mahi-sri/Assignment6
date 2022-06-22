pipeline {
    agent any

    tools {
        
        maven "myMaven"
    }

    stages {
        stage('Build')
        {
            steps
            {
                echo 'Building...'
                
                git 'https://github.com/mahi-sri/Assignment6.git'

                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
            
            stage('Test') 
            {
            steps 
                {
                echo 'Testing...'
                }
            }
        
            stage('Deploy') 
        {
            steps 
            {
                echo 'Deploying...'
            }
        }
    }
}
