#!/bin/bash
echo "Running container on Java8 no flags"
echo "docker run --rm -m 1g openjdk:8u131 java -XshowSettings:vm -version"
docker run --rm -m 1g openjdk:8u131 java -XshowSettings:vm -version

echo "Running container on Java8 limiting RAM flags"
echo "docker run --rm -m 1g openjdk:8u131 java -XX:MaxRAM=1g -XX:MaxRAMFraction=2 -XshowSettings:vm -version"
docker run --rm -m 1g openjdk:8u131 java -XX:MaxRAM=1g -XX:MaxRAMFraction=2 -XshowSettings:vm -version

echo ""
echo "Running container on Java8 adding experimental flags"
echo "docker run --rm -m 1g openjdk:8u131 java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XshowSettings:vm -version"
docker run --rm -m 1g openjdk:8u131 java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XshowSettings:vm -version

echo ""
echo "Running container on Java11 (Container Support enable by default)"
echo "docker run --rm -m 1g openjdk:11.0 java -XshowSettings:vm -version"
docker run --rm -m 1g openjdk:11.0 java -XshowSettings:vm -version

echo ""
echo "Running container on Java11 selecting the RAM percentage"
echo "docker run --rm -m 1g openjdk:11.0 java -XX:MaxRAMPercentage=75 -XshowSettings:vm -version"
docker run --rm -m 1g openjdk:11.0 java -XX:MaxRAMPercentage=75 -XshowSettings:vm -version