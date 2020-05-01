For this project to run you will need the following Softwares:
    1. Java 8
    2. Maven Build Tool
    3. Command Prompt

Steps to Generate the geektrust.jar file:
    1. Unzip the compressed file.
    2. Open the command prompt.
    3. Change the directory to backend-geektrust folder in the command prompt.
    4. Run the follwoing 2 command:
        i)  mvn clean
        ii) mvn package
    5. geektrust.jar file is generated in backend-geektrust/target folder

To Run the jar file:
    1.  Open the command prompt.
    2. Change the directory to backend-geektrust folder in the command prompt.
    3. Run the following command:
        java -jar target/geektrust.jar input.txt

Note: The file 'input.txt' contains the input format, each line is a separte input