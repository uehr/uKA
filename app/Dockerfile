FROM maven:3-jdk-8-alpine

RUN echo "Build jar"
RUN echo '{ "allow_root": true }' > /root/.bowerrc
WORKDIR /code

RUN apk add npm
RUN npm install -g swagger-merger

# 依存関係の解決
ADD pom.xml .
ADD openapi openapi
# OpenAPI定義をマージ
RUN swagger-merger -i openapi/index.yaml -o  openapi/merged.yaml
RUN mvn -B package -DskipTests --fail-never

# ソースコードのコピー
ADD . .

# ソースコードのビルド
RUN mvn -B package -DskipTests
RUN mv /code/target/*.jar /app.war

FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS

ENV PORT 80
EXPOSE 80

RUN apk update && apk upgrade \
    && apk --update add tzdata nss \
    && apk add --no-cache git \
    && apk add --no-cache curl

CMD echo "Uka app starting..." && \
    curl -s https://ifconfig.me && \
    java -Xmx512m -XX:TieredStopAtLevel=1 -Djava.security.egd=file:/dev/./urandom -jar /app.war

COPY --from=0 /app.war .