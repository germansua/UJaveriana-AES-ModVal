#!/bin/bash
# Clean and build the project
./gradlew clean build
java -Xms8m -Xmx8m -jar build/libs/soft-waek-references.jar