FROM amazoncorretto:11-alpine-jdk //de que imagen partimos
MAINTAINER DAC //quien es el dueño
COPY target/dac-0.0.1-SNAPSHOT.jar dac-app.jar       //va a copiar el empaquetado a github
ENTRYPOINT ["java","-jar","/dac-app.jar"]  //es la instruccion que se va a ejecutar primero