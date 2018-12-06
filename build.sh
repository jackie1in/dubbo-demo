#!/usr/bin/env bash
# 打包
mvn clean package -Dmaven.test.skip=true
# 打包docker镜像
docker build --build-arg \
JAR_FILE=./dubbo_provider/target/dubbo_provider-0.0.1-SNAPSHOT.jar . -t dubbo_provider:latest

# 打包docker镜像
docker build --build-arg \
JAR_FILE=./dubbo_consumer/target/dubbo_consumer-0.0.1-SNAPSHOT.jar . -t dubbo_consumer:latest