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
        stage('PushToGitlab'){
            steps{
                sshagent (credentials: ['gitlab_ssh']) {
                    sh 'git tag ${BUILD_NUMBER}'
                    sh 'git push git@gitlab.com:Dropsu/yatbrg.git HEAD:master' 
                }                
            }
        }
        stage('MakeDeb'){
            steps{
		            sh '''mkdir -p target/deb/etc/systemd/system
                    mkdir -p target/deb/usr/bin
                    cp target/yatbrpg-0.0.1-SNAPSHOT.jar target/deb/usr/bin'''

                    writeFile file: 'target/deb/etc/systemd/system/yatbrpg.service', text: '''[Unit]
                    Description=Yatbrpg app	
                    After=syslog.target	
	
                    [Service]	
                    SyslogIdentifier=yatbrpg	
                    ExecStart=/usr/bin/yatbrpg-0.0.1-SNAPSHOT.jar	
                    User=root
                    Type=simple	
	
                    [Install]	
                    WantedBy=multi-user.target'''

                    writeFile file: 'target/deb/script', text: '''#!/bin/bash
                    systemctl daemon-reload
                    systemctl enable yatbrpg.service
                    chmod 777 usr/bin/yatbrpg-0.0.1-SNAPSHOT.jar'''

                    sh '''cd target/deb
                    fpm -s dir -t deb -n yatbrpg --deb-no-default-config-files --force --after-install script etc usr'''

            }
        }
        stage('MakeRpm'){
            steps{
		            sh '''mkdir -p target/rpm/etc/systemd/system
                    mkdir -p target/rpm/opt/yatbrpg
                    cp target/yatbrpg-0.0.1-SNAPSHOT.jar target/rpm/opt/yatbrpg'''

                    writeFile file: 'target/rpm/etc/systemd/system/yatbrpg.service', text: '''[Unit]
                    Description=Yatbrpg app	
                    After=syslog.target	
	
                    [Service]	
                    SyslogIdentifier=yatbrpg	
                    ExecStart=/opt/yatbrpg/yatbrpg-0.0.1-SNAPSHOT.jar	
                    User=root
                    Type=simple	
	
                    [Install]	
                    WantedBy=multi-user.target'''

                    writeFile file: 'target/rpm/script', text: '''#!/bin/bash
                    systemctl daemon-reload
                    systemctl enable yatbrpg.service
                    chmod 777 opt/yatbrpg/yatbrpg-0.0.1-SNAPSHOT.jar'''

                    sh '''cd target/rpm
                    fpm -s dir -t rpm -n yatbrpg --deb-no-default-config-files --force --after-install script etc opt'''

            }
        }
                
    }
}

