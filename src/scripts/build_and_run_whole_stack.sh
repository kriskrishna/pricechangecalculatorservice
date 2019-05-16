#!/usr/bin/env bash

export SPRING_DATA_CASSANDRA_CONTACT_POINTS=docker.for.mac.localhost

echo -e "\nExecute Cassandra Docker running script...\n"
scripts/run_docker_cassandra.sh

echo -e "\nExecute price-change-writer Docker running script...\n"
scripts/run_docker.sh
