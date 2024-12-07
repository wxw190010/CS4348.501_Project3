import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		System.out.println("MENU");
		System.out.println("create, open, insert, search, load, print, extract, quit,");
		System.out.println("INSERT COMMAND: ");
		
		while(true){
		    String input = sc.nextLine();
		    
		    switch(input){
		        case "1":
		            
		            break;
		        case "2":
		            break;
		        default:
		            System.out.println("Input not recognized. Please try again.");
		    }
		}
	}
}
