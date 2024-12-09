import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IndexFile{
    
    //Initialize variables
    private String fileName;
    private RandomAccessFile file;
    private BTree btree;
    public static final int BLOCK_SIZE = 512;
    public static final String MAGIC_NUMBER = "4337PRJ3";

    //Constructor for creating the file and loading the BTree
    public IndexFile(String fileName){
        try{
            this.fileName = fileName;
            this.file = new RandomAccessFile(fileName, "rw");
            this.btree = new BTree();
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
        
        //Cancel if overwrite response is not yes
        if (file.exists()){
            System.out.print("File exists. Overwrite? (yes/no): ");
            if (!sc.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("\nCreate aborted.");
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
        
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")){
            byte[] magicNumber = new byte[8];
            raf.read(magicNumber);
            
            //Validate magic number
            if(!new String(magicNumber).equals(MAGIC_NUMBER)){
                System.out.println("Invalid file format.");
                return null;
            }
        }
        catch (IOException e){
            System.out.println("Error opening file: " + e.getMessage());
            return null;
        }
        return new IndexFile(fileName);
    }

    //Insert a key-value pair into the B-Tree
    public void insert(Scanner sc){
        System.out.print("Enter key: ");
        int key = sc.nextInt();
        System.out.print("Enter value: ");
        int value = sc.nextInt();
        sc.nextLine();
        
        try{
            btree.insert(key, value);
            System.out.println("Inserted key " + key + " with value " + value);
        } 
        catch(Exception e){
            System.out.println("Failed to insert key: " + e.getMessage());
        }
    }

    //Search for a key in the B-Tree
    public void search(Scanner sc){
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();
        sc.nextLine();
        
        try{
            int value = btree.search(key);
            if(value != -1){
                System.out.println("Key " + key + " found with value " + value);
            } 
            else{
                System.out.println("Key " + key + " not found.");
            }
        } 
        catch(Exception e){
            System.out.println("Search failed: " + e.getMessage());
        }
    }

    //Load key-value pairs from an external file into the B-Tree
    public void load(Scanner sc){
        
        //Get file name from user
        System.out.print("Enter file name to load from: ");
        String fileName = sc.nextLine();
        
        //Load values
        try(Scanner fileScanner = new Scanner(new File(fileName))){
            while (fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                int key = Integer.parseInt(parts[0].trim());
                int value = Integer.parseInt(parts[1].trim());
                btree.insert(key, value);
            }
            System.out.println("Successfully loaded data from " + fileName);
        } 
        catch (IOException | NumberFormatException e){
            System.out.println("Failed to load file: " + e.getMessage());
        }
    }

    //Print all key-value pairs in the B-Tree
    public void print(){
        try{
            btree.print();
        } 
        catch (Exception e){
            System.out.println("Failed to print B-Tree: " + e.getMessage());
        }
    }

    //Extract all key-value pairs from the B-Tree and write to an external file
    public void extract(Scanner sc){
        System.out.print("Enter file name to extract to: ");
        String fileName = sc.nextLine();

        try(RandomAccessFile extractFile = new RandomAccessFile(fileName, "rw")){
            extractFile.setLength(0);
            for(String record : btree.extractAll()){
                extractFile.writeBytes(record + "\n");
            }
            System.out.println("Data successfully extracted to " + fileName);
        } 
        catch(IOException e){
            System.out.println("Failed to extract data: " + e.getMessage());
        }
    }
}
