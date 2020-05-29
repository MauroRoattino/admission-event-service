FROM openjdk:11-jre-slim 

ARG ADMISSION_EVENT_SERVICE_VERSION

# We are going to work at /opt 

COPY target/admission-event-service-${ADMISSION_EVENT_SERVICE_VERSION}.jar /opt/admission-event-service/admission-event-service.jar

WORKDIR /opt/admission-event-service
ENTRYPOINT ["java", "-Duser.timezone=America/Buenos_Aires", "-Djsse.enableSNIExtension=false", "-jar", "admission-event-service.jar"]