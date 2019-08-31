#!/bin/bash
export JAVA_TOOL_OPTIONS="-XX:+FlightRecorder -XX:+PrintGC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/tmp/deadlocks.hprof"
./gradlew clean build
java -Xms16m -Xmx16m -jar build/libs/deadlocks.jar $1