FROM openjdk:17-jdk-alpine
WORKDIR /opt/uploadservice
ENV PORT 8076
EXPOSE 8076
COPY target/*.jar /opt/uploadservice/app.jar
ENTRYPOINT exec java $JAVA_OPT -jar app.jar