#!/bin/bash

if [ $# -ne 2 ]; then
    echo "Invalid number of params, necessary 2, factorial and stack size option"
    exit 1
fi

factorial=$1
size=$2

# Clean and build the project
./gradlew clean build

# Run one of the scenarios
case $size in
    # Default 1MB
    "0")
        java -jar build/libs/stack-over-flow.jar $factorial
        ;;
    # Short one
    "1")
        java -Xss256k -jar build/libs/stack-over-flow.jar $factorial
        ;;
    # Big one
    "2")
        java -Xss10m -jar build/libs/stack-over-flow.jar $factorial
        ;;
esac
