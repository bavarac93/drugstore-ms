FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} dms-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/dms-0.0.1-SNAPSHOT.jar"]
