#!/bin/bash
export JAVA_TOOL_OPTIONS="-XX:+PrintGC -XX:+FlightRecorder -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/tmp/fork-join-fw.hprof"
./gradlew clean build
java -Xms16m -Xmx16m -jar build/libs/fork-join-fw.jar