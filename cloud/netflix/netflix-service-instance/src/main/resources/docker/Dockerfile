FROM openjdk:8-jdk-alpine
WORKDIR usr
COPY netflix-service-instance.jar /usr/app01.jar
COPY netflix-service-instance.jar /usr/app02.jar
COPY netflix-service-instance.jar /usr/app03.jar
CMD java -jar /usr/app01.jar --spring.profiles.active=peer1 & java -jar /usr/app02.jar --spring.profiles.active=peer2 & java -jar /usr/app03.jar --spring.profiles.active=peer3