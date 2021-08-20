FROM openjdk:11-jdk-slim-buster

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        tzdata && \
    rm -rf /var/lib/apt/lists/*

ENV TZ America/Sao_Paulo

RUN echo $TZ > /etc/timezone

RUN dpkg-reconfigure -f noninteractive tzdata

COPY build/libs/* /deployments/libs/
COPY build/libs/*-SNAPSHOT.jar /deployments/app.jar

WORKDIR /deployments

ENTRYPOINT ["sh", "-c", "java -jar /deployments/app.jar"]
