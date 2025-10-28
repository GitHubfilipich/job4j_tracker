# Этап 1 - сборка проекта в jar и применение миграций

FROM maven:3.6.3-openjdk-17 as builder

RUN mkdir job4j_tracker

WORKDIR job4j_tracker

COPY . .

RUN mvn package -Dmaven.test.skip=true

# Этап 2 - указание как запустить проект

FROM openjdk:17.0.2-jdk

WORKDIR job4j_tracker

COPY --from=builder job4j_tracker/target/Tracker.jar app.jar

CMD ["java", "-jar", "app.jar"]
