# Food Truck Frenzy - A Deliciously Addictive 2D Maze Adventure!

Welcome to "Food Truck Frenzy," an exciting 2D maze adventure where you become a food truck chef on a mission to collect ingredients and recipes while avoiding obstacles and outsmarting the police! Test your skills as you navigate a maze of houses and roads to reach the endpoint after collecting all the ingredients and create the ultimate food truck experience. Will you rise to the challenge and claim victory in this deliciously addictive game?

How to Play:

    1. Navigate your food truck through a 2D maze filled with houses and roads by using the WASD keys.
    2. Collect ingredients scattered around the maze. Each ingredient is worth 100 points.
    3. Optional: Look out for bonus recipes which are worth 200 points. While not necessary to win the game, they can help you rack up an impressive high score!
    4. Beware of speed traps and potholes as you make your way through the maze. Getting caught in a speed trap will cost you 196 points, while hitting a pothole will result in a loss of 286 points.
    5. Keep an eye on the clock - you are timed, and the faster you complete the game, the better your bragging rights!
    6. Watch out for the police! They are following your every move and if they catch up to you, it's game over.
    7. Once you have collected all the ingredients, make your way to the endpoint in the bottom right corner of the maze to win.

Do you have what it takes to become the ultimate food truck chef in "Food Truck Frenzy"? Put your skills to the test and see if you can emerge victorious in this thrilling 2D maze adventure! Happy cooking and good luck!

# Prerequisites

To build, run, and test Food Truck Frenzy you need to have the following setup on your computer:

    1. Java Development Kit (JDK) version 11 or higher
    2. Apache Maven version 3.9.0 or higher
    3. Ensure JAVA_HOME environment variable points to the jdk folder
    4. Ensure PATH environment variable points to the jdk/bin folder

# Building the project

To build the project,

    1. Clone the git project onto your computer.
    2. Navigate to the "foodtruckfrenzy" folder (where the 'pom.xml' file is located)
    3. Run the following command:

```bash
  mvn clean package
```

After following the above 3 steps this will clean any previous build artifacts, compile the source code, run the tests, and package the compiled code into a JAR file. The JAR file will be located in the target folder.

# Running the game

After building, you can run the game with the following command (stay in the same "foodtruckfrenzy" directory): 

```bash
  java -jar target/foodtruckfrenzy-1.0-SNAPSHOT.jar
```

# Testing

The project includes JUnit tests which can be run using the following command:

```bash
  mvn test
```

To generate coverage reports with JaCoCo run the following command:

```bash
  mvn jacoco:prepare-agent test jacoco:report
```

The coverage report will output to:

```bash
  target/site/jacoco/index.html
```
Open the index.html file in your web browser to view.

# JavaDocs

The project includes JavaDocs which can be automatically generated using the following command:

```bash
  mvn javadoc:javadoc
```

The JavaDocs will output to:

```bash
  target/site/apidocs/index.html
```
Open the index.html file in your web browser to view.

# Authors
 - Kyle Deliyannides
 - Bassim Ghasemzadeh
 - Patrick Shaw
 - Christopher Pinca

