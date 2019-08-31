#!/bin/bash
export JAVA_TOOL_OPTIONS="-XX:+PrintGC -XX:+FlightRecorder -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/tmp/io-character-streams.hprof"
./gradlew clean build
java -Xms16m -Xmx16m -jar build/libs/io-character-streams.jar $1