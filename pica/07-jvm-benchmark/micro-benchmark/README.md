```shell script
mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-java-benchmark-archetype \
          -DgroupId=co.edu.javeriana.pica.jvm.performance \
          -DartifactId=micro-benchmark \
          -Dversion=1.0
```