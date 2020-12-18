FROM adoptopenjdk:11-jre-hotspot as builder
ARG JAR_FILE=build/libs/wry-vault-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} vault.jar
ENTRYPOINT ["java","-Xmx500m","-jar","/vault.jar"]