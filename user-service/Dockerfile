FROM maven:latest AS build

COPY settings-template.xml /usr/share/maven/ref/settings.xml
COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
#RUN /bin/bash -c 'sed -i "s|MAVEN_USERNAME|${MAVEN_USERNAME}|g" /usr/share/maven/ref/settings.xml && \
#                  sed -i "s|MAVEN_PASSWORD|${MAVEN_PASSWORD}|g" /usr/share/maven/ref/settings.xml && \
#                  mvn --settings /usr/share/maven/ref/settings.xml clean install'

RUN --mount=type=cache,target=/root/.m2  mvn --settings /usr/share/maven/ref/settings.xml clean package -Dmaven.test.skip

FROM eclipse-temurin:latest

WORKDIR /app

COPY --from=build /build/target/user-service-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]
