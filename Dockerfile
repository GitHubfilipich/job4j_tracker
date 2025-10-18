FROM maven:3.6.3-openjdk-17

RUN mkdir job4j_tracker

WORKDIR job4j_tracker

COPY . .

RUN mvn package -Dmaven.test.skip=true

RUN chmod +x entrypoint.sh

CMD ["./entrypoint.sh"]
