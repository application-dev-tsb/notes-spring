FROM adoptopenjdk/openjdk14:alpine-slim
ARG JAR_FILE
ADD ${JAR_FILE} app.jar

CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar app.jar