# FROM openjdk:8

# ARG PROFILE
# ARG ADDITIONAL_OPTS

# ENV PROFILE="dev"
# ENV ADDITIONAL_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -Xmx1G -Xms128m -XX:MaxMetaspaceSize=128m"

# WORKDIR /opt/spring_boot

# COPY ./target/springboot*.jar elo7_tm.jar

# SHELL ["/bin/sh", "-C"]

# EXPOSE 5005
# EXPOSE 8080

# CMD java ${ADDITIONAL_OPTS} -jar elo7_tm.jar --spring.profile.active=${PROFILE}

FROM openjdk:8-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
