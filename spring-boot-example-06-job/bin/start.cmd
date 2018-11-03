echo off
echo %~dp0

java -verbose:gc -Xmx32m -Xms32m -XX:-PrintGCDetails -jar ../target/spring-boot-example-06-job-0.0.1-SNAPSHOT.jar