FROM openjdk:8u171-jre-alpine3.8
LABEL maintainer="https://github.com/silencecorner"
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
EXPOSE 9000