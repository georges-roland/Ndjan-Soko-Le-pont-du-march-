#!/usr/bin/env bash
set -e

docker compose up -d
mvn spring-boot:run -Dspring-boot.run.profiles=postgres
