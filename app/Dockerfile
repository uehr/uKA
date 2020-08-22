FROM maven:3-jdk-8-alpine

RUN echo "Build jar"
RUN echo '{ "allow_root": true }' > /root/.bowerrc
WORKDIR /code

# 依存関係の解決
ADD pom.xml .
RUN mvn -B dependency:go-offline clean

# ソースコードのビルド
ADD . .
RUN mvn -B clean package -DskipTests
RUN mv /code/target/*.jar /app.war

FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    SLEEP=0

ENV PORT 80
EXPOSE 80

RUN apk update && apk upgrade \
    && apk --update add tzdata nss \
    && apk add --no-cache git \
    && apk add --no-cache curl

CMD echo "The application will start in ${SLEEP}s..." && \
    curl -s https://ifconfig.me
    sleep ${SLEEP} && \
    java -Xmx512m -XX:TieredStopAtLevel=1 -Djava.security.egd=file:/dev/./urandom -jar /app.war && \
COPY --from=0 /app.war .