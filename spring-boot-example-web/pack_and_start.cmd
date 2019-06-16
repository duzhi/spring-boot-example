call mvn clean package -Dmaven.test.skip=true
echo start app
java -jar target/spring-boot-example-web-0.0.1-SNAPSHOT.jar