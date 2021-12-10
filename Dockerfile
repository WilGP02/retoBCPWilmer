FROM openjdk:11
VOLUME /tmp
EXPOSE 8090
ADD ./target/exchangeCurrency-0.0.1-SNAPSHOT.jar exchange-currency.jar
ENTRYPOINT ["java","-jar","/exchange-currency.jar"]
