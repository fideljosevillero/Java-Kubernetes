# 2
#FROM openjdk:17.0.2
#WORKDIR /app
#COPY /target/student-service-0.0.1-SNAPSHOT.jar .
#EXPOSE 8001
#ENTRYPOINT ["java", "-jar", "student-service-0.0.1-SNAPSHOT.jar"]

# 2
#FROM openjdk:17.0.2-jdk
#
#WORKDIR /app/student
#
#COPY ./pom.xml /app
#COPY ./student-service/.mvn ./.mvn
#COPY ./student-service/mvnw .
#COPY ./student-service/pom.xml .
#
#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
##RUN ./mvnw dependency:go-offline
#
#COPY ./student-service/src ./src
#
#RUN ./mvnw clean package -DskipTests
#
#EXPOSE 8001
#
#ENTRYPOINT ["java", "-jar", "./target/student-service-0.0.1-SNAPSHOT.jar"]

# 3
FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/student

COPY ./pom.xml /app
COPY ./student-service/.mvn ./.mvn
COPY ./student-service/mvnw .
COPY ./student-service/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./student-service/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/student/target/student-service-0.0.1-SNAPSHOT.jar .

ENV PORT 8001

#EXPOSE 8001
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "student-service-0.0.1-SNAPSHOT.jar"]
#CMD ["java", "-jar", "student-service-0.0.1-SNAPSHOT.jar"]