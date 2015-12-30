package exercise3;

import java.util.Stack;

/**
 * Holds the history for the calculator. 
 * @author khodls
 *
 */
public class History implements HistoryInterface {
	
	
	//the stack holding the history in order. 
	public Stack<Double> hist = new Stack<Double>();
	
	//the stack used to implement flowing back through the history without losing data. 
	public Stack<Double> buffer  = new Stack<Double>();

	/**
	 * clear both stacks to start history from scratch
	 */
	public void clear(){
		hist.clear();
		buffer.clear();
	}
	
	/**
	 * returns the specified history item. Goes back the number of times specified by revNum
	 * @param index
	 * @return
	 */
	public double get(int index){
		
		double retVal;
		
		if(index == 0)
			retVal = hist.peek();
		else{
			
			//flow back through hist to get desired result
			for(int i = 0; i<index-1; i++){
				buffer.push(hist.pop());
			}
			
			retVal = hist.pop();
			buffer.push(retVal);
			
			//push everything back on to the hist stack that was removed. 
			for(int i = 0; i< index; i++){
				hist.push(buffer.pop());
			}
			
		}
		
		return retVal;
	}
	
	/**
	 * Return 1 if successful, 0 if unsucessful
	 * @param result
	 * @return
	 */
	public double add(double result){
		return hist.push(result);
	}
	
	/**
	 * removes the history at the specified index. 
	 */
	public double remove(int index){
		
		double retVal;
		
		for(int i = 0; i<index-1; i++){
			buffer.push(hist.pop());
		}
		
		retVal = hist.pop();
		
		//push everything back on to the hist stack that was removed. 
		for(int i = 0; i< index-1; i++){
			hist.push(buffer.pop());
		}
		
		return retVal;
	}
	
	/**
	 * Print all of the current history to the console. 
	 */
	public void printAll(){
		int index = 1; 
		while(!hist.isEmpty()){
			double cur = hist.pop();
			buffer.push(cur);
			System.out.println(index + ": " + cur);
			index++;
		}
		//reset history after printing. 
		while(!buffer.isEmpty()){
			hist.push(buffer.pop());		}
	}

}
