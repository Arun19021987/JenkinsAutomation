pipeline {
			agent {
		    node {
			label 'master'
			customWorkspace 'F:/JenkinsWorkSpace'
		    }
		}
    stages {
        
		stage('Build') {
		      steps{
			  withAnt(installation: 'Ant', jdk: 'JDK') {
				    bat "ant buildear"
				}
			  }
		}
		stage('config'){
		    steps{
		        withAnt(installation: 'Ant', jdk: 'JDK') {
				    bat "ant config"
				    bat "ant Appconfig"
				}
			    
		    }
		  }
		 stage('Deploy') {
		     steps{
		         
			     script{
					def rootDir=pwd() 
				     String jsonPath=rootDir + "/Jenkins.json"
				     def pipeline = load 'GroovyFile.groovy'
				     def flag = pipeline.JsonFile(jsonPath)
				     if(flag == "Y"){
						     withAnt(installation: 'Ant', jdk: 'JDK') {
							    bat "ant -DLTEConfig=F:/JenkinsWorkSpace/JenkinsDemo/Environments/config.xml Staging"
							}
				     }
				     else{
					  withAnt(installation: 'Ant', jdk: 'JDK') {
							    bat "ant Deploy"
							}
				     }
				     
			     }
			     
		     }
		 }
		}
}
