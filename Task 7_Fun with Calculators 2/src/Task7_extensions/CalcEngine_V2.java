package Task7_extensions;

import Postfix_Stack.Postfix;
import Postfix_Stack.StackException;
import Postfix_Stack.StackUnderflow;

public class CalcEngine_V2 extends Postfix_Multidigit {
	
	private String displayValue;
	public String getDisplayValue() {
		return displayValue;
	}
	public void ADDtoDisplayValue(String AddString) {	
		displayValue += AddString;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}	
	
	private double input;
	public String getinput() {
		if(input == 0)
			return "";
		else
			return Double.toString(input);
	}
	public void ADDtoinput(int AddNumber, int Base){
		if(!(input == 0 && AddNumber == 0)) {
			input = input*Base + AddNumber;
		}		
	}
	public void setinput(double input) {
		this.input = input;
	}	
	
	public String result;
	public CalcEngine_V2() {
		super();
		this.displayValue = "";
	}
	public String getTitle()
	{
		return "Cool Java Calculator";
	}
	/**
	* @return The author of this engine.
	*/
	public String getAuthor()
	{
		return "David J. Barnes and Michael Kolling";
	}
	/**
	* @return The version number of this engine.
	*/
	public String getVersion()
	{
	    return "Version 1.0";
	}
	public void clear() {
		displayValue = "";
		input = 0;
	}
	public void calcResult() throws StackUnderflow, StackException {
		result = Double.toString(evaluate(infixToPostfix(getDisplayValue())));
	}
	public String getResult() {
		return result;
	}
	
}


