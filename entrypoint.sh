#!/bin/sh
mvn liquibase:update -Pdocker
java -jar target/Tracker.jar