package Task7_extensions;


public class Usefull_Methods {

	public static String deleteSpaces(String s) {
		
		return s.replace("\\s+", "");
	}
	
	public static boolean StringisNumber(String number) {
		
		if(number.startsWith("."))
			return false;
					
		char[] cNumber = number.toCharArray();
		
		int i = 0;
		try {
			if(cNumber[0] == '-' && CharisNumberHEX(cNumber[1]))
				i = 1;
		}
		catch (Exception e) {}
		
		for (; i < cNumber.length ; i++) {
			if(!(CharisNumberHEX(cNumber[i]) || cNumber[i] == '.'))
				return false;
		}
		return true;
	}
	public static boolean CharisNumberHEX(char number) {
		if( number > 47 && number < 58 ||
			number > 64 && number < 71)
			return true;
		else
			return false;
	}
	public static String setSpacesEachToken(String S) {
		S = deleteSpaces(S);
		char [] S_Array = S.toCharArray();
		
		//If the input String has 2 dots in a row its wrong Tested here.
		int count = 0;
		for(char E : S_Array) {
			if(E == '.')
				count++;
			else
				count = 0;
			if(count >1)
				return null;	
		}
	
		String token = "";
		S = "";
		for(int i = 0; i< S_Array.length;i++) {
			token = "";
			
			//negativ numbers
			if(	S_Array[i] == '-') {
				token += S_Array[i];
				
				try {
					//if its an neg followed by a number
					if(CharisNumberHEX(S_Array[i+1])){
						//If - is the first digit:
						if(i==0) {	
							while(CharisNumberHEX(S_Array[i+1]) || S_Array[i+1] == '.') {
								i++;
								token += S_Array[i];	
							}
						}
						else {
							//if the - is not at the first digit
							if(CharisOperator(S_Array[i-1])) {		
								while(CharisNumberHEX(S_Array[i+1]) || S_Array[i+1] == '.') {
									i++;
									token += S_Array[i];						
								}
							}	
						}
					}
					//if the neg is followed by an (
					else if(S_Array[i+1] == '(') {
						i++;
						token += S_Array[i];
					}
				}
				catch(Exception e) {}
				S += token + " ";
				continue;
			}
			//operatoren
			if( i > 0  && CharisOperator(S_Array[i])) {
				token += S_Array[i];
				S += token + " ";
				continue;
			}
			//positive Zahlen
			else if(CharisNumberHEX(S_Array[i])){
				token = Character.toString(S_Array[i]);
				try {
					while(CharisNumberHEX(S_Array[i+1]) || S_Array[i+1] == '.') {
						i++;
						token += S_Array[i];	
					}
				}
				catch(Exception e) {}
				S += token + " ";
				continue;
			}
			else {
				//If input is wrong.
				return null;
			}
		}
		
		
		return S.stripTrailing();
	}
	public static boolean CharisToken(char c) {
		if(CharisNumberHEX(c) || CharisOperator(c)) {
			return true;
		}
		else 
			return false;
	}
	public static boolean CharisOperator(char c) {
		if( c == '+' ||
			c == '-' ||
			c == 'x' ||
			c == '*' ||
			c == '/' ||
			c == '^' ||
			c == '(' ||
			c == ')' ||
			c == '=') 
			return true;
		else
			return false;
	}
}

