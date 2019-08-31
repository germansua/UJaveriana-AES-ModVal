#!/bin/bash
export JAVA_TOOL_OPTIONS="-XX:+PrintGC -XX:+FlightRecorder -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/tmp/data-streams.hprof"
./gradlew clean build
java -Xms16m -Xmx16m -jar build/libs/data-streams.jar