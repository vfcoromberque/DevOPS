FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/hellodocker-0.0.1-SNAPSHOT.jar /app/
EXPOSE 9320
CMD ["java", "-jar", "target/hellodocker-0.0.1-SNAPSHOT.jar", "--server.port=9320"]
ENTRYPOINT ["java","-jar","/app/hellodocker-0.0.1-SNAPSHOT.jar"]