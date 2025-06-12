FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/PrepX-Backend-0.0.1-SNAPSHOT.jar PrepX.jar
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8080}", "-jar", "PrepX.jar"]