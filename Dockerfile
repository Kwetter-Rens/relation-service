FROM openjdk:17-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} social-graph-service.jar

ENTRYPOINT ["java", "-jar", "social-graph-service.jar"]