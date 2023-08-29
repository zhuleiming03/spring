FROM openjdk:8-jdk-alpine
WORKDIR usr
COPY netflix-ribbon-service.jar /usr/app01.jar
COPY netflix-ribbon-service.jar /usr/app02.jar
COPY netflix-ribbon-service.jar /usr/app03.jar
COPY netflix-ribbon-service.jar /usr/app04.jar
CMD java -jar /usr/app01.jar --spring.profiles.active=peer1 & java -jar /usr/app02.jar --spring.profiles.active=peer2 & java -jar /usr/app03.jar --spring.profiles.active=peer3 & java -jar /usr/app04.jar --spring.profiles.active=peer4