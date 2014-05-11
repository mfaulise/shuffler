shuffler
========

To build this project run:
mvn clean compile assembly:single

To test run:
mvn test

Once build the program can be run like this:
java -jar target\shuffle-0.0.1-SNAPSHOT-jar-with-dependencies.jar src\test\resources\simple_input.txt src\test\resources\commands\simple.txt
