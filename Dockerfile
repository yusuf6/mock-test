FROM azul/zulu-openjdk:18
COPY target/mock-test.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mock-test.jar"]