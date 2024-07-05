FROM maven:latest AS build

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn clean install

FROM eclipse-temurin:latest

WORKDIR /app

COPY --from=build /build/target/api-gateway-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "api-gateway-0.0.1-SNAPSHOT.jar"]
