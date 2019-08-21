#!/bin/bash
if [[ -z $1 ]]; then
    echo "Invalid times parameter"
    exit 1
fi

./gradlew clean build

case $1 in
    "1")
        java -Xms24m -Xmx240m -jar build/libs/simple-thread.jar 10
    ;;
    "2")
        java -Xms24m -Xmx240m -jar build/libs/simple-thread.jar 1000
    ;;
    "3")
        java -Xms24m -Xmx240m -jar build/libs/simple-thread.jar 100000
    ;;
esac