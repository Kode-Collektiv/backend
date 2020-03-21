#########################
### build environment ###
#########################

FROM maven:3-jdk-11-openj9 AS build

COPY src /srv/backend/src

COPY pom.xml /srv/backend

RUN mvn -f /srv/backend/pom.xml clean package -DskipTests

##################
### production ###
##################

FROM openjdk:11.0-slim

COPY --from=build /srv/backend/target/backend-0.0.1-SNAPSHOT.jar /srv/backend/backend-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/srv/backend/backend-0.0.1-SNAPSHOT.jar"]
