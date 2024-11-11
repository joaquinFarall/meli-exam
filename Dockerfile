FROM amazoncorretto:17-alpine-jdk

COPY target/MeLiExam-0.0.1-SNAPSHOT.jar meli_exam.jar

ENTRYPOINT ["java", "-jar", "/meli_exam.jar"]