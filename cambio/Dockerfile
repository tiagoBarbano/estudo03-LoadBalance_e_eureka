FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/cambio-0.0.1-SNAPSHOT.jar cambio-0.0.1-SNAPSHOT.jar
EXPOSE 8004
ENTRYPOINT exec java $JAVA_OPTS -jar cambio-0.0.1-SNAPSHOT.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar cambio-0.0.1-SNAPSHOT.jar
