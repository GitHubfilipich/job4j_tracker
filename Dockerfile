FROM maven:3.6.3-openjdk-17

RUN mkdir job4j_SQLTracker

WORKDIR job4j_SQLTracker

COPY . .

RUN mvn package -Dmaven.test.skip=true

CMD ["java", "-jar", "target/SQLTracker.jar"]
