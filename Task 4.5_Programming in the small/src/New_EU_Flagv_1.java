public class New_EU_Flagv_1 {

	public static void main(String[] args) {
		String outputLine;
		
		
		for (int row = 1; row <= 40; row++){      
		    outputLine = "";      
		    for (int column = 1; column <= 40; column++){
		        outputLine = outputLine+determineCharacter (column, row);
		    }      
		    System.out.println (outputLine);
		}  
	}
	
	
		
	
	public static char determineCharacter (int column, int row) {
		//Border:
		int BThick = 2;
		if(column <= BThick || column >= 41- BThick || row <= BThick || row >= 41-BThick ) 
			return '?';
				
		//rectangle Border:
		else if(column == 17 && row < 17)
			return '|';		
		else if(column <= 17 && row == 17)
			return '-';		
		//rectangle surface
		else if(column < 17 && row < 17) {
			if((row+column)%3 == 0)
			return '/';
			else if((row+column+1)%3 == 0)
			return ' ';
			else
			return '=';			
		}	
		// the diagonale +
		else  if(row+column == 41) 
			return '+';		
		//the vertical porentences
		else if(row+column < 41 && column%5 == 0) 
			return '(';
		//the horizontal porentences
		else if(row+column > 41 &&row % 3 == 0)
			return ')';
		return ' ';
	}
}