This repo contains 5 files: 2 .md files for tracking project progress and info, and 3 java files

main.java:
This is the main driver file for the program, which interacts with the user to perform its actions.
It has:
    -create:
        -makes a new file
    -open:
        -opens a file for interaction
    -insert:
        -puts a key/value pair into an open file
    -search
        -searches open file for values based on key
    -load
        -takes data from another file
    -print
        -prints all key/value pairs in an open file
    -extract
        -puts its data into another file
    -quit
        -exit program

main.java is the driver program, and prompts IndexFile.java for each function

IndexFile.java:
This file is used to track and manage the files that are made. This is where the inputs from the user is brought to and executed.

BTree.java:
This file makes and manages the btrees and its nodes. 

TO RUN:
-navigate to the directory of the files
-run "javac Main.java IndexFile.java BTree.java" to compile program
-run "java Main" to execute program
