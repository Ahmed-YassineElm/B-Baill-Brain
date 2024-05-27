FROM openjdk:17-jdk-alpine
WORKDIR /opt/userservice
ENV PORT 8077
EXPOSE 8077
COPY target/*.jar /opt/userservice/app.jar
ENTRYPOINT exec java $JAVA_OPT -jar app.jar