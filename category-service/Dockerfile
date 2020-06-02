FROM openjdk:13-jdk-alpine
EXPOSE 8081
ADD build/libs/category-service-0.0.1-SNAPSHOT.jar category-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/category-service.jar"]