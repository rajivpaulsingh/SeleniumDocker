FROM openjdk:8u191-jre-alpine3.8

# Workspace
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image
# ADD anything else in case of any other depenedencies like .csv/ .json/ .xls
ADD target/selenium-docker.jar          selenium-coker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs

# ADD suite fileds
ADD book-flight-module.xml              book-flight-module.xml
ADD search-module.xml                   search-module.xml

# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT - java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE