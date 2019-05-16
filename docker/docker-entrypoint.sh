#!/bin/sh

_term() {
  echo "Caught SIGTERM or SIGINT signal!"
  kill $child
  wait $child
  exit $?
}

trap _term SIGINT SIGTERM

# run uberjar app

java -Dmsp.env=gcp -Dspring.profiles.active=${PROFILE} -jar /opt/macys/pricechangewriterservice.jar  &

child=$!
wait $child

