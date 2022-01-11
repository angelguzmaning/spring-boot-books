FROM openjdk:17-jdk-alpine
EXPOSE 8090
WORKDIR /usr/src/app
COPY . /usr/src/app
CMD ["./mvnw","spring-boot:run"]