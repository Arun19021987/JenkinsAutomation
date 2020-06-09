pipeline {
			agent {
		    node {
			label 'master'
			customWorkspace 'F:/JenkinsWorkSpace'
		    }
		}
    stages {
        stage('Git-Checkout') {
            steps {
		   
			     
		    
		    git changelog: false, poll: false, url: 'https://github.com/Arun19021987/JenkinsAutomation.git'
		   
            }
        }
		stage('Build') {
		      steps{
			   ant {
				    target('buildear')
				    prop('logging', 'info')
           			    props('test.threads': 10, 'input.status': 'release')
				    buildFile('Build.xml')
				    
				    antInstallation('Ant')
				}
			  }
		}
		stage('config'){
		    steps{
		        ant {
				    targets(['config', 'Appconfig'])
				    prop('logging', 'info')
           			    props('test.threads': 10, 'input.status': 'release')
				    buildFile('Build.xml')
				    
				    antInstallation('Ant')
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
						     ant {
							    target('Staging')
                                                            prop('logging', 'info')
           			                            props('test.threads': 10, 'input.status': 'release')
							    buildFile('Build.xml')

							    antInstallation('Ant')
						}
				     }
				     else{
					  ant {
							    target('Deploy')
                                                            prop('logging', 'info')
           			                            props('test.threads': 10, 'input.status': 'release')
							    buildFile('Build.xml')

							    antInstallation('Ant')
						}
				     }
				     
			     }
			     
		     }
		 }
		}
}
