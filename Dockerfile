FROM eclipse-temurin:17-jdk
LABEL authors="shubhamkarna"
COPY --from=build /target/PrepX-Backend-0.0.1-SNAPSHOT.jar PrepX.jar


EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "PrepX.jar"]