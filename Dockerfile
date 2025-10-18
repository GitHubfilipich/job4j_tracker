FROM maven:3.6.3-openjdk-17

RUN mkdir job4j_tracker

WORKDIR job4j_tracker

COPY . .

RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix entrypoint.sh

RUN mvn package -Dmaven.test.skip=true

RUN chmod +x entrypoint.sh

CMD ["./entrypoint.sh"]
