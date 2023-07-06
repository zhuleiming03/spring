FROM openjdk:8-jdk-alpine
WORKDIR usr
COPY eureka-service-cluster.jar /usr/app01.jar
COPY eureka-service-cluster.jar /usr/app02.jar
CMD java -jar /usr/app01.jar --spring.profiles.active=peer1 & java -jar /usr/app02.jar --spring.profiles.active=peer2