# Stage 1: Build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/PrepX-Backend-0.0.1-SNAPSHOT.jar PrepX.jar
ENTRYPOINT ["java", "-jar", "PrepX.jar"]
