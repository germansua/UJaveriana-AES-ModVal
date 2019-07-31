#!/bin/bash

ARG="$1"
if [[ -z "$ARG" ]]; then
    echo "Invalid argument"
else
    # Clean and build the project
    ./gradlew clean build

    # Run one of the scenarios
    case $ARG in
        # Invalid
        "0")
            java -XX:StringTableSize=0 -XX:+PrintStringTableStatistics -jar build/libs/string-interning.jar $2
            ;;
        # Really Bad one
        "1")
            java -XX:StringTableSize=1009 -XX:+PrintStringTableStatistics -jar build/libs/string-interning.jar $2
            ;;
        # A bit better, but not that better
        "2")
            java -XX:StringTableSize=5087 -XX:+PrintStringTableStatistics -jar build/libs/string-interning.jar $2
            ;;
        # JVM's default
        "3")
            java -XX:+PrintStringTableStatistics -jar build/libs/string-interning.jar $2
            ;;
        # Better
        "4")
            java -XX:StringTableSize=2234129 -XX:+PrintStringTableStatistics -jar build/libs/string-interning.jar $2
            ;;
        # Huge One
        "5")
            java -XX:StringTableSize=8958797 -XX:+PrintStringTableStatistics -jar build/libs/string-interning.jar $2
            ;;
    esac
fi