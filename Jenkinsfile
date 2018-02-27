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
        stage('MakeDeb'){
            steps{
		            sh '''mkdir -p target/etc/systemd/system
                    mkdir -p target/usr/bin
                    cp target/yatbrpg-0.0.1-SNAPSHOT.jar target/usr/bin'''

                    writeFile file: 'target/etc/systemd/system/yatbrpg.service', text: '''[Unit]
                    Description=Yatbrpg app	
                    After=syslog.target	
	
                    [Service]	
                    SyslogIdentifier=yatbrpg	
                    ExecStart=/usr/bin/yatbrpg-0.0.1-SNAPSHOT.jar	
                    User=root
                    Type=simple	
	
                    [Install]	
                    WantedBy=multi-user.target'''

                    writeFile file: 'target/script', text: '''#!/bin/bash
                    systemctl daemon-reload
                    systemctl enable yatbrpg.service
                    chmod 777 usr/bin/yatbrpg-0.0.1-SNAPSHOT.jar'''

                    sh '''cd target
                    fpm -s dir -t deb -n yatbrpg --deb-no-default-config-files --force --after-install script etc usr'''

            }
        }
    }
}

