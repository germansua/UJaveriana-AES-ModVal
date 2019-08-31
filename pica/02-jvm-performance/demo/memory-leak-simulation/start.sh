#!/bin/bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home
export JAVA_TOOL_OPTIONS="-XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/var/tmp/memory-leak-simulation.hprof -XX:+PrintGCDetails"
./gradlew clean build
java -Xms24m -Xmx24m -jar build/libs/memory-leak-simulation.jar $1