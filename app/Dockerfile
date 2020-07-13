FROM amazoncorretto:latest

ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-amazon-corretto

EXPOSE 80

ADD . /app
WORKDIR /app
RUN ./mvnw clean package -DskipTests=true
