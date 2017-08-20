JAVA_MEM_OPTS=" -server -Xmx2g -Xms2g -Xmn256m  -Xss256k"
/opt/java/jdk1.8.0_112/bin/java $JAVA_MEM_OPTS -jar -Dspring.profiles.active=produce verify-process-0.0.1-SNAPSHOT.jar &
