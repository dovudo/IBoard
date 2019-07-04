FROM gradle:jdk12
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN gradle clean build
CMD ["java", "-jar", "./build/libs/IBoard-0.0.1-SNAPSHOT.jar"]
