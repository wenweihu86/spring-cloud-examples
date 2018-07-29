#!/usr/bin/env bash

mvn clean package -DskipTests

nohup java -Dspring.profiles.active=peer1 -jar eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar &
nohup java -Dspring.profiles.active=peer2 -jar eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar &

nohup java -Dspring.profiles.active=peer1 -jar config-server/target/config-server-0.0.1-SNAPSHOT.jar &
nohup java -Dspring.profiles.active=peer2 -jar config-server/target/config-server-0.0.1-SNAPSHOT.jar &

nohup java -jar inventory-server/target/inventory-server-0.0.1-SNAPSHOT.jar &

nohup java -jar order-server/target/order-server-0.0.1-SNAPSHOT.jar &

nohup java -jar gateway/target/gateway-0.0.1-SNAPSHOT.jar &
