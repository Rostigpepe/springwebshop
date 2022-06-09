FROM maven:3.8.5 AS maven

WORKDIR /usr/src/app
COPY pom.xml ./
COPY . /usr/src/app

RUN mvn clean install
RUN mvn -f /usr/src/app/pom.xml clean package


FROM openjdk:17

ARG JAR_FILE=api.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app
EXPOSE 8080
ENTRYPOINT ["java","-jar","api.jar"]