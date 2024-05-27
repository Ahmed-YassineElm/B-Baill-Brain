FROM openjdk:17-jdk-alpine
WORKDIR /opt/basketballservice
ENV PORT 8083
EXPOSE 8083
COPY target/*.jar /opt/basketballservice/app.jar
ENTRYPOINT exec java $JAVA_OPT -jar app.jar