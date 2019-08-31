#!/bin/bash
JAVA_TOOL_OPTIONS="-XX:+FlightRecorder"
./gradlew clean build
java -jar build/libs/race-condition.jar $1