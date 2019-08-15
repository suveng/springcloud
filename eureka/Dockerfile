FROM  s-repo.ttyuyin.com/library/openjdk8-openj9:alpine-slim

ADD target/*.jar eureka.jar

EXPOSE 20201

ENTRYPOINT ["java","-jar","/eureka.jar"]

