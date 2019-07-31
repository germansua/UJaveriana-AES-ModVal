#!/bin/bash
FILE_NAME="$1"
if [[ -z "$FILE_NAME" ]]; then
    echo "Not file to process provided"
else
    ./gradlew clean build
    java -Xms64m -Xmx64m -jar build/libs/memory-management.jar ${FILE_NAME}

    if [[ "$OSTYPE" == "linux-gnu" ]]; then # Linux
        echo "$(md5sum ${FILE_NAME}.gz)"
    elif [[ "$OSTYPE" == "darwin"* ]]; then # MacOS
        echo "$(md5 ${FILE_NAME}.gz)"
    else
        echo "Unknown OS"
    fi
fi