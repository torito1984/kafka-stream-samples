#/usr/bin/bash

java -cp target/kafka-stream-example-0.0.1.jar org.kafka.stream.example.launch.WordCountDemo --topic ${1} --job ${2}