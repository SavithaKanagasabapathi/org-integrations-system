Download Apache Kafka- https://kafka.apache.org/documentation/#quickstart
- Get Started - QuickStart - Download tar file and follow instructions to start in localhost:9092
- For mac - .sh files to run in Terminal
- For Windows - .bat files in bin/windows to run in cmd
- Download Java 17+
- In cmd, check java -version - it should be 17 or higher

1.Change Logs Directory Path in kafka-config-server.properties,
From log.dirs=/tmp/kraft-combined-logs 
To log.dirs=C:/kafka_2.13-4.1.0/kraft-combined-logs
Change \ to /

2.To generate UUID,
- Paste the kafka folder in c drive (do not place in sub folders) - to avoid error : "Input line is too long"
- Add kafka bin path to path in env 
- Go to C:\kafka\bin\windows
- Open cmd preferablly. Not powershell
```
kafka-storage.bat random-uuid
```
Ignore this Error - main ERROR Reconfiguration failed: No configuration found for '2c7b84de' at 'null' in 'null'

3.To set UUID to a variable,
```
set KAFKA_CLUSTER_ID=clusterId
```

4.To format log directories,
```
kafka-storage.bat format --standalone -t clusterId -c ../../config/server.properties
```

5.To start kafka server,
```
kafka-server-start.bat ../../config/server.properties
```

6.To create topic,
```
kafka-topics.bat --create --topic topicName --bootstrap-server localhost:9092
```

7.To produce message on topic,
```
kafka-console-producer.bat --topic topicName --bootstrap-server localhost:9092
```

8.To consume message on topic,
```
kafka-console-consumer.bat --topic topicName --from-beginning --bootstrap-server localhost:9092
```
