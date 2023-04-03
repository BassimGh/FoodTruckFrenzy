
# Food Truck Frenzy

Food Truck Frenzy is a 2D maze game created for CMPT 276 Spring 2023 at SFU. In this game you control a food truck to collect ingredients and recipes while avoiding the cops, speed traps, and pot holes. The game is built using Java, and uses Maven and JUnit for building and testing.

# Prerequisites

To build, run, and test Food Truck Frenzy you need to have the following installed on your computer:

    1. Java Development Kit (JDK) version 1.8 or higher
    2. Apache Maven version 3.9.0 or higher

# Building the project

To build the project, navigate to the root directory of the project (where the 'pom.xml' file is located) and run the following command:

```bash
  mvn clean install
```

This command will clean any previous build artifacts, compile the source code, run the tests, and package the compiled code into a JAR file. The JAR file will be located in the target folder.

# Running the game

After building, you ca run the game either by opening the JAR file located in the target folder or by running the following command: 

```bash
  java -jar target/foodtruckfrenzy-1.0-SNAPSHOT.jar
```

# Testing

The project includes JUnit tests which can be run using the following command:

```bash
  mvn test
```

# Authors
 - Kyle Deliyannides
 - Bassim Ghasemzadeh
 - Patrick Shaw
 - Christopher Pinca

