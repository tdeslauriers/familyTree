FROM openjdk:14-alpine
COPY build/libs/familyTree-*-all.jar familyTree.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "familyTree.jar"]