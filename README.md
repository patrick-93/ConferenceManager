# Conference Manager
Small program to parse an input file (examples in the inputs directory). It reads the input file
and sorts the different talks people want to give at a conference.

## Requirements
* Internet (to download Gradle if not already installed)
* OpenJDK 11 (or compatible substitute)

## Usage
```shell
git clone https://github.com/patrick-93/ConferenceManager.git
cd ConferenceManager
```
For Linux/MacOS
```shell
./gradlew build
java -jar build/libs/ConferenceManager-1.0-SNAPSHOT.jar /path/to/inputfile
```

For Windows
```shell
.\gradlew.bat build
java -jar build/libs/ConferenceManager-1.0-SNAPSHOT.jar C:\Path\to\inputfile
```

Included are some sample inputs in ./ConferenceManager/inputs/

