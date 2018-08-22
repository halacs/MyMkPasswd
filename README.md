# MyMkPasswd

## Goal
This repository wants to show how you can replace mkpasswd with Java code.

## Build
```
mvn package -DdescriptorId=jar-with-dependencies
```

## Run
```
java -jar target/MyMkPasswd-1-jar-with-dependencies.jar 
```

## Example output
```
Our hash: $5$4CN9XOLytKUV4SNf$/M.PXcGZSGN20aBeJdylZBC82Tp/vel9I5xAjpSx6a9
Reference Hash: $5$4CN9XOLytKUV4SNf$/M.PXcGZSGN20aBeJdylZBC82Tp/vel9I5xAjpSx6a9
We are good! :)
```
