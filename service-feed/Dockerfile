FROM openjdk:17-jdk-alpine
WORKDIR /opt/feedservice
ENV PORT 8089
EXPOSE 8089
COPY target/*.jar /opt/feedservice/app.jar
ENTRYPOINT exec java $JAVA_OPT -jar app.jar