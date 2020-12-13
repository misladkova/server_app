FROM mcr.microsoft.com/java/jre-headless:11-zulu-ubuntu

COPY serverApp-1.0-SNAPSHOT-jar-with-dependencies.jar /opt/api-server.jar

EXPOSE 8088

CMD ["java", "-jar", "/opt/api-server.jar"]
