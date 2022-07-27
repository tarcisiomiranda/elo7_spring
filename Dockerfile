FROM openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /target/sprint-boot*.jar elo7_tm.jar

SHELL ["/bin/sh", "-C"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar elo7_tm.jar --spring.profile.active=${PROFILE}
