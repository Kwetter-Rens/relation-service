FROM openjdk:17-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} relation-service.jar

ENTRYPOINT ["java", "-jar", "relation-service.jar"]