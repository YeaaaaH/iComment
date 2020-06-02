FROM openjdk:13-jdk-alpine
EXPOSE 8083
ADD build/libs/feedback-service-0.0.1-SNAPSHOT.jar feedback-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/feedback-service.jar"]