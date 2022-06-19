FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-1.1-RELEASE.jar
ENTRYPOINT ["java","-jar","/customer-1.1-RELEASE.jar"]
EXPOSE 9001