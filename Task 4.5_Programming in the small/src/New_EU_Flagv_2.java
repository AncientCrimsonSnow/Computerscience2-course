public class New_EU_Flagv_2 {
	
	private static int size =80;

	public static void main(String[] args) {
		String outputLine;
		
		
		for (int row = 1; row <= size; row++){      
		    outputLine = "";      
		    for (int column = 1; column <= size; column++){
		        outputLine = outputLine+determineCharacter (column, row);
		    }      
		    System.out.println (outputLine);
		}  
	}
	
	
		
	
	public static char determineCharacter (int column, int row) {
		//Border:
		//40/2 = 20	
		int BThick = size/20;
		//17/40 = 0.425	
		int Rec_Size = (int) Math.round((double)size*0.425);
		//40/5 = 8	Vporen = Vertical porentences
		int Vporen = size/8;
		//3/40 = 0.075	Hporen = Horizontal porentences
		int Hporen_Size = (int) Math.round((double)size*0.075);
		
		if(column <= BThick || column >= size+1- BThick || row <= BThick || row >= size+1-BThick )
			return '?';
		//rectangle Border:
		else if(column == Rec_Size && row < Rec_Size)
			return '|';	
		else if(column <= Rec_Size && row == Rec_Size)
			return '-';	
		//rectangle surface
		else if(column < Rec_Size && row < Rec_Size) {
			if((row+column)%3 == 0)
			return '/';
			else if((row+column+1)%3 == 0)
			return ' ';
			else
			return '=';
			
		}
		// the diagonale +
		else  if(row+column == size+1) 
			return '+';
		//the vertical porentences
		else if(row+column < size+1 && column%Vporen == 0)
			return '(';
		//the horizontal porentences
		else if(row+column > size+1 &&row % Hporen_Size == 0)
			return ')';
		return ' ';
	}
}
