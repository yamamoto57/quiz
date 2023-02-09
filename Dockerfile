FROM amazoncorretto:17 AS build
ADD . /work
WORKDIR /work
RUN chmod +x gradlew
RUN ./gradlew build

FROM amazoncorretto:17-alpine
COPY --from=build /work/build/libs/*.jar /usr/local/bin/quiz.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/bin/quiz.jar"]
