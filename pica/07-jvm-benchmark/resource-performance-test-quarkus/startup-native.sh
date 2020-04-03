#!/bin/bash
docker build -f Dockerfile-native -t quarkus-performance-test-native:1.0 .
docker run -d --rm -p 8080:8080 quarkus-performance-test-native:1.0