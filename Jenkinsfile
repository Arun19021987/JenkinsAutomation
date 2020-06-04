pipeline {
    agent any
    stages {
        stage('Git-Checkout') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/Arun19021987/JenkinsAutomation.git'
            }
        }
		stage('Build') {
		      steps{
			     bat label: '', script: 'C:/tibco/tra/5.7/bin/buildear -x -s -ear /Deployment/JenkinsDemo.archive -o F:/Jenkins/JenkinsDemo.ear -p F:/TibcoWS/JenkinsDemo'
			  }
		}
		stage('config'){
		    steps{
		        bat label: '', script: 'C:/tibco/tra/5.7/bin/AppManage -export -out F:/Jenkins/JenkinsDemo.xml  -ear F:/Jenkins/JenkinsDemo.ear'
		    }
		  }
		 stage('Deploy') {
		     steps{
		         bat label: '', script: 'C:/tibco/tra/5.7/bin/AppManage -deploy -ear F:/Jenkins/JenkinsDemo.ear -deployconfig F:/Jenkins/JenkinsDemo.xml -domain arun -user arun -pw arun'
		     }
		 }
		}
}
