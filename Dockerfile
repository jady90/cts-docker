FROM openjdk:8u191-jre-alpine3.8

# Workspace
WORKDIR /usr/share/digital

# Add .jar under target from host
# into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# Add any other dependency here in future

# Add Suite files
ADD testng.xml testng.xml

# HUB_HOST

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG testng.xml