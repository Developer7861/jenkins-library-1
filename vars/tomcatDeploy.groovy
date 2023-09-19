def call(ip,creds,warFile){
  // install ssh agent plugin
    sshagent([creds]) {
     // copy war file local to tomcat -dev server
     sh "scp -o StrictHostKeyChecking=no target/${warFile} ec2-user@${ip}:/opt/tomcat9/webapps"
     // restart the tomcat9 server
    sh "ssh ec2-user@${ip} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ec2-user@${ip} /opt/tomcat9/bin/startup.sh"
  }
}
