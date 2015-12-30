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
	
	//the two interfaces we need. 
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
				+ "\n Numbers need to be separated by a single space");
		
		System.out.println("\nEnter Operation and Numbers");
		
		Scanner scan = new Scanner(System.in);
		
		List<Integer> firstEnt;
		String operation; 
		
		try{
			String input = scan.nextLine();
			firstEnt = parseList(input);
			operation = parseOp(input);
		}catch(Exception e){
			System.out.println("FOUND AN EXCEPTION");
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
	 * @return
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
		else if(input.equals("hist")){
			res = false;
			hist.printAll();
		}
		else if(input.equals("clear")){
			res = false;
			hist.clear();
		}
		else{
			//we should never reach this loop
			res = false;
			System.out.println("Something went wrong, try again");
		}
		
		//add the result to history
		if(res){
			hist.add(result);
			return result;
		}
		else
			return -1;
	}
	
	private double performOp(String input, List<Integer> one, List<Integer> two){
		
	}
	
	
	/**
	 * Checks if the input from the user is a valid entry. 
	 * @param input
	 * @return
	 */
	private double checkOp(String input){
		
	}
}
