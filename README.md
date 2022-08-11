# Kafka_Java_Instruments

This project is a java application example using Apache Kafka

#   To run kafka server using command:

$ docker-compose -f docker/docker-compose-single-broker.yml up

kafka docker files origin:
https://github.com/wurstmeister/kafka-docker

#  Kafka-project console app build and run:
command in application root folder:

$ mvn clean install

in folder /target

$ java -jar kafka-project-1.0-SNAPSHOT-jar-with-dependencies.jar -c

Kafka producer mode:

$ java -jar kafka-project-1.0-SNAPSHOT-jar-with-dependencies.jar -p
