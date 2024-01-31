FROM amazoncorretto:11-alpine-jdk
MAINTAINER dac
COPY target/dac-0.0.1-SNAPSHOT.jar  dac-app.jar 
ENTRYPOINT ["java","-jar","/dac-app.jar"] 