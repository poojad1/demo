FROM gradle:4.6-jdk8-alpine as compile
COPY . /home/source/java
WORKDIR /home/source/java
# Default gradle user is `gradle`. We need to add permission on working directory for gradle to build.
USER root
RUN chown -R gradle /home/source/java
USER gradle
RUN gradle clean bootJar


FROM openjdk:8-jdk-alpine
ENV PORT 8080
EXPOSE 8080
COPY --from=compile "/home/source/java/build/libs/*.jar" /opt/app.jar
WORKDIR /opt
CMD ["java", "-jar", "app.jar"]
