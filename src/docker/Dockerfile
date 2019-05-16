FROM ci-artifacts.devops.fds.com/docker-infrastructure/debian-openjdk-custommacyscerts:0.0.1

ARG ARTIFACT_PATH=./pricechangewriterservice*.jar

ENV \
    CONFIG_FILE='' \
    PROFILE=''


ENV D_USER=macys \
    D_GROUP=macys \
    D_UID=6000 \
    D_GID=6000

# create unprivileged user
RUN addgroup --gid ${D_GID} ${D_GROUP} && \
    adduser --uid ${D_UID} --gid ${D_GID} --home /opt/macys --disabled-password --gecos "" ${D_USER}

EXPOSE 8080

COPY ${ARTIFACT_PATH} /opt/macys/pricechangewriterservice.jar
COPY docker-entrypoint.sh /usr/local/bin/

RUN chown -R ${D_USER}:${D_GROUP} /opt/macys/ && \
    chmod 555 /usr/local/bin/docker-entrypoint.sh

USER ${D_USER}
WORKDIR /opt/macys/

ENTRYPOINT ["docker-entrypoint.sh"]

#HEALTHCHECK --interval=1m --timeout=20s --retries=5 CMD curl --fail http://localhost:8080/actuator/health || exit 1

