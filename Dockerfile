FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY . /app

RUN javac Notecards/src/*.java

CMD ["java", "-cp", "src", "Main"]