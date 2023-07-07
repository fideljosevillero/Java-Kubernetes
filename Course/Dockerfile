# 2
#FROM openjdk:17.0.2
#WORKDIR /app
#COPY /target/Course-0.0.1-SNAPSHOT.jar .
#EXPOSE 8001
#ENTRYPOINT ["java", "-jar", "Course-0.0.1-SNAPSHOT.jar"]

# 2
FROM openjdk:17.0.2-jdk

WORKDIR /app/Course

COPY ./pom.xml /app
COPY ./Course/.mvn ./.mvn
COPY ./Course/mvnw .
COPY ./Course/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./Course/src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "./target/Course-0.0.1-SNAPSHOT.jar"]

# 3
#FROM openjdk:17-jdk-alpine as builder
#
#WORKDIR /app/Course
#
#COPY ./pom.xml /app
#COPY ./Course/.mvn ./.mvn
#COPY ./Course/mvnw .
#COPY ./Course/pom.xml .
#
#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
##RUN ./mvnw dependency:go-offline
#COPY ./Course/src ./src
#
#RUN ./mvnw clean package -DskipTests
#
#FROM openjdk:17-jdk-alpine
#
#WORKDIR /app
#
#COPY --from=builder /app/student/target/Course-0.0.1-SNAPSHOT.jar .
#EXPOSE 8001
#
#ENTRYPOINT ["java", "-jar", "Course-0.0.1-SNAPSHOT.jar"]
##CMD ["java", "-jar", "Course-0.0.1-SNAPSHOT.jar"]