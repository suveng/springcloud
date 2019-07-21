#!/usr/bin/env bash
cd eureka/target
nohup java -jar *.jar > eureka.log &
cd ../../gateway/target
nohup java -jar *.jar > gateway.log &
cd ../../service/user/target
nohup java -jar *.jar > user.log &
echo '完成'

