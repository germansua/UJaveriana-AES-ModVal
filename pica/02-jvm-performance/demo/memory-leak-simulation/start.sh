#!/bin/bash
./gradlew clean build
java -Xms24m -Xmx24m -jar build/libs/memory-leak-simulation.jar $1