#!/bin/bash
./gradlew clean build
java -Xms64m -Xmx64m -jar build/libs/memory-leak-simulation.jar