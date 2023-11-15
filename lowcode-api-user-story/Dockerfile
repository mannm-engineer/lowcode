#Build stage
FROM --platform=linux/amd64 gradle:latest AS BUILD
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon --debug

# Package stage
FROM --platform=linux/amd64 openjdk:17-alpine

WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/lowcode-api-user-story-0.0.1-SNAPSHOT.jar

EXPOSE 8080
CMD ["java", "-jar", "lowcode-api-user-story-0.0.1-SNAPSHOT.jar"]
