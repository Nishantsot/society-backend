FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn clean install

CMD ["java", "-jar", "target/society-backend-0.0.1-SNAPSHOT.jar"]