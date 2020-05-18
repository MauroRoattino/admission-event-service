FROM openjdk:11-jre-slim 

ARG ADMISSION-EVENT-SERVICE-VERSION

# We are going to work at /opt 

COPY target/admission-event-service-${ADMISSION-EVENT-SERVICE-VERSION}.jar /opt/admission-event-service/admission-event-service.jar

WORKDIR /opt/admission-event-service
ENTRYPOINT ["java", "-Djsse.enableSNIExtension=false", "-jar", "admission-event-service.jar"]