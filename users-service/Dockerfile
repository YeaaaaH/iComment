FROM openjdk:13-jdk-alpine
EXPOSE 8083
ADD build/libs/users-service-0.0.1-SNAPSHOT.jar users-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/users-service.jar"]