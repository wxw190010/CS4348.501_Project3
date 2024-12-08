import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IndexFile{
    private String fileName;
    private RandomAccessFile file;

    public static final int BLOCK_SIZE = 512;
    public static final String MAGIC_NUMBER = "4337PRJ3";

    //Constructor for opening the file and loading the B-Tree
    public IndexFile(String fileName){
        try{
            this.fileName = fileName;
            this.file = new RandomAccessFile(fileName, "rw");
        } 
        catch (IOException e){
            System.out.println("Failed to open file: " + e.getMessage());
        }
    }

    //Create a new index file
    public static IndexFile create(Scanner sc){
        System.out.print("\nFile Name: ");        
        String fileName = sc.nextLine();
        File file = new File(fileName);
        
        //Cancel if overwrite is not yes
        if (file.exists()){
            System.out.print("File exists. Overwrite? (yes/no): ");
            if (!sc.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("Create aborted.");
                return null;
            }
        }
        
        //Create RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            raf.setLength(BLOCK_SIZE);
            raf.writeBytes(MAGIC_NUMBER);
            raf.writeLong(0);   //Root block ID
            raf.writeLong(1);   //Next block ID
        } 
        catch (IOException e){
            System.out.println("Error creating file: " + e.getMessage());
        }
        return new IndexFile(fileName);
    }

    //Open an existing index file
    public static IndexFile open(Scanner sc){
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        return null;
    }

    //Insert a key-value pair into the B-Tree
    public void insert(Scanner sc){
        System.out.print("Enter key: ");
        int key = sc.nextInt();
        System.out.print("Enter value: ");
        int value = sc.nextInt();
        sc.nextLine();
        
        //Make BTree insertion
    }

    //Search for a key in the B-Tree
    public void search(Scanner sc){
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();
        sc.nextLine();

        //Make search method
    }

    //Load key-value pairs from an external file into the B-Tree
    public void load(Scanner sc){
        System.out.print("Enter file name to load from: ");
        String fileName = sc.nextLine();

        //Make load method
    }

    //Print all key-value pairs in the B-Tree
    public void print(){
        try {
            //bTree.print();
        } 
        catch (Exception e){
            System.out.println("Failed to print B-Tree: " + e.getMessage());
        }
    }

    //Extract all key-value pairs from the B-Tree and write to an external file
    public void extract(Scanner sc){
        System.out.print("Enter file name to extract to: ");
        String fileName = sc.nextLine();

        //Create extraction from BTree
    }
}
