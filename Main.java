import java.util.Scanner;

public class Main{
    
    private static boolean checkIfIndexNull(IndexFile indexFile){
        if(indexFile == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    private static void indexEmptyResponse(){
        System.out.println("Error: no file is open. Please ty again.\n");
    }
    
	public static void main(String[] args) {
	    boolean quit = false;
	    Scanner sc = new Scanner(System.in);
	    IndexFile indexFile = null;

		while(quit == false){
		    //Prompt user for command
		    System.out.println("MENU:");
	    	System.out.println("create, open, insert, search, load, print, extract, quit");
	    	System.out.print("INSERT COMMAND: ");
	    	
	    	//Get user input for menu
		    String input = sc.nextLine();
		    
		    switch(input.trim().toUpperCase()){
		        //Create new index file
		        case "CREATE":
		            indexFile = IndexFile.create(sc);
		            break;
		            
		        //Open index file
		        case "OPEN":
		            indexFile = IndexFile.open(sc);
		            break;
		            
		        //Insert key/value pair into index file      
		        case "INSERT":
		            if(checkIfIndexNull(indexFile) == true){
		                indexEmptyResponse();
		                break;
		            }
		            else{
		                indexFile.insert(sc);
		            }
		            break;
		        
		        //Search index file for key/value pair      
		        case "SEARCH":
		            if(checkIfIndexNull(indexFile) == true){
		                indexEmptyResponse();
		                break;
		            }
		            else{
		                indexFile.search(sc);
		            }
		            break;
		        
		        //Load index file fore reading      
		        case "LOAD":
		            if(checkIfIndexNull(indexFile) == true){
		                indexEmptyResponse();
		                break;
		            }
		            else{
		                indexFile.load(sc);
		            }
		            break;
		            
		        //Print all key/value pairs in index file      
		        case "PRINT":
		            if(checkIfIndexNull(indexFile) == true){
		                indexEmptyResponse();
		                break;
		            }
		            else{
		                indexFile.print();
		            }
		            break;
		            
		        //Save key/value pairs to a file     
		        case "EXTRACT":
		            if(checkIfIndexNull(indexFile) == true){
		                indexEmptyResponse();
		                break;
		            }
		            else{
		                indexFile.extract(sc);
		            }
		            break;
		            
		        //Quit program
		        case "QUIT":
		            quit = true;
		            break; 
		            
		        //Default case: try again      
		        default:
		            System.out.println("\nInput not recognized. Please try again.\n");
		    }
		}
	}
}
