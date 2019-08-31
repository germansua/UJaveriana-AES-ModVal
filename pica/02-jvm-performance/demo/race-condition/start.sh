#!/bin/bash
./gradlew clean build
java -jar build/libs/race-condition.jar $1