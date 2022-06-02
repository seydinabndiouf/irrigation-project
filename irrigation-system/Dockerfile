FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM amazoncorretto:11-alpine-jdk

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/irrigation-system-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "irrigation-system-0.0.1-SNAPSHOT.jar"]