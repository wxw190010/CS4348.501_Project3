12/02/2024
11:25 AM

It is now Monday after Thanksgiving break.
I was hoping to get started on this at least a week ago, but that hasn't happened, due to both busy scheduling and procratination. 
My hope is to work on this project every day up until the due date to get it as solid as possible.

For this project, I am going to take the approach of working on the base features first. I want to establish the base features of indexing before I worry about modifying any files.
I'm also going to take the approach of building on other features like I did for the last project. Instead of worrying about having all indexes running at once, im going to work on having one working at once. 
I'm also going to try and keep up with the github as much as possible. I have never kept up with a github, but i'm going to make sure I at least have a commit at the end of each session.



12/07/2024
1:42 PM

I am programming this project in Java. I already have made a menu for the different options, I am going to upload that, then work on making the index file. 
I want to work on implementing functions into the program so that I don't have to work on patching everything together in the end. 



12/07/2024
11:55 PM

-Created menu with all options
-Created index file with all methods (needs implementation)
-Created RandomAccessFile implementation into IndexFile.java

I decided to have multiple files for this project so I could put different structures into their own classes and files. I think having this separation will make the code more readable and be more clean.
A lot of the work I did today was to research the implementation of the RandomAccessFiles and BTree. Tomorrow, I should be fine to implement the whole project.

One problem I had today was forgetting about static and nonstatic contexts. There were a couple instances where I wanted to have a Scanner or another method work on checking if IndexFile was empty, but kept getting the error. 
I eventually just put the check into an if statement in each of the menu's options that needed it.
I don't think its as clean as it could be, but it still works fine.

-EDIT: forgot to commit last night, so i'm doing it the next day. 12/08/2024, 1:36 PM



12/08/2024
1:42 PM

Today I am going to finish the project. I'm thankful for the extension, because otherwise I would have has to drop working on other assignments and studying for finals to finish this.
I am going to focus on the implementation of the BTree, as that is the most important aspect of the assignment that i'm missing right now.
Since I have been making sure that the program is functional each time I leave it, I should be able to integrate this into the program without much issue.
I think I will add this in a separate file, just as I did with the IndexFile.java.



12/08/2024
8:57 PM

Finished with the project.
Coding the index file and btree was tougher than I thought it would be. 
I'm good at visualizing things, so having to code a database as objects and concepts is a topic I need to work on.
I ended up making 3 files: a main.java file for driving the interaction, an IndexFile.java for running managing the files, and a BTree.java for holding the data and nodes.

I really wish I would have been more productive beforehand so I had more time to work on this. The code isn't perfect or fully "clean", but it performs all of the functions it needs to.
I think I also liked the github method better than the report method. It familiarizes the user with GitHub, and acts as a "diary" to keep track of projects. It can also keep different commits for reverting to past repos.
I didn't fully utilize GitHub in this project just because of my lack of experience with it, but if I had more experience, I would likely have used it better.
