#!/bin/bash
./gradlew clean install
java -jar build/libs/performance.jar $1