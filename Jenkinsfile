pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
        }
        stage('Test'){
            steps{
                sh 'make check || true' 
                junit '**/target/surefire-reports/*.xml' 
            }
        }
        stage('MakeRpm'){
            steps{
                dir('/target') {
    sh '''mkdir -p etc/systemd/system
mkdir -p usr/bin
cp yatbrpg-0.0.1-SNAPSHOT.jar usr/bin
'''
                    writeFile file: 'etc/systemd/system/Yatbrpg.service', text: '''[Unit]
Description=Yatbrpg app	
After=syslog.target	
	
[Service]	
SyslogIdentifier=yatbrpg	
ExecStart=/usr/bin/yatbrpg-0.0.1-SNAPSHOT.jar	
User=root
Type=simple	
	
[Install]	
WantedBy=multi-user.target'''
}
                
                

            }
        }
    }
}
