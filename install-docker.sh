#!/bin/sh
mvn clean install
docker build -t "tipocambio-docker" .
docker run -d --name bbva-tipocambio-service -p 8080:8080 tipocambio-docker:latest
docker container ls -a
docker container rm bbva-tipocambio-service
docker container stop bbva-tipocambio-service
docker container start bbva-tipocambio-service
