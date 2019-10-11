#!/usr/bin/env bash

mvn clean install -DskipTests

nohup java -Dspring.profiles.active=peer1 -jar eureka-server/target/eureka-server.jar &
nohup java -Dspring.profiles.active=peer2 -jar eureka-server/target/eureka-server.jar &

nohup java -Dspring.profiles.active=peer1 -jar config-server/target/config-server.jar &
nohup java -Dspring.profiles.active=peer2 -jar config-server/target/config-server.jar &

nohup java -jar inventory-server/target/inventory-server.jar &

nohup java -jar order-server/target/order-server.jar &

nohup java -jar gateway/target/gateway.jar &
