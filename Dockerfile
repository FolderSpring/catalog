FROM openjdk:8
ADD catalog.jar catalog.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "catalog.jar"]