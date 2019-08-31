#!/bin/bash
export JAVA_TOOL_OPTIONS="-XX:+PrintGC -XX:+FlightRecorder -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/tmp/io-byte-stream.hprof"
./gradlew clean build
java -Xms16m -Xmx16m -jar build/libs/io-byte-streams.jar $1