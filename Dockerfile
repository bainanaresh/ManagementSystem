FROM openjdk:17
WORKDIR /appContainer
COPY . target/ManagementSystem.jar /appContainer/
EXPOSE 9191
CMD ["java","-jar","ManagementSystem.jar"]