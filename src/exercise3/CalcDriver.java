package exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class for this calculator, stores the history and interacts with the user. 
 * @author khodls
 *
 */
public class CalcDriver {

	/**
	 * Main, simply calls init to begin the program
	 * @param args
	 */
	public static void main(String[] args){
		CalcDriver driver = new CalcDriver();
		driver.init();
	}
	
	//the two interfaces for Calculaor and the History
	CalculatorInterface calc;
	HistoryInterface hist;
	
	
	/**
	 * Gets all of the data from the user and instantiates Calculator and History objects. 
	 * calls appropriate functions to continue the program
	 */
	private void init(){
		calc = new Calculator();
		hist = new History();
		
		System.out.println("To use this calculator Enter a operation followed by a list of numbers "
				+ "\n Numbers need to be separated by a single space"); // To add a second list separate list by <list><space><colon><space><list>, requred for additional operation. 
		
		interact();
	}
	
	/**
	 * Obtains input from the user and performs correct operation
	 * loops until the user specifies they want to exit. 
	 */
	private void interact(){
		
		boolean done = false;
		
		while(!done){
			System.out.println("\nEnter Operation and Numbers\n");
			
			Scanner scan = new Scanner(System.in);
			
			List<Integer> firstEnt = null;
			String operation = null; 
			
			try{
				String input = scan.nextLine();
				firstEnt = parseList(input);
				operation = parseOp(input);
			}catch(Exception e){ //TODO: change this to a more appropriate exception instead of generic
				System.out.println("FOUND AN EXCEPTION");
			}
			
			//if operation doesn't require calculations complete here. 
			if(operation.equals("hist")){
				hist.printAll();
			}
			else if(operation.equals("clear")){
				hist.clear();
				System.out.println("Cleared History\n");
			}
			else{
				System.out.println("Result was: " + performOp(operation, firstEnt) + "\n");
			}
			
			//get input for user to exit or not
			System.out.println("Enter 0 to Exit, enter any key to continue\n");
			
			//close scanner and exit program
			if(scan.nextLine().equals("0")){
				done = true;
				scan.close();
			}
		}
	}
	
	/**
	 * Creates a list out of the input string. Numbers separated by spaces. 
	 * @param input
	 * @return
	 */
	private List<Integer> parseList(String input){
		
		List<Integer> list = new ArrayList<Integer>();
		
		String[] nums = input.split(" ");
		
		for(int i = 1; i<nums.length; i++){
			list.add(Integer.parseInt(nums[i]));
		}
		
		return list;
	}
	
	/**
	 * parse the operation from the input string. 
	 * @param input
	 * @return
	 */
	private String parseOp(String input){
		//split on spaces and return first element
		return input.split((" "))[0];
	}
	
	/**
	 * Parses and performs the operation specified by the user. 
	 * 
	 *	add
	 *	sub
	 *	mul
	 *	div
	 *	hist
	 *	clear
	 *	diffsum
	 * @param input the string with the op command
	 * @return the value of the operation. 
	 */
	private int performOp(String input, List<Integer> list){
		
		int result = 0; 
		boolean res = true;
		
		if(input.equals("add")){
			result = calc.add(list);
		}
		else if(input.equals("sub")){
			result = calc.subtract(list);
		}	
		else if(input.equals("mul")){
			result = calc.product(list);
		}
		else if(input.equals("div")){
			result = calc.quotient(list);
		}
		else{
			res = false;
			//throw exception if the input command is not recognized. 
			throw new UnsupportedOperationException("Unable to perform the operation due to invalid input by the user");
		}
		
		//add the result to history
		if(res){
			hist.add(result);
		}
		
		return result;
	}
	
	
	/**
	 * Used for DiffSum only, this is due to the operation excepting two lists instead of the usual single list
	 * @param input
	 * @param one
	 * @param two
	 * @return the value of the diffsum operation. 
	 */
//	private double performOp(String input, List<Integer> one, List<Integer> two){
//		//TODO: implement a way to reach this by parsing the input string and checking if a colon and two valid lists are present. 
//	}
	
	
	/**
	 * Checks if the input from the user is a valid entry. 
	 * @param input
	 * @return
	 */
//	private double checkOp(String input){
//		
//	}
}
